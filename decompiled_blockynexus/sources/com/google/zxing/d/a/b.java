package com.google.zxing.d.a;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: ByteMatrix.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f14435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14437c;

    public b(int i, int i2) {
        this.f14435a = (byte[][]) Array.newInstance((Class<?>) byte.class, i2, i);
        this.f14436b = i;
        this.f14437c = i2;
    }

    public byte a(int i, int i2) {
        return this.f14435a[i2][i];
    }

    public int b() {
        return this.f14437c;
    }

    public int c() {
        return this.f14436b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f14436b * 2 * this.f14437c) + 2);
        for (int i = 0; i < this.f14437c; i++) {
            byte[] bArr = this.f14435a[i];
            for (int i2 = 0; i2 < this.f14436b; i2++) {
                byte b2 = bArr[i2];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte[][] a() {
        return this.f14435a;
    }

    public void a(int i, int i2, int i3) {
        this.f14435a[i2][i] = (byte) i3;
    }

    public void a(int i, int i2, boolean z) {
        this.f14435a[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public void a(byte b2) {
        for (byte[] bArr : this.f14435a) {
            Arrays.fill(bArr, b2);
        }
    }
}
