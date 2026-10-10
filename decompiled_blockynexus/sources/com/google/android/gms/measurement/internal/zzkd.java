package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zznj;
import com.google.android.gms.internal.measurement.zznk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkd {

    @VisibleForTesting
    private long zza;

    @VisibleForTesting
    private long zzb;
    private final zzai zzc;
    private final /* synthetic */ zzjx zzd;

    public zzkd(zzjx zzjxVar) {
        this.zzd = zzjxVar;
        this.zzc = new zzkc(this, this.zzd.zzy);
        this.zza = zzjxVar.zzl().elapsedRealtime();
        this.zzb = this.zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc() {
        this.zzd.zzc();
        zza(false, false, this.zzd.zzl().elapsedRealtime());
        this.zzd.zzd().zza(this.zzd.zzl().elapsedRealtime());
    }

    final void zza(long j) {
        this.zzd.zzc();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = this.zza;
    }

    final void zzb(long j) {
        this.zzc.zzc();
    }

    @VisibleForTesting
    final long zzb() {
        long jElapsedRealtime = this.zzd.zzl().elapsedRealtime();
        long j = jElapsedRealtime - this.zzb;
        this.zzb = jElapsedRealtime;
        return j;
    }

    @VisibleForTesting
    final long zzc(long j) {
        long j2 = j - this.zzb;
        this.zzb = j;
        return j2;
    }

    final void zza() {
        this.zzc.zzc();
        this.zza = 0L;
        this.zzb = this.zza;
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzc();
        this.zzd.zzv();
        if (!zznj.zzb() || !this.zzd.zzs().zza(zzas.zzbp) || this.zzd.zzy.zzaa()) {
            this.zzd.zzr().zzp.zza(this.zzd.zzl().currentTimeMillis());
        }
        long jZzc = j - this.zza;
        if (!z && jZzc < 1000) {
            this.zzd.zzq().zzw().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jZzc));
            return false;
        }
        if (this.zzd.zzs().zza(zzas.zzas) && !z2) {
            jZzc = (zznk.zzb() && this.zzd.zzs().zza(zzas.zzau)) ? zzc(j) : zzb();
        }
        this.zzd.zzq().zzw().zza("Recording user engagement, ms", Long.valueOf(jZzc));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jZzc);
        zzii.zza(this.zzd.zzh().zza(!this.zzd.zzs().zzh().booleanValue()), bundle, true);
        if (this.zzd.zzs().zza(zzas.zzas) && !this.zzd.zzs().zza(zzas.zzat) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.zzd.zzs().zza(zzas.zzat) || !z2) {
            this.zzd.zze().zza("auto", "_e", bundle);
        }
        this.zza = j;
        this.zzc.zzc();
        this.zzc.zza(3600000L);
        return true;
    }
}
