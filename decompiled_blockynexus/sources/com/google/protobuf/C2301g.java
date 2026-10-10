package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.google.protobuf.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CodedInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2301g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f14349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f14351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final InputStream f14354f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private a n;

    /* JADX INFO: renamed from: com.google.protobuf.g$a */
    /* JADX INFO: compiled from: CodedInputStream.java */
    private interface a {
        void a();
    }

    private C2301g(byte[] bArr, int i, int i2, boolean z) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 100;
        this.m = 67108864;
        this.n = null;
        this.f14349a = bArr;
        this.f14351c = i2 + i;
        this.f14353e = i;
        this.i = -i;
        this.f14354f = null;
        this.f14350b = z;
    }

    public static C2301g a(InputStream inputStream) {
        return new C2301g(inputStream, 4096);
    }

    private boolean j(int i) throws IOException {
        int i2 = this.f14353e;
        if (i2 + i <= this.f14351c) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
        if (this.i + i2 + i > this.j) {
            return false;
        }
        a aVar = this.n;
        if (aVar != null) {
            aVar.a();
        }
        if (this.f14354f != null) {
            int i3 = this.f14353e;
            if (i3 > 0) {
                int i4 = this.f14351c;
                if (i4 > i3) {
                    byte[] bArr = this.f14349a;
                    System.arraycopy(bArr, i3, bArr, 0, i4 - i3);
                }
                this.i += i3;
                this.f14351c -= i3;
                this.f14353e = 0;
            }
            InputStream inputStream = this.f14354f;
            byte[] bArr2 = this.f14349a;
            int i5 = this.f14351c;
            int i6 = inputStream.read(bArr2, i5, bArr2.length - i5);
            if (i6 == 0 || i6 < -1 || i6 > this.f14349a.length) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + i6 + "\nThe InputStream implementation is buggy.");
            }
            if (i6 > 0) {
                this.f14351c += i6;
                if ((this.i + i) - this.m > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                t();
                if (this.f14351c >= i) {
                    return true;
                }
                return j(i);
            }
        }
        return false;
    }

    private void t() {
        this.f14351c += this.f14352d;
        int i = this.i;
        int i2 = this.f14351c;
        int i3 = i + i2;
        int i4 = this.j;
        if (i3 <= i4) {
            this.f14352d = 0;
        } else {
            this.f14352d = i3 - i4;
            this.f14351c = i2 - this.f14352d;
        }
    }

    private void u() throws IOException {
        int i = this.f14351c;
        int i2 = this.f14353e;
        if (i - i2 >= 10) {
            byte[] bArr = this.f14349a;
            int i3 = 0;
            while (i3 < 10) {
                int i4 = i2 + 1;
                if (bArr[i2] >= 0) {
                    this.f14353e = i4;
                    return;
                } else {
                    i3++;
                    i2 = i4;
                }
            }
        }
        v();
    }

    private void v() throws IOException {
        for (int i = 0; i < 10; i++) {
            if (j() >= 0) {
                return;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public void b(int i) {
        this.j = i;
        t();
    }

    public boolean c() throws IOException {
        return n() != 0;
    }

    public ByteString d() throws IOException {
        int iM = m();
        int i = this.f14351c;
        int i2 = this.f14353e;
        if (iM > i - i2 || iM <= 0) {
            return iM == 0 ? ByteString.EMPTY : ByteString.wrap(g(iM));
        }
        ByteString byteStringWrap = (this.f14350b && this.h) ? ByteString.wrap(this.f14349a, i2, iM) : ByteString.copyFrom(this.f14349a, this.f14353e, iM);
        this.f14353e += iM;
        return byteStringWrap;
    }

    public boolean e(int i) throws IOException {
        int iB = WireFormat.b(i);
        if (iB == 0) {
            u();
            return true;
        }
        if (iB == 1) {
            f(8);
            return true;
        }
        if (iB == 2) {
            f(m());
            return true;
        }
        if (iB == 3) {
            s();
            a(WireFormat.a(WireFormat.a(i), 4));
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        f(4);
        return true;
    }

    public int f() throws IOException {
        return k();
    }

    public long g() throws IOException {
        return l();
    }

    public int h() throws IOException {
        return m();
    }

    public long i() throws IOException {
        return n();
    }

    public int k() throws IOException {
        int i = this.f14353e;
        if (this.f14351c - i < 4) {
            h(4);
            i = this.f14353e;
        }
        byte[] bArr = this.f14349a;
        this.f14353e = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public long l() throws IOException {
        int i = this.f14353e;
        if (this.f14351c - i < 8) {
            h(8);
            i = this.f14353e;
        }
        byte[] bArr = this.f14349a;
        this.f14353e = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
    
        if (r2[r3] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int m() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f14353e
            int r1 = r5.f14351c
            if (r1 != r0) goto L7
            goto L6a
        L7:
            byte[] r2 = r5.f14349a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.f14353e = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L18
            goto L6a
        L18:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L24
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L70
        L24:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L31
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2f:
            r1 = r3
            goto L70
        L31:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3f
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L70
        L3f:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L70
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2f
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L70
        L6a:
            long r0 = r5.o()
            int r1 = (int) r0
            return r1
        L70:
            r5.f14353e = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C2301g.m():int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b4, code lost:
    
        if (r2[r0] < 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long n() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f14353e
            int r1 = r11.f14351c
            if (r1 != r0) goto L8
            goto Lb6
        L8:
            byte[] r2 = r11.f14349a
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L14
            r11.f14353e = r3
            long r0 = (long) r0
            return r0
        L14:
            int r1 = r1 - r3
            r4 = 9
            if (r1 >= r4) goto L1b
            goto Lb6
        L1b:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L2a
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
        L26:
            long r2 = (long) r0
            r3 = r2
            goto Lbb
        L2a:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L3b
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r3 = r9
            goto Lbb
        L3b:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L49
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L26
        L49:
            long r3 = (long) r0
            int r0 = r1 + 1
            r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L60
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L5c:
            long r1 = r1 ^ r3
            r3 = r1
        L5e:
            r1 = r0
            goto Lbb
        L60:
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L74
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L72:
            long r3 = r3 ^ r5
            goto Lbb
        L74:
            int r0 = r1 + 1
            r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L87
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L5c
        L87:
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L9a
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L72
        L9a:
            int r0 = r1 + 1
            r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L5e
            int r1 = r0 + 1
            r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto Lbb
        Lb6:
            long r0 = r11.o()
            return r0
        Lbb:
            r11.f14353e = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C2301g.n():long");
    }

    long o() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bJ = j();
            j |= ((long) (bJ & 127)) << i;
            if ((bJ & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public String p() throws IOException {
        byte[] bArrG;
        int iM = m();
        int i = this.f14353e;
        int i2 = 0;
        if (iM <= this.f14351c - i && iM > 0) {
            bArrG = this.f14349a;
            this.f14353e = i + iM;
            i2 = i;
        } else {
            if (iM == 0) {
                return "";
            }
            if (iM <= this.f14351c) {
                h(iM);
                bArrG = this.f14349a;
                this.f14353e = iM + 0;
            } else {
                bArrG = g(iM);
            }
        }
        if (Utf8.b(bArrG, i2, i2 + iM)) {
            return new String(bArrG, i2, iM, r.f14375a);
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

    public int q() throws IOException {
        if (b()) {
            this.g = 0;
            return 0;
        }
        this.g = m();
        if (WireFormat.a(this.g) != 0) {
            return this.g;
        }
        throw InvalidProtocolBufferException.invalidTag();
    }

    public long r() throws IOException {
        return n();
    }

    public void s() throws IOException {
        int iQ;
        do {
            iQ = q();
            if (iQ == 0) {
                return;
            }
        } while (e(iQ));
    }

    public static C2301g a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    private byte[] g(int i) throws IOException {
        if (i <= 0) {
            if (i == 0) {
                return r.f14377c;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.i;
        int i3 = this.f14353e;
        int i4 = i2 + i3 + i;
        if (i4 > this.m) {
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }
        int i5 = this.j;
        if (i4 > i5) {
            f((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        InputStream inputStream = this.f14354f;
        if (inputStream == null) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = this.f14351c;
        int length = i6 - i3;
        this.i = i2 + i6;
        this.f14353e = 0;
        this.f14351c = 0;
        int length2 = i - length;
        if (length2 < 4096 || length2 <= inputStream.available()) {
            byte[] bArr = new byte[i];
            System.arraycopy(this.f14349a, i3, bArr, 0, length);
            while (length < bArr.length) {
                int i7 = this.f14354f.read(bArr, length, i - length);
                if (i7 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.i += i7;
                length += i7;
            }
            return bArr;
        }
        ArrayList<byte[]> arrayList = new ArrayList();
        while (length2 > 0) {
            byte[] bArr2 = new byte[Math.min(length2, 4096)];
            int i8 = 0;
            while (i8 < bArr2.length) {
                int i9 = this.f14354f.read(bArr2, i8, bArr2.length - i8);
                if (i9 == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.i += i9;
                i8 += i9;
            }
            length2 -= bArr2.length;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i];
        System.arraycopy(this.f14349a, i3, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    private void h(int i) throws IOException {
        if (!j(i)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void i(int i) throws IOException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = this.i;
        int i3 = this.f14353e;
        int i4 = i2 + i3 + i;
        int i5 = this.j;
        if (i4 > i5) {
            f((i5 - i2) - i3);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i6 = this.f14351c;
        int i7 = i6 - i3;
        this.f14353e = i6;
        h(1);
        while (true) {
            int i8 = i - i7;
            int i9 = this.f14351c;
            if (i8 <= i9) {
                this.f14353e = i8;
                return;
            } else {
                i7 += i9;
                this.f14353e = i9;
                h(1);
            }
        }
    }

    public int c(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i2 = i + this.i + this.f14353e;
        int i3 = this.j;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.j = i2;
        t();
        return i3;
    }

    public void f(int i) throws IOException {
        int i2 = this.f14351c;
        int i3 = this.f14353e;
        if (i > i2 - i3 || i < 0) {
            i(i);
        } else {
            this.f14353e = i3 + i;
        }
    }

    public static C2301g a(byte[] bArr, int i, int i2) {
        return a(bArr, i, i2, false);
    }

    public boolean b() throws IOException {
        return this.f14353e == this.f14351c && !j(1);
    }

    static C2301g a(byte[] bArr, int i, int i2, boolean z) {
        C2301g c2301g = new C2301g(bArr, i, i2, z);
        try {
            c2301g.c(i2);
            return c2301g;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public void a(int i) throws InvalidProtocolBufferException {
        if (this.g != i) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public <T extends x> T a(A<T> a2, C2306l c2306l) throws IOException {
        int iM = m();
        if (this.k < this.l) {
            int iC = c(iM);
            this.k++;
            T tB = a2.b(this, c2306l);
            a(0);
            this.k--;
            b(iC);
            return tB;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public int d(int i) {
        if (i >= 0) {
            int i2 = this.m;
            this.m = i;
            return i2;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i);
    }

    public int e() throws IOException {
        return m();
    }

    private C2301g(InputStream inputStream, int i) {
        this.h = false;
        this.j = Integer.MAX_VALUE;
        this.l = 100;
        this.m = 67108864;
        this.n = null;
        this.f14349a = new byte[i];
        this.f14353e = 0;
        this.i = 0;
        this.f14354f = inputStream;
        this.f14350b = false;
    }

    public static int a(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public byte j() throws IOException {
        if (this.f14353e == this.f14351c) {
            h(1);
        }
        byte[] bArr = this.f14349a;
        int i = this.f14353e;
        this.f14353e = i + 1;
        return bArr[i];
    }

    public int a() {
        int i = this.j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.i + this.f14353e);
    }
}
