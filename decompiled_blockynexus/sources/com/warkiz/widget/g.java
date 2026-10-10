package com.warkiz.widget;

import android.view.animation.AlphaAnimation;

/* JADX INFO: compiled from: IndicatorSeekBar.java */
/* JADX INFO: loaded from: classes5.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IndicatorSeekBar f21390a;

    g(IndicatorSeekBar indicatorSeekBar) {
        this.f21390a = indicatorSeekBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
        alphaAnimation.setDuration(180L);
        this.f21390a.mIndicatorContentView.setAnimation(alphaAnimation);
        this.f21390a.updateStayIndicator();
        this.f21390a.mIndicatorContentView.setVisibility(0);
    }
}
