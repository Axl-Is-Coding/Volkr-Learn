package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdmb implements zzeoy<zzdlv<zzbnq, zzbnv>> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdpw> zzeuw;
    private final zzeph<zzdqo> zzeux;

    public zzdmb(zzeph<Context> zzephVar, zzeph<zzdpw> zzephVar2, zzeph<zzdqo> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzeuw = zzephVar2;
        this.zzeux = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdlv<zzbnq, zzbnv> zzdlvVarZza = zzdlz.zza(this.zzesu.get(), this.zzeuw.get(), this.zzeux.get());
        zzepe.zza(zzdlvVarZza, "Cannot return null from a non-@Nullable @Provides method");
        return zzdlvVarZza;
    }
}
