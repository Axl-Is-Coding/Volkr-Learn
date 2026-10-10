package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzdyw<V> implements zzdzc<V> {
    private final V value;
    static final zzdzc<?> zzhth = new zzdyw(null);
    private static final Logger zzhrt = Logger.getLogger(zzdyw.class.getName());

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zza<V> extends zzdxq.zzh<V> {
        zza(Throwable th) {
            setException(th);
        }
    }

    zzdyw(V v) {
        this.value = v;
    }

    @Override // com.google.android.gms.internal.ads.zzdzc
    public void addListener(Runnable runnable, Executor executor) {
        zzdwd.checkNotNull(runnable, "Runnable was null.");
        zzdwd.checkNotNull(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = zzhrt;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 57 + String.valueOf(strValueOf2).length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", sb.toString(), (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public V get() {
        return this.value;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }

    public String toString() {
        String string = super.toString();
        String strValueOf = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 27 + String.valueOf(strValueOf).length());
        sb.append(string);
        sb.append("[status=SUCCESS, result=[");
        sb.append(strValueOf);
        sb.append("]]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        zzdwd.checkNotNull(timeUnit);
        return get();
    }
}
