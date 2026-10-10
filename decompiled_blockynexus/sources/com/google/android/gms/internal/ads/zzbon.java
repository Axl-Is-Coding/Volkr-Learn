package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbon implements zzeoy<zzbwk> {
    private final zzeph<Clock> zzfok;
    private final zzeph<ScheduledExecutorService> zzfpy;

    public zzbon(zzeph<ScheduledExecutorService> zzephVar, zzeph<Clock> zzephVar2) {
        this.zzfpy = zzephVar;
        this.zzfok = zzephVar2;
    }

    public static zzbwk zza(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        zzbwk zzbwkVar = new zzbwk(scheduledExecutorService, clock);
        zzepe.zza(zzbwkVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbwkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfpy.get(), this.zzfok.get());
    }
}
