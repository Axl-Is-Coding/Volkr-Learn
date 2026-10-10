package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

/* JADX INFO: loaded from: classes5.dex */
public class MultiTouchImageView extends ImageView implements SwipeToDismissTouchListener.b {
    private static final float DOUBLE_TAP_SCALE_FACTOR = 2.0f;
    private static final float MINIMUM_SCALE_FACTOR = 1.0f;
    private static final long SCALE_ANIMATION_DURATION = 300;
    boolean allowIntercept;
    final Matrix baseMatrix;
    final Matrix drawMatrix;
    final RectF drawRect;
    final GestureDetector gestureDetector;
    final float[] matrixValues;
    final ScaleGestureDetector scaleGestureDetector;
    final Matrix updateMatrix;
    final RectF viewRect;

    public MultiTouchImageView(Context context) {
        this(context, null);
    }

    public /* synthetic */ void a(float f2, float f3, ValueAnimator valueAnimator) {
        setScale(((Float) valueAnimator.getAnimatedValue()).floatValue() / getScale(), f2, f3);
        setImageMatrix();
    }

    void animateScale(float f2, float f3, final float f4, final float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, f3);
        valueAnimatorOfFloat.setDuration(SCALE_ANIMATION_DURATION);
        valueAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f20387a.a(f4, f5, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
    }

    @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.b
    public boolean canBeSwiped() {
        return getScale() == 1.0f;
    }

    Matrix getDrawMatrix() {
        this.drawMatrix.set(this.baseMatrix);
        this.drawMatrix.postConcat(this.updateMatrix);
        return this.drawMatrix;
    }

    RectF getDrawRect(Matrix matrix) {
        if (getDrawable() != null) {
            this.drawRect.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            matrix.mapRect(this.drawRect);
        }
        return this.drawRect;
    }

    float getScale() {
        this.updateMatrix.getValues(this.matrixValues);
        return this.matrixValues[0];
    }

    void initializeBaseMatrix(Drawable drawable) {
        RectF rectF = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.baseMatrix.reset();
        this.baseMatrix.setRectToRect(rectF, this.viewRect, Matrix.ScaleToFit.CENTER);
    }

    void initializeViewRect() {
        this.viewRect.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    }

    boolean isInitializationComplete() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.getIntrinsicWidth() > 0;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (isInitializationComplete()) {
            initializeViewRect();
            initializeBaseMatrix(getDrawable());
            setImageMatrix();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInitializationComplete()) {
            return false;
        }
        requestDisallowInterceptTouchEvent(true);
        return (this.gestureDetector.onTouchEvent(motionEvent) || this.scaleGestureDetector.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
    }

    void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    void reset() {
        this.updateMatrix.reset();
    }

    void setImageMatrix() {
        updateMatrixBounds();
        setScaleType(ImageView.ScaleType.MATRIX);
        setImageMatrix(getDrawMatrix());
    }

    void setScale(float f2, float f3, float f4) {
        this.updateMatrix.postScale(f2, f2, f3, f4);
    }

    void setTranslate(float f2, float f3) {
        this.updateMatrix.postTranslate(f2, f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void updateMatrixBounds() {
        /*
            r7 = this;
            android.graphics.Matrix r0 = r7.getDrawMatrix()
            android.graphics.RectF r0 = r7.getDrawRect(r0)
            float r1 = r0.height()
            android.graphics.RectF r2 = r7.viewRect
            float r2 = r2.height()
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L29
            android.graphics.RectF r1 = r7.viewRect
            float r1 = r1.height()
            float r2 = r0.height()
            float r1 = r1 - r2
            float r1 = r1 / r3
            float r2 = r0.top
        L27:
            float r1 = r1 - r2
            goto L47
        L29:
            float r1 = r0.top
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 <= 0) goto L31
            float r1 = -r1
            goto L47
        L31:
            float r1 = r0.bottom
            android.graphics.RectF r2 = r7.viewRect
            float r2 = r2.height()
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L46
            android.graphics.RectF r1 = r7.viewRect
            float r1 = r1.height()
            float r2 = r0.bottom
            goto L27
        L46:
            r1 = 0
        L47:
            float r2 = r0.width()
            android.graphics.RectF r5 = r7.viewRect
            float r5 = r5.width()
            r6 = 1
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 > 0) goto L69
            r7.allowIntercept = r6
            android.graphics.RectF r2 = r7.viewRect
            float r2 = r2.width()
            float r4 = r0.width()
            float r2 = r2 - r4
            float r2 = r2 / r3
            float r0 = r0.left
        L66:
            float r4 = r2 - r0
            goto L8d
        L69:
            float r2 = r0.left
            int r3 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r3 <= 0) goto L73
            r7.allowIntercept = r6
            float r4 = -r2
            goto L8d
        L73:
            float r2 = r0.right
            android.graphics.RectF r3 = r7.viewRect
            float r3 = r3.width()
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 >= 0) goto L8a
            r7.allowIntercept = r6
            android.graphics.RectF r2 = r7.viewRect
            float r2 = r2.width()
            float r0 = r0.right
            goto L66
        L8a:
            r0 = 0
            r7.allowIntercept = r0
        L8d:
            r7.setTranslate(r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.updateMatrixBounds():void");
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drawMatrix = new Matrix();
        this.baseMatrix = new Matrix();
        this.updateMatrix = new Matrix();
        this.viewRect = new RectF();
        this.drawRect = new RectF();
        this.matrixValues = new float[9];
        this.scaleGestureDetector = new ScaleGestureDetector(context, new i(this));
        this.gestureDetector = new GestureDetector(context, new j(this));
    }
}
