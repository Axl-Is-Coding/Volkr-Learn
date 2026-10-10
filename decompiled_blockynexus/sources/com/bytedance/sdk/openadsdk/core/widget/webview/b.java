package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.utils.l;

/* JADX INFO: compiled from: TTWebChromeClient.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6669a = WebChromeClient.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v f6670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f6671c;

    public b(v vVar, j jVar) {
        this.f6670b = vVar;
        this.f6671c = jVar;
    }

    private boolean a(String str) {
        try {
            Uri uri = Uri.parse(str);
            if (!"bytedance".equals(uri.getScheme().toLowerCase())) {
                return false;
            }
            l.a(uri, this.f6670b);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        j jVar = this.f6671c;
        if (jVar != null) {
            jVar.a(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !a(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }
}
