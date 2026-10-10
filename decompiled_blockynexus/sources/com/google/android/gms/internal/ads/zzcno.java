package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcno implements zzeoy<Set<zzcab<AppEventListener>>> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcns> zzggl;
    private final zzcni zzgia;

    private zzcno(zzcni zzcniVar, zzeph<zzcns> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzgia = zzcniVar;
        this.zzggl = zzephVar;
        this.zzesr = zzephVar2;
    }

    public static zzcno zzf(zzcni zzcniVar, zzeph<zzcns> zzephVar, zzeph<Executor> zzephVar2) {
        return new zzcno(zzcniVar, zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Set<zzcab<AppEventListener>> setZzb = zzcni.zzb(this.zzggl.get(), this.zzesr.get());
        zzepe.zza(setZzb, "Cannot return null from a non-@Nullable @Provides method");
        return setZzb;
    }
}
