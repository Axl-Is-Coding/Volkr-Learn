package com.alibaba.sdk.android.feedback.xblink.webview;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class r implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ XBHybridWebView f3929b;

    r(XBHybridWebView xBHybridWebView, String str) {
        this.f3929b = xBHybridWebView;
        this.f3928a = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3929b.loadUrl("javascript:" + this.f3928a);
    }
}
