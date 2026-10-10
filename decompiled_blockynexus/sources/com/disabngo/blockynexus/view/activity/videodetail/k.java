package com.disabngo.blockynexus.view.activity.videodetail;

import android.webkit.WebView;
import com.just.agentweb.WebViewClient;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f11199a;

    k(t tVar) {
        this.f11199a = tVar;
    }

    @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView != null) {
            webView.loadUrl("javascript:(function() { document.querySelector('.ytp-chrome-top').style.display='none';  })();");
            webView.loadUrl("javascript:document.onclick= function(){document.querySelector('.ytp-pause-overlay').style.visibility='hidden'}");
        }
    }
}
