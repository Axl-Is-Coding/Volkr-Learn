package com.ironsource.mediationsdk.a;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* JADX INFO: compiled from: ConfigFile.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f14760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f14764e = {CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY, "AdobeAir", "Xamarin", "Corona", "AdMob", "MoPub"};

    public static synchronized a a() {
        if (f14760a == null) {
            f14760a = new a();
        }
        return f14760a;
    }

    public String b() {
        return this.f14763d;
    }

    public String c() {
        return this.f14761b;
    }

    public String d() {
        return this.f14762c;
    }
}
