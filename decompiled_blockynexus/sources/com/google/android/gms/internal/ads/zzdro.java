package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdro implements zzeoy<ScheduledExecutorService> {
    private final zzeph<ThreadFactory> zzhjv;

    public zzdro(zzeph<ThreadFactory> zzephVar) {
        this.zzhjv = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        ScheduledExecutorService scheduledExecutorServiceZzb = zzdvg.zzaxc().zzb(1, this.zzhjv.get(), zzdvl.zzhov);
        zzepe.zza(scheduledExecutorServiceZzb, "Cannot return null from a non-@Nullable @Provides method");
        return scheduledExecutorServiceZzb;
    }
}
