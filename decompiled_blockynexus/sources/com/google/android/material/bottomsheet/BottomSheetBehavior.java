package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.b;
import androidx.customview.b.g;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.l.i;
import com.google.android.material.l.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f13204a = R.style.Widget_Design_BottomSheet_Modal;
    int A;
    int B;
    WeakReference<V> C;
    WeakReference<View> D;
    private final ArrayList<a> E;
    private VelocityTracker F;
    int G;
    private int H;
    boolean I;
    private Map<View, Integer> J;
    private final g.a K;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f13207d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13209f;
    private int g;
    private boolean h;
    private i i;
    private n j;
    private boolean k;
    private BottomSheetBehavior<V>.c l;
    private ValueAnimator m;
    int n;
    int o;
    int p;
    float q;
    int r;
    float s;
    boolean t;
    private boolean u;
    int v;
    androidx.customview.b.g w;
    private boolean x;
    private int y;
    private boolean z;

    public static abstract class a {
        public abstract void a(View view, float f2);

        public abstract void a(View view, int i);
    }

    private class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f13214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13216c;

        c(View view, int i) {
            this.f13214a = view;
            this.f13216c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.customview.b.g gVar = BottomSheetBehavior.this.w;
            if (gVar == null || !gVar.a(true)) {
                BottomSheetBehavior.this.f(this.f13216c);
            } else {
                ViewCompat.a(this.f13214a, this);
            }
            this.f13215b = false;
        }
    }

    public BottomSheetBehavior() {
        this.f13205b = 0;
        this.f13206c = true;
        this.l = null;
        this.q = 0.5f;
        this.s = -1.0f;
        this.v = 4;
        this.E = new ArrayList<>();
        this.K = new com.google.android.material.bottomsheet.c(this);
    }

    private void g(int i) {
        V v = this.C.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.B(v)) {
            v.post(new com.google.android.material.bottomsheet.a(this, v, i));
        } else {
            a((View) v, i);
        }
    }

    private void h(int i) {
        ValueAnimator valueAnimator;
        if (i == 2) {
            return;
        }
        boolean z = i == 3;
        if (this.k != z) {
            this.k = z;
            if (this.i == null || (valueAnimator = this.m) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.m.reverse();
                return;
            }
            float f2 = z ? WheelView.DividerConfig.FILL : 1.0f;
            this.m.setFloatValues(1.0f - f2, f2);
            this.m.start();
        }
    }

    private void i() {
        V v;
        WeakReference<V> weakReference = this.C;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.d(v, 524288);
        ViewCompat.d(v, 262144);
        ViewCompat.d(v, 1048576);
        if (this.t && this.v != 5) {
            a(v, b.a.u, 5);
        }
        int i = this.v;
        if (i == 3) {
            a(v, b.a.t, this.f13206c ? 4 : 6);
            return;
        }
        if (i == 4) {
            a(v, b.a.s, this.f13206c ? 3 : 6);
        } else {
            if (i != 6) {
                return;
            }
            a(v, b.a.t, 4);
            a(v, b.a.s, 3);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    public void addBottomSheetCallback(a aVar) {
        if (this.E.contains(aVar)) {
            return;
        }
        this.E.add(aVar);
    }

    void f(int i) {
        V v;
        if (this.v == i) {
            return;
        }
        this.v = i;
        WeakReference<V> weakReference = this.C;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i == 6 || i == 3) {
            d(true);
        } else if (i == 5 || i == 4) {
            d(false);
        }
        h(i);
        for (int i2 = 0; i2 < this.E.size(); i2++) {
            this.E.get(i2).a((View) v, i);
        }
        i();
    }

    public void removeBottomSheetCallback(a aVar) {
        this.E.remove(aVar);
    }

    @Deprecated
    public void setBottomSheetCallback(a aVar) {
        Log.w("BottomSheetBehavior", "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.E.clear();
        if (aVar != null) {
            this.E.add(aVar);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.a(coordinatorLayout, v, bVar.a());
        a(bVar);
        int i = bVar.f13210c;
        if (i == 1 || i == 2) {
            this.v = 4;
        } else {
            this.v = i;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.v == 1 && actionMasked == 0) {
            return true;
        }
        androidx.customview.b.g gVar = this.w;
        if (gVar != null) {
            gVar.a(motionEvent);
        }
        if (actionMasked == 0) {
            h();
        }
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
        this.F.addMovement(motionEvent);
        if (actionMasked == 2 && !this.x && Math.abs(this.H - motionEvent.getY()) > this.w.e()) {
            this.w.a(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.x;
    }

    public void c(int i) {
        a(i, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
        return new b(super.d(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    public void e(int i) {
        if (i == this.v) {
            return;
        }
        if (this.C != null) {
            g(i);
            return;
        }
        if (i == 4 || i == 3 || i == 6 || (this.t && i == 5)) {
            this.v = i;
        }
    }

    public void c(boolean z) {
        this.u = z;
    }

    public void d(int i) {
        this.f13205b = i;
    }

    private void c() {
        int iMax;
        if (this.f13209f) {
            iMax = Math.max(this.g, this.B - ((this.A * 9) / 16));
        } else {
            iMax = this.f13208e;
        }
        if (this.f13206c) {
            this.r = Math.max(this.B - iMax, this.o);
        } else {
            this.r = this.B - iMax;
        }
    }

    private void d() {
        this.p = (int) (this.B * (1.0f - this.q));
    }

    private void d(boolean z) {
        WeakReference<V> weakReference = this.C;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.J != null) {
                    return;
                } else {
                    this.J = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.C.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.J;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.f(childAt, this.J.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.J.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        ViewCompat.f(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.J = null;
        }
    }

    protected static class b extends androidx.customview.a.c {
        public static final Parcelable.Creator<b> CREATOR = new e();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f13210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f13211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f13212e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f13213f;
        boolean g;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13210c = parcel.readInt();
            this.f13211d = parcel.readInt();
            this.f13212e = parcel.readInt() == 1;
            this.f13213f = parcel.readInt() == 1;
            this.g = parcel.readInt() == 1;
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f13210c);
            parcel.writeInt(this.f13211d);
            parcel.writeInt(this.f13212e ? 1 : 0);
            parcel.writeInt(this.f13213f ? 1 : 0);
            parcel.writeInt(this.g ? 1 : 0);
        }

        public b(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f13210c = bottomSheetBehavior.v;
            this.f13211d = ((BottomSheetBehavior) bottomSheetBehavior).f13208e;
            this.f13212e = ((BottomSheetBehavior) bottomSheetBehavior).f13206c;
            this.f13213f = bottomSheetBehavior.t;
            this.g = ((BottomSheetBehavior) bottomSheetBehavior).u;
        }
    }

    private float g() {
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker == null) {
            return WheelView.DividerConfig.FILL;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f13207d);
        return this.F.getYVelocity(this.G);
    }

    private void e() {
        this.m = ValueAnimator.ofFloat(WheelView.DividerConfig.FILL, 1.0f);
        this.m.setDuration(500L);
        this.m.addUpdateListener(new com.google.android.material.bottomsheet.b(this));
    }

    private void h() {
        this.G = -1;
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.F = null;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout.d dVar) {
        super.a(dVar);
        this.C = null;
        this.w = null;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        super(context, attributeSet);
        this.f13205b = 0;
        this.f13206c = true;
        this.l = null;
        this.q = 0.5f;
        this.s = -1.0f;
        this.v = 4;
        this.E = new ArrayList<>();
        this.K = new com.google.android.material.bottomsheet.c(this);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.h = typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        if (zHasValue) {
            a(context, attributeSet, zHasValue, com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint));
        } else {
            a(context, attributeSet, zHasValue);
        }
        e();
        if (Build.VERSION.SDK_INT >= 21) {
            this.s = typedArrayObtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i = typedValuePeekValue.data) == -1) {
            c(i);
        } else {
            c(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        b(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        c(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        d(typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        a(typedArrayObtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        b(typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        typedArrayObtainStyledAttributes.recycle();
        this.f13207d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        return this.f13206c ? this.o : this.n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a() {
        super.a();
        this.C = null;
        this.w = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        i iVar;
        if (ViewCompat.j(coordinatorLayout) && !ViewCompat.j(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.C == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            this.C = new WeakReference<>(v);
            if (this.h && (iVar = this.i) != null) {
                ViewCompat.a(v, iVar);
            }
            i iVar2 = this.i;
            if (iVar2 != null) {
                float fI = this.s;
                if (fI == -1.0f) {
                    fI = ViewCompat.i(v);
                }
                iVar2.b(fI);
                this.k = this.v == 3;
                this.i.c(this.k ? WheelView.DividerConfig.FILL : 1.0f);
            }
            i();
            if (ViewCompat.k(v) == 0) {
                ViewCompat.f(v, 1);
            }
        }
        if (this.w == null) {
            this.w = androidx.customview.b.g.a(coordinatorLayout, this.K);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.A = coordinatorLayout.getWidth();
        this.B = coordinatorLayout.getHeight();
        this.o = Math.max(0, this.B - v.getHeight());
        d();
        c();
        int i2 = this.v;
        if (i2 == 3) {
            ViewCompat.c(v, f());
        } else if (i2 == 6) {
            ViewCompat.c(v, this.p);
        } else if (this.t && i2 == 5) {
            ViewCompat.c(v, this.B);
        } else {
            int i3 = this.v;
            if (i3 == 4) {
                ViewCompat.c(v, this.r);
            } else if (i3 == 1 || i3 == 2) {
                ViewCompat.c(v, top - v.getTop());
            }
        }
        this.D = new WeakReference<>(a(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.y = 0;
        this.z = false;
        return (i & 2) != 0;
    }

    public void b(int i) {
        if (i >= 0) {
            this.n = i;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void b(boolean z) {
        if (this.t != z) {
            this.t = z;
            if (!z && this.v == 5) {
                e(4);
            }
            i();
        }
    }

    public int b() {
        return this.v;
    }

    public static <V extends View> BottomSheetBehavior<V> b(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.d) {
            CoordinatorLayout.Behavior behaviorD = ((CoordinatorLayout.d) layoutParams).d();
            if (behaviorD instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behaviorD;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        androidx.customview.b.g gVar;
        if (!v.isShown()) {
            this.x = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            h();
        }
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
        this.F.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.H = (int) motionEvent.getY();
            if (this.v != 2) {
                WeakReference<View> weakReference = this.D;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.H)) {
                    this.G = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.I = true;
                }
            }
            this.x = this.G == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.H);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.I = false;
            this.G = -1;
            if (this.x) {
                this.x = false;
                return false;
            }
        }
        if (!this.x && (gVar = this.w) != null && gVar.b(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.D;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.x || this.v == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.w == null || Math.abs(((float) this.H) - motionEvent.getY()) <= ((float) this.w.e())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.D;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i4 = top - i2;
        if (i2 > 0) {
            if (i4 < f()) {
                iArr[1] = top - f();
                ViewCompat.c(v, -iArr[1]);
                f(3);
            } else {
                iArr[1] = i2;
                ViewCompat.c(v, -i2);
                f(1);
            }
        } else if (i2 < 0 && !view.canScrollVertically(-1)) {
            int i5 = this.r;
            if (i4 > i5 && !this.t) {
                iArr[1] = top - i5;
                ViewCompat.c(v, -iArr[1]);
                f(4);
            } else {
                iArr[1] = i2;
                ViewCompat.c(v, -i2);
                f(1);
            }
        }
        a(v.getTop());
        this.y = i2;
        this.z = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int iF;
        int i2 = 3;
        if (v.getTop() == f()) {
            f(3);
            return;
        }
        WeakReference<View> weakReference = this.D;
        if (weakReference != null && view == weakReference.get() && this.z) {
            if (this.y > 0) {
                iF = f();
            } else if (this.t && a(v, g())) {
                iF = this.B;
                i2 = 5;
            } else if (this.y == 0) {
                int top = v.getTop();
                if (this.f13206c) {
                    if (Math.abs(top - this.o) < Math.abs(top - this.r)) {
                        iF = this.o;
                    } else {
                        iF = this.r;
                        i2 = 4;
                    }
                } else {
                    int i3 = this.p;
                    if (top < i3) {
                        if (top < Math.abs(top - this.r)) {
                            iF = this.n;
                        } else {
                            iF = this.p;
                        }
                    } else if (Math.abs(top - i3) < Math.abs(top - this.r)) {
                        iF = this.p;
                    } else {
                        iF = this.r;
                        i2 = 4;
                    }
                    i2 = 6;
                }
            } else {
                if (this.f13206c) {
                    iF = this.r;
                } else {
                    int top2 = v.getTop();
                    if (Math.abs(top2 - this.p) < Math.abs(top2 - this.r)) {
                        iF = this.p;
                        i2 = 6;
                    } else {
                        iF = this.r;
                    }
                }
                i2 = 4;
            }
            a((View) v, i2, iF, false);
            this.z = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
        WeakReference<View> weakReference = this.D;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.v != 3 || super.a(coordinatorLayout, v, view, f2, f3);
    }

    public void a(boolean z) {
        if (this.f13206c == z) {
            return;
        }
        this.f13206c = z;
        if (this.C != null) {
            c();
        }
        f((this.f13206c && this.v == 6) ? 3 : this.v);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r4, boolean r5) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f13209f
            if (r4 != 0) goto L15
            r3.f13209f = r0
            goto L1f
        Lc:
            boolean r2 = r3.f13209f
            if (r2 != 0) goto L17
            int r2 = r3.f13208e
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = 0
            goto L1f
        L17:
            r3.f13209f = r1
            int r4 = java.lang.Math.max(r1, r4)
            r3.f13208e = r4
        L1f:
            if (r0 == 0) goto L42
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.C
            if (r4 == 0) goto L42
            r3.c()
            int r4 = r3.v
            r0 = 4
            if (r4 != r0) goto L42
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.C
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L42
            if (r5 == 0) goto L3f
            int r4 = r3.v
            r3.g(r4)
            goto L42
        L3f:
            r4.requestLayout()
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.a(int, boolean):void");
    }

    public void a(float f2) {
        if (f2 > WheelView.DividerConfig.FILL && f2 < 1.0f) {
            this.q = f2;
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    private void a(b bVar) {
        int i = this.f13205b;
        if (i == 0) {
            return;
        }
        if (i == -1 || (i & 1) == 1) {
            this.f13208e = bVar.f13211d;
        }
        int i2 = this.f13205b;
        if (i2 == -1 || (i2 & 2) == 2) {
            this.f13206c = bVar.f13212e;
        }
        int i3 = this.f13205b;
        if (i3 == -1 || (i3 & 4) == 4) {
            this.t = bVar.f13213f;
        }
        int i4 = this.f13205b;
        if (i4 == -1 || (i4 & 8) == 8) {
            this.u = bVar.g;
        }
    }

    boolean a(View view, float f2) {
        if (this.u) {
            return true;
        }
        return view.getTop() >= this.r && Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.r)) / ((float) this.f13208e) > 0.5f;
    }

    View a(View view) {
        if (ViewCompat.D(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewA = a(viewGroup.getChildAt(i));
            if (viewA != null) {
                return viewA;
            }
        }
        return null;
    }

    private void a(Context context, AttributeSet attributeSet, boolean z) {
        a(context, attributeSet, z, (ColorStateList) null);
    }

    private void a(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.h) {
            this.j = n.a(context, attributeSet, R.attr.bottomSheetStyle, f13204a).a();
            this.i = new i(this.j);
            this.i.a(context);
            if (z && colorStateList != null) {
                this.i.a(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
            this.i.setTint(typedValue.data);
        }
    }

    void a(View view, int i) {
        int iF;
        int i2;
        if (i == 4) {
            iF = this.r;
        } else if (i == 6) {
            int i3 = this.p;
            if (!this.f13206c || i3 > (i2 = this.o)) {
                iF = i3;
            } else {
                iF = i2;
                i = 3;
            }
        } else if (i == 3) {
            iF = f();
        } else if (this.t && i == 5) {
            iF = this.B;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        a(view, i, iF, false);
    }

    void a(View view, int i, int i2, boolean z) {
        boolean zB;
        if (z) {
            zB = this.w.d(view.getLeft(), i2);
        } else {
            zB = this.w.b(view, view.getLeft(), i2);
        }
        if (zB) {
            f(2);
            h(i);
            if (this.l == null) {
                this.l = new c(view, i);
            }
            if (!((c) this.l).f13215b) {
                BottomSheetBehavior<V>.c cVar = this.l;
                cVar.f13216c = i;
                ViewCompat.a(view, cVar);
                ((c) this.l).f13215b = true;
                return;
            }
            this.l.f13216c = i;
            return;
        }
        f(i);
    }

    void a(int i) {
        float f2;
        float f3;
        V v = this.C.get();
        if (v == null || this.E.isEmpty()) {
            return;
        }
        int i2 = this.r;
        if (i > i2) {
            f2 = i2 - i;
            f3 = this.B - i2;
        } else {
            f2 = i2 - i;
            f3 = i2 - f();
        }
        float f4 = f2 / f3;
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            this.E.get(i3).a(v, f4);
        }
    }

    private void a(V v, b.a aVar, int i) {
        ViewCompat.a(v, aVar, null, new d(this, i));
    }
}
