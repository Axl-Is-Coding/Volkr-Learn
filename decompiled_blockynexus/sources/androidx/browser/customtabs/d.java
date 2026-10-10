package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: CustomTabsClient.java */
/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CustomTabsClient$2 f767c;

    d(CustomTabsClient$2 customTabsClient$2, String str, Bundle bundle) {
        this.f767c = customTabsClient$2;
        this.f765a = str;
        this.f766b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f767c.f750b.a(this.f765a, this.f766b);
    }
}
