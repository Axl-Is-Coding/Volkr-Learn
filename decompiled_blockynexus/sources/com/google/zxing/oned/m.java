package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: OneDimensionalCodeWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class m implements com.google.zxing.f {
    public int a() {
        return 10;
    }

    @Override // com.google.zxing.f
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        }
        int iA = a();
        if (map != null && map.containsKey(EncodeHintType.MARGIN)) {
            iA = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
        }
        return a(a(str), i, i2, iA);
    }

    public abstract boolean[] a(String str);

    private static com.google.zxing.common.b a(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int iMax = Math.max(i, i4);
        int iMax2 = Math.max(1, i2);
        int i5 = iMax / i4;
        com.google.zxing.common.b bVar = new com.google.zxing.common.b(iMax, iMax2);
        int i6 = (iMax - (length * i5)) / 2;
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                bVar.a(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return bVar;
    }

    protected static int a(boolean[] zArr, int i, int[] iArr, boolean z) {
        int length = iArr.length;
        int i2 = i;
        boolean z2 = z;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = iArr[i3];
            int i6 = i2;
            int i7 = 0;
            while (i7 < i5) {
                zArr[i6] = z2;
                i7++;
                i6++;
            }
            i4 += i5;
            z2 = !z2;
            i3++;
            i2 = i6;
        }
        return i4;
    }
}
