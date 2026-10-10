package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.h;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: loaded from: classes5.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static double[] f20569a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f20570b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f20571c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f20572d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f20573e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;

    static void a(String str) {
        f20571c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            if (cls != null) {
                return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f20569a;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f20572d)) {
            f20572d = com.umeng.common.b.a(context).c();
        }
        return f20572d;
    }

    public static int getVerticalType(Context context) {
        if (f20573e == 0) {
            f20573e = com.umeng.common.b.a(context).d();
        }
        return f20573e;
    }

    static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(h.A, 0, "\\|");
        } else {
            f20572d = str;
            com.umeng.common.b.a(context).a(f20572d);
        }
    }

    static void a(Context context, int i) {
        f20573e = i;
        com.umeng.common.b.a(context).a(f20573e);
    }
}
