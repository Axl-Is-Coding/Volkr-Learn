package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbsk implements zzeoy<com.google.android.gms.ads.internal.zza> {
    private final zzeph<Context> zzesu;
    private final zzbsh zzfte;
    private final zzeph<zzawl> zzftf;

    private zzbsk(zzbsh zzbshVar, zzeph<Context> zzephVar, zzeph<zzawl> zzephVar2) {
        this.zzfte = zzbshVar;
        this.zzesu = zzephVar;
        this.zzftf = zzephVar2;
    }

    public static zzbsk zza(zzbsh zzbshVar, zzeph<Context> zzephVar, zzeph<zzawl> zzephVar2) {
        return new zzbsk(zzbshVar, zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        com.google.android.gms.ads.internal.zza zzaVar = new com.google.android.gms.ads.internal.zza(this.zzesu.get(), this.zzftf.get(), null);
        zzepe.zza(zzaVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzaVar;
    }
}
