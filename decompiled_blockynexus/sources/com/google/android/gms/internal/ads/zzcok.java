package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcok implements zzdya {
    static final zzdya zzboo = new zzcok();

    private zzcok() {
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final zzdzc zzf(Object obj) {
        return zzdyq.immediateFailedFuture(((ExecutionException) obj).getCause());
    }
}
