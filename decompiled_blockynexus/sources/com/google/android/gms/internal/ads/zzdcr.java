package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcr implements zzdgx<zzdgu<Bundle>> {
    private final Executor executor;
    private final zzayb zzbpw;

    zzdcr(Executor executor, zzayb zzaybVar) {
        this.executor = executor;
        this.zzbpw = zzaybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<Bundle>> zzarj() {
        return ((Boolean) zzwm.zzpx().zzd(zzabb.zzcra)).booleanValue() ? zzdyq.zzaf(null) : zzdyq.zzb(this.zzbpw.zzwu(), zzdcq.zzdwz, this.executor);
    }
}
