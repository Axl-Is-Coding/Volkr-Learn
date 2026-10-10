package androidx.browser.customtabs;

import android.os.Bundle;

/* JADX INFO: compiled from: CustomTabsClient.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Bundle f761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CustomTabsClient$2 f762c;

    b(CustomTabsClient$2 customTabsClient$2, String str, Bundle bundle) {
        this.f762c = customTabsClient$2;
        this.f760a = str;
        this.f761b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f762c.f750b.extraCallback(this.f760a, this.f761b);
    }
}
