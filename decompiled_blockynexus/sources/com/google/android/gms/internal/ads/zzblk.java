package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblk implements zzeoy<zzdtn> {
    private final zzeph<Context> zzesu;

    public zzblk(zzeph<Context> zzephVar) {
        this.zzesu = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdtn zzdtnVar = new zzdtn(this.zzesu.get(), com.google.android.gms.ads.internal.zzp.zzlf().zzyj());
        zzepe.zza(zzdtnVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdtnVar;
    }
}
