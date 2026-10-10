package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcag implements zzeoy<zzcae> {
    private final zzeph<Context> zzesu;
    private final zzeph<Set<zzcab<zzqu>>> zzfqq;
    private final zzeph<zzdnv> zzfrj;

    private zzcag(zzeph<Context> zzephVar, zzeph<Set<zzcab<zzqu>>> zzephVar2, zzeph<zzdnv> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzfqq = zzephVar2;
        this.zzfrj = zzephVar3;
    }

    public static zzcag zzk(zzeph<Context> zzephVar, zzeph<Set<zzcab<zzqu>>> zzephVar2, zzeph<zzdnv> zzephVar3) {
        return new zzcag(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcae(this.zzesu.get(), this.zzfqq.get(), this.zzfrj.get());
    }
}
