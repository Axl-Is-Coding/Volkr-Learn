package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.webkit.WebView;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: loaded from: classes.dex */
public class TTCornersWebView extends WebView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Paint f6562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Paint f6563f;
    private float[] g;

    public TTCornersWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new float[]{WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL};
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f6562e = new Paint();
        this.f6562e.setColor(-1);
        this.f6562e.setAntiAlias(true);
        this.f6562e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f6563f = new Paint();
        this.f6563f.setXfermode(null);
        this.f6563f.setAntiAlias(true);
        float fA = ac.a(context, 14.0f);
        a(fA, fA, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f6560c = getScrollX();
        this.f6561d = getScrollY();
        Path path = new Path();
        path.addRoundRect(new RectF(WheelView.DividerConfig.FILL, this.f6561d, this.f6560c + this.f6558a, r2 + this.f6559b), this.g, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f6558a = getMeasuredWidth();
        this.f6559b = getMeasuredHeight();
    }

    public TTCornersWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = new float[]{WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL};
        a(context, attributeSet);
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.g;
        fArr[0] = f2;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f3;
        fArr[4] = f4;
        fArr[5] = f4;
        fArr[6] = f5;
        fArr[7] = f5;
    }
}
