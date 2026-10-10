package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdyw;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdyq extends zzdyx {
    public static <V> zzdzc<V> immediateFailedFuture(Throwable th) {
        zzdwd.checkNotNull(th);
        return new zzdyw.zza(th);
    }

    public static <O> zzdzc<O> zza(zzdyb<O> zzdybVar, Executor executor) {
        zzdzq zzdzqVar = new zzdzq(zzdybVar);
        executor.execute(zzdzqVar);
        return zzdzqVar;
    }

    public static <V> zzdzc<V> zzaf(V v) {
        return v == null ? (zzdzc<V>) zzdyw.zzhth : new zzdyw(v);
    }

    public static <V, X extends Throwable> zzdzc<V> zzb(zzdzc<? extends V> zzdzcVar, Class<X> cls, zzdya<? super X, ? extends V> zzdyaVar, Executor executor) {
        return zzdxm.zza(zzdzcVar, cls, zzdyaVar, executor);
    }

    public static <V> zzdzc<List<V>> zzi(Iterable<? extends zzdzc<? extends V>> iterable) {
        return new zzdyc(zzdwp.zzh(iterable), true);
    }

    public static <V> zzdyv<V> zzj(Iterable<? extends zzdzc<? extends V>> iterable) {
        return new zzdyv<>(false, zzdwp.zzh(iterable), null);
    }

    public static <V> zzdyv<V> zzk(Iterable<? extends zzdzc<? extends V>> iterable) {
        return new zzdyv<>(true, zzdwp.zzh(iterable), null);
    }

    public static <I, O> zzdzc<O> zzb(zzdzc<I> zzdzcVar, zzdya<? super I, ? extends O> zzdyaVar, Executor executor) {
        return zzdxt.zza(zzdzcVar, zzdyaVar, executor);
    }

    public static <V> zzdzc<V> zza(zzdzc<V> zzdzcVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return zzdzcVar.isDone() ? zzdzcVar : zzdzm.zzb(zzdzcVar, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzdzc<O> zzb(zzdzc<I> zzdzcVar, zzdvu<? super I, ? extends O> zzdvuVar, Executor executor) {
        return zzdxt.zza(zzdzcVar, zzdvuVar, executor);
    }

    @SafeVarargs
    public static <V> zzdyv<V> zzb(zzdzc<? extends V>... zzdzcVarArr) {
        return new zzdyv<>(true, zzdwp.zzb(zzdzcVarArr), null);
    }

    @SafeVarargs
    public static <V> zzdyv<V> zza(zzdzc<? extends V>... zzdzcVarArr) {
        return new zzdyv<>(false, zzdwp.zzb(zzdzcVarArr), null);
    }

    public static <V> V zzb(Future<V> future) {
        zzdwd.checkNotNull(future);
        try {
            return (V) zzdzu.getUninterruptibly(future);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new zzdyi((Error) cause);
            }
            throw new zzdzr(cause);
        }
    }

    public static <V> void zza(zzdzc<V> zzdzcVar, zzdyr<? super V> zzdyrVar, Executor executor) {
        zzdwd.checkNotNull(zzdyrVar);
        zzdzcVar.addListener(new zzdys(zzdzcVar, zzdyrVar), executor);
    }

    public static <V> V zza(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return (V) zzdzu.getUninterruptibly(future);
        }
        throw new IllegalStateException(zzdwf.zzb("Future was expected to be done: %s", future));
    }
}
