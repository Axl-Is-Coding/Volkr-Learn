package com.tendcloud.tenddata;

import android.os.Build;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class dd extends cx {
    public dd() {
        a(com.umeng.analytics.pro.au.w, "android");
        a("osVersionName", p.a());
        a("osVersionCode", String.valueOf(p.i()));
        a(com.umeng.analytics.pro.au.L, TimeZone.getDefault().getID());
        a("locale", e());
        a("timezoneV", g());
        a(com.umeng.analytics.pro.au.M, p.k());
        a("romVersion", Build.FINGERPRINT);
        a("basebandVersion", d());
        a("osBuild", p.b());
        a("isAdbEnabled", Boolean.valueOf(p.a(ab.g)));
    }

    public static String d() {
        try {
            if (af.a(14)) {
                return Build.getRadioVersion();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String e() {
        try {
            return Locale.getDefault().toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static float f() {
        try {
            return TimeZone.getDefault().getRawOffset() / 3600000.0f;
        } catch (Throwable unused) {
            return -1.0f;
        }
    }

    private static String g() {
        try {
            return String.valueOf(f());
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b() {
        return ((JSONObject) a_()).optString("timezoneV");
    }

    public String c() {
        return ((JSONObject) a_()).optString("locale");
    }
}
