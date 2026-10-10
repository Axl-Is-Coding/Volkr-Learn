package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzgr implements zzgt {
    protected final zzfu zzy;

    zzgr(zzfu zzfuVar) {
        Preconditions.checkNotNull(zzfuVar);
        this.zzy = zzfuVar;
    }

    public void zza() {
        this.zzy.zzad();
    }

    public void zzb() {
        this.zzy.zzp().zzb();
    }

    public void zzc() {
        this.zzy.zzp().zzc();
    }

    public zzak zzk() {
        return this.zzy.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public Clock zzl() {
        return this.zzy.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public Context zzm() {
        return this.zzy.zzm();
    }

    public zzeo zzn() {
        return this.zzy.zzi();
    }

    public zzkv zzo() {
        return this.zzy.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzfr zzp() {
        return this.zzy.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzeq zzq() {
        return this.zzy.zzq();
    }

    public zzfc zzr() {
        return this.zzy.zzb();
    }

    public zzab zzs() {
        return this.zzy.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgt
    public zzw zzt() {
        return this.zzy.zzt();
    }
}
