package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzdyk<V> extends zzdyl<V> implements zzdxq.zzi<V> {
    zzdyk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdxq, java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (V) super.get(j, timeUnit);
    }
}
