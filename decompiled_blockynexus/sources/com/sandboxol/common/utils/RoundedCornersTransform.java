package com.sandboxol.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.o;
import com.bumptech.glide.load.resource.bitmap.C0503e;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public class RoundedCornersTransform implements o<Bitmap> {
    private boolean isLeftBottom;
    private boolean isLeftTop;
    private boolean isRightBotoom;
    private boolean isRightTop;
    private e mBitmapPool;
    private float radius;

    public RoundedCornersTransform(Context context, float f2) {
        this.mBitmapPool = c.a(context).c();
        this.radius = f2;
    }

    public void setNeedCorner(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isLeftTop = z;
        this.isRightTop = z2;
        this.isLeftBottom = z3;
        this.isRightBotoom = z4;
    }

    @Override // com.bumptech.glide.load.o
    public C<Bitmap> transform(Context context, C<Bitmap> c2, int i, int i2) {
        int height;
        int width;
        Bitmap bitmap = c2.get();
        if (i > i2) {
            float f2 = i2;
            float f3 = i;
            height = bitmap.getWidth();
            width = (int) (bitmap.getWidth() * (f2 / f3));
            if (width > bitmap.getHeight()) {
                width = bitmap.getHeight();
                height = (int) (bitmap.getHeight() * (f3 / f2));
            }
        } else if (i < i2) {
            float f4 = i;
            float f5 = i2;
            int height2 = bitmap.getHeight();
            int height3 = (int) (bitmap.getHeight() * (f4 / f5));
            if (height3 > bitmap.getWidth()) {
                height = bitmap.getWidth();
                width = (int) (bitmap.getWidth() * (f5 / f4));
            } else {
                height = height3;
                width = height2;
            }
        } else {
            height = bitmap.getHeight();
            width = height;
        }
        this.radius *= width / i2;
        Bitmap bitmapA = this.mBitmapPool.a(height, width, Bitmap.Config.ARGB_8888);
        if (bitmapA == null) {
            bitmapA = Bitmap.createBitmap(height, width, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapA);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        int width2 = (bitmap.getWidth() - height) / 2;
        int height4 = (bitmap.getHeight() - width) / 2;
        if (width2 != 0 || height4 != 0) {
            Matrix matrix = new Matrix();
            matrix.setTranslate(-width2, -height4);
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, canvas.getWidth(), canvas.getHeight());
        float f6 = this.radius;
        canvas.drawRoundRect(rectF, f6, f6, paint);
        if (!this.isLeftTop) {
            float f7 = this.radius;
            canvas.drawRect(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, f7, f7, paint);
        }
        if (!this.isRightTop) {
            canvas.drawRect(canvas.getWidth() - this.radius, WheelView.DividerConfig.FILL, canvas.getWidth(), this.radius, paint);
        }
        if (!this.isLeftBottom) {
            float height5 = canvas.getHeight();
            float f8 = this.radius;
            canvas.drawRect(WheelView.DividerConfig.FILL, height5 - f8, f8, canvas.getHeight(), paint);
        }
        if (!this.isRightBotoom) {
            canvas.drawRect(canvas.getWidth() - this.radius, canvas.getHeight() - this.radius, canvas.getWidth(), canvas.getHeight(), paint);
        }
        return C0503e.a(bitmapA, this.mBitmapPool);
    }

    @Override // com.bumptech.glide.load.h
    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }
}
