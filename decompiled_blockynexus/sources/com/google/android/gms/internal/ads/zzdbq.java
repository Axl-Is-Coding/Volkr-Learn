package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbq implements zzeoy<zzdbo> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<ViewGroup> zzgpw;
    private final zzeph<zzdzb> zzgvb;

    public zzdbq(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2, zzeph<zzdok> zzephVar3, zzeph<ViewGroup> zzephVar4) {
        this.zzgvb = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfqr = zzephVar3;
        this.zzgpw = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdbo(this.zzgvb.get(), this.zzesu.get(), this.zzfqr.get(), this.zzgpw.get());
    }
}
