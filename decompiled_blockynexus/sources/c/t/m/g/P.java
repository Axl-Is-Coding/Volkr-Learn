package c.t.m.g;

import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: classes.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2980a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2984e;

    public P() {
        this.f2980a = "";
        this.f2981b = 0;
        this.f2982c = "";
        this.f2983d = "";
        try {
            this.f2980a = fc.a().getPackageName();
            PackageInfo packageInfo = fc.a().getPackageManager().getPackageInfo(this.f2980a, 0);
            this.f2981b = packageInfo.versionCode;
            this.f2982c = packageInfo.versionName;
            this.f2984e = fc.c();
            this.f2983d = "";
        } catch (Throwable unused) {
        }
    }
}
