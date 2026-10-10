package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: classes5.dex */
public class bu extends cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final int f20732a = -65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final int f20733b = -2147418112;
    private static final cg h = new cg();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f20734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f20735d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f20736e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f20737f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class a implements cd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f20738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f20739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f20740c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.cd
        public cb a(cp cpVar) {
            bu buVar = new bu(cpVar, this.f20738a, this.f20739b);
            int i = this.f20740c;
            if (i != 0) {
                buVar.c(i);
            }
            return buVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f20738a = false;
            this.f20739b = true;
            this.f20738a = z;
            this.f20739b = z2;
            this.f20740c = i;
        }
    }

    public bu(cp cpVar) {
        this(cpVar, false, true);
    }

    @Override // com.umeng.analytics.pro.cb
    public ByteBuffer A() throws bi {
        int iW = w();
        d(iW);
        if (this.g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.g.f(), this.g.g(), iW);
            this.g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(bz bzVar) throws bi {
        if (this.f20735d) {
            a(f20733b | bzVar.f20763b);
            a(bzVar.f20762a);
            a(bzVar.f20764c);
        } else {
            a(bzVar.f20762a);
            a(bzVar.f20763b);
            a(bzVar.f20764c);
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(cg cgVar) {
    }

    public String b(int i) throws bi {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bi("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cb
    public void c() {
    }

    public void c(int i) {
        this.f20736e = i;
        this.f20737f = true;
    }

    @Override // com.umeng.analytics.pro.cb
    public void d() throws bi {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cb
    public void e() {
    }

    @Override // com.umeng.analytics.pro.cb
    public void f() {
    }

    @Override // com.umeng.analytics.pro.cb
    public void g() {
    }

    @Override // com.umeng.analytics.pro.cb
    public bz h() throws bi {
        int iW = w();
        if (iW < 0) {
            if ((f20732a & iW) == f20733b) {
                return new bz(z(), (byte) (iW & 255), w());
            }
            throw new cc(4, "Bad version in readMessageBegin");
        }
        if (this.f20734c) {
            throw new cc(4, "Missing version in readMessageBegin, old client?");
        }
        return new bz(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.cb
    public void i() {
    }

    @Override // com.umeng.analytics.pro.cb
    public cg j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.cb
    public void k() {
    }

    @Override // com.umeng.analytics.pro.cb
    public bw l() throws bi {
        byte bU = u();
        return new bw("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.cb
    public void m() {
    }

    @Override // com.umeng.analytics.pro.cb
    public by n() throws bi {
        return new by(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.cb
    public void o() {
    }

    @Override // com.umeng.analytics.pro.cb
    public bx p() throws bi {
        return new bx(u(), w());
    }

    @Override // com.umeng.analytics.pro.cb
    public void q() {
    }

    @Override // com.umeng.analytics.pro.cb
    public cf r() throws bi {
        return new cf(u(), w());
    }

    @Override // com.umeng.analytics.pro.cb
    public void s() {
    }

    @Override // com.umeng.analytics.pro.cb
    public boolean t() throws bi {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.cb
    public byte u() throws bi {
        if (this.g.h() < 1) {
            a(this.m, 0, 1);
            return this.m[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.cb
    public short v() throws bi {
        byte[] bArrF = this.n;
        int iG = 0;
        if (this.g.h() >= 2) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArrF[iG + 1] & 255) | ((bArrF[iG] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.cb
    public int w() throws bi {
        byte[] bArrF = this.o;
        int iG = 0;
        if (this.g.h() >= 4) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArrF[iG + 3] & 255) | ((bArrF[iG] & 255) << 24) | ((bArrF[iG + 1] & 255) << 16) | ((bArrF[iG + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.cb
    public long x() throws bi {
        byte[] bArrF = this.p;
        int iG = 0;
        if (this.g.h() >= 8) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return ((long) (bArrF[iG + 7] & 255)) | (((long) (bArrF[iG] & 255)) << 56) | (((long) (bArrF[iG + 1] & 255)) << 48) | (((long) (bArrF[iG + 2] & 255)) << 40) | (((long) (bArrF[iG + 3] & 255)) << 32) | (((long) (bArrF[iG + 4] & 255)) << 24) | (((long) (bArrF[iG + 5] & 255)) << 16) | (((long) (bArrF[iG + 6] & 255)) << 8);
    }

    @Override // com.umeng.analytics.pro.cb
    public double y() throws bi {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.cb
    public String z() throws bi {
        int iW = w();
        if (this.g.h() < iW) {
            return b(iW);
        }
        try {
            String str = new String(this.g.f(), this.g.g(), iW, "UTF-8");
            this.g.a(iW);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bi("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public bu(cp cpVar, boolean z, boolean z2) {
        super(cpVar);
        this.f20734c = false;
        this.f20735d = true;
        this.f20737f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.f20734c = z;
        this.f20735d = z2;
    }

    protected void d(int i) throws bi {
        if (i < 0) {
            throw new cc("Negative length: " + i);
        }
        if (this.f20737f) {
            this.f20736e -= i;
            if (this.f20736e >= 0) {
                return;
            }
            throw new cc("Message length exceeded: " + i);
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(bw bwVar) throws bi {
        a(bwVar.f20755b);
        a(bwVar.f20756c);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(by byVar) throws bi {
        a(byVar.f20759a);
        a(byVar.f20760b);
        a(byVar.f20761c);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(bx bxVar) throws bi {
        a(bxVar.f20757a);
        a(bxVar.f20758b);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(cf cfVar) throws bi {
        a(cfVar.f20831a);
        a(cfVar.f20832b);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(boolean z) throws bi {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(byte b2) throws bi {
        byte[] bArr = this.i;
        bArr[0] = b2;
        this.g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(short s) throws bi {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(int i) throws bi {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(long j) throws bi {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(double d2) throws bi {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(String str) throws bi {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bi("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cb
    public void a(ByteBuffer byteBuffer) throws bi {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    private int a(byte[] bArr, int i, int i2) throws bi {
        d(i2);
        return this.g.d(bArr, i, i2);
    }
}
