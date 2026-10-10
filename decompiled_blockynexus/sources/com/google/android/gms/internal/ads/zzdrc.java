package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdrc implements zzeoy<Executor> {
    public static zzdrc zzava() {
        return zzdrb.zzhjp;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdzb zzdzbVar = zzbbz.zzeet;
        zzepe.zza(zzdzbVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdzbVar;
    }
}
