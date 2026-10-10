package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyh implements zzeoy<zzcyb> {
    private final zzeph<zzdzb> zzfqk;
    private final zzeph<zzdsi> zzfqv;
    private final zzeph<zzbpm> zzgof;
    private final zzeph<Context> zzgrp;
    private final zzeph<zzaby> zzgrq;

    public zzcyh(zzeph<Context> zzephVar, zzeph<zzbpm> zzephVar2, zzeph<zzdsi> zzephVar3, zzeph<zzdzb> zzephVar4, zzeph<zzaby> zzephVar5) {
        this.zzgrp = zzephVar;
        this.zzgof = zzephVar2;
        this.zzfqv = zzephVar3;
        this.zzfqk = zzephVar4;
        this.zzgrq = zzephVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcyb(this.zzgrp.get(), this.zzgof.get(), this.zzfqv.get(), this.zzfqk.get(), this.zzgrq.get());
    }
}
