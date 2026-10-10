package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class TTRoundRectImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f6578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Matrix f6581d;

    public TTRoundRectImageView(Context context) {
        this(context, null);
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = drawable.getIntrinsicWidth() <= 0 ? getWidth() : drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight() <= 0 ? getHeight() : drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            super.onDraw(canvas);
            return;
        }
        Bitmap bitmapA = a(drawable);
        if (bitmapA == null) {
            super.onDraw(canvas);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        BitmapShader bitmapShader = new BitmapShader(bitmapA, tileMode, tileMode);
        float fMax = (bitmapA.getWidth() == getWidth() && bitmapA.getHeight() == getHeight()) ? 1.0f : Math.max((getWidth() * 1.0f) / bitmapA.getWidth(), (getHeight() * 1.0f) / bitmapA.getHeight());
        this.f6581d.setScale(fMax, fMax);
        bitmapShader.setLocalMatrix(this.f6581d);
        this.f6578a.setShader(bitmapShader);
        canvas.drawRoundRect(new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getWidth(), getHeight()), this.f6579b, this.f6580c, this.f6578a);
    }

    public void setXRound(int i) {
        this.f6579b = i;
        postInvalidate();
    }

    public void setYRound(int i) {
        this.f6580c = i;
        postInvalidate();
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTRoundRectImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6579b = 25;
        this.f6580c = 25;
        this.f6578a = new Paint();
        this.f6578a.setAntiAlias(true);
        this.f6578a.setFilterBitmap(true);
        this.f6581d = new Matrix();
    }
}
