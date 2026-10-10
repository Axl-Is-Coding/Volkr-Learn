package com.iab.omid.library.ironsrc.adsession;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14537b;

    private e(String str, String str2) {
        this.f14536a = str;
        this.f14537b = str2;
    }

    public static e a(String str, String str2) {
        b.e.a.a.a.d.e.a(str, "Name is null or empty");
        b.e.a.a.a.d.e.a(str2, "Version is null or empty");
        return new e(str, str2);
    }

    public String a() {
        return this.f14536a;
    }

    public String b() {
        return this.f14537b;
    }
}
