package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccy implements zzeoy<zzccw> {
    private final zzccw zzfxk;

    private zzccy(zzccw zzccwVar) {
        this.zzfxk = zzccwVar;
    }

    public static zzccy zze(zzccw zzccwVar) {
        return new zzccy(zzccwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzccw zzccwVar = this.zzfxk;
        if (zzccwVar == null) {
            throw null;
        }
        zzepe.zza(zzccwVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzccwVar;
    }
}
