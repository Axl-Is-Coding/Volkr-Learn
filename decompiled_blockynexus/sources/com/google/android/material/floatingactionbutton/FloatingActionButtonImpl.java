package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.l.r;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class FloatingActionButtonImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final TimeInterpolator f13372a = com.google.android.material.a.a.f13083c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f13373b = {R.attr.state_pressed, R.attr.state_enabled};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f13374c = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f13375d = {R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f13376e = {R.attr.state_hovered, R.attr.state_enabled};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f13377f = {R.attr.state_enabled};
    static final int[] g = new int[0];
    private int A;
    private ArrayList<Animator.AnimatorListener> C;
    private ArrayList<Animator.AnimatorListener> D;
    private ArrayList<d> E;
    final FloatingActionButton F;
    final com.google.android.material.k.b G;
    private ViewTreeObserver.OnPreDrawListener L;
    com.google.android.material.l.n h;
    com.google.android.material.l.i i;
    Drawable j;
    com.google.android.material.floatingactionbutton.d k;
    Drawable l;
    boolean m;
    float o;
    float p;
    float q;
    int r;
    private com.google.android.material.a.h t;
    private com.google.android.material.a.h u;
    private Animator v;
    private com.google.android.material.a.h w;
    private com.google.android.material.a.h x;
    private float y;
    boolean n = true;
    private float z = 1.0f;
    private int B = 0;
    private final Rect H = new Rect();
    private final RectF I = new RectF();
    private final RectF J = new RectF();
    private final Matrix K = new Matrix();
    private final com.google.android.material.internal.n s = new com.google.android.material.internal.n();

    private class a extends g {
        a() {
            super(FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.g
        protected float a() {
            return WheelView.DividerConfig.FILL;
        }
    }

    private class b extends g {
        b() {
            super(FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.g
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.o + floatingActionButtonImpl.p;
        }
    }

    private class c extends g {
        c() {
            super(FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.g
        protected float a() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.o + floatingActionButtonImpl.q;
        }
    }

    interface d {
        void a();

        void b();
    }

    interface e {
        void a();

        void b();
    }

    private class f extends g {
        f() {
            super(FloatingActionButtonImpl.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.g
        protected float a() {
            return FloatingActionButtonImpl.this.o;
        }
    }

    private abstract class g extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f13382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f13383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f13384c;

        private g() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.e((int) this.f13384c);
            this.f13382a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f13382a) {
                com.google.android.material.l.i iVar = FloatingActionButtonImpl.this.i;
                this.f13383b = iVar == null ? WheelView.DividerConfig.FILL : iVar.e();
                this.f13384c = a();
                this.f13382a = true;
            }
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            float f2 = this.f13383b;
            floatingActionButtonImpl.e((int) (f2 + ((this.f13384c - f2) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ g(FloatingActionButtonImpl floatingActionButtonImpl, k kVar) {
            this();
        }
    }

    FloatingActionButtonImpl(FloatingActionButton floatingActionButton, com.google.android.material.k.b bVar) {
        this.F = floatingActionButton;
        this.G = bVar;
        this.s.a(f13373b, a((g) new c()));
        this.s.a(f13374c, a((g) new b()));
        this.s.a(f13375d, a((g) new b()));
        this.s.a(f13376e, a((g) new b()));
        this.s.a(f13377f, a((g) new f()));
        this.s.a(g, a((g) new a()));
        this.y = this.F.getRotation();
    }

    private ViewTreeObserver.OnPreDrawListener A() {
        if (this.L == null) {
            this.L = new o(this);
        }
        return this.L;
    }

    private boolean B() {
        return ViewCompat.C(this.F) && !this.F.isInEditMode();
    }

    private com.google.android.material.a.h y() {
        if (this.u == null) {
            this.u = com.google.android.material.a.h.a(this.F.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
        }
        com.google.android.material.a.h hVar = this.u;
        androidx.core.f.h.a(hVar);
        return hVar;
    }

    private com.google.android.material.a.h z() {
        if (this.t == null) {
            this.t = com.google.android.material.a.h.a(this.F.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
        }
        com.google.android.material.a.h hVar = this.t;
        androidx.core.f.h.a(hVar);
        return hVar;
    }

    void addTransformationCallback(d dVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(dVar);
    }

    void b(int i) {
        this.r = i;
    }

    float c() {
        return this.o;
    }

    final void d(float f2) {
        if (this.q != f2) {
            this.q = f2;
            a(this.o, this.p, this.q);
        }
    }

    final com.google.android.material.a.h e() {
        return this.x;
    }

    float f() {
        return this.p;
    }

    float g() {
        return this.q;
    }

    final com.google.android.material.l.n h() {
        return this.h;
    }

    final com.google.android.material.a.h i() {
        return this.w;
    }

    boolean j() {
        return this.F.getVisibility() == 0 ? this.B == 1 : this.B != 2;
    }

    boolean k() {
        return this.F.getVisibility() != 0 ? this.B == 2 : this.B != 1;
    }

    void l() {
        this.s.a();
    }

    void m() {
        com.google.android.material.l.i iVar = this.i;
        if (iVar != null) {
            com.google.android.material.l.j.a(this.F, iVar);
        }
        if (s()) {
            this.F.getViewTreeObserver().addOnPreDrawListener(A());
        }
    }

    void n() {
    }

    void o() {
        ViewTreeObserver viewTreeObserver = this.F.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.L;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.L = null;
        }
    }

    void p() {
        float rotation = this.F.getRotation();
        if (this.y != rotation) {
            this.y = rotation;
            v();
        }
    }

    void q() {
        ArrayList<d> arrayList = this.E;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    void r() {
        ArrayList<d> arrayList = this.E;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    void removeTransformationCallback(d dVar) {
        ArrayList<d> arrayList = this.E;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(dVar);
    }

    boolean s() {
        return true;
    }

    boolean t() {
        return true;
    }

    final boolean u() {
        return !this.m || this.F.getSizeDimension() >= this.r;
    }

    void v() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.y % 90.0f != WheelView.DividerConfig.FILL) {
                if (this.F.getLayerType() != 1) {
                    this.F.setLayerType(1, null);
                }
            } else if (this.F.getLayerType() != 0) {
                this.F.setLayerType(0, null);
            }
        }
        com.google.android.material.l.i iVar = this.i;
        if (iVar != null) {
            iVar.b((int) this.y);
        }
    }

    final void w() {
        c(this.z);
    }

    final void x() {
        Rect rect = this.H;
        a(rect);
        b(rect);
        this.G.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void b(ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, com.google.android.material.j.c.b(colorStateList));
        }
    }

    final void c(float f2) {
        this.z = f2;
        Matrix matrix = this.K;
        a(f2, matrix);
        this.F.setImageMatrix(matrix);
    }

    void e(float f2) {
        com.google.android.material.l.i iVar = this.i;
        if (iVar != null) {
            iVar.b(f2);
        }
    }

    void a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        this.i = a();
        this.i.setTintList(colorStateList);
        if (mode != null) {
            this.i.setTintMode(mode);
        }
        this.i.a(-12303292);
        this.i.a(this.F.getContext());
        com.google.android.material.j.b bVar = new com.google.android.material.j.b(this.i.l());
        bVar.setTintList(com.google.android.material.j.c.b(colorStateList2));
        this.j = bVar;
        com.google.android.material.l.i iVar = this.i;
        androidx.core.f.h.a(iVar);
        this.l = new LayerDrawable(new Drawable[]{iVar, bVar});
    }

    boolean d() {
        return this.m;
    }

    final void b(float f2) {
        if (this.p != f2) {
            this.p = f2;
            a(this.o, this.p, this.q);
        }
    }

    void d(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.C;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.D;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    final void b(com.google.android.material.a.h hVar) {
        this.w = hVar;
    }

    void b(boolean z) {
        this.n = z;
        x();
    }

    void b(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(animatorListener);
    }

    void b(e eVar, boolean z) {
        if (k()) {
            return;
        }
        Animator animator = this.v;
        if (animator != null) {
            animator.cancel();
        }
        if (B()) {
            if (this.F.getVisibility() != 0) {
                this.F.setAlpha(WheelView.DividerConfig.FILL);
                this.F.setScaleY(WheelView.DividerConfig.FILL);
                this.F.setScaleX(WheelView.DividerConfig.FILL);
                c(WheelView.DividerConfig.FILL);
            }
            com.google.android.material.a.h hVarZ = this.w;
            if (hVarZ == null) {
                hVarZ = z();
            }
            AnimatorSet animatorSetA = a(hVarZ, 1.0f, 1.0f, 1.0f);
            animatorSetA.addListener(new l(this, z, eVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.C;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetA.addListener(it.next());
                }
            }
            animatorSetA.start();
            return;
        }
        this.F.internalSetVisibility(0, z);
        this.F.setAlpha(1.0f);
        this.F.setScaleY(1.0f);
        this.F.setScaleX(1.0f);
        c(1.0f);
        if (eVar != null) {
            eVar.a();
        }
    }

    void a(ColorStateList colorStateList) {
        com.google.android.material.l.i iVar = this.i;
        if (iVar != null) {
            iVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.d dVar = this.k;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    void a(PorterDuff.Mode mode) {
        com.google.android.material.l.i iVar = this.i;
        if (iVar != null) {
            iVar.setTintMode(mode);
        }
    }

    final void a(float f2) {
        if (this.o != f2) {
            this.o = f2;
            a(this.o, this.p, this.q);
        }
    }

    final void a(int i) {
        if (this.A != i) {
            this.A = i;
            w();
        }
    }

    private void a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.F.getDrawable() == null || this.A == 0) {
            return;
        }
        RectF rectF = this.I;
        RectF rectF2 = this.J;
        rectF.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.A;
        rectF2.set(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.A;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    final void a(com.google.android.material.l.n nVar) {
        this.h = nVar;
        com.google.android.material.l.i iVar = this.i;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(nVar);
        }
        Object obj = this.j;
        if (obj instanceof r) {
            ((r) obj).setShapeAppearanceModel(nVar);
        }
        com.google.android.material.floatingactionbutton.d dVar = this.k;
        if (dVar != null) {
            dVar.a(nVar);
        }
    }

    final Drawable b() {
        return this.l;
    }

    void b(Rect rect) {
        androidx.core.f.h.a(this.l, "Didn't initialize content background");
        if (t()) {
            this.G.a(new InsetDrawable(this.l, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.G.a(this.l);
        }
    }

    final void a(com.google.android.material.a.h hVar) {
        this.x = hVar;
    }

    void a(boolean z) {
        this.m = z;
    }

    void a(float f2, float f3, float f4) {
        x();
        e(f2);
    }

    void a(int[] iArr) {
        this.s.a(iArr);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.add(animatorListener);
    }

    void a(e eVar, boolean z) {
        if (j()) {
            return;
        }
        Animator animator = this.v;
        if (animator != null) {
            animator.cancel();
        }
        if (B()) {
            com.google.android.material.a.h hVarY = this.x;
            if (hVarY == null) {
                hVarY = y();
            }
            AnimatorSet animatorSetA = a(hVarY, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
            animatorSetA.addListener(new k(this, z, eVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.D;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    animatorSetA.addListener(it.next());
                }
            }
            animatorSetA.start();
            return;
        }
        this.F.internalSetVisibility(z ? 8 : 4, z);
        if (eVar != null) {
            eVar.b();
        }
    }

    private AnimatorSet a(com.google.android.material.a.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        hVar.b("opacity").a((Animator) objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        hVar.b("scale").a((Animator) objectAnimatorOfFloat2);
        a(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        hVar.b("scale").a((Animator) objectAnimatorOfFloat3);
        a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        a(f4, this.K);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.F, new com.google.android.material.a.f(), new m(this), new Matrix(this.K));
        hVar.b("iconScale").a((Animator) objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        com.google.android.material.a.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void a(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new n(this));
    }

    void a(Rect rect) {
        int sizeDimension = this.m ? (this.r - this.F.getSizeDimension()) / 2 : 0;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(this.n ? c() + this.q : WheelView.DividerConfig.FILL));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(r1 * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    com.google.android.material.l.i a() {
        com.google.android.material.l.n nVar = this.h;
        androidx.core.f.h.a(nVar);
        return new com.google.android.material.l.i(nVar);
    }

    private ValueAnimator a(g gVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f13372a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(gVar);
        valueAnimator.addUpdateListener(gVar);
        valueAnimator.setFloatValues(WheelView.DividerConfig.FILL, 1.0f);
        return valueAnimator;
    }
}
