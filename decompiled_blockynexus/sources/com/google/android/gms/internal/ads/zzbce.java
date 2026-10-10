package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbce implements zzdyr<Object> {
    private final /* synthetic */ String zzeey;

    zzbce(String str) {
        this.zzeey = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void onSuccess(Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.zzp.zzkv().zzb(th, this.zzeey);
    }
}
