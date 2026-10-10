package com.warkiz.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes5.dex */
public class ArrowView extends View {
    private final int mHeight;
    private final Paint mPaint;
    private final Path mPath;
    private final int mWidth;

    public ArrowView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(this.mPath, this.mPaint);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    void setColor(int i) {
        this.mPaint.setColor(i);
        invalidate();
    }

    public ArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArrowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWidth = j.a(context, 12.0f);
        this.mHeight = j.a(context, 7.0f);
        this.mPath = new Path();
        this.mPath.moveTo(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        this.mPath.lineTo(this.mWidth, WheelView.DividerConfig.FILL);
        this.mPath.lineTo(this.mWidth / 2.0f, this.mHeight);
        this.mPath.close();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeWidth(1.0f);
    }
}
