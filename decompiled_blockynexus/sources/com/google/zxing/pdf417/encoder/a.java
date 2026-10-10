package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: BarcodeMatrix.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b[] f14492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f14495d;

    a(int i, int i2) {
        this.f14492a = new b[i];
        int length = this.f14492a.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f14492a[i3] = new b(((i2 + 4) * 17) + 1);
        }
        this.f14495d = i2 * 17;
        this.f14494c = i;
        this.f14493b = -1;
    }

    b a() {
        return this.f14492a[this.f14493b];
    }

    void b() {
        this.f14493b++;
    }

    public byte[][] a(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f14494c * i2, this.f14495d * i);
        int i3 = this.f14494c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f14492a[i4 / i2].a(i);
        }
        return bArr;
    }
}
