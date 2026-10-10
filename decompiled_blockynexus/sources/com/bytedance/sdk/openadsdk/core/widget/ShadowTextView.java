package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
public class ShadowTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f6555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RectF f6556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6557c;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    private void a() {
        setTextColor(-1);
        this.f6555a = new Paint();
        this.f6555a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6555a.setColor(Color.parseColor("#99333333"));
        this.f6555a.setAntiAlias(true);
        this.f6555a.setStrokeWidth(WheelView.DividerConfig.FILL);
        this.f6556b = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f6556b;
        float f2 = rectF.bottom;
        canvas.drawRoundRect(rectF, f2 / 2.0f, f2 / 2.0f, this.f6555a);
        canvas.translate((this.f6556b.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), WheelView.DividerConfig.FILL);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            this.f6556b.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
            return;
        }
        this.f6557c = (int) getPaint().measureText("00");
        int i3 = this.f6557c;
        if (measuredWidth < i3) {
            measuredWidth = i3;
        }
        int i4 = measuredWidth + ((measuredHeight / 2) * 2);
        setMeasuredDimension(i4, measuredHeight);
        this.f6556b.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, i4, measuredHeight);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6557c = 0;
        a();
    }
}
