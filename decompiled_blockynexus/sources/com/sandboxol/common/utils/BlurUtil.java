package com.sandboxol.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class BlurUtil {
    public static Bitmap blur(Context context, Bitmap bitmap, int i) {
        return blur(context, bitmap, 8.0f, i);
    }

    private static Bitmap blurApi16(Bitmap bitmap, float f2, int i) {
        int[] iArr;
        int i2 = i;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (bitmap.getWidth() / f2), (int) (bitmap.getHeight() / f2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f3 = 1.0f / f2;
        canvas.scale(f3, f3);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, paint);
        Bitmap bitmapCopy = bitmapCreateBitmap.copy(bitmapCreateBitmap.getConfig(), true);
        if (i2 < 1) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i3 = width * height;
        int[] iArr2 = new int[i3];
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i4 = width - 1;
        int i5 = height - 1;
        int i6 = i2 + i2 + 1;
        int[] iArr3 = new int[i3];
        int[] iArr4 = new int[i3];
        int[] iArr5 = new int[i3];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i6 + 1) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i6, 3);
        int i11 = i2 + 1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i15 = -i2;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            while (i15 <= i2) {
                int i25 = i5;
                int i26 = height;
                int i27 = iArr2[i13 + Math.min(i4, Math.max(i15, 0))];
                int[] iArr9 = iArr8[i15 + i2];
                iArr9[0] = (i27 & 16711680) >> 16;
                iArr9[1] = (i27 & 65280) >> 8;
                iArr9[2] = i27 & 255;
                int iAbs = i11 - Math.abs(i15);
                i16 += iArr9[0] * iAbs;
                i17 += iArr9[1] * iAbs;
                i18 += iArr9[2] * iAbs;
                if (i15 > 0) {
                    i22 += iArr9[0];
                    i23 += iArr9[1];
                    i24 += iArr9[2];
                } else {
                    i19 += iArr9[0];
                    i20 += iArr9[1];
                    i21 += iArr9[2];
                }
                i15++;
                height = i26;
                i5 = i25;
            }
            int i28 = i5;
            int i29 = height;
            int i30 = i2;
            int i31 = 0;
            while (i31 < width) {
                iArr3[i13] = iArr7[i16];
                iArr4[i13] = iArr7[i17];
                iArr5[i13] = iArr7[i18];
                int i32 = i16 - i19;
                int i33 = i17 - i20;
                int i34 = i18 - i21;
                int[] iArr10 = iArr8[((i30 - i2) + i6) % i6];
                int i35 = i19 - iArr10[0];
                int i36 = i20 - iArr10[1];
                int i37 = i21 - iArr10[2];
                if (i12 == 0) {
                    iArr = iArr7;
                    iArr6[i31] = Math.min(i31 + i2 + 1, i4);
                } else {
                    iArr = iArr7;
                }
                int i38 = iArr2[i14 + iArr6[i31]];
                iArr10[0] = (i38 & 16711680) >> 16;
                iArr10[1] = (i38 & 65280) >> 8;
                iArr10[2] = i38 & 255;
                int i39 = i22 + iArr10[0];
                int i40 = i23 + iArr10[1];
                int i41 = i24 + iArr10[2];
                i16 = i32 + i39;
                i17 = i33 + i40;
                i18 = i34 + i41;
                i30 = (i30 + 1) % i6;
                int[] iArr11 = iArr8[i30 % i6];
                i19 = i35 + iArr11[0];
                i20 = i36 + iArr11[1];
                i21 = i37 + iArr11[2];
                i22 = i39 - iArr11[0];
                i23 = i40 - iArr11[1];
                i24 = i41 - iArr11[2];
                i13++;
                i31++;
                iArr7 = iArr;
            }
            i14 += width;
            i12++;
            bitmapCopy = bitmap2;
            height = i29;
            i5 = i28;
        }
        Bitmap bitmap3 = bitmapCopy;
        int[] iArr12 = iArr7;
        int i42 = i5;
        int i43 = height;
        int i44 = 0;
        while (i44 < width) {
            int i45 = -i2;
            int i46 = i45 * width;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            int i50 = 0;
            int i51 = 0;
            int i52 = 0;
            int i53 = 0;
            int i54 = 0;
            int i55 = 0;
            while (i45 <= i2) {
                int[] iArr13 = iArr6;
                int iMax = Math.max(0, i46) + i44;
                int[] iArr14 = iArr8[i45 + i2];
                iArr14[0] = iArr3[iMax];
                iArr14[1] = iArr4[iMax];
                iArr14[2] = iArr5[iMax];
                int iAbs2 = i11 - Math.abs(i45);
                i47 += iArr3[iMax] * iAbs2;
                i48 += iArr4[iMax] * iAbs2;
                i49 += iArr5[iMax] * iAbs2;
                if (i45 > 0) {
                    i53 += iArr14[0];
                    i54 += iArr14[1];
                    i55 += iArr14[2];
                } else {
                    i50 += iArr14[0];
                    i51 += iArr14[1];
                    i52 += iArr14[2];
                }
                int i56 = i42;
                if (i45 < i56) {
                    i46 += width;
                }
                i45++;
                i42 = i56;
                iArr6 = iArr13;
            }
            int[] iArr15 = iArr6;
            int i57 = i42;
            int i58 = i54;
            int i59 = i55;
            int i60 = i43;
            int i61 = 0;
            int i62 = i2;
            int i63 = i53;
            int i64 = i52;
            int i65 = i51;
            int i66 = i50;
            int i67 = i49;
            int i68 = i48;
            int i69 = i47;
            int i70 = i44;
            while (i61 < i60) {
                iArr2[i70] = (iArr2[i70] & (-16777216)) | (iArr12[i69] << 16) | (iArr12[i68] << 8) | iArr12[i67];
                int i71 = i69 - i66;
                int i72 = i68 - i65;
                int i73 = i67 - i64;
                int[] iArr16 = iArr8[((i62 - i2) + i6) % i6];
                int i74 = i66 - iArr16[0];
                int i75 = i65 - iArr16[1];
                int i76 = i64 - iArr16[2];
                if (i44 == 0) {
                    iArr15[i61] = Math.min(i61 + i11, i57) * width;
                }
                int i77 = iArr15[i61] + i44;
                iArr16[0] = iArr3[i77];
                iArr16[1] = iArr4[i77];
                iArr16[2] = iArr5[i77];
                int i78 = i63 + iArr16[0];
                int i79 = i58 + iArr16[1];
                int i80 = i59 + iArr16[2];
                i69 = i71 + i78;
                i68 = i72 + i79;
                i67 = i73 + i80;
                i62 = (i62 + 1) % i6;
                int[] iArr17 = iArr8[i62];
                i66 = i74 + iArr17[0];
                i65 = i75 + iArr17[1];
                i64 = i76 + iArr17[2];
                i63 = i78 - iArr17[0];
                i58 = i79 - iArr17[1];
                i59 = i80 - iArr17[2];
                i70 += width;
                i61++;
                i2 = i;
            }
            i44++;
            i2 = i;
            i43 = i60;
            i42 = i57;
            iArr6 = iArr15;
        }
        bitmap3.setPixels(iArr2, 0, width, 0, 0, width, i43);
        return bitmap3;
    }

    public static Bitmap blur(Context context, Bitmap bitmap, float f2, int i) {
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT <= 16) {
            return blurApi16(bitmap, f2, i);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((int) (bitmap.getWidth() / f2), (int) (bitmap.getHeight() / f2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        float f3 = 1.0f / f2;
        canvas.scale(f3, f3);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(bitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, paint);
        RenderScript renderScriptCreate = RenderScript.create(context);
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap, Allocation.MipmapControl.MIPMAP_FULL, 1);
        Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.setRadius(i);
        scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
        allocationCreateTyped.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }
}
