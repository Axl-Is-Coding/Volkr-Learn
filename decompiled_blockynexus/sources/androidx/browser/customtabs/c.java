package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: CustomTabsClient.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CustomTabsClient$2 f764b;

    c(CustomTabsClient$2 customTabsClient$2, Bundle bundle) {
        this.f764b = customTabsClient$2;
        this.f763a = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f764b.f750b.a(this.f763a);
    }
}
