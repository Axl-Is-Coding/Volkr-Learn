package c.t.m.g;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class Z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ Y f3067a;

    Z(Y y) {
        this.f3067a = y;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string = fc.a().getSharedPreferences(Y.d(), 0).getString("halley_cloud_param_content", "");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.f3067a.f3056a.a(string);
        } catch (Throwable th) {
            th.printStackTrace();
            fc.a().getSharedPreferences(Y.d(), 0).edit().putString("halley_cloud_param_content", "").commit();
        }
    }
}
