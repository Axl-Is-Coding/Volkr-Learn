package com.google.zxing.a.a;

/* JADX INFO: compiled from: SimpleToken.java */
/* JADX INFO: loaded from: classes2.dex */
final class f extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f14407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f14408d;

    f(h hVar, int i, int i2) {
        super(hVar);
        this.f14407c = (short) i;
        this.f14408d = (short) i2;
    }

    @Override // com.google.zxing.a.a.h
    void a(com.google.zxing.common.a aVar, byte[] bArr) {
        aVar.a(this.f14407c, this.f14408d);
    }

    public String toString() {
        short s = this.f14407c;
        short s2 = this.f14408d;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f14408d)).substring(1) + '>';
    }
}
