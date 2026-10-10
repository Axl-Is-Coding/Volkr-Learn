package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.utils.l;
import com.bytedance.sdk.openadsdk.utils.n;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.q;

/* JADX INFO: compiled from: TTWebViewClient.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends WebViewClient {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final v f6672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Context f6673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f6674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected j f6675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f6676f = true;
    protected boolean g = true;

    public c(Context context, v vVar, String str, j jVar) {
        this.f6673c = context;
        this.f6672b = vVar;
        this.f6674d = str;
        this.f6675e = jVar;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (o.a()) {
            o.a("WebChromeClient", "onPageFinished " + str);
        }
        j jVar = this.f6675e;
        if (jVar != null) {
            jVar.a(webView, str);
        }
        if (webView != null && this.f6676f) {
            try {
                String strA = a.a(com.bytedance.sdk.openadsdk.core.o.h().g(), this.f6674d);
                if (!TextUtils.isEmpty(strA)) {
                    n.a(webView, strA);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        j jVar = this.f6675e;
        if (jVar != null) {
            jVar.a(webView, str, bitmap);
        }
        if (this.g) {
            a.a(this.f6673c).a(Build.VERSION.SDK_INT >= 19).a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        j jVar = this.f6675e;
        if (jVar != null) {
            jVar.a(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        j jVar = this.f6675e;
        if (jVar == null || webResourceResponse == null) {
            return;
        }
        jVar.a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                sslErrorHandler.cancel();
            } catch (Throwable unused) {
            }
        }
        if (this.f6675e != null) {
            int primaryError = 0;
            String str = "SslError: unknown";
            if (sslError != null) {
                try {
                    primaryError = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                } catch (Throwable unused2) {
                }
            }
            this.f6675e.a(webView, primaryError, str, null);
        }
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        j jVar = this.f6675e;
        if (jVar != null) {
            jVar.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        o.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            uri = Uri.parse(str);
        } catch (Exception e2) {
            o.b("WebChromeClient", "shouldOverrideUrlLoading", e2);
            v vVar = this.f6672b;
            if (vVar != null && vVar.a()) {
                return true;
            }
        }
        if ("bytedance".equals(uri.getScheme().toLowerCase())) {
            l.a(uri, this.f6672b);
            return true;
        }
        if (!q.a(str)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            this.f6673c.startActivity(intent);
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        j jVar = this.f6675e;
        if (jVar == null || webResourceError == null) {
            return;
        }
        jVar.a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), null);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }
}
