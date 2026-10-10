package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbzn implements zzeoy<zzcwj> {
    private final zzeph<zzcwl> zzewu;
    private final zzeph<zzctd> zzewv;
    private final zzeph<Clock> zzfok;
    private final zzbys zzfwg;

    private zzbzn(zzbys zzbysVar, zzeph<Clock> zzephVar, zzeph<zzcwl> zzephVar2, zzeph<zzctd> zzephVar3) {
        this.zzfwg = zzbysVar;
        this.zzfok = zzephVar;
        this.zzewu = zzephVar2;
        this.zzewv = zzephVar3;
    }

    public static zzbzn zza(zzbys zzbysVar, zzeph<Clock> zzephVar, zzeph<zzcwl> zzephVar2, zzeph<zzctd> zzephVar3) {
        return new zzbzn(zzbysVar, zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcwj zzcwjVarZza = this.zzfwg.zza(this.zzfok.get(), this.zzewu.get(), this.zzewv.get());
        zzepe.zza(zzcwjVarZza, "Cannot return null from a non-@Nullable @Provides method");
        return zzcwjVarZza;
    }
}
