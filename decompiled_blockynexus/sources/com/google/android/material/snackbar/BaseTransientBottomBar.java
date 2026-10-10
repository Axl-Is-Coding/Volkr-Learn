package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Handler f13578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f13579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f13580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f13582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f13583f;
    protected final SnackbarBaseLayout g;
    private final t h;
    private int i;
    private boolean j;
    private View k;
    private Rect m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private List<a<B>> s;
    private Behavior t;
    private final AccessibilityManager u;
    private final Runnable l = new j(this);
    v.a v = new m(this);

    public static class Behavior extends SwipeDismissBehavior<View> {
        private final b k = new b(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.k.a(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.k.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
            return super.a(coordinatorLayout, view, motionEvent);
        }
    }

    protected static class SnackbarBaseLayout extends FrameLayout {
        private static final View.OnTouchListener consumeAllTouchListener = new s();
        private final float actionTextColorAlpha;
        private int animationMode;
        private final float backgroundOverlayColorAlpha;
        private c onAttachStateChangeListener;
        private d onLayoutChangeListener;

        protected SnackbarBaseLayout(Context context) {
            this(context, null);
        }

        float getActionTextColorAlpha() {
            return this.actionTextColorAlpha;
        }

        int getAnimationMode() {
            return this.animationMode;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.backgroundOverlayColorAlpha;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            c cVar = this.onAttachStateChangeListener;
            if (cVar != null) {
                cVar.onViewAttachedToWindow(this);
            }
            ViewCompat.H(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            c cVar = this.onAttachStateChangeListener;
            if (cVar != null) {
                cVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            d dVar = this.onLayoutChangeListener;
            if (dVar != null) {
                dVar.a(this, i, i2, i3, i4);
            }
        }

        void setAnimationMode(int i) {
            this.animationMode = i;
        }

        void setOnAttachStateChangeListener(c cVar) {
            this.onAttachStateChangeListener = cVar;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : consumeAllTouchListener);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(d dVar) {
            this.onLayoutChangeListener = dVar;
        }

        protected SnackbarBaseLayout(Context context, AttributeSet attributeSet) {
            super(com.google.android.material.internal.s.a(context, attributeSet, 0, 0), attributeSet);
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.a(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
            }
            this.animationMode = typedArrayObtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.backgroundOverlayColorAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            this.actionTextColorAlpha = typedArrayObtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(consumeAllTouchListener);
            setFocusable(true);
        }
    }

    public static abstract class a<B> {
        public void a(B b2) {
        }

        public void a(B b2, int i) {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v.a f13584a;

        public b(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.b(0.1f);
            swipeDismissBehavior.a(0.6f);
            swipeDismissBehavior.a(0);
        }

        public void a(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f13584a = baseTransientBottomBar.v;
        }

        public void onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    v.a().d(this.f13584a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                v.a().e(this.f13584a);
            }
        }

        public boolean a(View view) {
            return view instanceof SnackbarBaseLayout;
        }
    }

    protected interface c {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    protected interface d {
        void a(View view, int i, int i2, int i3, int i4);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f13579b = i >= 16 && i <= 19;
        f13580c = new int[]{R.attr.snackbarStyle};
        f13581d = BaseTransientBottomBar.class.getSimpleName();
        f13578a = new Handler(Looper.getMainLooper(), new i());
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, t tVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (tVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f13582e = viewGroup;
        this.h = tVar;
        this.f13583f = viewGroup.getContext();
        com.google.android.material.internal.s.a(this.f13583f);
        this.g = (SnackbarBaseLayout) LayoutInflater.from(this.f13583f).inflate(h(), this.f13582e, false);
        if (this.g.getBackground() == null) {
            ViewCompat.a(this.g, q());
        }
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).updateActionTextColorAlphaIfNeeded(this.g.getActionTextColorAlpha());
        }
        this.g.addView(view);
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.m = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        ViewCompat.e(this.g, 1);
        ViewCompat.f(this.g, 1);
        ViewCompat.b((View) this.g, true);
        ViewCompat.a(this.g, new k(this));
        ViewCompat.a(this.g, new l(this));
        this.u = (AccessibilityManager) this.f13583f.getSystemService("accessibility");
    }

    private int p() {
        View view = this.k;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[1];
        int[] iArr2 = new int[2];
        this.f13582e.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f13582e.getHeight()) - i;
    }

    private Drawable q() {
        SnackbarBaseLayout snackbarBaseLayout = this.g;
        int iA = com.google.android.material.d.a.a(snackbarBaseLayout, R.attr.colorSurface, R.attr.colorOnSurface, snackbarBaseLayout.getBackgroundOverlayColorAlpha());
        float dimension = this.g.getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(iA);
        gradientDrawable.setCornerRadius(dimension);
        return gradientDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r() {
        WindowManager windowManager = (WindowManager) this.f13583f.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int s() {
        int height = this.g.getHeight();
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t() {
        int[] iArr = new int[2];
        this.g.getLocationOnScreen(iArr);
        return iArr[1] + this.g.getHeight();
    }

    private boolean u() {
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.d) && (((CoordinatorLayout.d) layoutParams).d() instanceof SwipeDismissBehavior);
    }

    private boolean v() {
        return this.q > 0 && !this.j && u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (m()) {
            c();
        } else {
            this.g.setVisibility(0);
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ValueAnimator valueAnimatorA = a(WheelView.DividerConfig.FILL, 1.0f);
        ValueAnimator valueAnimatorB = b(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorA, valueAnimatorB);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new com.google.android.material.snackbar.a(this));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        int iS = s();
        if (f13579b) {
            ViewCompat.c(this.g, iS);
        } else {
            this.g.setTranslationY(iS);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iS, 0);
        valueAnimator.setInterpolator(com.google.android.material.a.a.f13082b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new e(this));
        valueAnimator.addUpdateListener(new f(this, iS));
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || this.m == null) {
            Log.w(f13581d, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        int i = this.k != null ? this.r : this.n;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = this.m;
        marginLayoutParams.bottomMargin = rect.bottom + i;
        marginLayoutParams.leftMargin = rect.left + this.o;
        marginLayoutParams.rightMargin = rect.right + this.p;
        this.g.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !v()) {
            return;
        }
        this.g.removeCallbacks(this.l);
        this.g.post(this.l);
    }

    public B addCallback(a<B> aVar) {
        if (aVar == null) {
            return this;
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(aVar);
        return this;
    }

    protected boolean j() {
        TypedArray typedArrayObtainStyledAttributes = this.f13583f.obtainStyledAttributes(f13580c);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    public boolean k() {
        return v.a().a(this.v);
    }

    void l() {
        v.a().c(this.v);
        List<a<B>> list = this.s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.s.get(size).a(this);
            }
        }
    }

    boolean m() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.u.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void n() {
        v.a().a(f(), this.v);
    }

    final void o() {
        this.g.setOnAttachStateChangeListener(new o(this));
        if (this.g.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.d) {
                a((CoordinatorLayout.d) layoutParams);
            }
            this.r = p();
            z();
            this.g.setVisibility(4);
            this.f13582e.addView(this.g);
        }
        if (ViewCompat.C(this.g)) {
            w();
        } else {
            this.g.setOnLayoutChangeListener(new p(this));
        }
    }

    public B removeCallback(a<B> aVar) {
        List<a<B>> list;
        if (aVar == null || (list = this.s) == null) {
            return this;
        }
        list.remove(aVar);
        return this;
    }

    public Context e() {
        return this.f13583f;
    }

    public int f() {
        return this.i;
    }

    protected SwipeDismissBehavior<? extends View> g() {
        return new Behavior();
    }

    protected int h() {
        return j() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    public View i() {
        return this.g;
    }

    private void e(int i) {
        if (this.g.getAnimationMode() == 1) {
            f(i);
        } else {
            g(i);
        }
    }

    private void f(int i) {
        ValueAnimator valueAnimatorA = a(1.0f, WheelView.DividerConfig.FILL);
        valueAnimatorA.setDuration(75L);
        valueAnimatorA.addListener(new com.google.android.material.snackbar.b(this, i));
        valueAnimatorA.start();
    }

    private void g(int i) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, s());
        valueAnimator.setInterpolator(com.google.android.material.a.a.f13082b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new g(this, i));
        valueAnimator.addUpdateListener(new h(this));
        valueAnimator.start();
    }

    void c() {
        this.g.post(new r(this));
    }

    public B d(int i) {
        this.i = i;
        return this;
    }

    private ValueAnimator b(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f13084d);
        valueAnimatorOfFloat.addUpdateListener(new com.google.android.material.snackbar.d(this));
        return valueAnimatorOfFloat;
    }

    protected void a(int i) {
        v.a().a(this.v, i);
    }

    void c(int i) {
        v.a().b(this.v);
        List<a<B>> list = this.s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.s.get(size).a(this, i);
            }
        }
        ViewParent parent = this.g.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.g);
        }
    }

    public void d() {
        a(3);
    }

    private void a(CoordinatorLayout.d dVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorG = this.t;
        if (swipeDismissBehaviorG == null) {
            swipeDismissBehaviorG = g();
        }
        if (swipeDismissBehaviorG instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorG).a((BaseTransientBottomBar<?>) this);
        }
        swipeDismissBehaviorG.a(new q(this));
        dVar.a(swipeDismissBehaviorG);
        if (this.k == null) {
            dVar.g = 80;
        }
    }

    final void b(int i) {
        if (m() && this.g.getVisibility() == 0) {
            e(i);
        } else {
            c(i);
        }
    }

    private ValueAnimator a(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(com.google.android.material.a.a.f13081a);
        valueAnimatorOfFloat.addUpdateListener(new com.google.android.material.snackbar.c(this));
        return valueAnimatorOfFloat;
    }
}
