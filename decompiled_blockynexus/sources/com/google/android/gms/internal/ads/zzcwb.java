package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwb implements zzeoy<zzcwc> {
    private final zzeph<zzbix> zzfxn;
    private final zzeph<zzbtp.zza> zzfxo;
    private final zzeph<zzbys> zzfxp;
    private final zzeph<zzccw> zzfxq;

    public zzcwb(zzeph<zzbix> zzephVar, zzeph<zzccw> zzephVar2, zzeph<zzbtp.zza> zzephVar3, zzeph<zzbys> zzephVar4) {
        this.zzfxn = zzephVar;
        this.zzfxq = zzephVar2;
        this.zzfxo = zzephVar3;
        this.zzfxp = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcwc(this.zzfxn.get(), this.zzfxq.get(), this.zzfxo.get(), this.zzfxp.get());
    }
}
