package com.google.zxing.d.a;

/* JADX INFO: compiled from: MaskUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {
    static int a(b bVar) {
        return a(bVar, true) + a(bVar, false);
    }

    static int b(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i = 0;
        int i2 = 0;
        while (i < iB - 1) {
            byte[] bArr = bArrA[i];
            int i3 = i2;
            int i4 = 0;
            while (i4 < iC - 1) {
                byte b2 = bArr[i4];
                int i5 = i4 + 1;
                if (b2 == bArr[i5]) {
                    int i6 = i + 1;
                    if (b2 == bArrA[i6][i4] && b2 == bArrA[i6][i5]) {
                        i3++;
                    }
                }
                i4 = i5;
            }
            i++;
            i2 = i3;
        }
        return i2 * 3;
    }

    static int c(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i = 0;
        int i2 = 0;
        while (i < iB) {
            int i3 = i2;
            for (int i4 = 0; i4 < iC; i4++) {
                byte[] bArr = bArrA[i];
                int i5 = i4 + 6;
                if (i5 < iC && bArr[i4] == 1 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 1 && bArr[i4 + 3] == 1 && bArr[i4 + 4] == 1 && bArr[i4 + 5] == 0 && bArr[i5] == 1 && (a(bArr, i4 - 4, i4) || a(bArr, i4 + 7, i4 + 11))) {
                    i3++;
                }
                int i6 = i + 6;
                if (i6 < iB && bArrA[i][i4] == 1 && bArrA[i + 1][i4] == 0 && bArrA[i + 2][i4] == 1 && bArrA[i + 3][i4] == 1 && bArrA[i + 4][i4] == 1 && bArrA[i + 5][i4] == 0 && bArrA[i6][i4] == 1 && (a(bArrA, i4, i - 4, i) || a(bArrA, i4, i + 7, i + 11))) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        return i2 * 40;
    }

    static int d(b bVar) {
        byte[][] bArrA = bVar.a();
        int iC = bVar.c();
        int iB = bVar.b();
        int i = 0;
        int i2 = 0;
        while (i < iB) {
            byte[] bArr = bArrA[i];
            int i3 = i2;
            for (int i4 = 0; i4 < iC; i4++) {
                if (bArr[i4] == 1) {
                    i3++;
                }
            }
            i++;
            i2 = i3;
        }
        int iB2 = bVar.b() * bVar.c();
        return ((Math.abs((i2 << 1) - iB2) * 10) / iB2) * 10;
    }

    private static boolean a(byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, bArr.length);
        for (int iMax = Math.max(i, 0); iMax < iMin; iMax++) {
            if (bArr[iMax] == 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(byte[][] bArr, int i, int i2, int i3) {
        int iMin = Math.min(i3, bArr.length);
        for (int iMax = Math.max(i2, 0); iMax < iMin; iMax++) {
            if (bArr[iMax][i] == 1) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean a(int r1, int r2, int r3) {
        /*
            r0 = 1
            switch(r1) {
                case 0: goto L3a;
                case 1: goto L3b;
                case 2: goto L37;
                case 3: goto L33;
                case 4: goto L2e;
                case 5: goto L26;
                case 6: goto L1d;
                case 7: goto L14;
                default: goto L4;
            }
        L4:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "Invalid mask pattern: "
            java.lang.String r1 = r3.concat(r1)
            r2.<init>(r1)
            throw r2
        L14:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            int r1 = r1 + r2
            goto L24
        L1d:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
        L24:
            r1 = r1 & r0
            goto L3d
        L26:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3d
        L2e:
            int r3 = r3 / 2
            int r2 = r2 / 3
            goto L3a
        L33:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L3d
        L37:
            int r1 = r2 % 3
            goto L3d
        L3a:
            int r3 = r3 + r2
        L3b:
            r1 = r3 & 1
        L3d:
            if (r1 != 0) goto L40
            return r0
        L40:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.d.a.e.a(int, int, int):boolean");
    }

    private static int a(b bVar, boolean z) {
        int iB = z ? bVar.b() : bVar.c();
        int iC = z ? bVar.c() : bVar.b();
        byte[][] bArrA = bVar.a();
        int i = 0;
        for (int i2 = 0; i2 < iB; i2++) {
            int i3 = i;
            int i4 = 0;
            byte b2 = -1;
            for (int i5 = 0; i5 < iC; i5++) {
                byte b3 = z ? bArrA[i2][i5] : bArrA[i5][i2];
                if (b3 == b2) {
                    i4++;
                } else {
                    if (i4 >= 5) {
                        i3 += (i4 - 5) + 3;
                    }
                    i4 = 1;
                    b2 = b3;
                }
            }
            if (i4 >= 5) {
                i3 += (i4 - 5) + 3;
            }
            i = i3;
        }
        return i;
    }
}
