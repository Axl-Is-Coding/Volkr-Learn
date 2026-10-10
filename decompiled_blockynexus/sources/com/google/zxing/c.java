package com.google.zxing;

import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.g;
import com.google.zxing.oned.i;
import com.google.zxing.oned.j;
import com.google.zxing.oned.k;
import com.google.zxing.oned.n;
import com.google.zxing.oned.r;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements f {
    @Override // com.google.zxing.f
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        f jVar;
        switch (b.f14416a[barcodeFormat.ordinal()]) {
            case 1:
                jVar = new j();
                break;
            case 2:
                jVar = new r();
                break;
            case 3:
                jVar = new i();
                break;
            case 4:
                jVar = new n();
                break;
            case 5:
                jVar = new com.google.zxing.d.a();
                break;
            case 6:
                jVar = new com.google.zxing.oned.e();
                break;
            case 7:
                jVar = new g();
                break;
            case 8:
                jVar = new Code128Writer();
                break;
            case 9:
                jVar = new k();
                break;
            case 10:
                jVar = new com.google.zxing.c.a();
                break;
            case 11:
                jVar = new com.google.zxing.oned.b();
                break;
            case 12:
                jVar = new com.google.zxing.b.a();
                break;
            case 13:
                jVar = new com.google.zxing.a.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(barcodeFormat)));
        }
        return jVar.a(str, barcodeFormat, i, i2, map);
    }
}
