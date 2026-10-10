package com.google.zxing.d.a;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: compiled from: MatrixUtil.java */
/* JADX INFO: loaded from: classes2.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[][] f14440a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f14441b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f14442c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[][] f14443d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    static void a(b bVar) {
        bVar.a((byte) -1);
    }

    static void b(com.google.zxing.qrcode.decoder.a aVar, b bVar) throws WriterException {
        if (aVar.c() < 7) {
            return;
        }
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        a(aVar, aVar2);
        int i = 0;
        int i2 = 17;
        while (i < 6) {
            int i3 = i2;
            for (int i4 = 0; i4 < 3; i4++) {
                boolean zA = aVar2.a(i3);
                i3--;
                bVar.a(i, (bVar.b() - 11) + i4, zA);
                bVar.a((bVar.b() - 11) + i4, i, zA);
            }
            i++;
            i2 = i3;
        }
    }

    private static boolean b(int i) {
        return i == -1;
    }

    private static void c(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f14440a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    private static void d(b bVar) {
        int i = 8;
        while (i < bVar.c() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (b(bVar.a(i, 6))) {
                bVar.a(i, 6, i3);
            }
            if (b(bVar.a(6, i))) {
                bVar.a(6, i, i3);
            }
            i = i2;
        }
    }

    static void a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.a aVar2, int i, b bVar) throws WriterException {
        a(bVar);
        a(aVar2, bVar);
        a(errorCorrectionLevel, i, bVar);
        b(aVar2, bVar);
        a(aVar, i, bVar);
    }

    private static void c(b bVar) throws WriterException {
        int length = f14440a[0].length;
        c(0, 0, bVar);
        c(bVar.c() - length, 0, bVar);
        c(0, bVar.c() - length, bVar);
        a(0, 7, bVar);
        a(bVar.c() - 8, 7, bVar);
        a(0, bVar.c() - 8, bVar);
        d(7, 0, bVar);
        d((bVar.b() - 7) - 1, 0, bVar);
        d(7, bVar.b() - 7, bVar);
    }

    static void a(com.google.zxing.qrcode.decoder.a aVar, b bVar) throws WriterException {
        c(bVar);
        b(bVar);
        c(aVar, bVar);
        d(bVar);
    }

    private static void b(b bVar) throws WriterException {
        if (bVar.a(8, bVar.b() - 8) != 0) {
            bVar.a(8, bVar.b() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static void d(int i, int i2, b bVar) throws WriterException {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (b(bVar.a(i, i4))) {
                bVar.a(i, i4, 0);
            } else {
                throw new WriterException();
            }
        }
    }

    private static void b(int i, int i2, b bVar) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = f14441b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                bVar.a(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i, b bVar) throws WriterException {
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        a(errorCorrectionLevel, i, aVar);
        for (int i2 = 0; i2 < aVar.b(); i2++) {
            boolean zA = aVar.a((aVar.b() - 1) - i2);
            int[] iArr = f14443d[i2];
            bVar.a(iArr[0], iArr[1], zA);
            if (i2 < 8) {
                bVar.a((bVar.c() - i2) - 1, 8, zA);
            } else {
                bVar.a(8, (bVar.b() - 7) + (i2 - 8), zA);
            }
        }
    }

    private static void c(com.google.zxing.qrcode.decoder.a aVar, b bVar) {
        if (aVar.c() < 2) {
            return;
        }
        int[] iArr = f14442c[aVar.c() - 1];
        for (int i : iArr) {
            if (i >= 0) {
                for (int i2 : iArr) {
                    if (i2 >= 0 && b(bVar.a(i2, i))) {
                        b(i2 - 2, i - 2, bVar);
                    }
                }
            }
        }
    }

    static void a(com.google.zxing.common.a aVar, int i, b bVar) throws WriterException {
        boolean zA;
        int iC = bVar.c() - 1;
        int iB = bVar.b() - 1;
        int i2 = 0;
        int i3 = -1;
        while (iC > 0) {
            if (iC == 6) {
                iC--;
            }
            while (iB >= 0 && iB < bVar.b()) {
                int i4 = i2;
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = iC - i5;
                    if (b(bVar.a(i6, iB))) {
                        if (i4 < aVar.b()) {
                            zA = aVar.a(i4);
                            i4++;
                        } else {
                            zA = false;
                        }
                        if (i != -1 && e.a(i, i6, iB)) {
                            zA = !zA;
                        }
                        bVar.a(i6, iB, zA);
                    }
                }
                iB += i3;
                i2 = i4;
            }
            i3 = -i3;
            iB += i3;
            iC -= 2;
        }
        if (i2 == aVar.b()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i2 + '/' + aVar.b());
    }

    static int a(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    static int a(int i, int i2) {
        if (i2 != 0) {
            int iA = a(i2);
            int iA2 = i << (iA - 1);
            while (a(iA2) >= iA) {
                iA2 ^= i2 << (a(iA2) - iA);
            }
            return iA2;
        }
        throw new IllegalArgumentException("0 polynomial");
    }

    static void a(ErrorCorrectionLevel errorCorrectionLevel, int i, com.google.zxing.common.a aVar) throws WriterException {
        if (g.a(i)) {
            int bits = (errorCorrectionLevel.getBits() << 3) | i;
            aVar.a(bits, 5);
            aVar.a(a(bits, 1335), 10);
            com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
            aVar2.a(21522, 15);
            aVar.b(aVar2);
            if (aVar.b() == 15) {
                return;
            }
            throw new WriterException("should not happen but we got: " + aVar.b());
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void a(com.google.zxing.qrcode.decoder.a aVar, com.google.zxing.common.a aVar2) throws WriterException {
        aVar2.a(aVar.c(), 6);
        aVar2.a(a(aVar.c(), 7973), 12);
        if (aVar2.b() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + aVar2.b());
    }

    private static void a(int i, int i2, b bVar) throws WriterException {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (b(bVar.a(i4, i2))) {
                bVar.a(i4, i2, 0);
            } else {
                throw new WriterException();
            }
        }
    }
}
