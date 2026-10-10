package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdry {
    private final E zzhjx;
    private final /* synthetic */ zzdru zzhkd;

    private zzdry(zzdru zzdruVar, E e2) {
        this.zzhkd = zzdruVar;
        this.zzhjx = e2;
    }

    private final <O> zzdsa<O> zza(Callable<O> callable, zzdzb zzdzbVar) {
        return new zzdsa<>(this.zzhkd, this.zzhjx, zzdru.zzhka, Collections.emptyList(), zzdzbVar.submit(callable));
    }

    public final <O> zzdsa<O> zzc(Callable<O> callable) {
        return zza(callable, this.zzhkd.zzgcz);
    }

    public final <O> zzdsa<O> zze(zzdzc<O> zzdzcVar) {
        return new zzdsa<>(this.zzhkd, this.zzhjx, zzdru.zzhka, Collections.emptyList(), zzdzcVar);
    }

    public final zzdsa<?> zza(final zzdrs zzdrsVar, zzdzb zzdzbVar) {
        return zza(new Callable(zzdrsVar) { // from class: com.google.android.gms.internal.ads.zzdrx
            private final zzdrs zzhke;

            {
                this.zzhke = zzdrsVar;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                this.zzhke.run();
                return null;
            }
        }, zzdzbVar);
    }
}
