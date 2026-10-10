package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import androidx.core.view.m;
import androidx.core.view.p;
import androidx.core.view.q;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements androidx.core.view.l, p {
    private static final int ALPHA_ANIMATION_DURATION = 300;
    private static final int ANIMATE_TO_START_DURATION = 200;
    private static final int ANIMATE_TO_TRIGGER_DURATION = 200;
    private static final int CIRCLE_BG_LIGHT = -328966;
    static final int CIRCLE_DIAMETER = 40;
    static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float DECELERATE_INTERPOLATION_FACTOR = 2.0f;
    public static final int DEFAULT = 1;
    private static final int DEFAULT_CIRCLE_TARGET = 64;
    public static final int DEFAULT_SLINGSHOT_DISTANCE = -1;
    private static final float DRAG_RATE = 0.5f;
    private static final int INVALID_POINTER = -1;
    public static final int LARGE = 0;
    private static final int[] LAYOUT_ATTRS = {R.attr.enabled};
    private static final String LOG_TAG = "SwipeRefreshLayout";
    private static final int MAX_ALPHA = 255;
    private static final float MAX_PROGRESS_ANGLE = 0.8f;
    private static final int SCALE_DOWN_DURATION = 150;
    private static final int STARTING_PROGRESS_ALPHA = 76;
    private int mActivePointerId;
    private Animation mAlphaMaxAnimation;
    private Animation mAlphaStartAnimation;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private a mChildScrollUpCallback;
    private int mCircleDiameter;
    androidx.swiperefreshlayout.widget.a mCircleView;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    int mCustomSlingshotDistance;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    b mListener;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final m mNestedScrollingChildHelper;
    private final q mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    d mProgress;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleAnimation;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;

    public interface a {
        boolean a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface b {
        void onRefresh();
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    private void animateOffsetToCorrectPosition(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
    }

    private void animateOffsetToStartPosition(int i, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mCircleView.a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mAnimateToStartPosition);
    }

    private void createProgressView() {
        this.mCircleView = new androidx.swiperefreshlayout.widget.a(getContext(), CIRCLE_BG_LIGHT);
        this.mProgress = new d(getContext());
        this.mProgress.a(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    private void finishSpinner(float f2) {
        if (f2 > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        this.mProgress.a(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, this.mScale ? null : new i(this));
        this.mProgress.a(false);
    }

    private boolean isAnimationRunning(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void moveSpinner(float f2) {
        this.mProgress.a(true);
        float fMin = Math.min(1.0f, Math.abs(f2 / this.mTotalDragDistance));
        double d2 = fMin;
        Double.isNaN(d2);
        float fMax = (((float) Math.max(d2 - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f2) - this.mTotalDragDistance;
        int i = this.mCustomSlingshotDistance;
        if (i <= 0) {
            i = this.mUsingCustomStart ? this.mSpinnerOffsetEnd - this.mOriginalOffsetTop : this.mSpinnerOffsetEnd;
        }
        float f3 = i;
        double dMax = Math.max(WheelView.DividerConfig.FILL, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        double dPow = Math.pow(dMax, 2.0d);
        Double.isNaN(dMax);
        float f4 = ((float) (dMax - dPow)) * 2.0f;
        int i2 = this.mOriginalOffsetTop + ((int) ((f3 * fMin) + (f3 * f4 * 2.0f)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f2 / this.mTotalDragDistance));
        }
        if (f2 < this.mTotalDragDistance) {
            if (this.mProgress.getAlpha() > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        } else if (this.mProgress.getAlpha() < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            startProgressAlphaMaxAnimation();
        }
        this.mProgress.a(WheelView.DividerConfig.FILL, Math.min(MAX_PROGRESS_ANGLE, fMax * MAX_PROGRESS_ANGLE));
        this.mProgress.a(Math.min(1.0f, fMax));
        this.mProgress.b((((fMax * 0.4f) - 0.25f) + (f4 * 2.0f)) * DRAG_RATE);
        setTargetOffsetTopAndBottom(i2 - this.mCurrentTargetOffsetTop);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        this.mProgress.setAlpha(i);
    }

    private Animation startAlphaAnimation(int i, int i2) {
        h hVar = new h(this, i, i2);
        hVar.setDuration(300L);
        this.mCircleView.a(null);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(hVar);
        return hVar;
    }

    private void startDragging(float f2) {
        float f3 = this.mInitialDownY;
        float f4 = f2 - f3;
        int i = this.mTouchSlop;
        if (f4 <= i || this.mIsBeingDragged) {
            return;
        }
        this.mInitialMotionY = f3 + i;
        this.mIsBeingDragged = true;
        this.mProgress.setAlpha(76);
    }

    private void startProgressAlphaMaxAnimation() {
        this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 255);
    }

    private void startProgressAlphaStartAnimation() {
        this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.getAlpha(), 76);
    }

    private void startScaleDownReturnToStartAnimation(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mStartingScale = this.mCircleView.getScaleX();
        this.mScaleDownToStartAnimation = new l(this);
        this.mScaleDownToStartAnimation.setDuration(150L);
        if (animationListener != null) {
            this.mCircleView.a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
    }

    private void startScaleUpAnimation(Animation.AnimationListener animationListener) {
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        this.mScaleAnimation = new f(this);
        this.mScaleAnimation.setDuration(this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.a(animationListener);
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public boolean canChildScrollUp() {
        a aVar = this.mChildScrollUpCallback;
        if (aVar != null) {
            return aVar.a(this, this.mTarget);
        }
        View view = this.mTarget;
        return view instanceof ListView ? androidx.core.widget.i.a((ListView) view, -1) : view.canScrollVertically(-1);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.mNestedScrollingChildHelper.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.mNestedScrollingChildHelper.a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mCircleViewIndex;
        return i3 < 0 ? i2 : i2 == i + (-1) ? i3 : i2 >= i3 ? i2 + 1 : i2;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.a();
    }

    @Override // android.view.View, androidx.core.view.l
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.b();
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    void moveToStart(float f2) {
        setTargetOffsetTopAndBottom((this.mFrom + ((int) ((this.mOriginalOffsetTop - r0) * f2))) - this.mCircleView.getTop());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0058  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r4.ensureTarget()
            int r0 = r5.getActionMasked()
            boolean r1 = r4.mReturningToStart
            r2 = 0
            if (r1 == 0) goto L10
            if (r0 != 0) goto L10
            r4.mReturningToStart = r2
        L10:
            boolean r1 = r4.isEnabled()
            if (r1 == 0) goto L83
            boolean r1 = r4.mReturningToStart
            if (r1 != 0) goto L83
            boolean r1 = r4.canChildScrollUp()
            if (r1 != 0) goto L83
            boolean r1 = r4.mRefreshing
            if (r1 != 0) goto L83
            boolean r1 = r4.mNestedScrollInProgress
            if (r1 == 0) goto L29
            goto L83
        L29:
            if (r0 == 0) goto L5d
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L58
            r1 = 2
            if (r0 == r1) goto L3d
            r1 = 3
            if (r0 == r1) goto L58
            r1 = 6
            if (r0 == r1) goto L39
            goto L80
        L39:
            r4.onSecondaryPointerUp(r5)
            goto L80
        L3d:
            int r0 = r4.mActivePointerId
            if (r0 != r3) goto L49
            java.lang.String r5 = androidx.swiperefreshlayout.widget.SwipeRefreshLayout.LOG_TAG
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r5, r0)
            return r2
        L49:
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L50
            return r2
        L50:
            float r5 = r5.getY(r0)
            r4.startDragging(r5)
            goto L80
        L58:
            r4.mIsBeingDragged = r2
            r4.mActivePointerId = r3
            goto L80
        L5d:
            int r0 = r4.mOriginalOffsetTop
            androidx.swiperefreshlayout.widget.a r1 = r4.mCircleView
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r4.setTargetOffsetTopAndBottom(r0)
            int r0 = r5.getPointerId(r2)
            r4.mActivePointerId = r0
            r4.mIsBeingDragged = r2
            int r0 = r4.mActivePointerId
            int r0 = r5.findPointerIndex(r0)
            if (r0 >= 0) goto L7a
            return r2
        L7a:
            float r5 = r5.getY(r0)
            r4.mInitialDownY = r5
        L80:
            boolean r5 = r4.mIsBeingDragged
            return r5
        L83:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.mCircleView.getMeasuredWidth();
        int measuredHeight2 = this.mCircleView.getMeasuredHeight();
        int i5 = measuredWidth / 2;
        int i6 = measuredWidth2 / 2;
        int i7 = this.mCurrentTargetOffsetTop;
        this.mCircleView.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), FileTypeUtils.GIGABYTE));
        this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, FileTypeUtils.GIGABYTE));
        this.mCircleViewIndex = -1;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == this.mCircleView) {
                this.mCircleViewIndex = i3;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f2 = this.mTotalUnconsumed;
            if (f2 > WheelView.DividerConfig.FILL) {
                float f3 = i2;
                if (f3 > f2) {
                    iArr[1] = i2 - ((int) f2);
                    this.mTotalUnconsumed = WheelView.DividerConfig.FILL;
                } else {
                    this.mTotalUnconsumed = f2 - f3;
                    iArr[1] = i2;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i2 > 0 && this.mTotalUnconsumed == WheelView.DividerConfig.FILL && Math.abs(i2 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        if (i4 + this.mParentOffsetInWindow[1] >= 0 || canChildScrollUp()) {
            return;
        }
        this.mTotalUnconsumed += Math.abs(r11);
        moveSpinner(this.mTotalUnconsumed);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.a(view, view2, i);
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = WheelView.DividerConfig.FILL;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.mReturningToStart || this.mRefreshing || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.a(view);
        this.mNestedScrollInProgress = false;
        float f2 = this.mTotalUnconsumed;
        if (f2 > WheelView.DividerConfig.FILL) {
            finishSpinner(f2);
            this.mTotalUnconsumed = WheelView.DividerConfig.FILL;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
        } else {
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.mIsBeingDragged) {
                    float y = (motionEvent.getY(iFindPointerIndex) - this.mInitialMotionY) * DRAG_RATE;
                    this.mIsBeingDragged = false;
                    finishSpinner(y);
                }
                this.mActivePointerId = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex2 < 0) {
                    Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(iFindPointerIndex2);
                startDragging(y2);
                if (this.mIsBeingDragged) {
                    float f2 = (y2 - this.mInitialMotionY) * DRAG_RATE;
                    if (f2 <= WheelView.DividerConfig.FILL) {
                        return false;
                    }
                    moveSpinner(f2);
                }
            } else {
                if (actionMasked == 3) {
                    return false;
                }
                if (actionMasked == 5) {
                    int actionIndex = motionEvent.getActionIndex();
                    if (actionIndex < 0) {
                        Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                        return false;
                    }
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                } else if (actionMasked == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) {
            View view = this.mTarget;
            if (view == null || ViewCompat.D(view)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(WheelView.DividerConfig.FILL);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    void setAnimationProgress(float f2) {
        this.mCircleView.setScaleX(f2);
        this.mCircleView.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        this.mProgress.a(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = androidx.core.content.b.a(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        reset();
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.a(z);
    }

    public void setOnChildScrollUpCallback(a aVar) {
        this.mChildScrollUpCallback = aVar;
    }

    public void setOnRefreshListener(b bVar) {
        this.mListener = bVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(androidx.core.content.b.a(getContext(), i));
    }

    public void setProgressViewEndTarget(boolean z, int i) {
        this.mSpinnerOffsetEnd = i;
        this.mScale = z;
        this.mCircleView.invalidate();
    }

    public void setProgressViewOffset(boolean z, int i, int i2) {
        this.mScale = z;
        this.mOriginalOffsetTop = i;
        this.mSpinnerOffsetEnd = i2;
        this.mUsingCustomStart = true;
        reset();
        this.mRefreshing = false;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            return;
        }
        this.mRefreshing = z;
        setTargetOffsetTopAndBottom((!this.mUsingCustomStart ? this.mSpinnerOffsetEnd + this.mOriginalOffsetTop : this.mSpinnerOffsetEnd) - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        startScaleUpAnimation(this.mRefreshListener);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.a(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public void setSlingshotDistance(int i) {
        this.mCustomSlingshotDistance = i;
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.mCircleView.bringToFront();
        ViewCompat.c(this.mCircleView, i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.b(i);
    }

    void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        this.mScaleDownAnimation = new g(this);
        this.mScaleDownAnimation.setDuration(150L);
        this.mCircleView.a(animationListener);
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    @Override // android.view.View, androidx.core.view.l
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.c();
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new e(this);
        this.mAnimateToCorrectPosition = new j(this);
        this.mAnimateToStartPosition = new k(this);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        createProgressView();
        setChildrenDrawingOrderEnabled(true);
        this.mSpinnerOffsetEnd = (int) (displayMetrics.density * 64.0f);
        this.mTotalDragDistance = this.mSpinnerOffsetEnd;
        this.mNestedScrollingParentHelper = new q(this);
        this.mNestedScrollingChildHelper = new m(this);
        setNestedScrollingEnabled(true);
        int i = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i;
        this.mOriginalOffsetTop = i;
        moveToStart(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (this.mRefreshing) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                startScaleDownAnimation(this.mRefreshListener);
            }
        }
    }
}
