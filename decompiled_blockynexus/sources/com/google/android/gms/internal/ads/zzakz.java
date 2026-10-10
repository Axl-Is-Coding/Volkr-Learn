package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzakz implements zzahq<zzalp> {
    private final /* synthetic */ zzeg zzdhq;
    private final /* synthetic */ zzaki zzdhr;
    private final /* synthetic */ zzbaz zzdhs;
    private final /* synthetic */ zzakr zzdht;

    zzakz(zzakr zzakrVar, zzeg zzegVar, zzaki zzakiVar, zzbaz zzbazVar) {
        this.zzdht = zzakrVar;
        this.zzdhq = zzegVar;
        this.zzdhr = zzakiVar;
        this.zzdhs = zzbazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzalp zzalpVar, Map map) {
        synchronized (this.zzdht.lock) {
            zzbbq.zzfd("JS Engine is requesting an update");
            if (this.zzdht.status == 0) {
                zzbbq.zzfd("Starting reload.");
                this.zzdht.status = 2;
                this.zzdht.zza(this.zzdhq);
            }
            this.zzdhr.zzb("/requestReload", (zzahq<? super zzalp>) this.zzdhs.get());
        }
    }
}
