package com.alibaba.sdk.android.feedback.xblink.f;

import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static void a(Object obj, String str) {
        if (!(obj instanceof b)) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVCallJs", "callSuccess: it seems you didn't pass the correct context which WindVane passed to your WindVaneInterface.");
            return;
        }
        b bVar = (b) obj;
        String str2 = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onSuccess(%s,'');", bVar.b()) : String.format("javascript:window.WindVane.onSuccess(%s,'%s');", bVar.b(), str);
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVCallJs", "onSuccess:" + str2);
        }
        XBHybridWebView xBHybridWebViewA = bVar.a();
        if (xBHybridWebViewA != null) {
            try {
                xBHybridWebViewA.loadUrl(str2);
            } catch (Exception e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WVCallJs", "callSuccess error." + e2.getMessage());
            }
        }
    }

    public static void a(Object obj, String str, String str2) {
        if (!(obj instanceof b)) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVCallJs", "fireEvent: it seems you didn't pass the correct context which WindVane passed to your WindVaneInterface.");
            return;
        }
        String str3 = TextUtils.isEmpty(str2) ? String.format("javascript:window.WindVane.fireEvent('%s', '');", str) : String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, str2);
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVCallJs", "fireEvent: " + str3);
        }
        XBHybridWebView xBHybridWebViewA = ((b) obj).a();
        if (xBHybridWebViewA != null) {
            try {
                xBHybridWebViewA.loadUrl(str3);
            } catch (Exception e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WVCallJs", "fireEvent error." + e2.getMessage());
            }
        }
    }

    public static void b(Object obj, String str) {
        if (!(obj instanceof b)) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("WVCallJs", "callFailure: it seems you didn't pass the correct context which WindVane passed to your WindVaneInterface.");
            return;
        }
        b bVar = (b) obj;
        String str2 = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onFailure(%s,'');", bVar.b()) : String.format("javascript:window.WindVane.onFailure(%s,'%s');", bVar.b(), str);
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.a("WVCallJs", "onFailure:" + str2);
        }
        XBHybridWebView xBHybridWebViewA = bVar.a();
        if (xBHybridWebViewA != null) {
            try {
                xBHybridWebViewA.loadUrl(str2);
            } catch (Exception e2) {
                com.alibaba.sdk.android.feedback.xblink.i.g.b("WVCallJs", "callFailure error. " + e2.getMessage());
            }
        }
    }
}
