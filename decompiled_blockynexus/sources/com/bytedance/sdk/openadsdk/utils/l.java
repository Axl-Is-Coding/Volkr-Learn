package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;

/* JADX INFO: compiled from: JsBridgeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public static void a(Uri uri, com.bytedance.sdk.openadsdk.core.v vVar) {
        if (vVar == null || !vVar.a(uri)) {
            return;
        }
        try {
            vVar.b(uri);
        } catch (Exception e2) {
            o.d("WebView", "TTAndroidObj handleUri exception: " + e2);
        }
    }

    public static String a(WebView webView, int i) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        return userAgentString + " open_news open_news_u_s/" + i;
    }
}
