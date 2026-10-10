package c.t.m.g;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3007e;

    public S() {
        try {
            this.f3003a = Build.MODEL;
            this.f3004b = Build.VERSION.RELEASE;
            this.f3005c = C0455pa.a();
            this.f3006d = C0455pa.b();
            C0455pa.e();
            this.f3007e = C0455pa.f();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
