package com.alibaba.sdk.android.feedback.xblink.webview;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ XBHybridWebView f3927a;

    q(XBHybridWebView xBHybridWebView) {
        this.f3927a = xBHybridWebView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            ((Activity) this.f3927a.context).finish();
        } catch (Exception unused) {
        }
    }
}
