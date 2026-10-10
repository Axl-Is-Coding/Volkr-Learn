package com.alibaba.sdk.android.feedback.xblink.webview;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class p implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ XBHybridWebView f3926b;

    p(XBHybridWebView xBHybridWebView, String str) {
        this.f3926b = xBHybridWebView;
        this.f3925a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3926b.loadUrl("javascript:" + this.f3925a);
    }
}
