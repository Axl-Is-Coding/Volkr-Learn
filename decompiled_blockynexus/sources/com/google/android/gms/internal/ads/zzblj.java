package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblj implements zzeoy<zzbag> {
    private final zzeph<Context> zzesu;

    public zzblj(zzeph<Context> zzephVar) {
        this.zzesu = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbag zzbagVar = new zzbag(this.zzesu.get());
        zzepe.zza(zzbagVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbagVar;
    }
}
