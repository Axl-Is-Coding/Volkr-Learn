package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtj implements zzeoy<zzbtk> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdnv> zzfrj;
    private final zzeph<zzarj> zzftv;

    private zzbtj(zzeph<Context> zzephVar, zzeph<zzdnv> zzephVar2, zzeph<zzarj> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzfrj = zzephVar2;
        this.zzftv = zzephVar3;
    }

    public static zzbtj zzh(zzeph<Context> zzephVar, zzeph<zzdnv> zzephVar2, zzeph<zzarj> zzephVar3) {
        return new zzbtj(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbtk(this.zzesu.get(), this.zzfrj.get(), this.zzftv.get());
    }
}
