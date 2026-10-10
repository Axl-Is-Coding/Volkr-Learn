package com.disabngo.blockynexus.view.activity.webview.config;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;

/* JADX INFO: compiled from: MyWebViewClient.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f11252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebViewActivity f11253b;

    public d(a aVar) {
        this.f11252a = aVar;
        this.f11253b = (WebViewActivity) aVar;
    }

    private void a(Activity activity, String str) {
        String str2;
        if (str.contains("alipays")) {
            str2 = "com.eg.android.AlipayGphone";
        } else if (str.contains("weixin://wap/pay")) {
            str2 = "com.tencent.mm";
        } else if (str.contains("openapp.jdmobile")) {
            str2 = "com.jingdong.app.mall";
        } else {
            a(str);
            str2 = "";
        }
        if (com.disabngo.blockynexus.view.activity.webview.utils.c.a(activity, str2)) {
            a(str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (!com.disabngo.blockynexus.view.activity.webview.utils.a.a(this.f11253b)) {
            this.f11252a.b();
        }
        this.f11252a.c();
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (i == 404) {
            webView.loadUrl("javascript:document.body.innerHTML=\"Page NO FOUND！\"");
        }
    }

    @Override // android.webkit.WebViewClient
    public void onScaleChanged(WebView webView, float f2, float f3) {
        super.onScaleChanged(webView, f2, f3);
        if (f3 - f2 > 7.0f) {
            webView.setInitialScale((int) ((f2 / f3) * 100.0f));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("http:") && !str.startsWith("https:")) {
            a(this.f11253b, str);
            return true;
        }
        if (!str.contains(".apk")) {
            return false;
        }
        a(this.f11253b, str);
        return true;
    }

    private void a(String str) {
        try {
            if (str.startsWith("will://")) {
                Uri uri = Uri.parse(str);
                Log.e("---------scheme", uri.getScheme() + "；host: " + uri.getHost() + "；Id: " + uri.getPathSegments().get(0));
            }
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.addFlags(268435456);
            this.f11253b.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
