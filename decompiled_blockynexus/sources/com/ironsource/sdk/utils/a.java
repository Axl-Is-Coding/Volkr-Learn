package com.ironsource.sdk.utils;

import android.content.Context;

/* JADX INFO: compiled from: DeviceProperties.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f15417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15418b = com.ironsource.environment.b.g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15419c = com.ironsource.environment.b.f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15420d = com.ironsource.environment.b.h();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f15421e = com.ironsource.environment.b.b();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15422f = com.ironsource.environment.b.a();
    private String g;

    private a(Context context) {
        this.g = com.ironsource.environment.b.k(context);
    }

    public static a b(Context context) {
        if (f15417a == null) {
            f15417a = new a(context);
        }
        return f15417a;
    }

    public static String g() {
        return "5.88";
    }

    public int a() {
        return this.f15422f;
    }

    public String c() {
        return this.f15419c;
    }

    public String d() {
        return this.f15418b;
    }

    public String e() {
        return this.f15420d;
    }

    public String f() {
        return this.f15421e;
    }

    public float a(Context context) {
        return com.ironsource.environment.b.m(context);
    }

    public String b() {
        return this.g;
    }
}
