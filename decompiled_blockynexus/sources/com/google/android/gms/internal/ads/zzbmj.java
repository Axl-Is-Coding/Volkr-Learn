package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbmj implements zzdyr<String> {
    private final /* synthetic */ String zzfng;
    private final /* synthetic */ zzbmh zzfnh;

    zzbmj(zzbmh zzbmhVar, String str) {
        this.zzfnh = zzbmhVar;
        this.zzfng = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(String str) {
        this.zzfnh.zzfmz.zzi(this.zzfnh.zzfmy.zza(this.zzfnh.zzfmw, this.zzfnh.zzfmx, false, this.zzfng, str, this.zzfnh.zzfmx.zzdkk));
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzfnh.zzfmz.zzi(this.zzfnh.zzfmy.zza(this.zzfnh.zzfmw, this.zzfnh.zzfmx, false, this.zzfng, null, this.zzfnh.zzfmx.zzdkk));
    }
}
