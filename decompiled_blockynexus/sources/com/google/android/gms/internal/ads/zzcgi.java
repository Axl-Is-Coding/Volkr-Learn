package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgi implements zzeoy<zzceq> {
    private final zzeph<zzcgd> zzfef;
    private final zzcgf zzgcr;

    public zzcgi(zzcgf zzcgfVar, zzeph<zzcgd> zzephVar) {
        this.zzgcr = zzcgfVar;
        this.zzfef = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcgd zzcgdVar = this.zzfef.get();
        zzepe.zza(zzcgdVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcgdVar;
    }
}
