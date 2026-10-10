package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdyh<V> extends zzdyg<V> {
    private final /* synthetic */ zzdye zzhsz;
    private final Callable<V> zzhta;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzdyh(zzdye zzdyeVar, Callable<V> callable, Executor executor) {
        super(zzdyeVar, executor);
        this.zzhsz = zzdyeVar;
        zzdwd.checkNotNull(callable);
        this.zzhta = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzdyg
    final void setValue(V v) {
        this.zzhsz.set(v);
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final V zzayd() throws Exception {
        this.zzhsy = false;
        return this.zzhta.call();
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final String zzaye() {
        return this.zzhta.toString();
    }
}
