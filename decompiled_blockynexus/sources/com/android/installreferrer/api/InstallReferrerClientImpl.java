package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import b.c.a.a.a.a;
import com.android.installreferrer.commons.InstallReferrerCommons;
import com.umeng.analytics.pro.au;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class InstallReferrerClientImpl extends InstallReferrerClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3964a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f3965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.c.a.a.a.a f3966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ServiceConnection f3967d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    private final class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InstallReferrerStateListener f3968a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
            InstallReferrerClientImpl.this.f3966c = a.AbstractBinderC0037a.a(iBinder);
            InstallReferrerClientImpl.this.f3964a = 2;
            this.f3968a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
            InstallReferrerClientImpl.this.f3966c = null;
            InstallReferrerClientImpl.this.f3964a = 0;
            this.f3968a.onInstallReferrerServiceDisconnected();
        }

        private a(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f3968a = installReferrerStateListener;
        }
    }

    public InstallReferrerClientImpl(Context context) {
        this.f3965b = context.getApplicationContext();
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        this.f3964a = 3;
        if (this.f3967d != null) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Unbinding from service.");
            this.f3965b.unbindService(this.f3967d);
            this.f3967d = null;
        }
        this.f3966c = null;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails getInstallReferrer() throws RemoteException {
        if (!isReady()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString(au.n, this.f3965b.getPackageName());
        try {
            return new ReferrerDetails(this.f3966c.a(bundle));
        } catch (RemoteException e2) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "RemoteException getting install referrer information");
            this.f3964a = 0;
            throw e2;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        return (this.f3964a != 2 || this.f3966c == null || this.f3967d == null) ? false : true;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        ResolveInfo resolveInfo;
        ServiceInfo serviceInfo;
        if (isReady()) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.f3964a;
        if (i == 1) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i == 3) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        InstallReferrerCommons.logVerbose("InstallReferrerClient", "Starting install referrer service setup.");
        this.f3967d = new a(installReferrerStateListener);
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> listQueryIntentServices = this.f3965b.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = (resolveInfo = listQueryIntentServices.get(0)).serviceInfo) == null) {
            this.f3964a = 0;
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service unavailable on device.");
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = resolveInfo.serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !a()) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f3964a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
        } else {
            if (this.f3965b.bindService(new Intent(intent), this.f3967d, 1)) {
                InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service was bonded successfully.");
                return;
            }
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Connection to service is blocked.");
            this.f3964a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(1);
        }
    }

    private boolean a() {
        try {
            return this.f3965b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
