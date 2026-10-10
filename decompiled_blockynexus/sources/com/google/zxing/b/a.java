package com.google.zxing.b;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.b;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.datamatrix.encoder.e;
import com.google.zxing.datamatrix.encoder.i;
import com.google.zxing.datamatrix.encoder.j;
import com.google.zxing.datamatrix.encoder.k;
import com.google.zxing.f;
import java.util.Map;

/* JADX INFO: compiled from: DataMatrixWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements f {
    @Override // com.google.zxing.f
    public b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) {
        com.google.zxing.a aVar;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i + 'x' + i2);
        }
        SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
        com.google.zxing.a aVar2 = null;
        if (map != null) {
            SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
            if (symbolShapeHint2 != null) {
                symbolShapeHint = symbolShapeHint2;
            }
            aVar = (com.google.zxing.a) map.get(EncodeHintType.MIN_SIZE);
            if (aVar == null) {
                aVar = null;
            }
            com.google.zxing.a aVar3 = (com.google.zxing.a) map.get(EncodeHintType.MAX_SIZE);
            if (aVar3 != null) {
                aVar2 = aVar3;
            }
        } else {
            aVar = null;
        }
        String strA = j.a(str, symbolShapeHint, aVar, aVar2);
        k kVarA = k.a(strA.length(), symbolShapeHint, aVar, aVar2, true);
        e eVar = new e(i.a(strA, kVarA), kVarA.e(), kVarA.d());
        eVar.a();
        return a(eVar, kVarA, i, i2);
    }

    private static b a(e eVar, k kVar, int i, int i2) {
        int iE = kVar.e();
        int iD = kVar.d();
        com.google.zxing.d.a.b bVar = new com.google.zxing.d.a.b(kVar.g(), kVar.f());
        int i3 = 0;
        for (int i4 = 0; i4 < iD; i4++) {
            if (i4 % kVar.g == 0) {
                int i5 = 0;
                for (int i6 = 0; i6 < kVar.g(); i6++) {
                    bVar.a(i5, i3, i6 % 2 == 0);
                    i5++;
                }
                i3++;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < iE; i8++) {
                if (i8 % kVar.f14468f == 0) {
                    bVar.a(i7, i3, true);
                    i7++;
                }
                bVar.a(i7, i3, eVar.a(i8, i4));
                i7++;
                int i9 = kVar.f14468f;
                if (i8 % i9 == i9 - 1) {
                    bVar.a(i7, i3, i4 % 2 == 0);
                    i7++;
                }
            }
            i3++;
            int i10 = kVar.g;
            if (i4 % i10 == i10 - 1) {
                int i11 = 0;
                for (int i12 = 0; i12 < kVar.g(); i12++) {
                    bVar.a(i11, i3, true);
                    i11++;
                }
                i3++;
            }
        }
        return a(bVar, i, i2);
    }

    private static b a(com.google.zxing.d.a.b bVar, int i, int i2) {
        b bVar2;
        int iC = bVar.c();
        int iB = bVar.b();
        int iMax = Math.max(i, iC);
        int iMax2 = Math.max(i2, iB);
        int iMin = Math.min(iMax / iC, iMax2 / iB);
        int i3 = (iMax - (iC * iMin)) / 2;
        int i4 = (iMax2 - (iB * iMin)) / 2;
        if (i2 >= iB && i >= iC) {
            bVar2 = new b(i, i2);
        } else {
            bVar2 = new b(iC, iB);
            i3 = 0;
            i4 = 0;
        }
        bVar2.b();
        int i5 = 0;
        while (i5 < iB) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < iC) {
                if (bVar.a(i7, i5) == 1) {
                    bVar2.a(i6, i4, iMin, iMin);
                }
                i7++;
                i6 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return bVar2;
    }
}
