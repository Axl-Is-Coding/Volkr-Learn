package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdlr implements zzdvu<zzcqm, zzdlt> {
    private final /* synthetic */ zzdlp zzhcd;

    zzdlr(zzdlp zzdlpVar) {
        this.zzhcd = zzdlpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final /* synthetic */ zzdlt apply(zzcqm zzcqmVar) {
        zzbbq.zzc("", zzcqmVar);
        zzayp.zzei("Failed to get a cache key, reverting to legacy flow.");
        zzdlp zzdlpVar = this.zzhcd;
        zzdlpVar.zzhcc = new zzdlt(null, zzdlpVar.zzatb(), null);
        return this.zzhcd.zzhcc;
    }
}
