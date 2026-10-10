package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhz implements zzdgx<zzdhw> {
    private final Executor executor;
    private final zzayb zzbpw;
    private final ScheduledExecutorService zzfmv;
    private final int zzgls;
    private final zzaxx zzgyr;
    private final Context zzvr;

    public zzdhz(zzaxx zzaxxVar, int i, Context context, zzayb zzaybVar, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzgyr = zzaxxVar;
        this.zzgls = i;
        this.zzvr = context;
        this.zzbpw = zzaybVar;
        this.zzfmv = scheduledExecutorService;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdhw> zzarj() {
        return zzdyl.zzg(zzdyq.zza(new zzdyb(this) { // from class: com.google.android.gms.internal.ads.zzdhy
            private final zzdhz zzgza;

            {
                this.zzgza = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdyb
            public final zzdzc zzarv() {
                return this.zzgza.zzase();
            }
        }, this.executor)).zza(zzdib.zzdwz, this.executor).zza(((Long) zzwm.zzpx().zzd(zzabb.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv).zza(Exception.class, new zzdvu(this) { // from class: com.google.android.gms.internal.ads.zzdia
            private final zzdhz zzgza;

            {
                this.zzgza = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return this.zzgza.zzb((Exception) obj);
            }
        }, zzdze.zzayh());
    }

    final /* synthetic */ zzdzc zzase() throws Exception {
        return this.zzgyr.zza(this.zzvr, this.zzgls);
    }

    final /* synthetic */ zzdhw zzb(Exception exc) {
        this.zzbpw.zza(exc, "AttestationTokenSignal");
        return null;
    }
}
