package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzawf implements zzdyr<Void> {
    private final /* synthetic */ zzdzc zzdxb;

    zzawf(zzavy zzavyVar, zzdzc zzdzcVar) {
        this.zzdxb = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(Void r2) {
        zzavy.zzdwk.remove(this.zzdxb);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzavy.zzdwk.remove(this.zzdxb);
    }
}
