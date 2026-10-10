package com.just.agentweb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public class WebIndicator extends BaseIndicatorView implements BaseIndicatorSpec {
    private static int CURRENT_MAX_DECELERATE_SPEED_DURATION = 450;
    private static int CURRENT_MAX_UNIFORM_SPEED_DURATION = 8000;
    public static final int DO_END_ANIMATION_DURATION = 600;
    public static final int FINISH = 2;
    public static final int MAX_DECELERATE_SPEED_DURATION = 450;
    public static final int MAX_UNIFORM_SPEED_DURATION = 8000;
    public static final int STARTED = 1;
    public static final int UN_START = 0;
    public static int WEB_INDICATOR_DEFAULT_HEIGHT = 3;
    private int TAG;
    private Animator mAnimator;
    private AnimatorListenerAdapter mAnimatorListenerAdapter;
    private ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    private int mColor;
    private float mCurrentProgress;
    private Paint mPaint;
    private float mTarget;
    private int mTargetWidth;

    public WebIndicator(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEnd() {
        if (this.TAG == 2 && this.mCurrentProgress == 100.0f) {
            setVisibility(8);
            this.mCurrentProgress = WheelView.DividerConfig.FILL;
            setAlpha(1.0f);
        }
        this.TAG = 0;
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mPaint = new Paint();
        this.mColor = Color.parseColor("#1aad19");
        this.mPaint.setAntiAlias(true);
        this.mPaint.setColor(this.mColor);
        this.mPaint.setDither(true);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mTargetWidth = context.getResources().getDisplayMetrics().widthPixels;
        WEB_INDICATOR_DEFAULT_HEIGHT = AgentWebUtils.dp2px(context, 3.0f);
    }

    private void startAnim(boolean z) {
        AnimatorSet animatorSet;
        float f2 = z ? 100.0f : 95.0f;
        Animator animator = this.mAnimator;
        if (animator != null && animator.isStarted()) {
            this.mAnimator.cancel();
        }
        float f3 = this.mCurrentProgress;
        if (f3 == WheelView.DividerConfig.FILL) {
            f3 = 1.0E-8f;
        }
        this.mCurrentProgress = f3;
        LogUtils.i("WebIndicator", "mCurrentProgress:" + this.mCurrentProgress + " v:" + f2 + "  :" + (1.0f - this.mCurrentProgress));
        if (z) {
            ValueAnimator valueAnimatorOfFloat = null;
            float f4 = this.mCurrentProgress;
            if (f4 < 95.0f) {
                valueAnimatorOfFloat = ValueAnimator.ofFloat(f4, 95.0f);
                float f5 = (1.0f - (this.mCurrentProgress / 100.0f)) - 0.05f;
                valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                valueAnimatorOfFloat.setDuration((long) (f5 * CURRENT_MAX_DECELERATE_SPEED_DURATION));
                valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
                valueAnimatorOfFloat.addUpdateListener(this.mAnimatorUpdateListener);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, WheelView.DividerConfig.FILL);
            objectAnimatorOfFloat.setDuration(600L);
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(95.0f, 100.0f);
            valueAnimatorOfFloat2.setDuration(600L);
            valueAnimatorOfFloat2.addUpdateListener(this.mAnimatorUpdateListener);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(objectAnimatorOfFloat, valueAnimatorOfFloat2);
            if (valueAnimatorOfFloat != null) {
                animatorSet = new AnimatorSet();
                animatorSet.play(animatorSet2).after(valueAnimatorOfFloat);
            } else {
                animatorSet = animatorSet2;
            }
            animatorSet.addListener(this.mAnimatorListenerAdapter);
            animatorSet.start();
            this.mAnimator = animatorSet;
        } else {
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(this.mCurrentProgress, f2);
            float f6 = (1.0f - (this.mCurrentProgress / 100.0f)) - 0.05f;
            valueAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat3.setDuration((long) (f6 * CURRENT_MAX_UNIFORM_SPEED_DURATION));
            valueAnimatorOfFloat3.addUpdateListener(this.mAnimatorUpdateListener);
            valueAnimatorOfFloat3.start();
            this.mAnimator = valueAnimatorOfFloat3;
        }
        this.TAG = 1;
        this.mTarget = f2;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawRect(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (this.mCurrentProgress / 100.0f) * Float.valueOf(getWidth()).floatValue(), getHeight(), this.mPaint);
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void hide() {
        this.TAG = 2;
    }

    @Override // com.just.agentweb.LayoutParamsOffer
    public FrameLayout.LayoutParams offerLayoutParams() {
        return new FrameLayout.LayoutParams(-1, WEB_INDICATOR_DEFAULT_HEIGHT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mAnimator;
        if (animator == null || !animator.isStarted()) {
            return;
        }
        this.mAnimator.cancel();
        this.mAnimator = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && size > getContext().getResources().getDisplayMetrics().widthPixels) {
            size = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = WEB_INDICATOR_DEFAULT_HEIGHT;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mTargetWidth = getMeasuredWidth();
        int i5 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i6 = this.mTargetWidth;
        if (i6 >= i5) {
            CURRENT_MAX_DECELERATE_SPEED_DURATION = 450;
            CURRENT_MAX_UNIFORM_SPEED_DURATION = MAX_UNIFORM_SPEED_DURATION;
        } else {
            float fFloatValue = i6 / Float.valueOf(i5).floatValue();
            CURRENT_MAX_UNIFORM_SPEED_DURATION = (int) (8000.0f * fFloatValue);
            CURRENT_MAX_DECELERATE_SPEED_DURATION = (int) (fFloatValue * 450.0f);
        }
        LogUtils.i("WebProgress", "CURRENT_MAX_UNIFORM_SPEED_DURATION" + CURRENT_MAX_UNIFORM_SPEED_DURATION);
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void reset() {
        this.mCurrentProgress = WheelView.DividerConfig.FILL;
        Animator animator = this.mAnimator;
        if (animator == null || !animator.isStarted()) {
            return;
        }
        this.mAnimator.cancel();
    }

    public void setColor(int i) {
        this.mColor = i;
        this.mPaint.setColor(i);
    }

    public void setProgress(float f2) {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (f2 >= 95.0f && this.TAG != 2) {
            startAnim(true);
        }
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void show() {
        if (getVisibility() == 8) {
            setVisibility(0);
            this.mCurrentProgress = WheelView.DividerConfig.FILL;
            startAnim(false);
        }
    }

    public WebIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTargetWidth = 0;
        this.TAG = 0;
        this.mTarget = WheelView.DividerConfig.FILL;
        this.mCurrentProgress = WheelView.DividerConfig.FILL;
        this.mAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.just.agentweb.WebIndicator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WebIndicator.this.mCurrentProgress = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                WebIndicator.this.invalidate();
            }
        };
        this.mAnimatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.just.agentweb.WebIndicator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                WebIndicator.this.doEnd();
            }
        };
        init(context, attributeSet, i);
    }

    public void setColor(String str) {
        setColor(Color.parseColor(str));
    }

    @Override // com.just.agentweb.BaseIndicatorView, com.just.agentweb.BaseIndicatorSpec
    public void setProgress(int i) {
        setProgress(Float.valueOf(i).floatValue());
    }
}
