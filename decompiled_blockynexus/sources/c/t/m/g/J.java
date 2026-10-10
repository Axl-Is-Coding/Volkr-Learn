package c.t.m.g;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ I f2932a;

    J(I i) {
        this.f2932a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB = C0446ma.b("settings_in_client", "");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        try {
            this.f2932a.f2924a.a(strB);
            this.f2932a.a();
        } catch (Throwable th) {
            th.printStackTrace();
            C0446ma.a("settings_in_client", "");
        }
    }
}
