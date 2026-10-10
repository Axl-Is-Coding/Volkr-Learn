package com.alibaba.sdk.android.feedback.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f3675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f3676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f3677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f3678f;
    private static String g;

    public static String a() {
        if (TextUtils.isEmpty(f3673a)) {
            f3673a = h();
        }
        return f3673a;
    }

    public static void a(String str) {
        com.alibaba.sdk.android.feedback.xblink.i.g.a("CustomConfigUtils", "setCustomConfig:" + str);
        if (TextUtils.isEmpty(str) || str.equals(f3673a)) {
            return;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("CustomConfigUtils", "do setCustomConfig");
        f3673a = str;
        c(str);
    }

    public static String b() {
        return f3674b;
    }

    public static void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("global");
            JSONObject jSONObject3 = jSONObject2.getJSONObject("navbar").getJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            f3674b = jSONObject3.getString("backgroundColor");
            f3675c = jSONObject3.getString("color");
            f3676d = jSONObject.getJSONObject("faq").optJSONObject("title").getString("content");
            f3677e = jSONObject2.optBoolean("translucentBarEnable", true);
            f3678f = jSONObject2.optInt("historyFontSizeAndroid");
            try {
                g = jSONObject2.getJSONObject("topBarLoaderAndroid").getJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE).getString("color");
            } catch (Exception unused) {
                g = "";
                com.alibaba.sdk.android.feedback.xblink.i.g.b("CustomConfigUtils", "get loadProgressColor error");
            }
        } catch (Exception unused2) {
        }
        Log.d("CustomConfigUtils", "translucentBarEnable=" + f3677e + ";historyFontSize=" + f3678f + ";loadProgressColor=" + g);
    }

    public static String c() {
        return f3675c;
    }

    private static void c(String str) {
        Context contextN = b.n();
        if (contextN == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = contextN.getSharedPreferences("ywPrefsTools", 0).edit();
        editorEdit.putString("device_conf", str);
        editorEdit.apply();
    }

    public static String d() {
        return f3676d;
    }

    public static boolean e() {
        return f3677e;
    }

    public static int f() {
        return f3678f;
    }

    public static String g() {
        return g;
    }

    private static String h() {
        Context contextN = b.n();
        return contextN == null ? "" : contextN.getSharedPreferences("ywPrefsTools", 0).getString("device_conf", "");
    }
}
