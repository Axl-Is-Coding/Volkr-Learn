package androidx.viewpager2.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.b;
import androidx.recyclerview.widget.L;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.rong.common.dlog.DLog;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public static final int OFFSCREEN_PAGE_LIMIT_DEFAULT = -1;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static boolean sFeatureEnhancedA11yEnabled = true;
    a mAccessibilityProvider;
    int mCurrentItem;
    private RecyclerView.c mCurrentItemDataSetChangeObserver;
    boolean mCurrentItemDirty;
    private CompositeOnPageChangeCallback mExternalPageChangeCallbacks;
    private androidx.viewpager2.widget.c mFakeDragger;
    private LinearLayoutManager mLayoutManager;
    private int mOffscreenPageLimit;
    private CompositeOnPageChangeCallback mPageChangeEventDispatcher;
    private androidx.viewpager2.widget.d mPageTransformerAdapter;
    private L mPagerSnapHelper;
    private Parcelable mPendingAdapterState;
    private int mPendingCurrentItem;
    RecyclerView mRecyclerView;
    private RecyclerView.f mSavedItemAnimator;
    private boolean mSavedItemAnimatorPresent;
    ScrollEventAdapter mScrollEventAdapter;
    private final Rect mTmpChildRect;
    private final Rect mTmpContainerRect;
    private boolean mUserInputEnabled;

    /* JADX INFO: Access modifiers changed from: private */
    abstract class a {
        private a() {
        }

        void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        void a(androidx.core.view.accessibility.b bVar) {
        }

        void a(RecyclerView.a<?> aVar) {
        }

        void a(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
        }

        boolean a() {
            return false;
        }

        boolean a(int i) {
            return false;
        }

        boolean a(int i, Bundle bundle) {
            return false;
        }

        void b(RecyclerView.a<?> aVar) {
        }

        boolean b() {
            return false;
        }

        boolean b(int i, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }

        String c() {
            throw new IllegalStateException("Not implemented.");
        }

        void d() {
        }

        CharSequence e() {
            throw new IllegalStateException("Not implemented.");
        }

        void f() {
        }

        void g() {
        }

        void h() {
        }

        void i() {
        }

        void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        }

        /* synthetic */ a(ViewPager2 viewPager2, androidx.viewpager2.widget.e eVar) {
            this();
        }

        boolean b(int i) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class c extends RecyclerView.c {
        private c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void a(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void b(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void c(int i, int i2) {
            a();
        }

        /* synthetic */ c(androidx.viewpager2.widget.e eVar) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void a(int i, int i2, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.c
        public final void a(int i, int i2, int i3) {
            a();
        }
    }

    private class d extends LinearLayoutManager {
        d(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void calculateExtraLayoutSpace(RecyclerView.t tVar, int[] iArr) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                super.calculateExtraLayoutSpace(tVar, iArr);
                return;
            }
            int pageSize = ViewPager2.this.getPageSize() * offscreenPageLimit;
            iArr[0] = pageSize;
            iArr[1] = pageSize;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void onInitializeAccessibilityNodeInfo(RecyclerView.o oVar, RecyclerView.t tVar, androidx.core.view.accessibility.b bVar) {
            super.onInitializeAccessibilityNodeInfo(oVar, tVar, bVar);
            ViewPager2.this.mAccessibilityProvider.a(bVar);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public boolean performAccessibilityAction(RecyclerView.o oVar, RecyclerView.t tVar, int i, Bundle bundle) {
            return ViewPager2.this.mAccessibilityProvider.a(i) ? ViewPager2.this.mAccessibilityProvider.b(i) : super.performAccessibilityAction(oVar, tVar, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    public static abstract class e {
        public void a(int i) {
        }

        public void a(int i, float f2, int i2) {
        }

        public void b(int i) {
        }
    }

    class f extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final androidx.core.view.accessibility.e f2422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.core.view.accessibility.e f2423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RecyclerView.c f2424d;

        f() {
            super(ViewPager2.this, null);
            this.f2422b = new androidx.viewpager2.widget.i(this);
            this.f2423c = new androidx.viewpager2.widget.j(this);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(CompositeOnPageChangeCallback compositeOnPageChangeCallback, RecyclerView recyclerView) {
            ViewCompat.f(recyclerView, 2);
            this.f2424d = new androidx.viewpager2.widget.k(this);
            if (ViewCompat.k(ViewPager2.this) == 0) {
                ViewCompat.f(ViewPager2.this, 1);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean a() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean a(int i, Bundle bundle) {
            return i == 8192 || i == 4096;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void b(RecyclerView.a<?> aVar) {
            if (aVar != null) {
                aVar.unregisterAdapterDataObserver(this.f2424d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public String c() {
            if (a()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void d() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void f() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void g() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void h() {
            j();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void i() {
            j();
            if (Build.VERSION.SDK_INT < 21) {
                ViewPager2.this.sendAccessibilityEvent(DLog.CRS);
            }
        }

        void j() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = R.id.accessibilityActionPageLeft;
            ViewCompat.d(viewPager2, R.id.accessibilityActionPageLeft);
            ViewCompat.d(viewPager2, R.id.accessibilityActionPageRight);
            ViewCompat.d(viewPager2, R.id.accessibilityActionPageUp);
            ViewCompat.d(viewPager2, R.id.accessibilityActionPageDown);
            if (ViewPager2.this.getAdapter() == null || (itemCount = ViewPager2.this.getAdapter().getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (ViewPager2.this.getOrientation() != 0) {
                if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                    ViewCompat.a(viewPager2, new b.a(R.id.accessibilityActionPageDown, null), null, this.f2422b);
                }
                if (ViewPager2.this.mCurrentItem > 0) {
                    ViewCompat.a(viewPager2, new b.a(R.id.accessibilityActionPageUp, null), null, this.f2423c);
                    return;
                }
                return;
            }
            boolean zIsRtl = ViewPager2.this.isRtl();
            int i2 = zIsRtl ? R.id.accessibilityActionPageLeft : R.id.accessibilityActionPageRight;
            if (zIsRtl) {
                i = R.id.accessibilityActionPageRight;
            }
            if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                ViewCompat.a(viewPager2, new b.a(i2, null), null, this.f2422b);
            }
            if (ViewPager2.this.mCurrentItem > 0) {
                ViewCompat.a(viewPager2, new b.a(i, null), null, this.f2423c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void onRvInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName(c());
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean b(int i, Bundle bundle) {
            if (!a(i, bundle)) {
                throw new IllegalStateException();
            }
            c(i == 8192 ? ViewPager2.this.getCurrentItem() - 1 : ViewPager2.this.getCurrentItem() + 1);
            return true;
        }

        void c(int i) {
            if (ViewPager2.this.isUserInputEnabled()) {
                ViewPager2.this.setCurrentItemInternal(i, true);
            }
        }

        private void c(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            RecyclerView.a adapter = ViewPager2.this.getAdapter();
            if (adapter == null || (itemCount = adapter.getItemCount()) == 0 || !ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            if (ViewPager2.this.mCurrentItem > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (ViewPager2.this.mCurrentItem < itemCount - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
            accessibilityNodeInfo.setScrollable(true);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(RecyclerView.a<?> aVar) {
            j();
            if (aVar != null) {
                aVar.registerAdapterDataObserver(this.f2424d);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
            b(accessibilityNodeInfo);
            if (Build.VERSION.SDK_INT >= 16) {
                c(accessibilityNodeInfo);
            }
        }

        private void b(AccessibilityNodeInfo accessibilityNodeInfo) {
            int itemCount;
            int itemCount2;
            if (ViewPager2.this.getAdapter() == null) {
                itemCount = 0;
            } else if (ViewPager2.this.getOrientation() == 1) {
                itemCount = ViewPager2.this.getAdapter().getItemCount();
            } else {
                itemCount2 = ViewPager2.this.getAdapter().getItemCount();
                itemCount = 0;
                androidx.core.view.accessibility.b.a(accessibilityNodeInfo).a(b.C0015b.a(itemCount, itemCount2, false, 0));
            }
            itemCount2 = 0;
            androidx.core.view.accessibility.b.a(accessibilityNodeInfo).a(b.C0015b.a(itemCount, itemCount2, false, 0));
        }
    }

    public interface g {
        void a(View view, float f2);
    }

    private class h extends L {
        h() {
        }

        @Override // androidx.recyclerview.widget.L, androidx.recyclerview.widget.ba
        public View c(RecyclerView.i iVar) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.c(iVar);
        }
    }

    private class i extends RecyclerView {
        i(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            return ViewPager2.this.mAccessibilityProvider.b() ? ViewPager2.this.mAccessibilityProvider.e() : super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.mCurrentItem);
            accessibilityEvent.setToIndex(ViewPager2.this.mCurrentItem);
            ViewPager2.this.mAccessibilityProvider.onRvInitializeAccessibilityEvent(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    private static class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final RecyclerView f2432b;

        k(int i, RecyclerView recyclerView) {
            this.f2431a = i;
            this.f2432b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2432b.smoothScrollToPosition(this.f2431a);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.e(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, null);
    }

    private RecyclerView.j enforceChildFillListener() {
        return new androidx.viewpager2.widget.h(this);
    }

    private void initialize(Context context, AttributeSet attributeSet) {
        this.mAccessibilityProvider = sFeatureEnhancedA11yEnabled ? new f() : new b();
        this.mRecyclerView = new i(context);
        this.mRecyclerView.setId(ViewCompat.a());
        this.mRecyclerView.setDescendantFocusability(131072);
        this.mLayoutManager = new d(context);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mRecyclerView.setScrollingTouchSlop(1);
        setOrientation(context, attributeSet);
        this.mRecyclerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.mRecyclerView.addOnChildAttachStateChangeListener(enforceChildFillListener());
        this.mScrollEventAdapter = new ScrollEventAdapter(this);
        this.mFakeDragger = new androidx.viewpager2.widget.c(this, this.mScrollEventAdapter, this.mRecyclerView);
        this.mPagerSnapHelper = new h();
        this.mPagerSnapHelper.a(this.mRecyclerView);
        this.mRecyclerView.addOnScrollListener(this.mScrollEventAdapter);
        this.mPageChangeEventDispatcher = new CompositeOnPageChangeCallback(3);
        this.mScrollEventAdapter.setOnPageChangeCallback(this.mPageChangeEventDispatcher);
        androidx.viewpager2.widget.f fVar = new androidx.viewpager2.widget.f(this);
        androidx.viewpager2.widget.g gVar = new androidx.viewpager2.widget.g(this);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(fVar);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(gVar);
        this.mAccessibilityProvider.a(this.mPageChangeEventDispatcher, this.mRecyclerView);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mExternalPageChangeCallbacks);
        this.mPageTransformerAdapter = new androidx.viewpager2.widget.d(this.mLayoutManager);
        this.mPageChangeEventDispatcher.addOnPageChangeCallback(this.mPageTransformerAdapter);
        RecyclerView recyclerView = this.mRecyclerView;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void registerCurrentItemDataSetTracker(RecyclerView.a<?> aVar) {
        if (aVar != null) {
            aVar.registerAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void restorePendingState() {
        RecyclerView.a adapter;
        if (this.mPendingCurrentItem == -1 || (adapter = getAdapter()) == 0) {
            return;
        }
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            if (adapter instanceof androidx.viewpager2.adapter.c) {
                ((androidx.viewpager2.adapter.c) adapter).a(parcelable);
            }
            this.mPendingAdapterState = null;
        }
        this.mCurrentItem = Math.max(0, Math.min(this.mPendingCurrentItem, adapter.getItemCount() - 1));
        this.mPendingCurrentItem = -1;
        this.mRecyclerView.scrollToPosition(this.mCurrentItem);
        this.mAccessibilityProvider.d();
    }

    private void setOrientation(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.viewpager2.R.styleable.ViewPager2);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, androidx.viewpager2.R.styleable.ViewPager2, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(androidx.viewpager2.R.styleable.ViewPager2_android_orientation, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void unregisterCurrentItemDataSetTracker(RecyclerView.a<?> aVar) {
        if (aVar != null) {
            aVar.unregisterAdapterDataObserver(this.mCurrentItemDataSetChangeObserver);
        }
    }

    public void addItemDecoration(RecyclerView.h hVar) {
        this.mRecyclerView.addItemDecoration(hVar);
    }

    public boolean beginFakeDrag() {
        return this.mFakeDragger.a();
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.mRecyclerView.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.mRecyclerView.canScrollVertically(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof j) {
            int i2 = ((j) parcelable).f2428a;
            sparseArray.put(this.mRecyclerView.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        restorePendingState();
    }

    public boolean endFakeDrag() {
        return this.mFakeDragger.b();
    }

    public boolean fakeDragBy(@SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.mFakeDragger.a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return this.mAccessibilityProvider.a() ? this.mAccessibilityProvider.c() : super.getAccessibilityClassName();
    }

    public RecyclerView.a getAdapter() {
        return this.mRecyclerView.getAdapter();
    }

    public int getCurrentItem() {
        return this.mCurrentItem;
    }

    public RecyclerView.h getItemDecorationAt(int i2) {
        return this.mRecyclerView.getItemDecorationAt(i2);
    }

    public int getItemDecorationCount() {
        return this.mRecyclerView.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getOrientation() {
        return this.mLayoutManager.getOrientation();
    }

    int getPageSize() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.mRecyclerView;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.mScrollEventAdapter.b();
    }

    public void invalidateItemDecorations() {
        this.mRecyclerView.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.mFakeDragger.c();
    }

    boolean isRtl() {
        return this.mLayoutManager.getLayoutDirection() == 1;
    }

    public boolean isUserInputEnabled() {
        return this.mUserInputEnabled;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.mAccessibilityProvider.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        this.mTmpContainerRect.left = getPaddingLeft();
        this.mTmpContainerRect.right = (i4 - i2) - getPaddingRight();
        this.mTmpContainerRect.top = getPaddingTop();
        this.mTmpContainerRect.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(8388659, measuredWidth, measuredHeight, this.mTmpContainerRect, this.mTmpChildRect);
        RecyclerView recyclerView = this.mRecyclerView;
        Rect rect = this.mTmpChildRect;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.mCurrentItemDirty) {
            updateCurrentItem();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        measureChild(this.mRecyclerView, i2, i3);
        int measuredWidth = this.mRecyclerView.getMeasuredWidth();
        int measuredHeight = this.mRecyclerView.getMeasuredHeight();
        int measuredState = this.mRecyclerView.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof j)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.getSuperState());
        this.mPendingCurrentItem = jVar.f2429b;
        this.mPendingAdapterState = jVar.f2430c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        j jVar = new j(super.onSaveInstanceState());
        jVar.f2428a = this.mRecyclerView.getId();
        int i2 = this.mPendingCurrentItem;
        if (i2 == -1) {
            i2 = this.mCurrentItem;
        }
        jVar.f2429b = i2;
        Parcelable parcelable = this.mPendingAdapterState;
        if (parcelable != null) {
            jVar.f2430c = parcelable;
        } else {
            Object adapter = this.mRecyclerView.getAdapter();
            if (adapter instanceof androidx.viewpager2.adapter.c) {
                jVar.f2430c = ((androidx.viewpager2.adapter.c) adapter).a();
            }
        }
        return jVar;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        return this.mAccessibilityProvider.a(i2, bundle) ? this.mAccessibilityProvider.b(i2, bundle) : super.performAccessibilityAction(i2, bundle);
    }

    public void registerOnPageChangeCallback(e eVar) {
        this.mExternalPageChangeCallbacks.addOnPageChangeCallback(eVar);
    }

    public void removeItemDecoration(RecyclerView.h hVar) {
        this.mRecyclerView.removeItemDecoration(hVar);
    }

    public void removeItemDecorationAt(int i2) {
        this.mRecyclerView.removeItemDecorationAt(i2);
    }

    public void requestTransform() {
        if (this.mPageTransformerAdapter.a() == null) {
            return;
        }
        double dA = this.mScrollEventAdapter.a();
        int i2 = (int) dA;
        double d2 = i2;
        Double.isNaN(d2);
        float f2 = (float) (dA - d2);
        this.mPageTransformerAdapter.a(i2, f2, Math.round(getPageSize() * f2));
    }

    public void setAdapter(RecyclerView.a aVar) {
        RecyclerView.a adapter = this.mRecyclerView.getAdapter();
        this.mAccessibilityProvider.b((RecyclerView.a<?>) adapter);
        unregisterCurrentItemDataSetTracker(adapter);
        this.mRecyclerView.setAdapter(aVar);
        this.mCurrentItem = 0;
        restorePendingState();
        this.mAccessibilityProvider.a((RecyclerView.a<?>) aVar);
        registerCurrentItemDataSetTracker(aVar);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    void setCurrentItemInternal(int i2, boolean z) {
        RecyclerView.a adapter = getAdapter();
        if (adapter == null) {
            if (this.mPendingCurrentItem != -1) {
                this.mPendingCurrentItem = Math.max(i2, 0);
                return;
            }
            return;
        }
        if (adapter.getItemCount() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
        if (iMin == this.mCurrentItem && this.mScrollEventAdapter.e()) {
            return;
        }
        if (iMin == this.mCurrentItem && z) {
            return;
        }
        double dA = this.mCurrentItem;
        this.mCurrentItem = iMin;
        this.mAccessibilityProvider.g();
        if (!this.mScrollEventAdapter.e()) {
            dA = this.mScrollEventAdapter.a();
        }
        this.mScrollEventAdapter.a(iMin, z);
        if (!z) {
            this.mRecyclerView.scrollToPosition(iMin);
            return;
        }
        double d2 = iMin;
        Double.isNaN(d2);
        if (Math.abs(d2 - dA) <= 3.0d) {
            this.mRecyclerView.smoothScrollToPosition(iMin);
            return;
        }
        this.mRecyclerView.scrollToPosition(d2 > dA ? iMin - 3 : iMin + 3);
        RecyclerView recyclerView = this.mRecyclerView;
        recyclerView.post(new k(iMin, recyclerView));
    }

    @Override // android.view.View
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.mAccessibilityProvider.f();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.mOffscreenPageLimit = i2;
        this.mRecyclerView.requestLayout();
    }

    public void setPageTransformer(g gVar) {
        if (gVar != null) {
            if (!this.mSavedItemAnimatorPresent) {
                this.mSavedItemAnimator = this.mRecyclerView.getItemAnimator();
                this.mSavedItemAnimatorPresent = true;
            }
            this.mRecyclerView.setItemAnimator(null);
        } else if (this.mSavedItemAnimatorPresent) {
            this.mRecyclerView.setItemAnimator(this.mSavedItemAnimator);
            this.mSavedItemAnimator = null;
            this.mSavedItemAnimatorPresent = false;
        }
        if (gVar == this.mPageTransformerAdapter.a()) {
            return;
        }
        this.mPageTransformerAdapter.a(gVar);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.mUserInputEnabled = z;
        this.mAccessibilityProvider.i();
    }

    void snapToPage() {
        View viewC = this.mPagerSnapHelper.c(this.mLayoutManager);
        if (viewC == null) {
            return;
        }
        int[] iArrA = this.mPagerSnapHelper.a(this.mLayoutManager, viewC);
        if (iArrA[0] == 0 && iArrA[1] == 0) {
            return;
        }
        this.mRecyclerView.smoothScrollBy(iArrA[0], iArrA[1]);
    }

    public void unregisterOnPageChangeCallback(e eVar) {
        this.mExternalPageChangeCallbacks.removeOnPageChangeCallback(eVar);
    }

    void updateCurrentItem() {
        L l = this.mPagerSnapHelper;
        if (l == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewC = l.c(this.mLayoutManager);
        if (viewC == null) {
            return;
        }
        int position = this.mLayoutManager.getPosition(viewC);
        if (position != this.mCurrentItem && getScrollState() == 0) {
            this.mPageChangeEventDispatcher.b(position);
        }
        this.mCurrentItemDirty = false;
    }

    class b extends a {
        b() {
            super(ViewPager2.this, null);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean a(int i) {
            return (i == 8192 || i == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean b() {
            return true;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public boolean b(int i) {
            if (a(i)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public CharSequence e() {
            if (b()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.a
        public void a(androidx.core.view.accessibility.b bVar) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            bVar.b(b.a.n);
            bVar.b(b.a.m);
            bVar.n(false);
        }
    }

    static class j extends View.BaseSavedState {
        public static final Parcelable.Creator<j> CREATOR = new l();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Parcelable f2430c;

        j(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f2428a = parcel.readInt();
            this.f2429b = parcel.readInt();
            this.f2430c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2428a);
            parcel.writeInt(this.f2429b);
            parcel.writeParcelable(this.f2430c, i);
        }

        j(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        j(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(RecyclerView.h hVar, int i2) {
        this.mRecyclerView.addItemDecoration(hVar, i2);
    }

    public void setCurrentItem(int i2, boolean z) {
        if (isFakeDragging()) {
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }
        setCurrentItemInternal(i2, z);
    }

    public void setOrientation(int i2) {
        this.mLayoutManager.setOrientation(i2);
        this.mAccessibilityProvider.h();
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.e(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.e(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mTmpContainerRect = new Rect();
        this.mTmpChildRect = new Rect();
        this.mExternalPageChangeCallbacks = new CompositeOnPageChangeCallback(3);
        this.mCurrentItemDirty = false;
        this.mCurrentItemDataSetChangeObserver = new androidx.viewpager2.widget.e(this);
        this.mPendingCurrentItem = -1;
        this.mSavedItemAnimator = null;
        this.mSavedItemAnimatorPresent = false;
        this.mUserInputEnabled = true;
        this.mOffscreenPageLimit = -1;
        initialize(context, attributeSet);
    }
}
