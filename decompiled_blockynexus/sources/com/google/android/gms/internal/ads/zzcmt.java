package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmt {
    private final Map<String, String> zzczo = new ConcurrentHashMap();
    private final /* synthetic */ zzcmu zzghh;

    @VisibleForTesting
    zzcmt(zzcmu zzcmuVar) {
        this.zzghh = zzcmuVar;
    }

    private final zzcmt zzapb() {
        this.zzczo.putAll(this.zzghh.zzghi);
        return this;
    }

    static /* synthetic */ zzcmt zzb(zzcmt zzcmtVar) {
        zzcmtVar.zzapb();
        return zzcmtVar;
    }

    public final zzcmt zza(zzdnw zzdnwVar) {
        this.zzczo.put("gqi", zzdnwVar.zzdtb);
        return this;
    }

    public final void zzapc() {
        this.zzghh.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcmw
            private final zzcmt zzghj;

            {
                this.zzghj = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzghj.zzape();
            }
        });
    }

    public final String zzapd() {
        return this.zzghh.zzghe.zzo(this.zzczo);
    }

    final /* synthetic */ void zzape() {
        this.zzghh.zzghe.zzn(this.zzczo);
    }

    public final zzcmt zzd(zzdnv zzdnvVar) {
        this.zzczo.put("aai", zzdnvVar.zzdjo);
        return this;
    }

    public final zzcmt zzr(String str, String str2) {
        this.zzczo.put(str, str2);
        return this;
    }
}
