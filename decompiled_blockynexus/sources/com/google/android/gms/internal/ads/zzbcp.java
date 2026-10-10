package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcp<T> implements zzdyr<T> {
    private final /* synthetic */ zzbck zzefe;
    private final /* synthetic */ zzbci zzeff;

    zzbcp(zzbcn zzbcnVar, zzbck zzbckVar, zzbci zzbciVar) {
        this.zzefe = zzbckVar;
        this.zzeff = zzbciVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void onSuccess(T t) {
        this.zzefe.zzh(t);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        this.zzeff.run();
    }
}
