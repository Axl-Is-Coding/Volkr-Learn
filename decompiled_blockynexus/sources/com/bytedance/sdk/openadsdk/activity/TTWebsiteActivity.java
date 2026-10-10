package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.t;

/* JADX INFO: loaded from: classes.dex */
public class TTWebsiteActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5719a = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f(this, "tt_activity_website"));
        WebView webView = (WebView) findViewById(t.e(this, "tt_ad_website"));
        if (o.h() != null) {
            this.f5719a = o.h().q();
        }
        com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "mWebsiteUrl=" + this.f5719a);
        if (this.f5719a == null) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(0);
        }
        try {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setDomStorageEnabled(true);
        } catch (Throwable unused) {
        }
        webView.loadUrl(this.f5719a);
        webView.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onPageFinished invoke....url=" + str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView2, webResourceRequest, webResourceError);
                com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onReceivedError invoke....onReceivedError=" + webResourceError.getErrorCode());
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView2, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView2, webResourceRequest, webResourceResponse);
                com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onReceivedHttpError invoke....errorResponse=" + webResourceResponse);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "shouldOverrideUrlLoading invoke....view=" + webView2 + ",request=" + webResourceRequest);
                if (webView2 == null || webResourceRequest == null) {
                    return false;
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    webView2.loadUrl(webResourceRequest.getUrl().toString());
                    com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "shouldOverrideUrlLoading invoke....url1=" + webResourceRequest.getUrl().toString());
                    return true;
                }
                webView2.loadUrl(webResourceRequest.toString());
                com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "shouldOverrideUrlLoading invoke....url2=" + webResourceRequest.toString());
                return true;
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView2, int i, String str, String str2) {
                super.onReceivedError(webView2, i, str, str2);
                com.bytedance.sdk.openadsdk.utils.o.e("TTWebsiteActivity", "onReceivedError invoke....description=" + str + ",failingUrl=" + str2);
            }
        });
    }
}
