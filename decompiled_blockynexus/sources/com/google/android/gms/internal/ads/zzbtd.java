package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbtd implements zzbuh, zzbuv, zzbyc, zzbzu {
    private final Executor executor;
    private final zzbuu zzftk;
    private final zzdnv zzftl;
    private final ScheduledExecutorService zzftm;
    private zzdzj<Boolean> zzftn = zzdzj.zzayi();
    private ScheduledFuture<?> zzfto;

    public zzbtd(zzbuu zzbuuVar, zzdnv zzdnvVar, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzftk = zzbuuVar;
        this.zzftl = zzdnvVar;
        this.zzftm = scheduledExecutorService;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onAdOpened() {
        int i = this.zzftl.zzhed;
        if (i == 0 || i == 1) {
            this.zzftk.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzu
    public final void zzajj() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqh)).booleanValue()) {
            zzdnv zzdnvVar = this.zzftl;
            if (zzdnvVar.zzhed == 2) {
                if (zzdnvVar.zzhdp == 0) {
                    this.zzftk.onAdImpression();
                } else {
                    zzdyq.zza(this.zzftn, new zzbtf(this), this.executor);
                    this.zzfto = this.zzftm.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbtg
                        private final zzbtd zzftq;

                        {
                            this.zzftq = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzftq.zzajn();
                        }
                    }, this.zzftl.zzhdp, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyc
    public final synchronized void zzajk() {
        if (this.zzftn.isDone()) {
            return;
        }
        if (this.zzfto != null) {
            this.zzfto.cancel(true);
        }
        this.zzftn.set(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbzu
    public final void zzajl() {
    }

    @Override // com.google.android.gms.internal.ads.zzbyc
    public final void zzajm() {
    }

    final /* synthetic */ void zzajn() {
        synchronized (this) {
            if (this.zzftn.isDone()) {
                return;
            }
            this.zzftn.set(true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuh
    public final void zzb(zzatw zzatwVar, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final synchronized void zzj(zzva zzvaVar) {
        if (this.zzftn.isDone()) {
            return;
        }
        if (this.zzfto != null) {
            this.zzfto.cancel(true);
        }
        this.zzftn.setException(new Exception());
    }
}
