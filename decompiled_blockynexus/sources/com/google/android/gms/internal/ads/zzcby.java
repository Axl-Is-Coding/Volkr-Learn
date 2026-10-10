package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcby implements zzeoy<zzcab<zzbxz>> {
    private final zzeph<Executor> zzesr;
    private final zzcbf zzfwx;

    private zzcby(zzcbf zzcbfVar, zzeph<Executor> zzephVar) {
        this.zzfwx = zzcbfVar;
        this.zzesr = zzephVar;
    }

    public static zzcby zzf(zzcbf zzcbfVar, zzeph<Executor> zzephVar) {
        return new zzcby(zzcbfVar, zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab<zzbxz> zzcabVarZzb = this.zzfwx.zzb(this.zzesr.get());
        zzepe.zza(zzcabVarZzb, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVarZzb;
    }
}
