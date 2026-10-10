package com.bumptech.glide.a;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f4083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f4084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f4085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f4086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f4088f;
    private final int g;
    private Writer i;
    private int k;
    private long h = 0;
    private final LinkedHashMap<String, c> j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(null));
    private final Callable<Void> n = new com.bumptech.glide.a.a(this);

    /* JADX INFO: compiled from: DiskLruCache.java */
    private static final class a implements ThreadFactory {
        private a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ a(com.bumptech.glide.a.a aVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class C0051b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f4089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f4090b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f4091c;

        /* synthetic */ C0051b(b bVar, c cVar, com.bumptech.glide.a.a aVar) {
            this(cVar);
        }

        public void c() throws IOException {
            b.this.a(this, true);
            this.f4091c = true;
        }

        private C0051b(c cVar) {
            this.f4089a = cVar;
            this.f4090b = cVar.f4097e ? null : new boolean[b.this.g];
        }

        public File a(int i) throws IOException {
            File fileB;
            synchronized (b.this) {
                if (this.f4089a.f4098f != this) {
                    throw new IllegalStateException();
                }
                if (!this.f4089a.f4097e) {
                    this.f4090b[i] = true;
                }
                fileB = this.f4089a.b(i);
                if (!b.this.f4083a.exists()) {
                    b.this.f4083a.mkdirs();
                }
            }
            return fileB;
        }

        public void b() {
            if (this.f4091c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void a() throws IOException {
            b.this.a(this, false);
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f4094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        File[] f4095c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        File[] f4096d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f4097e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private C0051b f4098f;
        private long g;

        /* synthetic */ c(b bVar, String str, com.bumptech.glide.a.a aVar) {
            this(str);
        }

        private c(String str) {
            this.f4093a = str;
            this.f4094b = new long[b.this.g];
            this.f4095c = new File[b.this.g];
            this.f4096d = new File[b.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < b.this.g; i++) {
                sb.append(i);
                this.f4095c[i] = new File(b.this.f4083a, sb.toString());
                sb.append(".tmp");
                this.f4096d[i] = new File(b.this.f4083a, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length != b.this.g) {
                a(strArr);
                throw null;
            }
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f4094b[i] = Long.parseLong(strArr[i]);
                } catch (NumberFormatException unused) {
                    a(strArr);
                    throw null;
                }
            }
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f4094b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.f4096d[i];
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f4095c[i];
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f4100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f4101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final File[] f4102d;

        /* synthetic */ d(b bVar, String str, long j, File[] fileArr, long[] jArr, com.bumptech.glide.a.a aVar) {
            this(str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.f4102d[i];
        }

        private d(String str, long j, File[] fileArr, long[] jArr) {
            this.f4099a = str;
            this.f4100b = j;
            this.f4102d = fileArr;
            this.f4101c = jArr;
        }
    }

    private b(File file, int i, int i2, long j) {
        this.f4083a = file;
        this.f4087e = i;
        this.f4084b = new File(file, "journal");
        this.f4085c = new File(file, "journal.tmp");
        this.f4086d = new File(file, "journal.bkp");
        this.g = i2;
        this.f4088f = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    private void n() throws IOException {
        a(this.f4085c);
        Iterator<c> it = this.j.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i = 0;
            if (next.f4098f == null) {
                while (i < this.g) {
                    this.h += next.f4094b[i];
                    i++;
                }
            } else {
                next.f4098f = null;
                while (i < this.g) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it.remove();
            }
        }
    }

    private void o() throws IOException {
        com.bumptech.glide.a.d dVar = new com.bumptech.glide.a.d(new FileInputStream(this.f4084b), e.f4110a);
        try {
            String strD = dVar.d();
            String strD2 = dVar.d();
            String strD3 = dVar.d();
            String strD4 = dVar.d();
            String strD5 = dVar.d();
            if (!"libcore.io.DiskLruCache".equals(strD) || !"1".equals(strD2) || !Integer.toString(this.f4087e).equals(strD3) || !Integer.toString(this.g).equals(strD4) || !"".equals(strD5)) {
                throw new IOException("unexpected journal header: [" + strD + ", " + strD2 + ", " + strD4 + ", " + strD5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    e(dVar.d());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (dVar.b()) {
                        q();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4084b, true), e.f4110a));
                    }
                    e.a(dVar);
                    return;
                }
            }
        } catch (Throwable th) {
            e.a(dVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() throws IOException {
        if (this.i != null) {
            a(this.i);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4085c), e.f4110a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write(UMCustomLogInfoBuilder.LINE_SEP);
            bufferedWriter.write("1");
            bufferedWriter.write(UMCustomLogInfoBuilder.LINE_SEP);
            bufferedWriter.write(Integer.toString(this.f4087e));
            bufferedWriter.write(UMCustomLogInfoBuilder.LINE_SEP);
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write(UMCustomLogInfoBuilder.LINE_SEP);
            bufferedWriter.write(UMCustomLogInfoBuilder.LINE_SEP);
            for (c cVar : this.j.values()) {
                if (cVar.f4098f != null) {
                    bufferedWriter.write("DIRTY " + cVar.f4093a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f4093a + cVar.a() + '\n');
                }
            }
            a(bufferedWriter);
            if (this.f4084b.exists()) {
                a(this.f4084b, this.f4086d, true);
            }
            a(this.f4085c, this.f4084b, false);
            this.f4086d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f4084b, true), e.f4110a));
        } catch (Throwable th) {
            a(bufferedWriter);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() throws IOException {
        while (this.h > this.f4088f) {
            d(this.j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i == null) {
            return;
        }
        for (c cVar : new ArrayList(this.j.values())) {
            if (cVar.f4098f != null) {
                cVar.f4098f.a();
            }
        }
        r();
        a(this.i);
        this.i = null;
    }

    private void e(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        c cVar = this.j.get(strSubstring);
        com.bumptech.glide.a.a aVar = null;
        if (cVar == null) {
            cVar = new c(this, strSubstring, aVar);
            this.j.put(strSubstring, cVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            cVar.f4097e = true;
            cVar.f4098f = null;
            cVar.b(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            cVar.f4098f = new C0051b(this, cVar, aVar);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public void b() throws IOException {
        close();
        e.a(this.f4083a);
    }

    public synchronized d c(String str) throws IOException {
        d();
        c cVar = this.j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.f4097e) {
            return null;
        }
        for (File file : cVar.f4095c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (g()) {
            this.m.submit(this.n);
        }
        return new d(this, str, cVar.g, cVar.f4095c, cVar.f4094b, null);
    }

    public synchronized boolean d(String str) throws IOException {
        d();
        c cVar = this.j.get(str);
        if (cVar != null && cVar.f4098f == null) {
            for (int i = 0; i < this.g; i++) {
                File fileA = cVar.a(i);
                if (fileA.exists() && !fileA.delete()) {
                    throw new IOException("failed to delete " + fileA);
                }
                this.h -= cVar.f4094b[i];
                cVar.f4094b[i] = 0;
            }
            this.k++;
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) str);
            this.i.append('\n');
            this.j.remove(str);
            if (g()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public static b a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            b bVar = new b(file, i, i2, j);
            if (bVar.f4084b.exists()) {
                try {
                    bVar.o();
                    bVar.n();
                    return bVar;
                } catch (IOException e2) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    bVar.b();
                }
            }
            file.mkdirs();
            b bVar2 = new b(file, i, i2, j);
            bVar2.q();
            return bVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    @TargetApi(26)
    private static void b(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    private void d() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public C0051b a(String str) throws IOException {
        return a(str, -1L);
    }

    private synchronized C0051b a(String str, long j) throws IOException {
        d();
        c cVar = this.j.get(str);
        com.bumptech.glide.a.a aVar = null;
        if (j != -1 && (cVar == null || cVar.g != j)) {
            return null;
        }
        if (cVar != null) {
            if (cVar.f4098f != null) {
                return null;
            }
        } else {
            cVar = new c(this, str, aVar);
            this.j.put(str, cVar);
        }
        C0051b c0051b = new C0051b(this, cVar, aVar);
        cVar.f4098f = c0051b;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        b(this.i);
        return c0051b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(C0051b c0051b, boolean z) throws IOException {
        c cVar = c0051b.f4089a;
        if (cVar.f4098f == c0051b) {
            if (z && !cVar.f4097e) {
                for (int i = 0; i < this.g; i++) {
                    if (c0051b.f4090b[i]) {
                        if (!cVar.b(i).exists()) {
                            c0051b.a();
                            return;
                        }
                    } else {
                        c0051b.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.g; i2++) {
                File fileB = cVar.b(i2);
                if (z) {
                    if (fileB.exists()) {
                        File fileA = cVar.a(i2);
                        fileB.renameTo(fileA);
                        long j = cVar.f4094b[i2];
                        long length = fileA.length();
                        cVar.f4094b[i2] = length;
                        this.h = (this.h - j) + length;
                    }
                } else {
                    a(fileB);
                }
            }
            this.k++;
            cVar.f4098f = null;
            if (!(cVar.f4097e | z)) {
                this.j.remove(cVar.f4093a);
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) cVar.f4093a);
                this.i.append('\n');
            } else {
                cVar.f4097e = true;
                this.i.append((CharSequence) "CLEAN");
                this.i.append(' ');
                this.i.append((CharSequence) cVar.f4093a);
                this.i.append((CharSequence) cVar.a());
                this.i.append('\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    cVar.g = j2;
                }
            }
            b(this.i);
            if (this.h > this.f4088f || g()) {
                this.m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }

    @TargetApi(26)
    private static void a(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
