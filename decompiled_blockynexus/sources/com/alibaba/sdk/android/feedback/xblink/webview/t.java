package com.alibaba.sdk.android.feedback.xblink.webview;

import android.text.TextUtils;
import android.webkit.CookieManager;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3931a = 101;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f3932b = 300000;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String cookie = CookieManager.getInstance().getCookie(str);
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.c("WVCookieManager", "get cookie : " + cookie + ";url: " + str);
        }
        return cookie;
    }
}
