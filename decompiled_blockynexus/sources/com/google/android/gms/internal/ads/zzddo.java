package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdgu;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzddo<S extends zzdgu<?>> {
    private final Clock zzbqa;
    public final zzdzc<S> zzgwg;
    private final long zzgwh;

    public zzddo(zzdzc<S> zzdzcVar, long j, Clock clock) {
        this.zzgwg = zzdzcVar;
        this.zzbqa = clock;
        this.zzgwh = clock.elapsedRealtime() + j;
    }

    public final boolean hasExpired() {
        return this.zzgwh < this.zzbqa.elapsedRealtime();
    }
}
