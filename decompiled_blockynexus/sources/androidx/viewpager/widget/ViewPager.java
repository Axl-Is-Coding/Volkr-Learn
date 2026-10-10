package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.core.view.C0313a;
import androidx.core.view.ViewCompat;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private int mActivePointerId;
    androidx.viewpager.widget.a mAdapter;
    private List<d> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private e mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<b> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private g mObserver;
    private int mOffscreenPageLimit;
    private e mOnPageChangeListener;
    private List<e> mOnPageChangeListeners;
    private int mPageMargin;
    private f mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private EdgeEffect mRightEdge;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final b mTempItem;
    private final Rect mTempRect;
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<b> COMPARATOR = new androidx.viewpager.widget.b();
    private static final Interpolator sInterpolator = new androidx.viewpager.widget.c();
    private static final j sPositionComparator = new j();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f2391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2393c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f2394d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f2395e;

        b() {
        }
    }

    public interface d {
        void a(ViewPager viewPager, androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public interface e {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f2, int i2);

        void onPageSelected(int i);
    }

    public interface f {
        void a(View view, float f2);
    }

    private class g extends DataSetObserver {
        g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    public static class h extends androidx.customview.a.c {
        public static final Parcelable.Creator<h> CREATOR = new androidx.viewpager.widget.f();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Parcelable f2399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        ClassLoader f2400e;

        public h(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f2398c + "}";
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2398c);
            parcel.writeParcelable(this.f2399d, i);
        }

        h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? h.class.getClassLoader() : classLoader;
            this.f2398c = parcel.readInt();
            this.f2399d = parcel.readParcelable(classLoader);
            this.f2400e = classLoader;
        }
    }

    public static class i implements e {
        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int i) {
        }
    }

    static class j implements Comparator<View> {
        j() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z = layoutParams.f2385a;
            return z != layoutParams2.f2385a ? z ? 1 : -1 : layoutParams.f2389e - layoutParams2.f2389e;
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.mItems = new ArrayList<>();
        this.mTempItem = new b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new androidx.viewpager.widget.d(this);
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(b bVar, int i2, b bVar2) {
        int i3;
        int i4;
        b bVar3;
        b bVar4;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f2 = clientWidth > 0 ? this.mPageMargin / clientWidth : WheelView.DividerConfig.FILL;
        if (bVar2 != null) {
            int i5 = bVar2.f2392b;
            int i6 = bVar.f2392b;
            if (i5 < i6) {
                float pageWidth = bVar2.f2395e + bVar2.f2394d + f2;
                int i7 = i5 + 1;
                int i8 = 0;
                while (i7 <= bVar.f2392b && i8 < this.mItems.size()) {
                    b bVar5 = this.mItems.get(i8);
                    while (true) {
                        bVar4 = bVar5;
                        if (i7 <= bVar4.f2392b || i8 >= this.mItems.size() - 1) {
                            break;
                        }
                        i8++;
                        bVar5 = this.mItems.get(i8);
                    }
                    while (i7 < bVar4.f2392b) {
                        pageWidth += this.mAdapter.getPageWidth(i7) + f2;
                        i7++;
                    }
                    bVar4.f2395e = pageWidth;
                    pageWidth += bVar4.f2394d + f2;
                    i7++;
                }
            } else if (i5 > i6) {
                int size = this.mItems.size() - 1;
                float pageWidth2 = bVar2.f2395e;
                while (true) {
                    i5--;
                    if (i5 < bVar.f2392b || size < 0) {
                        break;
                    }
                    b bVar6 = this.mItems.get(size);
                    while (true) {
                        bVar3 = bVar6;
                        if (i5 >= bVar3.f2392b || size <= 0) {
                            break;
                        }
                        size--;
                        bVar6 = this.mItems.get(size);
                    }
                    while (i5 > bVar3.f2392b) {
                        pageWidth2 -= this.mAdapter.getPageWidth(i5) + f2;
                        i5--;
                    }
                    pageWidth2 -= bVar3.f2394d + f2;
                    bVar3.f2395e = pageWidth2;
                }
            }
        }
        int size2 = this.mItems.size();
        float pageWidth3 = bVar.f2395e;
        int i9 = bVar.f2392b;
        int i10 = i9 - 1;
        this.mFirstOffset = i9 == 0 ? pageWidth3 : -3.4028235E38f;
        int i11 = count - 1;
        this.mLastOffset = bVar.f2392b == i11 ? (bVar.f2395e + bVar.f2394d) - 1.0f : Float.MAX_VALUE;
        int i12 = i2 - 1;
        while (i12 >= 0) {
            b bVar7 = this.mItems.get(i12);
            while (true) {
                i4 = bVar7.f2392b;
                if (i10 <= i4) {
                    break;
                }
                pageWidth3 -= this.mAdapter.getPageWidth(i10) + f2;
                i10--;
            }
            pageWidth3 -= bVar7.f2394d + f2;
            bVar7.f2395e = pageWidth3;
            if (i4 == 0) {
                this.mFirstOffset = pageWidth3;
            }
            i12--;
            i10--;
        }
        float pageWidth4 = bVar.f2395e + bVar.f2394d + f2;
        int i13 = bVar.f2392b + 1;
        int i14 = i2 + 1;
        while (i14 < size2) {
            b bVar8 = this.mItems.get(i14);
            while (true) {
                i3 = bVar8.f2392b;
                if (i13 >= i3) {
                    break;
                }
                pageWidth4 += this.mAdapter.getPageWidth(i13) + f2;
                i13++;
            }
            if (i3 == i11) {
                this.mLastOffset = (bVar8.f2394d + pageWidth4) - 1.0f;
            }
            bVar8.f2395e = pageWidth4;
            pageWidth4 += bVar8.f2394d + f2;
            i14++;
            i13++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z) {
        boolean z2 = this.mScrollState == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        boolean z3 = z2;
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = this.mItems.get(i2);
            if (bVar.f2393c) {
                bVar.f2393c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.a(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int i2, float f2, int i3, int i4) {
        if (Math.abs(i4) <= this.mFlingDistance || Math.abs(i3) <= this.mMinimumVelocity) {
            i2 += (int) (f2 + (i2 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i3 <= 0) {
            i2++;
        }
        if (this.mItems.size() <= 0) {
            return i2;
        }
        return Math.max(this.mItems.get(0).f2392b, Math.min(i2, this.mItems.get(r4.size() - 1).f2392b));
    }

    private void dispatchOnPageScrolled(int i2, float f2, int i3) {
        e eVar = this.mOnPageChangeListener;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
        List<e> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                e eVar2 = this.mOnPageChangeListeners.get(i4);
                if (eVar2 != null) {
                    eVar2.onPageScrolled(i2, f2, i3);
                }
            }
        }
        e eVar3 = this.mInternalPageChangeListener;
        if (eVar3 != null) {
            eVar3.onPageScrolled(i2, f2, i3);
        }
    }

    private void dispatchOnPageSelected(int i2) {
        e eVar = this.mOnPageChangeListener;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
        List<e> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = this.mOnPageChangeListeners.get(i3);
                if (eVar2 != null) {
                    eVar2.onPageSelected(i2);
                }
            }
        }
        e eVar3 = this.mInternalPageChangeListener;
        if (eVar3 != null) {
            eVar3.onPageSelected(i2);
        }
    }

    private void dispatchOnScrollStateChanged(int i2) {
        e eVar = this.mOnPageChangeListener;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
        List<e> list = this.mOnPageChangeListeners;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar2 = this.mOnPageChangeListeners.get(i3);
                if (eVar2 != null) {
                    eVar2.onPageScrollStateChanged(i2);
                }
            }
        }
        e eVar3 = this.mInternalPageChangeListener;
        if (eVar3 != null) {
            eVar3.onPageScrollStateChanged(i2);
        }
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private b infoForCurrentScrollPosition() {
        int i2;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : WheelView.DividerConfig.FILL;
        float f2 = clientWidth > 0 ? this.mPageMargin / clientWidth : WheelView.DividerConfig.FILL;
        b bVar = null;
        int i3 = 0;
        boolean z = true;
        int i4 = -1;
        float f3 = WheelView.DividerConfig.FILL;
        float f4 = WheelView.DividerConfig.FILL;
        while (i3 < this.mItems.size()) {
            b bVar2 = this.mItems.get(i3);
            if (!z && bVar2.f2392b != (i2 = i4 + 1)) {
                bVar2 = this.mTempItem;
                bVar2.f2395e = f3 + f4 + f2;
                bVar2.f2392b = i2;
                bVar2.f2394d = this.mAdapter.getPageWidth(bVar2.f2392b);
                i3--;
            }
            f3 = bVar2.f2395e;
            float f5 = bVar2.f2394d + f3 + f2;
            if (!z && scrollX < f3) {
                return bVar;
            }
            if (scrollX < f5 || i3 == this.mItems.size() - 1) {
                return bVar2;
            }
            i4 = bVar2.f2392b;
            f4 = bVar2.f2394d;
            i3++;
            bVar = bVar2;
            z = false;
        }
        return bVar;
    }

    private static boolean isDecorView(View view) {
        return view.getClass().getAnnotation(a.class) != null;
    }

    private boolean isGutterDrag(float f2, float f3) {
        return (f2 < ((float) this.mGutterSize) && f3 > WheelView.DividerConfig.FILL) || (f2 > ((float) (getWidth() - this.mGutterSize)) && f3 < WheelView.DividerConfig.FILL);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(i2);
            this.mActivePointerId = motionEvent.getPointerId(i2);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i2) {
        if (this.mItems.size() == 0) {
            if (this.mFirstLayout) {
                return false;
            }
            this.mCalledSuper = false;
            onPageScrolled(0, WheelView.DividerConfig.FILL, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        b bVarInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientWidth = getClientWidth();
        int i3 = this.mPageMargin;
        int i4 = clientWidth + i3;
        float f2 = clientWidth;
        int i5 = bVarInfoForCurrentScrollPosition.f2392b;
        float f3 = ((i2 / f2) - bVarInfoForCurrentScrollPosition.f2395e) / (bVarInfoForCurrentScrollPosition.f2394d + (i3 / f2));
        this.mCalledSuper = false;
        onPageScrolled(i5, f3, (int) (i4 * f3));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f2) {
        boolean z;
        boolean z2;
        float f3 = this.mLastMotionX - f2;
        this.mLastMotionX = f2;
        float scrollX = getScrollX() + f3;
        float clientWidth = getClientWidth();
        float f4 = this.mFirstOffset * clientWidth;
        float f5 = this.mLastOffset * clientWidth;
        boolean z3 = false;
        b bVar = this.mItems.get(0);
        ArrayList<b> arrayList = this.mItems;
        b bVar2 = arrayList.get(arrayList.size() - 1);
        if (bVar.f2392b != 0) {
            f4 = bVar.f2395e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (bVar2.f2392b != this.mAdapter.getCount() - 1) {
            f5 = bVar2.f2395e * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f4 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        } else if (scrollX > f5) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(scrollX - f5) / clientWidth);
                z3 = true;
            }
            scrollX = f5;
        }
        int i2 = (int) scrollX;
        this.mLastMotionX += scrollX - i2;
        scrollTo(i2, getScrollY());
        pageScrolled(i2);
        return z3;
    }

    private void recomputeScrollPosition(int i2, int i3, int i4, int i5) {
        if (i3 > 0 && !this.mItems.isEmpty()) {
            if (!this.mScroller.isFinished()) {
                this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i3 - getPaddingLeft()) - getPaddingRight()) + i5)) * (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)), getScrollY());
                return;
            }
        }
        b bVarInfoForPosition = infoForPosition(this.mCurItem);
        int iMin = (int) ((bVarInfoForPosition != null ? Math.min(bVarInfoForPosition.f2395e, this.mLastOffset) : WheelView.DividerConfig.FILL) * ((i2 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            completeScroll(false);
            scrollTo(iMin, getScrollY());
        }
    }

    private void removeNonDecorViews() {
        int i2 = 0;
        while (i2 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f2385a) {
                removeViewAt(i2);
                i2--;
            }
            i2++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        return this.mLeftEdge.isFinished() || this.mRightEdge.isFinished();
    }

    private void scrollToItem(int i2, boolean z, int i3, boolean z2) {
        b bVarInfoForPosition = infoForPosition(i2);
        int clientWidth = bVarInfoForPosition != null ? (int) (getClientWidth() * Math.max(this.mFirstOffset, Math.min(bVarInfoForPosition.f2395e, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i3);
            if (z2) {
                dispatchOnPageSelected(i2);
                return;
            }
            return;
        }
        if (z2) {
            dispatchOnPageSelected(i2);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                this.mDrawingOrderedChildren.add(getChildAt(i2));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        b bVarInfoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i4 = 0; i4 < getChildCount(); i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() == 0 && (bVarInfoForChild = infoForChild(childAt)) != null && bVarInfoForChild.f2392b == this.mCurItem) {
                    childAt.addFocusables(arrayList, i2, i3);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i3 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    b addNewItem(int i2, int i3) {
        b bVar = new b();
        bVar.f2392b = i2;
        bVar.f2391a = this.mAdapter.instantiateItem((ViewGroup) this, i2);
        bVar.f2394d = this.mAdapter.getPageWidth(i2);
        if (i3 < 0 || i3 >= this.mItems.size()) {
            this.mItems.add(bVar);
        } else {
            this.mItems.add(i3, bVar);
        }
        return bVar;
    }

    public void addOnAdapterChangeListener(d dVar) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(dVar);
    }

    public void addOnPageChangeListener(e eVar) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(eVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        b bVarInfoForChild;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarInfoForChild = infoForChild(childAt)) != null && bVarInfoForChild.f2392b == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.f2385a |= isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i2, layoutParams);
        } else {
            if (layoutParams2 != null && layoutParams2.f2385a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f2388d = true;
            addViewInLayout(view, i2, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean arrowScroll(int r7) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.arrowScroll(int):boolean");
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = WheelView.DividerConfig.FILL;
        this.mInitialMotionX = WheelView.DividerConfig.FILL;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        this.mFakeDragBeginTime = jUptimeMillis;
        return true;
    }

    protected boolean canScroll(View view, boolean z, int i2, int i3, int i4) {
        int i5;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i6 = i3 + scrollX;
                if (i6 >= childAt.getLeft() && i6 < childAt.getRight() && (i5 = i4 + scrollY) >= childAt.getTop() && i5 < childAt.getBottom() && canScroll(childAt, true, i2, i6 - childAt.getLeft(), i5 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i2);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i2 < 0 ? scrollX > ((int) (((float) clientWidth) * this.mFirstOffset)) : i2 > 0 && scrollX < ((int) (((float) clientWidth) * this.mLastOffset));
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void clearOnPageChangeListeners() {
        List<e> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.G(this);
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int iMax = this.mCurItem;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < this.mItems.size()) {
            b bVar = this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(bVar.f2391a);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (!z2) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z2 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, bVar.f2392b, bVar.f2391a);
                    int i3 = this.mCurItem;
                    if (i3 == bVar.f2392b) {
                        iMax = Math.max(0, Math.min(i3, count - 1));
                    }
                } else {
                    int i4 = bVar.f2392b;
                    if (i4 != itemPosition) {
                        if (i4 == this.mCurItem) {
                            iMax = itemPosition;
                        }
                        bVar.f2392b = itemPosition;
                    }
                }
                z = true;
            }
            i2++;
        }
        if (z2) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.f2385a) {
                    layoutParams.f2387c = WheelView.DividerConfig.FILL;
                }
            }
            setCurrentItemInternal(iMax, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        b bVarInfoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (bVarInfoForChild = infoForChild(childAt)) != null && bVarInfoForChild.f2392b == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f2) {
        return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        boolean zDraw = false;
        if (overScrollMode == 0 || (overScrollMode == 1 && (aVar = this.mAdapter) != null && aVar.getCount() > 1)) {
            if (!this.mLeftEdge.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.mFirstOffset * width);
                this.mLeftEdge.setSize(height, width);
                zDraw = false | this.mLeftEdge.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.mRightEdge.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.mLastOffset + 1.0f)) * width2);
                this.mRightEdge.setSize(height2, width2);
                zDraw |= this.mRightEdge.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.mLeftEdge.finish();
            this.mRightEdge.finish();
        }
        if (zDraw) {
            ViewCompat.G(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter != null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
            this.mPopulatePending = true;
            int clientWidth = getClientWidth();
            int scrollX = getScrollX();
            b bVarInfoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(bVarInfoForCurrentScrollPosition.f2392b, ((scrollX / clientWidth) - bVarInfoForCurrentScrollPosition.f2395e) / bVarInfoForCurrentScrollPosition.f2394d, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
        }
        endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return keyEvent.hasModifiers(2) ? pageLeft() : arrowScroll(17);
            }
            if (keyCode == 22) {
                return keyEvent.hasModifiers(2) ? pageRight() : arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f2) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        if (this.mAdapter == null) {
            return;
        }
        this.mLastMotionX += f2;
        float scrollX = getScrollX() - f2;
        float clientWidth = getClientWidth();
        float f3 = this.mFirstOffset * clientWidth;
        float f4 = this.mLastOffset * clientWidth;
        b bVar = this.mItems.get(0);
        b bVar2 = this.mItems.get(r4.size() - 1);
        if (bVar.f2392b != 0) {
            f3 = bVar.f2395e * clientWidth;
        }
        if (bVar2.f2392b != this.mAdapter.getCount() - 1) {
            f4 = bVar2.f2395e * clientWidth;
        }
        if (scrollX < f3) {
            scrollX = f3;
        } else if (scrollX > f4) {
            scrollX = f4;
        }
        int i2 = (int) scrollX;
        this.mLastMotionX += scrollX - i2;
        scrollTo(i2, getScrollY());
        pageScrolled(i2);
        MotionEvent motionEventObtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, WheelView.DividerConfig.FILL, 0);
        this.mVelocityTracker.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        if (this.mDrawingOrder == 2) {
            i3 = (i2 - 1) - i3;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i3).getLayoutParams()).f2390f;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    b infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    b infoForChild(View view) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            b bVar = this.mItems.get(i2);
            if (this.mAdapter.isViewFromObject(view, bVar.f2391a)) {
                return bVar;
            }
        }
        return null;
    }

    b infoForPosition(int i2) {
        for (int i3 = 0; i3 < this.mItems.size(); i3++) {
            b bVar = this.mItems.get(i3);
            if (bVar.f2392b == i2) {
                return bVar;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f2);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f2);
        this.mCloseEnough = (int) (2.0f * f2);
        this.mDefaultGutterSize = (int) (f2 * 16.0f);
        ViewCompat.a(this, new c());
        if (ViewCompat.k(this) == 0) {
            ViewCompat.f(this, 1);
        }
        ViewCompat.a(this, new androidx.viewpager.widget.e(this));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        Scroller scroller = this.mScroller;
        if (scroller != null && !scroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.mPageMargin / width;
        int i2 = 0;
        b bVar = this.mItems.get(0);
        float f5 = bVar.f2395e;
        int size = this.mItems.size();
        int i3 = bVar.f2392b;
        int i4 = this.mItems.get(size - 1).f2392b;
        while (i3 < i4) {
            while (i3 > bVar.f2392b && i2 < size) {
                i2++;
                bVar = this.mItems.get(i2);
            }
            if (i3 == bVar.f2392b) {
                float f6 = bVar.f2395e;
                float f7 = bVar.f2394d;
                f2 = (f6 + f7) * width;
                f5 = f6 + f7 + f4;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i3);
                f2 = (f5 + pageWidth) * width;
                f5 += pageWidth + f4;
            }
            if (this.mPageMargin + f2 > scrollX) {
                f3 = f4;
                this.mMarginDrawable.setBounds(Math.round(f2), this.mTopPageBounds, Math.round(this.mPageMargin + f2), this.mBottomPageBounds);
                this.mMarginDrawable.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i3++;
            f4 = f3;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            resetTouch();
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.mInitialMotionX = x;
            this.mLastMotionX = x;
            float y = motionEvent.getY();
            this.mInitialMotionY = y;
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsUnableToDrag = false;
            this.mIsScrollStarted = true;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalX() - this.mScroller.getCurrX()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i2 = this.mActivePointerId;
            if (i2 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f2 = x2 - this.mLastMotionX;
                float fAbs = Math.abs(f2);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.mInitialMotionY);
                if (f2 != WheelView.DividerConfig.FILL && !isGutterDrag(this.mLastMotionX, f2) && canScroll(this, false, (int) f2, (int) x2, (int) y2)) {
                    this.mLastMotionX = x2;
                    this.mLastMotionY = y2;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                if (fAbs > this.mTouchSlop && fAbs * 0.5f > fAbs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    this.mLastMotionX = f2 > WheelView.DividerConfig.FILL ? this.mInitialMotionX + this.mTouchSlop : this.mInitialMotionX - this.mTouchSlop;
                    this.mLastMotionY = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > this.mTouchSlop) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(x2)) {
                    ViewCompat.G(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        b bVarInfoForChild;
        int iMax;
        int iMax2;
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int measuredHeight = paddingBottom;
        int i8 = 0;
        int measuredHeight2 = paddingTop;
        int measuredWidth = paddingLeft;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2385a) {
                    int i10 = layoutParams.f2386b;
                    int i11 = i10 & 7;
                    int i12 = i10 & 112;
                    if (i11 == 1) {
                        iMax = Math.max((i6 - childAt.getMeasuredWidth()) / 2, measuredWidth);
                    } else if (i11 == 3) {
                        iMax = measuredWidth;
                        measuredWidth = childAt.getMeasuredWidth() + measuredWidth;
                    } else if (i11 != 5) {
                        iMax = measuredWidth;
                    } else {
                        iMax = (i6 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i12 == 16) {
                        iMax2 = Math.max((i7 - childAt.getMeasuredHeight()) / 2, measuredHeight2);
                    } else if (i12 == 48) {
                        iMax2 = measuredHeight2;
                        measuredHeight2 = childAt.getMeasuredHeight() + measuredHeight2;
                    } else if (i12 != 80) {
                        iMax2 = measuredHeight2;
                    } else {
                        iMax2 = (i7 - measuredHeight) - childAt.getMeasuredHeight();
                        measuredHeight += childAt.getMeasuredHeight();
                    }
                    int i13 = iMax + scrollX;
                    childAt.layout(i13, iMax2, childAt.getMeasuredWidth() + i13, iMax2 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        int i14 = (i6 - measuredWidth) - paddingRight;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.f2385a && (bVarInfoForChild = infoForChild(childAt2)) != null) {
                    float f2 = i14;
                    int i16 = ((int) (bVarInfoForChild.f2395e * f2)) + measuredWidth;
                    if (layoutParams2.f2388d) {
                        layoutParams2.f2388d = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (f2 * layoutParams2.f2387c), FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec((i7 - measuredHeight2) - measuredHeight, FileTypeUtils.GIGABYTE));
                    }
                    childAt2.layout(i16, measuredHeight2, childAt2.getMeasuredWidth() + i16, childAt2.getMeasuredHeight() + measuredHeight2);
                }
            }
        }
        this.mTopPageBounds = measuredHeight2;
        this.mBottomPageBounds = i7 - measuredHeight;
        this.mDecorChildCount = i8;
        if (this.mFirstLayout) {
            z2 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        this.mFirstLayout = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00aa  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onMeasure(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onPageScrolled(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.mDecorChildCount
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6d
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r4
            r4 = r3
            r3 = 0
        L1d:
            if (r3 >= r6) goto L6d
            android.view.View r8 = r12.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r9 = (androidx.viewpager.widget.ViewPager.LayoutParams) r9
            boolean r10 = r9.f2385a
            if (r10 != 0) goto L2e
            goto L6a
        L2e:
            int r9 = r9.f2386b
            r9 = r9 & 7
            if (r9 == r2) goto L4f
            r10 = 3
            if (r9 == r10) goto L49
            r10 = 5
            if (r9 == r10) goto L3c
            r9 = r4
            goto L5e
        L3c:
            int r9 = r5 - r7
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r7 = r7 + r10
            goto L5b
        L49:
            int r9 = r8.getWidth()
            int r9 = r9 + r4
            goto L5e
        L4f:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r4)
        L5b:
            r11 = r9
            r9 = r4
            r4 = r11
        L5e:
            int r4 = r4 + r0
            int r10 = r8.getLeft()
            int r4 = r4 - r10
            if (r4 == 0) goto L69
            r8.offsetLeftAndRight(r4)
        L69:
            r4 = r9
        L6a:
            int r3 = r3 + 1
            goto L1d
        L6d:
            r12.dispatchOnPageScrolled(r13, r14, r15)
            androidx.viewpager.widget.ViewPager$f r13 = r12.mPageTransformer
            if (r13 == 0) goto La1
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L7c:
            if (r1 >= r14) goto La1
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            androidx.viewpager.widget.ViewPager$LayoutParams r0 = (androidx.viewpager.widget.ViewPager.LayoutParams) r0
            boolean r0 = r0.f2385a
            if (r0 == 0) goto L8d
            goto L9e
        L8d:
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            androidx.viewpager.widget.ViewPager$f r3 = r12.mPageTransformer
            r3.a(r15, r0)
        L9e:
            int r1 = r1 + 1
            goto L7c
        La1:
            r12.mCalledSuper = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onPageScrolled(int, float, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        int i3;
        int i4;
        b bVarInfoForChild;
        int childCount = getChildCount();
        int i5 = -1;
        if ((i2 & 2) != 0) {
            i5 = childCount;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = childCount - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 0 && (bVarInfoForChild = infoForChild(childAt)) != null && bVarInfoForChild.f2392b == this.mCurItem && childAt.requestFocus(i2, rect)) {
                return true;
            }
            i3 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.a());
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.restoreState(hVar.f2399d, hVar.f2400e);
            setCurrentItemInternal(hVar.f2398c, false, true);
        } else {
            this.mRestoredCurItem = hVar.f2398c;
            this.mRestoredAdapterState = hVar.f2399d;
            this.mRestoredClassLoader = hVar.f2400e;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        h hVar = new h(super.onSaveInstanceState());
        hVar.f2398c = this.mCurItem;
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            hVar.f2399d = aVar.saveState();
        }
        return hVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            int i6 = this.mPageMargin;
            recomputeScrollPosition(i2, i4, i6, i6);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    boolean pageLeft() {
        int i2 = this.mCurItem;
        if (i2 <= 0) {
            return false;
        }
        setCurrentItem(i2 - 1, true);
        return true;
    }

    boolean pageRight() {
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    void populate() {
        populate(this.mCurItem);
    }

    public void removeOnAdapterChangeListener(d dVar) {
        List<d> list = this.mAdapterChangeListeners;
        if (list != null) {
            list.remove(dVar);
        }
    }

    public void removeOnPageChangeListener(e eVar) {
        List<e> list = this.mOnPageChangeListeners;
        if (list != null) {
            list.remove(eVar);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                b bVar = this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, bVar.f2392b, bVar.f2391a);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new g();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        List<d> list = this.mAdapterChangeListeners;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.mAdapterChangeListeners.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mAdapterChangeListeners.get(i3).a(this, aVar3, aVar);
        }
    }

    public void setCurrentItem(int i2) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, !this.mFirstLayout, false);
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2) {
        setCurrentItemInternal(i2, z, z2, 0);
    }

    e setInternalPageChangeListener(e eVar) {
        e eVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = eVar;
        return eVar2;
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1) {
            Log.w(TAG, "Requested offscreen page limit " + i2 + " too small; defaulting to 1");
            i2 = 1;
        }
        if (i2 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i2;
            populate();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
        this.mOnPageChangeListener = eVar;
    }

    public void setPageMargin(int i2) {
        int i3 = this.mPageMargin;
        this.mPageMargin = i2;
        int width = getWidth();
        recomputeScrollPosition(width, width, i2, i3);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z, f fVar) {
        setPageTransformer(z, fVar, 2);
    }

    void setScrollState(int i2) {
        if (this.mScrollState == i2) {
            return;
        }
        this.mScrollState = i2;
        if (this.mPageTransformer != null) {
            enableLayers(i2 != 0);
        }
        dispatchOnScrollStateChanged(i2);
    }

    void smoothScrollTo(int i2, int i3) {
        smoothScrollTo(i2, i3, 0);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f2387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f2390f;

        public LayoutParams() {
            super(-1, -1);
            this.f2387c = WheelView.DividerConfig.FILL;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2387c = WheelView.DividerConfig.FILL;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.f2386b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0066, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00fa A[PHI: r7 r10 r15
      0x00fa: PHI (r7v14 float) = (r7v12 float), (r7v13 float), (r7v5 float) binds: [B:62:0x00ef, B:59:0x00d9, B:53:0x00c3] A[DONT_GENERATE, DONT_INLINE]
      0x00fa: PHI (r10v4 int) = (r10v3 int), (r10v2 int), (r10v7 int) binds: [B:62:0x00ef, B:59:0x00d9, B:53:0x00c3] A[DONT_GENERATE, DONT_INLINE]
      0x00fa: PHI (r15v6 int) = (r15v4 int), (r15v5 int), (r15v9 int) binds: [B:62:0x00ef, B:59:0x00d9, B:53:0x00c3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void populate(int r18) {
        /*
            Method dump skipped, instruction units count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.populate(int):void");
    }

    void setCurrentItemInternal(int i2, boolean z, boolean z2, int i3) {
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.mCurItem == i2 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 >= this.mAdapter.getCount()) {
            i2 = this.mAdapter.getCount() - 1;
        }
        int i4 = this.mOffscreenPageLimit;
        int i5 = this.mCurItem;
        if (i2 > i5 + i4 || i2 < i5 - i4) {
            for (int i6 = 0; i6 < this.mItems.size(); i6++) {
                this.mItems.get(i6).f2393c = true;
            }
        }
        boolean z3 = this.mCurItem != i2;
        if (!this.mFirstLayout) {
            populate(i2);
            scrollToItem(i2, z, i3, z3);
        } else {
            this.mCurItem = i2;
            if (z3) {
                dispatchOnPageSelected(i2);
            }
            requestLayout();
        }
    }

    public void setPageTransformer(boolean z, f fVar, int i2) {
        boolean z2 = fVar != null;
        boolean z3 = z2 != (this.mPageTransformer != null);
        this.mPageTransformer = fVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.mDrawingOrder = z ? 2 : 1;
            this.mPageTransformerLayerType = i2;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z3) {
            populate();
        }
    }

    void smoothScrollTo(int i2, int i3, int i4) {
        int scrollX;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.mScroller;
        if ((scroller == null || scroller.isFinished()) ? false : true) {
            scrollX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i5 = scrollX;
        int scrollY = getScrollY();
        int i6 = i2 - i5;
        int i7 = i3 - scrollY;
        if (i6 == 0 && i7 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i8 = clientWidth / 2;
        float f2 = clientWidth;
        float f3 = i8;
        float fDistanceInfluenceForSnapDuration = f3 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i6) * 1.0f) / f2)) * f3);
        int iAbs = Math.abs(i4);
        int iMin = Math.min(iAbs > 0 ? Math.round(Math.abs(fDistanceInfluenceForSnapDuration / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i6) / ((f2 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f), 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i5, scrollY, i6, i7, iMin);
        ViewCompat.G(this);
    }

    public void setCurrentItem(int i2, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i2, z, false);
    }

    public void setPageMarginDrawable(int i2) {
        setPageMarginDrawable(androidx.core.content.b.c(getContext(), i2));
    }

    class c extends C0313a {
        c() {
        }

        private boolean b() {
            androidx.viewpager.widget.a aVar = ViewPager.this.mAdapter;
            return aVar != null && aVar.getCount() > 1;
        }

        @Override // androidx.core.view.C0313a
        public void a(View view, androidx.core.view.accessibility.b bVar) {
            super.a(view, bVar);
            bVar.b((CharSequence) ViewPager.class.getName());
            bVar.n(b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                bVar.a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                bVar.a(8192);
            }
        }

        @Override // androidx.core.view.C0313a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            androidx.viewpager.widget.a aVar;
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(b());
            if (accessibilityEvent.getEventType() != 4096 || (aVar = ViewPager.this.mAdapter) == null) {
                return;
            }
            accessibilityEvent.setItemCount(aVar.getCount());
            accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
            accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
        }

        @Override // androidx.core.view.C0313a
        public boolean a(View view, int i, Bundle bundle) {
            if (super.a(view, i, bundle)) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || !ViewPager.this.canScrollHorizontally(-1)) {
                    return false;
                }
                ViewPager viewPager = ViewPager.this;
                viewPager.setCurrentItem(viewPager.mCurItem - 1);
                return true;
            }
            if (!ViewPager.this.canScrollHorizontally(1)) {
                return false;
            }
            ViewPager viewPager2 = ViewPager.this;
            viewPager2.setCurrentItem(viewPager2.mCurItem + 1);
            return true;
        }
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItems = new ArrayList<>();
        this.mTempItem = new b();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new androidx.viewpager.widget.d(this);
        this.mScrollState = 0;
        initViewPager();
    }
}
