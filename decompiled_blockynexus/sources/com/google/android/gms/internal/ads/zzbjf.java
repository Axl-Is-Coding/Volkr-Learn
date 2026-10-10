package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjf implements zzeoy<zzeg> {
    private final zzbja zzesn;

    public zzbjf(zzbja zzbjaVar) {
        this.zzesn = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzeg zzegVarZzaef = this.zzesn.zzaef();
        zzepe.zza(zzegVarZzaef, "Cannot return null from a non-@Nullable @Provides method");
        return zzegVarZzaef;
    }
}
