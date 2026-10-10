package com.google.zxing.a;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.a.a.c;
import com.google.zxing.common.b;
import com.google.zxing.f;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: AztecWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {
    @Override // com.google.zxing.f
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        Charset charset;
        int i3;
        int i4;
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        if (map != null) {
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                charsetForName = Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString());
            }
            int i5 = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 33;
            if (map.containsKey(EncodeHintType.AZTEC_LAYERS)) {
                charset = charsetForName;
                i3 = i5;
                i4 = Integer.parseInt(map.get(EncodeHintType.AZTEC_LAYERS).toString());
                return a(str, barcodeFormat, i, i2, charset, i3, i4);
            }
            charset = charsetForName;
            i3 = i5;
        } else {
            charset = charsetForName;
            i3 = 33;
        }
        i4 = 0;
        return a(str, barcodeFormat, i, i2, charset, i3, i4);
    }

    private static b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return a(c.a(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(barcodeFormat)));
    }

    private static b a(com.google.zxing.a.a.a aVar, int i, int i2) {
        b bVarA = aVar.a();
        if (bVarA != null) {
            int iD = bVarA.d();
            int iC = bVarA.c();
            int iMax = Math.max(i, iD);
            int iMax2 = Math.max(i2, iC);
            int iMin = Math.min(iMax / iD, iMax2 / iC);
            int i3 = (iMax - (iD * iMin)) / 2;
            int i4 = (iMax2 - (iC * iMin)) / 2;
            b bVar = new b(iMax, iMax2);
            int i5 = 0;
            while (i5 < iC) {
                int i6 = i3;
                int i7 = 0;
                while (i7 < iD) {
                    if (bVarA.a(i7, i5)) {
                        bVar.a(i6, i4, iMin, iMin);
                    }
                    i7++;
                    i6 += iMin;
                }
                i5++;
                i4 += iMin;
            }
            return bVar;
        }
        throw new IllegalStateException();
    }
}
