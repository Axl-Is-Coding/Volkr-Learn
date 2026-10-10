package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import cn.qqtheme.framework.widget.WheelView;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.j;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/* JADX INFO: loaded from: classes.dex */
public class BezierRadarHeader extends InternalAbstract implements g {
    protected static final byte PROPERTY_DOT_ALPHA = 2;
    protected static final byte PROPERTY_RADAR_ANGLE = 4;
    protected static final byte PROPERTY_RADAR_SCALE = 0;
    protected static final byte PROPERTY_RIPPLE_RADIUS = 3;
    protected static final byte PROPERTY_WAVE_HEIGHT = 1;
    protected int mAccentColor;
    protected Animator mAnimatorSet;
    protected float mDotAlpha;
    protected float mDotFraction;
    protected float mDotRadius;
    protected boolean mEnableHorizontalDrag;
    protected boolean mManualAccentColor;
    protected boolean mManualPrimaryColor;
    protected Paint mPaint;
    protected Path mPath;
    protected int mPrimaryColor;
    protected int mRadarAngle;
    protected float mRadarCircle;
    protected float mRadarRadius;
    protected RectF mRadarRect;
    protected float mRadarScale;
    protected float mRippleRadius;
    protected int mWaveHeight;
    protected int mWaveOffsetX;
    protected int mWaveOffsetY;
    protected boolean mWavePulling;
    protected int mWaveTop;

    /* JADX INFO: loaded from: classes4.dex */
    protected class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        byte f19165a;

