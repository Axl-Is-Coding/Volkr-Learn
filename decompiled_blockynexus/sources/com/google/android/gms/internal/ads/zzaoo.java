package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaoo implements Runnable {
    private final /* synthetic */ zzaoi zzdmb;

    zzaoo(zzaoi zzaoiVar) {
        this.zzdmb = zzaoiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzdmb.zzdlq.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
