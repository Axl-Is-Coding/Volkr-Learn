package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpq implements zzeoy<zzdpl> {
    private final zzeph<zzbbx> zzfov;
    private final zzeph<Context> zzfth;
    private final zzeph<zzayb> zzgvj;

    public zzdpq(zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzayb> zzephVar3) {
        this.zzfth = zzephVar;
        this.zzfov = zzephVar2;
        this.zzgvj = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdpl(this.zzfth.get(), this.zzfov.get(), this.zzgvj.get());
    }
}
