package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdgu;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddp<S extends zzdgu<?>> implements zzdgx<S> {
    private final Clock zzbqa;
    private final AtomicReference<zzddo<S>> zzgwi = new AtomicReference<>();
    private final zzdgx<S> zzgwj;
    private final long zzgwk;

    public zzddp(zzdgx<S> zzdgxVar, long j, Clock clock) {
        this.zzbqa = clock;
        this.zzgwj = zzdgxVar;
        this.zzgwk = j;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<S> zzarj() {
        zzddo<S> zzddoVar = this.zzgwi.get();
        if (zzddoVar == null || zzddoVar.hasExpired()) {
            zzddoVar = new zzddo<>(this.zzgwj.zzarj(), this.zzgwk, this.zzbqa);
            this.zzgwi.set(zzddoVar);
        }
        return zzddoVar.zzgwg;
    }
}
