package com.sandboxol.blockmango;

import android.os.Build;
import android.os.RecoverySystem;
import android.util.Log;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.MD5Util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ZipUtil {
    private static String TAG = "ZipUtil";
    private int curMergeCount;
    private RecoverySystem.ProgressListener listener;
    private String pathName;
    private String zipFileName;
    private int oldProgress = 0;
    private Map<String, Boolean> mapIgnore = new HashMap();
    private int curCount = 0;
    private int totalCount = 0;

    public enum ZipStatus {
        FAILURE,
        MERGE_SUCCESS,
        SUCCESS
    }

    public ZipUtil(String str, String str2) {
        this.pathName = str2;
        this.zipFileName = str;
    }

    private Map<String, String> getGameResFilesMd5Reg(InputStream inputStream) throws Exception {
        HashMap map = new HashMap();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                inputStreamReader.close();
                return map;
            }
            String[] strArrSplit = line.split("\\*");
            map.put(strArrSplit[1], strArrSplit[0].replace(" ", ""));
        }
    }

    private Map<String, Boolean> needChangeFiles(ZipFile zipFile, ZipFile zipFile2) throws Exception {
        Map<String, String> gameResFilesMd5Reg = getGameResFilesMd5Reg(zipFile2.getInputStream(zipFile2.getEntry("checksums.md5")));
        HashMap map = new HashMap();
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (gameResFilesMd5Reg.get(zipEntryNextElement.getName()) == null || zipFile2.getEntry(zipEntryNextElement.getName()) != null) {
                if (!zipEntryNextElement.isDirectory()) {
                    map.put(zipEntryNextElement.getName(), true);
                }
            }
        }
        return map;
    }

    private void unzipEntry(ZipFile zipFile, ZipEntry zipEntry, Path path) throws Exception {
        Path pathResolve = path.resolve(Paths.get(zipEntry.getName(), new String[0]));
        if (zipEntry.isDirectory()) {
            Files.createDirectories(pathResolve, new FileAttribute[0]);
        } else if (this.mapIgnore.get(zipEntry.getName()) == null) {
            Files.createDirectories(pathResolve.getParent(), new FileAttribute[0]);
            Files.copy(zipFile.getInputStream(zipEntry), pathResolve, StandardCopyOption.REPLACE_EXISTING);
        }
        this.curCount++;
        double d2 = this.curCount;
        Double.isNaN(d2);
        double d3 = this.totalCount;
        Double.isNaN(d3);
        int i = (int) (((d2 * 1.0d) / d3) * 100.0d);
        RecoverySystem.ProgressListener progressListener = this.listener;
        if (progressListener == null || this.oldProgress == i) {
            return;
        }
        progressListener.onProgress(i);
        this.oldProgress = i;
    }

    private void unzipEntryForLowApi(ZipFile zipFile, ZipEntry zipEntry) throws IOException {
        if (zipEntry != null && !zipEntry.isDirectory() && this.mapIgnore.get(zipEntry.getName()) == null) {
            File file = new File(this.pathName, zipEntry.getName());
            if (file.getCanonicalPath().startsWith(this.pathName)) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                file.getParentFile().mkdirs();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                byte[] bArr = new byte[8192];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (-1 == i) {
                        break;
                    } else {
                        bufferedOutputStream.write(bArr, 0, i);
                    }
                }
                bufferedOutputStream.close();
                bufferedInputStream.close();
            }
        }
        this.curCount++;
        double d2 = this.curCount;
        Double.isNaN(d2);
        double d3 = this.totalCount;
        Double.isNaN(d3);
        int i2 = (int) (((d2 * 1.0d) / d3) * 100.0d);
        RecoverySystem.ProgressListener progressListener = this.listener;
        if (progressListener == null || this.oldProgress == i2) {
            return;
        }
        progressListener.onProgress(i2);
        this.oldProgress = i2;
    }

    private boolean unzipMultiThread() {
        try {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            final Path path = Paths.get(this.pathName, new String[0]);
            final ZipFile zipFile = new ZipFile(this.zipFileName);
            this.totalCount = zipFile.size();
            this.curCount = 0;
            ((Stream) zipFile.stream().parallel()).forEach(new Consumer() { // from class: com.sandboxol.blockmango.ub
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f16271a.a(zipFile, path, atomicBoolean, (ZipEntry) obj);
                }
            });
            if (this.listener != null && atomicBoolean.get()) {
                this.listener.onProgress(100);
            }
            zipFile.close();
            return atomicBoolean.get();
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean unzipMultiThreadForLowApi() {
        try {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            final ZipFile zipFile = new ZipFile(this.zipFileName);
            this.totalCount = zipFile.size();
            this.curCount = 0;
            final Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iAvailableProcessors);
            final HashSet hashSet = new HashSet();
            for (int i = 0; i < iAvailableProcessors; i++) {
                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.sandboxol.blockmango.tb
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16263a.a(enumerationEntries, zipFile, hashSet, atomicBoolean);
                    }
                });
            }
            executorServiceNewFixedThreadPool.shutdown();
            while (!executorServiceNewFixedThreadPool.isTerminated()) {
            }
            try {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    unzipEntryForLowApi(zipFile, (ZipEntry) it.next());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                atomicBoolean.set(false);
            }
            zipFile.close();
            Log.e("Main", "unzip for unzipMultiThreadForLowApi end ----------------------------------: " + (System.currentTimeMillis() - jCurrentTimeMillis));
            return atomicBoolean.get();
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public /* synthetic */ void a(ZipFile zipFile, Path path, AtomicBoolean atomicBoolean, ZipEntry zipEntry) {
        try {
            unzipEntry(zipFile, zipEntry, path);
        } catch (Exception e2) {
            e2.printStackTrace();
            atomicBoolean.set(false);
        }
    }

    public void setListener(RecoverySystem.ProgressListener progressListener) {
        this.listener = progressListener;
    }

    public boolean unzip() {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 29) ? unzipMultiThreadForLowApi() : unzipMultiThread();
    }

    public ZipStatus zipMerge(final String str, final String str2, RecoverySystem.ProgressListener progressListener) {
        String str3;
        final String str4 = str + ".tmp";
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            final ZipFile zipFile = new ZipFile(str);
            final ZipFile zipFile2 = new ZipFile(str2);
            final Map<String, Boolean> mapNeedChangeFiles = needChangeFiles(zipFile, zipFile2);
            int size = (zipFile.size() + zipFile2.size()) - mapNeedChangeFiles.size();
            this.curMergeCount = 0;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            final AtomicLong atomicLong = new AtomicLong(System.currentTimeMillis());
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            final AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
            try {
                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.sandboxol.blockmango.rb
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16244a.a(str4, zipFile, mapNeedChangeFiles, zipFile2, atomicBoolean, atomicLong);
                    }
                });
                final AtomicLong atomicLong2 = new AtomicLong(System.currentTimeMillis());
                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.sandboxol.blockmango.sb
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16252a.a(str, mapNeedChangeFiles, str2, atomicBoolean2, atomicBoolean, atomicLong2);
                    }
                });
                executorServiceNewFixedThreadPool.shutdown();
                int i = 0;
                while (!executorServiceNewFixedThreadPool.isTerminated()) {
                    double d2 = this.curMergeCount;
                    Double.isNaN(d2);
                    double d3 = size;
                    Double.isNaN(d3);
                    int i2 = (int) (((d2 * 1.0d) / d3) * 100.0d);
                    if (progressListener != null && i != i2) {
                        progressListener.onProgress(i2);
                        i = i2;
                    }
                }
                zipFile.close();
                zipFile2.close();
                Log.e("Main", String.format("zip merge get need change files size [%d],  get files time [%d], merge time [%d], unzip time [%d], total time [%d]", Integer.valueOf(mapNeedChangeFiles.size()), Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), Long.valueOf(atomicLong.get() - jCurrentTimeMillis2), Long.valueOf(atomicLong2.get() - jCurrentTimeMillis2), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                new File(str).delete();
                if (atomicBoolean.get()) {
                    str3 = str4;
                    try {
                        new File(str3).renameTo(new File(str));
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        new File(str3).delete();
                        return ZipStatus.FAILURE;
                    }
                }
                return (atomicBoolean.get() && atomicBoolean2.get()) ? ZipStatus.SUCCESS : atomicBoolean.get() ? ZipStatus.MERGE_SUCCESS : ZipStatus.FAILURE;
            } catch (Exception e3) {
                e = e3;
                str3 = str4;
            }
        } catch (Exception e4) {
            e = e4;
            str3 = str4;
        }
    }

    public /* synthetic */ void a(Enumeration enumeration, ZipFile zipFile, Set set, AtomicBoolean atomicBoolean) {
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntry = null;
            try {
                try {
                    ZipEntry zipEntry2 = (ZipEntry) enumeration.nextElement();
                    try {
                        unzipEntryForLowApi(zipFile, zipEntry2);
                    } catch (FileNotFoundException unused) {
                        zipEntry = zipEntry2;
                        if (zipEntry != null) {
                            set.add(zipEntry);
                        }
                    }
                } catch (FileNotFoundException unused2) {
                }
            } catch (NoSuchElementException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
                atomicBoolean.set(false);
            }
        }
    }

    public boolean unzip(String str, String str2, Map<String, Boolean> map) {
        this.curCount = 0;
        this.totalCount = 0;
        this.mapIgnore.clear();
        this.mapIgnore.putAll(map);
        this.pathName = str2;
        this.zipFileName = str;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26 && i <= 29) {
            return unzipMultiThread();
        }
        return unzipMultiThreadForLowApi();
    }

    private Map<String, String> getGameResFilesMd5Reg(String str) throws Exception {
        HashMap map = new HashMap();
        FileInputStream fileInputStream = new FileInputStream(str);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            String line = bufferedReader.readLine();
            if (line != null) {
                String[] strArrSplit = line.split("\\*");
                map.put(strArrSplit[1], strArrSplit[0].replace(" ", ""));
            } else {
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();
                return map;
            }
        }
    }

    public /* synthetic */ void a(String str, ZipFile zipFile, Map map, ZipFile zipFile2, AtomicBoolean atomicBoolean, AtomicLong atomicLong) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
            zipMerge(zipOutputStream, zipFile, (Map<String, Boolean>) map);
            zipMerge(zipOutputStream, zipFile2, new HashMap());
            zipOutputStream.close();
            atomicBoolean.set(true);
        } catch (Exception e2) {
            atomicBoolean.set(false);
            e2.printStackTrace();
            Log.e("Main", "merge error: " + e2.getMessage());
        }
        atomicLong.set(System.currentTimeMillis());
    }

    public /* synthetic */ void a(String str, Map map, String str2, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicLong atomicLong) {
        try {
            CommonHelper.deleteDir(new File(this.pathName));
            boolean zUnzip = unzip(str, this.pathName, map);
            if (zUnzip) {
                zUnzip = unzip(str2, this.pathName, new HashMap());
            }
            Map<String, String> gameResFilesMd5Reg = getGameResFilesMd5Reg(this.pathName + "/checksums.md5");
            Iterator<String> it = gameResFilesMd5Reg.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (MD5Util.getFileMD5String(new File(this.pathName + "/" + next)).compareTo(gameResFilesMd5Reg.get(next)) != 0) {
                    Log.e("checkRes", "md5 check failure 1. path = " + next);
                    zUnzip = false;
                    break;
                }
            }
            atomicBoolean.set(zUnzip);
        } catch (Exception e2) {
            Log.e("Main", "unzip error: " + e2.getMessage());
            CommonHelper.deleteDir(new File(this.pathName));
            atomicBoolean.set(false);
            e2.printStackTrace();
        }
        if (!atomicBoolean2.get()) {
            Log.e("Main", "unzip error remove files.");
            CommonHelper.deleteDir(new File(this.pathName));
        }
        atomicLong.set(System.currentTimeMillis());
    }

    private void zipMerge(ZipOutputStream zipOutputStream, ZipFile zipFile, Map<String, Boolean> map) throws Exception {
        Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
        while (enumerationEntries.hasMoreElements()) {
            ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
            if (map.get(zipEntryNextElement.getName()) == null) {
                if (!zipEntryNextElement.isDirectory()) {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntryNextElement.getName()));
                    byte[] bArr = new byte[8192];
                    InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                    while (true) {
                        int i = inputStream.read(bArr, 0, 8192);
                        if (i == -1) {
                            break;
                        } else {
                            zipOutputStream.write(bArr, 0, i);
                        }
                    }
                    zipOutputStream.closeEntry();
                }
                this.curMergeCount++;
            }
        }
    }
}
