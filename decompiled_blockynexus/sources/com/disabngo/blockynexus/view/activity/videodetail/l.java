package com.disabngo.blockynexus.view.activity.videodetail;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.just.agentweb.WebChromeClient;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f11200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f11201b;

    l(t tVar, Activity activity) {
        this.f11201b = tVar;
        this.f11200a = activity;
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return super.getDefaultVideoPoster() == null ? Bitmap.createBitmap(360, 200, Bitmap.Config.ALPHA_8) : super.getDefaultVideoPoster();
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onHideCustomView() {
        super.onHideCustomView();
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        if (i != 100 || webView == null) {
            return;
        }
        webView.loadUrl("javascript:(function() { document.querySelector('.ytp-chrome-top').style.display='none';  })();");
        webView.loadUrl("javascript:document.onclick= function(){document.querySelector('.ytp-pause-overlay').style.visibility='hidden'}");
    }

    @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
        this.f11200a.setRequestedOrientation(0);
    }
}