        a(byte b2) {
            this.f19165a = b2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            byte b2 = this.f19165a;
            if (b2 == 0) {
                BezierRadarHeader.this.mRadarScale = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (1 == b2) {
                BezierRadarHeader bezierRadarHeader = BezierRadarHeader.this;
                if (bezierRadarHeader.mWavePulling) {
                    valueAnimator.cancel();
                    return;
                }
                bezierRadarHeader.mWaveHeight = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 2;
            } else if (2 == b2) {
                BezierRadarHeader.this.mDotAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (3 == b2) {
                BezierRadarHeader.this.mRippleRadius = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (4 == b2) {
                BezierRadarHeader.this.mRadarAngle = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            }
            BezierRadarHeader.this.invalidate();
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = isInEditMode() ? getHeight() : this.mWaveOffsetY;
        drawWave(canvas, width);
        drawDot(canvas, width, height);
        drawRadar(canvas, width, height);
        drawRipple(canvas, width, height);
        super.dispatchDraw(canvas);
    }

    protected void drawDot(Canvas canvas, int i, int i2) {
        float f2 = this.mDotAlpha;
        float f3 = WheelView.DividerConfig.FILL;
        if (f2 > WheelView.DividerConfig.FILL) {
            this.mPaint.setColor(this.mAccentColor);
            float fA = com.scwang.smartrefresh.layout.c.c.a(i2);
            float f4 = i;
            float f5 = 7.0f;
            float f6 = (f4 * 1.0f) / 7.0f;
            float f7 = this.mDotFraction;
            float f8 = (f6 * f7) - (f7 > 1.0f ? ((f7 - 1.0f) * f6) / f7 : WheelView.DividerConfig.FILL);
            float f9 = i2;
            float f10 = this.mDotFraction;
            if (f10 > 1.0f) {
                f3 = (((f10 - 1.0f) * f9) / 2.0f) / f10;
            }
            float f11 = f9 - f3;
            int i3 = 0;
            while (i3 < 7) {
                float f12 = (i3 + 1.0f) - 4.0f;
                float fAbs = (1.0f - ((Math.abs(f12) / f5) * 2.0f)) * 255.0f;
                Paint paint = this.mPaint;
                double d2 = this.mDotAlpha * fAbs;
                double d3 = fA;
                Double.isNaN(d3);
                double dPow = 1.0d - (1.0d / Math.pow((d3 / 800.0d) + 1.0d, 15.0d));
                Double.isNaN(d2);
                paint.setAlpha((int) (d2 * dPow));
                float f13 = this.mDotRadius * (1.0f - (1.0f / ((fA / 10.0f) + 1.0f)));
                canvas.drawCircle(((f4 / 2.0f) - (f13 / 2.0f)) + (f8 * f12), f11 / 2.0f, f13, this.mPaint);
                i3++;
                f5 = 7.0f;
            }
            this.mPaint.setAlpha(255);
        }
    }

    protected void drawRadar(Canvas canvas, int i, int i2) {
        if (this.mAnimatorSet != null || isInEditMode()) {
            float f2 = this.mRadarRadius;
            float f3 = this.mRadarScale;
            float f4 = f2 * f3;
            float f5 = this.mRadarCircle * f3;
            this.mPaint.setColor(this.mAccentColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            float f6 = i / 2.0f;
            float f7 = i2 / 2.0f;
            canvas.drawCircle(f6, f7, f4, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            float f8 = f5 + f4;
            canvas.drawCircle(f6, f7, f8, this.mPaint);
            this.mPaint.setColor((this.mPrimaryColor & 16777215) | 1426063360);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mRadarRect.set(f6 - f4, f7 - f4, f6 + f4, f4 + f7);
            canvas.drawArc(this.mRadarRect, 270.0f, this.mRadarAngle, true, this.mPaint);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mRadarRect.set(f6 - f8, f7 - f8, f6 + f8, f7 + f8);
            canvas.drawArc(this.mRadarRect, 270.0f, this.mRadarAngle, false, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
        }
    }

    protected void drawRipple(Canvas canvas, int i, int i2) {
        if (this.mRippleRadius > WheelView.DividerConfig.FILL) {
            this.mPaint.setColor(this.mAccentColor);
            canvas.drawCircle(i / 2.0f, i2 / 2.0f, this.mRippleRadius, this.mPaint);
        }
    }

    protected void drawWave(Canvas canvas, int i) {
        this.mPath.reset();
        this.mPath.lineTo(WheelView.DividerConfig.FILL, this.mWaveTop);
        Path path = this.mPath;
        int i2 = this.mWaveOffsetX;
        float f2 = i2 >= 0 ? i2 : i / 2.0f;
        float f3 = i;
        path.quadTo(f2, this.mWaveHeight + r3, f3, this.mWaveTop);
        this.mPath.lineTo(f3, WheelView.DividerConfig.FILL);
        this.mPaint.setColor(this.mPrimaryColor);
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public boolean isSupportHorizontalDrag() {
        return this.mEnableHorizontalDrag;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public int onFinish(j jVar, boolean z) {
        Animator animator = this.mAnimatorSet;
        if (animator != null) {
            animator.removeAllListeners();
            this.mAnimatorSet.end();
            this.mAnimatorSet = null;
        }
        int width = getWidth();
        int i = this.mWaveOffsetY;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mRadarRadius, (float) Math.sqrt((width * width) + (i * i)));
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.addUpdateListener(new a((byte) 3));
        valueAnimatorOfFloat.start();
        return 400;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onHorizontalDrag(float f2, int i, int i2) {
        this.mWaveOffsetX = i;
        invalidate();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onMoving(boolean z, float f2, int i, int i2, int i3) {
        this.mWaveOffsetY = i;
        if (z || this.mWavePulling) {
            this.mWavePulling = true;
            this.mWaveTop = Math.min(i2, i);
            this.mWaveHeight = (int) (Math.max(0, i - i2) * 1.9f);
            this.mDotFraction = f2;
            invalidate();
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    public void onReleased(j jVar, int i, int i2) {
        this.mWaveTop = i - 1;
        this.mWavePulling = false;
        com.scwang.smartrefresh.layout.c.c cVar = new com.scwang.smartrefresh.layout.c.c(com.scwang.smartrefresh.layout.c.c.f19138b);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, WheelView.DividerConfig.FILL);
        valueAnimatorOfFloat.setInterpolator(cVar);
        valueAnimatorOfFloat.addUpdateListener(new a((byte) 2));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(WheelView.DividerConfig.FILL, 1.0f);
        valueAnimatorOfFloat.setInterpolator(cVar);
        valueAnimatorOfFloat2.addUpdateListener(new a((byte) 0));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 360);
        valueAnimatorOfInt.setDuration(720L);
        valueAnimatorOfInt.setRepeatCount(-1);
        valueAnimatorOfInt.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfInt.addUpdateListener(new a((byte) 4));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(valueAnimatorOfFloat, valueAnimatorOfFloat2, valueAnimatorOfInt);
        animatorSet.start();
        int i3 = this.mWaveHeight;
        ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(i3, 0, -((int) (i3 * 0.8f)), 0, -((int) (i3 * 0.4f)), 0);
        valueAnimatorOfInt2.addUpdateListener(new a((byte) 1));
        valueAnimatorOfInt2.setInterpolator(new com.scwang.smartrefresh.layout.c.c(com.scwang.smartrefresh.layout.c.c.f19138b));
        valueAnimatorOfInt2.setDuration(800L);
        valueAnimatorOfInt2.start();
        this.mAnimatorSet = animatorSet;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.b.f
    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = com.scwang.smartrefresh.layout.header.a.f19167a[refreshState2.ordinal()];
        if (i == 1 || i == 2) {
            this.mDotAlpha = 1.0f;
            this.mRadarScale = WheelView.DividerConfig.FILL;
            this.mRippleRadius = WheelView.DividerConfig.FILL;
        }
    }

    public BezierRadarHeader setAccentColor(int i) {
        this.mAccentColor = i;
        this.mManualAccentColor = true;
        return this;
    }

    public BezierRadarHeader setAccentColorId(int i) {
        setAccentColor(androidx.core.content.b.a(getContext(), i));
        return this;
    }

    public BezierRadarHeader setEnableHorizontalDrag(boolean z) {
        this.mEnableHorizontalDrag = z;
        if (!z) {
            this.mWaveOffsetX = -1;
        }
        return this;
    }

    public BezierRadarHeader setPrimaryColor(int i) {
        this.mPrimaryColor = i;
        this.mManualPrimaryColor = true;
        return this;
    }

    public BezierRadarHeader setPrimaryColorId(int i) {
        setPrimaryColor(androidx.core.content.b.a(getContext(), i));
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.a.h
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !this.mManualPrimaryColor) {
            setPrimaryColor(iArr[0]);
            this.mManualPrimaryColor = false;
        }
        if (iArr.length <= 1 || this.mManualAccentColor) {
            return;
        }
        setAccentColor(iArr[1]);
        this.mManualAccentColor = false;
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.mEnableHorizontalDrag = false;
        this.mWaveOffsetX = -1;
        this.mWaveOffsetY = 0;
        this.mRadarAngle = 0;
        this.mRadarRadius = WheelView.DividerConfig.FILL;
        this.mRadarCircle = WheelView.DividerConfig.FILL;
        this.mRadarScale = WheelView.DividerConfig.FILL;
        this.mRadarRect = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        this.mSpinnerStyle = com.scwang.smartrefresh.layout.constant.b.f19151c;
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mDotRadius = com.scwang.smartrefresh.layout.c.c.a(7.0f);
        this.mRadarRadius = com.scwang.smartrefresh.layout.c.c.a(20.0f);
        this.mRadarCircle = com.scwang.smartrefresh.layout.c.c.a(7.0f);
        this.mPaint.setStrokeWidth(com.scwang.smartrefresh.layout.c.c.a(3.0f));
        setMinimumHeight(com.scwang.smartrefresh.layout.c.c.a(100.0f));
        if (isInEditMode()) {
            this.mWaveTop = 1000;
            this.mRadarScale = 1.0f;
            this.mRadarAngle = 270;
        } else {
            this.mRadarScale = WheelView.DividerConfig.FILL;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BezierRadarHeader);
        this.mEnableHorizontalDrag = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.mEnableHorizontalDrag);
        setAccentColor(typedArrayObtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlAccentColor, -1));
        setPrimaryColor(typedArrayObtainStyledAttributes.getColor(R.styleable.BezierRadarHeader_srlPrimaryColor, -14540254));
        this.mManualAccentColor = typedArrayObtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlAccentColor);
        this.mManualPrimaryColor = typedArrayObtainStyledAttributes.hasValue(R.styleable.BezierRadarHeader_srlPrimaryColor);
        typedArrayObtainStyledAttributes.recycle();
    }
}
