package b.h.b.a;

import android.content.Context;
import android.os.Build;
import com.sandboxol.clothes.EchoesHandler;
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
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: AssertFileCopyUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2790a = "AssertFileCopyUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f2794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private h f2795f;
    private int h;
    private int j;
    private boolean k;
    private int i = 0;
    private Exception o = null;
    private int g = 0;
    private String l = c();
    private String m = d();
    private String n = e();

    public f(Context context, String str, String str2, String str3, int i, int i2, boolean z, h hVar) {
        this.f2791b = context;
        this.h = i2;
        this.f2792c = str;
        this.f2793d = str2;
        this.f2794e = str3;
        this.f2795f = hVar;
        this.j = i;
        this.k = z;
    }

    private String c() {
        return this.f2791b.getDir(EchoesHandler.ASSETS_NAME, 0).getPath() + "/";
    }

    private String d() {
        return this.f2791b.getDir("resourcesv2", 0).getPath() + "/";
    }

    private String e() {
        return this.f2791b.getDir("resourcesv3", 0).getPath() + "/";
    }

    private boolean f() {
        try {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            final Path path = Paths.get(this.f2793d, new String[0]);
            final ZipFile zipFile = new ZipFile(this.f2792c);
            this.g = 0;
            ((Stream) zipFile.stream().parallel()).forEach(new Consumer() { // from class: b.h.b.a.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.f2783a.a(zipFile, path, atomicBoolean, (ZipEntry) obj);
                }
            });
            if (this.f2795f != null && !atomicBoolean.get()) {
                this.f2795f.b();
            }
            zipFile.close();
            return atomicBoolean.get();
        } catch (Exception unused) {
            h hVar = this.f2795f;
            if (hVar != null) {
                hVar.b();
            }
            return false;
        }
    }

    private boolean g() {
        try {
            this.o = null;
            int i = 1;
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            long jCurrentTimeMillis = System.currentTimeMillis();
            final ZipFile zipFile = new ZipFile(this.f2792c);
            this.g = 0;
            final Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            int iAvailableProcessors = Runtime.getRuntime().availableProcessors() / 2;
            if (iAvailableProcessors >= 1) {
                i = iAvailableProcessors;
            }
            ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(i);
            final HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < i; i2++) {
                executorServiceNewFixedThreadPool.submit(new Runnable() { // from class: b.h.b.a.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2778a.a(enumerationEntries, zipFile, hashSet, atomicBoolean);
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
                this.o = e2;
            }
            zipFile.close();
            if (this.f2795f != null && !atomicBoolean.get()) {
                this.f2795f.b();
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            com.apkfuns.logutils.c.a(f2790a).d("unzip for unzipMultiThreadForLowApi end ----------------------------------: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
            return atomicBoolean.get();
        } catch (Exception e3) {
            e3.printStackTrace();
            h hVar = this.f2795f;
            if (hVar == null) {
                return false;
            }
            hVar.b();
            return false;
        }
    }

    public boolean a() {
        return b();
    }

    public boolean b() {
        return Build.VERSION.SDK_INT >= 26 ? f() : g();
    }

    public /* synthetic */ void a(ZipFile zipFile, Path path, AtomicBoolean atomicBoolean, ZipEntry zipEntry) {
        try {
            if (zipEntry.getName().contains("res.version")) {
                com.apkfuns.logutils.c.a(f2790a).d("unzip for unzipMultiThread ignore file :" + zipEntry.getName());
            } else {
                a(zipFile, zipEntry, path);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            atomicBoolean.set(false);
            this.o = e2;
        }
    }

    private void a(ZipFile zipFile, ZipEntry zipEntry, Path path) throws Exception {
        if (!zipEntry.getName().startsWith(this.f2794e)) {
            int i = this.g;
            double d2 = i;
            Double.isNaN(d2);
            int i2 = this.h;
            double d3 = i2;
            Double.isNaN(d3);
            int i3 = (int) (((d2 * 1.0d) / d3) * 100.0d);
            h hVar = this.f2795f;
            if (hVar == null || this.i == i3) {
                return;
            }
            this.i = i3;
            hVar.a(i, i2, this.j);
            return;
        }
        String strReplace = zipEntry.getName().replace(this.f2794e, "");
        Path pathResolve = path.resolve(Paths.get(strReplace, new String[0]));
        if (zipEntry.isDirectory()) {
            Files.createDirectories(pathResolve, new FileAttribute[0]);
            if (a(strReplace) && pathResolve.toString().startsWith(this.l)) {
                String string = pathResolve.toString();
                Files.createDirectories(Paths.get(string.replace(this.l, this.m), new String[0]), new FileAttribute[0]);
                Files.createDirectories(Paths.get(string.replace(this.l, this.n), new String[0]), new FileAttribute[0]);
            }
        } else {
            Files.createDirectories(pathResolve.getParent(), new FileAttribute[0]);
            Files.copy(zipFile.getInputStream(zipEntry), pathResolve, StandardCopyOption.REPLACE_EXISTING);
            if (a(strReplace) && pathResolve.toString().startsWith(this.l)) {
                String string2 = pathResolve.toString();
                Path path2 = Paths.get(string2.replace(this.l, this.m), new String[0]);
                if (!new File(path2.toString()).exists()) {
                    Files.createDirectories(path2.getParent(), new FileAttribute[0]);
                    Files.copy(zipFile.getInputStream(zipEntry), path2, StandardCopyOption.REPLACE_EXISTING);
                }
                Path path3 = Paths.get(string2.replace(this.l, this.n), new String[0]);
                if (!new File(path3.toString()).exists()) {
                    Files.createDirectories(path3.getParent(), new FileAttribute[0]);
                    Files.copy(zipFile.getInputStream(zipEntry), path3, StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
        this.g++;
        int i4 = this.g;
        double d4 = i4;
        Double.isNaN(d4);
        int i5 = this.h;
        double d5 = i5;
        Double.isNaN(d5);
        int i6 = (int) (((d4 * 1.0d) / d5) * 100.0d);
        h hVar2 = this.f2795f;
        if (hVar2 == null || this.i == i6) {
            return;
        }
        this.i = i6;
        hVar2.a(i4, i5, this.j);
    }

    public /* synthetic */ void a(Enumeration enumeration, ZipFile zipFile, Set set, AtomicBoolean atomicBoolean) {
        ZipEntry zipEntry;
        while (enumeration.hasMoreElements()) {
            try {
                try {
                    zipEntry = (ZipEntry) enumeration.nextElement();
                } catch (FileNotFoundException unused) {
                    zipEntry = null;
                }
                try {
                    if (!zipEntry.getName().contains("res.version")) {
                        a(zipFile, zipEntry);
                    } else {
                        com.apkfuns.logutils.c.a(f2790a).d("unzip for unzipMultiThreadForLowApi ignore file :" + zipEntry.getName());
                    }
                } catch (FileNotFoundException unused2) {
                    if (zipEntry != null) {
                        set.add(zipEntry);
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                atomicBoolean.set(false);
                this.o = e2;
            } catch (NoSuchElementException e3) {
                e3.printStackTrace();
            }
        }
    }

    private void a(ZipFile zipFile, ZipEntry zipEntry) throws IOException {
        boolean z;
        BufferedOutputStream bufferedOutputStream;
        File file;
        BufferedOutputStream bufferedOutputStream2;
        boolean z2;
        File file2;
        if (zipEntry != null && !zipEntry.getName().startsWith(this.f2794e)) {
            int i = this.g;
            double d2 = i;
            Double.isNaN(d2);
            int i2 = this.h;
            double d3 = i2;
            Double.isNaN(d3);
            int i3 = (int) (((d2 * 1.0d) / d3) * 100.0d);
            h hVar = this.f2795f;
            if (hVar == null || this.i == i3) {
                return;
            }
            this.i = i3;
            hVar.a(i, i2, this.j);
            return;
        }
        if (!zipEntry.isDirectory()) {
            String strReplace = zipEntry.getName().replace(this.f2794e, "");
            File file3 = new File(this.f2793d, strReplace);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            file3.getParentFile().mkdirs();
            BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file3));
            if (a(strReplace)) {
                file = new File(this.f2793d.replace(this.l, this.m), strReplace);
                z2 = !file.exists() || file.getTotalSpace() == 0;
                if (z2) {
                    file.getParentFile().mkdirs();
                    bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                } else {
                    bufferedOutputStream2 = null;
                }
                file2 = new File(this.f2793d.replace(this.l, this.n), strReplace);
                z = !file2.exists() || file2.getTotalSpace() == 0;
                if (z) {
                    file2.getParentFile().mkdirs();
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                } else {
                    bufferedOutputStream = null;
                }
            } else {
                z = true;
                bufferedOutputStream = null;
                file = null;
                bufferedOutputStream2 = null;
                z2 = true;
                file2 = null;
            }
            byte[] bArr = new byte[8192];
            while (true) {
                int i4 = bufferedInputStream.read(bArr);
                if (-1 == i4) {
                    break;
                }
                bufferedOutputStream3.write(bArr, 0, i4);
                if (file != null && a(strReplace) && z2) {
                    bufferedOutputStream2.write(bArr, 0, i4);
                }
                if (file2 != null && a(strReplace) && z) {
                    bufferedOutputStream.write(bArr, 0, i4);
                }
            }
            bufferedOutputStream3.close();
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            bufferedInputStream.close();
        }
        this.g++;
        int i5 = this.g;
        double d4 = i5;
        Double.isNaN(d4);
        int i6 = this.h;
        double d5 = i6;
        Double.isNaN(d5);
        int i7 = (int) (((d4 * 1.0d) / d5) * 100.0d);
        h hVar2 = this.f2795f;
        if (hVar2 != null && this.i != i7) {
            this.i = i7;
            hVar2.a(i5, i6, this.j);
        }
        com.apkfuns.logutils.c.a(f2790a).d("unzip progress :  curCount: " + this.g + " totalCount:" + this.h);
    }

    private boolean a(String str) {
        if (this.k) {
            return str.startsWith("Media/Actor") || str.startsWith("Media/Effects") || str.startsWith("Media/GUI") || str.startsWith("Media/Sound") || str.startsWith("Media/Textures") || str.startsWith("Media/Font") || str.startsWith("Media/Skins") || str.startsWith("Media/blank.png");
        }
        return false;
    }
}
