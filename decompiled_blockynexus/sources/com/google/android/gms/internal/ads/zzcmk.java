package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmk implements zzbui, zzbvs, zzbws {
    private final zzcms zzghd;
    private final zzcmz zzghe;

    public zzcmk(zzcms zzcmsVar, zzcmz zzcmzVar) {
        this.zzghd = zzcmsVar;
        this.zzghe = zzcmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        this.zzghd.zzru().put("action", "loaded");
        this.zzghe.zzn(this.zzghd.zzru());
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzb(zzdog zzdogVar) {
        this.zzghd.zzc(zzdogVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(zzatc zzatcVar) {
        this.zzghd.zzj(zzatcVar.zzdty);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(zzva zzvaVar) {
        this.zzghd.zzru().put("action", "ftl");
        this.zzghd.zzru().put("ftl", String.valueOf(zzvaVar.errorCode));
        this.zzghd.zzru().put("ed", zzvaVar.zzcgx);
        this.zzghe.zzn(this.zzghd.zzru());
    }
}
