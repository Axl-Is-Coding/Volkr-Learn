package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMemoryInputTransport.java */
/* JADX INFO: loaded from: classes5.dex */
public final class co extends cp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f20842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20844c;

    public co() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cp
    public void b() throws cq {
    }

    @Override // com.umeng.analytics.pro.cp
    public void b(byte[] bArr, int i, int i2) throws cq {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.cp
    public void c() {
    }

    public void c(byte[] bArr, int i, int i2) {
        this.f20842a = bArr;
        this.f20843b = i;
        this.f20844c = i + i2;
    }

    public void e() {
        this.f20842a = null;
    }

    @Override // com.umeng.analytics.pro.cp
    public byte[] f() {
        return this.f20842a;
    }

    @Override // com.umeng.analytics.pro.cp
    public int g() {
        return this.f20843b;
    }

    @Override // com.umeng.analytics.pro.cp
    public int h() {
        return this.f20844c - this.f20843b;
    }

    public co(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public int a(byte[] bArr, int i, int i2) throws cq {
        int iH = h();
        if (i2 > iH) {
            i2 = iH;
        }
        if (i2 > 0) {
            System.arraycopy(this.f20842a, this.f20843b, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    public co(byte[] bArr, int i, int i2) {
        c(bArr, i, i2);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(int i) {
        this.f20843b += i;
    }
}
