package com.sandboxol.file.e;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.sandboxol.file.entity.Progress;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.security.MessageDigest;
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
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: ZipUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f17611a = "ZipUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f17612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f17614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f17615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.sandboxol.file.d.e f17616f;
    private boolean g;
    private String m;
    private int j = 0;
    private Map<String, Boolean> k = new HashMap();
    private Exception l = null;
    private int h = 0;
    private int i = 0;

    public j(Context context, String str, String str2, String str3, boolean z, com.sandboxol.file.d.e eVar) {
        this.f17612b = context;
        this.f17614d = str;
        this.f17615e = str2;
        this.f17613c = str3;
        this.f17616f = eVar;
        this.g = z;
        if (str3 == null || str3.split("\\.").length <= 0) {
            this.m = "checksums.md5";
            return;
        }
        this.m = str3.split("\\.")[0] + "-checksums.md5";
    }

    private boolean c() {
        try {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            final Path path = Paths.get(this.f17615e, new String[0]);
            final ZipFile zipFile = new ZipFile(this.f17614d + "/" + this.f17613c);
            this.i = zipFile.size();
            this.h = 0;
            ((Stream) zipFile.stream().parallel()).forEach(new Consumer() { // from class: com.sandboxol.file.e.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f17587a.a(zipFile, path, atomicBoolean, (ZipEntry) obj);
                }
            });
            if (this.f17616f != null && !atomicBoolean.get()) {
                this.f17616f.error(new Exception("failed other", this.l));
            }
            zipFile.close();
            return atomicBoolean.get();
        } catch (Exception e2) {
            com.sandboxol.file.d.e eVar = this.f17616f;
            if (eVar != null) {
                eVar.error(new Exception("failed other", e2));
            }
            return false;
        }
    }

    private boolean d() {
        try {
            this.l = null;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            final ZipFile zipFile = new ZipFile(this.f17614d + "/" + this.f17613c);
            this.i = zipFile.size();
            this.h = 0;
            final Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(iAvailableProcessors);
            final HashSet hashSet = new HashSet();
            for (int i = 0; i < iAvailableProcessors; i++) {
                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: com.sandboxol.file.e.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f17591a.a(enumerationEntries, zipFile, hashSet, atomicBoolean);
                    }
                });
            }
            executorServiceNewFixedThreadPool.shutdown();
            while (!executorServiceNewFixedThreadPool.isTerminated()) {
            }
            try {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    a(zipFile, (ZipEntry) it.next());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                atomicBoolean.set(false);
                this.l = e2;
            }
            zipFile.close();
            if (this.f17616f != null && !atomicBoolean.get()) {
                this.f17616f.error(new Exception("failed other", this.l));
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(f17611a, "unzip for unzipMultiThreadForLowApi end ----------------------------------: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
            return atomicBoolean.get();
        } catch (Exception e3) {
            e3.printStackTrace();
            com.sandboxol.file.d.e eVar = this.f17616f;
            if (eVar == null) {
                return false;
            }
            eVar.error(new Exception("failed other", e3));
            return false;
        }
    }

    public void a() {
        if (b()) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                Map<String, String> mapA = com.sandboxol.file.f.b.a(this.f17612b, this.f17615e, this.m);
                for (String str : mapA.keySet()) {
                    if (mapA.size() != 0 && !this.m.equals(str) && !str.contains("appres") && this.g) {
                        if (!com.sandboxol.file.f.b.a(mapA.get(str), this.f17615e + "/", str, messageDigest)) {
                            this.f17616f.error(new Exception("failed md5 error"));
                            return;
                        }
                    }
                }
                this.f17616f.success();
            } catch (Exception e2) {
                this.f17616f.error(new Exception("failed other", e2));
                Log.e("checkRes", "md5 check failure 2. e = " + e2.getMessage());
            }
        }
    }

    public boolean b() {
        return Build.VERSION.SDK_INT >= 26 ? c() : d();
    }

    public /* synthetic */ void a(ZipFile zipFile, Path path, AtomicBoolean atomicBoolean, ZipEntry zipEntry) {
        try {
            a(zipFile, zipEntry, path);
        } catch (Exception e2) {
            e2.printStackTrace();
            atomicBoolean.set(false);
            this.l = e2;
        }
    }

    private void a(ZipFile zipFile, ZipEntry zipEntry, Path path) throws Exception {
        Path pathResolve = path.resolve(Paths.get(zipEntry.getName(), new String[0]));
        if (zipEntry.isDirectory()) {
            Files.createDirectories(pathResolve, new FileAttribute[0]);
        } else if (this.k.get(zipEntry.getName()) == null) {
            Files.createDirectories(pathResolve.getParent(), new FileAttribute[0]);
            Files.copy(zipFile.getInputStream(zipEntry), pathResolve, StandardCopyOption.REPLACE_EXISTING);
            if (zipEntry.getName().equals("checksums.md5")) {
                a(pathResolve.toString(), pathResolve.toString().substring(0, pathResolve.toString().lastIndexOf("/") + 1) + this.m);
            }
        }
        this.h++;
        double d2 = this.h;
        Double.isNaN(d2);
        double d3 = this.i;
        Double.isNaN(d3);
        int i = (int) (((d2 * 1.0d) / d3) * 100.0d);
        if (this.f17616f == null || this.j == i) {
            return;
        }
        this.j = i;
        this.f17616f.progress(new Progress().setDownloadSize(Long.valueOf(this.h)).setTotalSize(Long.valueOf(this.i)));
    }

    public /* synthetic */ void a(Enumeration enumeration, ZipFile zipFile, Set set, AtomicBoolean atomicBoolean) {
        while (enumeration.hasMoreElements()) {
            ZipEntry zipEntry = null;
            try {
                try {
                    ZipEntry zipEntry2 = (ZipEntry) enumeration.nextElement();
                    try {
                        a(zipFile, zipEntry2);
                    } catch (FileNotFoundException unused) {
                        zipEntry = zipEntry2;
                        if (zipEntry != null) {
                            set.add(zipEntry);
                        }
                    }
                } catch (FileNotFoundException unused2) {
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                atomicBoolean.set(false);
                this.l = e2;
            } catch (NoSuchElementException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void a(ZipFile zipFile, ZipEntry zipEntry) throws IOException {
        if (zipEntry != null && !zipEntry.isDirectory() && this.k.get(zipEntry.getName()) == null) {
            File file = new File(this.f17615e, zipEntry.getName());
            String absolutePath = file.getAbsolutePath();
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
            if (zipEntry.getName().equals("checksums.md5")) {
                a(absolutePath, absolutePath.substring(0, absolutePath.lastIndexOf("/") + 1) + this.m);
            }
        }
        this.h++;
        if (this.f17616f != null) {
            this.f17616f.progress(new Progress().setDownloadSize(Long.valueOf(this.h)).setTotalSize(Long.valueOf(this.i)));
        }
        Log.d(f17611a, "unzip progress :  curCount: " + this.h + " totalCount:" + this.i);
    }

    public static void a(String str, String str2) {
        File file = new File(str);
        File file2 = new File(str2);
        if (file2.exists() && file2.isFile()) {
            file2.delete();
        }
        if (file.exists() && file.isFile()) {
            file.renameTo(file2);
        }
    }
}
