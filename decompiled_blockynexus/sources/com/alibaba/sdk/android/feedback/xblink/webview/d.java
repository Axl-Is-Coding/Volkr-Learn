package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: classes.dex */
class d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsResult f3906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ HybridWebChromeClient f3907b;

    d(HybridWebChromeClient hybridWebChromeClient, JsResult jsResult) {
        this.f3907b = hybridWebChromeClient;
        this.f3906a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3906a.confirm();
    }
}
