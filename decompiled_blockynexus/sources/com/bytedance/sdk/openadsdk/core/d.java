package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: AdPreference.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f6053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f6054b;

    private d(Context context) {
        this.f6054b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    public static d a(Context context) {
        if (f6053a == null) {
            synchronized (d.class) {
                if (f6053a == null) {
                    f6053a = new d(context);
                }
            }
        }
        return f6053a;
    }

    public String b(String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("ttopenadsdk", str, str2) : this.f6054b.getString(str, str2);
    }

    public int b(String str, int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, i);
        }
        return this.f6054b.getInt(str, i);
    }

    public void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, str2);
        } else {
            this.f6054b.edit().putString(str, str2).apply();
        }
    }

    public boolean b(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, z);
        }
        return this.f6054b.getBoolean(str, z);
    }

    public void a(String str, int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Integer.valueOf(i));
        } else {
            this.f6054b.edit().putInt(str, i).apply();
        }
    }

    public void a(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Boolean.valueOf(z));
        } else {
            this.f6054b.edit().putBoolean(str, z).apply();
        }
    }
}
