package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R;
import androidx.core.view.C0316d;
import androidx.core.view.J;
import androidx.core.view.ViewCompat;
import androidx.core.view.n;
import androidx.core.view.o;
import androidx.core.view.q;
import androidx.core.view.r;
import cn.qqtheme.framework.widget.WheelView;
import com.alibaba.android.arouter.utils.Consts;
import com.uc.crashsdk.export.LogType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements n, o {
    static final Class<?>[] CONSTRUCTOR_PARAMS;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors;
    private static final androidx.core.f.e<Rect> sRectPool;
    private r mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final androidx.coordinatorlayout.widget.c<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private J mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final q mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private e mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final List<View> mTempList1;

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public J a(CoordinatorLayout coordinatorLayout, V v, J j) {
            return j;
        }

        public void a() {
        }

        public void a(d dVar) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v) {
            return c(coordinatorLayout, v) > WheelView.DividerConfig.FILL;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f2, float f3, boolean z) {
            return false;
        }

        public int b(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @Deprecated
        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return b(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        public float c(CoordinatorLayout coordinatorLayout, V v) {
            return WheelView.DividerConfig.FILL;
        }

        public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Parcelable d(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                a(coordinatorLayout, v, view, view2, i);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                d(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            a(coordinatorLayout, v, view, i, i2, i3, i4, i5);
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, v, view, i, i2, iArr);
            }
        }
    }

    public interface a {
        Behavior getBehavior();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface b {
        Class<? extends Behavior> value();
    }

    private class c implements ViewGroup.OnHierarchyChangeListener {
        c() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    static class g implements Comparator<View> {
        g() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fW = ViewCompat.w(view);
            float fW2 = ViewCompat.w(view2);
            if (fW > fW2) {
                return -1;
            }
            return fW < fW2 ? 1 : 0;
        }
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new g();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal<>();
        sRectPool = new androidx.core.f.g(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    private static Rect acquireTempRect() {
        Rect rectA = sRectPool.a();
        return rectA == null ? new Rect() : rectA;
    }

    private static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private void constrainChildRect(d dVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    private J dispatchApplyWindowInsetsToBehaviors(J j) {
        Behavior behaviorD;
        if (j.g()) {
            return j;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.j(childAt) && (behaviorD = ((d) childAt.getLayoutParams()).d()) != null) {
                j = behaviorD.a(this, childAt, j);
                if (j.g()) {
                    break;
                }
            }
        }
        return j;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, d dVar, int i2, int i3) {
        int iA = C0316d.a(resolveAnchoredChildGravity(dVar.f900c), i);
        int iA2 = C0316d.a(resolveGravity(dVar.f901d), i);
        int i4 = iA & 7;
        int i5 = iA & 112;
        int i6 = iA2 & 7;
        int i7 = iA2 & 112;
        int iWidth = i6 != 1 ? i6 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i7 != 16 ? i7 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i4 == 1) {
            iWidth -= i2 / 2;
        } else if (i4 != 5) {
            iWidth -= i2;
        }
        if (i5 == 16) {
            iHeight -= i3 / 2;
        } else if (i5 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    private int getKeyline(int i) {
        int[] iArr = this.mKeylines;
        if (iArr == null) {
            Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e(TAG, "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        Comparator<View> comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.e(view);
    }

    private void layoutChild(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        Rect rectAcquireTempRect = acquireTempRect();
        rectAcquireTempRect.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin);
        if (this.mLastInsets != null && ViewCompat.j(this) && !ViewCompat.j(view)) {
            rectAcquireTempRect.left += this.mLastInsets.c();
            rectAcquireTempRect.top += this.mLastInsets.e();
            rectAcquireTempRect.right -= this.mLastInsets.d();
            rectAcquireTempRect.bottom -= this.mLastInsets.b();
        }
        Rect rectAcquireTempRect2 = acquireTempRect();
        C0316d.a(resolveGravity(dVar.f900c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectAcquireTempRect, rectAcquireTempRect2, i);
        view.layout(rectAcquireTempRect2.left, rectAcquireTempRect2.top, rectAcquireTempRect2.right, rectAcquireTempRect2.bottom);
        releaseTempRect(rectAcquireTempRect);
        releaseTempRect(rectAcquireTempRect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        Rect rectAcquireTempRect = acquireTempRect();
        Rect rectAcquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, rectAcquireTempRect);
            getDesiredAnchoredChildRect(view, i, rectAcquireTempRect, rectAcquireTempRect2);
            view.layout(rectAcquireTempRect2.left, rectAcquireTempRect2.top, rectAcquireTempRect2.right, rectAcquireTempRect2.bottom);
        } finally {
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        d dVar = (d) view.getLayoutParams();
        int iA = C0316d.a(resolveKeylineGravity(dVar.f900c), i2);
        int i3 = iA & 7;
        int i4 = iA & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int keyline = getKeyline(i) - measuredWidth;
        int i5 = 0;
        if (i3 == 1) {
            keyline += measuredWidth / 2;
        } else if (i3 == 5) {
            keyline += measuredWidth;
        }
        if (i4 == 16) {
            i5 = 0 + (measuredHeight / 2);
        } else if (i4 == 80) {
            i5 = measuredHeight + 0;
        }
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(keyline, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        boolean z;
        boolean z2;
        int width;
        int i2;
        int i3;
        int i4;
        int height;
        int i5;
        int i6;
        int i7;
        if (ViewCompat.C(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            d dVar = (d) view.getLayoutParams();
            Behavior behaviorD = dVar.d();
            Rect rectAcquireTempRect = acquireTempRect();
            Rect rectAcquireTempRect2 = acquireTempRect();
            rectAcquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (behaviorD == null || !behaviorD.a(this, view, rectAcquireTempRect)) {
                rectAcquireTempRect.set(rectAcquireTempRect2);
            } else if (!rectAcquireTempRect2.contains(rectAcquireTempRect)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectAcquireTempRect.toShortString() + " | Bounds:" + rectAcquireTempRect2.toShortString());
            }
            releaseTempRect(rectAcquireTempRect2);
            if (rectAcquireTempRect.isEmpty()) {
                releaseTempRect(rectAcquireTempRect);
                return;
            }
            int iA = C0316d.a(dVar.h, i);
            if ((iA & 48) != 48 || (i6 = (rectAcquireTempRect.top - ((ViewGroup.MarginLayoutParams) dVar).topMargin) - dVar.j) >= (i7 = rect.top)) {
                z = false;
            } else {
                setInsetOffsetY(view, i7 - i6);
                z = true;
            }
            if ((iA & 80) == 80 && (height = ((getHeight() - rectAcquireTempRect.bottom) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin) + dVar.j) < (i5 = rect.bottom)) {
                setInsetOffsetY(view, height - i5);
                z = true;
            }
            if (!z) {
                setInsetOffsetY(view, 0);
            }
            if ((iA & 3) != 3 || (i3 = (rectAcquireTempRect.left - ((ViewGroup.MarginLayoutParams) dVar).leftMargin) - dVar.i) >= (i4 = rect.left)) {
                z2 = false;
            } else {
                setInsetOffsetX(view, i4 - i3);
                z2 = true;
            }
            if ((iA & 5) == 5 && (width = ((getWidth() - rectAcquireTempRect.right) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin) + dVar.i) < (i2 = rect.right)) {
                setInsetOffsetX(view, width - i2);
                z2 = true;
            }
            if (!z2) {
                setInsetOffsetX(view, 0);
            }
            releaseTempRect(rectAcquireTempRect);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(Consts.DOT)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            str = WIDGET_PACKAGE_NAME + '.' + str;
        }
        try {
            Map<String, Constructor<Behavior>> map = sConstructors.get();
            if (map == null) {
                map = new HashMap<>();
                sConstructors.set(map);
            }
            Constructor<Behavior> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e2) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e2);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        MotionEvent motionEventObtain = null;
        boolean zA = false;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            View view = list.get(i2);
            d dVar = (d) view.getLayoutParams();
            Behavior behaviorD = dVar.d();
            if (!(zA || z) || actionMasked == 0) {
                if (!zA && behaviorD != null) {
                    if (i == 0) {
                        zA = behaviorD.a(this, view, motionEvent);
                    } else if (i == 1) {
                        zA = behaviorD.b(this, view, motionEvent);
                    }
                    if (zA) {
                        this.mBehaviorTouchView = view;
                    }
                }
                boolean zB = dVar.b();
                boolean zB2 = dVar.b(this, view);
                boolean z2 = zB2 && !zB;
                if (zB2 && !z2) {
                    break;
                }
                z = z2;
            } else if (behaviorD != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
                }
                if (i == 0) {
                    behaviorD.a(this, view, motionEventObtain);
                } else if (i == 1) {
                    behaviorD.b(this, view, motionEventObtain);
                }
            }
        }
        list.clear();
        return zA;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            d resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.a(this, childAt);
            this.mChildDag.a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.a(this, childAt, childAt2)) {
                        if (!this.mChildDag.b(childAt2)) {
                            this.mChildDag.a(childAt2);
                        }
                        this.mChildDag.a(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.b());
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.a(rect);
    }

    private void resetTouchBehaviors(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behaviorD = ((d) childAt.getLayoutParams()).d();
            if (behaviorD != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
                if (z) {
                    behaviorD.a(this, childAt, motionEventObtain);
                } else {
                    behaviorD.b(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((d) getChildAt(i2).getLayoutParams()).h();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= 8388611;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    private void setInsetOffsetX(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        int i2 = dVar.i;
        if (i2 != i) {
            ViewCompat.b(view, i - i2);
            dVar.i = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        int i2 = dVar.j;
        if (i2 != i) {
            ViewCompat.c(view, i - i2);
            dVar.j = i;
        }
    }

    private void setupForInsets() {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (!ViewCompat.j(this)) {
            ViewCompat.a(this, (r) null);
            return;
        }
        if (this.mApplyWindowInsetsListener == null) {
            this.mApplyWindowInsetsListener = new androidx.coordinatorlayout.widget.a(this);
        }
        ViewCompat.a(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(LogType.UNEXP_ANR);
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof d) && super.checkLayoutParams(layoutParams);
    }

    public void dispatchDependentViewsChanged(View view) {
        List listC = this.mChildDag.c(view);
        if (listC == null || listC.isEmpty()) {
            return;
        }
        for (int i = 0; i < listC.size(); i++) {
            View view2 = (View) listC.get(i);
            Behavior behaviorD = ((d) view2.getLayoutParams()).d();
            if (behaviorD != null) {
                behaviorD.b(this, view2, view);
            }
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect rectAcquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, rectAcquireTempRect);
        Rect rectAcquireTempRect2 = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, rectAcquireTempRect2);
        try {
            if (rectAcquireTempRect.left <= rectAcquireTempRect2.right && rectAcquireTempRect.top <= rectAcquireTempRect2.bottom && rectAcquireTempRect.right >= rectAcquireTempRect2.left) {
                if (rectAcquireTempRect.bottom >= rectAcquireTempRect2.top) {
                    z = true;
                }
            }
            return z;
        } finally {
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        d dVar = (d) view.getLayoutParams();
        Behavior behavior = dVar.f898a;
        if (behavior != null) {
            float fC = behavior.c(this, view);
            if (fC > WheelView.DividerConfig.FILL) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(dVar.f898a.b(this, view));
                this.mScrimPaint.setAlpha(clamp(Math.round(fC * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            }
            i++;
        }
        if (z != this.mNeedsPreDrawListener) {
            if (z) {
                addPreDrawListener();
            } else {
                removePreDrawListener();
            }
        }
    }

    void getChildRect(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            getDescendantRect(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> getDependencies(View view) {
        List<View> listD = this.mChildDag.d(view);
        this.mTempDependenciesList.clear();
        if (listD != null) {
            this.mTempDependenciesList.addAll(listD);
        }
        return this.mTempDependenciesList;
    }

    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List<View> getDependents(View view) {
        List listC = this.mChildDag.c(view);
        this.mTempDependenciesList.clear();
        if (listC != null) {
            this.mTempDependenciesList.addAll(listC);
        }
        return this.mTempDependenciesList;
    }

    void getDescendantRect(View view, Rect rect) {
        androidx.coordinatorlayout.widget.d.a(this, view, rect);
    }

    void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        d dVar = (d) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, dVar, measuredWidth, measuredHeight);
        constrainChildRect(dVar, rect2, measuredWidth, measuredHeight);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((d) view.getLayoutParams()).f());
    }

    public final J getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    d getResolvedLayoutParams(View view) {
        d dVar = (d) view.getLayoutParams();
        if (!dVar.f899b) {
            if (view instanceof a) {
                Behavior behavior = ((a) view).getBehavior();
                if (behavior == null) {
                    Log.e(TAG, "Attached behavior class is null");
                }
                dVar.a(behavior);
                dVar.f899b = true;
            } else {
                b bVar = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    bVar = (b) superclass.getAnnotation(b.class);
                    if (bVar != null) {
                        break;
                    }
                }
                if (bVar != null) {
                    try {
                        dVar.a(bVar.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e2) {
                        Log.e(TAG, "Default behavior class " + bVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e2);
                    }
                }
                dVar.f899b = true;
            }
        }
        return dVar;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect rectAcquireTempRect = acquireTempRect();
        getDescendantRect(view, rectAcquireTempRect);
        try {
            return rectAcquireTempRect.contains(i, i2);
        } finally {
            releaseTempRect(rectAcquireTempRect);
        }
    }

    void offsetChildToAnchor(View view, int i) {
        Behavior behaviorD;
        d dVar = (d) view.getLayoutParams();
        if (dVar.k != null) {
            Rect rectAcquireTempRect = acquireTempRect();
            Rect rectAcquireTempRect2 = acquireTempRect();
            Rect rectAcquireTempRect3 = acquireTempRect();
            getDescendantRect(dVar.k, rectAcquireTempRect);
            getChildRect(view, false, rectAcquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            getDesiredAnchoredChildRectWithoutConstraints(view, i, rectAcquireTempRect, rectAcquireTempRect3, dVar, measuredWidth, measuredHeight);
            boolean z = (rectAcquireTempRect3.left == rectAcquireTempRect2.left && rectAcquireTempRect3.top == rectAcquireTempRect2.top) ? false : true;
            constrainChildRect(dVar, rectAcquireTempRect3, measuredWidth, measuredHeight);
            int i2 = rectAcquireTempRect3.left - rectAcquireTempRect2.left;
            int i3 = rectAcquireTempRect3.top - rectAcquireTempRect2.top;
            if (i2 != 0) {
                ViewCompat.b(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.c(view, i3);
            }
            if (z && (behaviorD = dVar.d()) != null) {
                behaviorD.b(this, view, dVar.k);
            }
            releaseTempRect(rectAcquireTempRect);
            releaseTempRect(rectAcquireTempRect2);
            releaseTempRect(rectAcquireTempRect3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new e();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.j(this)) {
            ViewCompat.H(this);
        }
        this.mIsAttachedToWindow = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void onChildViewsChanged(int r18) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onChildViewsChanged(int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors(false);
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        View view = this.mNestedScrollingTarget;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mDrawStatusBarBackground || this.mStatusBarBackground == null) {
            return;
        }
        J j = this.mLastInsets;
        int iE = j != null ? j.e() : 0;
        if (iE > 0) {
            this.mStatusBarBackground.setBounds(0, 0, getWidth(), iE);
            this.mStatusBarBackground.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors(true);
        }
        boolean zPerformIntercept = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors(true);
        }
        return zPerformIntercept;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behaviorD;
        int iM = ViewCompat.m(this);
        int size = this.mDependencySortedChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.mDependencySortedChildren.get(i5);
            if (view.getVisibility() != 8 && ((behaviorD = ((d) view.getLayoutParams()).d()) == null || !behaviorD.a(this, view, iM))) {
                onLayoutChild(view, iM);
            }
        }
    }

    public void onLayoutChild(View view, int i) {
        d dVar = (d) view.getLayoutParams();
        if (dVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = dVar.k;
        if (view2 != null) {
            layoutChildWithAnchor(view, view2, i);
            return;
        }
        int i2 = dVar.f902e;
        if (i2 >= 0) {
            layoutChildWithKeyline(view, i2, i);
        } else {
            layoutChild(view, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r31, int r32) {
        /*
            Method dump skipped, instruction units count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        Behavior behaviorD;
        int childCount = getChildCount();
        boolean zA = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (behaviorD = dVar.d()) != null) {
                    zA |= behaviorD.a(this, childAt, view, f2, f3, z);
                }
            }
        }
        if (zA) {
            onChildViewsChanged(1);
        }
        return zA;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View view, float f2, float f3) {
        Behavior behaviorD;
        int childCount = getChildCount();
        boolean zA = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(0) && (behaviorD = dVar.d()) != null) {
                    zA |= behaviorD.a(this, childAt, view, f2, f3);
                }
            }
        }
        return zA;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.a());
        SparseArray<Parcelable> sparseArray = fVar.f905c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorD = getResolvedLayoutParams(childAt).d();
            if (id != -1 && behaviorD != null && (parcelable2 = sparseArray.get(id)) != null) {
                behaviorD.a(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableD;
        f fVar = new f(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorD = ((d) childAt.getLayoutParams()).d();
            if (id != -1 && behaviorD != null && (parcelableD = behaviorD.d(this, childAt)) != null) {
                sparseArray.append(id, parcelableD);
            }
        }
        fVar.f905c = sparseArray;
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[PHI: r3
      0x002b: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:9:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0054  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.mBehaviorTouchView
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L15
            boolean r3 = r0.performIntercept(r1, r4)
            if (r3 == 0) goto L2b
            goto L16
        L15:
            r3 = 0
        L16:
            android.view.View r6 = r0.mBehaviorTouchView
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$d r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.d) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior r6 = r6.d()
            if (r6 == 0) goto L2b
            android.view.View r7 = r0.mBehaviorTouchView
            boolean r6 = r6.b(r0, r7, r1)
            goto L2c
        L2b:
            r6 = 0
        L2c:
            android.view.View r7 = r0.mBehaviorTouchView
            r8 = 0
            if (r7 != 0) goto L37
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L4a
        L37:
            if (r3 == 0) goto L4a
            long r11 = android.os.SystemClock.uptimeMillis()
            r13 = 3
            r14 = 0
            r15 = 0
            r16 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L4a:
            if (r8 == 0) goto L4f
            r8.recycle()
        L4f:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L57
        L54:
            r0.resetTouchBehaviors(r5)
        L57:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void recordLastChildRect(View view, Rect rect) {
        ((d) view.getLayoutParams()).a(rect);
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behaviorD = ((d) view.getLayoutParams()).d();
        if (behaviorD == null || !behaviorD.a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.mDisallowInterceptReset) {
            return;
        }
        resetTouchBehaviors(false);
        this.mDisallowInterceptReset = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mStatusBarBackground = drawable != null ? drawable.mutate() : null;
            Drawable drawable3 = this.mStatusBarBackground;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.a(this.mStatusBarBackground, ViewCompat.m(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.G(this);
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? androidx.core.content.b.c(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.mStatusBarBackground;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.mStatusBarBackground.setVisible(z, false);
    }

    final J setWindowInsets(J j) {
        if (androidx.core.f.c.a(this.mLastInsets, j)) {
            return j;
        }
        this.mLastInsets = j;
        this.mDrawStatusBarBackground = j != null && j.e() > 0;
        setWillNotDraw(!this.mDrawStatusBarBackground && getBackground() == null);
        J jDispatchApplyWindowInsetsToBehaviors = dispatchApplyWindowInsetsToBehaviors(j);
        requestLayout();
        return jDispatchApplyWindowInsetsToBehaviors;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mStatusBarBackground;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public d generateDefaultLayoutParams() {
        return new d(-2, -2);
    }

    @Override // androidx.core.view.n
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        Behavior behaviorD;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i3) && (behaviorD = dVar.d()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorD.a(this, childAt, view, i, i2, iArr2, i3);
                    iMax = i > 0 ? Math.max(iMax, this.mBehaviorConsumed[0]) : Math.min(iMax, this.mBehaviorConsumed[0]);
                    iMax2 = i2 > 0 ? Math.max(iMax2, this.mBehaviorConsumed[1]) : Math.min(iMax2, this.mBehaviorConsumed[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    @Override // androidx.core.view.n
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        onNestedScroll(view, i, i2, i3, i4, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.n
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        Behavior behaviorD;
        this.mNestedScrollingParentHelper.a(view, view2, i, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i2) && (behaviorD = dVar.d()) != null) {
                behaviorD.a(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // androidx.core.view.n
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                Behavior behaviorD = dVar.d();
                if (behaviorD != null) {
                    boolean zB = behaviorD.b(this, childAt, view, view2, i, i2);
                    dVar.a(i2, zB);
                    z |= zB;
                } else {
                    dVar.a(i2, false);
                }
            }
        }
        return z;
    }

    @Override // androidx.core.view.n
    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d dVar = (d) childAt.getLayoutParams();
            if (dVar.a(i)) {
                Behavior behaviorD = dVar.d();
                if (behaviorD != null) {
                    behaviorD.a(this, childAt, view, i);
                }
                dVar.b(i);
                dVar.g();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public static class d extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Behavior f898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f899b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f900c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f901d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f902e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f903f;
        public int g;
        public int h;
        int i;
        int j;
        View k;
        View l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        final Rect q;
        Object r;

        public d(int i, int i2) {
            super(i, i2);
            this.f899b = false;
            this.f900c = 0;
            this.f901d = 0;
            this.f902e = -1;
            this.f903f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public void a(Behavior behavior) {
            Behavior behavior2 = this.f898a;
            if (behavior2 != behavior) {
                if (behavior2 != null) {
                    behavior2.a();
                }
                this.f898a = behavior;
                this.r = null;
                this.f899b = true;
                if (behavior != null) {
                    behavior.a(this);
                }
            }
        }

        boolean b() {
            if (this.f898a == null) {
                this.m = false;
            }
            return this.m;
        }

        public int c() {
            return this.f903f;
        }

        public Behavior d() {
            return this.f898a;
        }

        boolean e() {
            return this.p;
        }

        Rect f() {
            return this.q;
        }

        void g() {
            this.p = false;
        }

        void h() {
            this.m = false;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view) {
            boolean z = this.m;
            if (z) {
                return true;
            }
            Behavior behavior = this.f898a;
            boolean zA = (behavior != null ? behavior.a(coordinatorLayout, view) : false) | z;
            this.m = zA;
            return zA;
        }

        void a(Rect rect) {
            this.q.set(rect);
        }

        void b(int i) {
            a(i, false);
        }

        private boolean b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.k.getId() != this.f903f) {
                return false;
            }
            View view2 = this.k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent != null && parent != view) {
                    if (parent instanceof View) {
                        view2 = parent;
                    }
                } else {
                    this.l = null;
                    this.k = null;
                    return false;
                }
            }
            this.l = view2;
            return true;
        }

        boolean a() {
            return this.k == null && this.f903f != -1;
        }

        void a(int i, boolean z) {
            if (i == 0) {
                this.n = z;
            } else {
                if (i != 1) {
                    return;
                }
                this.o = z;
            }
        }

        d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f899b = false;
            this.f900c = 0;
            this.f901d = 0;
            this.f902e = -1;
            this.f903f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f900c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f903f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f901d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f902e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f899b = typedArrayObtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f899b) {
                this.f898a = CoordinatorLayout.parseBehavior(context, attributeSet, typedArrayObtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            Behavior behavior = this.f898a;
            if (behavior != null) {
                behavior.a(this);
            }
        }

        boolean a(int i) {
            if (i == 0) {
                return this.n;
            }
            if (i != 1) {
                return false;
            }
            return this.o;
        }

        void a(boolean z) {
            this.p = z;
        }

        boolean a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Behavior behavior;
            return view2 == this.l || a(view2, ViewCompat.m(coordinatorLayout)) || ((behavior = this.f898a) != null && behavior.a(coordinatorLayout, view, view2));
        }

        View a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f903f == -1) {
                this.l = null;
                this.k = null;
                return null;
            }
            if (this.k == null || !b(view, coordinatorLayout)) {
                a(view, coordinatorLayout);
            }
            return this.k;
        }

        private void a(View view, CoordinatorLayout coordinatorLayout) {
            this.k = coordinatorLayout.findViewById(this.f903f);
            View view2 = this.k;
            if (view2 == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f903f) + " to anchor view " + view);
            }
            if (view2 == coordinatorLayout) {
                if (coordinatorLayout.isInEditMode()) {
                    this.l = null;
                    this.k = null;
                    return;
                }
                throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
            }
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.l = null;
                        this.k = null;
                        return;
                    }
                    throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.l = view2;
        }

        public d(d dVar) {
            super((ViewGroup.MarginLayoutParams) dVar);
            this.f899b = false;
            this.f900c = 0;
            this.f901d = 0;
            this.f902e = -1;
            this.f903f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        private boolean a(View view, int i) {
            int iA = C0316d.a(((d) view.getLayoutParams()).g, i);
            return iA != 0 && (C0316d.a(this.h, i) & iA) == iA;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f899b = false;
            this.f900c = 0;
            this.f901d = 0;
            this.f902e = -1;
            this.f903f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f899b = false;
            this.f900c = 0;
            this.f901d = 0;
            this.f902e = -1;
            this.f903f = -1;
            this.g = 0;
            this.h = 0;
            this.q = new Rect();
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new androidx.coordinatorlayout.widget.c<>();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new q(this);
        if (i == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            if (i == 0) {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            } else {
                saveAttributeDataForStyleable(context, R.styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i, 0);
            }
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.mKeylines = resources.getIntArray(resourceId);
            float f2 = resources.getDisplayMetrics().density;
            int length = this.mKeylines.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.mKeylines[i2] = (int) (r12[i2] * f2);
            }
        }
        this.mStatusBarBackground = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new c());
        if (ViewCompat.k(this) == 0) {
            ViewCompat.f(this, 1);
        }
    }

    @Override // android.view.ViewGroup
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // androidx.core.view.o
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        Behavior behaviorD;
        int iMin;
        int iMin2;
        int childCount = getChildCount();
        boolean z = false;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                d dVar = (d) childAt.getLayoutParams();
                if (dVar.a(i5) && (behaviorD = dVar.d()) != null) {
                    int[] iArr2 = this.mBehaviorConsumed;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    behaviorD.a(this, childAt, view, i, i2, i3, i4, i5, iArr2);
                    if (i3 > 0) {
                        iMin = Math.max(i6, this.mBehaviorConsumed[0]);
                    } else {
                        iMin = Math.min(i6, this.mBehaviorConsumed[0]);
                    }
                    if (i4 > 0) {
                        iMin2 = Math.max(i7, this.mBehaviorConsumed[1]);
                    } else {
                        iMin2 = Math.min(i7, this.mBehaviorConsumed[1]);
                    }
                    i6 = iMin;
                    i7 = iMin2;
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            onChildViewsChanged(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof d) {
            return new d((d) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new d((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new d(layoutParams);
    }

    protected static class f extends androidx.customview.a.c {
        public static final Parcelable.Creator<f> CREATOR = new androidx.coordinatorlayout.widget.b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        SparseArray<Parcelable> f905c;

        public f(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f905c = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f905c.append(iArr[i2], parcelableArray[i2]);
            }
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            SparseArray<Parcelable> sparseArray = this.f905c;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f905c.keyAt(i2);
                parcelableArr[i2] = this.f905c.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
