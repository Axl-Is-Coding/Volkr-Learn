package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import cn.qqtheme.framework.widget.WheelView;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1748Lg {
    public static Bitmap A00(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.setScale(-1.0f, 1.0f);
        matrix.postTranslate(bitmap.getWidth(), WheelView.DividerConfig.FILL);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap A01(EnumC1747Lf enumC1747Lf) {
        byte[] bArrDecode = Base64.decode(enumC1747Lf.A01(LX.A01), 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static Bitmap A02(EnumC1747Lf enumC1747Lf) {
        byte[] bArrDecode = Base64.decode(enumC1747Lf.A01(LX.A01), 0);
        return A00(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
    }

    public static Drawable A03(C2026Wb c2026Wb, EnumC1747Lf enumC1747Lf) {
        return new BitmapDrawable(c2026Wb.getResources(), A01(enumC1747Lf));
    }
}
