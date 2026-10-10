package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.C0313a;
import androidx.core.view.C0321i;
import androidx.core.view.InterfaceC0322j;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.b;
import androidx.recyclerview.widget.W;
import androidx.recyclerview.widget.fa;
import androidx.recyclerview.widget.ga;
import androidx.recyclerview.widget.r;
import cn.qqtheme.framework.widget.WheelView;
import com.alibaba.android.arouter.utils.Consts;
import com.umeng.analytics.pro.m;
import io.rong.common.dlog.DLog;
import io.rong.imkit.utils.FileTypeUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements InterfaceC0322j, androidx.core.view.k, androidx.core.view.u {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    static final boolean ALLOW_THREAD_GAP_WORK;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {R.attr.nestedScrollingEnabled};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator;
    W mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    a mAdapter;
    C0351a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private d mChildDrawingOrderCallback;
    C0352b mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private e mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.r mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private l mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    f mItemAnimator;
    private f.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<h> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    i mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final q mObserver;
    private List<j> mOnChildAttachStateListeners;
    private k mOnFlingListener;
    private final ArrayList<l> mOnItemTouchListeners;
    final List<w> mPendingAccessibilityImportanceChange;
    private r mPendingSavedState;
    boolean mPostedAnimatorRunner;
    r.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final o mRecycler;
    p mRecyclerListener;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private m mScrollListener;
    private List<m> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.view.m mScrollingChildHelper;
    final t mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final v mViewFlinger;
    private final ga.b mViewInfoProcessCallback;
    final ga mViewInfoStore;

    public static abstract class a<VH extends w> {
        private final b mObservable = new b();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            androidx.core.os.c.a(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f1845c = true;
            }
            androidx.core.os.c.a();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                androidx.core.os.c.a(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH vh = (VH) onCreateViewHolder(viewGroup, i);
                if (vh.itemView.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.mItemViewType = i;
                return vh;
            } finally {
                androidx.core.os.c.a();
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.b(i, 1);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.c(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.a(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.b(i, i2);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.c(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.d(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.d(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(c cVar) {
            this.mObservable.registerObserver(cVar);
        }

        public void setHasStableIds(boolean z) {
            if (hasObservers()) {
                throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
            }
            this.mHasStableIds = z;
        }

        public void unregisterAdapterDataObserver(c cVar) {
            this.mObservable.unregisterObserver(cVar);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.a(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.a(i, i2, obj);
        }
    }

    static class b extends Observable<c> {
        b() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((c) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((c) ((Observable) this).mObservers.get(size)).b(i, i2);
            }
        }

        public void d(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((c) ((Observable) this).mObservers.get(size)).c(i, i2);
            }
        }

        public void a(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((c) ((Observable) this).mObservers.get(size)).a(i, i2, obj);
            }
        }

        public void b(int i, int i2) {
            a(i, i2, null);
        }

        public void a(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((c) ((Observable) this).mObservers.get(size)).a(i, i2, 1);
            }
        }
    }

    public static abstract class c {
        public void a() {
        }

        public void a(int i, int i2) {
        }

        public void a(int i, int i2, int i3) {
        }

        public void a(int i, int i2, Object obj) {
            a(i, i2);
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2) {
        }
    }

    public interface d {
        int a(int i, int i2);
    }

    public static class e {
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f1847a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<a> f1848b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f1849c = 120;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f1850d = 120;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f1851e = 250;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f1852f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(w wVar);
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1853a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1854b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f1855c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f1856d;

            public c a(w wVar) {
                a(wVar, 0);
                return this;
            }

            public c a(w wVar, int i) {
                View view = wVar.itemView;
                this.f1853a = view.getLeft();
                this.f1854b = view.getTop();
                this.f1855c = view.getRight();
                this.f1856d = view.getBottom();
                return this;
            }
        }

        void a(b bVar) {
            this.f1847a = bVar;
        }

        public abstract boolean a(w wVar, c cVar, c cVar2);

        public abstract boolean a(w wVar, w wVar2, c cVar, c cVar2);

        public abstract void b();

        public abstract boolean b(w wVar);

        public abstract boolean b(w wVar, c cVar, c cVar2);

        public long c() {
            return this.f1849c;
        }

        public abstract boolean c(w wVar, c cVar, c cVar2);

        public long d() {
            return this.f1852f;
        }

        public abstract void d(w wVar);

        public long e() {
            return this.f1851e;
        }

        public void e(w wVar) {
        }

        public long f() {
            return this.f1850d;
        }

        public abstract boolean g();

        public c h() {
            return new c();
        }

        public abstract void i();

        public c a(t tVar, w wVar, int i, List<Object> list) {
            c cVarH = h();
            cVarH.a(wVar);
            return cVarH;
        }

        public final void c(w wVar) {
            e(wVar);
            b bVar = this.f1847a;
            if (bVar != null) {
                bVar.a(wVar);
            }
        }

        public c a(t tVar, w wVar) {
            c cVarH = h();
            cVarH.a(wVar);
            return cVarH;
        }

        static int a(w wVar) {
            int i = wVar.mFlags & 14;
            if (wVar.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = wVar.getOldPosition();
            int adapterPosition = wVar.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | DLog.CRS;
        }

        public final boolean a(a aVar) {
            boolean zG = g();
            if (aVar != null) {
                if (!zG) {
                    aVar.a();
                } else {
                    this.f1848b.add(aVar);
                }
            }
            return zG;
        }

        public boolean a(w wVar, List<Object> list) {
            return b(wVar);
        }

        public final void a() {
            int size = this.f1848b.size();
            for (int i = 0; i < size; i++) {
                this.f1848b.get(i).a();
            }
            this.f1848b.clear();
        }
    }

    private class g implements f.b {
        g() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.f.b
        public void a(w wVar) {
            wVar.setIsRecyclable(true);
            if (wVar.mShadowedHolder != null && wVar.mShadowingHolder == null) {
                wVar.mShadowedHolder = null;
            }
            wVar.mShadowingHolder = null;
            if (wVar.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(wVar.itemView) || !wVar.isTmpDetached()) {
                return;
            }
            RecyclerView.this.removeDetachedView(wVar.itemView, false);
        }
    }

    public static abstract class h {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, t tVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, t tVar) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, t tVar) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).a(), recyclerView);
        }
    }

    public static abstract class i {
        C0352b mChildHelper;
        private int mHeight;
        private int mHeightMode;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        s mSmoothScroller;
        private int mWidth;
        private int mWidthMode;
        private final fa.b mHorizontalBoundCheckCallback = new T(this);
        private final fa.b mVerticalBoundCheckCallback = new U(this);
        fa mHorizontalBoundCheck = new fa(this.mHorizontalBoundCheckCallback);
        fa mVerticalBoundCheck = new fa(this.mVerticalBoundCheckCallback);
        boolean mRequestedSimpleAnimations = false;
        boolean mIsAttachedToWindow = false;
        boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        public interface a {
            void a(int i, int i2);
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f1858a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f1859b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f1860c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f1861d;
        }

        private void addViewInt(View view, int i, boolean z) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.a(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.g(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int iB = this.mChildHelper.b(view);
                if (i == -1) {
                    i = this.mChildHelper.a();
                }
                if (iB == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(view) + this.mRecyclerView.exceptionLabel());
                }
                if (iB != i) {
                    this.mRecyclerView.mLayout.moveView(iB, i);
                }
            } else {
                this.mChildHelper.a(view, i, false);
                layoutParams.f1845c = true;
                s sVar = this.mSmoothScroller;
                if (sVar != null && sVar.isRunning()) {
                    this.mSmoothScroller.onChildAttachedToWindow(view);
                }
            }
            if (layoutParams.f1846d) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.f1846d = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i2, i3) : size : Math.min(size, Math.max(i2, i3));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.a(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
        
            if (r3 >= 0) goto L8;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r1 = 0
                goto L1e
            Lf:
                if (r3 < 0) goto L15
            L11:
                r1 = r3
            L12:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L1e
            L15:
                r4 = -1
                if (r3 != r4) goto L19
                goto L12
            L19:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
            L1e:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - paddingLeft;
            int iMin = Math.min(0, i);
            int i2 = top - paddingTop;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - width;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - height);
            if (getLayoutDirection() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public static b getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            b bVar = new b();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i, i2);
            bVar.f1858a = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_orientation, 1);
            bVar.f1859b = typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_spanCount, 1);
            bVar.f1860c = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_reverseLayout, false);
            bVar.f1861d = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_stackFromEnd, false);
            typedArrayObtainStyledAttributes.recycle();
            return bVar;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void scrapOrRecycleView(o oVar, int i, View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                oVar.b(childViewHolderInt);
            } else {
                detachViewAt(i);
                oVar.c(view);
                this.mRecyclerView.mViewInfoStore.d(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.a(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.g(childViewHolderInt);
            }
            this.mChildHelper.a(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, t tVar, a aVar) {
        }

        public void collectInitialPrefetchPositions(int i, a aVar) {
        }

        public int computeHorizontalScrollExtent(t tVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(t tVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(t tVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(t tVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(t tVar) {
            return 0;
        }

        public int computeVerticalScrollRange(t tVar) {
            return 0;
        }

        public void detachAndScrapAttachedViews(o oVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(oVar, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, o oVar) {
            scrapOrRecycleView(oVar, this.mChildHelper.b(view), view);
        }

        public void detachAndScrapViewAt(int i, o oVar) {
            scrapOrRecycleView(oVar, i, getChildAt(i));
        }

        public void detachView(View view) {
            int iB = this.mChildHelper.b(view);
            if (iB >= 0) {
                detachViewInternal(iB, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        void dispatchDetachedFromWindow(RecyclerView recyclerView, o oVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, oVar);
        }

        public void endAnimation(View view) {
            f fVar = this.mRecyclerView.mItemAnimator;
            if (fVar != null) {
                fVar.d(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View viewFindContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.c(viewFindContainingItemView)) {
                return null;
            }
            return viewFindContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.d() || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1844b.bottom;
        }

        public View getChildAt(int i) {
            C0352b c0352b = this.mChildHelper;
            if (c0352b != null) {
                return c0352b.c(i);
            }
            return null;
        }

        public int getChildCount() {
            C0352b c0352b = this.mChildHelper;
            if (c0352b != null) {
                return c0352b.a();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(o oVar, t tVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return view.getBottom() + getBottomDecorationHeight(view);
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f1844b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f1844b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return view.getRight() + getRightDecorationWidth(view);
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.m(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1844b.left;
        }

        public int getMinimumHeight() {
            return ViewCompat.n(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.o(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.q(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return ViewCompat.r(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).a();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1844b.right;
        }

        public int getRowCountForAccessibility(o oVar, t tVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(o oVar, t tVar) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f1844b.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f1844b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
            }
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.h(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(o oVar, t tVar) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            s sVar = this.mSmoothScroller;
            return sVar != null && sVar.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.a(view, 24579) && this.mVerticalBoundCheck.a(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f1844b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f1844b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = i + itemDecorInsetsForChild.left + itemDecorInsetsForChild.right;
            int i4 = i2 + itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
            } else {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
            }
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(a aVar, a aVar2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, o oVar) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, o oVar, t tVar) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        void onInitializeAccessibilityNodeInfo(androidx.core.view.accessibility.b bVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, bVar);
        }

        void onInitializeAccessibilityNodeInfoForItem(View view, androidx.core.view.accessibility.b bVar) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.c(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, bVar);
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(o oVar, t tVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(t tVar) {
        }

        public void onMeasure(o oVar, t tVar, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        void onSmoothScrollerStopped(s sVar) {
            if (this.mSmoothScroller == sVar) {
                this.mSmoothScroller = null;
            }
        }

        boolean performAccessibilityAction(int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        public boolean performAccessibilityActionForItem(o oVar, t tVar, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                ViewCompat.a(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.e(childCount);
            }
        }

        public void removeAndRecycleAllViews(o oVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, oVar);
                }
            }
        }

        void removeAndRecycleScrapInt(o oVar) {
            int iE = oVar.e();
            for (int i = iE - 1; i >= 0; i--) {
                View viewC = oVar.c(i);
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(viewC);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(viewC, false);
                    }
                    f fVar = this.mRecyclerView.mItemAnimator;
                    if (fVar != null) {
                        fVar.d(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    oVar.a(viewC);
                }
            }
            oVar.c();
            if (iE > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, o oVar) {
            removeView(view);
            oVar.b(view);
        }

        public void removeAndRecycleViewAt(int i, o oVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            oVar.b(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            this.mChildHelper.d(view);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.e(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, o oVar, t tVar) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, o oVar, t tVar) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), FileTypeUtils.GIGABYTE));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.j();
                }
            }
        }

        void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            this.mWidthMode = View.MeasureSpec.getMode(i);
            if (this.mWidthMode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            this.mHeightMode = View.MeasureSpec.getMode(i2);
            if (this.mHeightMode != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, rect.width() + getPaddingLeft() + getPaddingRight(), getMinimumWidth()), chooseSize(i2, rect.height() + getPaddingTop() + getPaddingBottom(), getMinimumHeight()));
        }

        void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i5) {
                    i5 = i9;
                }
                int i10 = rect.top;
                if (i10 < i4) {
                    i4 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i3, i4, i5, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = FileTypeUtils.GIGABYTE;
            this.mHeightMode = FileTypeUtils.GIGABYTE;
        }

        boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, t tVar, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(s sVar) {
            s sVar2 = this.mSmoothScroller;
            if (sVar2 != null && sVar != sVar2 && sVar2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = sVar;
            this.mSmoothScroller.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        void stopSmoothScroller() {
            s sVar = this.mSmoothScroller;
            if (sVar != null) {
                sVar.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void onInitializeAccessibilityEvent(o oVar, t tVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            a aVar = this.mRecyclerView.mAdapter;
            if (aVar != null) {
                accessibilityEvent.setItemCount(aVar.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(o oVar, t tVar, androidx.core.view.accessibility.b bVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                bVar.a(8192);
                bVar.n(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                bVar.a(4096);
                bVar.n(true);
            }
            bVar.a(b.C0015b.a(getRowCountForAccessibility(oVar, tVar), getColumnCountForAccessibility(oVar, tVar), isLayoutHierarchical(oVar, tVar), getSelectionModeForAccessibility(oVar, tVar)));
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, t tVar, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(o oVar, t tVar, int i, Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L20
                if (r7 < 0) goto L11
                goto L22
            L11:
                if (r7 != r1) goto L33
                if (r5 == r2) goto L1c
                if (r5 == 0) goto L19
                if (r5 == r3) goto L1c
            L19:
                r5 = 0
                r7 = 0
                goto L1d
            L1c:
                r7 = r4
            L1d:
                r6 = r5
                r4 = r7
                goto L34
            L20:
                if (r7 < 0) goto L26
            L22:
                r4 = r7
                r6 = 1073741824(0x40000000, float:2.0)
                goto L34
            L26:
                if (r7 != r1) goto L2a
                r6 = r5
                goto L34
            L2a:
                if (r7 != r0) goto L33
                if (r5 == r2) goto L30
                if (r5 != r3) goto L34
            L30:
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L34
            L33:
                r4 = 0
            L34:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r6)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.i.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void onInitializeAccessibilityNodeInfoForItem(o oVar, t tVar, View view, androidx.core.view.accessibility.b bVar) {
            bVar.b(b.c.a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    public interface j {
        void a(View view);

        void b(View view);
    }

    public static abstract class k {
        public abstract boolean a(int i, int i2);
    }

    public interface l {
        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class m {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<w> f1868a = new ArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<w> f1869b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<w> f1870c = new ArrayList<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<w> f1871d = Collections.unmodifiableList(this.f1868a);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1872e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1873f = 2;
        n g;
        private u h;

        public o() {
        }

        private void e(w wVar) {
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = wVar.itemView;
                if (ViewCompat.k(view) == 0) {
                    ViewCompat.f(view, 1);
                }
                W w = RecyclerView.this.mAccessibilityDelegate;
                if (w == null) {
                    return;
                }
                C0313a c0313aB = w.b();
                if (c0313aB instanceof W.a) {
                    ((W.a) c0313aB).d(view);
                }
                ViewCompat.a(view, c0313aB);
            }
        }

        public void a() {
            this.f1868a.clear();
            i();
        }

        View b(int i, boolean z) {
            return a(i, z, RecyclerView.FOREVER_NS).itemView;
        }

        void c(View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f1869b == null) {
                    this.f1869b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f1869b.add(childViewHolderInt);
                return;
            }
            if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.f1868a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.exceptionLabel());
            }
        }

        boolean d(w wVar) {
            if (wVar.isRemoved()) {
                return RecyclerView.this.mState.d();
            }
            int i = wVar.mPosition;
            if (i >= 0 && i < RecyclerView.this.mAdapter.getItemCount()) {
                if (RecyclerView.this.mState.d() || RecyclerView.this.mAdapter.getItemViewType(wVar.mPosition) == wVar.getItemViewType()) {
                    return !RecyclerView.this.mAdapter.hasStableIds() || wVar.getItemId() == RecyclerView.this.mAdapter.getItemId(wVar.mPosition);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + wVar + RecyclerView.this.exceptionLabel());
        }

        public void f(int i) {
            this.f1872e = i;
            j();
        }

        void g() {
            int size = this.f1870c.size();
            for (int i = 0; i < size; i++) {
                LayoutParams layoutParams = (LayoutParams) this.f1870c.get(i).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f1845c = true;
                }
            }
        }

        void h() {
            int size = this.f1870c.size();
            for (int i = 0; i < size; i++) {
                w wVar = this.f1870c.get(i);
                if (wVar != null) {
                    wVar.addFlags(6);
                    wVar.addChangePayload(null);
                }
            }
            a aVar = RecyclerView.this.mAdapter;
            if (aVar == null || !aVar.hasStableIds()) {
                i();
            }
        }

        void i() {
            for (int size = this.f1870c.size() - 1; size >= 0; size--) {
                e(size);
            }
            this.f1870c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RecyclerView.this.mPrefetchRegistry.a();
            }
        }

        void j() {
            i iVar = RecyclerView.this.mLayout;
            this.f1873f = this.f1872e + (iVar != null ? iVar.mPrefetchMaxCountObserved : 0);
            for (int size = this.f1870c.size() - 1; size >= 0 && this.f1870c.size() > this.f1873f; size--) {
                e(size);
            }
        }

        public void b(View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            b(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.d(childViewHolderInt);
        }

        private boolean a(w wVar, int i, int i2, long j) {
            wVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = wVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS && !this.g.a(itemViewType, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.mAdapter.bindViewHolder(wVar, i);
            this.g.a(wVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            e(wVar);
            if (!RecyclerView.this.mState.d()) {
                return true;
            }
            wVar.mPreLayoutPosition = i2;
            return true;
        }

        public List<w> f() {
            return this.f1871d;
        }

        private void f(w wVar) {
            View view = wVar.itemView;
            if (view instanceof ViewGroup) {
                a((ViewGroup) view, false);
            }
        }

        public View d(int i) {
            return b(i, false);
        }

        void e(int i) {
            a(this.f1870c.get(i), true);
            this.f1870c.remove(i);
        }

        void b(w wVar) {
            boolean z;
            if (!wVar.isScrap() && wVar.itemView.getParent() == null) {
                if (!wVar.isTmpDetached()) {
                    if (!wVar.shouldIgnore()) {
                        boolean zDoesTransientStatePreventRecycling = wVar.doesTransientStatePreventRecycling();
                        a aVar = RecyclerView.this.mAdapter;
                        if ((aVar != null && zDoesTransientStatePreventRecycling && aVar.onFailedToRecycleView(wVar)) || wVar.isRecyclable()) {
                            if (this.f1873f <= 0 || wVar.hasAnyOfTheFlags(526)) {
                                z = false;
                            } else {
                                int size = this.f1870c.size();
                                if (size >= this.f1873f && size > 0) {
                                    e(0);
                                    size--;
                                }
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.a(wVar.mPosition)) {
                                    int i = size - 1;
                                    while (i >= 0) {
                                        if (!RecyclerView.this.mPrefetchRegistry.a(this.f1870c.get(i).mPosition)) {
                                            break;
                                        } else {
                                            i--;
                                        }
                                    }
                                    size = i + 1;
                                }
                                this.f1870c.add(size, wVar);
                                z = true;
                            }
                            if (!z) {
                                a(wVar, true);
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        RecyclerView.this.mViewInfoStore.h(wVar);
                        if (z || z || !zDoesTransientStatePreventRecycling) {
                            return;
                        }
                        wVar.mOwnerRecyclerView = null;
                        return;
                    }
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.exceptionLabel());
                }
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + wVar + RecyclerView.this.exceptionLabel());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Scrapped or attached views may not be recycled. isScrap:");
            sb.append(wVar.isScrap());
            sb.append(" isAttached:");
            sb.append(wVar.itemView.getParent() != null);
            sb.append(RecyclerView.this.exceptionLabel());
            throw new IllegalArgumentException(sb.toString());
        }

        n d() {
            if (this.g == null) {
                this.g = new n();
            }
            return this.g;
        }

        void c(w wVar) {
            if (wVar.mInChangeScrap) {
                this.f1869b.remove(wVar);
            } else {
                this.f1868a.remove(wVar);
            }
            wVar.mScrapContainer = null;
            wVar.mInChangeScrap = false;
            wVar.clearReturnedFromScrapFlag();
        }

        public int a(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.a()) {
                return !RecyclerView.this.mState.d() ? i : RecyclerView.this.mAdapterHelper.b(i);
            }
            throw new IndexOutOfBoundsException("invalid position " + i + ". State item count is " + RecyclerView.this.mState.a() + RecyclerView.this.exceptionLabel());
        }

        int e() {
            return this.f1868a.size();
        }

        /* JADX WARN: Removed duplicated region for block: B:105:0x0227 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:107:0x022a  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0180 A[PHI: r1 r4
          0x0180: PHI (r1v12 androidx.recyclerview.widget.RecyclerView$w) = (r1v11 androidx.recyclerview.widget.RecyclerView$w), (r1v31 androidx.recyclerview.widget.RecyclerView$w) binds: [B:28:0x005d, B:58:0x0101] A[DONT_GENERATE, DONT_INLINE]
          0x0180: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:58:0x0101] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x01a1  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x01cd  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x01fd  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x020b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        androidx.recyclerview.widget.RecyclerView.w a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instruction units count: 614
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.o.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$w");
        }

        View c(int i) {
            return this.f1868a.get(i).itemView;
        }

        void c() {
            this.f1868a.clear();
            ArrayList<w> arrayList = this.f1869b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        void c(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.f1870c.size() - 1; size >= 0; size--) {
                w wVar = this.f1870c.get(size);
                if (wVar != null && (i3 = wVar.mPosition) >= i && i3 < i4) {
                    wVar.addFlags(2);
                    e(size);
                }
            }
        }

        w b(int i) {
            int size;
            int iB;
            ArrayList<w> arrayList = this.f1869b;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    w wVar = this.f1869b.get(i2);
                    if (!wVar.wasReturnedFromScrap() && wVar.getLayoutPosition() == i) {
                        wVar.addFlags(32);
                        return wVar;
                    }
                }
                if (RecyclerView.this.mAdapter.hasStableIds() && (iB = RecyclerView.this.mAdapterHelper.b(i)) > 0 && iB < RecyclerView.this.mAdapter.getItemCount()) {
                    long itemId = RecyclerView.this.mAdapter.getItemId(iB);
                    for (int i3 = 0; i3 < size; i3++) {
                        w wVar2 = this.f1869b.get(i3);
                        if (!wVar2.wasReturnedFromScrap() && wVar2.getItemId() == itemId) {
                            wVar2.addFlags(32);
                            return wVar2;
                        }
                    }
                }
            }
            return null;
        }

        void b(int i, int i2) {
            int i3;
            int i4;
            int i5;
            int i6;
            if (i < i2) {
                i4 = i;
                i3 = i2;
                i5 = -1;
            } else {
                i3 = i;
                i4 = i2;
                i5 = 1;
            }
            int size = this.f1870c.size();
            for (int i7 = 0; i7 < size; i7++) {
                w wVar = this.f1870c.get(i7);
                if (wVar != null && (i6 = wVar.mPosition) >= i4 && i6 <= i3) {
                    if (i6 == i) {
                        wVar.offsetPosition(i2 - i, false);
                    } else {
                        wVar.offsetPosition(i5, false);
                    }
                }
            }
        }

        void b() {
            int size = this.f1870c.size();
            for (int i = 0; i < size; i++) {
                this.f1870c.get(i).clearOldPosition();
            }
            int size2 = this.f1868a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.f1868a.get(i2).clearOldPosition();
            }
            ArrayList<w> arrayList = this.f1869b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.f1869b.get(i3).clearOldPosition();
                }
            }
        }

        private void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        void a(w wVar, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(wVar);
            View view = wVar.itemView;
            W w = RecyclerView.this.mAccessibilityDelegate;
            if (w != null) {
                C0313a c0313aB = w.b();
                ViewCompat.a(view, c0313aB instanceof W.a ? ((W.a) c0313aB).c(view) : null);
            }
            if (z) {
                a(wVar);
            }
            wVar.mOwnerRecyclerView = null;
            d().a(wVar);
        }

        void a(View view) {
            w childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.mScrapContainer = null;
            childViewHolderInt.mInChangeScrap = false;
            childViewHolderInt.clearReturnedFromScrapFlag();
            b(childViewHolderInt);
        }

        w a(int i, boolean z) {
            View viewB;
            int size = this.f1868a.size();
            for (int i2 = 0; i2 < size; i2++) {
                w wVar = this.f1868a.get(i2);
                if (!wVar.wasReturnedFromScrap() && wVar.getLayoutPosition() == i && !wVar.isInvalid() && (RecyclerView.this.mState.h || !wVar.isRemoved())) {
                    wVar.addFlags(32);
                    return wVar;
                }
            }
            if (!z && (viewB = RecyclerView.this.mChildHelper.b(i)) != null) {
                w childViewHolderInt = RecyclerView.getChildViewHolderInt(viewB);
                RecyclerView.this.mChildHelper.f(viewB);
                int iB = RecyclerView.this.mChildHelper.b(viewB);
                if (iB != -1) {
                    RecyclerView.this.mChildHelper.a(iB);
                    c(viewB);
                    childViewHolderInt.addFlags(8224);
                    return childViewHolderInt;
                }
                throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + childViewHolderInt + RecyclerView.this.exceptionLabel());
            }
            int size2 = this.f1870c.size();
            for (int i3 = 0; i3 < size2; i3++) {
                w wVar2 = this.f1870c.get(i3);
                if (!wVar2.isInvalid() && wVar2.getLayoutPosition() == i && !wVar2.isAttachedToTransitionOverlay()) {
                    if (!z) {
                        this.f1870c.remove(i3);
                    }
                    return wVar2;
                }
            }
            return null;
        }

        w a(long j, int i, boolean z) {
            for (int size = this.f1868a.size() - 1; size >= 0; size--) {
                w wVar = this.f1868a.get(size);
                if (wVar.getItemId() == j && !wVar.wasReturnedFromScrap()) {
                    if (i == wVar.getItemViewType()) {
                        wVar.addFlags(32);
                        if (wVar.isRemoved() && !RecyclerView.this.mState.d()) {
                            wVar.setFlags(2, 14);
                        }
                        return wVar;
                    }
                    if (!z) {
                        this.f1868a.remove(size);
                        RecyclerView.this.removeDetachedView(wVar.itemView, false);
                        a(wVar.itemView);
                    }
                }
            }
            int size2 = this.f1870c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                w wVar2 = this.f1870c.get(size2);
                if (wVar2.getItemId() == j && !wVar2.isAttachedToTransitionOverlay()) {
                    if (i == wVar2.getItemViewType()) {
                        if (!z) {
                            this.f1870c.remove(size2);
                        }
                        return wVar2;
                    }
                    if (!z) {
                        e(size2);
                        return null;
                    }
                }
            }
        }

        void a(w wVar) {
            p pVar = RecyclerView.this.mRecyclerListener;
            if (pVar != null) {
                pVar.a(wVar);
            }
            a aVar = RecyclerView.this.mAdapter;
            if (aVar != null) {
                aVar.onViewRecycled(wVar);
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mState != null) {
                recyclerView.mViewInfoStore.h(wVar);
            }
        }

        void a(a aVar, a aVar2, boolean z) {
            a();
            d().a(aVar, aVar2, z);
        }

        void a(int i, int i2) {
            int size = this.f1870c.size();
            for (int i3 = 0; i3 < size; i3++) {
                w wVar = this.f1870c.get(i3);
                if (wVar != null && wVar.mPosition >= i) {
                    wVar.offsetPosition(i2, true);
                }
            }
        }

        void a(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.f1870c.size() - 1; size >= 0; size--) {
                w wVar = this.f1870c.get(size);
                if (wVar != null) {
                    int i4 = wVar.mPosition;
                    if (i4 >= i3) {
                        wVar.offsetPosition(-i2, z);
                    } else if (i4 >= i) {
                        wVar.addFlags(8);
                        e(size);
                    }
                }
            }
        }

        void a(u uVar) {
            this.h = uVar;
        }

        void a(n nVar) {
            n nVar2 = this.g;
            if (nVar2 != null) {
                nVar2.c();
            }
            this.g = nVar;
            if (this.g == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.g.a();
        }
    }

    public interface p {
        void a(w wVar);
    }

    public static abstract class s {
        private i mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final a mRecyclingAction = new a(0, 0);

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f1876a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f1877b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f1878c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f1879d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Interpolator f1880e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private boolean f1881f;
            private int g;

            public a(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            private void b() {
                if (this.f1880e != null && this.f1878c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.f1878c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void a(int i) {
                this.f1879d = i;
            }

            public a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1879d = -1;
                this.f1881f = false;
                this.g = 0;
                this.f1876a = i;
                this.f1877b = i2;
                this.f1878c = i3;
                this.f1880e = interpolator;
            }

            boolean a() {
                return this.f1879d >= 0;
            }

            void a(RecyclerView recyclerView) {
                int i = this.f1879d;
                if (i >= 0) {
                    this.f1879d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f1881f = false;
                } else {
                    if (this.f1881f) {
                        b();
                        recyclerView.mViewFlinger.a(this.f1876a, this.f1877b, this.f1878c, this.f1880e);
                        this.g++;
                        if (this.g > 10) {
                            Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f1881f = false;
                        return;
                    }
                    this.g = 0;
                }
            }

            public void a(int i, int i2, int i3, Interpolator interpolator) {
                this.f1876a = i;
                this.f1877b = i2;
                this.f1878c = i3;
                this.f1880e = interpolator;
                this.f1881f = true;
            }
        }

        public interface b {
            PointF computeScrollVectorForPosition(int i);
        }

        public PointF computeScrollVectorForPosition(int i) {
            Object layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).computeScrollVectorForPosition(i);
            }
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public i getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        protected void normalize(PointF pointF) {
            float f2 = pointF.x;
            float f3 = pointF.y;
            float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        void onAnimation(int i, int i2) {
            PointF pointFComputeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (pointFComputeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (pointFComputeScrollVectorForPosition.x != WheelView.DividerConfig.FILL || pointFComputeScrollVectorForPosition.y != WheelView.DividerConfig.FILL)) {
                recyclerView.scrollStep((int) Math.signum(pointFComputeScrollVectorForPosition.x), (int) Math.signum(pointFComputeScrollVectorForPosition.y), null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.a(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                boolean zA = this.mRecyclingAction.a();
                this.mRecyclingAction.a(recyclerView);
                if (zA && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.a();
                }
            }
        }

        protected void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        protected abstract void onSeekTargetStep(int i, int i2, t tVar, a aVar);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View view, t tVar, a aVar);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        void start(RecyclerView recyclerView, i iVar) {
            recyclerView.mViewFlinger.b();
            if (this.mStarted) {
                Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = iVar;
            int i = this.mTargetPosition;
            if (i == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.mRecyclerView.mState.f1882a = i;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.a();
            this.mStarted = true;
        }

        protected final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f1882a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    public static abstract class u {
        public abstract View a(o oVar, int i, int i2);
    }

    public static abstract class w {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        int mFlags;
        WeakReference<RecyclerView> mNestedRecyclerView;
        RecyclerView mOwnerRecyclerView;
        int mPosition = -1;
        int mOldPosition = -1;
        long mItemId = -1;
        int mItemViewType = -1;
        int mPreLayoutPosition = -1;
        w mShadowedHolder = null;
        w mShadowingHolder = null;
        List<Object> mPayloads = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        o mScrapContainer = null;
        boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        int mPendingAccessibilityState = -1;

        public w(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.itemView = view;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                this.mPayloads = new ArrayList();
                this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
            }
        }

        void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ViewCompat.z(this.itemView);
        }

        void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ViewCompat.z(this.itemView);
        }

        boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        boolean isScrap() {
            return this.mScrapContainer != null;
        }

        boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f1845c = true;
            }
        }

        void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.k(this.itemView);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (i2 ^ (-1)));
        }

        public final void setIsRecyclable(boolean z) {
            this.mIsRecyclableCount = z ? this.mIsRecyclableCount - 1 : this.mIsRecyclableCount + 1;
            int i = this.mIsRecyclableCount;
            if (i < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z && i == 1) {
                this.mFlags |= 16;
            } else if (z && this.mIsRecyclableCount == 0) {
                this.mFlags &= -17;
            }
        }

        void setScrapContainer(o oVar, boolean z) {
            this.mScrapContainer = oVar;
            this.mInChangeScrap = z;
        }

        boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        void unScrap() {
            this.mScrapContainer.c(this);
        }

        boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = i2 == 18 || i2 == 19 || i2 == 20;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = Build.VERSION.SDK_INT >= 23;
        POST_UPDATES_ON_ANIMATION = Build.VERSION.SDK_INT >= 16;
        ALLOW_THREAD_GAP_WORK = Build.VERSION.SDK_INT >= 21;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = Build.VERSION.SDK_INT <= 15;
        IGNORE_DETACHED_FOCUSED_CHILD = Build.VERSION.SDK_INT <= 15;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new O();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(w wVar) {
        View view = wVar.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.c(getChildViewHolder(view));
        if (wVar.isTmpDetached()) {
            this.mChildHelper.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.mChildHelper.a(view);
        } else {
            this.mChildHelper.a(view, true);
        }
    }

    private void animateChange(w wVar, w wVar2, f.c cVar, f.c cVar2, boolean z, boolean z2) {
        wVar.setIsRecyclable(false);
        if (z) {
            addAnimatingView(wVar);
        }
        if (wVar != wVar2) {
            if (z2) {
                addAnimatingView(wVar2);
            }
            wVar.mShadowedHolder = wVar2;
            addAnimatingView(wVar);
            this.mRecycler.c(wVar);
            wVar2.setIsRecyclable(false);
            wVar2.mShadowingHolder = wVar;
        }
        if (this.mItemAnimator.a(wVar, wVar2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    static void clearNestedRecyclerViewIfNotNested(w wVar) {
        WeakReference<RecyclerView> weakReference = wVar.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == wVar.itemView) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            wVar.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Constructor constructor;
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, strTrim);
            try {
                Class<? extends U> clsAsSubclass = Class.forName(fullClassName, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(i.class);
                Object[] objArr = null;
                try {
                    constructor = clsAsSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                } catch (NoSuchMethodException e2) {
                    try {
                        constructor = clsAsSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e3) {
                        e3.initCause(e2);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((i) constructor.newInstance(objArr));
            } catch (ClassCastException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
            } catch (ClassNotFoundException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
            } catch (InstantiationException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
            }
        }
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
        accessibilityEventObtain.setEventType(DLog.CRS);
        androidx.core.view.accessibility.a.a(accessibilityEventObtain, i2);
        sendAccessibilityEventUnchecked(accessibilityEventObtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        t tVar = this.mState;
        tVar.i = tVar.k && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        t tVar2 = this.mState;
        tVar2.h = tVar2.l;
        tVar2.f1887f = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.k) {
            int iA = this.mChildHelper.a();
            for (int i2 = 0; i2 < iA; i2++) {
                w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.c(childViewHolderInt, this.mItemAnimator.a(this.mState, childViewHolderInt, f.a(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.i && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.a(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.l) {
            saveOldPositions();
            t tVar3 = this.mState;
            boolean z = tVar3.g;
            tVar3.g = false;
            this.mLayout.onLayoutChildren(this.mRecycler, tVar3);
            this.mState.g = z;
            for (int i3 = 0; i3 < this.mChildHelper.a(); i3++) {
                w childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.c(i3));
                if (!childViewHolderInt2.shouldIgnore() && !this.mViewInfoStore.c(childViewHolderInt2)) {
                    int iA2 = f.a(childViewHolderInt2);
                    boolean zHasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                    if (!zHasAnyOfTheFlags) {
                        iA2 |= 4096;
                    }
                    f.c cVarA = this.mItemAnimator.a(this.mState, childViewHolderInt2, iA2, childViewHolderInt2.getUnmodifiedPayloads());
                    if (zHasAnyOfTheFlags) {
                        recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, cVarA);
                    } else {
                        this.mViewInfoStore.a(childViewHolderInt2, cVarA);
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f1886e = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.b();
        this.mState.f1887f = this.mAdapter.getItemCount();
        t tVar = this.mState;
        tVar.f1885d = 0;
        tVar.h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, tVar);
        t tVar2 = this.mState;
        tVar2.g = false;
        this.mPendingSavedState = null;
        tVar2.k = tVar2.k && this.mItemAnimator != null;
        this.mState.f1886e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        t tVar = this.mState;
        tVar.f1886e = 1;
        if (tVar.k) {
            for (int iA = this.mChildHelper.a() - 1; iA >= 0; iA--) {
                w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(iA));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    f.c cVarA = this.mItemAnimator.a(this.mState, childViewHolderInt);
                    w wVarA = this.mViewInfoStore.a(changedHolderKey);
                    if (wVarA == null || wVarA.shouldIgnore()) {
                        this.mViewInfoStore.b(childViewHolderInt, cVarA);
                    } else {
                        boolean zB = this.mViewInfoStore.b(wVarA);
                        boolean zB2 = this.mViewInfoStore.b(childViewHolderInt);
                        if (zB && wVarA == childViewHolderInt) {
                            this.mViewInfoStore.b(childViewHolderInt, cVarA);
                        } else {
                            f.c cVarF = this.mViewInfoStore.f(wVarA);
                            this.mViewInfoStore.b(childViewHolderInt, cVarA);
                            f.c cVarE = this.mViewInfoStore.e(childViewHolderInt);
                            if (cVarF == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, wVarA);
                            } else {
                                animateChange(wVarA, childViewHolderInt, cVarF, cVarE, zB, zB2);
                            }
                        }
                    }
                }
            }
            this.mViewInfoStore.a(this.mViewInfoProcessCallback);
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        t tVar2 = this.mState;
        tVar2.f1884c = tVar2.f1887f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        tVar2.k = false;
        tVar2.l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<w> arrayList = this.mRecycler.f1869b;
        if (arrayList != null) {
            arrayList.clear();
        }
        i iVar = this.mLayout;
        if (iVar.mPrefetchMaxObservedInInitialPrefetch) {
            iVar.mPrefetchMaxCountObserved = 0;
            iVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.j();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        l lVar = this.mInterceptingOnItemTouchListener;
        if (lVar == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        lVar.onTouchEvent(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = this.mOnItemTouchListeners.get(i2);
            if (lVar.a(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = lVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int iA = this.mChildHelper.a();
        if (iA == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iA; i4++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewFindNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (recyclerViewFindNestedRecyclerView != null) {
                return recyclerViewFindNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        w wVarFindViewHolderForAdapterPosition;
        int i2 = this.mState.m;
        if (i2 == -1) {
            i2 = 0;
        }
        int iA = this.mState.a();
        for (int i3 = i2; i3 < iA; i3++) {
            w wVarFindViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (wVarFindViewHolderForAdapterPosition2 == null) {
                break;
            }
            if (wVarFindViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return wVarFindViewHolderForAdapterPosition2.itemView;
            }
        }
        int iMin = Math.min(iA, i2);
        do {
            iMin--;
            if (iMin < 0 || (wVarFindViewHolderForAdapterPosition = findViewHolderForAdapterPosition(iMin)) == null) {
                return null;
            }
        } while (!wVarFindViewHolderForAdapterPosition.itemView.hasFocusable());
        return wVarFindViewHolderForAdapterPosition.itemView;
    }

    static w getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f1843a;
    }

    static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f1844b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        }
        if (str.contains(Consts.DOT)) {
            return str;
        }
        return RecyclerView.class.getPackage().getName() + '.' + str;
    }

    private androidx.core.view.m getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new androidx.core.view.m(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j2, w wVar, w wVar2) {
        int iA = this.mChildHelper.a();
        for (int i2 = 0; i2 < iA; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i2));
            if (childViewHolderInt != wVar && getChangedHolderKey(childViewHolderInt) == j2) {
                a aVar = this.mAdapter;
                if (aVar == null || !aVar.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + wVar + exceptionLabel());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + childViewHolderInt + " \n View Holder 2:" + wVar + exceptionLabel());
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + wVar2 + " cannot be found but it is necessary for " + wVar + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int iA = this.mChildHelper.a();
        for (int i2 = 0; i2 < iA; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.c(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        if (ViewCompat.l(this) == 0) {
            ViewCompat.g(this, 8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new C0352b(new Q(this));
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        byte b2 = -1;
        int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i5 = rect.left;
        int i6 = this.mTempRect2.left;
        if ((i5 < i6 || rect.right <= i6) && this.mTempRect.right < this.mTempRect2.right) {
            i3 = 1;
        } else {
            Rect rect2 = this.mTempRect;
            int i7 = rect2.right;
            int i8 = this.mTempRect2.right;
            i3 = ((i7 > i8 || rect2.left >= i8) && this.mTempRect.left > this.mTempRect2.left) ? -1 : 0;
        }
        Rect rect3 = this.mTempRect;
        int i9 = rect3.top;
        int i10 = this.mTempRect2.top;
        if ((i9 < i10 || rect3.bottom <= i10) && this.mTempRect.bottom < this.mTempRect2.bottom) {
            b2 = 1;
        } else {
            Rect rect4 = this.mTempRect;
            int i11 = rect4.bottom;
            int i12 = this.mTempRect2.bottom;
            if ((i11 <= i12 && rect4.top < i12) || this.mTempRect.top <= this.mTempRect2.top) {
                b2 = 0;
            }
        }
        if (i2 == 1) {
            return b2 < 0 || (b2 == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return b2 > 0 || (b2 == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return b2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return b2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + exceptionLabel());
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout) {
            this.mAdapterHelper.f();
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.e();
        } else {
            this.mAdapterHelper.b();
        }
        boolean z = false;
        boolean z2 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.k = this.mFirstLayoutComplete && this.mItemAnimator != null && (this.mDataSetHasChangedAfterLayout || z2 || this.mLayout.mRequestedSimpleAnimations) && (!this.mDataSetHasChangedAfterLayout || this.mAdapter.hasStableIds());
        t tVar = this.mState;
        if (tVar.k && z2 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z = true;
        }
        tVar.l = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            androidx.core.widget.f.a(r3, r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            androidx.core.widget.f.a(r3, r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.f.a(r9, r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.f.a(r9, r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L7f
        L7c:
            androidx.core.view.ViewCompat.G(r6)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View viewFindViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                if (!this.mChildHelper.c(focusedChild)) {
                    return;
                }
            } else if (this.mChildHelper.a() == 0) {
                requestFocus();
                return;
            }
        }
        View viewFindNextViewToFocus = null;
        w wVarFindViewHolderForItemId = (this.mState.n == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.n);
        if (wVarFindViewHolderForItemId != null && !this.mChildHelper.c(wVarFindViewHolderForItemId.itemView) && wVarFindViewHolderForItemId.itemView.hasFocusable()) {
            viewFindNextViewToFocus = wVarFindViewHolderForItemId.itemView;
        } else if (this.mChildHelper.a() > 0) {
            viewFindNextViewToFocus = findNextViewToFocus();
        }
        if (viewFindNextViewToFocus != null) {
            int i2 = this.mState.o;
            if (i2 == -1 || (viewFindViewById = viewFindNextViewToFocus.findViewById(i2)) == null || !viewFindViewById.isFocusable()) {
                viewFindViewById = viewFindNextViewToFocus;
            }
            viewFindViewById.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.G(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f1845c) {
                Rect rect = layoutParams2.f1844b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        t tVar = this.mState;
        tVar.n = -1L;
        tVar.m = -1;
        tVar.o = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        w wVarFindContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (wVarFindContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.n = this.mAdapter.hasStableIds() ? wVarFindContainingViewHolder.getItemId() : -1L;
        this.mState.m = this.mDataSetHasChangedAfterLayout ? -1 : wVarFindContainingViewHolder.isRemoved() ? wVarFindContainingViewHolder.mOldPosition : wVarFindContainingViewHolder.getAdapterPosition();
        this.mState.o = getDeepestFocusedViewWithId(wVarFindContainingViewHolder.itemView);
    }

    private void setAdapterInternal(a aVar, boolean z, boolean z2) {
        a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        this.mAdapterHelper.f();
        a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mObserver);
            aVar.onAttachedToRecyclerView(this);
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onAdapterChanged(aVar3, this.mAdapter);
        }
        this.mRecycler.a(aVar3, this.mAdapter, z);
        this.mState.g = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.b();
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.stopSmoothScroller();
        }
    }

    void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        ViewCompat.G(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null || !iVar.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(h hVar, int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(hVar);
        } else {
            this.mItemDecorations.add(i2, hVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(j jVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(jVar);
    }

    public void addOnItemTouchListener(l lVar) {
        this.mOnItemTouchListeners.add(lVar);
    }

    public void addOnScrollListener(m mVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(mVar);
    }

    void animateAppearance(w wVar, f.c cVar, f.c cVar2) {
        wVar.setIsRecyclable(false);
        if (this.mItemAnimator.a(wVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void animateDisappearance(w wVar, f.c cVar, f.c cVar2) {
        addAnimatingView(wVar);
        wVar.setIsRecyclable(false);
        if (this.mItemAnimator.b(wVar, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        throw new IllegalStateException(str + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
        }
        if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        }
    }

    boolean canReuseUpdatedViewHolder(w wVar) {
        f fVar = this.mItemAnimator;
        return fVar == null || fVar.a(wVar, wVar.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    void clearOldPositions() {
        int iB = this.mChildHelper.b();
        for (int i2 = 0; i2 < iB; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        this.mRecycler.b();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<j> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<m> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        i iVar = this.mLayout;
        if (iVar != null && iVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.mLeftGlow.onRelease();
            zIsFinished = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            zIsFinished |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            zIsFinished |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            zIsFinished |= this.mBottomGlow.isFinished();
        }
        if (zIsFinished) {
            ViewCompat.G(this);
        }
    }

    void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            androidx.core.os.c.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            androidx.core.os.c.a();
            return;
        }
        if (this.mAdapterHelper.c()) {
            if (!this.mAdapterHelper.c(4) || this.mAdapterHelper.c(11)) {
                if (this.mAdapterHelper.c()) {
                    androidx.core.os.c.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    androidx.core.os.c.a();
                    return;
                }
                return;
            }
            androidx.core.os.c.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            this.mAdapterHelper.e();
            if (!this.mLayoutWasDefered) {
                if (hasUpdatedView()) {
                    dispatchLayout();
                } else {
                    this.mAdapterHelper.a();
                }
            }
            stopInterceptRequestLayout(true);
            onExitLayoutOrScroll();
            androidx.core.os.c.a();
        }
    }

    void defaultOnMeasure(int i2, int i3) {
        setMeasuredDimension(i.chooseSize(i2, getPaddingLeft() + getPaddingRight(), ViewCompat.o(this)), i.chooseSize(i3, getPaddingTop() + getPaddingBottom(), ViewCompat.n(this)));
    }

    void dispatchChildAttached(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewAttachedToWindow(childViewHolderInt);
        }
        List<j> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    void dispatchChildDetached(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        a aVar = this.mAdapter;
        if (aVar != null && childViewHolderInt != null) {
            aVar.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<j> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).a(view);
            }
        }
    }

    void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
            return;
        }
        if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
            return;
        }
        t tVar = this.mState;
        tVar.j = false;
        if (tVar.f1886e == 1) {
            dispatchLayoutStep1();
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        } else if (!this.mAdapterHelper.d() && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
            this.mLayout.setExactMeasureSpecsFrom(this);
        } else {
            this.mLayout.setExactMeasureSpecsFrom(this);
            dispatchLayoutStep2();
        }
        dispatchLayoutStep3();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return getScrollingChildHelper().a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    void dispatchOnScrollStateChanged(int i2) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        m mVar = this.mScrollListener;
        if (mVar != null) {
            mVar.onScrollStateChanged(this, i2);
        }
        List<m> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        m mVar = this.mScrollListener;
        if (mVar != null) {
            mVar.onScrolled(this, i2, i3);
        }
        List<m> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            w wVar = this.mPendingAccessibilityImportanceChange.get(size);
            if (wVar.itemView.getParent() == this && !wVar.shouldIgnore() && (i2 = wVar.mPendingAccessibilityState) != -1) {
                ViewCompat.f(wVar.itemView, i2);
                wVar.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, WheelView.DividerConfig.FILL);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z2 = z;
        } else {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 = z3 | z;
            canvas.restoreToCount(iSave4);
        }
        if (!z2 && this.mItemAnimator != null && this.mItemDecorations.size() > 0 && this.mItemAnimator.g()) {
            z2 = true;
        }
        if (z2) {
            ViewCompat.G(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        this.mBottomGlow = this.mEdgeEffectFactory.a(this, 3);
        if (this.mClipToPadding) {
            this.mBottomGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        this.mLeftGlow = this.mEdgeEffectFactory.a(this, 0);
        if (this.mClipToPadding) {
            this.mLeftGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        this.mRightGlow = this.mEdgeEffectFactory.a(this, 2);
        if (this.mClipToPadding) {
            this.mRightGlow.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        this.mTopGlow = this.mEdgeEffectFactory.a(this, 1);
        if (this.mClipToPadding) {
            this.mTopGlow.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    final void fillRemainingScrollValues(t tVar) {
        if (getScrollState() != 2) {
            tVar.p = 0;
            tVar.q = 0;
        } else {
            OverScroller overScroller = this.mViewFlinger.f1890c;
            tVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            tVar.q = overScroller.getFinalY() - overScroller.getCurrY();
        }
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int iA = this.mChildHelper.a() - 1; iA >= 0; iA--) {
            View viewC = this.mChildHelper.c(iA);
            float translationX = viewC.getTranslationX();
            float translationY = viewC.getTranslationY();
            if (f2 >= viewC.getLeft() + translationX && f2 <= viewC.getRight() + translationX && f3 >= viewC.getTop() + translationY && f3 <= viewC.getBottom() + translationY) {
                return viewC;
            }
        }
        return null;
    }

    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public w findContainingViewHolder(View view) {
        View viewFindContainingItemView = findContainingItemView(view);
        if (viewFindContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(viewFindContainingItemView);
    }

    public w findViewHolderForAdapterPosition(int i2) {
        w wVar = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int iB = this.mChildHelper.b();
        for (int i3 = 0; i3 < iB; i3++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i2) {
                if (!this.mChildHelper.c(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                wVar = childViewHolderInt;
            }
        }
        return wVar;
    }

    public w findViewHolderForItemId(long j2) {
        a aVar = this.mAdapter;
        w wVar = null;
        if (aVar != null && aVar.hasStableIds()) {
            int iB = this.mChildHelper.b();
            for (int i2 = 0; i2 < iB; i2++) {
                w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.c(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    wVar = childViewHolderInt;
                }
            }
        }
        return wVar;
    }

    public w findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    @Deprecated
    public w findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    public boolean fling(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.mLayoutSuppressed) {
            return false;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (!zCanScrollHorizontally || Math.abs(i2) < this.mMinFlingVelocity) {
            i2 = 0;
        }
        if (!zCanScrollVertically || Math.abs(i3) < this.mMinFlingVelocity) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f2 = i2;
        float f3 = i3;
        if (!dispatchNestedPreFling(f2, f3)) {
            boolean z = zCanScrollHorizontally || zCanScrollVertically;
            dispatchNestedFling(f2, f3, z);
            k kVar = this.mOnFlingListener;
            if (kVar != null && kVar.a(i2, i3)) {
                return true;
            }
            if (z) {
                int i4 = zCanScrollHorizontally ? 1 : 0;
                if (zCanScrollVertically) {
                    i4 |= 2;
                }
                startNestedScroll(i4, 1);
                int i5 = this.mMaxFlingVelocity;
                int iMax = Math.max(-i5, Math.min(i2, i5));
                int i6 = this.mMaxFlingVelocity;
                this.mViewFlinger.a(iMax, Math.max(-i6, Math.min(i3, i6)));
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewOnFocusSearchFailed;
        boolean z;
        View viewOnInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
        if (viewOnInterceptFocusSearch != null) {
            return viewOnInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i2 == 2 || i2 == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i3 = i2 == 2 ? 130 : 33;
                z = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i4 = (this.mLayout.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                z = focusFinder.findNextFocus(this, view, i4) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            viewOnFocusSearchFailed = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                viewOnFocusSearchFailed = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                viewOnFocusSearchFailed = viewFindNextFocus;
            }
        }
        if (viewOnFocusSearchFailed == null || viewOnFocusSearchFailed.hasFocusable()) {
            return isPreferredNextFocus(view, viewOnFocusSearchFailed, i2) ? viewOnFocusSearchFailed : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        requestChildOnScreen(viewOnFocusSearchFailed, null);
        return view;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.generateDefaultLayoutParams();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    int getAdapterPositionFor(w wVar) {
        if (wVar.hasAnyOfTheFlags(524) || !wVar.isBound()) {
            return -1;
        }
        return this.mAdapterHelper.a(wVar.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        i iVar = this.mLayout;
        return iVar != null ? iVar.getBaseline() : super.getBaseline();
    }

    long getChangedHolderKey(w wVar) {
        return this.mAdapter.hasStableIds() ? wVar.getItemId() : wVar.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i2, int i3) {
        d dVar = this.mChildDrawingOrderCallback;
        return dVar == null ? super.getChildDrawingOrder(i2, i3) : dVar.a(i2, i3);
    }

    public long getChildItemId(View view) {
        w childViewHolderInt;
        a aVar = this.mAdapter;
        if (aVar == null || !aVar.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public w getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public W getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public e getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public f getItemAnimator() {
        return this.mItemAnimator;
    }

    Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f1845c) {
            return layoutParams.f1844b;
        }
        if (this.mState.d() && (layoutParams.b() || layoutParams.e())) {
            return layoutParams.f1844b;
        }
        Rect rect = layoutParams.f1844b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i3 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f1845c = false;
        return rect;
    }

    public h getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public i getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public k getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public n getRecycledViewPool() {
        return this.mRecycler.d();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().a();
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.c();
    }

    void initAdapterManager() {
        this.mAdapterHelper = new C0351a(new S(this));
    }

    void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new C0366p(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(androidx.recyclerview.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(androidx.recyclerview.R.dimen.fastscroll_margin));
        } else {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
        }
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        f fVar = this.mItemAnimator;
        return fVar != null && fVar.g();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.l
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().b();
    }

    void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i2);
        awakenScrollBars();
    }

    void markItemDecorInsetsDirty() {
        int iB = this.mChildHelper.b();
        for (int i2 = 0; i2 < iB; i2++) {
            ((LayoutParams) this.mChildHelper.d(i2).getLayoutParams()).f1845c = true;
        }
        this.mRecycler.g();
    }

    void markKnownViewsInvalid() {
        int iB = this.mChildHelper.b();
        for (int i2 = 0; i2 < iB; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        this.mRecycler.h();
    }

    public void offsetChildrenHorizontal(int i2) {
        int iA = this.mChildHelper.a();
        for (int i3 = 0; i3 < iA; i3++) {
            this.mChildHelper.c(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int iA = this.mChildHelper.a();
        for (int i3 = 0; i3 < iA; i3++) {
            this.mChildHelper.c(i3).offsetTopAndBottom(i2);
        }
    }

    void offsetPositionRecordsForInsert(int i2, int i3) {
        int iB = this.mChildHelper.b();
        for (int i4 = 0; i4 < iB; i4++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.g = true;
            }
        }
        this.mRecycler.a(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iB = this.mChildHelper.b();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i8 = 0; i8 < iB; i8++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i8));
            if (childViewHolderInt != null && (i7 = childViewHolderInt.mPosition) >= i5 && i7 <= i4) {
                if (i7 == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i6, false);
                }
                this.mState.g = true;
            }
        }
        this.mRecycler.b(i2, i3);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int i2, int i3, boolean z) {
        int i4 = i2 + i3;
        int iB = this.mChildHelper.b();
        for (int i5 = 0; i5 < iB; i5++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z);
                    this.mState.g = true;
                } else if (i6 >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z);
                    this.mState.g = true;
                }
            }
        }
        this.mRecycler.a(i2, i3, z);
        requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.mLayoutOrScrollCounter = r0
            r1 = 1
            r4.mIsAttached = r1
            boolean r2 = r4.mFirstLayoutComplete
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = 0
        L15:
            r4.mFirstLayoutComplete = r1
            androidx.recyclerview.widget.RecyclerView$i r1 = r4.mLayout
            if (r1 == 0) goto L1e
            r1.dispatchAttachedToWindow(r4)
        L1e:
            r4.mPostedAnimatorRunner = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.ALLOW_THREAD_GAP_WORK
            if (r0 == 0) goto L67
            java.lang.ThreadLocal<androidx.recyclerview.widget.r> r0 = androidx.recyclerview.widget.r.f2022a
            java.lang.Object r0 = r0.get()
            androidx.recyclerview.widget.r r0 = (androidx.recyclerview.widget.r) r0
            r4.mGapWorker = r0
            androidx.recyclerview.widget.r r0 = r4.mGapWorker
            if (r0 != 0) goto L62
            androidx.recyclerview.widget.r r0 = new androidx.recyclerview.widget.r
            r0.<init>()
            r4.mGapWorker = r0
            android.view.Display r0 = androidx.core.view.ViewCompat.h(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L54
        L52:
            r0 = 1114636288(0x42700000, float:60.0)
        L54:
            androidx.recyclerview.widget.r r1 = r4.mGapWorker
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.f2026e = r2
            java.lang.ThreadLocal<androidx.recyclerview.widget.r> r0 = androidx.recyclerview.widget.r.f2022a
            r0.set(r1)
        L62:
            androidx.recyclerview.widget.r r0 = r4.mGapWorker
            r0.a(r4)
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        androidx.recyclerview.widget.r rVar;
        super.onDetachedFromWindow();
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.b();
        }
        stopScroll();
        this.mIsAttached = false;
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.b();
        if (!ALLOW_THREAD_GAP_WORK || (rVar = this.mGapWorker) == null) {
            return;
        }
        rVar.b(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).onDraw(canvas, this, this.mState);
        }
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$i r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$i r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            return false;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zCanScrollHorizontally ? 1 : 0;
            if (zCanScrollVertically) {
                i2 |= 2;
            }
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (iFindPointerIndex < 0) {
                Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x2 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i3 = x2 - this.mInitialTouchX;
                int i4 = y2 - this.mInitialTouchY;
                if (!zCanScrollHorizontally || Math.abs(i3) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (zCanScrollVertically && Math.abs(i4) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        androidx.core.os.c.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.c.a();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z = false;
        if (iVar.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.f1886e == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i2, i3);
            this.mState.j = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), FileTypeUtils.GIGABYTE));
                this.mState.j = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                return;
            }
            return;
        }
        if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            return;
        }
        if (this.mAdapterUpdateDuringMeasure) {
            startInterceptRequestLayout();
            onEnterLayoutOrScroll();
            processAdapterUpdatesAndSetAnimationFlags();
            onExitLayoutOrScroll();
            t tVar = this.mState;
            if (tVar.l) {
                tVar.h = true;
            } else {
                this.mAdapterHelper.b();
                this.mState.h = false;
            }
            this.mAdapterUpdateDuringMeasure = false;
            stopInterceptRequestLayout(false);
        } else if (this.mState.l) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        a aVar = this.mAdapter;
        if (aVar != null) {
            this.mState.f1887f = aVar.getItemCount();
        } else {
            this.mState.f1887f = 0;
        }
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        stopInterceptRequestLayout(false);
        this.mState.h = false;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof r)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.mPendingSavedState = (r) parcelable;
        super.onRestoreInstanceState(this.mPendingSavedState.a());
        i iVar = this.mLayout;
        if (iVar == null || (parcelable2 = this.mPendingSavedState.f1875c) == null) {
            return;
        }
        iVar.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        r rVar = new r(super.onSaveInstanceState());
        r rVar2 = this.mPendingSavedState;
        if (rVar2 != null) {
            rVar.a(rVar2);
        } else {
            i iVar = this.mLayout;
            if (iVar != null) {
                rVar.f1875c = iVar.onSaveInstanceState();
            } else {
                rVar.f1875c = null;
            }
        }
        return rVar;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00df A[PHI: r0
      0x00df: PHI (r0v42 int) = (r0v31 int), (r0v46 int) binds: [B:41:0x00c8, B:45:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        ViewCompat.a(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
    }

    void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void recordAnimationInfoIfBouncedHiddenView(w wVar, f.c cVar) {
        wVar.setFlags(0, 8192);
        if (this.mState.i && wVar.isUpdated() && !wVar.isRemoved() && !wVar.shouldIgnore()) {
            this.mViewInfoStore.a(getChangedHolderKey(wVar), wVar);
        }
        this.mViewInfoStore.c(wVar, cVar);
    }

    void removeAndRecycleViews() {
        f fVar = this.mItemAnimator;
        if (fVar != null) {
            fVar.b();
        }
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.a();
    }

    boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        boolean zE = this.mChildHelper.e(view);
        if (zE) {
            w childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.c(childViewHolderInt);
            this.mRecycler.b(childViewHolderInt);
        }
        stopInterceptRequestLayout(!zE);
        return zE;
    }

    @Override // android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        w childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + childViewHolderInt + exceptionLabel());
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(h hVar) {
        i iVar = this.mLayout;
        if (iVar != null) {
            iVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(hVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i2));
            return;
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(j jVar) {
        List<j> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(jVar);
    }

    public void removeOnItemTouchListener(l lVar) {
        this.mOnItemTouchListeners.remove(lVar);
        if (this.mInterceptingOnItemTouchListener == lVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(m mVar) {
        List<m> list = this.mScrollListeners;
        if (list != null) {
            list.remove(mVar);
        }
    }

    void repositionShadowingViews() {
        w wVar;
        int iA = this.mChildHelper.a();
        for (int i2 = 0; i2 < iA; i2++) {
            View viewC = this.mChildHelper.c(i2);
            w childViewHolder = getChildViewHolder(viewC);
            if (childViewHolder != null && (wVar = childViewHolder.mShadowingHolder) != null) {
                View view = wVar.itemView;
                int left = viewC.getLeft();
                int top = viewC.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    void saveOldPositions() {
        int iB = this.mChildHelper.b();
        for (int i2 = 0; i2 < iB; i2++) {
            w childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        boolean zCanScrollHorizontally = iVar.canScrollHorizontally();
        boolean zCanScrollVertically = this.mLayout.canScrollVertically();
        if (zCanScrollHorizontally || zCanScrollVertically) {
            if (!zCanScrollHorizontally) {
                i2 = 0;
            }
            if (!zCanScrollVertically) {
                i3 = 0;
            }
            scrollByInternal(i2, i3, null);
        }
    }

    boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i8 = iArr2[0];
            int i9 = iArr2[1];
            i5 = i9;
            i4 = i8;
            i6 = i2 - i8;
            i7 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        int i10 = i4;
        dispatchNestedScroll(i4, i5, i6, i7, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i11 = i6 - iArr4[0];
        int i12 = i7 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i13 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i13 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null && !C0321i.a(motionEvent, m.a.p)) {
                pullGlows(motionEvent.getX(), i11, motionEvent.getY(), i12);
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (i10 != 0 || i5 != 0) {
            dispatchOnScrolled(i10, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i10 == 0 && i5 == 0) ? false : true;
    }

    void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.c.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int iScrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
        int iScrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
        androidx.core.os.c.a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = iScrollHorizontallyBy;
            iArr[1] = iScrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(W w2) {
        this.mAccessibilityDelegate = w2;
        ViewCompat.a(this, this.mAccessibilityDelegate);
    }

    public void setAdapter(a aVar) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d dVar) {
        if (dVar == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = dVar;
        setChildrenDrawingOrderEnabled(this.mChildDrawingOrderCallback != null);
    }

    boolean setChildImportantForAccessibilityInternal(w wVar, int i2) {
        if (!isComputingLayout()) {
            ViewCompat.f(wVar.itemView, i2);
            return true;
        }
        wVar.mPendingAccessibilityState = i2;
        this.mPendingAccessibilityImportanceChange.add(wVar);
        return false;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(e eVar) {
        androidx.core.f.h.a(eVar);
        this.mEdgeEffectFactory = eVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(f fVar) {
        f fVar2 = this.mItemAnimator;
        if (fVar2 != null) {
            fVar2.b();
            this.mItemAnimator.a((f.b) null);
        }
        this.mItemAnimator = fVar;
        f fVar3 = this.mItemAnimator;
        if (fVar3 != null) {
            fVar3.a(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.mRecycler.f(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(i iVar) {
        if (iVar == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            f fVar = this.mItemAnimator;
            if (fVar != null) {
                fVar.b();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.a();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.a();
        }
        this.mChildHelper.c();
        this.mLayout = iVar;
        if (iVar != null) {
            if (iVar.mRecyclerView != null) {
                throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.mRecyclerView.exceptionLabel());
            }
            this.mLayout.setRecyclerView(this);
            if (this.mIsAttached) {
                this.mLayout.dispatchAttachedToWindow(this);
            }
        }
        this.mRecycler.j();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public void setOnFlingListener(k kVar) {
        this.mOnFlingListener = kVar;
    }

    @Deprecated
    public void setOnScrollListener(m mVar) {
        this.mScrollListener = mVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(n nVar) {
        this.mRecycler.a(nVar);
    }

    public void setRecyclerListener(p pVar) {
        this.mRecyclerListener = pVar;
    }

    void setScrollState(int i2) {
        if (i2 == this.mScrollState) {
            return;
        }
        this.mScrollState = i2;
        if (i2 != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 == 1) {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(u uVar) {
        this.mRecycler.a(uVar);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (!isComputingLayout()) {
            return false;
        }
        int iA = accessibilityEvent != null ? androidx.core.view.accessibility.a.a(accessibilityEvent) : 0;
        if (iA == 0) {
            iA = 0;
        }
        this.mEatenAccessibilityChangeFlags = iA | this.mEatenAccessibilityChangeFlags;
        return true;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollToPosition(int i2) {
        if (this.mLayoutSuppressed) {
            return;
        }
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.smoothScrollToPosition(this, this.mState, i2);
        }
    }

    void startInterceptRequestLayout() {
        this.mInterceptRequestLayoutDepth++;
        if (this.mInterceptRequestLayoutDepth != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.l
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0));
                this.mLayoutSuppressed = true;
                this.mIgnoreMotionEventTillDown = true;
                stopScroll();
                return;
            }
            this.mLayoutSuppressed = false;
            if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                requestLayout();
            }
            this.mLayoutWasDefered = false;
        }
    }

    public void swapAdapter(a aVar, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(aVar, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int iB = this.mChildHelper.b();
        int i5 = i2 + i3;
        for (int i6 = 0; i6 < iB; i6++) {
            View viewD = this.mChildHelper.d(i6);
            w childViewHolderInt = getChildViewHolderInt(viewD);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i2 && i4 < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) viewD.getLayoutParams()).f1845c = true;
            }
        }
        this.mRecycler.c(i2, i3);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.recyclerview.R.attr.recyclerViewStyle);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.recyclerview.widget.RecyclerView.w findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.b r0 = r5.mChildHelper
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            androidx.recyclerview.widget.b r3 = r5.mChildHelper
            android.view.View r3 = r3.d(r2)
            androidx.recyclerview.widget.RecyclerView$w r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            androidx.recyclerview.widget.b r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.c(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$w");
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().a(i2);
    }

    void onExitLayoutOrScroll(boolean z) {
        this.mLayoutOrScrollCounter--;
        if (this.mLayoutOrScrollCounter < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    @Override // androidx.core.view.InterfaceC0322j
    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<a> f1862a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1863b = 0;

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ArrayList<w> f1864a = new ArrayList<>();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f1865b = 5;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f1866c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f1867d = 0;

            a() {
            }
        }

        public w a(int i) {
            a aVar = this.f1862a.get(i);
            if (aVar == null || aVar.f1864a.isEmpty()) {
                return null;
            }
            ArrayList<w> arrayList = aVar.f1864a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public void b() {
            for (int i = 0; i < this.f1862a.size(); i++) {
                this.f1862a.valueAt(i).f1864a.clear();
            }
        }

        void c() {
            this.f1863b--;
        }

        void b(int i, long j) {
            a aVarB = b(i);
            aVarB.f1866c = a(aVarB.f1866c, j);
        }

        boolean b(int i, long j, long j2) {
            long j3 = b(i).f1866c;
            return j3 == 0 || j + j3 < j2;
        }

        private a b(int i) {
            a aVar = this.f1862a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f1862a.put(i, aVar2);
            return aVar2;
        }

        public void a(w wVar) {
            int itemViewType = wVar.getItemViewType();
            ArrayList<w> arrayList = b(itemViewType).f1864a;
            if (this.f1862a.get(itemViewType).f1865b <= arrayList.size()) {
                return;
            }
            wVar.resetInternal();
            arrayList.add(wVar);
        }

        long a(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        void a(int i, long j) {
            a aVarB = b(i);
            aVarB.f1867d = a(aVarB.f1867d, j);
        }

        boolean a(int i, long j, long j2) {
            long j3 = b(i).f1867d;
            return j3 == 0 || j + j3 < j2;
        }

        void a() {
            this.f1863b++;
        }

        void a(a aVar, a aVar2, boolean z) {
            if (aVar != null) {
                c();
            }
            if (!z && this.f1863b == 0) {
                b();
            }
            if (aVar2 != null) {
                a();
            }
        }
    }

    private class q extends c {
        q() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.g = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.c()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void b(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.b(i, i2)) {
                b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void c(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.c(i, i2)) {
                b();
            }
        }

        void b() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    ViewCompat.a(recyclerView, recyclerView.mUpdateChildViewsRunnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.a(i, i2, obj)) {
                b();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public void a(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            if (RecyclerView.this.mAdapterHelper.a(i, i2, i3)) {
                b();
            }
        }
    }

    class v implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f1889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        OverScroller f1890c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Interpolator f1891d = RecyclerView.sQuinticInterpolator;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f1892e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f1893f = false;

        v() {
            this.f1890c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            ViewCompat.a(RecyclerView.this, this);
        }

        void a() {
            if (this.f1892e) {
                this.f1893f = true;
            } else {
                c();
            }
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f1890c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                b();
                return;
            }
            this.f1893f = false;
            this.f1892e = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f1890c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f1888a;
                int i4 = currY - this.f1889b;
                this.f1888a = currX;
                this.f1889b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    s sVar = recyclerView4.mLayout.mSmoothScroller;
                    if (sVar != null && !sVar.isPendingInitialRun() && sVar.isRunning()) {
                        int iA = RecyclerView.this.mState.a();
                        if (iA == 0) {
                            sVar.stop();
                        } else if (sVar.getTargetPosition() >= iA) {
                            sVar.setTargetPosition(iA - 1);
                            sVar.onAnimation(i2, i);
                        } else {
                            sVar.onAnimation(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i, i3, i4, null, 1, iArr5);
                int[] iArr6 = RecyclerView.this.mReusableIntPair;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    RecyclerView.this.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                s sVar2 = RecyclerView.this.mLayout.mSmoothScroller;
                if ((sVar2 != null && sVar2.isPendingInitialRun()) || !z) {
                    a();
                    RecyclerView recyclerView6 = RecyclerView.this;
                    androidx.recyclerview.widget.r rVar = recyclerView6.mGapWorker;
                    if (rVar != null) {
                        rVar.a(recyclerView6, i2, i);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RecyclerView.this.mPrefetchRegistry.a();
                    }
                }
            }
            s sVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (sVar3 != null && sVar3.isPendingInitialRun()) {
                sVar3.onAnimation(0, 0);
            }
            this.f1892e = false;
            if (this.f1893f) {
                c();
            } else {
                RecyclerView.this.setScrollState(0);
                RecyclerView.this.stopNestedScroll(1);
            }
        }

        public void a(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.f1889b = 0;
            this.f1888a = 0;
            Interpolator interpolator = this.f1891d;
            Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
            if (interpolator != interpolator2) {
                this.f1891d = interpolator2;
                this.f1890c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
            }
            this.f1890c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                i3 = a(i, i2, 0, 0);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f1891d != interpolator) {
                this.f1891d = interpolator;
                this.f1890c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f1889b = 0;
            this.f1888a = 0;
            RecyclerView.this.setScrollState(2);
            this.f1890c.startScroll(0, 0, i, i2, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.f1890c.computeScrollOffset();
            }
            a();
        }

        private float a(float f2) {
            return (float) Math.sin((f2 - 0.5f) * 0.47123894f);
        }

        private int a(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            int width = z ? RecyclerView.this.getWidth() : RecyclerView.this.getHeight();
            int i5 = width / 2;
            float f2 = width;
            float f3 = i5;
            float fA = f3 + (a(Math.min(1.0f, (iSqrt2 * 1.0f) / f2)) * f3);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fA / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f2) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mObserver = new q();
        this.mRecycler = new o();
        this.mViewInfoStore = new ga();
        this.mUpdateChildViewsRunnable = new M(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new e();
        this.mItemAnimator = new C0361k();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean z = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new v();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new r.a() : null;
        this.mState = new t();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new g();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new N(this);
        this.mViewInfoProcessCallback = new P(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.view.A.a(viewConfiguration, context);
        this.mScaledVerticalScrollFactor = androidx.core.view.A.b(viewConfiguration, context);
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.k(this) == 0) {
            ViewCompat.f(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new W(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.recyclerview.R.styleable.RecyclerView, i2, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, androidx.recyclerview.R.styleable.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i2, 0);
        }
        String string = typedArrayObtainStyledAttributes.getString(androidx.recyclerview.R.styleable.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(androidx.recyclerview.R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_android_clipToPadding, true);
        this.mEnableFastScroller = typedArrayObtainStyledAttributes.getBoolean(androidx.recyclerview.R.styleable.RecyclerView_fastScrollEnabled, false);
        if (this.mEnableFastScroller) {
            initFastScroller((StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), typedArrayObtainStyledAttributes.getDrawable(androidx.recyclerview.R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        typedArrayObtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, NESTED_SCROLLING_ATTRS, i2, 0);
            if (Build.VERSION.SDK_INT >= 29) {
                saveAttributeDataForStyleable(context, NESTED_SCROLLING_ATTRS, attributeSet, typedArrayObtainStyledAttributes2, i2, 0);
            }
            z = typedArrayObtainStyledAttributes2.getBoolean(0, true);
            typedArrayObtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z);
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        w f1843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Rect f1844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f1845c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f1846d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1844b = new Rect();
            this.f1845c = true;
            this.f1846d = false;
        }

        public int a() {
            return this.f1843a.getLayoutPosition();
        }

        public boolean b() {
            return this.f1843a.isUpdated();
        }

        public boolean c() {
            return this.f1843a.isRemoved();
        }

        public boolean e() {
            return this.f1843a.isInvalid();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f1844b = new Rect();
            this.f1845c = true;
            this.f1846d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1844b = new Rect();
            this.f1845c = true;
            this.f1846d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1844b = new Rect();
            this.f1845c = true;
            this.f1846d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f1844b = new Rect();
            this.f1845c = true;
            this.f1846d = false;
        }
    }

    public static class r extends androidx.customview.a.c {
        public static final Parcelable.Creator<r> CREATOR = new V();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f1875c;

        r(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1875c = parcel.readParcelable(classLoader == null ? i.class.getClassLoader() : classLoader);
        }

        void a(r rVar) {
            this.f1875c = rVar.f1875c;
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f1875c, 0);
        }

        r(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SparseArray<Object> f1883b;
        int m;
        long n;
        int o;
        int p;
        int q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1882a = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1884c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1885d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f1886e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1887f = 0;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = false;
        boolean l = false;

        void a(int i) {
            if ((this.f1886e & i) != 0) {
                return;
            }
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.f1886e));
        }

        public int b() {
            return this.f1882a;
        }

        public boolean c() {
            return this.f1882a != -1;
        }

        public boolean d() {
            return this.h;
        }

        public boolean e() {
            return this.l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f1882a + ", mData=" + this.f1883b + ", mItemCount=" + this.f1887f + ", mIsMeasuring=" + this.j + ", mPreviousLayoutItemCount=" + this.f1884c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f1885d + ", mStructureChanged=" + this.g + ", mInPreLayout=" + this.h + ", mRunSimpleAnimations=" + this.k + ", mRunPredictiveAnimations=" + this.l + '}';
        }

        void a(a aVar) {
            this.f1886e = 1;
            this.f1887f = aVar.getItemCount();
            this.h = false;
            this.i = false;
            this.j = false;
        }

        public int a() {
            return this.h ? this.f1884c - this.f1885d : this.f1887f;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.mLayout;
        if (iVar != null) {
            return iVar.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z) {
        i iVar = this.mLayout;
        if (iVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.mLayoutSuppressed) {
            return;
        }
        if (!iVar.canScrollHorizontally()) {
            i2 = 0;
        }
        if (!this.mLayout.canScrollVertically()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (i4 == Integer.MIN_VALUE || i4 > 0) {
            if (z) {
                int i5 = i2 != 0 ? 1 : 0;
                if (i3 != 0) {
                    i5 |= 2;
                }
                startNestedScroll(i5, 1);
            }
            this.mViewFlinger.a(i2, i3, i4, interpolator);
            return;
        }
        scrollBy(i2, i3);
    }

    public void addItemDecoration(h hVar) {
        addItemDecoration(hVar, -1);
    }
}
