package com.alibaba.sdk.android.feedback.a;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f3680b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f3681c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f3682d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f3683e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f3684f = null;
    private static String g = null;
    private static String h = null;
    private static Context i = null;
    private static int j = 0;
    private static String k = null;
    private static String l = "https://feedback-api.aliyuncs.com";
    private static String m = "http://feedback-api.aliyuncs.com";
    private static String n = "http://feedback-api.aliyuncs.com";
    private static int o = 0;
    private static float p = 0.0f;
    private static boolean q = true;
    private static int r;

    public static void a(float f2) {
        p = f2;
    }

    public static void a(int i2) {
        o = i2;
    }

    public static void a(Context context) {
        i = context;
    }

    public static void a(String str) {
        f3679a = str;
    }

    public static void a(boolean z) {
        q = z;
    }

    public static boolean a() {
        return q;
    }

    public static float b() {
        return p;
    }

    public static void b(int i2) {
        r = i2;
    }

    public static void b(String str) {
        f3680b = str;
    }

    public static int c() {
        return o;
    }

    public static void c(int i2) {
        j = i2;
    }

    public static void c(String str) {
        f3681c = str;
    }

    public static String d() {
        return f3679a;
    }

    public static void d(String str) {
        f3682d = str;
    }

    public static String e() {
        return f3680b;
    }

    public static void e(String str) {
        g = str;
    }

    public static String f() {
        return f3682d;
    }

    public static void f(String str) {
        h = str;
    }

    public static String g() {
        return f3683e;
    }

    public static void g(String str) {
        int i2 = r;
        if (i2 == 2) {
            m = str;
        } else if (i2 != 3) {
            l = str;
        } else {
            n = str;
        }
    }

    public static String h() {
        return f3684f;
    }

    public static void h(String str) {
        k = str;
    }

    public static String i() {
        return g;
    }

    public static String j() {
        return h;
    }

    public static String k() {
        int i2 = r;
        return (i2 == 2 || i2 == 3) ? "http://feedback-api.aliyuncs.com" : "https://feedback-api.aliyuncs.com";
    }

    public static String l() {
        int i2 = r;
        return i2 != 2 ? i2 != 3 ? l : n : m;
    }

    public static int m() {
        return r;
    }

    public static Context n() {
        return i;
    }

    public static int o() {
        return j;
    }

    public static String p() {
        return k;
    }
}
