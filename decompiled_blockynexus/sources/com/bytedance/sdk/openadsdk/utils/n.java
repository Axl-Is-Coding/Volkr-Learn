package com.bytedance.sdk.openadsdk.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.WebView;

/* JADX INFO: compiled from: LoadUrlUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f7119a;

    /* JADX INFO: compiled from: LoadUrlUtils.java */
    private static class a {
        private a() {
        }

        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: LoadUrlUtils.java */
    @TargetApi(19)
    private static class b extends a {
        private b() {
            super();
        }

        @Override // com.bytedance.sdk.openadsdk.utils.n.a
        public void a(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            boolean z = false;
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    z = true;
                } catch (Throwable th) {
                    boolean z2 = th instanceof IllegalStateException;
                }
            }
            if (z) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            f7119a = new b();
        } else {
            f7119a = new a();
        }
    }

    public static void a(WebView webView, String str) {
        f7119a.a(webView, str);
    }
}
