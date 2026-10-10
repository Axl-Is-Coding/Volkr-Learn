package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: CircularProgressDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Interpolator f2095a = new LinearInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Interpolator f2096b = new androidx.interpolator.a.a.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f2097c = {-16777216};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f2098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2099e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Resources f2100f;
    private Animator g;
    float h;
    boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: CircularProgressDrawable.java */
    static class a {
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float q;
        int r;
        int s;
        int u;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final RectF f2101a = new RectF();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Paint f2102b = new Paint();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Paint f2103c = new Paint();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Paint f2104d = new Paint();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2105e = WheelView.DividerConfig.FILL;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f2106f = WheelView.DividerConfig.FILL;
        float g = WheelView.DividerConfig.FILL;
        float h = 5.0f;
        float p = 1.0f;
        int t = 255;

        a() {
            this.f2102b.setStrokeCap(Paint.Cap.SQUARE);
            this.f2102b.setAntiAlias(true);
            this.f2102b.setStyle(Paint.Style.STROKE);
            this.f2103c.setStyle(Paint.Style.FILL);
            this.f2103c.setAntiAlias(true);
            this.f2104d.setColor(0);
        }

        void a(float f2, float f3) {
            this.r = (int) f2;
            this.s = (int) f3;
        }

        void b(int i) {
            this.u = i;
        }

        void c(int i) {
            this.j = i;
            this.u = this.i[this.j];
        }

        int d() {
            return (this.j + 1) % this.i.length;
        }

        void e(float f2) {
            this.f2105e = f2;
        }

        void f(float f2) {
            this.h = f2;
            this.f2102b.setStrokeWidth(f2);
        }

        float g() {
            return this.l;
        }

        float h() {
            return this.m;
        }

        float i() {
            return this.k;
        }

        void j() {
            c(d());
        }

        void k() {
            this.k = WheelView.DividerConfig.FILL;
            this.l = WheelView.DividerConfig.FILL;
            this.m = WheelView.DividerConfig.FILL;
            e(WheelView.DividerConfig.FILL);
            c(WheelView.DividerConfig.FILL);
            d(WheelView.DividerConfig.FILL);
        }

        void l() {
            this.k = this.f2105e;
            this.l = this.f2106f;
            this.m = this.g;
        }

        float b() {
            return this.f2106f;
        }

        void d(float f2) {
            this.g = f2;
        }

        float e() {
            return this.f2105e;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f2101a;
            float f2 = this.q;
            float fMin = (this.h / 2.0f) + f2;
            if (f2 <= WheelView.DividerConfig.FILL) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.r * this.p) / 2.0f, this.h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f3 = this.f2105e;
            float f4 = this.g;
            float f5 = (f3 + f4) * 360.0f;
            float f6 = ((this.f2106f + f4) * 360.0f) - f5;
            this.f2102b.setColor(this.u);
            this.f2102b.setAlpha(this.t);
            float f7 = this.h / 2.0f;
            rectF.inset(f7, f7);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f2104d);
            float f8 = -f7;
            rectF.inset(f8, f8);
            canvas.drawArc(rectF, f5, f6, false, this.f2102b);
            a(canvas, f5, f6, rectF);
        }

        void b(float f2) {
            this.q = f2;
        }

        int c() {
            return this.i[d()];
        }

        int f() {
            return this.i[this.j];
        }

        void c(float f2) {
            this.f2106f = f2;
        }

        void a(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    this.o = new Path();
                    this.o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f4 = (this.r * this.p) / 2.0f;
                this.o.moveTo(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
                this.o.lineTo(this.r * this.p, WheelView.DividerConfig.FILL);
                Path path2 = this.o;
                float f5 = this.r;
                float f6 = this.p;
                path2.lineTo((f5 * f6) / 2.0f, this.s * f6);
                this.o.offset((fMin + rectF.centerX()) - f4, rectF.centerY() + (this.h / 2.0f));
                this.o.close();
                this.f2103c.setColor(this.u);
                this.f2103c.setAlpha(this.t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.o, this.f2103c);
                canvas.restore();
            }
        }

        void a(int[] iArr) {
            this.i = iArr;
            c(0);
        }

        void a(ColorFilter colorFilter) {
            this.f2102b.setColorFilter(colorFilter);
        }

        void a(int i) {
            this.t = i;
        }

        int a() {
            return this.t;
        }

        void a(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }

        void a(float f2) {
            if (f2 != this.p) {
                this.p = f2;
            }
        }
    }

    public d(Context context) {
        androidx.core.f.h.a(context);
        this.f2100f = context.getResources();
        this.f2098d = new a();
        this.f2098d.a(f2097c);
        c(2.5f);
        a();
    }

    private int a(float f2, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f2))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f2))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f2))) << 8) | ((i & 255) + ((int) (f2 * ((i2 & 255) - r8))));
    }

    private void a(float f2, float f3, float f4, float f5) {
        a aVar = this.f2098d;
        float f6 = this.f2100f.getDisplayMetrics().density;
        aVar.f(f3 * f6);
        aVar.b(f2 * f6);
        aVar.c(0);
        aVar.a(f4 * f6, f5 * f6);
    }

    private void d(float f2) {
        this.f2099e = f2;
    }

    public void b(float f2) {
        this.f2098d.d(f2);
        invalidateSelf();
    }

    public void c(float f2) {
        this.f2098d.f(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f2099e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f2098d.a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2098d.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2098d.a(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2098d.a(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.g.cancel();
        this.f2098d.l();
        if (this.f2098d.b() != this.f2098d.e()) {
            this.i = true;
            this.g.setDuration(666L);
            this.g.start();
        } else {
            this.f2098d.c(0);
            this.f2098d.k();
            this.g.setDuration(1332L);
            this.g.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.g.cancel();
        d(WheelView.DividerConfig.FILL);
        this.f2098d.a(false);
        this.f2098d.c(0);
        this.f2098d.k();
        invalidateSelf();
    }

    private void b(float f2, a aVar) {
        a(f2, aVar);
        float fFloor = (float) (Math.floor(aVar.h() / 0.8f) + 1.0d);
        aVar.e(aVar.i() + (((aVar.g() - 0.01f) - aVar.i()) * f2));
        aVar.c(aVar.g());
        aVar.d(aVar.h() + ((fFloor - aVar.h()) * f2));
    }

    public void a(int i) {
        if (i == 0) {
            a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void a(boolean z) {
        this.f2098d.a(z);
        invalidateSelf();
    }

    public void a(float f2) {
        this.f2098d.a(f2);
        invalidateSelf();
    }

    public void a(float f2, float f3) {
        this.f2098d.e(f2);
        this.f2098d.c(f3);
        invalidateSelf();
    }

    public void a(int... iArr) {
        this.f2098d.a(iArr);
        this.f2098d.c(0);
        invalidateSelf();
    }

    void a(float f2, a aVar) {
        if (f2 > 0.75f) {
            aVar.b(a((f2 - 0.75f) / 0.25f, aVar.f(), aVar.c()));
        } else {
            aVar.b(aVar.f());
        }
    }

    void a(float f2, a aVar, boolean z) {
        float fI;
        float interpolation;
        if (this.i) {
            b(f2, aVar);
            return;
        }
        if (f2 != 1.0f || z) {
            float fH = aVar.h();
            if (f2 < 0.5f) {
                float fI2 = aVar.i();
                fI = (f2096b.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + fI2;
                interpolation = fI2;
            } else {
                fI = aVar.i() + 0.79f;
                interpolation = fI - (((1.0f - f2096b.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float f3 = fH + (0.20999998f * f2);
            float f4 = (f2 + this.h) * 216.0f;
            aVar.e(interpolation);
            aVar.c(fI);
            aVar.d(f3);
            d(f4);
        }
    }

    private void a() {
        a aVar = this.f2098d;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(WheelView.DividerConfig.FILL, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b(this, aVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f2095a);
        valueAnimatorOfFloat.addListener(new c(this, aVar));
        this.g = valueAnimatorOfFloat;
    }
}
