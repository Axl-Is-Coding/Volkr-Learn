package com.google.android.ads.mediationtestsuite.utils.logging;

import android.content.Context;
import java.util.UUID;

/* JADX INFO: compiled from: TestSuiteState.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f12682a = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static g f12683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12686e;

    private g() {
    }

    public static g f() {
        if (f12683b == null) {
            f12683b = new g();
        }
        return f12683b;
    }

    public String a(Context context) {
        return context.getPackageName();
    }

    public String b() {
        return this.f12685d;
    }

    public String c() {
        return f12682a;
    }

    public String d() {
        return "0.9.5";
    }

    public String e() {
        String str = this.f12686e;
        if (str == null) {
            return "mediationtestsuite_android";
        }
        String strValueOf = String.valueOf(str);
        return strValueOf.length() != 0 ? "mediationtestsuite_android_".concat(strValueOf) : new String("mediationtestsuite_android_");
    }

    public String a() {
        return this.f12684c;
    }

    public void b(String str) {
        this.f12686e = str;
    }

    public void a(String str) {
        this.f12684c = str;
    }
}
