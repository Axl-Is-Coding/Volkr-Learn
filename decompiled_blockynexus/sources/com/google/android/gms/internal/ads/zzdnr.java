package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdnr extends AdMetadataListener {
    private final /* synthetic */ zzdnp zzhda;
    private final /* synthetic */ zzxj zzhdb;

    zzdnr(zzdnp zzdnpVar, zzxj zzxjVar) {
        this.zzhda = zzdnpVar;
        this.zzhdb = zzxjVar;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.zzhda.zzhcz != null) {
            try {
                this.zzhdb.onAdMetadataChanged();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
    }
}
