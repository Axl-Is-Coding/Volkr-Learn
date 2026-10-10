package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.bytedance.sdk.openadsdk.utils.ac;

/* JADX INFO: loaded from: classes.dex */
public class NiceImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f5726f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Xfermode n;
    private int o;
    private int p;
    private float q;
    private float[] r;
    private float[] s;
    private RectF t;
    private RectF u;
    private Paint v;
    private Path w;
    private Path x;

    public NiceImageView(Context context) {
        this(context, null);
    }

    private void a(Canvas canvas) {
        if (!this.f5722b) {
            int i = this.f5724d;
            if (i > 0) {
                a(canvas, i, this.f5725e, this.u, this.r);
                return;
            }
            return;
        }
        int i2 = this.f5724d;
        if (i2 > 0) {
            a(canvas, i2, this.f5725e, this.q - (i2 / 2.0f));
        }
        int i3 = this.f5726f;
        if (i3 > 0) {
            a(canvas, i3, this.g, (this.q - this.f5724d) - (i3 / 2.0f));
        }
    }

    private void b() {
        if (!this.f5722b) {
            this.t.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, this.o, this.p);
            if (this.f5723c) {
                this.t = this.u;
                return;
            }
            return;
        }
        this.q = Math.min(this.o, this.p) / 2.0f;
        RectF rectF = this.t;
        int i = this.o;
        float f2 = this.q;
        int i2 = this.p;
        rectF.set((i / 2.0f) - f2, (i2 / 2.0f) - f2, (i / 2.0f) + f2, (i2 / 2.0f) + f2);
    }

    private void c() {
        if (this.f5722b) {
            return;
        }
        int i = 0;
        if (this.h <= 0) {
            float[] fArr = this.r;
            int i2 = this.i;
            float f2 = i2;
            fArr[1] = f2;
            fArr[0] = f2;
            int i3 = this.j;
            float f3 = i3;
            fArr[3] = f3;
            fArr[2] = f3;
            int i4 = this.l;
            float f4 = i4;
            fArr[5] = f4;
            fArr[4] = f4;
            int i5 = this.k;
            float f5 = i5;
            fArr[7] = f5;
            fArr[6] = f5;
            float[] fArr2 = this.s;
            int i6 = this.f5724d;
            float f6 = i2 - (i6 / 2.0f);
            fArr2[1] = f6;
            fArr2[0] = f6;
            float f7 = i3 - (i6 / 2.0f);
            fArr2[3] = f7;
            fArr2[2] = f7;
            float f8 = i4 - (i6 / 2.0f);
            fArr2[5] = f8;
            fArr2[4] = f8;
            float f9 = i5 - (i6 / 2.0f);
            fArr2[7] = f9;
            fArr2[6] = f9;
            return;
        }
        while (true) {
            float[] fArr3 = this.r;
            if (i >= fArr3.length) {
                return;
            }
            int i7 = this.h;
            fArr3[i] = i7;
            this.s[i] = i7 - (this.f5724d / 2.0f);
            i++;
        }
    }

    private void d() {
        if (this.f5722b) {
            return;
        }
        this.f5726f = 0;
    }

    public void isCircle(boolean z) {
        this.f5722b = z;
        d();
        b();
        invalidate();
    }

    public void isCoverSrc(boolean z) {
        this.f5723c = z;
        b();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.t, null, 31);
        if (!this.f5723c) {
            int i = this.o;
            int i2 = this.f5724d;
            int i3 = this.f5726f;
            int i4 = this.p;
            canvas.scale((((i - (i2 * 2)) - (i3 * 2)) * 1.0f) / i, (((i4 - (i2 * 2)) - (i3 * 2)) * 1.0f) / i4, i / 2.0f, i4 / 2.0f);
        }
        super.onDraw(canvas);
        this.v.reset();
        this.w.reset();
        if (this.f5722b) {
            this.w.addCircle(this.o / 2.0f, this.p / 2.0f, this.q, Path.Direction.CCW);
        } else {
            this.w.addRoundRect(this.t, this.s, Path.Direction.CCW);
        }
        this.v.setAntiAlias(true);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setXfermode(this.n);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.w, this.v);
        } else {
            this.x.addRect(this.t, Path.Direction.CCW);
            this.x.op(this.w, Path.Op.DIFFERENCE);
            canvas.drawPath(this.x, this.v);
        }
        this.v.setXfermode(null);
        int i5 = this.m;
        if (i5 != 0) {
            this.v.setColor(i5);
            canvas.drawPath(this.w, this.v);
        }
        canvas.restore();
        a(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.o = i;
        this.p = i2;
        a();
        b();
    }

    public void setBorderColor(int i) {
        this.f5725e = i;
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.f5724d = ac.c(this.f5721a, i);
        a(false);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.k = ac.c(this.f5721a, i);
        a(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.l = ac.c(this.f5721a, i);
        a(true);
    }

    public void setCornerRadius(int i) {
        this.h = ac.c(this.f5721a, i);
        a(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.i = ac.c(this.f5721a, i);
        a(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.j = ac.c(this.f5721a, i);
        a(true);
    }

    public void setInnerBorderColor(int i) {
        this.g = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.f5726f = ac.c(this.f5721a, i);
        d();
        invalidate();
    }

    public void setMaskColor(int i) {
        this.m = i;
        invalidate();
    }

    public NiceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5725e = -1;
        this.g = -1;
        this.f5721a = context;
        this.h = ac.c(context, 10.0f);
        this.r = new float[8];
        this.s = new float[8];
        this.u = new RectF();
        this.t = new RectF();
        this.v = new Paint();
        this.w = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.x = new Path();
        }
        c();
        d();
    }

    private void a(Canvas canvas, int i, int i2, float f2) {
        a(i, i2);
        this.w.addCircle(this.o / 2.0f, this.p / 2.0f, f2, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        a(i, i2);
        this.w.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(int i, int i2) {
        this.w.reset();
        this.v.setStrokeWidth(i);
        this.v.setColor(i2);
        this.v.setStyle(Paint.Style.STROKE);
    }

    private void a() {
        if (this.f5722b) {
            return;
        }
        RectF rectF = this.u;
        int i = this.f5724d;
        rectF.set(i / 2.0f, i / 2.0f, this.o - (i / 2.0f), this.p - (i / 2.0f));
    }

    private void a(boolean z) {
        if (z) {
            this.h = 0;
        }
        c();
        a();
        invalidate();
    }
}
