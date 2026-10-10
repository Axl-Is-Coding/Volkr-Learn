package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcz implements zzdgx<zzdcw> {
    private final Executor executor;
    private final ScheduledExecutorService zzfmv;
    private final Context zzvr;

    public zzdcz(Context context, ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zzvr = context;
        this.zzfmv = scheduledExecutorService;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdcw> zzarj() {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcwp)).booleanValue()) {
            return zzdyq.zzaf(null);
        }
        final zzbcg zzbcgVar = new zzbcg();
        try {
            new zzdvq(zzbcgVar) { // from class: com.google.android.gms.internal.ads.zzdcy
                private final zzbcg zzbvu;

                {
                    this.zzbvu = zzbcgVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdvq
                public final void zzbm(boolean z) {
                    this.zzbvu.set(false);
                }
            }.zzbm(false);
        } catch (Throwable unused) {
            zzbbq.zzfc("ArCoreApk is not ready.");
            zzbcgVar.set(false);
        }
        return zzdyq.zzb(zzdyq.zzb(zzdyq.zza(zzbcgVar, 200L, TimeUnit.MILLISECONDS, this.zzfmv), new zzdvu(this) { // from class: com.google.android.gms.internal.ads.zzddb
            private final zzdcz zzgwa;

            {
                this.zzgwa = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return new zzdcw(false, false, ((Boolean) obj).booleanValue());
            }
        }, this.executor), Throwable.class, zzdda.zzboo, this.executor);
    }
}
