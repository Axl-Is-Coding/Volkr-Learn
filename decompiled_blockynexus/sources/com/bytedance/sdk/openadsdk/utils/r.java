package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: Predicate.java */
/* JADX INFO: loaded from: classes.dex */
public class r {
    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        a(str);
        throw null;
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a(str2);
            throw null;
        }
    }

    public static void a(boolean z, String str) {
        if (z) {
            return;
        }
        a(str);
        throw null;
    }

    public static void a(Context context, String str) {
        if (context instanceof Activity) {
            return;
        }
        a(str);
        throw null;
    }

    private static void a(String str) {
        throw new IllegalArgumentException(str);
    }
}
