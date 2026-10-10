package com.google.zxing.c;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.b;
import com.google.zxing.f;
import com.google.zxing.pdf417.encoder.Compaction;
import com.google.zxing.pdf417.encoder.c;
import com.google.zxing.pdf417.encoder.d;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: compiled from: PDF417Writer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {
    @Override // com.google.zxing.f
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        int i3;
        int i4;
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
        }
        d dVar = new d();
        if (map != null) {
            if (map.containsKey(EncodeHintType.PDF417_COMPACT)) {
                dVar.a(Boolean.valueOf(map.get(EncodeHintType.PDF417_COMPACT).toString()).booleanValue());
            }
            if (map.containsKey(EncodeHintType.PDF417_COMPACTION)) {
                dVar.a(Compaction.valueOf(map.get(EncodeHintType.PDF417_COMPACTION).toString()));
            }
            if (map.containsKey(EncodeHintType.PDF417_DIMENSIONS)) {
                c cVar = (c) map.get(EncodeHintType.PDF417_DIMENSIONS);
                dVar.a(cVar.a(), cVar.c(), cVar.b(), cVar.d());
            }
            int i5 = map.containsKey(EncodeHintType.MARGIN) ? Integer.parseInt(map.get(EncodeHintType.MARGIN).toString()) : 30;
            int i6 = map.containsKey(EncodeHintType.ERROR_CORRECTION) ? Integer.parseInt(map.get(EncodeHintType.ERROR_CORRECTION).toString()) : 2;
            if (map.containsKey(EncodeHintType.CHARACTER_SET)) {
                dVar.a(Charset.forName(map.get(EncodeHintType.CHARACTER_SET).toString()));
            }
            i4 = i5;
            i3 = i6;
        } else {
            i3 = 2;
            i4 = 30;
        }
        return a(dVar, str, i3, i, i2, i4);
    }

    private static b a(d dVar, String str, int i, int i2, int i3, int i4) throws WriterException {
        boolean z;
        dVar.a(str, i);
        byte[][] bArrA = dVar.a().a(1, 4);
        if ((i3 > i2) != (bArrA[0].length < bArrA.length)) {
            bArrA = a(bArrA);
            z = true;
        } else {
            z = false;
        }
        int length = i2 / bArrA[0].length;
        int length2 = i3 / bArrA.length;
        if (length >= length2) {
            length = length2;
        }
        if (length > 1) {
            byte[][] bArrA2 = dVar.a().a(length, length << 2);
            if (z) {
                bArrA2 = a(bArrA2);
            }
            return a(bArrA2, i4);
        }
        return a(bArrA, i4);
    }

    private static b a(byte[][] bArr, int i) {
        int i2 = i * 2;
        b bVar = new b(bArr[0].length + i2, bArr.length + i2);
        bVar.b();
        int iC = (bVar.c() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    bVar.b(i4 + i, iC);
                }
            }
            i3++;
            iC--;
        }
        return bVar;
    }

    private static byte[][] a(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }
}
