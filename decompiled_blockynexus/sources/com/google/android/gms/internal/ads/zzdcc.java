package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcc implements zzeoy<zzdca> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzddp<zzdha>> zzeug;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzayb> zzgvj;

    private zzdcc(zzeph<zzddp<zzdha>> zzephVar, zzeph<zzdok> zzephVar2, zzeph<Context> zzephVar3, zzeph<zzayb> zzephVar4) {
        this.zzeug = zzephVar;
        this.zzfqr = zzephVar2;
        this.zzesu = zzephVar3;
        this.zzgvj = zzephVar4;
    }

    public static zzdcc zzg(zzeph<zzddp<zzdha>> zzephVar, zzeph<zzdok> zzephVar2, zzeph<Context> zzephVar3, zzeph<zzayb> zzephVar4) {
        return new zzdcc(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdca(this.zzeug.get(), this.zzfqr.get(), this.zzesu.get(), this.zzgvj.get());
    }
}
