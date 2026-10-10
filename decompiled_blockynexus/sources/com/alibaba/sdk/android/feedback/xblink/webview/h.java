package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: classes.dex */
class h implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsResult f3914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HybridWebChromeClient f3915b;

    h(HybridWebChromeClient hybridWebChromeClient, JsResult jsResult) {
        this.f3915b = hybridWebChromeClient;
        this.f3914a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3914a.cancel();
    }
}
