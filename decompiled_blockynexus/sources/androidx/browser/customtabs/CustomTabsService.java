package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public abstract class CustomTabsService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Map<IBinder, IBinder.DeathRecipient> f751a = new a.a.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICustomTabsService.Stub f752b = new h(this);

    protected abstract int a(CustomTabsSessionToken customTabsSessionToken, String str, Bundle bundle);

    protected abstract Bundle a(String str, Bundle bundle);

    protected abstract boolean a(long j);

    protected boolean a(CustomTabsSessionToken customTabsSessionToken) {
        try {
            synchronized (this.f751a) {
                IBinder iBinderA = customTabsSessionToken.a();
                iBinderA.unlinkToDeath(this.f751a.get(iBinderA), 0);
                this.f751a.remove(iBinderA);
            }
            return true;
        } catch (NoSuchElementException unused) {
            return false;
        }
    }

    protected abstract boolean a(CustomTabsSessionToken customTabsSessionToken, int i, Uri uri, Bundle bundle);

    protected abstract boolean a(CustomTabsSessionToken customTabsSessionToken, Uri uri);

    protected abstract boolean a(CustomTabsSessionToken customTabsSessionToken, Uri uri, Bundle bundle, List<Bundle> list);

    protected abstract boolean a(CustomTabsSessionToken customTabsSessionToken, Bundle bundle);

    protected abstract boolean b(CustomTabsSessionToken customTabsSessionToken);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f752b;
    }
}
