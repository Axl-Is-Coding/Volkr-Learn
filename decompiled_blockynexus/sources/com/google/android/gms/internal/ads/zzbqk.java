package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqk implements zzeoy<zzbwk> {
    private final zzbqh zzfro;

    public zzbqk(zzbqh zzbqhVar) {
        this.zzfro = zzbqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzbwk zzbwkVarZzaiv = this.zzfro.zzaiv();
        zzepe.zza(zzbwkVarZzaiv, "Cannot return null from a non-@Nullable @Provides method");
        return zzbwkVarZzaiv;
    }
}
