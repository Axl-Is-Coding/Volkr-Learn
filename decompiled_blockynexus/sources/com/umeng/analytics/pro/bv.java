package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: classes5.dex */
public class bv extends cb {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final cg f20741d = new cg("");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final bw f20742e = new bw("", (byte) 0, 0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f20743f = new byte[16];
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f20744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    byte[] f20745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    byte[] f20746c;
    private ba m;
    private short n;
    private bw o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* JADX INFO: compiled from: TCompactProtocol.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f20748a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final byte f20749b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final byte f20750c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final byte f20751d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final byte f20752e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte f20753f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    static {
        byte[] bArr = f20743f;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    public bv(cp cpVar, long j2) {
        super(cpVar);
        this.m = new ba(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.f20744a = new byte[5];
        this.f20745b = new byte[10];
        this.r = new byte[1];
        this.f20746c = new byte[1];
        this.q = j2;
    }

    private int E() throws bi {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & 127) << i4;
                if ((b2 & 128) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & 127) << i5;
                if ((bU & 128) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bi {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                j2 |= ((long) (b2 & 127)) << i3;
                if ((b2 & 128) != 128) {
                    break;
                }
                i3 += 7;
                i2++;
            }
            this.g.a(i2 + 1);
        } else {
            while (true) {
                byte bU = u();
                j2 |= ((long) (bU & 127)) << i2;
                if ((bU & 128) != 128) {
                    break;
                }
                i2 += 7;
            }
        }
        return j2;
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & ci.m;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) throws bi {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws cc {
        if (i2 < 0) {
            throw new cc("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new cc("Length exceeded max allowed: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.cb
    public ByteBuffer A() throws bi {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cb
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cb
    public void a() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(bz bzVar) throws bi {
        b(h);
        d(((bzVar.f20763b << 5) & (-32)) | 1);
        b(bzVar.f20764c);
        a(bzVar.f20762a);
    }

    @Override // com.umeng.analytics.pro.cb
    public void b() throws bi {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.cb
    public void c() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public void d() throws bi {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cb
    public void e() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public void f() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public void g() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public bz h() throws bi {
        byte bU = u();
        if (bU != -126) {
            throw new cc("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & j);
        if (b2 == 1) {
            return new bz(z(), (byte) ((bU2 >> 5) & 3), E());
        }
        throw new cc("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.cb
    public void i() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public cg j() throws bi {
        this.m.a(this.n);
        this.n = (short) 0;
        return f20741d;
    }

    @Override // com.umeng.analytics.pro.cb
    public void k() throws bi {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.cb
    public bw l() throws bi {
        byte bU = u();
        if (bU == 0) {
            return f20742e;
        }
        short s = (short) ((bU & 240) >> 4);
        short sV = s == 0 ? v() : (short) (this.n + s);
        byte b2 = (byte) (bU & ci.m);
        bw bwVar = new bw("", d(b2), sV);
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bwVar.f20756c;
        return bwVar;
    }

    @Override // com.umeng.analytics.pro.cb
    public void m() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public by n() throws bi {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new by(d((byte) (bU >> 4)), d((byte) (bU & ci.m)), iE);
    }

    @Override // com.umeng.analytics.pro.cb
    public void o() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public bx p() throws bi {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new bx(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.cb
    public void q() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public cf r() throws bi {
        return new cf(p());
    }

    @Override // com.umeng.analytics.pro.cb
    public void s() throws bi {
    }

    @Override // com.umeng.analytics.pro.cb
    public boolean t() throws bi {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.cb
    public byte u() throws bi {
        if (this.g.h() <= 0) {
            this.g.d(this.f20746c, 0, 1);
            return this.f20746c[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.cb
    public short v() throws bi {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.cb
    public int w() throws bi {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.cb
    public long x() throws bi {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.cb
    public double y() throws bi {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.cb
    public String z() throws bi {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.g.h() < iE) {
                return new String(e(iE), "UTF-8");
            }
            String str = new String(this.g.f(), this.g.g(), iE, "UTF-8");
            this.g.a(iE);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bi("UTF-8 not supported!");
        }
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class a implements cd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f20747a;

        public a() {
            this.f20747a = -1L;
        }

        @Override // com.umeng.analytics.pro.cd
        public cb a(cp cpVar) {
            return new bv(cpVar, this.f20747a);
        }

        public a(int i) {
            this.f20747a = i;
        }
    }

    private void b(int i2) throws bi {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.f20744a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.f20744a;
        bArr[i3] = (byte) i2;
        this.g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) throws bi {
        b((byte) i2);
    }

    private byte d(byte b2) throws cc {
        byte b3 = (byte) (b2 & ci.m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return ci.m;
            case 10:
                return ci.l;
            case 11:
                return ci.k;
            case 12:
                return (byte) 12;
            default:
                throw new cc("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f20743f[b2];
    }

    private void b(long j2) throws bi {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.f20745b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.f20745b;
        bArr[i2] = (byte) j2;
        this.g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(cg cgVar) throws bi {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(bw bwVar) throws bi {
        if (bwVar.f20755b == 2) {
            this.o = bwVar;
        } else {
            a(bwVar, (byte) -1);
        }
    }

    private void b(byte b2) throws bi {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.g.b(bArr);
    }

    private void a(bw bwVar, byte b2) throws bi {
        if (b2 == -1) {
            b2 = e(bwVar.f20755b);
        }
        short s = bwVar.f20756c;
        short s2 = this.n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(bwVar.f20756c);
        }
        this.n = bwVar.f20756c;
    }

    public bv(cp cpVar) {
        this(cpVar, -1L);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(by byVar) throws bi {
        int i2 = byVar.f20761c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(byVar.f20760b) | (e(byVar.f20759a) << 4));
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(bx bxVar) throws bi {
        a(bxVar.f20757a, bxVar.f20758b);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(cf cfVar) throws bi {
        a(cfVar.f20831a, cfVar.f20832b);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(boolean z) throws bi {
        bw bwVar = this.o;
        if (bwVar != null) {
            a(bwVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(byte b2) throws bi {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(short s) throws bi {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(int i2) throws bi {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(long j2) throws bi {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(double d2) throws bi {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(String str) throws bi {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bi("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(ByteBuffer byteBuffer) throws bi {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bi {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bi {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }
}
