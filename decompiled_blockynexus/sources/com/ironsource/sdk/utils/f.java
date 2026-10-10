package com.ironsource.sdk.utils;

import android.util.Log;
import com.ironsource.sdk.data.SSAEnums$DebugMode;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15427a;

    public static void a(int i) {
        if (SSAEnums$DebugMode.MODE_0.getValue() == i) {
            f15427a = false;
        } else {
            f15427a = true;
        }
    }

    public static void b(String str, String str2) {
        if (f15427a) {
            Log.e(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (f15427a) {
            Log.i(str, str2);
        }
    }

    public static void a(String str, String str2) {
        if (f15427a) {
            Log.d(str, str2);
        }
    }
}
