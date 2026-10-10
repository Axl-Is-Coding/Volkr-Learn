package com.sandboxol.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes3.dex */
public class BitmapWaterMark {
    public static Bitmap addTimeWatermark(Context context, Bitmap bitmap, String str, int i, int i2) {
        int iSp2px = (int) SizeUtil.sp2px(context, i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setTextSize(iSp2px);
        paint.setFakeBoldText(true);
        canvas.drawText(str, (r9 * 1) / 2, r0 / 2, paint);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    public static Bitmap addWaterMaskImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int width2 = bitmap2.getWidth();
        int height2 = bitmap2.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
        canvas.drawBitmap(bitmap2, width - width2, height - height2, (Paint) null);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }

    public static Bitmap addWordWaterMaskImage(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        bitmap2.getWidth();
        bitmap2.getHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawBitmap(bitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
        canvas.drawBitmap(bitmap2, 1.0f, 1.0f, (Paint) null);
        canvas.save();
        canvas.restore();
        return bitmapCreateBitmap;
    }
}
