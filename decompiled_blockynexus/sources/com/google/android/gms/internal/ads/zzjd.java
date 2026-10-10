package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzjd implements zziu {
    private final /* synthetic */ zzjb zzamv;

    private zzjd(zzjb zzjbVar) {
        this.zzamv = zzjbVar;
    }

    @Override // com.google.android.gms.internal.ads.zziu
    public final void zzc(int i, long j, long j2) {
        this.zzamv.zzamo.zzb(i, j, j2);
        zzjb.zza(i, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zziu
    public final void zzen() {
        zzjb.zzgd();
        zzjb.zza(this.zzamv, true);
    }

    @Override // com.google.android.gms.internal.ads.zziu
    public final void zzx(int i) {
        this.zzamv.zzamo.zzy(i);
        zzjb.zzx(i);
    }
}
