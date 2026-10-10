package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [O] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdsd<O> implements zzdyr<O> {
    private final /* synthetic */ zzdrr zzhki;
    private final /* synthetic */ zzdsa zzhkj;

    zzdsd(zzdsa zzdsaVar, zzdrr zzdrrVar) {
        this.zzhkj = zzdsaVar;
        this.zzhki = zzdrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void onSuccess(O o) {
        this.zzhkj.zzhkd.zzhkb.zzc(this.zzhki);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzhkj.zzhkd.zzhkb.zza(this.zzhki, th);
    }
}
