package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgc implements zzeoy<zzdfz> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzcza> zzeti;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<String> zzfow;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<zzcyy> zzgra;

    private zzdgc(zzeph<zzdzb> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<String> zzephVar3, zzeph<zzcza> zzephVar4, zzeph<Context> zzephVar5, zzeph<zzdok> zzephVar6, zzeph<zzcyy> zzephVar7) {
        this.zzesr = zzephVar;
        this.zzfnm = zzephVar2;
        this.zzfow = zzephVar3;
        this.zzeti = zzephVar4;
        this.zzesu = zzephVar5;
        this.zzfqr = zzephVar6;
        this.zzgra = zzephVar7;
    }

    public static zzdgc zzb(zzeph<zzdzb> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<String> zzephVar3, zzeph<zzcza> zzephVar4, zzeph<Context> zzephVar5, zzeph<zzdok> zzephVar6, zzeph<zzcyy> zzephVar7) {
        return new zzdgc(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6, zzephVar7);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdfz(this.zzesr.get(), this.zzfnm.get(), this.zzfow.get(), this.zzeti.get(), this.zzesu.get(), this.zzfqr.get(), this.zzgra.get());
    }
}
