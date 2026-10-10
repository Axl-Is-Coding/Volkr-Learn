package com.google.zxing.common;

import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.Arrays;

/* JADX INFO: compiled from: BitMatrix.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f14422d;

    public b(int i) {
        this(i, i);
    }

    public boolean a(int i, int i2) {
        return ((this.f14422d[(i2 * this.f14421c) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public void b(int i, int i2) {
        int i3 = (i2 * this.f14421c) + (i / 32);
        int[] iArr = this.f14422d;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public int c() {
        return this.f14420b;
    }

    public int d() {
        return this.f14419a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14419a == bVar.f14419a && this.f14420b == bVar.f14420b && this.f14421c == bVar.f14421c && Arrays.equals(this.f14422d, bVar.f14422d);
    }

    public int hashCode() {
        int i = this.f14419a;
        return (((((((i * 31) + i) * 31) + this.f14420b) * 31) + this.f14421c) * 31) + Arrays.hashCode(this.f14422d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f14419a = i;
        this.f14420b = i2;
        this.f14421c = (i + 31) / 32;
        this.f14422d = new int[this.f14421c * i2];
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public b m80clone() {
        return new b(this.f14419a, this.f14420b, this.f14421c, (int[]) this.f14422d.clone());
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 > 0 && i3 > 0) {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.f14420b || i5 > this.f14419a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.f14421c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.f14422d;
                    int i9 = (i8 / 32) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public void b() {
        int length = this.f14422d.length;
        for (int i = 0; i < length; i++) {
            this.f14422d[i] = 0;
        }
    }

    private b(int i, int i2, int i3, int[] iArr) {
        this.f14419a = i;
        this.f14420b = i2;
        this.f14421c = i3;
        this.f14422d = iArr;
    }

    public String a(String str, String str2) {
        return a(str, str2, UMCustomLogInfoBuilder.LINE_SEP);
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f14420b * (this.f14419a + 1));
        for (int i = 0; i < this.f14420b; i++) {
            for (int i2 = 0; i2 < this.f14419a; i2++) {
                sb.append(a(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
