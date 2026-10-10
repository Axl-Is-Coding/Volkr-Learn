package com.ironsource.sdk.ISNAdView;

import android.util.Log;

/* JADX INFO: compiled from: ISNAdView.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ISNAdView f15082a;

    a(ISNAdView iSNAdView) {
        this.f15082a = iSNAdView;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15082a.mIsnAdViewLogic.c();
            this.f15082a.removeView(this.f15082a.mWebView);
            if (this.f15082a.mWebView != null) {
                this.f15082a.mWebView.destroy();
            }
            this.f15082a.mActivity = null;
            this.f15082a.mAdViewSize = null;
            this.f15082a.mContainerIdentifier = null;
            this.f15082a.mIsnAdViewLogic.a();
            this.f15082a.mIsnAdViewLogic = null;
        } catch (Exception e2) {
            Log.e(this.f15082a.TAG, "performCleanup | could not destroy ISNAdView");
            e2.printStackTrace();
        }
    }
}
