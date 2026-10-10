package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzs<V> extends zzdyy<V> {
    private final Callable<V> zzhta;
    private final /* synthetic */ zzdzq zzhty;

    zzdzs(zzdzq zzdzqVar, Callable<V> callable) {
        this.zzhty = zzdzqVar;
        zzdwd.checkNotNull(callable);
        this.zzhta = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final boolean isDone() {
        return this.zzhty.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final V zzayd() throws Exception {
        return this.zzhta.call();
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final String zzaye() {
        return this.zzhta.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final void zzb(V v, Throwable th) {
        if (th == null) {
            this.zzhty.set(v);
        } else {
            this.zzhty.setException(th);
        }
    }
}
