package com.google.android.gms.internal.ads;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzh<V> extends zzdyo<V> implements zzdzc<V>, ScheduledFuture<V> {
    private final ScheduledFuture<?> zzhtr;

    public zzdzh(zzdzc<V> zzdzcVar, ScheduledFuture<?> scheduledFuture) {
        super(zzdzcVar);
        this.zzhtr = scheduledFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzdym, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        boolean zCancel = super.cancel(z);
        if (zCancel) {
            this.zzhtr.cancel(z);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Delayed delayed) {
        return this.zzhtr.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return this.zzhtr.getDelay(timeUnit);
    }
}
