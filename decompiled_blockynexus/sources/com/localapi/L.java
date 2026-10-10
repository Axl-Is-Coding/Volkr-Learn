package com.localapi;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public final class L {
    private static boolean host;

    static {
        try {
            Class.forName("android.util.Log");
        } catch (Throwable unused) {
            host = true;
        }
    }

    private L() {
    }

    public static void i(String str) {
        if (host) {
            System.out.println("[LocalAPI] " + str);
            return;
        }
        try {
            Log.i("LocalAPI", str);
        } catch (Throwable unused) {
            System.out.println("[LocalAPI] " + str);
        }
    }

    public static void e(String str) {
        if (host) {
            System.err.println("[LocalAPI] " + str);
            return;
        }
        try {
            Log.e("LocalAPI", str);
        } catch (Throwable unused) {
            System.err.println("[LocalAPI] " + str);
        }
    }
}
