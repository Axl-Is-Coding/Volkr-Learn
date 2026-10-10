package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddv implements zzeoy<zzddp<zzddg>> {
    private final zzeph<Clock> zzfok;
    private final zzeph<zzddj> zzgwo;

    public zzddv(zzeph<zzddj> zzephVar, zzeph<Clock> zzephVar2) {
        this.zzgwo = zzephVar;
        this.zzfok = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzddp zzddpVar = new zzddp(this.zzgwo.get(), 10000L, this.zzfok.get());
        zzepe.zza(zzddpVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzddpVar;
    }
}
