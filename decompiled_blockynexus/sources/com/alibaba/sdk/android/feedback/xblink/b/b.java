package com.alibaba.sdk.android.feedback.xblink.b;

import android.app.Application;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3769a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f3770b = a.ONLINE.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f3771c = a.ONLINE.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Application f3772d;
    private static b h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f3773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f3774f;
    private String g;

    private b() {
    }

    public static synchronized b a() {
        if (h == null) {
            h = new b();
        }
        return h;
    }

    public String b() {
        return this.f3773e;
    }

    public String c() {
        return this.f3774f;
    }

    public String d() {
        return this.g;
    }
}
