package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbi implements zzeoy<zzdzc<zzdbm>> {
    private final zzeph<zzdsi> zzfqv;
    private final zzeph<zzdbl> zzgus;
    private final zzeph<zzbtm> zzgut;

    public zzdbi(zzeph<zzdsi> zzephVar, zzeph<zzdbl> zzephVar2, zzeph<zzbtm> zzephVar3) {
        this.zzfqv = zzephVar;
        this.zzgus = zzephVar2;
        this.zzgut = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdrr zzdrrVarZzavs = this.zzfqv.get().zza(zzdsf.GENERATE_SIGNALS, this.zzgut.get().zzajp()).zza(this.zzgus.get()).zza(((Integer) zzwm.zzpx().zzd(zzabb.zzcvb)).intValue(), TimeUnit.SECONDS).zzavs();
        zzepe.zza(zzdrrVarZzavs, "Cannot return null from a non-@Nullable @Provides method");
        return zzdrrVarZzavs;
    }
}
