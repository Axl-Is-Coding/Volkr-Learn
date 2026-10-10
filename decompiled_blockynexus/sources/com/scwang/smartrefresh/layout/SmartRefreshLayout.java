package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import cn.qqtheme.framework.widget.WheelView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements androidx.core.view.p, com.scwang.smartrefresh.layout.a.j {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected static com.scwang.smartrefresh.layout.a.a sFooterCreator;
    protected static com.scwang.smartrefresh.layout.a.b sHeaderCreator;
    protected static com.scwang.smartrefresh.layout.a.c sRefreshInitializer;
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected com.scwang.smartrefresh.layout.constant.a mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected com.scwang.smartrefresh.layout.constant.a mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected com.scwang.smartrefresh.layout.a.i mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected com.scwang.smartrefresh.layout.b.b mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected androidx.core.view.m mNestedChild;
    protected boolean mNestedInProgress;
    protected androidx.core.view.q mNestedParent;
    protected com.scwang.smartrefresh.layout.b.c mOnMultiPurposeListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected com.scwang.smartrefresh.layout.a.e mRefreshContent;
    protected com.scwang.smartrefresh.layout.a.h mRefreshFooter;
    protected com.scwang.smartrefresh.layout.a.h mRefreshHeader;
    protected com.scwang.smartrefresh.layout.b.d mRefreshListener;
    protected int mScreenHeightPixels;
    protected com.scwang.smartrefresh.layout.a.k mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected RefreshState mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    protected class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19120c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f19123f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19118a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19119b = 10;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f19122e = WheelView.DividerConfig.FILL;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f19121d = AnimationUtils.currentAnimationTimeMillis();

        a(float f2, int i) {
            this.f19123f = f2;
            this.f19120c = i;
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.f19119b);
            if (f2 > WheelView.DividerConfig.FILL) {
                SmartRefreshLayout.this.mKernel.a(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.a(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.mSpinner) < Math.abs(this.f19120c)) {
                double d2 = this.f19123f;
                this.f19118a = this.f19118a + 1;
                double dPow = Math.pow(0.949999988079071d, r4 * 2);
                Double.isNaN(d2);
                this.f19123f = (float) (d2 * dPow);
            } else if (this.f19120c != 0) {
                double d3 = this.f19123f;
                this.f19118a = this.f19118a + 1;
                double dPow2 = Math.pow(0.44999998807907104d, r4 * 2);
                Double.isNaN(d3);
                this.f19123f = (float) (d3 * dPow2);
            } else {
                double d4 = this.f19123f;
                this.f19118a = this.f19118a + 1;
                double dPow3 = Math.pow(0.8500000238418579d, r4 * 2);
                Double.isNaN(d4);
                this.f19123f = (float) (d4 * dPow3);
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f2 = this.f19123f * (((jCurrentAnimationTimeMillis - this.f19121d) * 1.0f) / 1000.0f);
            if (Math.abs(f2) >= 1.0f) {
                this.f19121d = jCurrentAnimationTimeMillis;
                this.f19122e += f2;
                SmartRefreshLayout.this.moveSpinnerInfinitely(this.f19122e);
                SmartRefreshLayout.this.mHandler.postDelayed(this, this.f19119b);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout2.mViceState;
            if (refreshState.isDragging && refreshState.isHeader) {
                smartRefreshLayout2.mKernel.a(RefreshState.PullDownCanceled);
            } else {
                SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                RefreshState refreshState2 = smartRefreshLayout3.mViceState;
                if (refreshState2.isDragging && refreshState2.isFooter) {
                    smartRefreshLayout3.mKernel.a(RefreshState.PullUpCanceled);
                }
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            smartRefreshLayout4.animationRunnable = null;
            if (Math.abs(smartRefreshLayout4.mSpinner) >= Math.abs(this.f19120c)) {
                int iMin = Math.min(Math.max((int) com.scwang.smartrefresh.layout.c.c.a(Math.abs(SmartRefreshLayout.this.mSpinner - this.f19120c)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                smartRefreshLayout5.animSpinner(this.f19120c, 0, smartRefreshLayout5.mReboundInterpolator, iMin);
            }
        }
    }

    protected class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19124a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f19127d;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19125b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f19126c = 10;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f19128e = 0.98f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f19129f = 0;
        long g = AnimationUtils.currentAnimationTimeMillis();

        b(float f2) {
            this.f19127d = f2;
            this.f19124a = SmartRefreshLayout.this.mSpinner;
        }

        /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
        
            if (r0 < (-r1.mFooterHeight)) goto L48;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Runnable a() {
            /*
                r11 = this;
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                boolean r2 = r1.isFinishing
                r3 = 0
                if (r2 == 0) goto La
                return r3
            La:
                int r2 = r0.mSpinner
                if (r2 == 0) goto Lb5
                boolean r1 = r1.isOpening
                if (r1 != 0) goto L26
                boolean r1 = r0.mFooterNoMoreData
                if (r1 == 0) goto L59
                boolean r1 = r0.mEnableFooterFollowWhenNoMoreData
                if (r1 == 0) goto L59
                boolean r1 = r0.mFooterNoMoreDataEffective
                if (r1 == 0) goto L59
                boolean r1 = r0.mEnableLoadMore
                boolean r0 = r0.isEnableRefreshOrLoadMore(r1)
                if (r0 == 0) goto L59
            L26:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading
                if (r1 == r2) goto L42
                boolean r1 = r0.mFooterNoMoreData
                if (r1 == 0) goto L4b
                boolean r1 = r0.mEnableFooterFollowWhenNoMoreData
                if (r1 == 0) goto L4b
                boolean r1 = r0.mFooterNoMoreDataEffective
                if (r1 == 0) goto L4b
                boolean r1 = r0.mEnableLoadMore
                boolean r0 = r0.isEnableRefreshOrLoadMore(r1)
                if (r0 == 0) goto L4b
            L42:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r0.mSpinner
                int r0 = r0.mFooterHeight
                int r0 = -r0
                if (r1 < r0) goto L59
            L4b:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = r0.mState
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r1 != r2) goto Lb5
                int r1 = r0.mSpinner
                int r0 = r0.mHeaderHeight
                if (r1 <= r0) goto Lb5
            L59:
                r0 = 0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r1 = r1.mSpinner
                float r2 = r11.f19127d
                r0 = r1
                r4 = 0
            L62:
                int r5 = r1 * r0
                if (r5 <= 0) goto Lb5
                double r5 = (double) r2
                float r2 = r11.f19128e
                double r7 = (double) r2
                int r4 = r4 + 1
                int r2 = r11.f19126c
                int r2 = r2 * r4
                float r2 = (float) r2
                r9 = 1092616192(0x41200000, float:10.0)
                float r2 = r2 / r9
                double r9 = (double) r2
                double r7 = java.lang.Math.pow(r7, r9)
                java.lang.Double.isNaN(r5)
                double r5 = r5 * r7
                float r2 = (float) r5
                int r5 = r11.f19126c
                float r5 = (float) r5
                r6 = 1065353216(0x3f800000, float:1.0)
                float r5 = r5 * r6
                r7 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r7
                float r5 = r5 * r2
                float r7 = java.lang.Math.abs(r5)
                int r6 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
                if (r6 >= 0) goto Lb1
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r1.mState
                boolean r4 = r2.isOpening
                if (r4 == 0) goto Lb0
                com.scwang.smartrefresh.layout.constant.RefreshState r4 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r2 != r4) goto La3
                int r1 = r1.mHeaderHeight
                if (r0 > r1) goto Lb0
            La3:
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r2 = r1.mState
                com.scwang.smartrefresh.layout.constant.RefreshState r4 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing
                if (r2 == r4) goto Lb5
                int r1 = r1.mFooterHeight
                int r1 = -r1
                if (r0 >= r1) goto Lb5
            Lb0:
                return r3
            Lb1:
                float r0 = (float) r0
                float r0 = r0 + r5
                int r0 = (int) r0
                goto L62
            Lb5:
                long r0 = android.view.animation.AnimationUtils.currentAnimationTimeMillis()
                r11.f19129f = r0
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.os.Handler r0 = r0.mHandler
                int r1 = r11.f19126c
                long r1 = (long) r1
                r0.postDelayed(r11, r1)
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.b.a():java.lang.Runnable");
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = jCurrentAnimationTimeMillis - this.g;
            double d2 = this.f19127d;
            double dPow = Math.pow(this.f19128e, (jCurrentAnimationTimeMillis - this.f19129f) / (1000.0f / this.f19126c));
            Double.isNaN(d2);
            this.f19127d = (float) (d2 * dPow);
            float f2 = this.f19127d * ((j * 1.0f) / 1000.0f);
            if (Math.abs(f2) <= 1.0f) {
                SmartRefreshLayout.this.animationRunnable = null;
                return;
            }
            this.g = jCurrentAnimationTimeMillis;
            this.f19124a = (int) (this.f19124a + f2);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int i = smartRefreshLayout2.mSpinner;
            int i2 = this.f19124a;
            if (i * i2 > 0) {
                smartRefreshLayout2.mKernel.a(i2, true);
                SmartRefreshLayout.this.mHandler.postDelayed(this, this.f19126c);
                return;
            }
            smartRefreshLayout2.animationRunnable = null;
            smartRefreshLayout2.mKernel.a(0, true);
            com.scwang.smartrefresh.layout.c.c.b(SmartRefreshLayout.this.mRefreshContent.a(), (int) (-this.f19127d));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.mFooterLocked || f2 <= WheelView.DividerConfig.FILL) {
                return;
            }
            smartRefreshLayout3.mFooterLocked = false;
        }
    }

    public class c implements com.scwang.smartrefresh.layout.a.i {
        public c() {
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public com.scwang.smartrefresh.layout.a.i a(RefreshState refreshState) {
            switch (com.scwang.smartrefresh.layout.a.f19131a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.mState;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.mSpinner == 0) {
                        smartRefreshLayout.notifyStateChanged(refreshState3);
                    } else if (SmartRefreshLayout.this.mSpinner != 0) {
                        a(0);
                    }
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.mState.isOpening && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.mState;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.mFooterNoMoreData || !smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout4.mFooterNoMoreDataEffective)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullUpToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.mState.isOpening && smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        a(RefreshState.None);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.mState.isOpening && (!smartRefreshLayout7.mFooterNoMoreData || !smartRefreshLayout7.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout7.mFooterNoMoreDataEffective)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullUpCanceled);
                            a(RefreshState.None);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.mState.isOpening && smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    }
                    break;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.mState;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.mFooterNoMoreData || !smartRefreshLayout10.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout10.mFooterNoMoreDataEffective)) {
                            SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.mState.isOpening && smartRefreshLayout11.isEnableRefreshOrLoadMore(smartRefreshLayout11.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.mState.isOpening && smartRefreshLayout12.isEnableRefreshOrLoadMore(smartRefreshLayout12.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.mState.isOpening && smartRefreshLayout13.isEnableRefreshOrLoadMore(smartRefreshLayout13.mEnableLoadMore)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    break;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    break;
                case 13:
                    SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                    if (smartRefreshLayout14.mState == RefreshState.Refreshing) {
                        smartRefreshLayout14.notifyStateChanged(RefreshState.RefreshFinish);
                    }
                    break;
                case 14:
                    SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                    if (smartRefreshLayout15.mState == RefreshState.Loading) {
                        smartRefreshLayout15.notifyStateChanged(RefreshState.LoadFinish);
                    }
                    break;
                case 15:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelReleased);
                    break;
                case 16:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelFinish);
                    break;
                case 17:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevel);
                    break;
            }
            return null;
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public com.scwang.smartrefresh.layout.a.j b() {
            return SmartRefreshLayout.this;
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public com.scwang.smartrefresh.layout.a.i b(int i) {
            SmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // com.scwang.smartrefresh.layout.a.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.scwang.smartrefresh.layout.a.i a(boolean r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L28
                com.scwang.smartrefresh.layout.q r4 = new com.scwang.smartrefresh.layout.q
                r4.<init>(r3)
                com.scwang.smartrefresh.layout.SmartRefreshLayout r0 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                int r0 = r0.getMeasuredHeight()
                android.animation.ValueAnimator r0 = r3.a(r0)
                if (r0 == 0) goto L23
                com.scwang.smartrefresh.layout.SmartRefreshLayout r1 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                android.animation.ValueAnimator r2 = r1.reboundAnimator
                if (r0 != r2) goto L23
                int r1 = r1.mFloorDuration
                long r1 = (long) r1
                r0.setDuration(r1)
                r0.addListener(r4)
                goto L36
            L23:
                r0 = 0
                r4.onAnimationEnd(r0)
                goto L36
            L28:
                r4 = 0
                android.animation.ValueAnimator r4 = r3.a(r4)
                if (r4 != 0) goto L36
                com.scwang.smartrefresh.layout.SmartRefreshLayout r4 = com.scwang.smartrefresh.layout.SmartRefreshLayout.this
                com.scwang.smartrefresh.layout.constant.RefreshState r0 = com.scwang.smartrefresh.layout.constant.RefreshState.None
                r4.notifyStateChanged(r0)
            L36:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.c.a(boolean):com.scwang.smartrefresh.layout.a.i");
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public com.scwang.smartrefresh.layout.a.i a() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mState == RefreshState.TwoLevel) {
                smartRefreshLayout.mKernel.a(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    a(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    a(0).setDuration(SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00c1  */
        @Override // com.scwang.smartrefresh.layout.a.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.scwang.smartrefresh.layout.a.i a(int r19, boolean r20) {
            /*
                Method dump skipped, instruction units count: 917
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.c.a(int, boolean):com.scwang.smartrefresh.layout.a.i");
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public ValueAnimator a(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i, 0, smartRefreshLayout.mReboundInterpolator, smartRefreshLayout.mReboundDuration);
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public com.scwang.smartrefresh.layout.a.i a(com.scwang.smartrefresh.layout.a.h hVar, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mPaint == null && i != 0) {
                smartRefreshLayout.mPaint = new Paint();
            }
            if (hVar.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else if (hVar.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public com.scwang.smartrefresh.layout.a.i a(com.scwang.smartrefresh.layout.a.h hVar, boolean z) {
            if (hVar.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            } else if (hVar.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.a.i
        public com.scwang.smartrefresh.layout.a.i a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (hVar.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                com.scwang.smartrefresh.layout.constant.a aVar = smartRefreshLayout.mHeaderHeightStatus;
                if (aVar.o) {
                    smartRefreshLayout.mHeaderHeightStatus = aVar.b();
                }
            } else if (hVar.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                com.scwang.smartrefresh.layout.constant.a aVar2 = smartRefreshLayout2.mFooterHeightStatus;
                if (aVar2.o) {
                    smartRefreshLayout2.mFooterHeightStatus = aVar2.b();
                }
            }
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(com.scwang.smartrefresh.layout.a.a aVar) {
        sFooterCreator = aVar;
    }

    public static void setDefaultRefreshHeaderCreator(com.scwang.smartrefresh.layout.a.b bVar) {
        sHeaderCreator = bVar;
    }

    public static void setDefaultRefreshInitializer(com.scwang.smartrefresh.layout.a.c cVar) {
        sRefreshInitializer = cVar;
    }

    protected ValueAnimator animSpinner(int i, int i2, Interpolator interpolator, int i3) {
        if (this.mSpinner == i) {
            return null;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animationRunnable = null;
        this.reboundAnimator = ValueAnimator.ofInt(this.mSpinner, i);
        this.reboundAnimator.setDuration(i3);
        this.reboundAnimator.setInterpolator(interpolator);
        this.reboundAnimator.addListener(new d(this));
        this.reboundAnimator.addUpdateListener(new e(this));
        this.reboundAnimator.setStartDelay(i2);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    protected void animSpinnerBounce(float f2) {
        RefreshState refreshState;
        if (this.reboundAnimator == null) {
            if (f2 > WheelView.DividerConfig.FILL && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.animationRunnable = new a(f2, this.mHeaderHeight);
                return;
            }
            if (f2 < WheelView.DividerConfig.FILL && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != RefreshState.Refreshing)))) {
                this.animationRunnable = new a(f2, -this.mFooterHeight);
            } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
                this.animationRunnable = new a(f2, 0);
            }
        }
    }

    public boolean autoLoadMore() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f2 = i2 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f2 / i2, false);
    }

    public boolean autoLoadMoreAnimationOnly() {
        int i = this.mReboundDuration;
        int i2 = this.mFooterHeight;
        float f2 = i2 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i2 == 0) {
            i2 = 1;
        }
        return autoLoadMore(0, i, f2 / i2, true);
    }

    public boolean autoRefresh() {
        int i = this.mAttachedToWindow ? 0 : 400;
        int i2 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i3 = this.mHeaderHeight;
        float f3 = f2 * i3 * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f3 / i3, false);
    }

    public boolean autoRefreshAnimationOnly() {
        int i = this.mAttachedToWindow ? 0 : 400;
        int i2 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i3 = this.mHeaderHeight;
        float f3 = f2 * i3 * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f3 / i3, true);
    }

    public com.scwang.smartrefresh.layout.a.j closeHeaderOrFooter() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.Refreshing) {
            finishRefresh();
        } else if (refreshState == RefreshState.Loading) {
            finishLoadMore();
        } else if (this.mSpinner != 0) {
            animSpinner(0, 0, this.mReboundInterpolator, this.mReboundDuration);
        }
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY >= 0 || !((this.mEnableRefresh || this.mEnableOverScrollDrag) && this.mRefreshContent.b())) && (finalY <= 0 || !((this.mEnableLoadMore || this.mEnableOverScrollDrag) && this.mRefreshContent.c()))) {
                this.mVerticalPermit = true;
                invalidate();
            } else {
                if (this.mVerticalPermit) {
                    animSpinnerBounce(Build.VERSION.SDK_INT >= 14 ? finalY > 0 ? -this.mScroller.getCurrVelocity() : this.mScroller.getCurrVelocity() : ((this.mScroller.getCurrY() - finalY) * 1.0f) / Math.max(this.mScroller.getDuration() - this.mScroller.timePassed(), 1));
                }
                this.mScroller.forceFinished(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e0, code lost:
    
        if (r22.mState.isFooter == false) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ce  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instruction units count: 871
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.SmartRefreshLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        Paint paint;
        Paint paint2;
        com.scwang.smartrefresh.layout.a.e eVar = this.mRefreshContent;
        View view2 = eVar != null ? eVar.getView() : null;
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
        if (hVar != null && hVar.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i = this.mHeaderBackgroundColor;
                if (i != 0 && (paint2 = this.mPaint) != null) {
                    paint2.setColor(i);
                    if (this.mRefreshHeader.getSpinnerStyle().i) {
                        iMax = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19149a) {
                        iMax = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(WheelView.DividerConfig.FILL, view.getTop(), getWidth(), iMax, this.mPaint);
                }
                if (this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19151c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
        if (hVar2 != null && hVar2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i2 = this.mFooterBackgroundColor;
                if (i2 != 0 && (paint = this.mPaint) != null) {
                    paint.setColor(i2);
                    if (this.mRefreshFooter.getSpinnerStyle().i) {
                        iMin = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19149a) {
                        iMin = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(WheelView.DividerConfig.FILL, iMin, getWidth(), view.getBottom(), this.mPaint);
                }
                if (this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19151c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j);
    }

    public com.scwang.smartrefresh.layout.a.j finishLoadMore() {
        return finishLoadMore(true);
    }

    public com.scwang.smartrefresh.layout.a.j finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, true);
    }

    public com.scwang.smartrefresh.layout.a.j finishRefresh() {
        return finishRefresh(true);
    }

    public com.scwang.smartrefresh.layout.a.j finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.a.j
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mNestedParent.a();
    }

    public com.scwang.smartrefresh.layout.a.f getRefreshFooter() {
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshFooter;
        if (hVar instanceof com.scwang.smartrefresh.layout.a.f) {
            return (com.scwang.smartrefresh.layout.a.f) hVar;
        }
        return null;
    }

    public com.scwang.smartrefresh.layout.a.g getRefreshHeader() {
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
        if (hVar instanceof com.scwang.smartrefresh.layout.a.g) {
            return (com.scwang.smartrefresh.layout.a.g) hVar;
        }
        return null;
    }

    public RefreshState getState() {
        return this.mState;
    }

    protected boolean interceptAnimatorByAction(int i) {
        if (i == 0) {
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.mKernel.a(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.mKernel.a(RefreshState.PullUpToLoad);
                }
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        return this.reboundAnimator != null;
    }

    protected boolean isEnableRefreshOrLoadMore(boolean z) {
        return z && !this.mEnablePureScrollMode;
    }

    protected boolean isEnableTranslationContent(boolean z, com.scwang.smartrefresh.layout.a.h hVar) {
        return z || this.mEnablePureScrollMode || hVar == null || hVar.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19151c;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mEnableNestedScrolling && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    protected void moveSpinnerInfinitely(float f2) {
        RefreshState refreshState;
        float f3 = (!this.mNestedInProgress || this.mEnableLoadMoreWhenContentNotFull || f2 >= WheelView.DividerConfig.FILL || this.mRefreshContent.c()) ? f2 : WheelView.DividerConfig.FILL;
        if (f3 > this.mScreenHeightPixels * 5 && getTag() == null) {
            Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
            setTag("你这么死拉，臣妾做不到啊！");
        }
        if (this.mState == RefreshState.TwoLevel && f3 > WheelView.DividerConfig.FILL) {
            this.mKernel.a(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (this.mState == RefreshState.Refreshing && f3 >= WheelView.DividerConfig.FILL) {
            int i = this.mHeaderHeight;
            if (f3 < i) {
                this.mKernel.a((int) f3, true);
            } else {
                double d2 = (this.mHeaderMaxDragRate - 1.0f) * i;
                int iMax = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i2 = this.mHeaderHeight;
                double d3 = iMax - i2;
                double dMax = Math.max(WheelView.DividerConfig.FILL, (f3 - i2) * this.mDragRate);
                Double.isNaN(dMax);
                double d4 = -dMax;
                if (d3 == 0.0d) {
                    d3 = 1.0d;
                }
                double dPow = 1.0d - Math.pow(100.0d, d4 / d3);
                Double.isNaN(d2);
                this.mKernel.a(((int) Math.min(d2 * dPow, dMax)) + this.mHeaderHeight, true);
            }
        } else if (f3 < WheelView.DividerConfig.FILL && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i3 = this.mFooterHeight;
            if (f3 > (-i3)) {
                this.mKernel.a((int) f3, true);
            } else {
                double d5 = (this.mFooterMaxDragRate - 1.0f) * i3;
                int iMax2 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i4 = this.mFooterHeight;
                double d6 = iMax2 - i4;
                double d7 = -Math.min(WheelView.DividerConfig.FILL, (i4 + f3) * this.mDragRate);
                Double.isNaN(d7);
                double d8 = -d7;
                if (d6 == 0.0d) {
                    d6 = 1.0d;
                }
                double dPow2 = 1.0d - Math.pow(100.0d, d8 / d6);
                Double.isNaN(d5);
                this.mKernel.a(((int) (-Math.min(d5 * dPow2, d7))) - this.mFooterHeight, true);
            }
        } else if (f3 >= WheelView.DividerConfig.FILL) {
            double d9 = this.mHeaderMaxDragRate * this.mHeaderHeight;
            double dMax2 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double dMax3 = Math.max(WheelView.DividerConfig.FILL, this.mDragRate * f3);
            Double.isNaN(dMax3);
            double d10 = -dMax3;
            if (dMax2 == 0.0d) {
                dMax2 = 1.0d;
            }
            double dPow3 = 1.0d - Math.pow(100.0d, d10 / dMax2);
            Double.isNaN(d9);
            this.mKernel.a((int) Math.min(d9 * dPow3, dMax3), true);
        } else {
            double d11 = this.mFooterMaxDragRate * this.mFooterHeight;
            double dMax4 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d12 = -Math.min(WheelView.DividerConfig.FILL, this.mDragRate * f3);
            Double.isNaN(d12);
            double d13 = -d12;
            if (dMax4 == 0.0d) {
                dMax4 = 1.0d;
            }
            double dPow4 = 1.0d - Math.pow(100.0d, d13 / dMax4);
            Double.isNaN(d11);
            this.mKernel.a((int) (-Math.min(d11 * dPow4, d12)), true);
        }
        if (!this.mEnableAutoLoadMore || this.mFooterNoMoreData || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || f3 >= WheelView.DividerConfig.FILL || (refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        if (this.mDisableContentWhenLoading) {
            this.animationRunnable = null;
            this.mKernel.a(-this.mFooterHeight);
        }
        setStateDirectLoading(false);
        this.mHandler.postDelayed(new f(this), this.mReboundDuration);
    }

    protected void notifyStateChanged(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == refreshState) {
            if (this.mViceState != refreshState2) {
                this.mViceState = refreshState2;
                return;
            }
            return;
        }
        this.mState = refreshState;
        this.mViceState = refreshState;
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
        com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
        com.scwang.smartrefresh.layout.b.c cVar = this.mOnMultiPurposeListener;
        if (hVar != null) {
            hVar.onStateChanged(this, refreshState2, refreshState);
        }
        if (hVar2 != null) {
            hVar2.onStateChanged(this, refreshState2, refreshState);
        }
        if (cVar != null) {
            cVar.onStateChanged(this, refreshState2, refreshState);
        }
        if (refreshState == RefreshState.LoadFinish) {
            this.mFooterLocked = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        com.scwang.smartrefresh.layout.a.h hVar;
        super.onAttachedToWindow();
        boolean z = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            if (this.mRefreshHeader == null) {
                com.scwang.smartrefresh.layout.a.b bVar = sHeaderCreator;
                if (bVar != null) {
                    setRefreshHeader(bVar.a(getContext(), this));
                } else {
                    setRefreshHeader(new BezierRadarHeader(getContext()));
                }
            }
            if (this.mRefreshFooter == null) {
                com.scwang.smartrefresh.layout.a.a aVar = sFooterCreator;
                if (aVar != null) {
                    setRefreshFooter(aVar.a(getContext(), this));
                } else {
                    boolean z2 = this.mEnableLoadMore;
                    setRefreshFooter(new BallPulseFooter(getContext()));
                    this.mEnableLoadMore = z2;
                }
            } else {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z = false;
                }
                this.mEnableLoadMore = z;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshHeader;
                    if ((hVar2 == null || childAt != hVar2.getView()) && ((hVar = this.mRefreshFooter) == null || childAt != hVar.getView())) {
                        this.mRefreshContent = new com.scwang.smartrefresh.layout.impl.a(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int iA = com.scwang.smartrefresh.layout.c.c.a(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, 0, new LayoutParams(-1, -1));
                this.mRefreshContent = new com.scwang.smartrefresh.layout.impl.a(textView);
                this.mRefreshContent.getView().setPadding(iA, iA, iA, iA);
            }
            View viewFindViewById = findViewById(this.mFixedHeaderViewId);
            View viewFindViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.a(this.mScrollBoundaryDecider);
            this.mRefreshContent.a(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.a(this.mKernel, viewFindViewById, viewFindViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                com.scwang.smartrefresh.layout.a.e eVar = this.mRefreshContent;
                this.mSpinner = 0;
                eVar.a(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            com.scwang.smartrefresh.layout.a.h hVar3 = this.mRefreshHeader;
            if (hVar3 != null) {
                hVar3.setPrimaryColors(iArr);
            }
            com.scwang.smartrefresh.layout.a.h hVar4 = this.mRefreshFooter;
            if (hVar4 != null) {
                hVar4.setPrimaryColors(this.mPrimaryColors);
            }
        }
        com.scwang.smartrefresh.layout.a.e eVar2 = this.mRefreshContent;
        if (eVar2 != null) {
            super.bringChildToFront(eVar2.getView());
        }
        com.scwang.smartrefresh.layout.a.h hVar5 = this.mRefreshHeader;
        if (hVar5 != null && hVar5.getSpinnerStyle().h) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        com.scwang.smartrefresh.layout.a.h hVar6 = this.mRefreshFooter;
        if (hVar6 == null || !hVar6.getSpinnerStyle().h) {
            return;
        }
        super.bringChildToFront(this.mRefreshFooter.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mKernel.a(0, true);
        notifyStateChanged(RefreshState.None);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.mFooterLocked = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        int i;
        int i2;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i3 = 0;
        int i4 = -1;
        char c2 = 0;
        while (true) {
            i = 2;
            if (i3 >= childCount) {
                break;
            }
            View childAt = super.getChildAt(i3);
            if (com.scwang.smartrefresh.layout.c.c.a(childAt) && (c2 < 2 || i3 == 1)) {
                i4 = i3;
                c2 = 2;
            } else if (!(childAt instanceof com.scwang.smartrefresh.layout.a.h) && c2 < 1) {
                i4 = i3;
                c2 = i3 <= 0 ? (char) 0 : (char) 1;
            }
            i3++;
        }
        if (i4 >= 0) {
            this.mRefreshContent = new com.scwang.smartrefresh.layout.impl.a(super.getChildAt(i4));
            if (i4 != 1) {
                if (childCount == 2) {
                    i2 = -1;
                    i = 1;
                }
                i2 = -1;
                i = -1;
            } else if (childCount == 3) {
                i2 = 0;
            } else {
                i2 = 0;
                i = -1;
            }
        } else {
            i2 = -1;
            i = -1;
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = super.getChildAt(i5);
            if (i5 == i2 || (i5 != i && i2 == -1 && this.mRefreshHeader == null && (childAt2 instanceof com.scwang.smartrefresh.layout.a.g))) {
                this.mRefreshHeader = childAt2 instanceof com.scwang.smartrefresh.layout.a.g ? (com.scwang.smartrefresh.layout.a.g) childAt2 : new RefreshHeaderWrapper(childAt2);
            } else if (i5 == i || (i == -1 && (childAt2 instanceof com.scwang.smartrefresh.layout.a.f))) {
                this.mEnableLoadMore = this.mEnableLoadMore || !this.mManualLoadMore;
                this.mRefreshFooter = childAt2 instanceof com.scwang.smartrefresh.layout.a.f ? (com.scwang.smartrefresh.layout.a.f) childAt2 : new RefreshFooterWrapper(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = super.getChildAt(i5);
            if (childAt.getVisibility() != 8 && childAt.getTag(R.string.srl_component_falsify) != childAt) {
                com.scwang.smartrefresh.layout.a.e eVar = this.mRefreshContent;
                if (eVar != null && eVar.getView() == childAt) {
                    boolean z2 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null;
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i6 = marginLayoutParams.leftMargin + paddingLeft;
                    int i7 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i6;
                    int measuredHeight = view.getMeasuredHeight() + i7;
                    if (z2 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i8 = this.mHeaderHeight;
                        i7 += i8;
                        measuredHeight += i8;
                    }
                    view.layout(i6, i7, measuredWidth, measuredHeight);
                }
                com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
                if (hVar != null && hVar.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh);
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int i9 = marginLayoutParams2.leftMargin;
                    int i10 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i9;
                    int measuredHeight2 = view2.getMeasuredHeight() + i10;
                    if (!z3 && this.mRefreshHeader.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19149a) {
                        int i11 = this.mHeaderHeight;
                        i10 -= i11;
                        measuredHeight2 -= i11;
                    }
                    view2.layout(i9, i10, measuredWidth2, measuredHeight2);
                }
                com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
                if (hVar2 != null && hVar2.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableLoadMore);
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    com.scwang.smartrefresh.layout.constant.b spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i12 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19149a && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f19153e) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.mFooterInsetStart;
                    } else {
                        if (z4 || spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f19152d || spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f19151c) {
                            iMax = this.mFooterHeight;
                        } else if (spinnerStyle.i && this.mSpinner < 0) {
                            iMax = Math.max(isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0, 0);
                        }
                        measuredHeight3 -= iMax;
                    }
                    view3.layout(i12, measuredHeight3, view3.getMeasuredWidth() + i12, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z = isInEditMode() && this.mEnablePreviewInEditMode;
        int childCount = super.getChildCount();
        int measuredHeight = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = super.getChildAt(i7);
            if (childAt.getVisibility() != 8 && childAt.getTag(R.string.srl_component_falsify) != childAt) {
                com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
                if (hVar != null && hVar.getView() == childAt) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int iMax = this.mHeaderHeight;
                    com.scwang.smartrefresh.layout.constant.a aVar = this.mHeaderHeightStatus;
                    if (aVar.n < com.scwang.smartrefresh.layout.constant.a.g.n) {
                        int i8 = layoutParams.height;
                        if (i8 > 0) {
                            iMax = i8 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            if (aVar.a(com.scwang.smartrefresh.layout.constant.a.f19147e)) {
                                this.mHeaderHeight = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.mHeaderHeightStatus = com.scwang.smartrefresh.layout.constant.a.f19147e;
                            }
                        } else if (i8 == -2 && (this.mRefreshHeader.getSpinnerStyle() != com.scwang.smartrefresh.layout.constant.b.f19153e || !this.mHeaderHeightStatus.o)) {
                            int iMax2 = Math.max((View.MeasureSpec.getSize(i2) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(iMax2, Integer.MIN_VALUE));
                            int measuredHeight2 = view.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != iMax2 && this.mHeaderHeightStatus.a(com.scwang.smartrefresh.layout.constant.a.f19145c)) {
                                    this.mHeaderHeight = measuredHeight2 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                    this.mHeaderHeightStatus = com.scwang.smartrefresh.layout.constant.a.f19145c;
                                }
                                iMax = -1;
                            }
                        }
                    }
                    if (this.mRefreshHeader.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19153e) {
                        iMax = View.MeasureSpec.getSize(i2);
                        i6 = -1;
                        i5 = 0;
                    } else {
                        if (!this.mRefreshHeader.getSpinnerStyle().i || z) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                            iMax = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableRefresh) ? this.mSpinner : 0);
                        }
                        i6 = -1;
                    }
                    if (iMax != i6) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i5), FileTypeUtils.GIGABYTE));
                    }
                    com.scwang.smartrefresh.layout.constant.a aVar2 = this.mHeaderHeightStatus;
                    if (!aVar2.o) {
                        this.mHeaderHeightStatus = aVar2.a();
                        com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshHeader;
                        com.scwang.smartrefresh.layout.a.i iVar = this.mKernel;
                        int i9 = this.mHeaderHeight;
                        hVar2.onInitialized(iVar, i9, (int) (this.mHeaderMaxDragRate * i9));
                    }
                    if (z && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        measuredHeight += view.getMeasuredHeight();
                    }
                }
                com.scwang.smartrefresh.layout.a.h hVar3 = this.mRefreshFooter;
                if (hVar3 != null && hVar3.getView() == childAt) {
                    View view2 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int iMax3 = this.mFooterHeight;
                    com.scwang.smartrefresh.layout.constant.a aVar3 = this.mFooterHeightStatus;
                    if (aVar3.n < com.scwang.smartrefresh.layout.constant.a.g.n) {
                        int i10 = layoutParams2.height;
                        if (i10 > 0) {
                            iMax3 = marginLayoutParams2.bottomMargin + i10 + marginLayoutParams2.topMargin;
                            if (aVar3.a(com.scwang.smartrefresh.layout.constant.a.f19147e)) {
                                this.mFooterHeight = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.mFooterHeightStatus = com.scwang.smartrefresh.layout.constant.a.f19147e;
                            }
                        } else if (i10 == -2 && (this.mRefreshFooter.getSpinnerStyle() != com.scwang.smartrefresh.layout.constant.b.f19153e || !this.mFooterHeightStatus.o)) {
                            int iMax4 = Math.max((View.MeasureSpec.getSize(i2) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(iMax4, Integer.MIN_VALUE));
                            int measuredHeight3 = view2.getMeasuredHeight();
                            if (measuredHeight3 > 0) {
                                if (measuredHeight3 != iMax4 && this.mFooterHeightStatus.a(com.scwang.smartrefresh.layout.constant.a.f19145c)) {
                                    this.mFooterHeight = measuredHeight3 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                    this.mFooterHeightStatus = com.scwang.smartrefresh.layout.constant.a.f19145c;
                                }
                                iMax3 = -1;
                            }
                        }
                    }
                    if (this.mRefreshFooter.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19153e) {
                        iMax3 = View.MeasureSpec.getSize(i2);
                        i4 = -1;
                        i3 = 0;
                    } else {
                        if (!this.mRefreshFooter.getSpinnerStyle().i || z) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                            iMax3 = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0);
                        }
                        i4 = -1;
                    }
                    if (iMax3 != i4) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax3 - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i3), FileTypeUtils.GIGABYTE));
                    }
                    com.scwang.smartrefresh.layout.constant.a aVar4 = this.mFooterHeightStatus;
                    if (!aVar4.o) {
                        this.mFooterHeightStatus = aVar4.a();
                        com.scwang.smartrefresh.layout.a.h hVar4 = this.mRefreshFooter;
                        com.scwang.smartrefresh.layout.a.i iVar2 = this.mKernel;
                        int i11 = this.mFooterHeight;
                        hVar4.onInitialized(iVar2, i11, (int) (this.mFooterMaxDragRate * i11));
                    }
                    if (z && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        measuredHeight += view2.getMeasuredHeight();
                    }
                }
                com.scwang.smartrefresh.layout.a.e eVar = this.mRefreshContent;
                if (eVar != null && eVar.getView() == childAt) {
                    View view3 = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    view3.measure(ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((z && (this.mRefreshHeader != null && isEnableRefreshOrLoadMore(this.mEnableRefresh) && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader))) ? this.mHeaderHeight : 0) + ((z && (this.mRefreshFooter != null && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableFooterTranslationContent, this.mRefreshFooter))) ? this.mFooterHeight : 0), layoutParams3.height));
                    measuredHeight += view3.getMeasuredHeight();
                }
            }
        }
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i), View.resolveSize(measuredHeight, i2));
        this.mLastTouchX = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return this.mNestedChild.a(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return (this.mFooterLocked && f3 > WheelView.DividerConfig.FILL) || startFlingIfNeed(-f3) || this.mNestedChild.a(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int i3;
        int i4 = this.mTotalUnconsumed;
        if (i2 * i4 > 0) {
            if (Math.abs(i2) > Math.abs(this.mTotalUnconsumed)) {
                i3 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
            } else {
                this.mTotalUnconsumed -= i2;
                i3 = i2;
            }
            moveSpinnerInfinitely(this.mTotalUnconsumed);
        } else if (i2 <= 0 || !this.mFooterLocked) {
            i3 = 0;
        } else {
            this.mTotalUnconsumed = i4 - i2;
            moveSpinnerInfinitely(this.mTotalUnconsumed);
            i3 = i2;
        }
        this.mNestedChild.a(i, i2 - i3, iArr, null);
        iArr[1] = iArr[1] + i3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        com.scwang.smartrefresh.layout.a.k kVar;
        com.scwang.smartrefresh.layout.a.k kVar2;
        boolean zA = this.mNestedChild.a(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if ((i5 < 0 && ((this.mEnableRefresh || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (kVar2 = this.mScrollBoundaryDecider) == null || kVar2.a(this.mRefreshContent.getView())))) || (i5 > 0 && ((this.mEnableLoadMore || this.mEnableOverScrollDrag) && (this.mTotalUnconsumed != 0 || (kVar = this.mScrollBoundaryDecider) == null || kVar.b(this.mRefreshContent.getView()))))) {
            RefreshState refreshState = this.mViceState;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.mKernel.a(i5 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
                if (!zA) {
                    ViewParent parent = getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                    }
                }
            }
            int i6 = this.mTotalUnconsumed - i5;
            this.mTotalUnconsumed = i6;
            moveSpinnerInfinitely(i6);
        }
        if (!this.mFooterLocked || i2 >= 0) {
            return;
        }
        this.mFooterLocked = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedParent.a(view, view2, i);
        this.mNestedChild.b(i & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (isEnabled() && isNestedScrollingEnabled() && (i & 2) != 0) && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.p
    public void onStopNestedScroll(View view) {
        this.mNestedParent.a(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.c();
    }

    protected void overSpinner() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.mCurrentVelocity <= -1000 || this.mSpinner <= getMeasuredHeight() / 2) {
                if (this.mIsBeingDragged) {
                    this.mKernel.a();
                    return;
                }
                return;
            } else {
                ValueAnimator valueAnimatorA = this.mKernel.a(getMeasuredHeight());
                if (valueAnimatorA != null) {
                    valueAnimatorA.setDuration(this.mFloorDuration);
                    return;
                }
                return;
            }
        }
        if (refreshState == RefreshState.Loading || (this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mSpinner < 0 && isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
            int i = this.mSpinner;
            int i2 = this.mFooterHeight;
            if (i < (-i2)) {
                this.mKernel.a(-i2);
                return;
            } else {
                if (i > 0) {
                    this.mKernel.a(0);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.Refreshing) {
            int i3 = this.mSpinner;
            int i4 = this.mHeaderHeight;
            if (i3 > i4) {
                this.mKernel.a(i4);
                return;
            } else {
                if (i3 < 0) {
                    this.mKernel.a(0);
                    return;
                }
                return;
            }
        }
        if (refreshState2 == RefreshState.PullDownToRefresh) {
            this.mKernel.a(RefreshState.PullDownCanceled);
            return;
        }
        if (refreshState2 == RefreshState.PullUpToLoad) {
            this.mKernel.a(RefreshState.PullUpCanceled);
            return;
        }
        if (refreshState2 == RefreshState.ReleaseToRefresh) {
            this.mKernel.a(RefreshState.Refreshing);
            return;
        }
        if (refreshState2 == RefreshState.ReleaseToLoad) {
            this.mKernel.a(RefreshState.Loading);
            return;
        }
        if (refreshState2 == RefreshState.ReleaseToTwoLevel) {
            this.mKernel.a(RefreshState.TwoLevelReleased);
            return;
        }
        if (refreshState2 == RefreshState.RefreshReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.a(this.mHeaderHeight);
            }
        } else if (refreshState2 == RefreshState.LoadReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.a(-this.mFooterHeight);
            }
        } else if (this.mSpinner != 0) {
            this.mKernel.a(0);
        }
    }

    public com.scwang.smartrefresh.layout.a.j resetNoMoreData() {
        return setNoMoreData(false);
    }

    public com.scwang.smartrefresh.layout.a.j setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.j
    public com.scwang.smartrefresh.layout.a.j setDragRate(float f2) {
        this.mDragRate = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.j
    public com.scwang.smartrefresh.layout.a.j setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    @Deprecated
    public com.scwang.smartrefresh.layout.a.j setEnableFooterFollowWhenLoadFinished(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableFooterFollowWhenNoMoreData(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.j
    public com.scwang.smartrefresh.layout.a.j setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        this.mManualFooterTranslationContent = true;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        com.scwang.smartrefresh.layout.a.e eVar = this.mRefreshContent;
        if (eVar != null) {
            eVar.a(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.j
    public com.scwang.smartrefresh.layout.a.j setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setFooterHeight(float f2) {
        int iA = com.scwang.smartrefresh.layout.c.c.a(f2);
        if (iA != this.mFooterHeight && this.mFooterHeightStatus.a(com.scwang.smartrefresh.layout.constant.a.j)) {
            this.mFooterHeight = iA;
            com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshFooter;
            if (hVar != null && this.mAttachedToWindow && this.mFooterHeightStatus.o) {
                com.scwang.smartrefresh.layout.constant.b spinnerStyle = hVar.getSpinnerStyle();
                if (spinnerStyle != com.scwang.smartrefresh.layout.constant.b.f19153e && !spinnerStyle.i) {
                    View view = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(Math.max((this.mFooterHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), FileTypeUtils.GIGABYTE));
                    int i = marginLayoutParams.leftMargin;
                    int measuredHeight = ((marginLayoutParams.topMargin + getMeasuredHeight()) - this.mFooterInsetStart) - (spinnerStyle != com.scwang.smartrefresh.layout.constant.b.f19149a ? this.mFooterHeight : 0);
                    view.layout(i, measuredHeight, view.getMeasuredWidth() + i, view.getMeasuredHeight() + measuredHeight);
                }
                this.mFooterHeightStatus = com.scwang.smartrefresh.layout.constant.a.j;
                com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
                com.scwang.smartrefresh.layout.a.i iVar = this.mKernel;
                int i2 = this.mFooterHeight;
                hVar2.onInitialized(iVar, i2, (int) (this.mFooterMaxDragRate * i2));
            } else {
                this.mFooterHeightStatus = com.scwang.smartrefresh.layout.constant.a.i;
            }
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setFooterInsetStart(float f2) {
        this.mFooterInsetStart = com.scwang.smartrefresh.layout.c.c.a(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.j
    public com.scwang.smartrefresh.layout.a.j setFooterMaxDragRate(float f2) {
        this.mFooterMaxDragRate = f2;
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshFooter;
        if (hVar == null || !this.mAttachedToWindow) {
            this.mFooterHeightStatus = this.mFooterHeightStatus.b();
        } else {
            com.scwang.smartrefresh.layout.a.i iVar = this.mKernel;
            int i = this.mFooterHeight;
            hVar.onInitialized(iVar, i, (int) (i * this.mFooterMaxDragRate));
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setFooterTriggerRate(float f2) {
        this.mFooterTriggerRate = f2;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setHeaderHeight(float f2) {
        int iA = com.scwang.smartrefresh.layout.c.c.a(f2);
        if (iA != this.mHeaderHeight && this.mHeaderHeightStatus.a(com.scwang.smartrefresh.layout.constant.a.j)) {
            this.mHeaderHeight = iA;
            com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
            if (hVar != null && this.mAttachedToWindow && this.mHeaderHeightStatus.o) {
                com.scwang.smartrefresh.layout.constant.b spinnerStyle = hVar.getSpinnerStyle();
                if (spinnerStyle != com.scwang.smartrefresh.layout.constant.b.f19153e && !spinnerStyle.i) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(Math.max((this.mHeaderHeight - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), FileTypeUtils.GIGABYTE));
                    int i = marginLayoutParams.leftMargin;
                    int i2 = (marginLayoutParams.topMargin + this.mHeaderInsetStart) - (spinnerStyle == com.scwang.smartrefresh.layout.constant.b.f19149a ? this.mHeaderHeight : 0);
                    view.layout(i, i2, view.getMeasuredWidth() + i, view.getMeasuredHeight() + i2);
                }
                this.mHeaderHeightStatus = com.scwang.smartrefresh.layout.constant.a.j;
                com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshHeader;
                com.scwang.smartrefresh.layout.a.i iVar = this.mKernel;
                int i3 = this.mHeaderHeight;
                hVar2.onInitialized(iVar, i3, (int) (this.mHeaderMaxDragRate * i3));
            } else {
                this.mHeaderHeightStatus = com.scwang.smartrefresh.layout.constant.a.i;
            }
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setHeaderInsetStart(float f2) {
        this.mHeaderInsetStart = com.scwang.smartrefresh.layout.c.c.a(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.j
    public com.scwang.smartrefresh.layout.a.j setHeaderMaxDragRate(float f2) {
        this.mHeaderMaxDragRate = f2;
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
        if (hVar == null || !this.mAttachedToWindow) {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.b();
        } else {
            com.scwang.smartrefresh.layout.a.i iVar = this.mKernel;
            int i = this.mHeaderHeight;
            hVar.onInitialized(iVar, i, (int) (this.mHeaderMaxDragRate * i));
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setHeaderTriggerRate(float f2) {
        this.mHeaderTriggerRate = f2;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mEnableNestedScrolling = z;
        this.mNestedChild.a(z);
    }

    public com.scwang.smartrefresh.layout.a.j setNoMoreData(boolean z) {
        if (this.mState == RefreshState.Loading && z) {
            finishLoadMoreWithNoMoreData();
            return this;
        }
        if (this.mFooterNoMoreData != z) {
            this.mFooterNoMoreData = z;
            com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshFooter;
            if (hVar instanceof com.scwang.smartrefresh.layout.a.f) {
                if (((com.scwang.smartrefresh.layout.a.f) hVar).setNoMoreData(z)) {
                    this.mFooterNoMoreDataEffective = true;
                    if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == com.scwang.smartrefresh.layout.constant.b.f19149a && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                        this.mRefreshFooter.getView().setTranslationY(this.mSpinner);
                    }
                } else {
                    this.mFooterNoMoreDataEffective = false;
                    new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(不支持NoMoreData，请使用[ClassicsFooter]或者[自定义Footer并实现setNoMoreData方法且返回true])").printStackTrace();
                }
            }
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setOnLoadMoreListener(com.scwang.smartrefresh.layout.b.b bVar) {
        this.mLoadMoreListener = bVar;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || bVar == null);
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setOnMultiPurposeListener(com.scwang.smartrefresh.layout.b.c cVar) {
        this.mOnMultiPurposeListener = cVar;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setOnRefreshListener(com.scwang.smartrefresh.layout.b.d dVar) {
        this.mRefreshListener = dVar;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setOnRefreshLoadMoreListener(com.scwang.smartrefresh.layout.b.e eVar) {
        this.mRefreshListener = eVar;
        this.mLoadMoreListener = eVar;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || eVar == null);
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setPrimaryColors(int... iArr) {
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
        if (hVar != null) {
            hVar.setPrimaryColors(iArr);
        }
        com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
        if (hVar2 != null) {
            hVar2.setPrimaryColors(iArr);
        }
        this.mPrimaryColors = iArr;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setPrimaryColorsId(int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = androidx.core.content.b.a(getContext(), iArr[i]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setReboundDuration(int i) {
        this.mReboundDuration = i;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setReboundInterpolator(Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setRefreshContent(View view) {
        return setRefreshContent(view, -1, -1);
    }

    public com.scwang.smartrefresh.layout.a.j setRefreshFooter(com.scwang.smartrefresh.layout.a.f fVar) {
        return setRefreshFooter(fVar, -1, -2);
    }

    public com.scwang.smartrefresh.layout.a.j setRefreshHeader(com.scwang.smartrefresh.layout.a.g gVar) {
        return setRefreshHeader(gVar, -1, -2);
    }

    public com.scwang.smartrefresh.layout.a.j setScrollBoundaryDecider(com.scwang.smartrefresh.layout.a.k kVar) {
        this.mScrollBoundaryDecider = kVar;
        com.scwang.smartrefresh.layout.a.e eVar = this.mRefreshContent;
        if (eVar != null) {
            eVar.a(kVar);
        }
        return this;
    }

    protected void setStateDirectLoading(boolean z) {
        if (this.mState != RefreshState.Loading) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(RefreshState.Loading);
            com.scwang.smartrefresh.layout.b.b bVar = this.mLoadMoreListener;
            if (bVar != null) {
                if (z) {
                    bVar.a(this);
                }
            } else if (this.mOnMultiPurposeListener == null) {
                finishLoadMore(2000);
            }
            com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshFooter;
            if (hVar != null) {
                int i = this.mFooterHeight;
                hVar.onStartAnimator(this, i, (int) (this.mFooterMaxDragRate * i));
            }
            com.scwang.smartrefresh.layout.b.c cVar = this.mOnMultiPurposeListener;
            if (cVar == null || !(this.mRefreshFooter instanceof com.scwang.smartrefresh.layout.a.f)) {
                return;
            }
            if (z) {
                cVar.a(this);
            }
            com.scwang.smartrefresh.layout.b.c cVar2 = this.mOnMultiPurposeListener;
            com.scwang.smartrefresh.layout.a.f fVar = (com.scwang.smartrefresh.layout.a.f) this.mRefreshFooter;
            int i2 = this.mFooterHeight;
            cVar2.a(fVar, i2, (int) (this.mFooterMaxDragRate * i2));
        }
    }

    protected void setStateLoading(boolean z) {
        com.scwang.smartrefresh.layout.b bVar = new com.scwang.smartrefresh.layout.b(this, z);
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator valueAnimatorA = this.mKernel.a(-this.mFooterHeight);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(bVar);
        }
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshFooter;
        if (hVar != null) {
            int i = this.mFooterHeight;
            hVar.onReleased(this, i, (int) (this.mFooterMaxDragRate * i));
        }
        com.scwang.smartrefresh.layout.b.c cVar = this.mOnMultiPurposeListener;
        if (cVar != null) {
            com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
            if (hVar2 instanceof com.scwang.smartrefresh.layout.a.f) {
                int i2 = this.mFooterHeight;
                cVar.b((com.scwang.smartrefresh.layout.a.f) hVar2, i2, (int) (this.mFooterMaxDragRate * i2));
            }
        }
        if (valueAnimatorA == null) {
            bVar.onAnimationEnd(null);
        }
    }

    protected void setStateRefreshing(boolean z) {
        com.scwang.smartrefresh.layout.c cVar = new com.scwang.smartrefresh.layout.c(this, z);
        notifyStateChanged(RefreshState.RefreshReleased);
        ValueAnimator valueAnimatorA = this.mKernel.a(this.mHeaderHeight);
        if (valueAnimatorA != null) {
            valueAnimatorA.addListener(cVar);
        }
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
        if (hVar != null) {
            int i = this.mHeaderHeight;
            hVar.onReleased(this, i, (int) (this.mHeaderMaxDragRate * i));
        }
        com.scwang.smartrefresh.layout.b.c cVar2 = this.mOnMultiPurposeListener;
        if (cVar2 != null) {
            com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshHeader;
            if (hVar2 instanceof com.scwang.smartrefresh.layout.a.g) {
                int i2 = this.mHeaderHeight;
                cVar2.a((com.scwang.smartrefresh.layout.a.g) hVar2, i2, (int) (this.mHeaderMaxDragRate * i2));
            }
        }
        if (valueAnimatorA == null) {
            cVar.onAnimationEnd(null);
        }
    }

    protected void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            notifyStateChanged(RefreshState.None);
        }
        if (this.mViceState != refreshState) {
            this.mViceState = refreshState;
        }
    }

    protected boolean startFlingIfNeed(float f2) {
        if (f2 == WheelView.DividerConfig.FILL) {
            f2 = this.mCurrentVelocity;
        }
        if (Build.VERSION.SDK_INT > 27 && this.mRefreshContent != null) {
            getScaleY();
            View view = this.mRefreshContent.getView();
            if (getScaleY() == -1.0f && view.getScaleY() == -1.0f) {
                f2 = -f2;
            }
        }
        if (Math.abs(f2) > this.mMinimumVelocity) {
            int i = this.mSpinner;
            if (i * f2 < WheelView.DividerConfig.FILL) {
                RefreshState refreshState = this.mState;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i < 0 && this.mFooterNoMoreData)) {
                    this.animationRunnable = new b(f2).a();
                    return true;
                }
                if (this.mState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f2 < WheelView.DividerConfig.FILL && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == RefreshState.Loading && this.mSpinner >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f2 > WheelView.DividerConfig.FILL && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFloorDuration = 300;
        this.mReboundDuration = 300;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new androidx.core.view.m(this);
        this.mNestedParent = new androidx.core.view.q(this);
        com.scwang.smartrefresh.layout.constant.a aVar = com.scwang.smartrefresh.layout.constant.a.f19143a;
        this.mHeaderHeightStatus = aVar;
        this.mFooterHeightStatus = aVar;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mKernel = new c();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0L;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler();
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = context.getResources().getDisplayMetrics().heightPixels;
        this.mReboundInterpolator = new com.scwang.smartrefresh.layout.c.c(com.scwang.smartrefresh.layout.c.c.f19137a);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = com.scwang.smartrefresh.layout.c.c.a(60.0f);
        this.mHeaderHeight = com.scwang.smartrefresh.layout.c.c.a(100.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipToPadding)) {
            super.setClipToPadding(false);
        }
        if (!typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_android_clipChildren)) {
            super.setClipChildren(false);
        }
        com.scwang.smartrefresh.layout.a.c cVar = sRefreshInitializer;
        if (cVar != null) {
            cVar.a(context, this);
        }
        this.mDragRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        this.mEnableLoadMore = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMore, this.mEnableLoadMore);
        this.mHeaderHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderHeight, this.mHeaderHeight);
        this.mFooterHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterHeight, this.mFooterHeight);
        this.mHeaderInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        this.mEnableHeaderTranslationContent = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent, this.mEnableHeaderTranslationContent);
        this.mEnableFooterTranslationContent = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        this.mEnableFooterFollowWhenNoMoreData = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableClipHeaderWhenFixedBehind = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        this.mEnableNestedScrolling = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mNestedChild.a(this.mEnableNestedScrolling);
        this.mManualLoadMore = this.mManualLoadMore || typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableLoadMore);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent);
        this.mHeaderHeightStatus = typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlHeaderHeight) ? com.scwang.smartrefresh.layout.constant.a.g : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_srlFooterHeight) ? com.scwang.smartrefresh.layout.constant.a.g : this.mFooterHeightStatus;
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean autoLoadMore(int i, int i2, float f2, boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || this.mFooterNoMoreData) {
            return false;
        }
        p pVar = new p(this, f2, i2, z);
        setViceState(RefreshState.Loading);
        if (i > 0) {
            this.mHandler.postDelayed(pVar, i);
            return true;
        }
        pVar.run();
        return true;
    }

    @Deprecated
    public boolean autoRefresh(int i) {
        int i2 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i3 = this.mHeaderHeight;
        float f3 = f2 * i3 * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoRefresh(i, i2, f3 / i3, false);
    }

    public com.scwang.smartrefresh.layout.a.j finishLoadMore(int i) {
        return finishLoadMore(i, true, false);
    }

    public com.scwang.smartrefresh.layout.a.j finishRefresh(int i) {
        return finishRefresh(i, true, Boolean.FALSE);
    }

    public com.scwang.smartrefresh.layout.a.j setRefreshContent(View view, int i, int i2) {
        com.scwang.smartrefresh.layout.a.e eVar = this.mRefreshContent;
        if (eVar != null) {
            super.removeView(eVar.getView());
        }
        super.addView(view, getChildCount(), new LayoutParams(i, i2));
        this.mRefreshContent = new com.scwang.smartrefresh.layout.impl.a(view);
        if (this.mAttachedToWindow) {
            View viewFindViewById = findViewById(this.mFixedHeaderViewId);
            View viewFindViewById2 = findViewById(this.mFixedFooterViewId);
            this.mRefreshContent.a(this.mScrollBoundaryDecider);
            this.mRefreshContent.a(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.a(this.mKernel, viewFindViewById, viewFindViewById2);
        }
        com.scwang.smartrefresh.layout.a.h hVar = this.mRefreshHeader;
        if (hVar != null && hVar.getSpinnerStyle().h) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
        if (hVar2 != null && hVar2.getSpinnerStyle().h) {
            super.bringChildToFront(this.mRefreshFooter.getView());
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setRefreshFooter(com.scwang.smartrefresh.layout.a.f fVar, int i, int i2) {
        com.scwang.smartrefresh.layout.a.h hVar;
        com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshFooter;
        if (hVar2 != null) {
            super.removeView(hVar2.getView());
        }
        this.mRefreshFooter = fVar;
        this.mFooterLocked = false;
        this.mFooterBackgroundColor = 0;
        this.mFooterNoMoreDataEffective = false;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = this.mFooterHeightStatus.b();
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (this.mRefreshFooter.getSpinnerStyle().h) {
            super.addView(this.mRefreshFooter.getView(), getChildCount(), new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshFooter.getView(), 0, new LayoutParams(i, i2));
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null && (hVar = this.mRefreshFooter) != null) {
            hVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j setRefreshHeader(com.scwang.smartrefresh.layout.a.g gVar, int i, int i2) {
        com.scwang.smartrefresh.layout.a.h hVar;
        com.scwang.smartrefresh.layout.a.h hVar2 = this.mRefreshHeader;
        if (hVar2 != null) {
            super.removeView(hVar2.getView());
        }
        this.mRefreshHeader = gVar;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = this.mHeaderHeightStatus.b();
        if (this.mRefreshHeader.getSpinnerStyle().h) {
            super.addView(this.mRefreshHeader.getView(), getChildCount(), new LayoutParams(i, i2));
        } else {
            super.addView(this.mRefreshHeader.getView(), 0, new LayoutParams(i, i2));
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null && (hVar = this.mRefreshHeader) != null) {
            hVar.setPrimaryColors(iArr);
        }
        return this;
    }

    public boolean autoRefresh(int i, int i2, float f2, boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            return false;
        }
        m mVar = new m(this, f2, i2, z);
        setViceState(RefreshState.Refreshing);
        if (i > 0) {
            this.mHandler.postDelayed(mVar, i);
            return true;
        }
        mVar.run();
        return true;
    }

    public com.scwang.smartrefresh.layout.a.j finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16 : 0, z, false);
    }

    public com.scwang.smartrefresh.layout.a.j finishRefresh(boolean z) {
        if (z) {
            return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) << 16, true, Boolean.FALSE);
        }
        return finishRefresh(0, false, null);
    }

    public com.scwang.smartrefresh.layout.a.j finishLoadMore(int i, boolean z, boolean z2) {
        int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        j jVar = new j(this, i2, z2, z);
        if (i3 > 0) {
            this.mHandler.postDelayed(jVar, i3);
        } else {
            jVar.run();
        }
        return this;
    }

    public com.scwang.smartrefresh.layout.a.j finishRefresh(int i, boolean z, Boolean bool) {
        int i2 = i >> 16;
        int i3 = (i << 16) >> 16;
        g gVar = new g(this, i2, bool, z);
        if (i3 > 0) {
            this.mHandler.postDelayed(gVar, i3);
        } else {
            gVar.run();
        }
        return this;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19116a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.scwang.smartrefresh.layout.constant.b f19117b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f19116a = 0;
            this.f19117b = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f19116a = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f19116a);
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle)) {
                this.f19117b = com.scwang.smartrefresh.layout.constant.b.f19154f[typedArrayObtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle, com.scwang.smartrefresh.layout.constant.b.f19149a.g)];
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f19116a = 0;
            this.f19117b = null;
        }
    }
}
