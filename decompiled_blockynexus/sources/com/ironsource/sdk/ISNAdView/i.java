package com.ironsource.sdk.ISNAdView;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import b.f.d.b.c;

/* JADX INFO: compiled from: ISNAdViewWebClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c.a f15103a;

    public i(c.a aVar) {
        this.f15103a = aVar;
    }

    private String a(String str, String str2) {
        return "ISNAdViewWebClient | External Adunit failed to load." + str + " Status code: " + str2;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        try {
            this.f15103a.a(a("onReceivedError", String.valueOf(i)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onReceivedError(webView, i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            this.f15103a.a(a("onReceivedHttpError", Build.VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : ""));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            this.f15103a.a(a("onReceivedErrorM", String.valueOf(webResourceError.getErrorCode())));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }
}
