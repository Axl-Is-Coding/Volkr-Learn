package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;

/* JADX INFO: loaded from: classes.dex */
class CustomTabsClient$2 extends ICustomTabsCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CustomTabsCallback f750b;

    @Override // android.support.customtabs.ICustomTabsCallback
    public void extraCallback(String str, Bundle bundle) throws RemoteException {
        if (this.f750b == null) {
            return;
        }
        this.f749a.post(new b(this, str, bundle));
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onMessageChannelReady(Bundle bundle) throws RemoteException {
        if (this.f750b == null) {
            return;
        }
        this.f749a.post(new c(this, bundle));
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onNavigationEvent(int i, Bundle bundle) {
        if (this.f750b == null) {
            return;
        }
        this.f749a.post(new a(this, i, bundle));
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onPostMessage(String str, Bundle bundle) throws RemoteException {
        if (this.f750b == null) {
            return;
        }
        this.f749a.post(new d(this, str, bundle));
    }

    @Override // android.support.customtabs.ICustomTabsCallback
    public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) throws RemoteException {
        if (this.f750b == null) {
            return;
        }
        this.f749a.post(new e(this, i, uri, z, bundle));
    }
}
