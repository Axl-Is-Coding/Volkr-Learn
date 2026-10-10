package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: UMPreferenceWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20605a = "cconfig_sp_last_request_time";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20606b = "abtest_sp_last_request_data";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20607c = "umeng_general_config";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20608d = "cconfig_sharedpreference";

    private aa() {
    }

    public static SharedPreferences a(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(str, 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static SharedPreferences a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences(f20608d, 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
