package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavm implements RewardItem {
    private final zzaux zzdwc;

    public zzavm(zzaux zzauxVar) {
        this.zzdwc = zzauxVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzaux zzauxVar = this.zzdwc;
        if (zzauxVar == null) {
            return 0;
        }
        try {
            return zzauxVar.getAmount();
        } catch (RemoteException e2) {
            zzbbq.zzd("Could not forward getAmount to RewardItem", e2);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzaux zzauxVar = this.zzdwc;
        if (zzauxVar == null) {
            return null;
        }
        try {
            return zzauxVar.getType();
        } catch (RemoteException e2) {
            zzbbq.zzd("Could not forward getType to RewardItem", e2);
            return null;
        }
    }
}
