package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgn implements zzdgx<zzdgu<Bundle>> {
    private final boolean zzgxx;

    zzdgn(zzdmd zzdmdVar) {
        if (zzdmdVar != null) {
            this.zzgxx = true;
        } else {
            this.zzgxx = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<Bundle>> zzarj() {
        return zzdyq.zzaf(this.zzgxx ? zzdgm.zzgxw : null);
    }
}
