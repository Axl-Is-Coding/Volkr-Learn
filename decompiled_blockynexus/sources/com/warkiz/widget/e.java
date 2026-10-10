package com.warkiz.widget;

/* JADX INFO: compiled from: IndicatorSeekBar.java */
/* JADX INFO: loaded from: classes5.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IndicatorSeekBar f21386a;

    e(IndicatorSeekBar indicatorSeekBar) {
        this.f21386a = indicatorSeekBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f21386a.requestLayout();
    }
}
