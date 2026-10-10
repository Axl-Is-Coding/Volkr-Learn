package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzq<V> extends zzdyk<V> implements RunnableFuture<V> {
    private volatile zzdyy<?> zzhtz;

    private zzdzq(Callable<V> callable) {
        this.zzhtz = new zzdzs(this, callable);
    }

    static <V> zzdzq<V> zza(Runnable runnable, V v) {
        return new zzdzq<>(Executors.callable(runnable, v));
    }

    static <V> zzdzq<V> zzf(Callable<V> callable) {
        return new zzdzq<>(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final void afterDone() {
        zzdyy<?> zzdyyVar;
        super.afterDone();
        if (wasInterrupted() && (zzdyyVar = this.zzhtz) != null) {
            zzdyyVar.interruptTask();
        }
        this.zzhtz = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final String pendingToString() {
        zzdyy<?> zzdyyVar = this.zzhtz;
        if (zzdyyVar == null) {
            return super.pendingToString();
        }
        String strValueOf = String.valueOf(zzdyyVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 7);
        sb.append("task=[");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzdyy<?> zzdyyVar = this.zzhtz;
        if (zzdyyVar != null) {
            zzdyyVar.run();
        }
        this.zzhtz = null;
    }

    zzdzq(zzdyb<V> zzdybVar) {
        this.zzhtz = new zzdzp(this, zzdybVar);
    }
}
