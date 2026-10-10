package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DiskBasedCache.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements com.android.volley.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f4047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f4048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f4049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4050d;

    public f(File file, int i) {
        this.f4047a = new LinkedHashMap(16, 0.75f, true);
        this.f4048b = 0L;
        this.f4049c = file;
        this.f4050d = i;
    }

    private String c(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void d(String str) {
        a aVarRemove = this.f4047a.remove(str);
        if (aVarRemove != null) {
            this.f4048b -= aVarRemove.f4051a;
        }
    }

    @Override // com.android.volley.a
    public synchronized void a(String str, a.C0049a c0049a) {
        a(c0049a.f3976a.length);
        File fileA = a(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(b(fileA));
            a aVar = new a(str, c0049a);
            if (!aVar.a(bufferedOutputStream)) {
                bufferedOutputStream.close();
                com.android.volley.p.a("Failed to write header for %s", fileA.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(c0049a.f3976a);
            bufferedOutputStream.close();
            a(str, aVar);
        } catch (IOException unused) {
            if (fileA.delete()) {
                return;
            }
            com.android.volley.p.a("Could not clean up file %s", fileA.getAbsolutePath());
        }
    }

    public synchronized void b(String str) {
        boolean zDelete = a(str).delete();
        d(str);
        if (!zDelete) {
            com.android.volley.p.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
        }
    }

    @Override // com.android.volley.a
    public synchronized a.C0049a get(String str) {
        a aVar = this.f4047a.get(str);
        if (aVar == null) {
            return null;
        }
        File fileA = a(str);
        try {
            b bVar = new b(new BufferedInputStream(a(fileA)), fileA.length());
            try {
                a aVarA = a.a(bVar);
                if (TextUtils.equals(str, aVarA.f4052b)) {
                    return aVar.a(a(bVar, bVar.b()));
                }
                com.android.volley.p.a("%s: key=%s, found=%s", fileA.getAbsolutePath(), str, aVarA.f4052b);
                d(str);
                return null;
            } finally {
                bVar.close();
            }
        } catch (IOException e2) {
            com.android.volley.p.a("%s: %s", fileA.getAbsolutePath(), e2.toString());
            b(str);
            return null;
        }
    }

    @Override // com.android.volley.a
    public synchronized void initialize() {
        long length;
        b bVar;
        if (!this.f4049c.exists()) {
            if (!this.f4049c.mkdirs()) {
                com.android.volley.p.b("Unable to create cache dir %s", this.f4049c.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.f4049c.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                length = file.length();
                bVar = new b(new BufferedInputStream(a(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                a aVarA = a.a(bVar);
                aVarA.f4051a = length;
                a(aVarA.f4052b, aVarA);
                bVar.close();
            } catch (Throwable th) {
                bVar.close();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f4051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f4052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f4053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f4054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f4055e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f4056f;
        final long g;
        final List<com.android.volley.g> h;

        private a(String str, String str2, long j, long j2, long j3, long j4, List<com.android.volley.g> list) {
            this.f4052b = str;
            this.f4053c = "".equals(str2) ? null : str2;
            this.f4054d = j;
            this.f4055e = j2;
            this.f4056f = j3;
            this.g = j4;
            this.h = list;
        }

        private static List<com.android.volley.g> a(a.C0049a c0049a) {
            List<com.android.volley.g> list = c0049a.h;
            return list != null ? list : h.b(c0049a.g);
        }

        static a a(b bVar) throws IOException {
            if (f.a((InputStream) bVar) == 538247942) {
                return new a(f.b(bVar), f.b(bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.a(bVar));
            }
            throw new IOException();
        }

        a(String str, a.C0049a c0049a) {
            this(str, c0049a.f3977b, c0049a.f3978c, c0049a.f3979d, c0049a.f3980e, c0049a.f3981f, a(c0049a));
            this.f4051a = c0049a.f3976a.length;
        }

        a.C0049a a(byte[] bArr) {
            a.C0049a c0049a = new a.C0049a();
            c0049a.f3976a = bArr;
            c0049a.f3977b = this.f4053c;
            c0049a.f3978c = this.f4054d;
            c0049a.f3979d = this.f4055e;
            c0049a.f3980e = this.f4056f;
            c0049a.f3981f = this.g;
            c0049a.g = h.a(this.h);
            c0049a.h = Collections.unmodifiableList(this.h);
            return c0049a;
        }

        boolean a(OutputStream outputStream) {
            try {
                f.a(outputStream, 538247942);
                f.a(outputStream, this.f4052b);
                f.a(outputStream, this.f4053c == null ? "" : this.f4053c);
                f.a(outputStream, this.f4054d);
                f.a(outputStream, this.f4055e);
                f.a(outputStream, this.f4056f);
                f.a(outputStream, this.g);
                f.a(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e2) {
                com.android.volley.p.a("%s", e2.toString());
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    static class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f4057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f4058b;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.f4057a = j;
        }

        long b() {
            return this.f4057a - this.f4058b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.f4058b++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.f4058b += (long) i3;
            }
            return i3;
        }
    }

    private static int c(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public f(File file) {
        this(file, 5242880);
    }

    OutputStream b(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    static long b(InputStream inputStream) throws IOException {
        return ((((long) c(inputStream)) & 255) << 0) | 0 | ((((long) c(inputStream)) & 255) << 8) | ((((long) c(inputStream)) & 255) << 16) | ((((long) c(inputStream)) & 255) << 24) | ((((long) c(inputStream)) & 255) << 32) | ((((long) c(inputStream)) & 255) << 40) | ((((long) c(inputStream)) & 255) << 48) | ((255 & ((long) c(inputStream))) << 56);
    }

    static String b(b bVar) throws IOException {
        return new String(a(bVar, b((InputStream) bVar)), "UTF-8");
    }

    public File a(String str) {
        return new File(this.f4049c, c(str));
    }

    private void a(int i) {
        long j;
        long j2 = i;
        if (this.f4048b + j2 < this.f4050d) {
            return;
        }
        if (com.android.volley.p.f4029b) {
            com.android.volley.p.c("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f4048b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f4047a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (a(value.f4052b).delete()) {
                j = j2;
                this.f4048b -= value.f4051a;
            } else {
                j = j2;
                String str = value.f4052b;
                com.android.volley.p.a("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
            it.remove();
            i2++;
            if (this.f4048b + j < this.f4050d * 0.9f) {
                break;
            } else {
                j2 = j;
            }
        }
        if (com.android.volley.p.f4029b) {
            com.android.volley.p.c("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f4048b - j3), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    private void a(String str, a aVar) {
        if (!this.f4047a.containsKey(str)) {
            this.f4048b += aVar.f4051a;
        } else {
            this.f4048b += aVar.f4051a - this.f4047a.get(str).f4051a;
        }
        this.f4047a.put(str, aVar);
    }

    static byte[] a(b bVar, long j) throws IOException {
        long jB = bVar.b();
        if (j >= 0 && j <= jB) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jB);
    }

    InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws IOException {
        return (c(inputStream) << 24) | (c(inputStream) << 0) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static void a(List<com.android.volley.g> list, OutputStream outputStream) throws IOException {
        if (list != null) {
            a(outputStream, list.size());
            for (com.android.volley.g gVar : list) {
                a(outputStream, gVar.a());
                a(outputStream, gVar.b());
            }
            return;
        }
        a(outputStream, 0);
    }

    static List<com.android.volley.g> a(b bVar) throws IOException {
        int iA = a((InputStream) bVar);
        if (iA >= 0) {
            List<com.android.volley.g> listEmptyList = iA == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < iA; i++) {
                listEmptyList.add(new com.android.volley.g(b(bVar).intern(), b(bVar).intern()));
            }
            return listEmptyList;
        }
        throw new IOException("readHeaderList size=" + iA);
    }
}
