package com.google.zxing.d;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.b;
import com.google.zxing.d.a.d;
import com.google.zxing.d.a.g;
import com.google.zxing.f;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

/* JADX INFO: compiled from: QRCodeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {
    @Override // com.google.zxing.f
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i3 = 4;
        if (map != null) {
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(EncodeHintType.MARGIN)) {
                i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
        }
        return a(d.a(str, errorCorrectionLevelValueOf, map), i, i2, i3);
    }

    private static b a(g gVar, int i, int i2, int i3) {
        com.google.zxing.d.a.b bVarA = gVar.a();
        if (bVarA != null) {
            int iC = bVarA.c();
            int iB = bVarA.b();
            int i4 = i3 << 1;
            int i5 = iC + i4;
            int i6 = i4 + iB;
            int iMax = Math.max(i, i5);
            int iMax2 = Math.max(i2, i6);
            int iMin = Math.min(iMax / i5, iMax2 / i6);
            int i7 = (iMax - (iC * iMin)) / 2;
            int i8 = (iMax2 - (iB * iMin)) / 2;
            b bVar = new b(iMax, iMax2);
            int i9 = 0;
            while (i9 < iB) {
                int i10 = i7;
                int i11 = 0;
                while (i11 < iC) {
                    if (bVarA.a(i11, i9) == 1) {
                        bVar.a(i10, i8, iMin, iMin);
                    }
                    i11++;
                    i10 += iMin;
                }
                i9++;
                i8 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
