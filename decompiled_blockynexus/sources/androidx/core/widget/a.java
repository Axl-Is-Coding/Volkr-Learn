package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: AutoScrollHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1285a = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f1288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f1289e;
    private int h;
    private int i;
    private boolean m;
    boolean n;
    boolean o;
    boolean p;
    private boolean q;
    private boolean r;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C0019a f1286b = new C0019a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Interpolator f1287c = new AccelerateInterpolator();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float[] f1290f = {WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL};
    private float[] g = {Float.MAX_VALUE, Float.MAX_VALUE};
    private float[] j = {WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL};
    private float[] k = {WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL};
    private float[] l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoScrollHelper.java */
    private static class C0019a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f1293c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f1294d;
        private float j;
        private int k;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f1295e = Long.MIN_VALUE;
        private long i = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f1296f = 0;
        private int g = 0;
        private int h = 0;

        C0019a() {
        }

        private float a(float f2) {
            return ((-4.0f) * f2 * f2) + (f2 * 4.0f);
        }

        public void a(int i) {
            this.f1292b = i;
        }

        public void b(int i) {
            this.f1291a = i;
        }

        public int c() {
            return this.h;
        }

        public int d() {
            float f2 = this.f1293c;
            return (int) (f2 / Math.abs(f2));
        }

        public int e() {
            float f2 = this.f1294d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean f() {
            return this.i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.i + ((long) this.k);
        }

        public void g() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.k = a.a((int) (jCurrentAnimationTimeMillis - this.f1295e), 0, this.f1292b);
            this.j = a(jCurrentAnimationTimeMillis);
            this.i = jCurrentAnimationTimeMillis;
        }

        public void h() {
            this.f1295e = AnimationUtils.currentAnimationTimeMillis();
            this.i = -1L;
            this.f1296f = this.f1295e;
            this.j = 0.5f;
            this.g = 0;
            this.h = 0;
        }

        private float a(long j) {
            if (j < this.f1295e) {
                return WheelView.DividerConfig.FILL;
            }
            long j2 = this.i;
            if (j2 < 0 || j < j2) {
                return a.a((j - this.f1295e) / this.f1291a, WheelView.DividerConfig.FILL, 1.0f) * 0.5f;
            }
            long j3 = j - j2;
            float f2 = this.j;
            return (1.0f - f2) + (f2 * a.a(j3 / this.k, WheelView.DividerConfig.FILL, 1.0f));
        }

        public int b() {
            return this.g;
        }

        public void a() {
            if (this.f1296f != 0) {
                long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float fA = a(a(jCurrentAnimationTimeMillis));
                long j = jCurrentAnimationTimeMillis - this.f1296f;
                this.f1296f = jCurrentAnimationTimeMillis;
                float f2 = j * fA;
                this.g = (int) (this.f1293c * f2);
                this.h = (int) (f2 * this.f1294d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public void a(float f2, float f3) {
            this.f1293c = f2;
            this.f1294d = f3;
        }
    }

    /* JADX INFO: compiled from: AutoScrollHelper.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    aVar.f1286b.h();
                }
                C0019a c0019a = a.this.f1286b;
                if (c0019a.f() || !a.this.b()) {
                    a.this.p = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.o) {
                    aVar2.o = false;
                    aVar2.a();
                }
                c0019a.a();
                a.this.a(c0019a.b(), c0019a.c());
                ViewCompat.a(a.this.f1288d, this);
            }
        }
    }

    public a(View view) {
        this.f1288d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (int) ((1575.0f * f2) + 0.5f);
        b(f3, f3);
        float f4 = (int) ((f2 * 315.0f) + 0.5f);
        c(f4, f4);
        d(1);
        a(Float.MAX_VALUE, Float.MAX_VALUE);
        d(0.2f, 0.2f);
        e(1.0f, 1.0f);
        c(f1285a);
        f(500);
        e(500);
    }

    static float a(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public a a(boolean z) {
        if (this.q && !z) {
            c();
        }
        this.q = z;
        return this;
    }

    public abstract void a(int i, int i2);

    public abstract boolean a(int i);

    public a b(float f2, float f3) {
        float[] fArr = this.l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public abstract boolean b(int i);

    public a c(float f2, float f3) {
        float[] fArr = this.k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a d(int i) {
        this.h = i;
        return this;
    }

    public a e(float f2, float f3) {
        float[] fArr = this.j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public a f(int i) {
        this.f1286b.b(i);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.q
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.c()
            goto L58
        L1a:
            r5.o = r2
            r5.m = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f1288d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.a(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f1288d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.a(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f1286b
            r7.a(r0, r6)
            boolean r6 = r5.p
            if (r6 != 0) goto L58
            boolean r6 = r5.b()
            if (r6 == 0) goto L58
            r5.d()
        L58:
            boolean r6 = r5.r
            if (r6 == 0) goto L61
            boolean r6 = r5.p
            if (r6 == 0) goto L61
            r1 = 1
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private float f(float f2, float f3) {
        if (f3 == WheelView.DividerConfig.FILL) {
            return WheelView.DividerConfig.FILL;
        }
        int i = this.h;
        if (i == 0 || i == 1) {
            if (f2 < f3) {
                if (f2 >= WheelView.DividerConfig.FILL) {
                    return 1.0f - (f2 / f3);
                }
                if (this.p && this.h == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f2 < WheelView.DividerConfig.FILL) {
            return f2 / (-f3);
        }
        return WheelView.DividerConfig.FILL;
    }

    public a d(float f2, float f3) {
        float[] fArr = this.f1290f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    boolean b() {
        C0019a c0019a = this.f1286b;
        int iE = c0019a.e();
        int iD = c0019a.d();
        return (iE != 0 && b(iE)) || (iD != 0 && a(iD));
    }

    public a c(int i) {
        this.i = i;
        return this;
    }

    public a e(int i) {
        this.f1286b.a(i);
        return this;
    }

    private void c() {
        if (this.n) {
            this.p = false;
        } else {
            this.f1286b.g();
        }
    }

    private void d() {
        int i;
        if (this.f1289e == null) {
            this.f1289e = new b();
        }
        this.p = true;
        this.n = true;
        if (!this.m && (i = this.i) > 0) {
            ViewCompat.a(this.f1288d, this.f1289e, i);
        } else {
            this.f1289e.run();
        }
        this.m = true;
    }

    public a a(float f2, float f3) {
        float[] fArr = this.g;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    private float a(int i, float f2, float f3, float f4) {
        float fA = a(this.f1290f[i], f3, this.g[i], f2);
        if (fA == WheelView.DividerConfig.FILL) {
            return WheelView.DividerConfig.FILL;
        }
        float f5 = this.j[i];
        float f6 = this.k[i];
        float f7 = this.l[i];
        float f8 = f5 * f4;
        if (fA > WheelView.DividerConfig.FILL) {
            return a(fA * f8, f6, f7);
        }
        return -a((-fA) * f8, f6, f7);
    }

    private float a(float f2, float f3, float f4, float f5) {
        float interpolation;
        float fA = a(f2 * f3, WheelView.DividerConfig.FILL, f4);
        float f6 = f(f3 - f5, fA) - f(f5, fA);
        if (f6 < WheelView.DividerConfig.FILL) {
            interpolation = -this.f1287c.getInterpolation(-f6);
        } else {
            if (f6 <= WheelView.DividerConfig.FILL) {
                return WheelView.DividerConfig.FILL;
            }
            interpolation = this.f1287c.getInterpolation(f6);
        }
        return a(interpolation, -1.0f, 1.0f);
    }

    void a() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
        this.f1288d.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }
}
