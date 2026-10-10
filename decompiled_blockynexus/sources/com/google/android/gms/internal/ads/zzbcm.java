package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcm<T> implements zzdyr<T> {
    private final /* synthetic */ zzbcn zzefb;

    zzbcm(zzbcn zzbcnVar) {
        this.zzefb = zzbcnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void onSuccess(T t) {
        this.zzefb.zzefd.set(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzefb.zzefd.set(-1);
    }
}
