package com.twitter.sdk.android.core.identity;

import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URI;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: OAuthWebViewClient.java */
/* JADX INFO: loaded from: classes5.dex */
class f extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f20141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f20142b;

    /* JADX INFO: compiled from: OAuthWebViewClient.java */
    interface a {
        void a(Bundle bundle);

        void a(WebView webView, String str);

        void a(WebViewException webViewException);
    }

    f(String str, a aVar) {
        this.f20141a = str;
        this.f20142b = aVar;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f20142b.a(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f20142b.a(new WebViewException(i, str, str2));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        this.f20142b.a(new WebViewException(sslError.getPrimaryError(), null, null));
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith(this.f20141a)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        TreeMap<String, String> treeMapA = com.twitter.sdk.android.core.internal.a.f.a(URI.create(str), false);
        Bundle bundle = new Bundle(treeMapA.size());
        for (Map.Entry<String, String> entry : treeMapA.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        this.f20142b.a(bundle);
        return true;
    }
}
