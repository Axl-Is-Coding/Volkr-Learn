package com.sandboxol.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.R;

/* JADX INFO: loaded from: classes3.dex */
public class RoundImageView extends AppCompatImageView {
    private static final int BODER_RADIUS_DEFAULT = 0;
    private static final String STATE_BORDER_RADIUS = "state_border_radius";
    private static final String STATE_INSTANCE = "state_instance";
    private static final String STATE_TYPE = "state_type";
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_ROUND = 1;
    private Paint mBitmapPaint;
    private BitmapShader mBitmapShader;
    private int mBorderRadius;
    private Matrix mMatrix;
    private int mRadius;
    private RectF mRoundRect;
    private int mWidth;
    private int type;

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.mBitmapPaint = new Paint();
        this.mBitmapPaint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundImageView);
        this.mBorderRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundImageView_borderRadius, (int) TypedValue.applyDimension(1, WheelView.DividerConfig.FILL, getResources().getDisplayMetrics()));
        this.type = typedArrayObtainStyledAttributes.getInt(R.styleable.RoundImageView_roundType, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = 1;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void setUpShader() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Bitmap bitmapDrawableToBitamp = drawableToBitamp(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(bitmapDrawableToBitamp, tileMode, tileMode);
        float fMax = 1.0f;
        if (this.type == 0 && bitmapDrawableToBitamp != null) {
            fMax = (this.mWidth * 1.0f) / Math.min(bitmapDrawableToBitamp.getWidth(), bitmapDrawableToBitamp.getHeight());
        } else if (this.type == 1 && bitmapDrawableToBitamp != null && (bitmapDrawableToBitamp.getWidth() != getWidth() || bitmapDrawableToBitamp.getHeight() != getHeight())) {
            fMax = Math.max((getWidth() * 1.0f) / bitmapDrawableToBitamp.getWidth(), (getHeight() * 1.0f) / bitmapDrawableToBitamp.getHeight());
        }
        this.mMatrix.setScale(fMax, fMax);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mBitmapPaint.setShader(this.mBitmapShader);
    }

    public int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, i, getResources().getDisplayMetrics());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() == null || this.mRoundRect == null) {
            return;
        }
        setUpShader();
        if (this.type != 1) {
            int i = this.mRadius;
            canvas.drawCircle(i, i, i, this.mBitmapPaint);
        } else {
            RectF rectF = this.mRoundRect;
            int i2 = this.mBorderRadius;
            canvas.drawRoundRect(rectF, i2, i2, this.mBitmapPaint);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.type == 0) {
            this.mWidth = Math.min(getMeasuredWidth(), getMeasuredWidth());
            int i3 = this.mWidth;
            this.mRadius = i3 / 2;
            setMeasuredDimension(i3, i3);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(STATE_INSTANCE));
        this.type = bundle.getInt(STATE_TYPE);
        this.mBorderRadius = bundle.getInt(STATE_BORDER_RADIUS);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_INSTANCE, super.onSaveInstanceState());
        bundle.putInt(STATE_TYPE, this.type);
        bundle.putInt(STATE_BORDER_RADIUS, this.mBorderRadius);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.type == 1) {
            this.mRoundRect = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, i, i2);
        }
    }

    public void setBorderRadius(int i) {
        int iDp2px = dp2px(i);
        if (this.mBorderRadius != iDp2px) {
            this.mBorderRadius = iDp2px;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.type != i) {
            this.type = i;
            int i2 = this.type;
            if (i2 != 1 && i2 != 0) {
                this.type = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context) {
        this(context, null);
    }
}
