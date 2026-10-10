package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: classes.dex */
class e implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsResult f3908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HybridWebChromeClient f3909b;

    e(HybridWebChromeClient hybridWebChromeClient, JsResult jsResult) {
        this.f3909b = hybridWebChromeClient;
        this.f3908a = jsResult;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3908a.cancel();
    }
}
