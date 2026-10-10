package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzdyl<V> extends zzdyu<V> {
    zzdyl() {
    }

    public static <V> zzdyl<V> zzg(zzdzc<V> zzdzcVar) {
        return zzdzcVar instanceof zzdyl ? (zzdyl) zzdzcVar : new zzdyn(zzdzcVar);
    }

    public final <X extends Throwable> zzdyl<V> zza(Class<X> cls, zzdvu<? super X, ? extends V> zzdvuVar, Executor executor) {
        zzdxo zzdxoVar = new zzdxo(this, cls, zzdvuVar);
        addListener(zzdxoVar, zzdze.zza(executor, zzdxoVar));
        return zzdxoVar;
    }

    public final <T> zzdyl<T> zzb(zzdya<? super V, T> zzdyaVar, Executor executor) {
        zzdwd.checkNotNull(executor);
        zzdxs zzdxsVar = new zzdxs(this, zzdyaVar);
        addListener(zzdxsVar, zzdze.zza(executor, zzdxsVar));
        return zzdxsVar;
    }

    public final <X extends Throwable> zzdyl<V> zza(Class<X> cls, zzdya<? super X, ? extends V> zzdyaVar, Executor executor) {
        zzdxp zzdxpVar = new zzdxp(this, cls, zzdyaVar);
        addListener(zzdxpVar, zzdze.zza(executor, zzdxpVar));
        return zzdxpVar;
    }

    public final zzdyl<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzdyl) zzdyq.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzdyl<T> zza(zzdvu<? super V, T> zzdvuVar, Executor executor) {
        zzdwd.checkNotNull(zzdvuVar);
        zzdxv zzdxvVar = new zzdxv(this, zzdvuVar);
        addListener(zzdxvVar, zzdze.zza(executor, zzdxvVar));
        return zzdxvVar;
    }
}
