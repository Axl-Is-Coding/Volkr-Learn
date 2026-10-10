package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: CustomTabsClient.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CustomTabsClient$2 f759c;

    a(CustomTabsClient$2 customTabsClient$2, int i, Bundle bundle) {
        this.f759c = customTabsClient$2;
        this.f757a = i;
        this.f758b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f759c.f750b.onNavigationEvent(this.f757a, this.f758b);
    }
}
