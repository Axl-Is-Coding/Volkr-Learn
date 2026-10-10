package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzala implements zzahq<zzalp> {
    private final /* synthetic */ zzaki zzdhr;
    private final /* synthetic */ zzakr zzdht;
    private final /* synthetic */ zzalm zzdhu;

    zzala(zzakr zzakrVar, zzalm zzalmVar, zzaki zzakiVar) {
        this.zzdht = zzakrVar;
        this.zzdhu = zzalmVar;
        this.zzdhr = zzakiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzalp zzalpVar, Map map) {
        synchronized (this.zzdht.lock) {
            if (this.zzdhu.getStatus() != -1 && this.zzdhu.getStatus() != 1) {
                this.zzdht.status = 0;
                this.zzdht.zzdhg.zzh(this.zzdhr);
                this.zzdhu.zzm(this.zzdhr);
                this.zzdht.zzdhi = this.zzdhu;
                zzayp.zzei("Successfully loaded JS Engine.");
            }
        }
    }
}
