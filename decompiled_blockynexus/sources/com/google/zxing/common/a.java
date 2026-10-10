package com.google.zxing.common;

import java.util.Arrays;

/* JADX INFO: compiled from: BitArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f14417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14418b;

    public a() {
        this.f14418b = 0;
        this.f14417a = new int[1];
    }

    public boolean a(int i) {
        return ((1 << (i & 31)) & this.f14417a[i / 32]) != 0;
    }

    public int b() {
        return this.f14418b;
    }

    public int c() {
        return (this.f14418b + 7) / 8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14418b == aVar.f14418b && Arrays.equals(this.f14417a, aVar.f14417a);
    }

    public int hashCode() {
        return (this.f14418b * 31) + Arrays.hashCode(this.f14417a);
    }

    public String toString() {
        int i = this.f14418b;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.f14418b; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(a(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    private void b(int i) {
        if (i > (this.f14417a.length << 5)) {
            int[] iArrC = c(i);
            int[] iArr = this.f14417a;
            System.arraycopy(iArr, 0, iArrC, 0, iArr.length);
            this.f14417a = iArrC;
        }
    }

    private static int[] c(int i) {
        return new int[(i + 31) / 32];
    }

    public void a(boolean z) {
        b(this.f14418b + 1);
        if (z) {
            int[] iArr = this.f14417a;
            int i = this.f14418b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f14418b++;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a m79clone() {
        return new a((int[]) this.f14417a.clone(), this.f14418b);
    }

    a(int[] iArr, int i) {
        this.f14417a = iArr;
        this.f14418b = i;
    }

    public void a(int i, int i2) {
        if (i2 >= 0 && i2 <= 32) {
            b(this.f14418b + i2);
            while (i2 > 0) {
                boolean z = true;
                if (((i >> (i2 - 1)) & 1) != 1) {
                    z = false;
                }
                a(z);
                i2--;
            }
            return;
        }
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void b(a aVar) {
        if (this.f14418b != aVar.f14418b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f14417a;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ aVar.f14417a[i];
            i++;
        }
    }

    public void a(a aVar) {
        int i = aVar.f14418b;
        b(this.f14418b + i);
        for (int i2 = 0; i2 < i; i2++) {
            a(aVar.a(i2));
        }
    }

    public void a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i4;
            int i7 = 0;
            for (int i8 = 0; i8 < 8; i8++) {
                if (a(i6)) {
                    i7 |= 1 << (7 - i8);
                }
                i6++;
            }
            bArr[i2 + i5] = (byte) i7;
            i5++;
            i4 = i6;
        }
    }
}
