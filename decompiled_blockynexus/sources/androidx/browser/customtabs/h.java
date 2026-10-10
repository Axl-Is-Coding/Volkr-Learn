package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.ICustomTabsService;
import java.util.List;

/* JADX INFO: compiled from: CustomTabsService.java */
/* JADX INFO: loaded from: classes.dex */
class h extends ICustomTabsService.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CustomTabsService f782a;

    h(CustomTabsService customTabsService) {
        this.f782a = customTabsService;
    }

    @Override // android.support.customtabs.ICustomTabsService
    public Bundle extraCommand(String str, Bundle bundle) {
        return this.f782a.a(str, bundle);
    }

    @Override // android.support.customtabs.ICustomTabsService
    public boolean mayLaunchUrl(ICustomTabsCallback iCustomTabsCallback, Uri uri, Bundle bundle, List<Bundle> list) {
        return this.f782a.a(new CustomTabsSessionToken(iCustomTabsCallback), uri, bundle, list);
    }

    @Override // android.support.customtabs.ICustomTabsService
    public boolean newSession(ICustomTabsCallback iCustomTabsCallback) {
        CustomTabsSessionToken customTabsSessionToken = new CustomTabsSessionToken(iCustomTabsCallback);
        try {
            g gVar = new g(this, customTabsSessionToken);
            synchronized (this.f782a.f751a) {
                iCustomTabsCallback.asBinder().linkToDeath(gVar, 0);
                this.f782a.f751a.put(iCustomTabsCallback.asBinder(), gVar);
            }
            return this.f782a.b(customTabsSessionToken);
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // android.support.customtabs.ICustomTabsService
    public int postMessage(ICustomTabsCallback iCustomTabsCallback, String str, Bundle bundle) {
        return this.f782a.a(new CustomTabsSessionToken(iCustomTabsCallback), str, bundle);
    }

    @Override // android.support.customtabs.ICustomTabsService
    public boolean requestPostMessageChannel(ICustomTabsCallback iCustomTabsCallback, Uri uri) {
        return this.f782a.a(new CustomTabsSessionToken(iCustomTabsCallback), uri);
    }

    @Override // android.support.customtabs.ICustomTabsService
    public boolean updateVisuals(ICustomTabsCallback iCustomTabsCallback, Bundle bundle) {
        return this.f782a.a(new CustomTabsSessionToken(iCustomTabsCallback), bundle);
    }

    @Override // android.support.customtabs.ICustomTabsService
    public boolean validateRelationship(ICustomTabsCallback iCustomTabsCallback, int i, Uri uri, Bundle bundle) {
        return this.f782a.a(new CustomTabsSessionToken(iCustomTabsCallback), i, uri, bundle);
    }

    @Override // android.support.customtabs.ICustomTabsService
    public boolean warmup(long j) {
        return this.f782a.a(j);
    }
}
