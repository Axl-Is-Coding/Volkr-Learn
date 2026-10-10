package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: EAN13Writer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends p {
    @Override // com.google.zxing.oned.m, com.google.zxing.f
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + o.b(str);
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 13) {
            try {
                if (!o.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i = h.f14481f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iA = m.a(zArr, 0, o.f14486a, true) + 0;
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit += 10;
            }
            iA += m.a(zArr, iA, o.f14490e[iDigit], false);
        }
        int iA2 = iA + m.a(zArr, iA, o.f14487b, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            iA2 += m.a(zArr, iA2, o.f14489d[Character.digit(str.charAt(i3), 10)], true);
        }
        m.a(zArr, iA2, o.f14486a, true);
        return zArr;
    }
}
