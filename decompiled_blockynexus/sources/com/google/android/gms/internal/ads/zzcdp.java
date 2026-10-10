package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdp implements zzeoy<zzceq> {
    private final zzcdl zzfyp;
    private final zzeph<zzcdi> zzfyq;

    public zzcdp(zzcdl zzcdlVar, zzeph<zzcdi> zzephVar) {
        this.zzfyp = zzcdlVar;
        this.zzfyq = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcdi zzcdiVar = this.zzfyq.get();
        zzepe.zza(zzcdiVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcdiVar;
    }
}
