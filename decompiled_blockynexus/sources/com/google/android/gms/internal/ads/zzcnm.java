package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcnm implements zzeoy<Set<zzcab<zzbvs>>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcns> zzggl;
    private final zzcni zzgia;

    private zzcnm(zzcni zzcniVar, zzeph<zzcns> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzgia = zzcniVar;
        this.zzggl = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static Set<zzcab<zzbvs>> zzb(zzcni zzcniVar, zzcns zzcnsVar, Executor executor) {
        Set<zzcab<zzbvs>> setZzc = zzcni.zzc(zzcnsVar, executor);
        zzepe.zza(setZzc, "Cannot return null from a non-@Nullable @Provides method");
        return setZzc;
    }

    public static zzcnm zzd(zzcni zzcniVar, zzeph<zzcns> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzcnm(zzcniVar, zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzb(this.zzgia, this.zzggl.get(), this.zzesr.get());
    }
}
