package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdma implements zzeoy<zzdlv<zzcjj, zzcjg>> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdpw> zzeuw;
    private final zzeph<zzdqo> zzeux;

    public zzdma(zzeph<Context> zzephVar, zzeph<zzdpw> zzephVar2, zzeph<zzdqo> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzeuw = zzephVar2;
        this.zzeux = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdlv zzdlnVar;
        Context context = this.zzesu.get();
        zzdpw zzdpwVar = this.zzeuw.get();
        zzdqo zzdqoVar = this.zzeux.get();
        if (((Integer) zzwm.zzpx().zzd(zzabb.zzcwr)).intValue() > 0) {
            zzdqn zzdqnVarZza = zzdqoVar.zza(zzdqf.Rewarded, context, zzdpwVar, new zzdld(new zzdku()));
            zzdlnVar = new zzdkz(new zzdlm(new zzdln()), new zzdle(zzdqnVarZza.zzhbu, zzbbz.zzeep), zzdqnVarZza.zzhiu, zzbbz.zzeep);
        } else {
            zzdlnVar = new zzdln();
        }
        zzepe.zza(zzdlnVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdlnVar;
    }
}
