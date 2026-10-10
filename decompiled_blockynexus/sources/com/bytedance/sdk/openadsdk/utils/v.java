package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SPUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, v> f7137a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f7138b;

    private v(String str, Context context) {
        if (context != null) {
            this.f7138b = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public static v a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        v vVar = f7137a.get(str);
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(str, context);
        f7137a.put(str, vVar2);
        return vVar2;
    }

    public String b(String str, String str2) {
        try {
            return this.f7138b.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public int b(String str, int i) {
        try {
            return this.f7138b.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public long b(String str, long j) {
        try {
            return this.f7138b.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public Set<String> b(String str, Set<String> set) {
        try {
            return this.f7138b.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public void a(String str, String str2) {
        try {
            this.f7138b.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(String str) {
        try {
            this.f7138b.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return b(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str, int i) {
        try {
            this.f7138b.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, long j) {
        try {
            this.f7138b.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    public void a(String str, Set<String> set) {
        try {
            this.f7138b.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }
}
