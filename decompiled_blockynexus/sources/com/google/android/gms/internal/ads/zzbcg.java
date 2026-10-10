package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbcg<T> implements zzdzc<T> {
    private final zzdzj<T> zzeez = zzdzj.zzayi();

    private static boolean zzas(boolean z) {
        if (!z) {
            com.google.android.gms.ads.internal.zzp.zzkv().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzdzc
    public void addListener(Runnable runnable, Executor executor) {
        this.zzeez.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return this.zzeez.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return this.zzeez.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.zzeez.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.zzeez.isDone();
    }

    public final boolean set(T t) {
        boolean z = this.zzeez.set(t);
        zzas(z);
        return z;
    }

    public final boolean setException(Throwable th) {
        boolean exception = this.zzeez.setException(th);
        zzas(exception);
        return exception;
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzeez.get(j, timeUnit);
    }
}
