package androidx.browser.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class CustomTabsSessionToken {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ICustomTabsCallback f753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CustomTabsCallback f754b = new CustomTabsCallback() { // from class: androidx.browser.customtabs.CustomTabsSessionToken.1
        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void a(Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f753a.onMessageChannelReady(bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void extraCallback(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f753a.extraCallback(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f753a.onNavigationEvent(i, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void a(String str, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f753a.onPostMessage(str, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }

        @Override // androidx.browser.customtabs.CustomTabsCallback
        public void a(int i, Uri uri, boolean z, Bundle bundle) {
            try {
                CustomTabsSessionToken.this.f753a.onRelationshipValidationResult(i, uri, z, bundle);
            } catch (RemoteException unused) {
                Log.e("CustomTabsSessionToken", "RemoteException during ICustomTabsCallback transaction");
            }
        }
    };

    static class MockCallback extends ICustomTabsCallback.Stub {
        MockCallback() {
        }

        @Override // android.support.customtabs.ICustomTabsCallback.Stub, android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int i, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String str, Bundle bundle) {
        }

        @Override // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        }
    }

    CustomTabsSessionToken(ICustomTabsCallback iCustomTabsCallback) {
        this.f753a = iCustomTabsCallback;
    }

    IBinder a() {
        return this.f753a.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj instanceof CustomTabsSessionToken) {
            return ((CustomTabsSessionToken) obj).a().equals(this.f753a.asBinder());
        }
        return false;
    }

    public CustomTabsCallback getCallback() {
        return this.f754b;
    }

    public int hashCode() {
        return a().hashCode();
    }
}
