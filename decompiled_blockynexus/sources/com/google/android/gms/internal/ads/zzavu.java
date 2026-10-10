package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavu extends zzauw {
    private final String type;
    private final int zzdvs;

    public zzavu(zzauv zzauvVar) {
        this(zzauvVar != null ? zzauvVar.type : "", zzauvVar != null ? zzauvVar.zzdvs : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaux
    public final int getAmount() throws RemoteException {
        return this.zzdvs;
    }

    @Override // com.google.android.gms.internal.ads.zzaux
    public final String getType() throws RemoteException {
        return this.type;
    }

    public zzavu(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzavu(String str, int i) {
        this.type = str;
        this.zzdvs = i;
    }
}
