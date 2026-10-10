package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczi implements zzeoy<zzczf> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzwt> zzgso;
    private final zzeph<zzboq> zzgsp;

    public zzczi(zzeph<Context> zzephVar, zzeph<zzwt> zzephVar2, zzeph<zzdok> zzephVar3, zzeph<zzboq> zzephVar4) {
        this.zzesu = zzephVar;
        this.zzgso = zzephVar2;
        this.zzfqr = zzephVar3;
        this.zzgsp = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzczf(this.zzesu.get(), this.zzgso.get(), this.zzfqr.get(), this.zzgsp.get());
    }
}
