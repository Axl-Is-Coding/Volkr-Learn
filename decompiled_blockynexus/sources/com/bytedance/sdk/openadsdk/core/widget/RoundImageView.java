package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class RoundImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6552b;

    public RoundImageView(Context context) {
        super(context);
        this.f6551a = 0;
        this.f6552b = 0;
    }

    private Bitmap a(Bitmap bitmap, int i) {
        int i2 = i * 2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapCreateBitmap = height > width ? Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width) : height < width ? Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height) : null;
        if (bitmapCreateBitmap != null) {
            bitmap = bitmapCreateBitmap;
        }
        if (bitmap.getWidth() != i2 || bitmap.getHeight() != i2) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return bitmapCreateBitmap2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmapCopy;
        Bitmap bitmapA;
        Drawable drawable = getDrawable();
        if (drawable == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
            return;
        }
        try {
            bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        } catch (Throwable unused) {
            bitmapCopy = null;
        }
        if (bitmapCopy == null) {
            super.onDraw(canvas);
            return;
        }
        if (this.f6551a == 0) {
            this.f6551a = getWidth();
        }
        if (this.f6552b == 0) {
            this.f6552b = getHeight();
        }
        int i = this.f6551a;
        int i2 = this.f6552b;
        if (i >= i2) {
            i = i2;
        }
        try {
            bitmapA = a(bitmapCopy, i / 2);
        } catch (Throwable unused2) {
            bitmapA = null;
        }
        if (bitmapA == null) {
            super.onDraw(canvas);
        } else {
            canvas.drawBitmap(bitmapA, (this.f6551a / 2) - r2, (this.f6552b / 2) - r2, (Paint) null);
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6551a = 0;
        this.f6552b = 0;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6551a = 0;
        this.f6552b = 0;
    }
}
