package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdsu implements zzeoy<zzdsr> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdoj> zzfkv;
    private final zzeph<zzeg> zzfnq;
    private final zzeph<Clock> zzfok;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<String> zzgvp;
    private final zzeph<String> zzgvz;
    private final zzeph<zzcwj> zzhlo;

    private zzdsu(zzeph<zzcwj> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<String> zzephVar3, zzeph<String> zzephVar4, zzeph<Context> zzephVar5, zzeph<zzdoj> zzephVar6, zzeph<Clock> zzephVar7, zzeph<zzeg> zzephVar8) {
        this.zzhlo = zzephVar;
        this.zzfov = zzephVar2;
        this.zzgvp = zzephVar3;
        this.zzgvz = zzephVar4;
        this.zzesu = zzephVar5;
        this.zzfkv = zzephVar6;
        this.zzfok = zzephVar7;
        this.zzfnq = zzephVar8;
    }

    public static zzdsu zza(zzeph<zzcwj> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<String> zzephVar3, zzeph<String> zzephVar4, zzeph<Context> zzephVar5, zzeph<zzdoj> zzephVar6, zzeph<Clock> zzephVar7, zzeph<zzeg> zzephVar8) {
        return new zzdsu(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7, zzephVar8);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdsr(this.zzhlo.get(), this.zzfov.get(), this.zzgvp.get(), this.zzgvz.get(), this.zzesu.get(), this.zzfkv.get(), this.zzfok.get(), this.zzfnq.get());
    }
}
