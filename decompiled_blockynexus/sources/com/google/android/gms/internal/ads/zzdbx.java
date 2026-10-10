package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbx implements zzdgx<Object> {
    private final Executor executor;
    private final zzdzc<String> zzgvd;

    public zzdbx(zzdzc<String> zzdzcVar, Executor executor) {
        this.zzgvd = zzdzcVar;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<Object> zzarj() {
        return zzdyq.zzb(this.zzgvd, zzdbw.zzboo, this.executor);
    }
}
