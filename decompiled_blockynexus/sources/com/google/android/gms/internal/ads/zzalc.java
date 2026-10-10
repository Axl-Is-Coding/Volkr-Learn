package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzalc implements Runnable {
    private final /* synthetic */ zzaki zzdhr;
    private final /* synthetic */ zzakr zzdht;
    private final /* synthetic */ zzalm zzdhu;

    zzalc(zzakr zzakrVar, zzalm zzalmVar, zzaki zzakiVar) {
        this.zzdht = zzakrVar;
        this.zzdhu = zzalmVar;
        this.zzdhr = zzakiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzdht.lock) {
            if (this.zzdhu.getStatus() != -1 && this.zzdhu.getStatus() != 1) {
                this.zzdhu.reject();
                zzdzb zzdzbVar = zzbbz.zzeet;
                zzaki zzakiVar = this.zzdhr;
                zzakiVar.getClass();
                zzdzbVar.execute(zzalb.zzb(zzakiVar));
                zzayp.zzei("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
