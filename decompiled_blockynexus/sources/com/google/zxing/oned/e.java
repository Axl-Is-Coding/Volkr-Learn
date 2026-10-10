package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: Code39Writer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends m {
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String b(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.e.b(java.lang.String):java.lang.String");
    }

    @Override // com.google.zxing.oned.m, com.google.zxing.f
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i)) < 0) {
                    str = b(str);
                    length = str.length();
                    if (length > 80) {
                        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                    }
                } else {
                    i++;
                }
            }
            int[] iArr = new int[9];
            int i2 = length + 25;
            int i3 = 0;
            while (i3 < length) {
                a(d.f14477a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i3))], iArr);
                int i4 = i2;
                for (int i5 = 0; i5 < 9; i5++) {
                    i4 += iArr[i5];
                }
                i3++;
                i2 = i4;
            }
            boolean[] zArr = new boolean[i2];
            a(148, iArr);
            int iA = m.a(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int iA2 = iA + m.a(zArr, iA, iArr2, false);
            for (int i6 = 0; i6 < length; i6++) {
                a(d.f14477a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i6))], iArr);
                int iA3 = iA2 + m.a(zArr, iA2, iArr, true);
                iA2 = iA3 + m.a(zArr, iA3, iArr2, false);
            }
            a(148, iArr);
            m.a(zArr, iA2, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }

    private static void a(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }
}
