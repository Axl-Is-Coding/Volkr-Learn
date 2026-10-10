package com.google.zxing.pdf417.encoder;

/* JADX INFO: compiled from: BarcodeRow.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f14496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14497b = 0;

    b(int i) {
        this.f14496a = new byte[i];
    }

    private void a(int i, boolean z) {
        this.f14496a[i] = z ? (byte) 1 : (byte) 0;
    }

    void a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f14497b;
            this.f14497b = i3 + 1;
            a(i3, z);
        }
    }

    byte[] a(int i) {
        byte[] bArr = new byte[this.f14496a.length * i];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.f14496a[i2 / i];
        }
        return bArr;
    }
}
