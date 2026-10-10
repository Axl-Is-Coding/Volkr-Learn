package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcis implements zzdyr<zzbgj> {
    private final /* synthetic */ String zzenm;
    private final /* synthetic */ zzahq zzgem;

    zzcis(zzcil zzcilVar, String str, zzahq zzahqVar) {
        this.zzenm = str;
        this.zzgem = zzahqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzbgj zzbgjVar) {
        zzbgjVar.zzb(this.zzenm, this.zzgem);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
    }
}
