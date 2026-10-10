package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccx implements zzeoy<zzcep> {
    private final zzccw zzfxk;

    private zzccx(zzccw zzccwVar) {
        this.zzfxk = zzccwVar;
    }

    public static zzccx zzc(zzccw zzccwVar) {
        return new zzccx(zzccwVar);
    }

    public static zzcep zzd(zzccw zzccwVar) {
        zzcep zzcepVarZzalh = zzccwVar.zzalh();
        zzepe.zza(zzcepVarZzalh, "Cannot return null from a non-@Nullable @Provides method");
        return zzcepVarZzalh;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zzd(this.zzfxk);
    }
}
