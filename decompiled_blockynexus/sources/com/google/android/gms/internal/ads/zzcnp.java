package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcnp implements zzeoy<Set<zzcab<zzdso>>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcns> zzggl;
    private final zzcni zzgia;

    private zzcnp(zzcni zzcniVar, zzeph<zzcns> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzgia = zzcniVar;
        this.zzggl = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzcnp zzg(zzcni zzcniVar, zzeph<zzcns> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzcnp(zzcniVar, zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<zzdso>> setZzh = zzcni.zzh(this.zzggl.get(), this.zzesr.get());
        zzepe.zza(setZzh, "Cannot return null from a non-@Nullable @Provides method");
        return setZzh;
    }
}
