package org.apache.commons.compress.archivers.a;

import com.google.android.gms.gcm.Task;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TarArchiveInputStream.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends org.apache.commons.compress.archivers.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f23520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f23523f;
    private long g;
    private long h;
    private final InputStream i;
    private a j;
    private final org.apache.commons.compress.archivers.zip.d k;
    final String l;
    private Map<String, String> m;

    public b(InputStream inputStream) {
        this(inputStream, Task.EXTRAS_LIMIT_BYTES, 512);
    }

    private void r() throws IOException {
        long jB = b();
        int i = this.f23522e;
        long j = jB % ((long) i);
        if (j > 0) {
            b(org.apache.commons.compress.a.d.a(this.i, ((long) i) - j));
        }
    }

    private byte[] s() throws IOException {
        byte[] bArrQ = q();
        a(b(bArrQ));
        if (!o() || bArrQ == null) {
            return bArrQ;
        }
        z();
        r();
        return null;
    }

    private boolean t() {
        a aVar = this.j;
        return aVar != null && aVar.c();
    }

    private void v() throws IOException {
        Map<String, String> mapA = a(this);
        g();
        a(mapA);
    }

    private void w() throws IOException {
        this.m = a(this);
        g();
    }

    private void x() throws IOException {
        byte[] bArrS;
        if (this.j.d()) {
            do {
                bArrS = s();
                if (bArrS == null) {
                    this.j = null;
                    return;
                }
            } while (new c(bArrS).a());
        }
    }

    private void y() throws IOException {
        if (t()) {
            return;
        }
        long j = this.g;
        if (j > 0) {
            int i = this.f23521d;
            if (j % ((long) i) != 0) {
                b(org.apache.commons.compress.a.d.a(this.i, (((j / ((long) i)) + 1) * ((long) i)) - j));
            }
        }
    }

    private void z() throws IOException {
        boolean zMarkSupported = this.i.markSupported();
        if (zMarkSupported) {
            this.i.mark(this.f23521d);
        }
        try {
            if ((!b(q())) && zMarkSupported) {
            }
        } finally {
            if (zMarkSupported) {
                d(this.f23521d);
                this.i.reset();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        r4 = r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.Map<java.lang.String, java.lang.String> a(java.io.InputStream r10) throws java.io.IOException {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            java.util.Map<java.lang.String, java.lang.String> r1 = r9.m
            r0.<init>(r1)
        L7:
            r1 = 0
            r2 = 0
            r3 = 0
        La:
            int r4 = r10.read()
            r5 = -1
            if (r4 == r5) goto L78
            r6 = 1
            int r2 = r2 + r6
            r7 = 10
            if (r4 != r7) goto L18
            goto L78
        L18:
            r7 = 32
            if (r4 != r7) goto L72
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream
            r4.<init>()
        L21:
            int r7 = r10.read()
            if (r7 == r5) goto L70
            int r2 = r2 + r6
            r8 = 61
            if (r7 != r8) goto L6b
            java.lang.String r8 = "UTF-8"
            java.lang.String r4 = r4.toString(r8)
            int r3 = r3 - r2
            if (r3 != r6) goto L39
            r0.remove(r4)
            goto L70
        L39:
            byte[] r2 = new byte[r3]
            int r6 = org.apache.commons.compress.a.d.a(r10, r2)
            if (r6 != r3) goto L4c
            java.lang.String r6 = new java.lang.String
            int r3 = r3 + (-1)
            r6.<init>(r2, r1, r3, r8)
            r0.put(r4, r6)
            goto L70
        L4c:
            java.io.IOException r10 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to read Paxheader. Expected "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " bytes, read "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L6b:
            byte r7 = (byte) r7
            r4.write(r7)
            goto L21
        L70:
            r4 = r7
            goto L78
        L72:
            int r3 = r3 * 10
            int r4 = r4 + (-48)
            int r3 = r3 + r4
            goto La
        L78:
            if (r4 != r5) goto L7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.archivers.a.b.a(java.io.InputStream):java.util.Map");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (t()) {
            return 0;
        }
        long j = this.g;
        long j2 = this.h;
        if (j - j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) (j - j2);
    }

    protected boolean b(byte[] bArr) {
        return bArr == null || org.apache.commons.compress.a.a.a(bArr, this.f23521d);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.i.close();
    }

    protected byte[] d() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = read(this.f23520c);
            if (i < 0) {
                break;
            }
            byteArrayOutputStream.write(this.f23520c, 0, i);
        }
        g();
        if (this.j == null) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 0 && byteArray[length - 1] == 0) {
            length--;
        }
        if (length == byteArray.length) {
            return byteArray;
        }
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 0, bArr, 0, length);
        return bArr;
    }

    public org.apache.commons.compress.archivers.a g() throws IOException {
        return n();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    public a n() throws IOException {
        if (o()) {
            return null;
        }
        if (this.j != null) {
            org.apache.commons.compress.a.d.a(this, Long.MAX_VALUE);
            y();
        }
        byte[] bArrS = s();
        if (bArrS == null) {
            this.j = null;
            return null;
        }
        try {
            this.j = new a(bArrS, this.k);
            this.h = 0L;
            this.g = this.j.b();
            if (this.j.e()) {
                byte[] bArrD = d();
                if (bArrD == null) {
                    return null;
                }
                this.j.b(this.k.decode(bArrD));
            }
            if (this.j.f()) {
                byte[] bArrD2 = d();
                if (bArrD2 == null) {
                    return null;
                }
                this.j.c(this.k.decode(bArrD2));
            }
            if (this.j.g()) {
                w();
            }
            if (this.j.i()) {
                v();
            } else if (!this.m.isEmpty()) {
                a(this.m);
            }
            if (this.j.h()) {
                x();
            }
            this.g = this.j.b();
            return this.j;
        } catch (IllegalArgumentException e2) {
            throw new IOException("Error detected parsing the header", e2);
        }
    }

    protected final boolean o() {
        return this.f23523f;
    }

    protected byte[] q() throws IOException {
        byte[] bArr = new byte[this.f23521d];
        int iA = org.apache.commons.compress.a.d.a(this.i, bArr);
        a(iA);
        if (iA != this.f23521d) {
            return null;
        }
        return bArr;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (o() || t() || this.h >= this.g) {
            return -1;
        }
        if (this.j == null) {
            throw new IllegalStateException("No current tar entry");
        }
        int iMin = Math.min(i2, available());
        int i3 = this.i.read(bArr, i, iMin);
        if (i3 != -1) {
            a(i3);
            this.h += (long) i3;
        } else {
            if (iMin > 0) {
                throw new IOException("Truncated TAR archive");
            }
            a(true);
        }
        return i3;
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0 || t()) {
            return 0L;
        }
        long jSkip = this.i.skip(Math.min(j, this.g - this.h));
        b(jSkip);
        this.h += jSkip;
        return jSkip;
    }

    public b(InputStream inputStream, int i, int i2) {
        this(inputStream, i, i2, null);
    }

    public b(InputStream inputStream, int i, int i2, String str) {
        this.f23520c = new byte[256];
        this.m = new HashMap();
        this.i = inputStream;
        this.f23523f = false;
        this.l = str;
        this.k = org.apache.commons.compress.archivers.zip.e.a(str);
        this.f23521d = i2;
        this.f23522e = i;
    }

    private void a(Map<String, String> map) {
        this.j.d(map);
    }

    protected final void a(boolean z) {
        this.f23523f = z;
    }
}
