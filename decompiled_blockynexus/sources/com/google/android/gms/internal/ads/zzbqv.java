package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbqv {
    private final Executor executor;
    private volatile boolean zzafc = true;
    private final ScheduledExecutorService zzfmv;
    private final zzdzc<zzbqu> zzfry;

    public zzbqv(Executor executor, ScheduledExecutorService scheduledExecutorService, zzdzc<zzbqu> zzdzcVar) {
        this.executor = executor;
        this.zzfmv = scheduledExecutorService;
        this.zzfry = zzdzcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaja() {
        zzbbz.zzeet.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbqz
            private final zzbqv zzfsa;

            {
                this.zzfsa = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfsa.zzajb();
            }
        });
    }

    public final boolean isLoading() {
        return this.zzafc;
    }

    public final void zza(zzdyr<zzbqo> zzdyrVar) {
        zzdyq.zza(this.zzfry, new zzbrc(this, zzdyrVar), this.executor);
    }

    final /* synthetic */ void zzajb() {
        this.zzafc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(List<? extends zzdzc<? extends zzbqo>> list, final zzdyr<zzbqo> zzdyrVar) {
        if (list == null || list.isEmpty()) {
            this.executor.execute(new Runnable(zzdyrVar) { // from class: com.google.android.gms.internal.ads.zzbqy
                private final zzdyr zzfrz;

                {
                    this.zzfrz = zzdyrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzfrz.zzb(new zzcof(zzdpg.NO_FILL));
                }
            });
            return;
        }
        zzdzc zzdzcVarZzaf = zzdyq.zzaf(null);
        for (final zzdzc<? extends zzbqo> zzdzcVar : list) {
            zzdzcVarZzaf = zzdyq.zzb(zzdyq.zzb(zzdzcVarZzaf, Throwable.class, new zzdya(zzdyrVar) { // from class: com.google.android.gms.internal.ads.zzbqx
                private final zzdyr zzfrz;

                {
                    this.zzfrz = zzdyrVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) {
                    this.zzfrz.zzb((Throwable) obj);
                    return zzdyq.zzaf(null);
                }
            }, this.executor), new zzdya(this, zzdyrVar, zzdzcVar) { // from class: com.google.android.gms.internal.ads.zzbra
                private final zzbqv zzfsa;
                private final zzdyr zzfsb;
                private final zzdzc zzfsc;

                {
                    this.zzfsa = this;
                    this.zzfsb = zzdyrVar;
                    this.zzfsc = zzdzcVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) {
                    return this.zzfsa.zza(this.zzfsb, this.zzfsc, (zzbqo) obj);
                }
            }, this.executor);
        }
        zzdyq.zza(zzdzcVarZzaf, new zzbrb(this, zzdyrVar), this.executor);
    }

    final /* synthetic */ zzdzc zza(zzdyr zzdyrVar, zzdzc zzdzcVar, zzbqo zzbqoVar) throws Exception {
        if (zzbqoVar != null) {
            zzdyrVar.onSuccess(zzbqoVar);
        }
        return zzdyq.zza(zzdzcVar, zzadf.zzdcp.get().longValue(), TimeUnit.MILLISECONDS, this.zzfmv);
    }
}
