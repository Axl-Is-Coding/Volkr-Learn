package com.google.zxing.common.reedsolomon;

/* JADX INFO: compiled from: GenericGFPoly.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f14429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f14430b;

    b(a aVar, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f14429a = aVar;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f14430b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f14430b = new int[]{0};
            return;
        }
        this.f14430b = new int[length - i];
        int[] iArr2 = this.f14430b;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    int[] a() {
        return this.f14430b;
    }

    int b() {
        return this.f14430b.length - 1;
    }

    boolean c() {
        return this.f14430b[0] == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(b() * 8);
        for (int iB = b(); iB >= 0; iB--) {
            int iA = a(iB);
            if (iA != 0) {
                if (iA < 0) {
                    sb.append(" - ");
                    iA = -iA;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iB == 0 || iA != 1) {
                    int iC = this.f14429a.c(iA);
                    if (iC == 0) {
                        sb.append('1');
                    } else if (iC == 1) {
                        sb.append('a');
                    } else {
                        sb.append("a^");
                        sb.append(iC);
                    }
                }
                if (iB != 0) {
                    if (iB == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iB);
                    }
                }
            }
        }
        return sb.toString();
    }

    int a(int i) {
        return this.f14430b[(r0.length - 1) - i];
    }

    b[] b(b bVar) {
        if (!this.f14429a.equals(bVar.f14429a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (bVar.c()) {
            throw new IllegalArgumentException("Divide by 0");
        }
        b bVarB = this.f14429a.b();
        int iB = this.f14429a.b(bVar.a(bVar.b()));
        b bVarA = bVarB;
        b bVarA2 = this;
        while (bVarA2.b() >= bVar.b() && !bVarA2.c()) {
            int iB2 = bVarA2.b() - bVar.b();
            int iC = this.f14429a.c(bVarA2.a(bVarA2.b()), iB);
            b bVarA3 = bVar.a(iB2, iC);
            bVarA = bVarA.a(this.f14429a.b(iB2, iC));
            bVarA2 = bVarA2.a(bVarA3);
        }
        return new b[]{bVarA, bVarA2};
    }

    b c(b bVar) {
        if (!this.f14429a.equals(bVar.f14429a)) {
            throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if (c() || bVar.c()) {
            return this.f14429a.b();
        }
        int[] iArr = this.f14430b;
        int length = iArr.length;
        int[] iArr2 = bVar.f14430b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                iArr3[i4] = a.a(iArr3[i4], this.f14429a.c(i2, iArr2[i3]));
            }
        }
        return new b(this.f14429a, iArr3);
    }

    b a(b bVar) {
        if (this.f14429a.equals(bVar.f14429a)) {
            if (c()) {
                return bVar;
            }
            if (bVar.c()) {
                return this;
            }
            int[] iArr = this.f14430b;
            int[] iArr2 = bVar.f14430b;
            if (iArr.length > iArr2.length) {
                iArr = iArr2;
                iArr2 = iArr;
            }
            int[] iArr3 = new int[iArr2.length];
            int length = iArr2.length - iArr.length;
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            for (int i = length; i < iArr2.length; i++) {
                iArr3[i] = a.a(iArr[i - length], iArr2[i]);
            }
            return new b(this.f14429a, iArr3);
        }
        throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }

    b a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f14429a.b();
        }
        int length = this.f14430b.length;
        int[] iArr = new int[i + length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = this.f14429a.c(this.f14430b[i3], i2);
        }
        return new b(this.f14429a, iArr);
    }
}
