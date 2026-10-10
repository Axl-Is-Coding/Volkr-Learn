package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzi extends zzdzf implements zzdzb, ScheduledExecutorService {
    private final ScheduledExecutorService zzhts;

    zzdzi(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        zzdwd.checkNotNull(scheduledExecutorService);
        this.zzhts = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzdzq zzdzqVarZzf = zzdzq.zzf(callable);
        return new zzdzh(zzdzqVarZzf, this.zzhts.schedule(zzdzqVarZzf, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdzk zzdzkVar = new zzdzk(runnable);
        return new zzdzh(zzdzkVar, this.zzhts.scheduleAtFixedRate(zzdzkVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzdzk zzdzkVar = new zzdzk(runnable);
        return new zzdzh(zzdzkVar, this.zzhts.scheduleWithFixedDelay(zzdzkVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzdzq zzdzqVarZza = zzdzq.zza(runnable, (Object) null);
        return new zzdzh(zzdzqVarZza, this.zzhts.schedule(zzdzqVarZza, j, timeUnit));
    }
}
