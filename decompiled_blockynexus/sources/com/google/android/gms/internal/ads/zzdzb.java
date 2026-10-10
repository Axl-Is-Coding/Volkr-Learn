package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzdzb extends ExecutorService {
    <T> zzdzc<T> zze(Callable<T> callable);

    zzdzc<?> zzg(Runnable runnable);
}
