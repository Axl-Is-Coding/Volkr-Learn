package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: EAN8Writer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends p {
    @Override // com.google.zxing.oned.m, com.google.zxing.f
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + o.b(str);
            } catch (FormatException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 8) {
            try {
                if (!o.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[67];
        int iA = m.a(zArr, 0, o.f14486a, true) + 0;
        for (int i = 0; i <= 3; i++) {
            iA += m.a(zArr, iA, o.f14489d[Character.digit(str.charAt(i), 10)], false);
        }
        int iA2 = iA + m.a(zArr, iA, o.f14487b, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            iA2 += m.a(zArr, iA2, o.f14489d[Character.digit(str.charAt(i2), 10)], true);
        }
        m.a(zArr, iA2, o.f14486a, true);
        return zArr;
    }
}
