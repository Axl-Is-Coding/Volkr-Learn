package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdf implements zzeoy<zzbqp<zzboq>> {
    private final zzeph<zzbwk> zzftr;
    private final zzeph<zzbix> zzfxn;
    private final zzeph<zzbtp.zza> zzfxo;
    private final zzeph<zzbys> zzfxp;
    private final zzeph<zzccw> zzfxq;

    public zzcdf(zzeph<zzbix> zzephVar, zzeph<zzbtp.zza> zzephVar2, zzeph<zzbys> zzephVar3, zzeph<zzccw> zzephVar4, zzeph<zzbwk> zzephVar5) {
        this.zzfxn = zzephVar;
        this.zzfxo = zzephVar2;
        this.zzfxp = zzephVar3;
        this.zzfxq = zzephVar4;
        this.zzftr = zzephVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbix zzbixVar = this.zzfxn.get();
        zzbtp.zza zzaVar = this.zzfxo.get();
        zzbys zzbysVar = this.zzfxp.get();
        zzbqp<zzboq> zzbqpVarZzage = zzbixVar.zzadp().zzd(zzaVar.zzajv()).zzd(zzbysVar).zzb(this.zzfxq.get()).zza(new zzcyn(null)).zza(new zzbqh(this.zzftr.get())).zzc(new zzbol(null)).zzafw().zzage();
        zzepe.zza(zzbqpVarZzage, "Cannot return null from a non-@Nullable @Provides method");
        return zzbqpVarZzage;
    }
}
