package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdlj implements zzdyr<Void> {
    zzdlj(zzdle zzdleVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Void r1) {
        zzayp.zzei("Notification of cache hit successful.");
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzayp.zzei("Notification of cache hit failed.");
    }
}
