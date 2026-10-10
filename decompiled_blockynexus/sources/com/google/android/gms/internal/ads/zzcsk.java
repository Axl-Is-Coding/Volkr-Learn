package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsk implements zzeoy<zzcsf> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzcsc> zzewe;
    private final zzeph<zzcrw> zzeyv;
    private final zzeph<zzbtm> zzgmy;

    private zzcsk(zzeph<Context> zzephVar, zzeph<zzbtm> zzephVar2, zzeph<zzcsc> zzephVar3, zzeph<zzcrw> zzephVar4) {
        this.zzesu = zzephVar;
        this.zzgmy = zzephVar2;
        this.zzewe = zzephVar3;
        this.zzeyv = zzephVar4;
    }

    public static zzcsk zze(zzeph<Context> zzephVar, zzeph<zzbtm> zzephVar2, zzeph<zzcsc> zzephVar3, zzeph<zzcrw> zzephVar4) {
        return new zzcsk(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcsf(this.zzesu.get(), this.zzgmy.get(), this.zzewe.get(), this.zzeyv.get());
    }
}
