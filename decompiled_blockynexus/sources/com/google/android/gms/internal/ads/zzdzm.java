package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzm<V> extends zzdyk<V> {
    private zzdzc<V> zzhtu;
    private ScheduledFuture<?> zzhtv;

    private zzdzm(zzdzc<V> zzdzcVar) {
        zzdwd.checkNotNull(zzdzcVar);
        this.zzhtu = zzdzcVar;
    }

    static <V> zzdzc<V> zzb(zzdzc<V> zzdzcVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        zzdzm zzdzmVar = new zzdzm(zzdzcVar);
        zzdzo zzdzoVar = new zzdzo(zzdzmVar);
        zzdzmVar.zzhtv = scheduledExecutorService.schedule(zzdzoVar, j, timeUnit);
        zzdzcVar.addListener(zzdzoVar, zzdyj.INSTANCE);
        return zzdzmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final void afterDone() {
        maybePropagateCancellationTo(this.zzhtu);
        ScheduledFuture<?> scheduledFuture = this.zzhtv;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzhtu = null;
        this.zzhtv = null;
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final String pendingToString() {
        zzdzc<V> zzdzcVar = this.zzhtu;
        ScheduledFuture<?> scheduledFuture = this.zzhtv;
        if (zzdzcVar == null) {
            return null;
        }
        String strValueOf = String.valueOf(zzdzcVar);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 14);
        sb.append("inputFuture=[");
        sb.append(strValueOf);
        sb.append("]");
        String string = sb.toString();
        if (scheduledFuture == null) {
            return string;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return string;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 43);
        sb2.append(strValueOf2);
        sb2.append(", remaining delay=[");
        sb2.append(delay);
        sb2.append(" ms]");
        return sb2.toString();
    }

    static /* synthetic */ ScheduledFuture zza(zzdzm zzdzmVar, ScheduledFuture scheduledFuture) {
        zzdzmVar.zzhtv = null;
        return null;
    }
}
