package com.bytedance.sdk.openadsdk.utils;

import android.util.Log;
import com.sandboxol.center.utils.Logger;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7120a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f7121b = 4;

    public static void a(int i) {
        f7121b = i;
    }

    public static void b() {
        f7120a = true;
        a(3);
    }

    public static boolean c() {
        return f7120a;
    }

    public static void d(String str, String str2) {
        if (c() && str2 != null && f7121b <= 5) {
            Log.w(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (c() && str2 != null && f7121b <= 6) {
            Log.e(str, str2);
        }
    }

    public static boolean a() {
        return f7121b <= 3;
    }

    public static void c(String str, String str2) {
        if (c() && str2 != null && f7121b <= 4) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (c() && str2 != null && f7121b <= 2) {
            Log.v(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (c() && str2 != null && f7121b <= 3) {
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && f7121b <= 6) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void a(String str) {
        if (c()) {
            b(Logger.DEFAULT_TAG, str);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && f7121b <= 5) {
                Log.w(str, str2, th);
            }
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (c()) {
            if (!(str2 == null && th == null) && f7121b <= 3) {
                Log.d(str, str2, th);
            }
        }
    }

    public static void b(String str) {
        if (c()) {
            e(Logger.DEFAULT_TAG, str);
        }
    }
}
