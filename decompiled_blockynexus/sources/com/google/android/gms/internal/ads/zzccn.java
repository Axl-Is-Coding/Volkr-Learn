package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzua;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccn implements zzeoy<zzcco> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzua.zza.EnumC0120zza> zzfow;
    private final zzeph<zzbgj> zzfqh;
    private final zzeph<zzdnv> zzfrj;

    private zzccn(zzeph<Context> zzephVar, zzeph<zzbgj> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzbbx> zzephVar4, zzeph<zzua.zza.EnumC0120zza> zzephVar5) {
        this.zzesu = zzephVar;
        this.zzfqh = zzephVar2;
        this.zzfrj = zzephVar3;
        this.zzfmh = zzephVar4;
        this.zzfow = zzephVar5;
    }

    public static zzccn zzc(zzeph<Context> zzephVar, zzeph<zzbgj> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzbbx> zzephVar4, zzeph<zzua.zza.EnumC0120zza> zzephVar5) {
        return new zzccn(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcco(this.zzesu.get(), this.zzfqh.get(), this.zzfrj.get(), this.zzfmh.get(), this.zzfow.get());
    }
}
