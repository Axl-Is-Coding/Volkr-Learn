package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: classes.dex */
class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsResult f3912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HybridWebChromeClient f3913b;

    g(HybridWebChromeClient hybridWebChromeClient, JsResult jsResult) {
        this.f3913b = hybridWebChromeClient;
        this.f3912a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3912a.cancel();
    }
}
