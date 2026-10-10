package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblb implements zzeoy<zzarj> {
    private final zzbky zzflz;

    public zzblb(zzbky zzbkyVar) {
        this.zzflz = zzbkyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzarj zzarjVarZzaem = this.zzflz.zzaem();
        zzepe.zza(zzarjVarZzaem, "Cannot return null from a non-@Nullable @Provides method");
        return zzarjVarZzaem;
    }
}
