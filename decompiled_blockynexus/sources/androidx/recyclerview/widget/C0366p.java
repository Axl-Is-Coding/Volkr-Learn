package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: renamed from: androidx.recyclerview.widget.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FastScroller.java */
/* JADX INFO: loaded from: classes.dex */
class C0366p extends RecyclerView.h implements RecyclerView.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f2013a = {R.attr.state_pressed};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f2014b = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f2015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f2016d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final StateListDrawable f2017e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Drawable f2018f;
    private final int g;
    private final int h;
    private final StateListDrawable i;
    private final Drawable j;
    private final int k;
    private final int l;
    int m;
    int n;
    float o;
    int p;
    int q;
    float r;
    private RecyclerView u;
    private int s = 0;
    private int t = 0;
    private boolean v = false;
    private boolean w = false;
    private int x = 0;
    private int y = 0;
    private final int[] z = new int[2];
    private final int[] A = new int[2];
    final ValueAnimator B = ValueAnimator.ofFloat(WheelView.DividerConfig.FILL, 1.0f);
    int C = 0;
    private final Runnable D = new RunnableC0364n(this);
    private final RecyclerView.m E = new C0365o(this);

    /* JADX INFO: renamed from: androidx.recyclerview.widget.p$a */
    /* JADX INFO: compiled from: FastScroller.java */
    private class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2019a = false;

        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2019a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2019a) {
                this.f2019a = false;
                return;
            }
            if (((Float) C0366p.this.B.getAnimatedValue()).floatValue() == WheelView.DividerConfig.FILL) {
                C0366p c0366p = C0366p.this;
                c0366p.C = 0;
                c0366p.b(0);
            } else {
                C0366p c0366p2 = C0366p.this;
                c0366p2.C = 2;
                c0366p2.a();
            }
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.p$b */
    /* JADX INFO: compiled from: FastScroller.java */
    private class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C0366p.this.f2017e.setAlpha(iFloatValue);
            C0366p.this.f2018f.setAlpha(iFloatValue);
            C0366p.this.a();
        }
    }

    C0366p(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f2017e = stateListDrawable;
        this.f2018f = drawable;
        this.i = stateListDrawable2;
        this.j = drawable2;
        this.g = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.h = Math.max(i, drawable.getIntrinsicWidth());
        this.k = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.l = Math.max(i, drawable2.getIntrinsicWidth());
        this.f2015c = i2;
        this.f2016d = i3;
        this.f2017e.setAlpha(255);
        this.f2018f.setAlpha(255);
        this.B.addListener(new a());
        this.B.addUpdateListener(new b());
        a(recyclerView);
    }

    private void c() {
        this.u.removeCallbacks(this.D);
    }

    private void d() {
        this.u.removeItemDecoration(this);
        this.u.removeOnItemTouchListener(this);
        this.u.removeOnScrollListener(this.E);
        c();
    }

    private int[] e() {
        int[] iArr = this.A;
        int i = this.f2016d;
        iArr[0] = i;
        iArr[1] = this.s - i;
        return iArr;
    }

    private int[] f() {
        int[] iArr = this.z;
        int i = this.f2016d;
        iArr[0] = i;
        iArr[1] = this.t - i;
        return iArr;
    }

    private boolean g() {
        return ViewCompat.m(this.u) == 1;
    }

    private void h() {
        this.u.addItemDecoration(this);
        this.u.addOnItemTouchListener(this);
        this.u.addOnScrollListener(this.E);
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            d();
        }
        this.u = recyclerView;
        if (this.u != null) {
            h();
        }
    }

    void b(int i) {
        if (i == 2 && this.x != 2) {
            this.f2017e.setState(f2013a);
            c();
        }
        if (i == 0) {
            a();
        } else {
            b();
        }
        if (this.x == 2 && i != 2) {
            this.f2017e.setState(f2014b);
            c(1200);
        } else if (i == 1) {
            c(ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.x = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.t tVar) {
        if (this.s != this.u.getWidth() || this.t != this.u.getHeight()) {
            this.s = this.u.getWidth();
            this.t = this.u.getHeight();
            b(0);
        } else if (this.C != 0) {
            if (this.v) {
                b(canvas);
            }
            if (this.w) {
                a(canvas);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.x == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zB = b(motionEvent.getX(), motionEvent.getY());
            boolean zA = a(motionEvent.getX(), motionEvent.getY());
            if (zB || zA) {
                if (zA) {
                    this.y = 1;
                    this.r = (int) motionEvent.getX();
                } else if (zB) {
                    this.y = 2;
                    this.o = (int) motionEvent.getY();
                }
                b(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.x == 2) {
            this.o = WheelView.DividerConfig.FILL;
            this.r = WheelView.DividerConfig.FILL;
            b(1);
            this.y = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.x == 2) {
            b();
            if (this.y == 1) {
                a(motionEvent.getX());
            }
            if (this.y == 2) {
                b(motionEvent.getY());
            }
        }
    }

    private void c(int i) {
        c();
        this.u.postDelayed(this.D, i);
    }

    void a() {
        this.u.invalidate();
    }

    void a(int i) {
        int i2 = this.C;
        if (i2 == 1) {
            this.B.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.C = 3;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), WheelView.DividerConfig.FILL);
        this.B.setDuration(i);
        this.B.start();
    }

    public void b() {
        int i = this.C;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.B.cancel();
            }
        }
        this.C = 1;
        ValueAnimator valueAnimator = this.B;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.B.setDuration(500L);
        this.B.setStartDelay(0L);
        this.B.start();
    }

    private void a(Canvas canvas) {
        int i = this.t;
        int i2 = this.k;
        int i3 = this.q;
        int i4 = this.p;
        this.i.setBounds(0, 0, i4, i2);
        this.j.setBounds(0, 0, this.s, this.l);
        canvas.translate(WheelView.DividerConfig.FILL, i - i2);
        this.j.draw(canvas);
        canvas.translate(i3 - (i4 / 2), WheelView.DividerConfig.FILL);
        this.i.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void b(Canvas canvas) {
        int i = this.s;
        int i2 = this.g;
        int i3 = i - i2;
        int i4 = this.n;
        int i5 = this.m;
        int i6 = i4 - (i5 / 2);
        this.f2017e.setBounds(0, 0, i2, i5);
        this.f2018f.setBounds(0, 0, this.h, this.t);
        if (g()) {
            this.f2018f.draw(canvas);
            canvas.translate(this.g, i6);
            canvas.scale(-1.0f, 1.0f);
            this.f2017e.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.g, -i6);
            return;
        }
        canvas.translate(i3, WheelView.DividerConfig.FILL);
        this.f2018f.draw(canvas);
        canvas.translate(WheelView.DividerConfig.FILL, i6);
        this.f2017e.draw(canvas);
        canvas.translate(-i3, -i6);
    }

    void a(int i, int i2) {
        int iComputeVerticalScrollRange = this.u.computeVerticalScrollRange();
        int i3 = this.t;
        this.v = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.f2015c;
        int iComputeHorizontalScrollRange = this.u.computeHorizontalScrollRange();
        int i4 = this.s;
        this.w = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.f2015c;
        if (!this.v && !this.w) {
            if (this.x != 0) {
                b(0);
                return;
            }
            return;
        }
        if (this.v) {
            float f2 = i3;
            this.n = (int) ((f2 * (i2 + (f2 / 2.0f))) / iComputeVerticalScrollRange);
            this.m = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.w) {
            float f3 = i4;
            this.q = (int) ((f3 * (i + (f3 / 2.0f))) / iComputeHorizontalScrollRange);
            this.p = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.x;
        if (i5 == 0 || i5 == 1) {
            b(1);
        }
    }

    private void b(float f2) {
        int[] iArrF = f();
        float fMax = Math.max(iArrF[0], Math.min(iArrF[1], f2));
        if (Math.abs(this.n - fMax) < 2.0f) {
            return;
        }
        int iA = a(this.o, fMax, iArrF, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
        if (iA != 0) {
            this.u.scrollBy(0, iA);
        }
        this.o = fMax;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.x;
        if (i == 1) {
            boolean zB = b(motionEvent.getX(), motionEvent.getY());
            boolean zA = a(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zB && !zA) {
                return false;
            }
            if (zA) {
                this.y = 1;
                this.r = (int) motionEvent.getX();
            } else if (zB) {
                this.y = 2;
                this.o = (int) motionEvent.getY();
            }
            b(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    boolean b(float f2, float f3) {
        if (!g() ? f2 >= this.s - this.g : f2 <= this.g / 2) {
            int i = this.n;
            int i2 = this.m;
            if (f3 >= i - (i2 / 2) && f3 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    private void a(float f2) {
        int[] iArrE = e();
        float fMax = Math.max(iArrE[0], Math.min(iArrE[1], f2));
        if (Math.abs(this.q - fMax) < 2.0f) {
            return;
        }
        int iA = a(this.r, fMax, iArrE, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
        if (iA != 0) {
            this.u.scrollBy(iA, 0);
        }
        this.r = fMax;
    }

    private int a(float f2, float f3, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f3 - f2) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    boolean a(float f2, float f3) {
        if (f3 >= this.t - this.k) {
            int i = this.q;
            int i2 = this.p;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }
}
