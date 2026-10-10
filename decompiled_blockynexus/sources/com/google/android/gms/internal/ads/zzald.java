package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzald implements zzbci {
    private final /* synthetic */ zzakr zzdht;
    private final /* synthetic */ zzalm zzdhv;

    zzald(zzakr zzakrVar, zzalm zzalmVar) {
        this.zzdht = zzakrVar;
        this.zzdhv = zzalmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbci
    public final void run() {
        synchronized (this.zzdht.lock) {
            this.zzdht.status = 1;
            zzayp.zzei("Failed loading new engine. Marking new engine destroyable.");
            this.zzdhv.zztm();
        }
    }
}
