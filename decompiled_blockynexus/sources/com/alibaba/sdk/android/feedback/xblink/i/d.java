package com.alibaba.sdk.android.feedback.xblink.i;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e2) {
            g.b("ImageTool", e2 + "");
            return 0;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0 || bitmap == null) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapCreateBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap a(String str, int i) {
        if (i > 1024) {
            i = 1024;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        if (i2 <= i3) {
            i2 = i3;
        }
        int iRound = Math.round(i2 / i);
        if (iRound < 1) {
            iRound = 1;
        }
        options.inSampleSize = iRound;
        options.inJustDecodeBounds = false;
        if (bitmapDecodeFile != null) {
            bitmapDecodeFile.recycle();
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static Drawable a(Resources resources, String str) {
        if (str == null) {
            return null;
        }
        try {
            return new BitmapDrawable(resources, BitmapFactory.decodeStream(new ByteArrayInputStream(Base64.decode(str, 0))));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static byte[] a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 70, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
