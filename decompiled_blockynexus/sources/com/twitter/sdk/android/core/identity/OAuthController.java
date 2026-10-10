package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.identity.f;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.l;
import com.twitter.sdk.android.core.n;
import com.twitter.sdk.android.core.q;
import com.twitter.sdk.android.core.s;

/* JADX INFO: loaded from: classes5.dex */
class OAuthController implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f20131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    s f20132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProgressBar f20133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WebView f20134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final q f20135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OAuth1aService f20136f;

    interface a {
        void a(int i, Intent intent);
    }

    OAuthController(ProgressBar progressBar, WebView webView, q qVar, OAuth1aService oAuth1aService, a aVar) {
        this.f20133c = progressBar;
        this.f20134d = webView;
        this.f20135e = qVar;
        this.f20136f = oAuth1aService;
        this.f20131a = aVar;
    }

    com.twitter.sdk.android.core.c<l> newRequestAccessTokenCallback() {
        return new c(this);
    }

    com.twitter.sdk.android.core.c<l> newRequestTempTokenCallback() {
        return new b(this);
    }

    private void b(Bundle bundle) {
        String string;
        n.e().d("Twitter", "OAuth web view completed successfully");
        if (bundle != null && (string = bundle.getString("oauth_verifier")) != null) {
            n.e().d("Twitter", "Converting the request token to an access token.");
            this.f20136f.a(newRequestAccessTokenCallback(), this.f20132b, string);
            return;
        }
        n.e().e("Twitter", "Failed to get authorization, bundle incomplete " + bundle, null);
        a(1, new TwitterAuthException("Failed to get authorization, bundle incomplete"));
    }

    private void c() {
        this.f20134d.stopLoading();
        b();
    }

    void a() {
        n.e().d("Twitter", "Obtaining request token to start the sign in flow");
        this.f20136f.b(newRequestTempTokenCallback());
    }

    protected void a(int i, TwitterAuthException twitterAuthException) {
        Intent intent = new Intent();
        intent.putExtra("auth_error", twitterAuthException);
        this.f20131a.a(i, intent);
    }

    void a(WebView webView, WebViewClient webViewClient, String str, WebChromeClient webChromeClient) {
        WebSettings settings = webView.getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(false);
        settings.setSaveFormData(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(str);
        webView.setVisibility(4);
        webView.setWebChromeClient(webChromeClient);
    }

    private void b(WebViewException webViewException) {
        n.e().e("Twitter", "OAuth web view completed with an error", webViewException);
        a(1, new TwitterAuthException("OAuth web view completed with an error"));
    }

    private void b() {
        this.f20133c.setVisibility(8);
    }

    @Override // com.twitter.sdk.android.core.identity.f.a
    public void a(WebView webView, String str) {
        b();
        webView.setVisibility(0);
    }

    @Override // com.twitter.sdk.android.core.identity.f.a
    public void a(Bundle bundle) {
        b(bundle);
        c();
    }

    @Override // com.twitter.sdk.android.core.identity.f.a
    public void a(WebViewException webViewException) {
        b(webViewException);
        c();
    }
}
