package com.ironsource.sdk.ISNAdView;

import android.webkit.JavascriptInterface;

/* JADX INFO: compiled from: ISNAdViewWebViewJSInterface.java */
/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ISNAdView f15104a;

    j(ISNAdView iSNAdView) {
        this.f15104a = iSNAdView;
    }

    @JavascriptInterface
    public void receiveMessageFromExternal(String str) {
        this.f15104a.receiveMessageFromWebView(str);
    }
}
