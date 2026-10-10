package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* JADX INFO: compiled from: UPCAWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements com.google.zxing.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f14485a = new i();

    @Override // com.google.zxing.f
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            return this.f14485a.a("0".concat(String.valueOf(str)), BarcodeFormat.EAN_13, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(barcodeFormat)));
    }
}
