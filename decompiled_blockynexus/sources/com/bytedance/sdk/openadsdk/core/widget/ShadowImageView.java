package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class ShadowImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f6553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RectF f6554b;

    public ShadowImageView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6553a = new Paint();
        this.f6553a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6553a.setColor(Color.parseColor("#99333333"));
        this.f6553a.setAntiAlias(true);
        this.f6553a.setStrokeWidth(WheelView.DividerConfig.FILL);
        this.f6554b = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.f6554b;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, rectF.bottom / 2.0f, this.f6553a);
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f6554b.right == getMeasuredWidth() && this.f6554b.bottom == getMeasuredHeight()) {
            return;
        }
        this.f6554b.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, getMeasuredWidth(), getMeasuredHeight());
    }

    public ShadowImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ShadowImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
