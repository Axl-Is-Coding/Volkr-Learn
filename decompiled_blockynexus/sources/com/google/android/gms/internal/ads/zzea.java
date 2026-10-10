package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzea implements Runnable {
    private final /* synthetic */ Context zzxp;

    zzea(zzdy zzdyVar, Context context) {
        this.zzxp = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zzb(this.zzxp);
        } catch (Exception e2) {
            zzdy.zzxg.zza(2019, -1L, e2);
        }
    }
}
