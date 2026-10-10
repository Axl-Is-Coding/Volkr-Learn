package com.sandboxol.center.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.sandboxol.center.R;

/* JADX INFO: loaded from: classes3.dex */
public class CircleProgressView extends View {
    private int circleColor;
    private Paint mPaint;
    private int maxProgress;
    private int progress;
    private int progressColor;
    private int progressWidth;

    public CircleProgressView(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        this.mPaint = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar, i, 0);
        this.circleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressBar_circleColor, getResources().getColor(R.color.colorPrimaryDark));
        this.progressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progressColor, getResources().getColor(R.color.colorAccent));
        this.progressWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.CircleProgressBar_progressWidth, this.progressWidth);
        this.progress = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleProgressBar_progress, 0);
        this.maxProgress = typedArrayObtainStyledAttributes.getInt(R.styleable.CircleProgressBar_maxProgress, 1);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int dp2px(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth() / 2;
        int i = width - (this.progressWidth / 2);
        this.mPaint.setColor(this.circleColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.progressWidth);
        this.mPaint.setAntiAlias(true);
        float f2 = width;
        canvas.drawCircle(f2, f2, i, this.mPaint);
        float f3 = (this.progress * 360) / this.maxProgress;
        this.mPaint.setColor(this.progressColor);
        this.mPaint.setDither(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        float f4 = width - i;
        float f5 = width + i;
        canvas.drawArc(new RectF(f4, f4, f5, f5), -90.0f, f3, false, this.mPaint);
    }

    public void setProgress(int i) {
        this.progress = i;
        invalidate();
    }

    public void setProgressPercent(int i, int i2) {
        this.progress = i;
        this.maxProgress = i2;
        invalidate();
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.progress = 0;
        this.maxProgress = 1;
        this.progressWidth = 20;
        init(context, attributeSet, i);
    }
}
