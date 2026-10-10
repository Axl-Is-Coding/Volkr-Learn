package com.alibaba.sdk.android.feedback.xblink.webview;

import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes.dex */
class n implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ XBHybridWebView f3923a;

    n(XBHybridWebView xBHybridWebView) {
        this.f3923a = xBHybridWebView;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        WebView.HitTestResult hitTestResult;
        try {
            hitTestResult = this.f3923a.getHitTestResult();
        } catch (Exception unused) {
            hitTestResult = null;
        }
        if (hitTestResult == null) {
            return false;
        }
        if (!com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            return true;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("HybridWebView", "Long click on WebView, " + hitTestResult.getExtra());
        return true;
    }
}
