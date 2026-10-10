package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpu implements zzeoy<Context> {
    private final zzdpp zzhgo;
    private final zzeph<zzdpn> zzhgq;

    private zzdpu(zzdpp zzdppVar, zzeph<zzdpn> zzephVar) {
        this.zzhgo = zzdppVar;
        this.zzhgq = zzephVar;
    }

    public static Context zzb(zzdpp zzdppVar, zzdpn zzdpnVar) {
        Context context = zzdpnVar.zzaai;
        zzepe.zza(context, "Cannot return null from a non-@Nullable @Provides method");
        return context;
    }

    public static zzdpu zzc(zzdpp zzdppVar, zzeph<zzdpn> zzephVar) {
        return new zzdpu(zzdppVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzhgo, this.zzhgq.get());
    }
}
