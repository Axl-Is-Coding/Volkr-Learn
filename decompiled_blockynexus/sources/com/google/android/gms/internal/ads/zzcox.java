package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcox implements zzeoy<zzcpt> {
    private final zzeph<Context> zzesu;

    private zzcox(zzeph<Context> zzephVar) {
        this.zzesu = zzephVar;
    }

    public static zzcox zzad(zzeph<Context> zzephVar) {
        return new zzcox(zzephVar);
    }

    public static zzcpt zzcg(Context context) {
        zzcpt zzcptVar = new zzcpt(context);
        zzepe.zza(zzcptVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcptVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzcg(this.zzesu.get());
    }
}
