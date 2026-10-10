package com.alibaba.sdk.android.feedback.xblink.i;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f3896a = true;

    public static void a(String str, String str2) {
        if (!f3896a || str == null || str2 == null) {
            return;
        }
        Log.d("alifb_" + str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        if (!f3896a || str == null || str2 == null) {
            return;
        }
        Log.e("alifb_" + str, str2, th);
    }

    public static void a(String str, Throwable th) {
        if (!f3896a || str == null || th == null) {
            return;
        }
        Log.w("alifb_" + str, th);
    }

    public static void a(boolean z) {
        f3896a = z;
    }

    public static boolean a() {
        return f3896a;
    }

    public static void b(String str, String str2) {
        if (!f3896a || str == null || str2 == null) {
            return;
        }
        Log.e("alifb_" + str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        if (!f3896a || str == null || str2 == null) {
            return;
        }
        Log.w("alifb_" + str, str2, th);
    }

    public static void c(String str, String str2) {
        if (!f3896a || str == null || str2 == null) {
            return;
        }
        Log.i("alifb_" + str, str2);
    }

    public static void d(String str, String str2) {
        if (!f3896a || str == null || str2 == null) {
            return;
        }
        Log.v("alifb_" + str, str2);
    }

    public static void e(String str, String str2) {
        if (!f3896a || str == null || str2 == null) {
            return;
        }
        Log.w("alifb_" + str, str2);
    }
}
