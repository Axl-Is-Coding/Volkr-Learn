package com.google.android.gms.measurement.internal;

import a.a.b;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zza extends zzd {
    private final Map<String, Long> zza;
    private final Map<String, Integer> zzb;
    private long zzc;

    public zza(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzb = new b();
        this.zza = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(String str, long j) {
        zzc();
        Preconditions.checkNotEmpty(str);
        if (this.zzb.isEmpty()) {
            this.zzc = j;
        }
        Integer num = this.zzb.get(str);
        if (num != null) {
            this.zzb.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (this.zzb.size() >= 100) {
            zzq().zzh().zza("Too many ads visible");
        } else {
            this.zzb.put(str, 1);
            this.zza.put(str, Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str, long j) {
        zzc();
        Preconditions.checkNotEmpty(str);
        Integer num = this.zzb.get(str);
        if (num == null) {
            zzq().zze().zza("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzij zzijVarZza = zzh().zza(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            this.zzb.put(str, Integer.valueOf(iIntValue));
            return;
        }
        this.zzb.remove(str);
        Long l = this.zza.get(str);
        if (l == null) {
            zzq().zze().zza("First ad unit exposure time was never set");
        } else {
            long jLongValue = j - l.longValue();
            this.zza.remove(str);
            zza(str, jLongValue, zzijVarZza);
        }
        if (this.zzb.isEmpty()) {
            long j2 = this.zzc;
            if (j2 == 0) {
                zzq().zze().zza("First ad exposure time was never set");
            } else {
                zza(j - j2, zzijVarZza);
                this.zzc = 0L;
            }
        }
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zzq().zze().zza("Ad unit id must be a non-empty string");
        } else {
            zzp().zza(new zzc(this, str, j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zzq().zze().zza("Ad unit id must be a non-empty string");
        } else {
            zzp().zza(new zzb(this, str, j));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhb zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzen zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzem zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjx zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzak zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzeo zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzkv zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzfr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzeq zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzfc zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ zzab zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgr, com.google.android.gms.measurement.internal.zzgt
    public final /* bridge */ /* synthetic */ zzw zzt() {
        return super.zzt();
    }

    private final void zza(long j, zzij zzijVar) {
        if (zzijVar == null) {
            zzq().zzw().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzq().zzw().zza("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zzii.zza(zzijVar, bundle, true);
        zze().zza("am", "_xa", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(long j) {
        Iterator<String> it = this.zza.keySet().iterator();
        while (it.hasNext()) {
            this.zza.put(it.next(), Long.valueOf(j));
        }
        if (this.zza.isEmpty()) {
            return;
        }
        this.zzc = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    private final void zza(String str, long j, zzij zzijVar) {
        if (zzijVar == null) {
            zzq().zzw().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            zzq().zzw().zza("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zzii.zza(zzijVar, bundle, true);
        zze().zza("am", "_xu", bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final void zza(long j) {
        zzij zzijVarZza = zzh().zza(false);
        for (String str : this.zza.keySet()) {
            zza(str, j - this.zza.get(str).longValue(), zzijVarZza);
        }
        if (!this.zza.isEmpty()) {
            zza(j - this.zzc, zzijVarZza);
        }
        zzb(j);
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgr
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }
}
