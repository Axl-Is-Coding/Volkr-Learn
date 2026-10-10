package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest$ErrorCode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaos implements Runnable {
    private final /* synthetic */ zzaoi zzdmb;
    private final /* synthetic */ AdRequest$ErrorCode zzdmc;

    zzaos(zzaoi zzaoiVar, AdRequest$ErrorCode adRequest$ErrorCode) {
        this.zzdmb = zzaoiVar;
        this.zzdmc = adRequest$ErrorCode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzdmb.zzdlq.onAdFailedToLoad(zzaou.zza(this.zzdmc));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
