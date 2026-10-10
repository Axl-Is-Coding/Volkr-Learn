package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdym<V> extends zzdwi implements Future<V> {
    protected zzdym() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return zzaxh().cancel(z);
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return zzaxh().get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return zzaxh().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return zzaxh().isDone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdwi
    /* JADX INFO: renamed from: zzayf, reason: merged with bridge method [inline-methods] */
    public abstract Future<? extends V> zzaxh();

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return zzaxh().get(j, timeUnit);
    }
}
