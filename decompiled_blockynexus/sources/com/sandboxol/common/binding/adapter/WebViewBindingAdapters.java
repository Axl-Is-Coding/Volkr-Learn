package com.sandboxol.common.binding.adapter;

import android.text.TextUtils;
import android.webkit.WebView;
import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewBindingAdapters {
    public static void loadHtml(WebView webView, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        webView.loadDataWithBaseURL(null, str, NanoHTTPD.MIME_HTML, "UTF-8", null);
    }
}
