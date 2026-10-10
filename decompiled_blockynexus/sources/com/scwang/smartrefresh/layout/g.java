package com.scwang.smartrefresh.layout;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* JADX INFO: compiled from: SmartRefreshLayout.java */
/* JADX INFO: loaded from: classes.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f19159a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f19160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Boolean f19161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f19162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ SmartRefreshLayout f19163e;

    g(SmartRefreshLayout smartRefreshLayout, int i, Boolean bool, boolean z) {
        this.f19163e = smartRefreshLayout;
        this.f19160b = i;
        this.f19161c = bool;
        this.f19162d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f19159a == 0) {
            SmartRefreshLayout smartRefreshLayout = this.f19163e;
            if (smartRefreshLayout.mState == RefreshState.None && smartRefreshLayout.mViceState == RefreshState.Refreshing) {
                smartRefreshLayout.mViceState = RefreshState.None;
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = this.f19163e;
            if (smartRefreshLayout2.reboundAnimator != null) {
                RefreshState refreshState = smartRefreshLayout2.mState;
                if (refreshState.isHeader && (refreshState.isDragging || refreshState == RefreshState.RefreshReleased)) {
                    SmartRefreshLayout smartRefreshLayout3 = this.f19163e;
                    ValueAnimator valueAnimator = smartRefreshLayout3.reboundAnimator;
                    smartRefreshLayout3.reboundAnimator = null;
                    valueAnimator.cancel();
                    this.f19163e.mKernel.a(RefreshState.None);
                    return;
                }
            }
            SmartRefreshLayout smartRefreshLayout4 = this.f19163e;
            if (smartRefreshLayout4.mState != RefreshState.Refreshing || smartRefreshLayout4.mRefreshHeader == null || smartRefreshLayout4.mRefreshContent == null) {
                return;
            }
            this.f19159a++;
            smartRefreshLayout4.mHandler.postDelayed(this, this.f19160b);
            this.f19163e.notifyStateChanged(RefreshState.RefreshFinish);
            Boolean bool = this.f19161c;
            if (bool != null) {
                this.f19163e.setNoMoreData(bool == Boolean.TRUE);
                return;
            }
            return;
        }
        SmartRefreshLayout smartRefreshLayout5 = this.f19163e;
        int iOnFinish = smartRefreshLayout5.mRefreshHeader.onFinish(smartRefreshLayout5, this.f19162d);
        SmartRefreshLayout smartRefreshLayout6 = this.f19163e;
        com.scwang.smartrefresh.layout.b.c cVar = smartRefreshLayout6.mOnMultiPurposeListener;
        if (cVar != null) {
            com.scwang.smartrefresh.layout.a.h hVar = smartRefreshLayout6.mRefreshHeader;
            if (hVar instanceof com.scwang.smartrefresh.layout.a.g) {
                cVar.a((com.scwang.smartrefresh.layout.a.g) hVar, this.f19162d);
            }
        }
        if (iOnFinish < Integer.MAX_VALUE) {
            SmartRefreshLayout smartRefreshLayout7 = this.f19163e;
            if (smartRefreshLayout7.mIsBeingDragged || smartRefreshLayout7.mNestedInProgress) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                SmartRefreshLayout smartRefreshLayout8 = this.f19163e;
                if (smartRefreshLayout8.mIsBeingDragged) {
                    float f2 = smartRefreshLayout8.mLastTouchY;
                    smartRefreshLayout8.mTouchY = f2;
                    smartRefreshLayout8.mTouchSpinner = 0;
                    smartRefreshLayout8.mIsBeingDragged = false;
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout8.mLastTouchX, (f2 + smartRefreshLayout8.mSpinner) - (smartRefreshLayout8.mTouchSlop * 2), 0));
                    SmartRefreshLayout smartRefreshLayout9 = this.f19163e;
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout9.mLastTouchX, smartRefreshLayout9.mLastTouchY + smartRefreshLayout9.mSpinner, 0));
                }
                SmartRefreshLayout smartRefreshLayout10 = this.f19163e;
                if (smartRefreshLayout10.mNestedInProgress) {
                    smartRefreshLayout10.mTotalUnconsumed = 0;
                    super/*android.view.ViewGroup*/.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout10.mLastTouchX, smartRefreshLayout10.mLastTouchY, 0));
                    SmartRefreshLayout smartRefreshLayout11 = this.f19163e;
                    smartRefreshLayout11.mNestedInProgress = false;
                    smartRefreshLayout11.mTouchSpinner = 0;
                }
            }
            SmartRefreshLayout smartRefreshLayout12 = this.f19163e;
            int i = smartRefreshLayout12.mSpinner;
            if (i <= 0) {
                if (i < 0) {
                    smartRefreshLayout12.animSpinner(0, iOnFinish, smartRefreshLayout12.mReboundInterpolator, smartRefreshLayout12.mReboundDuration);
                    return;
                } else {
                    smartRefreshLayout12.mKernel.a(0, false);
                    this.f19163e.mKernel.a(RefreshState.None);
                    return;
                }
            }
            ValueAnimator valueAnimatorAnimSpinner = smartRefreshLayout12.animSpinner(0, iOnFinish, smartRefreshLayout12.mReboundInterpolator, smartRefreshLayout12.mReboundDuration);
            SmartRefreshLayout smartRefreshLayout13 = this.f19163e;
            ValueAnimator.AnimatorUpdateListener animatorUpdateListenerA = smartRefreshLayout13.mEnableScrollContentWhenRefreshed ? smartRefreshLayout13.mRefreshContent.a(smartRefreshLayout13.mSpinner) : null;
            if (valueAnimatorAnimSpinner == null || animatorUpdateListenerA == null) {
                return;
            }
            valueAnimatorAnimSpinner.addUpdateListener(animatorUpdateListenerA);
        }
    }
}
