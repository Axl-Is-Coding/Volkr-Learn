package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/* JADX INFO: compiled from: ExpressClient.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends com.bytedance.sdk.openadsdk.core.widget.webview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.h f6304a;

    public f(Context context, v vVar, com.bytedance.sdk.openadsdk.core.d.h hVar, com.bytedance.sdk.openadsdk.c.j jVar) {
        super(context, vVar, hVar.J(), jVar);
        this.f6304a = hVar;
    }

    private WebResourceResponse a(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.d.g gVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e.a aVarA = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (aVarA != e.a.IMAGE) {
            Iterator<com.bytedance.sdk.openadsdk.core.d.g> it = this.f6304a.B().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.sdk.openadsdk.core.d.g next = it.next();
                if (!TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(str)) {
                    String strA = next.a();
                    if (strA.startsWith("https")) {
                        strA = strA.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(strA)) {
                        gVar = next;
                        break;
                    }
                }
            }
        }
        return (aVarA == e.a.IMAGE || gVar != null) ? a(str) : com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str, aVarA);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f6676f = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.g = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            o.c("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            WebResourceResponse webResourceResponseA = a(webView, str);
            a(jCurrentTimeMillis, System.currentTimeMillis(), str, webResourceResponseA != null ? 1 : 2);
            if (webResourceResponseA != null) {
                return webResourceResponseA;
            }
        } catch (Throwable th) {
            o.c("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    private WebResourceResponse a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File fileA = com.bytedance.sdk.openadsdk.g.a.a.a().a(com.bytedance.sdk.openadsdk.g.a.a.a().a(str, 0, 0, null));
            if (fileA == null || !fileA.exists() || fileA.length() <= 0) {
                return null;
            }
            return new WebResourceResponse(e.a.IMAGE.a(), "utf-8", new FileInputStream(fileA));
        } catch (Throwable th) {
            o.c("ExpressClient", "get image WebResourceResponse error", th);
            return null;
        }
    }

    private void a(long j, long j2, String str, int i) {
        com.bytedance.sdk.openadsdk.c.j jVar = this.f6675e;
        if (jVar == null || jVar.a() == null) {
            return;
        }
        e.a aVarA = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (aVarA == e.a.HTML) {
            this.f6675e.a().a(str, j, j2, i);
        } else if (aVarA == e.a.JS) {
            this.f6675e.a().b(str, j, j2, i);
        }
    }
}
