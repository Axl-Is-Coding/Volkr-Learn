package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdze {
    public static zzdzb zza(ExecutorService executorService) {
        return executorService instanceof zzdzb ? (zzdzb) executorService : executorService instanceof ScheduledExecutorService ? new zzdzi((ScheduledExecutorService) executorService) : new zzdzf(executorService);
    }

    public static Executor zzayh() {
        return zzdyj.INSTANCE;
    }

    static Executor zza(Executor executor, zzdxq<?> zzdxqVar) {
        zzdwd.checkNotNull(executor);
        zzdwd.checkNotNull(zzdxqVar);
        return executor == zzdyj.INSTANCE ? executor : new zzdzd(executor, zzdxqVar);
    }
}
