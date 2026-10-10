package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: compiled from: CustomTabsClient.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Uri f769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Bundle f771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ CustomTabsClient$2 f772e;

    e(CustomTabsClient$2 customTabsClient$2, int i, Uri uri, boolean z, Bundle bundle) {
        this.f772e = customTabsClient$2;
        this.f768a = i;
        this.f769b = uri;
        this.f770c = z;
        this.f771d = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f772e.f750b.a(this.f768a, this.f769b, this.f770c, this.f771d);
    }
}
