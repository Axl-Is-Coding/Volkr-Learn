package io.rong.imkit.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes5.dex */
public class CircleProgressView extends View {
    private static final int animDuration = 2000;
    private static final int progressCirclePadding = 3;
    private static final float startAngle = -90.0f;
    private boolean fillIn;
    private CircleProgressViewAnim mCircleProgressViewAnim;
    private Paint paintBgCircle;
    private Paint paintCircle;
    private Paint paintProgressCircle;
    private float sweepAngle;

    private class CircleProgressViewAnim extends Animation {
        private CircleProgressViewAnim() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            if (f2 >= 1.0f) {
                CircleProgressView circleProgressView = CircleProgressView.this;
                circleProgressView.startAnimAutomatic(circleProgressView.fillIn);
            } else {
                CircleProgressView.this.sweepAngle = f2 * 360.0f;
                CircleProgressView.this.invalidate();
            }
        }
    }

    public CircleProgressView(Context context) {
        super(context);
        this.sweepAngle = WheelView.DividerConfig.FILL;
        this.fillIn = false;
        init();
    }

    private void init() {
        this.mCircleProgressViewAnim = new CircleProgressViewAnim();
        this.mCircleProgressViewAnim.setDuration(2000L);
        this.paintBgCircle = new Paint();
        this.paintBgCircle.setAntiAlias(true);
        this.paintBgCircle.setStyle(Paint.Style.STROKE);
        this.paintBgCircle.setColor(-855638017);
        this.paintCircle = new Paint();
        this.paintCircle.setAntiAlias(true);
        this.paintCircle.setStyle(Paint.Style.FILL);
        this.paintCircle.setColor(-7829368);
        this.paintProgressCircle = new Paint();
        this.paintProgressCircle.setAntiAlias(true);
        this.paintProgressCircle.setStyle(Paint.Style.FILL);
        this.paintProgressCircle.setColor(-855638017);
    }

    public int dip2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredWidth() / 2, getMeasuredWidth() / 2, this.paintBgCircle);
        canvas.drawArc(new RectF(3.0f, 3.0f, getMeasuredWidth() - 3, getMeasuredWidth() - 3), startAngle, this.sweepAngle, true, this.paintProgressCircle);
        if (this.fillIn) {
            return;
        }
        canvas.drawCircle(getMeasuredWidth() / 2, getMeasuredWidth() / 2, (getMeasuredWidth() / 2) - 6, this.paintCircle);
    }

    public void setProgress(int i, boolean z) {
        this.fillIn = z;
        double d2 = i;
        Double.isNaN(d2);
        this.sweepAngle = (float) (d2 * 3.6d);
        invalidate();
    }

    public void startAnimAutomatic(boolean z) {
        this.fillIn = z;
        if (this.mCircleProgressViewAnim != null) {
            clearAnimation();
        }
        startAnimation(this.mCircleProgressViewAnim);
    }

    public void stopAnimAutomatic() {
        if (this.mCircleProgressViewAnim != null) {
            clearAnimation();
        }
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sweepAngle = WheelView.DividerConfig.FILL;
        this.fillIn = false;
        init();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sweepAngle = WheelView.DividerConfig.FILL;
        this.fillIn = false;
        init();
    }
}
