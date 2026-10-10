package com.bytedance.sdk.adnet.core;

import android.os.SystemClock;
import com.bytedance.sdk.adnet.face.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
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
class f implements com.bytedance.sdk.adnet.face.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f5499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f5501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f5502d;

    public f(File file, int i) {
        this.f5499a = new LinkedHashMap(16, 0.75f, true);
        this.f5500b = 0L;
        this.f5501c = file;
        this.f5502d = i;
    }

    private String d(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void e(String str) {
        a aVarRemove = this.f5499a.remove(str);
        if (aVarRemove != null) {
            this.f5500b -= aVarRemove.f5503a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.sdk.adnet.face.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized com.bytedance.sdk.adnet.face.a.C0073a a(java.lang.String r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch: java.lang.Throwable -> L9e
            r1 = 0
            if (r0 == 0) goto La
            monitor-exit(r10)
            return r1
        La:
            java.util.Map<java.lang.String, com.bytedance.sdk.adnet.core.f$a> r0 = r10.f5499a     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r0 = r0.get(r11)     // Catch: java.lang.Throwable -> L9e
            com.bytedance.sdk.adnet.core.f$a r0 = (com.bytedance.sdk.adnet.core.f.a) r0     // Catch: java.lang.Throwable -> L9e
            if (r0 != 0) goto L16
            monitor-exit(r10)
            return r1
        L16:
            java.io.File r2 = r10.c(r11)     // Catch: java.lang.Throwable -> L9e
            r3 = 1
            r4 = 0
            r5 = 2
            com.bytedance.sdk.adnet.core.f$b r6 = new com.bytedance.sdk.adnet.core.f$b     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L78
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L78
            java.io.InputStream r8 = r10.a(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L78
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L78
            long r8 = r2.length()     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L78
            r6.<init>(r7, r8)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L78
            com.bytedance.sdk.adnet.core.f$a r7 = com.bytedance.sdk.adnet.core.f.a.a(r6)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r8 = r7.f5504b     // Catch: java.lang.Throwable -> L6e
            boolean r8 = android.text.TextUtils.equals(r11, r8)     // Catch: java.lang.Throwable -> L6e
            if (r8 != 0) goto L5a
            java.lang.String r0 = "%s: key=%s, found=%s"
            r8 = 3
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch: java.lang.Throwable -> L6e
            java.lang.String r9 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L6e
            r8[r4] = r9     // Catch: java.lang.Throwable -> L6e
            r8[r3] = r11     // Catch: java.lang.Throwable -> L6e
            java.lang.String r7 = r7.f5504b     // Catch: java.lang.Throwable -> L6e
            r8[r5] = r7     // Catch: java.lang.Throwable -> L6e
            com.bytedance.sdk.adnet.core.o.b(r0, r8)     // Catch: java.lang.Throwable -> L6e
            r10.e(r11)     // Catch: java.lang.Throwable -> L6e
            r6.close()     // Catch: java.lang.Throwable -> L73 java.lang.Throwable -> L97
            r6.close()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L9e
        L58:
            monitor-exit(r10)
            return r1
        L5a:
            long r7 = r6.a()     // Catch: java.lang.Throwable -> L6e
            byte[] r7 = a(r6, r7)     // Catch: java.lang.Throwable -> L6e
            com.bytedance.sdk.adnet.face.a$a r0 = r0.a(r7)     // Catch: java.lang.Throwable -> L6e
            r6.close()     // Catch: java.lang.Throwable -> L73 java.lang.Throwable -> L97
            r6.close()     // Catch: java.lang.Throwable -> L6c java.lang.Throwable -> L9e
        L6c:
            monitor-exit(r10)
            return r0
        L6e:
            r0 = move-exception
            r6.close()     // Catch: java.lang.Throwable -> L73 java.lang.Throwable -> L97
            throw r0     // Catch: java.lang.Throwable -> L73 java.lang.Throwable -> L97
        L73:
            r0 = move-exception
            goto L7a
        L75:
            r11 = move-exception
            r6 = r1
            goto L98
        L78:
            r0 = move-exception
            r6 = r1
        L7a:
            java.lang.String r7 = "%s: %s"
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L97
            r5[r4] = r2     // Catch: java.lang.Throwable -> L97
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L97
            r5[r3] = r0     // Catch: java.lang.Throwable -> L97
            com.bytedance.sdk.adnet.core.o.b(r7, r5)     // Catch: java.lang.Throwable -> L97
            r10.b(r11)     // Catch: java.lang.Throwable -> L97
            if (r6 == 0) goto L95
            r6.close()     // Catch: java.lang.Throwable -> L95 java.lang.Throwable -> L9e
        L95:
            monitor-exit(r10)
            return r1
        L97:
            r11 = move-exception
        L98:
            if (r6 == 0) goto L9d
            r6.close()     // Catch: java.lang.Throwable -> L9d java.lang.Throwable -> L9e
        L9d:
            throw r11     // Catch: java.lang.Throwable -> L9e
        L9e:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.core.f.a(java.lang.String):com.bytedance.sdk.adnet.face.a$a");
    }

    public synchronized void b(String str) {
        boolean zDelete = c(str).delete();
        e(str);
        if (!zDelete) {
            o.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
        }
    }

    public File c(String str) {
        return new File(this.f5501c, d(str));
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f5503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f5504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f5505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f5506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f5507e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f5508f;
        final long g;
        final List<Header> h;

        private a(String str, String str2, long j, long j2, long j3, long j4, List<Header> list) {
            this.f5504b = str;
            this.f5505c = "".equals(str2) ? null : str2;
            this.f5506d = j;
            this.f5507e = j2;
            this.f5508f = j3;
            this.g = j4;
            this.h = list;
        }

        private static List<Header> a(a.C0073a c0073a) {
            List<Header> list = c0073a.i;
            return list != null ? list : com.bytedance.sdk.adnet.d.b.b(c0073a.h);
        }

        static a a(b bVar) throws Throwable {
            if (f.a((InputStream) bVar) == 538247942) {
                return new a(f.a(bVar), f.a(bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b((InputStream) bVar), f.b(bVar));
            }
            throw new IOException();
        }

        a(String str, a.C0073a c0073a) {
            this(str, c0073a.f5568c, c0073a.f5569d, c0073a.f5570e, c0073a.f5571f, c0073a.g, a(c0073a));
        }

        a.C0073a a(byte[] bArr) {
            a.C0073a c0073a = new a.C0073a();
            c0073a.f5567b = bArr;
            c0073a.f5568c = this.f5505c;
            c0073a.f5569d = this.f5506d;
            c0073a.f5570e = this.f5507e;
            c0073a.f5571f = this.f5508f;
            c0073a.g = this.g;
            c0073a.h = com.bytedance.sdk.adnet.d.b.a(this.h);
            c0073a.i = Collections.unmodifiableList(this.h);
            return c0073a;
        }

        boolean a(OutputStream outputStream) {
            try {
                f.a(outputStream, 538247942);
                f.a(outputStream, this.f5504b);
                f.a(outputStream, this.f5505c == null ? "" : this.f5505c);
                f.a(outputStream, this.f5506d);
                f.a(outputStream, this.f5507e);
                f.a(outputStream, this.f5508f);
                f.a(outputStream, this.g);
                f.a(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (Throwable th) {
                o.b("%s", th.toString());
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: DiskBasedCache.java */
    static class b extends FilterInputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f5509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f5510b;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.f5509a = j;
        }

        long a() {
            return this.f5509a - this.f5510b;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            if (i != -1) {
                this.f5510b++;
            }
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            if (i3 != -1) {
                this.f5510b += (long) i3;
            }
            return i3;
        }
    }

    private static int c(InputStream inputStream) throws Throwable {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    public f(File file) {
        this(file, 5242880);
    }

    private void b() {
        if (this.f5500b < this.f5502d) {
            return;
        }
        if (o.f5544a) {
            o.a("Pruning old cache entries.", new Object[0]);
        }
        long j = this.f5500b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f5499a.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (c(value.f5504b).delete()) {
                this.f5500b -= value.f5503a;
            } else {
                String str = value.f5504b;
                o.b("Could not delete cache entry for key=%s, filename=%s", str, d(str));
            }
            it.remove();
            i++;
            if (this.f5500b < this.f5502d * 0.9f) {
                break;
            }
        }
        if (o.f5544a) {
            o.a("pruned %d files, %d bytes, %d ms", Integer.valueOf(i), Long.valueOf(this.f5500b - j), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    OutputStream b(File file) throws Throwable {
        return new FileOutputStream(file);
    }

    static long b(InputStream inputStream) throws Throwable {
        return ((((long) c(inputStream)) & 255) << 0) | 0 | ((((long) c(inputStream)) & 255) << 8) | ((((long) c(inputStream)) & 255) << 16) | ((((long) c(inputStream)) & 255) << 24) | ((((long) c(inputStream)) & 255) << 32) | ((((long) c(inputStream)) & 255) << 40) | ((((long) c(inputStream)) & 255) << 48) | ((255 & ((long) c(inputStream))) << 56);
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized void a() {
        if (!this.f5501c.exists()) {
            if (!this.f5501c.mkdirs()) {
                o.c("Unable to create cache dir %s", this.f5501c.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = this.f5501c.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                long length = file.length();
                b bVar = new b(new BufferedInputStream(a(file)), length);
                try {
                    a aVarA = a.a(bVar);
                    aVarA.f5503a = length;
                    a(aVarA.f5504b, aVarA);
                } catch (Throwable unused) {
                }
                bVar.close();
            } catch (Throwable unused2) {
                file.delete();
            }
        }
    }

    static List<Header> b(b bVar) throws Throwable {
        int iA = a((InputStream) bVar);
        if (iA >= 0) {
            List<Header> listEmptyList = iA == 0 ? Collections.emptyList() : new ArrayList<>();
            for (int i = 0; i < iA; i++) {
                listEmptyList.add(new Header(a(bVar).intern(), a(bVar).intern()));
            }
            return listEmptyList;
        }
        throw new IOException("readHeaderList size=" + iA);
    }

    @Override // com.bytedance.sdk.adnet.face.a
    public synchronized void a(String str, a.C0073a c0073a) {
        BufferedOutputStream bufferedOutputStream;
        if (this.f5500b + ((long) c0073a.f5567b.length) > this.f5502d && c0073a.f5567b.length > this.f5502d * 0.9f) {
            return;
        }
        File fileC = c(str);
        try {
            bufferedOutputStream = new BufferedOutputStream(b(fileC));
            try {
                a aVar = new a(str, c0073a);
                if (aVar.a(bufferedOutputStream)) {
                    bufferedOutputStream.write(c0073a.f5567b);
                    aVar.f5503a = fileC.length();
                    a(str, aVar);
                    b();
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return;
                }
                bufferedOutputStream.close();
                o.b("Failed to write header for %s", fileC.getAbsolutePath());
                throw new IOException();
            } catch (Throwable th) {
                th = th;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
        }
    }

    private void a(String str, a aVar) {
        if (!this.f5499a.containsKey(str)) {
            this.f5500b += aVar.f5503a;
        } else {
            this.f5500b += aVar.f5503a - this.f5499a.get(str).f5503a;
        }
        this.f5499a.put(str, aVar);
    }

    static byte[] a(b bVar, long j) throws Throwable {
        long jA = bVar.a();
        if (j >= 0 && j <= jA) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + jA);
    }

    InputStream a(File file) throws Throwable {
        return new FileInputStream(file);
    }

    static void a(OutputStream outputStream, int i) throws Throwable {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int a(InputStream inputStream) throws Throwable {
        return (c(inputStream) << 24) | (c(inputStream) << 0) | 0 | (c(inputStream) << 8) | (c(inputStream) << 16);
    }

    static void a(OutputStream outputStream, long j) throws Throwable {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void a(OutputStream outputStream, String str) throws Throwable {
        byte[] bytes = str.getBytes("UTF-8");
        a(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String a(b bVar) throws Throwable {
        return new String(a(bVar, b((InputStream) bVar)), "UTF-8");
    }

    static void a(List<Header> list, OutputStream outputStream) throws Throwable {
        if (list != null) {
            a(outputStream, list.size());
            for (Header header : list) {
                a(outputStream, header.getName());
                a(outputStream, header.getValue());
            }
            return;
        }
        a(outputStream, 0);
    }
}
