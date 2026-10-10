package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcrl implements zzeoy<zzcqv> {
    private final zzeph<Context> zzesu;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzatt> zzgln;
    private final zzeph<zzbly> zzglo;
    private final zzeph<zzatq> zzglp;
    private final zzeph<HashMap<String, zzcrk>> zzglq;

    private zzcrl(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzatt> zzephVar3, zzeph<zzbly> zzephVar4, zzeph<zzatq> zzephVar5, zzeph<HashMap<String, zzcrk>> zzephVar6) {
        this.zzesu = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzgln = zzephVar3;
        this.zzglo = zzephVar4;
        this.zzglp = zzephVar5;
        this.zzglq = zzephVar6;
    }

    public static zzcrl zzb(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzatt> zzephVar3, zzeph<zzbly> zzephVar4, zzeph<zzatq> zzephVar5, zzeph<HashMap<String, zzcrk>> zzephVar6) {
        return new zzcrl(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5, zzephVar6);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcqv(this.zzesu.get(), this.zzfqk.get(), this.zzgln.get(), this.zzglo.get(), this.zzglp.get(), this.zzglq.get());
    }
}
