package com.bytedance.sdk.a.b.a.e;

import java.util.Arrays;

/* JADX INFO: compiled from: Settings.java */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f5151b = new int[10];

    void a() {
        this.f5150a = 0;
        Arrays.fill(this.f5151b, 0);
    }

    int b(int i) {
        return this.f5151b[i];
    }

    int c() {
        if ((this.f5150a & 2) != 0) {
            return this.f5151b[1];
        }
        return -1;
    }

    int d(int i) {
        return (this.f5150a & 32) != 0 ? this.f5151b[5] : i;
    }

    int b() {
        return Integer.bitCount(this.f5150a);
    }

    int c(int i) {
        return (this.f5150a & 16) != 0 ? this.f5151b[4] : i;
    }

    int d() {
        if ((this.f5150a & 128) != 0) {
            return this.f5151b[7];
        }
        return 65535;
    }

    n a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f5151b;
            if (i < iArr.length) {
                this.f5150a = (1 << i) | this.f5150a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    boolean a(int i) {
        return ((1 << i) & this.f5150a) != 0;
    }

    void a(n nVar) {
        for (int i = 0; i < 10; i++) {
            if (nVar.a(i)) {
                a(i, nVar.b(i));
            }
        }
    }
}
