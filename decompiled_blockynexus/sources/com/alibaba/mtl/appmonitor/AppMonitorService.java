package com.alibaba.mtl.appmonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class AppMonitorService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IMonitor f3548a = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f3548a == null) {
            this.f3548a = new Monitor(getApplication());
        }
        return (IBinder) this.f3548a;
    }

    @Override // android.app.Service
    public void onDestroy() {
        IMonitor iMonitor = this.f3548a;
        if (iMonitor != null) {
            try {
                iMonitor.triggerUpload();
            } catch (RemoteException unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        IMonitor iMonitor = this.f3548a;
        if (iMonitor != null) {
            try {
                iMonitor.triggerUpload();
            } catch (RemoteException unused) {
            }
        }
        super.onLowMemory();
    }
}
