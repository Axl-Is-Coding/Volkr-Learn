package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.o;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SSWebSettings.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f6631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6632b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6633c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6634d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6635e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6636f = true;
    private boolean g = true;
    private boolean h = true;

    private a(Context context) {
        this.f6631a = new WeakReference<>(context);
    }

    public static a a(Context context) {
        return new a(context);
    }

    public a b(boolean z) {
        this.f6633c = z;
        return this;
    }

    private void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            o.b(th.toString());
        }
    }

    public a a(boolean z) {
        this.h = z;
        return this;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(WebView webView) {
        if (webView == null || this.f6631a.get() == null) {
            return;
        }
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f6633c) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.f6634d);
        settings.setDomStorageEnabled(this.f6635e);
        settings.setAllowFileAccess(this.f6636f);
        settings.setBlockNetworkImage(true ^ this.g);
        try {
            if (Build.VERSION.SDK_INT >= 11 && !this.h) {
                webView.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && this.h) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            o.b(th.toString());
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + str.replace("{{ad_id}}", str2) + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
