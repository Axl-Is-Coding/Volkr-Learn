package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrx implements zzeoy<zzaxw> {
    private final zzeph<zzayi> zzevj;
    private final zzeph<Clock> zzfok;
    private final zzeph<zzdok> zzfqr;

    private zzbrx(zzeph<Clock> zzephVar, zzeph<zzayi> zzephVar2, zzeph<zzdok> zzephVar3) {
        this.zzfok = zzephVar;
        this.zzevj = zzephVar2;
        this.zzfqr = zzephVar3;
    }

    public static zzbrx zzg(zzeph<Clock> zzephVar, zzeph<zzayi> zzephVar2, zzeph<zzdok> zzephVar3) {
        return new zzbrx(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzaxw zzaxwVarZza = this.zzevj.get().zza(this.zzfok.get(), this.zzfqr.get().zzhfb);
        zzepe.zza(zzaxwVarZza, "Cannot return null from a non-@Nullable @Provides method");
        return zzaxwVarZza;
    }
}
