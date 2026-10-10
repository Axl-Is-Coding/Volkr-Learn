package com.alibaba.sdk.android.feedback.xblink.webview;

import android.os.Build;
import android.os.Handler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Handler f3921a;

    public static void a() {
        if (Build.VERSION.SDK_INT != 15 || "SAMSUNG".equalsIgnoreCase(Build.BRAND)) {
            return;
        }
        if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
            com.alibaba.sdk.android.feedback.xblink.i.g.e("TweakWebCoreHandler", "BRAND: " + Build.BRAND);
        }
        b();
    }

    private static void b() {
        if (f3921a != null) {
            return;
        }
        try {
            Field declaredField = Class.forName("android.webkit.WebViewCore").getDeclaredField("sWebCoreHandler");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Method declaredMethod = Handler.class.getDeclaredMethod("getIMessenger", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(obj, null);
            f3921a = new m((Handler) obj);
            if (objInvoke != null) {
                Field declaredField2 = Handler.class.getDeclaredField("mMessenger");
                declaredField2.setAccessible(true);
                declaredField2.set(f3921a, objInvoke);
            }
            declaredField.set(null, f3921a);
            if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a("TweakWebCoreHandler", "sWebCoreHandler: " + obj);
            }
        } catch (Throwable th) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("TweakWebCoreHandler", "tweakWebCoreHandler exception: " + th);
        }
        if (f3921a == null) {
            f3921a = new Handler();
        }
    }
}
