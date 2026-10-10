package com.ironsource.mediationsdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: IronSourceBannerLayout.java */
/* JADX INFO: loaded from: classes2.dex */
class S implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f14724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FrameLayout.LayoutParams f14725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ IronSourceBannerLayout f14726c;

    S(IronSourceBannerLayout ironSourceBannerLayout, View view, FrameLayout.LayoutParams layoutParams) {
        this.f14726c = ironSourceBannerLayout;
        this.f14724a = view;
        this.f14725b = layoutParams;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14726c.removeAllViews();
        ViewParent parent = this.f14724a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f14724a);
        }
        this.f14726c.mBannerView = this.f14724a;
        this.f14726c.addView(this.f14724a, 0, this.f14725b);
    }
}
