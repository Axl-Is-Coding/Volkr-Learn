package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdix implements zzdgx<zzdiu> {
    private ScheduledExecutorService zzfmv;
    private zzarg zzgzo;
    private Context zzvr;

    public zzdix(zzarg zzargVar, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzgzo = zzargVar;
        this.zzfmv = scheduledExecutorService;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdiu> zzarj() {
        return zzdyq.zzb(zzdyq.zza(this.zzgzo.zzr(this.zzvr), ((Long) zzwm.zzpx().zzd(zzabb.zzcsu)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv), zzdiw.zzdwz, zzbbz.zzeep);
    }
}
