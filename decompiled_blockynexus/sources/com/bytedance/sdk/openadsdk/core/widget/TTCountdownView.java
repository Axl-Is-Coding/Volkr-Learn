package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: loaded from: classes.dex */
public class TTCountdownView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6564a = t.a(o.a(), "tt_count_down_view");
    private ValueAnimator A;
    private boolean B;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f6565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f6569f;
    private float g;
    private float h;
    private int i;
    private boolean j;
    private float k;
    private float l;
    private float m;
    private String n;
    private boolean o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Paint s;
    private float t;
    private float u;
    private RectF v;
    private a w;
    private AnimatorSet x;
    private ValueAnimator y;
    private ValueAnimator z;

    public interface a {
    }

    public TTCountdownView(Context context) {
        this(context, null);
    }

    private void c() {
        float f2 = this.h;
        this.v = new RectF(-f2, -f2, f2, f2);
    }

    private int d() {
        return (int) ((((this.f6569f / 2.0f) + this.h) * 2.0f) + a(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.z = null;
        }
        this.z = ValueAnimator.ofFloat(this.t, WheelView.DividerConfig.FILL);
        this.z.setInterpolator(new LinearInterpolator());
        this.z.setDuration((long) (a(this.t, this.k) * 1000.0f));
        this.z.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownView.this.t = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.z;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y = null;
        }
        this.y = ValueAnimator.ofFloat(this.u, WheelView.DividerConfig.FILL);
        this.y.setInterpolator(new LinearInterpolator());
        this.y.setDuration((long) (a(this.u, this.l) * 1000.0f));
        this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownView.this.u = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.y;
    }

    public float a(float f2, float f3) {
        return f2 * f3;
    }

    public float a(float f2, int i) {
        return i * f2;
    }

    public a getCountdownListener() {
        return this.w;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = d();
        }
        if (mode2 != 1073741824) {
            size2 = d();
        }
        setMeasuredDimension(size, size2);
    }

    public void setCountDownTime(int i) {
        float f2 = i;
        this.l = f2;
        this.k = f2;
        a();
    }

    public void setCountdownListener(a aVar) {
        this.w = aVar;
    }

    public TTCountdownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Canvas canvas) {
        String str;
        canvas.save();
        Paint.FontMetrics fontMetrics = this.s.getFontMetrics();
        String str2 = f6564a;
        if (this.o) {
            str = "" + ((int) Math.ceil(a(this.u, this.l)));
        } else {
            str = this.n;
        }
        if (TextUtils.isEmpty(str)) {
            str = f6564a;
        }
        canvas.drawText(str, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.s);
        canvas.restore();
    }

    private void b() {
        this.p = new Paint(1);
        this.p.setColor(this.f6565b);
        this.p.setStrokeWidth(this.f6569f);
        this.p.setAntiAlias(true);
        this.p.setStyle(Paint.Style.STROKE);
        this.q = new Paint(1);
        this.q.setColor(this.f6567d);
        this.q.setAntiAlias(true);
        this.q.setStrokeWidth(this.f6569f);
        this.q.setStyle(Paint.Style.FILL);
        this.r = new Paint(1);
        this.r.setColor(this.f6566c);
        this.r.setAntiAlias(true);
        this.r.setStrokeWidth(this.f6569f / 2.0f);
        this.r.setStyle(Paint.Style.STROKE);
        this.s = new Paint(1);
        this.s.setColor(this.f6568e);
        this.r.setAntiAlias(true);
        this.s.setTextSize(this.g);
        this.s.setTextAlign(Paint.Align.CENTER);
    }

    public TTCountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6565b = Color.parseColor("#fce8b6");
        this.f6566c = Color.parseColor("#f0f0f0");
        this.f6567d = Color.parseColor("#ffffff");
        this.f6568e = Color.parseColor("#7c7c7c");
        this.f6569f = 2.0f;
        this.g = 12.0f;
        this.h = 18.0f;
        this.i = 270;
        this.j = false;
        this.k = 5.0f;
        this.l = 5.0f;
        this.m = 0.8f;
        this.n = f6564a;
        this.o = false;
        this.t = 1.0f;
        this.u = 1.0f;
        this.B = false;
        this.f6569f = a(2.0f);
        this.h = a(18.0f);
        this.g = b(12.0f);
        this.i %= 360;
        b();
        c();
    }

    public void a() {
        AnimatorSet animatorSet = this.x;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.x = null;
        }
        ValueAnimator valueAnimator = this.A;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.A = null;
        }
        ValueAnimator valueAnimator2 = this.y;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.y = null;
        }
        ValueAnimator valueAnimator3 = this.z;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.z = null;
        }
        this.t = 1.0f;
        this.u = 1.0f;
        invalidate();
    }

    private void b(Canvas canvas) {
        float f2;
        canvas.save();
        float fA = a(this.t, 360);
        if (this.j) {
            f2 = this.i - fA;
        } else {
            f2 = this.i;
        }
        canvas.drawCircle(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.h, this.q);
        canvas.drawCircle(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.h, this.r);
        canvas.drawArc(this.v, f2, fA, false, this.p);
        canvas.restore();
    }

    private float a(float f2) {
        return TypedValue.applyDimension(1, f2, getResources().getDisplayMetrics());
    }

    private float b(float f2) {
        return TypedValue.applyDimension(2, f2, getResources().getDisplayMetrics());
    }
}
