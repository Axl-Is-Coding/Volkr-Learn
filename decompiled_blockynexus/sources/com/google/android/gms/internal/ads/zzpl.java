package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpl implements zzpd {
    private boolean started;
    private zzhu zzafh = zzhu.zzahz;
    private long zzbkj;
    private long zzbkk;

    public final void start() {
        if (this.started) {
            return;
        }
        this.zzbkk = SystemClock.elapsedRealtime();
        this.started = true;
    }

    public final void stop() {
        if (this.started) {
            zzel(zzfz());
            this.started = false;
        }
    }

    public final void zza(zzpd zzpdVar) {
        zzel(zzpdVar.zzfz());
        this.zzafh = zzpdVar.zzfs();
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzb(zzhu zzhuVar) {
        if (this.started) {
            zzel(zzfz());
        }
        this.zzafh = zzhuVar;
        return zzhuVar;
    }

    public final void zzel(long j) {
        this.zzbkj = j;
        if (this.started) {
            this.zzbkk = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final zzhu zzfs() {
        return this.zzafh;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final long zzfz() {
        long j = this.zzbkj;
        if (!this.started) {
            return j;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.zzbkk;
        zzhu zzhuVar = this.zzafh;
        return j + (zzhuVar.zzaia == 1.0f ? zzha.zzdn(jElapsedRealtime) : zzhuVar.zzdu(jElapsedRealtime));
    }
}
