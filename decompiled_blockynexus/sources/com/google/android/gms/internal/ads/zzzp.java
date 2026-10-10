package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzzp implements Runnable {
    private final /* synthetic */ zzzq zzcku;

    zzzp(zzzq zzzqVar) {
        this.zzcku = zzzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzcku.zzckv.zzbpj != null) {
            try {
                this.zzcku.zzckv.zzbpj.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbbq.zzd("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
