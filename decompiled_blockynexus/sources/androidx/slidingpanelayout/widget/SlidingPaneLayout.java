package androidx.slidingpanelayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0313a;
import androidx.core.view.ViewCompat;
import androidx.customview.b.g;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {
    private static final int DEFAULT_FADE_COLOR = -858993460;
    private static final int DEFAULT_OVERHANG_SIZE = 32;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final String TAG = "SlidingPaneLayout";
    private boolean mCanSlide;
    private int mCoveredFadeColor;
    private boolean mDisplayListReflectionLoaded;
    final g mDragHelper;
    private boolean mFirstLayout;
    private Method mGetDisplayList;
    private float mInitialMotionX;
    private float mInitialMotionY;
    boolean mIsUnableToDrag;
    private final int mOverhangSize;
    private d mPanelSlideListener;
    private int mParallaxBy;
    private float mParallaxOffset;
    final ArrayList<b> mPostedRunnables;
    boolean mPreservedOpenState;
    private Field mRecreateDisplayList;
    private Drawable mShadowDrawableLeft;
    private Drawable mShadowDrawableRight;
    float mSlideOffset;
    int mSlideRange;
    View mSlideableView;
    private int mSliderFadeColor;
    private final Rect mTmpRect;

    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final View f2080a;

        b(View view) {
            this.f2080a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2080a.getParent() == SlidingPaneLayout.this) {
                this.f2080a.setLayerType(0, null);
                SlidingPaneLayout.this.invalidateChildRegion(this.f2080a);
            }
            SlidingPaneLayout.this.mPostedRunnables.remove(this);
        }
    }

    private class c extends g.a {
        c() {
        }

        @Override // androidx.customview.b.g.a
        public void a(View view, int i) {
            SlidingPaneLayout.this.setAllChildrenVisible();
        }

        @Override // androidx.customview.b.g.a
        public boolean b(View view, int i) {
            if (SlidingPaneLayout.this.mIsUnableToDrag) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f2075c;
        }

        @Override // androidx.customview.b.g.a
        public void c(int i) {
            if (SlidingPaneLayout.this.mDragHelper.f() == 0) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                if (slidingPaneLayout.mSlideOffset != WheelView.DividerConfig.FILL) {
                    slidingPaneLayout.dispatchOnPanelOpened(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = true;
                } else {
                    slidingPaneLayout.updateObscuredViewsVisibility(slidingPaneLayout.mSlideableView);
                    SlidingPaneLayout slidingPaneLayout2 = SlidingPaneLayout.this;
                    slidingPaneLayout2.dispatchOnPanelClosed(slidingPaneLayout2.mSlideableView);
                    SlidingPaneLayout.this.mPreservedOpenState = false;
                }
            }
        }

        @Override // androidx.customview.b.g.a
        public void a(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.onPanelDragged(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.b.g.a
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.b.g.a
        public void a(View view, float f2, float f3) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int paddingRight = SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                if (f2 < WheelView.DividerConfig.FILL || (f2 == WheelView.DividerConfig.FILL && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.mSlideRange;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.mSlideableView.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f2 > WheelView.DividerConfig.FILL || (f2 == WheelView.DividerConfig.FILL && SlidingPaneLayout.this.mSlideOffset > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.mSlideRange;
                }
            }
            SlidingPaneLayout.this.mDragHelper.d(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // androidx.customview.b.g.a
        public int a(View view) {
            return SlidingPaneLayout.this.mSlideRange;
        }

        @Override // androidx.customview.b.g.a
        public int a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.mSlideableView.getLayoutParams();
            if (SlidingPaneLayout.this.isLayoutRtlSupport()) {
                int width = SlidingPaneLayout.this.getWidth() - ((SlidingPaneLayout.this.getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + SlidingPaneLayout.this.mSlideableView.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.mSlideRange);
            }
            int paddingLeft = SlidingPaneLayout.this.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.mSlideRange + paddingLeft);
        }

        @Override // androidx.customview.b.g.a
        public void a(int i, int i2) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            slidingPaneLayout.mDragHelper.a(slidingPaneLayout.mSlideableView, i2);
        }
    }

    public interface d {
        void a(View view);

        void a(View view, float f2);

        void b(View view);
    }

    static class e extends androidx.customview.a.c {
        public static final Parcelable.Creator<e> CREATOR = new androidx.slidingpanelayout.widget.a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2083c;

        e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.a.c, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2083c ? 1 : 0);
        }

        e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2083c = parcel.readInt() != 0;
        }
    }

    public SlidingPaneLayout(Context context) {
        this(context, null);
    }

    private boolean closePane(View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(WheelView.DividerConfig.FILL, i)) {
            return false;
        }
        this.mPreservedOpenState = false;
        return true;
    }

    private void dimChildView(View view, float f2, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f2 > WheelView.DividerConfig.FILL && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f2)) << 24) | (i & 16777215);
            if (layoutParams.f2077e == null) {
                layoutParams.f2077e = new Paint();
            }
            layoutParams.f2077e.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f2077e);
            }
            invalidateChildRegion(view);
            return;
        }
        if (view.getLayerType() != 0) {
            Paint paint = layoutParams.f2077e;
            if (paint != null) {
                paint.setColorFilter(null);
            }
            b bVar = new b(view);
            this.mPostedRunnables.add(bVar);
            ViewCompat.a(this, bVar);
        }
    }

    private boolean openPane(View view, int i) {
        if (!this.mFirstLayout && !smoothSlideTo(1.0f, i)) {
            return false;
        }
        this.mPreservedOpenState = true;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parallaxOtherViews(float r10) {
        /*
            r9 = this;
            boolean r0 = r9.isLayoutRtlSupport()
            android.view.View r1 = r9.mSlideableView
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams r1 = (androidx.slidingpanelayout.widget.SlidingPaneLayout.LayoutParams) r1
            boolean r2 = r1.f2076d
            r3 = 0
            if (r2 == 0) goto L1c
            if (r0 == 0) goto L16
            int r1 = r1.rightMargin
            goto L18
        L16:
            int r1 = r1.leftMargin
        L18:
            if (r1 > 0) goto L1c
            r1 = 1
            goto L1d
        L1c:
            r1 = 0
        L1d:
            int r2 = r9.getChildCount()
        L21:
            if (r3 >= r2) goto L5b
            android.view.View r4 = r9.getChildAt(r3)
            android.view.View r5 = r9.mSlideableView
            if (r4 != r5) goto L2c
            goto L58
        L2c:
            float r5 = r9.mParallaxOffset
            r6 = 1065353216(0x3f800000, float:1.0)
            float r5 = r6 - r5
            int r7 = r9.mParallaxBy
            float r8 = (float) r7
            float r5 = r5 * r8
            int r5 = (int) r5
            r9.mParallaxOffset = r10
            float r8 = r6 - r10
            float r7 = (float) r7
            float r8 = r8 * r7
            int r7 = (int) r8
            int r5 = r5 - r7
            if (r0 == 0) goto L44
            int r5 = -r5
        L44:
            r4.offsetLeftAndRight(r5)
            if (r1 == 0) goto L58
            if (r0 == 0) goto L4f
            float r5 = r9.mParallaxOffset
            float r5 = r5 - r6
            goto L53
        L4f:
            float r5 = r9.mParallaxOffset
            float r5 = r6 - r5
        L53:
            int r6 = r9.mCoveredFadeColor
            r9.dimChildView(r4, r5, r6)
        L58:
            int r3 = r3 + 1
            goto L21
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.parallaxOtherViews(float):void");
    }

    private static boolean viewIsOpaque(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && canScroll(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z) {
            if (view.canScrollHorizontally(isLayoutRtlSupport() ? i : -i)) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean canSlide() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mDragHelper.a(true)) {
            if (this.mCanSlide) {
                ViewCompat.G(this);
            } else {
                this.mDragHelper.a();
            }
        }
    }

    void dispatchOnPanelClosed(View view) {
        d dVar = this.mPanelSlideListener;
        if (dVar != null) {
            dVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelOpened(View view) {
        d dVar = this.mPanelSlideListener;
        if (dVar != null) {
            dVar.a(view);
        }
        sendAccessibilityEvent(32);
    }

    void dispatchOnPanelSlide(View view) {
        d dVar = this.mPanelSlideListener;
        if (dVar != null) {
            dVar.a(view, this.mSlideOffset);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i;
        int right;
        super.draw(canvas);
        Drawable drawable = isLayoutRtlSupport() ? this.mShadowDrawableRight : this.mShadowDrawableLeft;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (isLayoutRtlSupport()) {
            right = childAt.getRight();
            i = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i2 = left - intrinsicWidth;
            i = left;
            right = i2;
        }
        drawable.setBounds(right, top, i, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.mCanSlide && !layoutParams.f2075c && this.mSlideableView != null) {
            canvas.getClipBounds(this.mTmpRect);
            if (isLayoutRtlSupport()) {
                Rect rect = this.mTmpRect;
                rect.left = Math.max(rect.left, this.mSlideableView.getRight());
            } else {
                Rect rect2 = this.mTmpRect;
                rect2.right = Math.min(rect2.right, this.mSlideableView.getLeft());
            }
            canvas.clipRect(this.mTmpRect);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public int getParallaxDistance() {
        return this.mParallaxBy;
    }

    public int getSliderFadeColor() {
        return this.mSliderFadeColor;
    }

    void invalidateChildRegion(View view) {
        Field field;
        int i = Build.VERSION.SDK_INT;
        if (i >= 17) {
            ViewCompat.a(view, ((LayoutParams) view.getLayoutParams()).f2077e);
            return;
        }
        if (i >= 16) {
            if (!this.mDisplayListReflectionLoaded) {
                try {
                    this.mGetDisplayList = View.class.getDeclaredMethod("getDisplayList", null);
                } catch (NoSuchMethodException e2) {
                    Log.e(TAG, "Couldn't fetch getDisplayList method; dimming won't work right.", e2);
                }
                try {
                    this.mRecreateDisplayList = View.class.getDeclaredField("mRecreateDisplayList");
                    this.mRecreateDisplayList.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e(TAG, "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e3);
                }
                this.mDisplayListReflectionLoaded = true;
            }
            if (this.mGetDisplayList == null || (field = this.mRecreateDisplayList) == null) {
                view.invalidate();
                return;
            }
            try {
                field.setBoolean(view, true);
                this.mGetDisplayList.invoke(view, null);
            } catch (Exception e4) {
                Log.e(TAG, "Error refreshing display list state", e4);
            }
        }
        ViewCompat.a(this, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    boolean isDimmed(View view) {
        if (view == null) {
            return false;
        }
        return this.mCanSlide && ((LayoutParams) view.getLayoutParams()).f2076d && this.mSlideOffset > WheelView.DividerConfig.FILL;
    }

    boolean isLayoutRtlSupport() {
        return ViewCompat.m(this) == 1;
    }

    public boolean isOpen() {
        return !this.mCanSlide || this.mSlideOffset == 1.0f;
    }

    public boolean isSlideable() {
        return this.mCanSlide;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
        int size = this.mPostedRunnables.size();
        for (int i = 0; i < size; i++) {
            this.mPostedRunnables.get(i).run();
        }
        this.mPostedRunnables.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.mCanSlide && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.mPreservedOpenState = !this.mDragHelper.a(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.mCanSlide || (this.mIsUnableToDrag && actionMasked != 0)) {
            this.mDragHelper.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.mDragHelper.b();
            return false;
        }
        if (actionMasked == 0) {
            this.mIsUnableToDrag = false;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
            if (this.mDragHelper.a(this.mSlideableView, (int) x, (int) y) && isDimmed(this.mSlideableView)) {
                z = true;
            }
            return this.mDragHelper.b(motionEvent) || z;
        }
        if (actionMasked == 2) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float fAbs = Math.abs(x2 - this.mInitialMotionX);
            float fAbs2 = Math.abs(y2 - this.mInitialMotionY);
            if (fAbs > this.mDragHelper.e() && fAbs2 > fAbs) {
                this.mDragHelper.b();
                this.mIsUnableToDrag = true;
                return false;
            }
        }
        z = false;
        if (this.mDragHelper.b(motionEvent)) {
            return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        if (zIsLayoutRtlSupport) {
            this.mDragHelper.d(2);
        } else {
            this.mDragHelper.d(1);
        }
        int i10 = i3 - i;
        int paddingRight = zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            this.mSlideOffset = (this.mCanSlide && this.mPreservedOpenState) ? 1.0f : WheelView.DividerConfig.FILL;
        }
        int width = paddingRight;
        int i11 = width;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f2075c) {
                    int i13 = i10 - paddingLeft;
                    int iMin = (Math.min(width, i13 - this.mOverhangSize) - i11) - (((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    this.mSlideRange = iMin;
                    int i14 = zIsLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    layoutParams.f2076d = ((i11 + i14) + iMin) + (measuredWidth / 2) > i13;
                    int i15 = (int) (iMin * this.mSlideOffset);
                    i5 = i14 + i15 + i11;
                    this.mSlideOffset = i15 / this.mSlideRange;
                    i6 = 0;
                } else if (!this.mCanSlide || (i7 = this.mParallaxBy) == 0) {
                    i5 = width;
                    i6 = 0;
                } else {
                    i6 = (int) ((1.0f - this.mSlideOffset) * i7);
                    i5 = width;
                }
                if (zIsLayoutRtlSupport) {
                    i9 = (i10 - i5) + i6;
                    i8 = i9 - measuredWidth;
                } else {
                    i8 = i5 - i6;
                    i9 = i8 + measuredWidth;
                }
                childAt.layout(i8, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                width += childAt.getWidth();
                i11 = i5;
            }
        }
        if (this.mFirstLayout) {
            if (this.mCanSlide) {
                if (this.mParallaxBy != 0) {
                    parallaxOtherViews(this.mSlideOffset);
                }
                if (((LayoutParams) this.mSlideableView.getLayoutParams()).f2076d) {
                    dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
                }
            } else {
                for (int i16 = 0; i16 < childCount; i16++) {
                    dimChildView(getChildAt(i16), WheelView.DividerConfig.FILL, this.mSliderFadeColor);
                }
            }
            updateObscuredViewsVisibility(this.mSlideableView);
        }
        this.mFirstLayout = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2 A[PHI: r12
      0x00b2: PHI (r12v2 float) = (r12v1 float), (r12v3 float) binds: [B:35:0x00a9, B:37:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0143  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 586
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    void onPanelDragged(int i) {
        if (this.mSlideableView == null) {
            this.mSlideOffset = WheelView.DividerConfig.FILL;
            return;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        int width = this.mSlideableView.getWidth();
        if (zIsLayoutRtlSupport) {
            i = (getWidth() - i) - width;
        }
        this.mSlideOffset = (i - ((zIsLayoutRtlSupport ? getPaddingRight() : getPaddingLeft()) + (zIsLayoutRtlSupport ? ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin))) / this.mSlideRange;
        if (this.mParallaxBy != 0) {
            parallaxOtherViews(this.mSlideOffset);
        }
        if (layoutParams.f2076d) {
            dimChildView(this.mSlideableView, this.mSlideOffset, this.mSliderFadeColor);
        }
        dispatchOnPanelSlide(this.mSlideableView);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.a());
        if (eVar.f2083c) {
            openPane();
        } else {
            closePane();
        }
        this.mPreservedOpenState = eVar.f2083c;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f2083c = isSlideable() ? isOpen() : this.mPreservedOpenState;
        return eVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.mFirstLayout = true;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.mCanSlide) {
            return super.onTouchEvent(motionEvent);
        }
        this.mDragHelper.a(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.mInitialMotionX = x;
            this.mInitialMotionY = y;
        } else if (actionMasked == 1 && isDimmed(this.mSlideableView)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            float f2 = x2 - this.mInitialMotionX;
            float f3 = y2 - this.mInitialMotionY;
            int iE = this.mDragHelper.e();
            if ((f2 * f2) + (f3 * f3) < iE * iE && this.mDragHelper.a(this.mSlideableView, (int) x2, (int) y2)) {
                closePane(this.mSlideableView, 0);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.mCanSlide) {
            return;
        }
        this.mPreservedOpenState = view == this.mSlideableView;
    }

    void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    public void setCoveredFadeColor(int i) {
        this.mCoveredFadeColor = i;
    }

    public void setPanelSlideListener(d dVar) {
        this.mPanelSlideListener = dVar;
    }

    public void setParallaxDistance(int i) {
        this.mParallaxBy = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.mShadowDrawableLeft = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.mShadowDrawableRight = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(androidx.core.content.b.c(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(androidx.core.content.b.c(getContext(), i));
    }

    public void setSliderFadeColor(int i) {
        this.mSliderFadeColor = i;
    }

    @Deprecated
    public void smoothSlideClosed() {
        closePane();
    }

    @Deprecated
    public void smoothSlideOpen() {
        openPane();
    }

    boolean smoothSlideTo(float f2, int i) {
        int paddingLeft;
        if (!this.mCanSlide) {
            return false;
        }
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        LayoutParams layoutParams = (LayoutParams) this.mSlideableView.getLayoutParams();
        if (zIsLayoutRtlSupport) {
            paddingLeft = (int) (getWidth() - (((getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + (f2 * this.mSlideRange)) + this.mSlideableView.getWidth()));
        } else {
            paddingLeft = (int) (getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + (f2 * this.mSlideRange));
        }
        g gVar = this.mDragHelper;
        View view = this.mSlideableView;
        if (!gVar.b(view, paddingLeft, view.getTop())) {
            return false;
        }
        setAllChildrenVisible();
        ViewCompat.G(this);
        return true;
    }

    void updateObscuredViewsVisibility(View view) {
        int left;
        int right;
        int top;
        int bottom;
        boolean z;
        int i;
        View view2 = view;
        boolean zIsLayoutRtlSupport = isLayoutRtlSupport();
        int width = zIsLayoutRtlSupport ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zIsLayoutRtlSupport ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !viewIsOpaque(view)) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        }
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z = zIsLayoutRtlSupport;
            } else {
                int iMax = Math.max(zIsLayoutRtlSupport ? paddingLeft : width, childAt.getLeft());
                int iMax2 = Math.max(paddingTop, childAt.getTop());
                if (zIsLayoutRtlSupport) {
                    z = zIsLayoutRtlSupport;
                    i = width;
                } else {
                    z = zIsLayoutRtlSupport;
                    i = paddingLeft;
                }
                childAt.setVisibility((iMax < left || iMax2 < top || Math.min(i, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i2++;
            view2 = view;
            zIsLayoutRtlSupport = z;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int[] f2073a = {R.attr.layout_weight};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f2074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f2077e;

        public LayoutParams() {
            super(-1, -1);
            this.f2074b = WheelView.DividerConfig.FILL;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2074b = WheelView.DividerConfig.FILL;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2074b = WheelView.DividerConfig.FILL;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2074b = WheelView.DividerConfig.FILL;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2073a);
            this.f2074b = typedArrayObtainStyledAttributes.getFloat(0, WheelView.DividerConfig.FILL);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSliderFadeColor = DEFAULT_FADE_COLOR;
        this.mFirstLayout = true;
        this.mTmpRect = new Rect();
        this.mPostedRunnables = new ArrayList<>();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.mOverhangSize = (int) ((32.0f * f2) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.a(this, new a());
        ViewCompat.f(this, 1);
        this.mDragHelper = g.a(this, 0.5f, new c());
        this.mDragHelper.a(f2 * 400.0f);
    }

    public boolean closePane() {
        return closePane(this.mSlideableView, 0);
    }

    public boolean openPane() {
        return openPane(this.mSlideableView, 0);
    }

    class a extends C0313a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Rect f2078d = new Rect();

        a() {
        }

        @Override // androidx.core.view.C0313a
        public void a(View view, androidx.core.view.accessibility.b bVar) {
            androidx.core.view.accessibility.b bVarA = androidx.core.view.accessibility.b.a(bVar);
            super.a(view, bVarA);
            a(bVar, bVarA);
            bVarA.y();
            bVar.b((CharSequence) SlidingPaneLayout.class.getName());
            bVar.d(view);
            Object objS = ViewCompat.s(view);
            if (objS instanceof View) {
                bVar.c((View) objS);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!c(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.f(childAt, 1);
                    bVar.a(childAt);
                }
            }
        }

        public boolean c(View view) {
            return SlidingPaneLayout.this.isDimmed(view);
        }

        @Override // androidx.core.view.C0313a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // androidx.core.view.C0313a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (c(view)) {
                return false;
            }
            return super.a(viewGroup, view, accessibilityEvent);
        }

        private void a(androidx.core.view.accessibility.b bVar, androidx.core.view.accessibility.b bVar2) {
            Rect rect = this.f2078d;
            bVar2.a(rect);
            bVar.c(rect);
            bVar2.b(rect);
            bVar.d(rect);
            bVar.q(bVar2.w());
            bVar.f(bVar2.h());
            bVar.b(bVar2.d());
            bVar.c(bVar2.e());
            bVar.h(bVar2.o());
            bVar.e(bVar2.n());
            bVar.i(bVar2.p());
            bVar.j(bVar2.q());
            bVar.a(bVar2.k());
            bVar.o(bVar2.u());
            bVar.l(bVar2.r());
            bVar.a(bVar2.b());
            bVar.b(bVar2.g());
        }
    }
}
