package com.bytedance.sdk.a.a;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: Buffer.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements d, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f4850c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    o f4851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f4852b;

    @Override // com.bytedance.sdk.a.a.e
    public void a(long j) throws EOFException {
        if (this.f4852b < j) {
            throw new EOFException();
        }
    }

    @Override // com.bytedance.sdk.a.a.r
    public void a_(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        u.a(cVar.f4852b, 0L, j);
        while (j > 0) {
            o oVar = cVar.f4851a;
            if (j < oVar.f4886c - oVar.f4885b) {
                o oVar2 = this.f4851a;
                o oVar3 = oVar2 != null ? oVar2.g : null;
                if (oVar3 != null && oVar3.f4888e) {
                    if ((((long) oVar3.f4886c) + j) - ((long) (oVar3.f4887d ? 0 : oVar3.f4885b)) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        cVar.f4851a.a(oVar3, (int) j);
                        cVar.f4852b -= j;
                        this.f4852b += j;
                        return;
                    }
                }
                cVar.f4851a = cVar.f4851a.a((int) j);
            }
            o oVar4 = cVar.f4851a;
            long j2 = oVar4.f4886c - oVar4.f4885b;
            cVar.f4851a = oVar4.b();
            o oVar5 = this.f4851a;
            if (oVar5 == null) {
                this.f4851a = oVar4;
                o oVar6 = this.f4851a;
                oVar6.g = oVar6;
                oVar6.f4889f = oVar6;
            } else {
                oVar5.g.a(oVar4).c();
            }
            cVar.f4852b -= j2;
            this.f4852b += j2;
            j -= j2;
        }
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.e
    public c c() {
        return this;
    }

    @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c u() {
        return this;
    }

    public String d(long j) throws EOFException {
        return a(j, u.f4897a);
    }

    @Override // com.bytedance.sdk.a.a.e
    public boolean e() {
        return this.f4852b == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        long j = this.f4852b;
        if (j != cVar.f4852b) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        o oVar = this.f4851a;
        o oVar2 = cVar.f4851a;
        int i = oVar.f4885b;
        int i2 = oVar2.f4885b;
        while (j2 < this.f4852b) {
            long jMin = Math.min(oVar.f4886c - i, oVar2.f4886c - i2);
            int i3 = i2;
            int i4 = i;
            int i5 = 0;
            while (i5 < jMin) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                if (oVar.f4884a[i4] != oVar2.f4884a[i3]) {
                    return false;
                }
                i5++;
                i4 = i6;
                i3 = i7;
            }
            if (i4 == oVar.f4886c) {
                oVar = oVar.f4889f;
                i = oVar.f4885b;
            } else {
                i = i4;
            }
            if (i3 == oVar2.f4886c) {
                oVar2 = oVar2.f4889f;
                i2 = oVar2.f4885b;
            } else {
                i2 = i3;
            }
            j2 += jMin;
        }
        return true;
    }

    @Override // com.bytedance.sdk.a.a.e
    public InputStream f() {
        return new InputStream() { // from class: com.bytedance.sdk.a.a.c.1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(c.this.f4852b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                c cVar = c.this;
                if (cVar.f4852b > 0) {
                    return cVar.h() & 255;
                }
                return -1;
            }

            public String toString() {
                return c.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return c.this.a(bArr, i, i2);
            }
        };
    }

    @Override // com.bytedance.sdk.a.a.d, com.bytedance.sdk.a.a.r, java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        o oVar = this.f4851a;
        if (oVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = oVar.f4886c;
            for (int i3 = oVar.f4885b; i3 < i2; i3++) {
                i = (i * 31) + oVar.f4884a[i3];
            }
            oVar = oVar.f4889f;
        } while (oVar != this.f4851a);
        return i;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // com.bytedance.sdk.a.a.e
    public int j() {
        long j = this.f4852b;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.f4852b);
        }
        o oVar = this.f4851a;
        int i = oVar.f4885b;
        int i2 = oVar.f4886c;
        if (i2 - i < 4) {
            return ((h() & 255) << 24) | ((h() & 255) << 16) | ((h() & 255) << 8) | (h() & 255);
        }
        byte[] bArr = oVar.f4884a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f4852b = j - 4;
        if (i8 == i2) {
            this.f4851a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f4885b = i8;
        }
        return i9;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a5 A[EDGE_INSN: B:45:0x00a5->B:38:0x00a5 BREAK  A[LOOP:0: B:5:0x000b->B:47:?], SYNTHETIC] */
    @Override // com.bytedance.sdk.a.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long m() {
        /*
            r15 = this;
            long r0 = r15.f4852b
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lac
            r0 = 0
            r4 = r2
            r1 = 0
        Lb:
            com.bytedance.sdk.a.a.o r6 = r15.f4851a
            byte[] r7 = r6.f4884a
            int r8 = r6.f4885b
            int r9 = r6.f4886c
        L13:
            if (r8 >= r9) goto L91
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L72
            r11 = 70
            if (r10 > r11) goto L72
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r1 = r1 + 1
            goto L13
        L4a:
            com.bytedance.sdk.a.a.c r0 = new com.bytedance.sdk.a.a.c
            r0.<init>()
            com.bytedance.sdk.a.a.c r0 = r0.k(r4)
            com.bytedance.sdk.a.a.c r0 = r0.i(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.o()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L72:
            if (r1 == 0) goto L76
            r0 = 1
            goto L91
        L76:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L91:
            if (r8 != r9) goto L9d
            com.bytedance.sdk.a.a.o r7 = r6.b()
            r15.f4851a = r7
            com.bytedance.sdk.a.a.p.a(r6)
            goto L9f
        L9d:
            r6.f4885b = r8
        L9f:
            if (r0 != 0) goto La5
            com.bytedance.sdk.a.a.o r6 = r15.f4851a
            if (r6 != 0) goto Lb
        La5:
            long r2 = r15.f4852b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f4852b = r2
            return r4
        Lac:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            goto Lb5
        Lb4:
            throw r0
        Lb5:
            goto Lb4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.a.a.c.m():long");
    }

    public f n() {
        return new f(q());
    }

    public String o() {
        try {
            return a(this.f4852b, u.f4897a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public String p() throws EOFException {
        return e(Long.MAX_VALUE);
    }

    public byte[] q() {
        try {
            return g(this.f4852b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void r() {
        try {
            h(this.f4852b);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        o oVar = this.f4851a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), oVar.f4886c - oVar.f4885b);
        byteBuffer.put(oVar.f4884a, oVar.f4885b, iMin);
        oVar.f4885b += iMin;
        this.f4852b -= (long) iMin;
        if (oVar.f4885b == oVar.f4886c) {
            this.f4851a = oVar.b();
            p.a(oVar);
        }
        return iMin;
    }

    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public c clone() {
        c cVar = new c();
        if (this.f4852b == 0) {
            return cVar;
        }
        cVar.f4851a = this.f4851a.a();
        o oVar = cVar.f4851a;
        oVar.g = oVar;
        oVar.f4889f = oVar;
        o oVar2 = this.f4851a;
        while (true) {
            oVar2 = oVar2.f4889f;
            if (oVar2 == this.f4851a) {
                cVar.f4852b = this.f4852b;
                return cVar;
            }
            cVar.f4851a.g.a(oVar2.a());
        }
    }

    public final f t() {
        long j = this.f4852b;
        if (j <= 2147483647L) {
            return f((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f4852b);
    }

    public String toString() {
        return t().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            o oVarE = e(1);
            int iMin = Math.min(i, 8192 - oVarE.f4886c);
            byteBuffer.get(oVarE.f4884a, oVarE.f4886c, iMin);
            i -= iMin;
            oVarE.f4886c += iMin;
        }
        this.f4852b += (long) iRemaining;
        return iRemaining;
    }

    public final c a(c cVar, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("out == null");
        }
        u.a(this.f4852b, j, j2);
        if (j2 == 0) {
            return this;
        }
        cVar.f4852b += j2;
        o oVar = this.f4851a;
        while (true) {
            int i = oVar.f4886c;
            int i2 = oVar.f4885b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            oVar = oVar.f4889f;
        }
        while (j2 > 0) {
            o oVarA = oVar.a();
            oVarA.f4885b = (int) (((long) oVarA.f4885b) + j);
            oVarA.f4886c = Math.min(oVarA.f4885b + ((int) j2), oVarA.f4886c);
            o oVar2 = cVar.f4851a;
            if (oVar2 == null) {
                oVarA.g = oVarA;
                oVarA.f4889f = oVarA;
                cVar.f4851a = oVarA;
            } else {
                oVar2.g.a(oVarA);
            }
            j2 -= (long) (oVarA.f4886c - oVarA.f4885b);
            oVar = oVar.f4889f;
            j = 0;
        }
        return this;
    }

    public final long b() {
        return this.f4852b;
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c g(int i) {
        o oVarE = e(4);
        byte[] bArr = oVarE.f4884a;
        int i2 = oVarE.f4886c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        oVarE.f4886c = i5 + 1;
        this.f4852b += 4;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public String e(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j != Long.MAX_VALUE ? j + 1 : Long.MAX_VALUE;
        long jA = a((byte) 10, 0L, j2);
        if (jA != -1) {
            return f(jA);
        }
        if (j2 < b() && b(j2 - 1) == 13 && b(j2) == 10) {
            return f(j2);
        }
        c cVar = new c();
        a(cVar, 0L, Math.min(32L, b()));
        throw new EOFException("\\n not found: limit=" + Math.min(b(), j) + " content=" + cVar.n().e() + (char) 8230);
    }

    String f(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (b(j2) == 13) {
                String strD = d(j2);
                h(2L);
                return strD;
            }
        }
        String strD2 = d(j);
        h(1L);
        return strD2;
    }

    public final long g() {
        long j = this.f4852b;
        if (j == 0) {
            return 0L;
        }
        o oVar = this.f4851a.g;
        int i = oVar.f4886c;
        return (i >= 8192 || !oVar.f4888e) ? j : j - ((long) (i - oVar.f4885b));
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte h() {
        long j = this.f4852b;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        o oVar = this.f4851a;
        int i = oVar.f4885b;
        int i2 = oVar.f4886c;
        int i3 = i + 1;
        byte b2 = oVar.f4884a[i];
        this.f4852b = j - 1;
        if (i3 == i2) {
            this.f4851a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f4885b = i3;
        }
        return b2;
    }

    @Override // com.bytedance.sdk.a.a.e
    public short i() {
        long j = this.f4852b;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.f4852b);
        }
        o oVar = this.f4851a;
        int i = oVar.f4885b;
        int i2 = oVar.f4886c;
        if (i2 - i < 2) {
            return (short) (((h() & 255) << 8) | (h() & 255));
        }
        byte[] bArr = oVar.f4884a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f4852b = j - 2;
        if (i4 == i2) {
            this.f4851a = oVar.b();
            p.a(oVar);
        } else {
            oVar.f4885b = i4;
        }
        return (short) i5;
    }

    @Override // com.bytedance.sdk.a.a.e
    public short k() {
        return u.a(i());
    }

    @Override // com.bytedance.sdk.a.a.e
    public int l() {
        return u.a(j());
    }

    public final byte b(long j) {
        int i;
        u.a(this.f4852b, j, 1L);
        long j2 = this.f4852b;
        if (j2 - j > j) {
            o oVar = this.f4851a;
            while (true) {
                int i2 = oVar.f4886c;
                int i3 = oVar.f4885b;
                long j3 = i2 - i3;
                if (j < j3) {
                    return oVar.f4884a[i3 + ((int) j)];
                }
                j -= j3;
                oVar = oVar.f4889f;
            }
        } else {
            long j4 = j - j2;
            o oVar2 = this.f4851a;
            do {
                oVar2 = oVar2.g;
                int i4 = oVar2.f4886c;
                i = oVar2.f4885b;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return oVar2.f4884a[i + ((int) j4)];
        }
    }

    @Override // com.bytedance.sdk.a.a.e
    public f c(long j) throws EOFException {
        return new f(g(j));
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c h(int i) {
        o oVarE = e(2);
        byte[] bArr = oVarE.f4884a;
        int i2 = oVarE.f4886c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        oVarE.f4886c = i3 + 1;
        this.f4852b += 2;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public byte[] g(long j) throws EOFException {
        u.a(this.f4852b, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            a(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    public final f f(int i) {
        if (i == 0) {
            return f.f4855b;
        }
        return new q(this, i);
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr) {
        if (bArr != null) {
            return c(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    o e(int i) {
        if (i >= 1 && i <= 8192) {
            o oVar = this.f4851a;
            if (oVar == null) {
                this.f4851a = p.a();
                o oVar2 = this.f4851a;
                oVar2.g = oVar2;
                oVar2.f4889f = oVar2;
                return oVar2;
            }
            o oVar3 = oVar.g;
            return (oVar3.f4886c + i > 8192 || !oVar3.f4888e) ? oVar3.a(p.a()) : oVar3;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.sdk.a.a.e
    public void h(long j) throws EOFException {
        while (j > 0) {
            if (this.f4851a != null) {
                int iMin = (int) Math.min(j, r0.f4886c - r0.f4885b);
                long j2 = iMin;
                this.f4852b -= j2;
                j -= j2;
                o oVar = this.f4851a;
                oVar.f4885b += iMin;
                if (oVar.f4885b == oVar.f4886c) {
                    this.f4851a = oVar.b();
                    p.a(oVar);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = i2;
            u.a(bArr.length, i, j);
            int i3 = i2 + i;
            while (i < i3) {
                o oVarE = e(1);
                int iMin = Math.min(i3 - i, 8192 - oVarE.f4886c);
                System.arraycopy(bArr, i, oVarE.f4884a, oVarE.f4886c, iMin);
                i += iMin;
                oVarE.f4886c += iMin;
            }
            this.f4852b += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public String a(long j, Charset charset) throws EOFException {
        u.a(this.f4852b, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        o oVar = this.f4851a;
        int i = oVar.f4885b;
        if (((long) i) + j > oVar.f4886c) {
            return new String(g(j), charset);
        }
        String str = new String(oVar.f4884a, i, (int) j, charset);
        oVar.f4885b = (int) (((long) oVar.f4885b) + j);
        this.f4852b -= j;
        if (oVar.f4885b == oVar.f4886c) {
            this.f4851a = oVar.b();
            p.a(oVar);
        }
        return str;
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public c l(long j) {
        if (j == 0) {
            return i(48);
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                return b("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        o oVarE = e(i);
        byte[] bArr = oVarE.f4884a;
        int i2 = oVarE.f4886c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f4850c[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        oVarE.f4886c += i;
        this.f4852b += (long) i;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public c k(long j) {
        if (j == 0) {
            return i(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        o oVarE = e(iNumberOfTrailingZeros);
        byte[] bArr = oVarE.f4884a;
        int i = oVarE.f4886c;
        for (int i2 = (i + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f4850c[(int) (15 & j)];
            j >>>= 4;
        }
        oVarE.f4886c += iNumberOfTrailingZeros;
        this.f4852b += (long) iNumberOfTrailingZeros;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c i(int i) {
        o oVarE = e(1);
        byte[] bArr = oVarE.f4884a;
        int i2 = oVarE.f4886c;
        oVarE.f4886c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f4852b++;
        return this;
    }

    @Override // com.bytedance.sdk.a.a.e
    public void a(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iA = a(bArr, i, bArr.length - i);
            if (iA == -1) {
                throw new EOFException();
            }
            i += iA;
        }
    }

    public int a(byte[] bArr, int i, int i2) {
        u.a(bArr.length, i, i2);
        o oVar = this.f4851a;
        if (oVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, oVar.f4886c - oVar.f4885b);
        System.arraycopy(oVar.f4884a, oVar.f4885b, bArr, i, iMin);
        oVar.f4885b += iMin;
        this.f4852b -= (long) iMin;
        if (oVar.f4885b == oVar.f4886c) {
            this.f4851a = oVar.b();
            p.a(oVar);
        }
        return iMin;
    }

    public c a(f fVar) {
        if (fVar != null) {
            fVar.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // com.bytedance.sdk.a.a.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c b(String str) {
        return a(str, 0, str.length());
    }

    public c a(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
            }
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (cCharAt < 128) {
                    o oVarE = e(1);
                    byte[] bArr = oVarE.f4884a;
                    int i3 = oVarE.f4886c - i;
                    int iMin = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                    while (i4 < iMin) {
                        char cCharAt2 = str.charAt(i4);
                        if (cCharAt2 >= 128) {
                            break;
                        }
                        bArr[i4 + i3] = (byte) cCharAt2;
                        i4++;
                    }
                    int i5 = oVarE.f4886c;
                    int i6 = (i3 + i4) - i5;
                    oVarE.f4886c = i5 + i6;
                    this.f4852b += (long) i6;
                    i = i4;
                } else {
                    if (cCharAt < 2048) {
                        i((cCharAt >> 6) | 192);
                        i((cCharAt & '?') | 128);
                    } else if (cCharAt >= 55296 && cCharAt <= 57343) {
                        int i7 = i + 1;
                        char cCharAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                        if (cCharAt <= 56319 && cCharAt3 >= 56320 && cCharAt3 <= 57343) {
                            int i8 = (((cCharAt & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                            i((i8 >> 18) | 240);
                            i(((i8 >> 12) & 63) | 128);
                            i(((i8 >> 6) & 63) | 128);
                            i((i8 & 63) | 128);
                            i += 2;
                        } else {
                            i(63);
                            i = i7;
                        }
                    } else {
                        i((cCharAt >> '\f') | 224);
                        i(((cCharAt >> 6) & 63) | 128);
                        i((cCharAt & '?') | 128);
                    }
                    i++;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public c a(int i) {
        if (i < 128) {
            i(i);
        } else if (i < 2048) {
            i((i >> 6) | 192);
            i((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                i(63);
            } else {
                i((i >> 12) | 224);
                i(((i >> 6) & 63) | 128);
                i((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            i((i >> 18) | 240);
            i(((i >> 12) & 63) | 128);
            i(((i >> 6) & 63) | 128);
            i((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public c a(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 >= i) {
            if (i2 <= str.length()) {
                if (charset != null) {
                    if (charset.equals(u.f4897a)) {
                        return a(str, i, i2);
                    }
                    byte[] bytes = str.substring(i, i2).getBytes(charset);
                    return c(bytes, 0, bytes.length);
                }
                throw new IllegalArgumentException("charset == null");
            }
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
    }

    public long a(s sVar) throws IOException {
        if (sVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long jA = sVar.a(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (jA == -1) {
                return j;
            }
            j += jA;
        }
    }

    @Override // com.bytedance.sdk.a.a.s
    public long a(c cVar, long j) {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j >= 0) {
            long j2 = this.f4852b;
            if (j2 == 0) {
                return -1L;
            }
            if (j > j2) {
                j = j2;
            }
            cVar.a_(this, j);
            return j;
        }
        throw new IllegalArgumentException("byteCount < 0: " + j);
    }

    @Override // com.bytedance.sdk.a.a.e
    public long a(byte b2) {
        return a(b2, 0L, Long.MAX_VALUE);
    }

    public long a(byte b2, long j, long j2) {
        o oVar;
        long j3 = 0;
        if (j >= 0 && j2 >= j) {
            long j4 = this.f4852b;
            if (j2 <= j4) {
                j4 = j2;
            }
            if (j == j4 || (oVar = this.f4851a) == null) {
                return -1L;
            }
            long j5 = this.f4852b;
            if (j5 - j >= j) {
                while (true) {
                    j5 = j3;
                    j3 = ((long) (oVar.f4886c - oVar.f4885b)) + j5;
                    if (j3 >= j) {
                        break;
                    }
                    oVar = oVar.f4889f;
                }
            } else {
                while (j5 > j) {
                    oVar = oVar.g;
                    j5 -= (long) (oVar.f4886c - oVar.f4885b);
                }
            }
            long j6 = j;
            while (j5 < j4) {
                byte[] bArr = oVar.f4884a;
                int iMin = (int) Math.min(oVar.f4886c, (((long) oVar.f4885b) + j4) - j5);
                for (int i = (int) ((((long) oVar.f4885b) + j6) - j5); i < iMin; i++) {
                    if (bArr[i] == b2) {
                        return ((long) (i - oVar.f4885b)) + j5;
                    }
                }
                j6 = ((long) (oVar.f4886c - oVar.f4885b)) + j5;
                oVar = oVar.f4889f;
                j5 = j6;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f4852b), Long.valueOf(j), Long.valueOf(j2)));
    }

    @Override // com.bytedance.sdk.a.a.r
    public t a() {
        return t.f4893c;
    }
}
