package com.warkiz.widget;

import android.animation.ValueAnimator;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: IndicatorSeekBar.java */
/* JADX INFO: loaded from: classes5.dex */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ float f21387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f21388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ IndicatorSeekBar f21389c;

    f(IndicatorSeekBar indicatorSeekBar, float f2, int i) {
        this.f21389c = indicatorSeekBar;
        this.f21387a = f2;
        this.f21388b = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        IndicatorSeekBar indicatorSeekBar = this.f21389c;
        indicatorSeekBar.lastProgress = indicatorSeekBar.mProgress;
        if (this.f21387a - this.f21389c.mProgressArr[this.f21388b] > WheelView.DividerConfig.FILL) {
            this.f21389c.mProgress = this.f21387a - ((Float) valueAnimator.getAnimatedValue()).floatValue();
        } else {
            this.f21389c.mProgress = this.f21387a + ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
        IndicatorSeekBar indicatorSeekBar2 = this.f21389c;
        indicatorSeekBar2.refreshThumbCenterXByProgress(indicatorSeekBar2.mProgress);
        this.f21389c.setSeekListener(false);
        if (this.f21389c.mIndicator != null && this.f21389c.mIndicatorStayAlways) {
            this.f21389c.mIndicator.e();
            this.f21389c.updateStayIndicator();
        }
        this.f21389c.invalidate();
    }
}
