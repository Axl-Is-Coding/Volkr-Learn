package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdrr<E, V> implements zzdzc<V> {
    private final E zzhjx;
    private final String zzhjy;
    private final zzdzc<V> zzhjz;

    public zzdrr(E e2, String str, zzdzc<V> zzdzcVar) {
        this.zzhjx = e2;
        this.zzhjy = str;
        this.zzhjz = zzdzcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdzc
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhjz.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.zzhjz.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        return this.zzhjz.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzhjz.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzhjz.isDone();
    }

    public final String toString() {
        String str = this.zzhjy;
        int iIdentityHashCode = System.identityHashCode(this);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(str);
        sb.append("@");
        sb.append(iIdentityHashCode);
        return sb.toString();
    }

    public final E zzavp() {
        return this.zzhjx;
    }

    public final String zzavq() {
        return this.zzhjy;
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzhjz.get(j, timeUnit);
    }
}
