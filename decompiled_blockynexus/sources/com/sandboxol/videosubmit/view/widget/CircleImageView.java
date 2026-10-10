package com.sandboxol.videosubmit.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes4.dex */
public class CircleImageView extends AppCompatImageView {
    private Paint mPaint;
    private int mRadius;
    private float mScale;

    public CircleImageView(Context context) {
        super(context);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPaint = new Paint();
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(getBackground());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapDrawableToBitmap, tileMode, tileMode);
        this.mScale = (this.mRadius * 2.0f) / Math.min(bitmapDrawableToBitmap.getHeight(), bitmapDrawableToBitmap.getWidth());
        Matrix matrix = new Matrix();
        float f2 = this.mScale;
        matrix.setScale(f2, f2);
        bitmapShader.setLocalMatrix(matrix);
        this.mPaint.setShader(bitmapShader);
        int i = this.mRadius;
        canvas.drawCircle(i, i, i, this.mPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMin = Math.min(getMeasuredWidth(), getMeasuredHeight());
        this.mRadius = iMin / 2;
        setMeasuredDimension(iMin, iMin);
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
