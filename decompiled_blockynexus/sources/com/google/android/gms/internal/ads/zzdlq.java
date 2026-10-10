package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdlq implements zzdvu<zzatc, zzdlt> {
    private final /* synthetic */ zzdlp zzhcd;

    zzdlq(zzdlp zzdlpVar) {
        this.zzhcd = zzdlpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final /* synthetic */ zzdlt apply(zzatc zzatcVar) {
        zzatc zzatcVar2 = zzatcVar;
        this.zzhcd.zzhcc = new zzdlt(zzatcVar2, new zzdql(zzatcVar2.zzduc), null);
        return this.zzhcd.zzhcc;
    }
}
