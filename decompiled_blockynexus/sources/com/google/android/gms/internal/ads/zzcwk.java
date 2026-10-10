package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwk implements zzeoy<zzcwh> {
    private final zzeph<zzbix> zzfxn;
    private final zzeph<zzbtp.zza> zzfxo;
    private final zzeph<zzbys> zzfxp;

    public zzcwk(zzeph<zzbix> zzephVar, zzeph<zzbtp.zza> zzephVar2, zzeph<zzbys> zzephVar3) {
        this.zzfxn = zzephVar;
        this.zzfxo = zzephVar2;
        this.zzfxp = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcwh(this.zzfxn.get(), this.zzfxo.get(), this.zzfxp.get());
    }
}
