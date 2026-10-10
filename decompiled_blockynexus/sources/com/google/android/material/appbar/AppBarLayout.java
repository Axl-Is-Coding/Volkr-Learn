package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;
import androidx.core.view.l;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import com.google.android.material.l.i;
import com.google.android.material.l.j;
import com.just.agentweb.WebIndicator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@CoordinatorLayout.b(Behavior.class)
public class AppBarLayout extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private int currentOffset;
    private int downPreScrollRange;
    private int downScrollRange;
    private ValueAnimator elevationOverlayAnimator;
    private boolean haveChildWithInterpolator;
    private J lastInsets;
    private boolean liftOnScroll;
    private WeakReference<View> liftOnScrollTargetView;
    private int liftOnScrollTargetViewId;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<a> listeners;
    private int pendingAction;
    private Drawable statusBarForeground;
    private int[] tmpStatesArray;
    private int totalScrollRange;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private int k;
        private int l;
        private ValueAnimator m;
        private int n;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private a r;

        public static abstract class a<T extends AppBarLayout> {
            public abstract boolean a(T t);
        }

        public BaseBehavior() {
            this.n = -1;
        }

        private static boolean a(int i, int i2) {
            return (i & i2) == i2;
        }

        public void setDragCallback(a aVar) {
            this.r = aVar;
        }

        private void d(CoordinatorLayout coordinatorLayout, T t) {
            int iC = c();
            int iB = b(t, iC);
            if (iB >= 0) {
                View childAt = t.getChildAt(iB);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int iA = layoutParams.a();
                if ((iA & 17) == 17) {
                    int i = -childAt.getTop();
                    int iN = -childAt.getBottom();
                    if (iB == t.getChildCount() - 1) {
                        iN += t.getTopInset();
                    }
                    if (a(iA, 2)) {
                        iN += ViewCompat.n(childAt);
                    } else if (a(iA, 5)) {
                        int iN2 = ViewCompat.n(childAt) + iN;
                        if (iC < iN2) {
                            i = iN2;
                        } else {
                            iN = iN2;
                        }
                    }
                    if (a(iA, 32)) {
                        i += ((LinearLayout.LayoutParams) layoutParams).topMargin;
                        iN -= ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                    }
                    if (iC < (iN + i) / 2) {
                        i = iN;
                    }
                    a(coordinatorLayout, t, androidx.core.c.a.a(i, -t.getTotalScrollRange(), 0), WheelView.DividerConfig.FILL);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int c(T t) {
            return t.getTotalScrollRange();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        private int c(T t, int i) {
            int iAbs = Math.abs(i);
            int childCount = t.getChildCount();
            int topInset = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator interpolatorB = layoutParams.b();
                if (iAbs < childAt.getTop() || iAbs > childAt.getBottom()) {
                    i2++;
                } else if (interpolatorB != null) {
                    int iA = layoutParams.a();
                    if ((iA & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        if ((iA & 2) != 0) {
                            topInset -= ViewCompat.n(childAt);
                        }
                    }
                    if (ViewCompat.j(childAt)) {
                        topInset -= t.getTopInset();
                    }
                    if (topInset > 0) {
                        float f2 = topInset;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f2 * interpolatorB.getInterpolation((iAbs - childAt.getTop()) / f2)));
                    }
                }
            }
            return i;
        }

        protected static class b extends androidx.customview.a.c {
            public static final Parcelable.Creator<b> CREATOR = new d();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f13104c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            float f13105d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f13106e;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f13104c = parcel.readInt();
                this.f13105d = parcel.readFloat();
                this.f13106e = parcel.readByte() != 0;
            }

            @Override // androidx.customview.a.c, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f13104c);
                parcel.writeFloat(this.f13105d);
                parcel.writeByte(this.f13106e ? (byte) 1 : (byte) 0);
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }
        }

        private int b(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (a(layoutParams.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    bottom += ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.isLiftOnScroll() || a(coordinatorLayout, (AppBarLayout) t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i2;
            return z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public int b(T t) {
            return -t.getDownNestedScrollRange();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Parcelable d(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable parcelableD = super.d(coordinatorLayout, t);
            int iB = b();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + iB;
                if (childAt.getTop() + iB <= 0 && bottom >= 0) {
                    b bVar = new b(parcelableD);
                    bVar.f13104c = i;
                    bVar.f13106e = bottom == ViewCompat.n(childAt) + t.getTopInset();
                    bVar.f13105d = bottom / childAt.getHeight();
                    return bVar;
                }
            }
            return parcelableD;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i5 = -t.getTotalScrollRange();
                    i4 = i5;
                    downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i5;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i4 != downNestedPreScrollRange) {
                    iArr[1] = a(coordinatorLayout, t, i2, i4, downNestedPreScrollRange);
                }
            }
            if (t.isLiftOnScroll()) {
                t.setLiftedState(t.shouldLift(view));
            }
        }

        private boolean c(CoordinatorLayout coordinatorLayout, T t) {
            List<View> dependents = coordinatorLayout.getDependents(t);
            int size = dependents.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.Behavior behaviorD = ((CoordinatorLayout.d) dependents.get(i).getLayoutParams()).d();
                if (behaviorD instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) behaviorD).c() != 0;
                }
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (i4 < 0) {
                iArr[1] = a(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.l == 0 || i == 1) {
                d(coordinatorLayout, (AppBarLayout) t);
                if (t.isLiftOnScroll()) {
                    t.setLiftedState(t.shouldLift(view));
                }
            }
            this.q = new WeakReference<>(view);
        }

        @Override // com.google.android.material.appbar.HeaderBehavior
        int c() {
            return b() + this.k;
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, float f2) {
            int height;
            int iAbs = Math.abs(c() - i);
            float fAbs = Math.abs(f2);
            if (fAbs > WheelView.DividerConfig.FILL) {
                height = Math.round((iAbs / fAbs) * 1000.0f) * 3;
            } else {
                height = (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f);
            }
            a(coordinatorLayout, (AppBarLayout) t, i, height);
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int iC = c();
            if (iC == i) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                this.m = new ValueAnimator();
                this.m.setInterpolator(com.google.android.material.a.a.f13085e);
                this.m.addUpdateListener(new c(this, coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i2, WebIndicator.DO_END_ANIMATION_DURATION));
            this.m.setIntValues(iC, i);
            this.m.start();
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.d) t.getLayoutParams())).height == -2) {
                coordinatorLayout.onMeasureChild(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.a(coordinatorLayout, t, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int iRound;
            boolean zA = super.a(coordinatorLayout, t, i);
            int pendingAction = t.getPendingAction();
            int i2 = this.n;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i2);
                int i3 = -childAt.getBottom();
                if (this.o) {
                    iRound = ViewCompat.n(childAt) + t.getTopInset();
                } else {
                    iRound = Math.round(childAt.getHeight() * this.p);
                }
                c(coordinatorLayout, t, i3 + iRound);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        a(coordinatorLayout, t, i4, WheelView.DividerConfig.FILL);
                    } else {
                        c(coordinatorLayout, t, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        a(coordinatorLayout, t, 0, WheelView.DividerConfig.FILL);
                    } else {
                        c(coordinatorLayout, t, 0);
                    }
                }
            }
            t.resetPendingAction();
            this.n = -1;
            a(androidx.core.c.a.a(b(), -t.getTotalScrollRange(), 0));
            a(coordinatorLayout, (AppBarLayout) t, b(), 0, true);
            t.onOffsetChanged(b());
            return zA;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        public boolean a(T t) {
            a aVar = this.r;
            if (aVar != null) {
                return aVar.a(t);
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void e(CoordinatorLayout coordinatorLayout, T t) {
            d(coordinatorLayout, (AppBarLayout) t);
            if (t.isLiftOnScroll()) {
                t.setLiftedState(t.shouldLift(a(coordinatorLayout)));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.HeaderBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int b(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int iC = c();
            int i4 = 0;
            if (i2 != 0 && iC >= i2 && iC <= i3) {
                int iA = androidx.core.c.a.a(i, i2, i3);
                if (iC != iA) {
                    int iC2 = t.hasChildWithInterpolator() ? c(t, iA) : iA;
                    boolean zA = a(iC2);
                    i4 = iC - iA;
                    this.k = iA - iC2;
                    if (!zA && t.hasChildWithInterpolator()) {
                        coordinatorLayout.dispatchDependentViewsChanged(t);
                    }
                    t.onOffsetChanged(b());
                    a(coordinatorLayout, (AppBarLayout) t, iA, iA < iC ? -1 : 1, false);
                }
            } else {
                this.k = 0;
            }
            return i4;
        }

        private void a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, boolean z) {
            View viewA = a(t, i);
            if (viewA != null) {
                int iA = ((LayoutParams) viewA.getLayoutParams()).a();
                boolean zShouldLift = false;
                if ((iA & 1) != 0) {
                    int iN = ViewCompat.n(viewA);
                    if (i2 <= 0 || (iA & 12) == 0 ? !((iA & 2) == 0 || (-i) < (viewA.getBottom() - iN) - t.getTopInset()) : (-i) >= (viewA.getBottom() - iN) - t.getTopInset()) {
                        zShouldLift = true;
                    }
                }
                if (t.isLiftOnScroll()) {
                    zShouldLift = t.shouldLift(a(coordinatorLayout));
                }
                boolean liftedState = t.setLiftedState(zShouldLift);
                if (z || (liftedState && c(coordinatorLayout, (AppBarLayout) t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        private static View a(AppBarLayout appBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private View a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof l) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof b) {
                b bVar = (b) parcelable;
                super.a(coordinatorLayout, t, bVar.a());
                this.n = bVar.f13104c;
                this.p = bVar.f13105d;
                this.o = bVar.f13106e;
                return;
            }
            super.a(coordinatorLayout, t, parcelable);
            this.n = -1;
        }
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            return super.a(coordinatorLayout, appBarLayout, i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ int b() {
            return super.b();
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void setDragCallback(BaseBehavior.a aVar) {
            super.setDragCallback(aVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, appBarLayout, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: b */
        public /* bridge */ /* synthetic */ Parcelable d(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.d(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, iArr, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            super.a(coordinatorLayout, appBarLayout, view, i, i2, i3, i4, i5, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.a(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            return super.b(coordinatorLayout, appBarLayout, view, view2, i, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        public /* bridge */ /* synthetic */ void a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            super.a(coordinatorLayout, appBarLayout, view, i);
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior
        public /* bridge */ /* synthetic */ boolean a(int i) {
            return super.a(i);
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        /* bridge */ /* synthetic */ View a(List list) {
            return a((List<View>) list);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            a(view, view2);
            b(view, view2);
            return false;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        int c(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            b(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.material.appbar.ViewOffsetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.a(coordinatorLayout, view, i);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.a(coordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        float b(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iA = a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iA > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iA / i) + 1.0f;
                }
            }
            return WheelView.DividerConfig.FILL;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutA = a(coordinatorLayout.getDependencies(view));
            if (appBarLayoutA != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f13118d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutA.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        private void b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.isLiftOnScroll()) {
                    appBarLayout.setLiftedState(appBarLayout.shouldLift(view));
                }
            }
        }

        private void a(View view, View view2) {
            CoordinatorLayout.Behavior behaviorD = ((CoordinatorLayout.d) view2.getLayoutParams()).d();
            if (behaviorD instanceof BaseBehavior) {
                ViewCompat.c(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) behaviorD).k) + d()) - a(view2));
            }
        }

        private static int a(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior behaviorD = ((CoordinatorLayout.d) appBarLayout.getLayoutParams()).d();
            if (behaviorD instanceof BaseBehavior) {
                return ((BaseBehavior) behaviorD).c();
            }
            return 0;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        AppBarLayout a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    public interface a<T extends AppBarLayout> {
        void a(T t, int i);
    }

    public interface b extends a<AppBarLayout> {
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    private void clearLiftOnScrollTargetView() {
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.liftOnScrollTargetView = null;
    }

    private View findLiftOnScrollTargetView(View view) {
        int i;
        if (this.liftOnScrollTargetView == null && (i = this.liftOnScrollTargetViewId) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.liftOnScrollTargetViewId);
            }
            if (viewFindViewById != null) {
                this.liftOnScrollTargetView = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.liftOnScrollTargetView;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean hasCollapsibleChild() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    private boolean setLiftableState(boolean z) {
        if (this.liftable == z) {
            return false;
        }
        this.liftable = z;
        refreshDrawableState();
        return true;
    }

    private boolean shouldDrawStatusBarForeground() {
        return this.statusBarForeground != null && getTopInset() > 0;
    }

    private boolean shouldOffsetFirstChild() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || ViewCompat.j(childAt)) ? false : true;
    }

    private void startLiftOnScrollElevationOverlayAnimation(i iVar, boolean z) {
        float dimension = getResources().getDimension(R.dimen.design_appbar_elevation);
        float f2 = z ? WheelView.DividerConfig.FILL : dimension;
        if (!z) {
            dimension = WheelView.DividerConfig.FILL;
        }
        ValueAnimator valueAnimator = this.elevationOverlayAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.elevationOverlayAnimator = ValueAnimator.ofFloat(f2, dimension);
        this.elevationOverlayAnimator.setDuration(getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
        this.elevationOverlayAnimator.setInterpolator(com.google.android.material.a.a.f13081a);
        this.elevationOverlayAnimator.addUpdateListener(new com.google.android.material.appbar.b(this, iVar));
        this.elevationOverlayAnimator.start();
    }

    private void updateWillNotDraw() {
        setWillNotDraw(!shouldDrawStatusBarForeground());
    }

    public void addOnOffsetChangedListener(a aVar) {
        if (this.listeners == null) {
            this.listeners = new ArrayList();
        }
        if (aVar == null || this.listeners.contains(aVar)) {
            return;
        }
        this.listeners.add(aVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (shouldDrawStatusBarForeground()) {
            int iSave = canvas.save();
            canvas.translate(WheelView.DividerConfig.FILL, -this.currentOffset);
            this.statusBarForeground.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarForeground;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iN;
        int i = this.downPreScrollRange;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f13107a;
            if ((i3 & 5) != 5) {
                if (i2 > 0) {
                    break;
                }
            } else {
                int i4 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                if ((i3 & 8) != 0) {
                    iN = ViewCompat.n(childAt);
                } else if ((i3 & 2) != 0) {
                    iN = measuredHeight - ViewCompat.n(childAt);
                } else {
                    iMin = i4 + measuredHeight;
                    if (childCount == 0 && ViewCompat.j(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i2 += iMin;
                }
                iMin = i4 + iN;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i2 += iMin;
            }
        }
        int iMax = Math.max(0, i2);
        this.downPreScrollRange = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i = this.downScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iN = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            int i3 = layoutParams.f13107a;
            if ((i3 & 1) == 0) {
                break;
            }
            iN += measuredHeight;
            if ((i3 & 2) != 0) {
                iN -= ViewCompat.n(childAt);
                break;
            }
            i2++;
        }
        int iMax = Math.max(0, iN);
        this.downScrollRange = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.liftOnScrollTargetViewId;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iN = ViewCompat.n(this);
        if (iN == 0) {
            int childCount = getChildCount();
            iN = childCount >= 1 ? ViewCompat.n(getChildAt(childCount - 1)) : 0;
            if (iN == 0) {
                return getHeight() / 3;
            }
        }
        return (iN * 2) + topInset;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    public Drawable getStatusBarForeground() {
        return this.statusBarForeground;
    }

    @Deprecated
    public float getTargetElevation() {
        return WheelView.DividerConfig.FILL;
    }

    final int getTopInset() {
        J j = this.lastInsets;
        if (j != null) {
            return j.e();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.totalScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int iN = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.f13107a;
            if ((i3 & 1) == 0) {
                break;
            }
            iN += measuredHeight + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            if (i2 == 0 && ViewCompat.j(childAt)) {
                iN -= getTopInset();
            }
            if ((i3 & 2) != 0) {
                iN -= ViewCompat.n(childAt);
                break;
            }
            i2++;
        }
        int iMax = Math.max(0, iN);
        this.totalScrollRange = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] iArr = this.tmpStatesArray;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.liftable ? R.attr.state_liftable : -R.attr.state_liftable;
        iArr[1] = (this.liftable && this.lifted) ? R.attr.state_lifted : -R.attr.state_lifted;
        iArr[2] = this.liftable ? R.attr.state_collapsible : -R.attr.state_collapsible;
        iArr[3] = (this.liftable && this.lifted) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clearLiftOnScrollTargetView();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (ViewCompat.j(this) && shouldOffsetFirstChild()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.c(getChildAt(childCount), topInset);
            }
        }
        invalidateScrollRanges();
        this.haveChildWithInterpolator = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            }
            if (((LayoutParams) getChildAt(i5).getLayoutParams()).b() != null) {
                this.haveChildWithInterpolator = true;
                break;
            }
            i5++;
        }
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.liftableOverride) {
            return;
        }
        setLiftableState(this.liftOnScroll || hasCollapsibleChild());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && ViewCompat.j(this) && shouldOffsetFirstChild()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = androidx.core.c.a.a(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i2));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        invalidateScrollRanges();
    }

    void onOffsetChanged(int i) {
        this.currentOffset = i;
        if (!willNotDraw()) {
            ViewCompat.G(this);
        }
        List<a> list = this.listeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.listeners.get(i2);
                if (aVar != null) {
                    aVar.a(this, i);
                }
            }
        }
    }

    J onWindowInsetChanged(J j) {
        J j2 = ViewCompat.j(this) ? j : null;
        if (!androidx.core.f.c.a(this.lastInsets, j2)) {
            this.lastInsets = j2;
            updateWillNotDraw();
            requestLayout();
        }
        return j;
    }

    public void removeOnOffsetChangedListener(a aVar) {
        List<a> list = this.listeners;
        if (list == null || aVar == null) {
            return;
        }
        list.remove(aVar);
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        j.a(this, f2);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.C(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.liftOnScroll = z;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.liftOnScrollTargetViewId = i;
        clearLiftOnScrollTargetView();
    }

    public boolean setLiftable(boolean z) {
        this.liftableOverride = true;
        return setLiftableState(z);
    }

    public boolean setLifted(boolean z) {
        return setLiftedState(z);
    }

    boolean setLiftedState(boolean z) {
        if (this.lifted == z) {
            return false;
        }
        this.lifted = z;
        refreshDrawableState();
        if (!this.liftOnScroll || !(getBackground() instanceof i)) {
            return true;
        }
        startLiftOnScrollElevationOverlayAnimation((i) getBackground(), z);
        return true;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.statusBarForeground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.statusBarForeground = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.statusBarForeground;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.statusBarForeground.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a(this.statusBarForeground, ViewCompat.m(this));
                this.statusBarForeground.setVisible(getVisibility() == 0, false);
                this.statusBarForeground.setCallback(this);
            }
            updateWillNotDraw();
            ViewCompat.G(this);
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            h.a(this, f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.statusBarForeground;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    boolean shouldLift(View view) {
        View viewFindLiftOnScrollTargetView = findLiftOnScrollTargetView(view);
        if (viewFindLiftOnScrollTargetView != null) {
            view = viewFindLiftOnScrollTargetView;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.statusBarForeground;
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.appBarLayoutStyle);
    }

    public void setExpanded(boolean z, boolean z2) {
        setExpanded(z, z2, true);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
        this.pendingAction = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            h.a(this);
            h.a(this, attributeSet, i, R.style.Widget_Design_AppBarLayout);
        }
        TypedArray typedArrayA = s.a(context, attributeSet, R.styleable.AppBarLayout, i, R.style.Widget_Design_AppBarLayout, new int[0]);
        ViewCompat.a(this, typedArrayA.getDrawable(R.styleable.AppBarLayout_android_background));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            i iVar = new i();
            iVar.a(ColorStateList.valueOf(colorDrawable.getColor()));
            iVar.a(context);
            ViewCompat.a(this, iVar);
        }
        if (typedArrayA.hasValue(R.styleable.AppBarLayout_expanded)) {
            setExpanded(typedArrayA.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && typedArrayA.hasValue(R.styleable.AppBarLayout_elevation)) {
            h.a(this, typedArrayA.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (typedArrayA.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(typedArrayA.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (typedArrayA.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(typedArrayA.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.liftOnScroll = typedArrayA.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        this.liftOnScrollTargetViewId = typedArrayA.getResourceId(R.styleable.AppBarLayout_liftOnScrollTargetViewId, -1);
        setStatusBarForeground(typedArrayA.getDrawable(R.styleable.AppBarLayout_statusBarForeground));
        typedArrayA.recycle();
        ViewCompat.a(this, new com.google.android.material.appbar.a(this));
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        this.pendingAction = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public void removeOnOffsetChangedListener(b bVar) {
        removeOnOffsetChangedListener((a) bVar);
    }

    public void addOnOffsetChangedListener(b bVar) {
        addOnOffsetChangedListener((a) bVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f13108b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f13107a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.f13107a = typedArrayObtainStyledAttributes.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f13108b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f13107a;
        }

        public Interpolator b() {
            return this.f13108b;
        }

        boolean c() {
            int i = this.f13107a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f13107a = 1;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f13107a = 1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f13107a = 1;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f13107a = 1;
        }
    }
}
