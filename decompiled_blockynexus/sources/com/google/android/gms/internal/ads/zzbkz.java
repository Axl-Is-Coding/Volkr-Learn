package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbkz implements zzeoy<zzacg> {
    private final zzbky zzflz;

    public zzbkz(zzbky zzbkyVar) {
        this.zzflz = zzbkyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzacg zzacgVarZzaeo = this.zzflz.zzaeo();
        zzepe.zza(zzacgVarZzaeo, "Cannot return null from a non-@Nullable @Provides method");
        return zzacgVarZzaeo;
    }
}
