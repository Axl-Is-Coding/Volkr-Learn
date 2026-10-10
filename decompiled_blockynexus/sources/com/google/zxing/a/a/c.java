package com.google.zxing.a.a;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f14400a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public static a a(byte[] bArr, int i, int i2) {
        int i3;
        com.google.zxing.common.a aVarA;
        com.google.zxing.common.a aVarA2;
        boolean z;
        int iAbs;
        int iA;
        int i4;
        com.google.zxing.common.a aVarA3 = new e(bArr).a();
        int iB = ((aVarA3.b() * i) / 100) + 11;
        int iB2 = aVarA3.b() + iB;
        int i5 = 0;
        int i6 = 1;
        if (i2 == 0) {
            com.google.zxing.common.a aVar = null;
            int i7 = 0;
            int i8 = 0;
            while (i7 <= 32) {
                boolean z2 = i7 <= 3;
                int i9 = z2 ? i7 + 1 : i7;
                int iA2 = a(i9, z2);
                if (iB2 <= iA2) {
                    if (aVar == null || i8 != f14400a[i9]) {
                        i3 = f14400a[i9];
                        aVarA = a(aVarA3, i3);
                    } else {
                        int i10 = i8;
                        aVarA = aVar;
                        i3 = i10;
                    }
                    int i11 = iA2 - (iA2 % i3);
                    if ((!z2 || aVarA.b() <= (i3 << 6)) && aVarA.b() + iB <= i11) {
                        aVarA2 = aVarA;
                        z = z2;
                        iAbs = i9;
                        iA = iA2;
                    } else {
                        com.google.zxing.common.a aVar2 = aVarA;
                        i8 = i3;
                        aVar = aVar2;
                    }
                }
                i7++;
                i5 = 0;
                i6 = 1;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i2 < 0;
        iAbs = Math.abs(i2);
        if (iAbs > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
        }
        iA = a(iAbs, z);
        i3 = f14400a[iAbs];
        int i12 = iA - (iA % i3);
        aVarA2 = a(aVarA3, i3);
        if (aVarA2.b() + iB > i12) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && aVarA2.b() > (i3 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        com.google.zxing.common.a aVarB = b(aVarA2, iA, i3);
        int iB3 = aVarA2.b() / i3;
        com.google.zxing.common.a aVarA4 = a(z, iAbs, iB3);
        int i13 = (z ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i13];
        int i14 = 2;
        if (z) {
            for (int i15 = 0; i15 < iArr.length; i15++) {
                iArr[i15] = i15;
            }
            i4 = i13;
        } else {
            int i16 = i13 / 2;
            i4 = i13 + 1 + (((i16 - 1) / 15) * 2);
            int i17 = i4 / 2;
            for (int i18 = 0; i18 < i16; i18++) {
                iArr[(i16 - i18) - i6] = (i17 - r14) - 1;
                iArr[i16 + i18] = (i18 / 15) + i18 + i17 + i6;
            }
        }
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(i4);
        int i19 = 0;
        int i20 = 0;
        while (i19 < iAbs) {
            int i21 = ((iAbs - i19) << i14) + (z ? 9 : 12);
            int i22 = 0;
            while (i22 < i21) {
                int i23 = i22 << 1;
                while (i5 < i14) {
                    if (aVarB.a(i20 + i23 + i5)) {
                        int i24 = i19 << 1;
                        bVar.b(iArr[i24 + i5], iArr[i24 + i22]);
                    }
                    if (aVarB.a((i21 << 1) + i20 + i23 + i5)) {
                        int i25 = i19 << 1;
                        bVar.b(iArr[i25 + i22], iArr[((i13 - 1) - i25) - i5]);
                    }
                    if (aVarB.a((i21 << 2) + i20 + i23 + i5)) {
                        int i26 = (i13 - 1) - (i19 << 1);
                        bVar.b(iArr[i26 - i5], iArr[i26 - i22]);
                    }
                    if (aVarB.a((i21 * 6) + i20 + i23 + i5)) {
                        int i27 = i19 << 1;
                        bVar.b(iArr[((i13 - 1) - i27) - i22], iArr[i27 + i5]);
                    }
                    i5++;
                    i14 = 2;
                }
                i22++;
                i5 = 0;
                i14 = 2;
            }
            i20 += i21 << 3;
            i19++;
            i5 = 0;
            i14 = 2;
        }
        a(bVar, z, i4, aVarA4);
        if (z) {
            a(bVar, i4 / 2, 5);
        } else {
            int i28 = i4 / 2;
            a(bVar, i28, 7);
            int i29 = 0;
            int i30 = 0;
            while (i29 < (i13 / 2) - 1) {
                for (int i31 = i28 & 1; i31 < i4; i31 += 2) {
                    int i32 = i28 - i30;
                    bVar.b(i32, i31);
                    int i33 = i28 + i30;
                    bVar.b(i33, i31);
                    bVar.b(i31, i32);
                    bVar.b(i31, i33);
                }
                i29 += 15;
                i30 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.a(z);
        aVar3.c(i4);
        aVar3.b(iAbs);
        aVar3.a(iB3);
        aVar3.a(bVar);
        return aVar3;
    }

    private static com.google.zxing.common.a b(com.google.zxing.common.a aVar, int i, int i2) {
        int iB = aVar.b() / i2;
        com.google.zxing.common.reedsolomon.c cVar = new com.google.zxing.common.reedsolomon.c(a(i2));
        int i3 = i / i2;
        int[] iArrA = a(aVar, i2, i3);
        cVar.a(iArrA, i3 - iB);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        aVar2.a(0, i % i2);
        for (int i4 : iArrA) {
            aVar2.a(i4, i2);
        }
        return aVar2;
    }

    private static void a(com.google.zxing.common.b bVar, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    bVar.b(i5, i4);
                    bVar.b(i5, i6);
                    bVar.b(i4, i5);
                    bVar.b(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        bVar.b(i7, i7);
        int i8 = i7 + 1;
        bVar.b(i8, i7);
        bVar.b(i7, i8);
        int i9 = i + i2;
        bVar.b(i9, i7);
        bVar.b(i9, i8);
        bVar.b(i9, i9 - 1);
    }

    static com.google.zxing.common.a a(boolean z, int i, int i2) {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (z) {
            aVar.a(i - 1, 2);
            aVar.a(i2 - 1, 6);
            return b(aVar, 28, 4);
        }
        aVar.a(i - 1, 5);
        aVar.a(i2 - 1, 11);
        return b(aVar, 40, 4);
    }

    private static void a(com.google.zxing.common.b bVar, boolean z, int i, com.google.zxing.common.a aVar) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (aVar.a(i3)) {
                    bVar.b(i4, i2 - 5);
                }
                if (aVar.a(i3 + 7)) {
                    bVar.b(i2 + 5, i4);
                }
                if (aVar.a(20 - i3)) {
                    bVar.b(i4, i2 + 5);
                }
                if (aVar.a(27 - i3)) {
                    bVar.b(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (aVar.a(i3)) {
                bVar.b(i5, i2 - 7);
            }
            if (aVar.a(i3 + 10)) {
                bVar.b(i2 + 7, i5);
            }
            if (aVar.a(29 - i3)) {
                bVar.b(i5, i2 + 7);
            }
            if (aVar.a(39 - i3)) {
                bVar.b(i2 - 7, i5);
            }
            i3++;
        }
    }

    private static int[] a(com.google.zxing.common.a aVar, int i, int i2) {
        int[] iArr = new int[i2];
        int iB = aVar.b() / i;
        for (int i3 = 0; i3 < iB; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= aVar.a((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    private static com.google.zxing.common.reedsolomon.a a(int i) {
        if (i == 4) {
            return com.google.zxing.common.reedsolomon.a.f14426d;
        }
        if (i == 6) {
            return com.google.zxing.common.reedsolomon.a.f14425c;
        }
        if (i == 8) {
            return com.google.zxing.common.reedsolomon.a.g;
        }
        if (i == 10) {
            return com.google.zxing.common.reedsolomon.a.f14424b;
        }
        if (i == 12) {
            return com.google.zxing.common.reedsolomon.a.f14423a;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
    }

    static com.google.zxing.common.a a(com.google.zxing.common.a aVar, int i) {
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        int iB = aVar.b();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < iB) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= iB || aVar.a(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                aVar2.a(i7, i);
            } else if (i7 == 0) {
                aVar2.a(i4 | 1, i);
            } else {
                aVar2.a(i4, i);
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return aVar2;
    }
}
