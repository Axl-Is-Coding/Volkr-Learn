package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaul implements RewardItem {
    private final zzatw zzdvw;

    public zzaul(zzatw zzatwVar) {
        this.zzdvw = zzatwVar;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        zzatw zzatwVar = this.zzdvw;
        if (zzatwVar == null) {
            return 0;
        }
        try {
            return zzatwVar.getAmount();
        } catch (RemoteException e2) {
            zzbbq.zzd("Could not forward getAmount to RewardItem", e2);
            return 0;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        zzatw zzatwVar = this.zzdvw;
        if (zzatwVar == null) {
            return null;
        }
        try {
            return zzatwVar.getType();
        } catch (RemoteException e2) {
            zzbbq.zzd("Could not forward getType to RewardItem", e2);
            return null;
        }
    }
}
