package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhl implements zzdgx<zzdhi> {
    private final Executor executor;
    private final ScheduledExecutorService zzfmv;
    private final zzaxx zzgyr;
    private final Context zzvr;

    public zzdhl(zzaxx zzaxxVar, Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzgyr = zzaxxVar;
        this.zzvr = context;
        this.zzfmv = scheduledExecutorService;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdhi> zzarj() {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcoq)).booleanValue()) {
            return zzdyq.immediateFailedFuture(new Exception("Did not ad Ad ID into query param."));
        }
        return zzdyl.zzg(this.zzgyr.zzal(this.zzvr)).zza(zzdhk.zzdwz, this.executor).zza(((Long) zzwm.zzpx().zzd(zzabb.zzcor)).longValue(), TimeUnit.MILLISECONDS, this.zzfmv).zza(Throwable.class, new zzdvu(this) { // from class: com.google.android.gms.internal.ads.zzdhn
            private final zzdhl zzgys;

            {
                this.zzgys = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return this.zzgys.zzf((Throwable) obj);
            }
        }, this.executor);
    }

    final /* synthetic */ zzdhi zzf(Throwable th) {
        zzwm.zzpt();
        return new zzdhi(null, zzbbg.zzbo(this.zzvr));
    }
}
