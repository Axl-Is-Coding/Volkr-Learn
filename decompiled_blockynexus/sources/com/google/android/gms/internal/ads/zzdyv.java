package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdyv<V> {
    private final boolean zzhsj;
    private final zzdwp<zzdzc<? extends V>> zzhtg;

    private zzdyv(boolean z, zzdwp<zzdzc<? extends V>> zzdwpVar) {
        this.zzhsj = z;
        this.zzhtg = zzdwpVar;
    }

    public final <C> zzdzc<C> zza(Callable<C> callable, Executor executor) {
        return new zzdye(this.zzhtg, this.zzhsj, executor, callable);
    }

    /* synthetic */ zzdyv(boolean z, zzdwp zzdwpVar, zzdyt zzdytVar) {
        this(z, zzdwpVar);
    }
}
