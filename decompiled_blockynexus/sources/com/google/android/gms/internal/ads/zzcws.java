package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcws<AdT> implements zzeoy<zzcwq<AdT>> {
    public static <AdT> zzcwq<AdT> zza(zzdsi zzdsiVar, zzcwj zzcwjVar, zzbug zzbugVar, zzdsr zzdsrVar, zzdst zzdstVar, zzbqp<AdT> zzbqpVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzctd zzctdVar) {
        return new zzcwq<>(zzdsiVar, zzcwjVar, zzbugVar, zzdsrVar, zzdstVar, zzbqpVar, executor, scheduledExecutorService, zzctdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}
