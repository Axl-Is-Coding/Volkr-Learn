package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwi implements zzeoy<zzcwf> {
    private final zzeph<zzbix> zzfxn;
    private final zzeph<zzbtp.zza> zzfxo;
    private final zzeph<zzbys> zzfxp;
    private final zzeph<zzcyn> zzgpv;

    public zzcwi(zzeph<zzbix> zzephVar, zzeph<zzbtp.zza> zzephVar2, zzeph<zzcyn> zzephVar3, zzeph<zzbys> zzephVar4) {
        this.zzfxn = zzephVar;
        this.zzfxo = zzephVar2;
        this.zzgpv = zzephVar3;
        this.zzfxp = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcwf(this.zzfxn.get(), this.zzfxo.get(), this.zzgpv.get(), this.zzfxp.get());
    }
}
