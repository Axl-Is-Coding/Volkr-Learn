package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbts implements zzeoy<Context> {
    private final zzeph<Context> zzfth;
    private final zzbtp zzfuk;

    private zzbts(zzbtp zzbtpVar, zzeph<Context> zzephVar) {
        this.zzfuk = zzbtpVar;
        this.zzfth = zzephVar;
    }

    public static zzbts zza(zzbtp zzbtpVar, zzeph<Context> zzephVar) {
        return new zzbts(zzbtpVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Context contextZzcd = this.zzfuk.zzcd(this.zzfth.get());
        zzepe.zza(contextZzcd, "Cannot return null from a non-@Nullable @Provides method");
        return contextZzcd;
    }
}
