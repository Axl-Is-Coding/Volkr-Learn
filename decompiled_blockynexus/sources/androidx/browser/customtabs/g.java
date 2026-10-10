package androidx.browser.customtabs;

import android.os.IBinder;

/* JADX INFO: compiled from: CustomTabsService.java */
/* JADX INFO: loaded from: classes.dex */
class g implements IBinder.DeathRecipient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomTabsSessionToken f780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f781b;

    g(h hVar, CustomTabsSessionToken customTabsSessionToken) {
        this.f781b = hVar;
        this.f780a = customTabsSessionToken;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.f781b.f782a.a(this.f780a);
    }
}
