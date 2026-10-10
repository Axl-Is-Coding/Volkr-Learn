package com.alibaba.sdk.android.feedback.xblink.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.SystemClock;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes.dex */
public class HybridWebViewClient extends WebViewClient {
    private static final String TAG = "HybridWebViewClient";
    protected Context mContext;
    private boolean mIsFirst;
    private long mStartPageTime;
    private i mWebViewErrorListener;
    protected com.alibaba.sdk.android.feedback.xblink.e.a filter = null;
    private boolean sdcardChanged = false;
    private boolean enableTakeDownload = true;
    private boolean isAppcacheEnabled = false;
    protected String currentUrl = null;

    public HybridWebViewClient(Context context) {
        this.mContext = context;
    }

    private com.alibaba.sdk.android.feedback.xblink.a.d doubleDownResponse(String str, String str2) {
        return null;
    }

    private com.alibaba.sdk.android.feedback.xblink.a.d wrapperResponse(WebView webView, String str, String str2) {
        return null;
    }

    public void enableTakeDownload(boolean z) {
        this.enableTakeDownload = z;
    }

    public com.alibaba.sdk.android.feedback.xblink.e.a getUrlFilter() {
        return this.filter;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.d(TAG, "Page finish: " + str);
        }
        ((XBHybridWebView) webView).onMessage(401, null);
        com.alibaba.sdk.android.feedback.xblink.f.h.a().a(webView, str);
        if (this.mIsFirst) {
            this.mIsFirst = false;
            SystemClock.elapsedRealtime();
            long j = this.mStartPageTime;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.d(TAG, "Page start: " + str);
        }
        this.mStartPageTime = SystemClock.elapsedRealtime();
        this.mIsFirst = true;
        this.isAppcacheEnabled = false;
        this.currentUrl = str;
        ((XBHybridWebView) webView).onMessage(400, null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.d(TAG, "Receive error, code: " + i + "; desc: " + str + "; url: " + str2);
        }
        String url = webView.getUrl();
        if (url == null || url.equals(str2)) {
            ((XBHybridWebView) webView).onMessage(402, str2);
        }
        if (i != -2 && com.alibaba.sdk.android.feedback.xblink.b.c.f3777c) {
            String str3 = "4.5.1|" + str + "|" + str2;
        }
        i iVar = this.mWebViewErrorListener;
        if (iVar != null) {
            iVar.onReceivedError();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a() && sslError != null) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e(TAG, "Receive ssl error: " + sslError.getPrimaryError());
        }
        if (com.alibaba.sdk.android.feedback.a.b.m() == 2) {
            sslErrorHandler.proceed();
        } else {
            sslErrorHandler.cancel();
        }
    }

    public void setUrlFilter(com.alibaba.sdk.android.feedback.xblink.e.a aVar) {
        this.filter = aVar;
    }

    public void setWebViewErrorListener(i iVar) {
        this.mWebViewErrorListener = iVar;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            return false;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.d(TAG, "shouldOverrideUrlLoading: " + str);
        return false;
    }
}
