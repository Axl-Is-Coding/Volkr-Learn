package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdnl implements zzdag<zzcjg> {
    private final /* synthetic */ zzdnj zzhcw;

    zzdnl(zzdnj zzdnjVar) {
        this.zzhcw = zzdnjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final /* synthetic */ void onSuccess(zzcjg zzcjgVar) {
        zzcjg zzcjgVar2 = zzcjgVar;
        synchronized (this.zzhcw) {
            this.zzhcw.zzhcz = zzcjgVar2;
            this.zzhcw.zzhcz.zzaih();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdag
    public final void zzaqv() {
        synchronized (this.zzhcw) {
            this.zzhcw.zzhcz = null;
        }
    }
}
