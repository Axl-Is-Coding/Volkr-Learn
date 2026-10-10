package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzzz implements Runnable {
    private final /* synthetic */ zzaaa zzcla;

    zzzz(zzaaa zzaaaVar) {
        this.zzcla = zzaaaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzcla.zzclb != null) {
            try {
                this.zzcla.zzclb.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e2) {
                zzbbq.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e2);
            }
        }
    }
}
