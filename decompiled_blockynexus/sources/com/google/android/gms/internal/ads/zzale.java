package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzale implements zzbck<zzaki> {
    private final /* synthetic */ zzakr zzdht;
    private final /* synthetic */ zzalm zzdhv;

    zzale(zzakr zzakrVar, zzalm zzalmVar) {
        this.zzdht = zzakrVar;
        this.zzdhv = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final /* synthetic */ void zzh(zzaki zzakiVar) {
        synchronized (this.zzdht.lock) {
            this.zzdht.status = 0;
            if (this.zzdht.zzdhi != null && this.zzdhv != this.zzdht.zzdhi) {
                zzayp.zzei("New JS engine is loaded, marking previous one as destroyable.");
                this.zzdht.zzdhi.zztm();
            }
            this.zzdht.zzdhi = this.zzdhv;
        }
    }
}
