package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzzr implements Runnable {
    private final /* synthetic */ zzzs zzckw;

    zzzr(zzzs zzzsVar) {
        this.zzckw = zzzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzckw.zzbpj != null) {
            try {
                this.zzckw.zzbpj.onAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbbq.zzd("Could not notify onAdFailedToLoad event.", e2);
            }
        }
    }
}
