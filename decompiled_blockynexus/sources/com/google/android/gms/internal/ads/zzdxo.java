package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxo<V, X extends Throwable> extends zzdxm<V, X, zzdvu<? super X, ? extends V>, V> {
    zzdxo(zzdzc<? extends V> zzdzcVar, Class<X> cls, zzdvu<? super X, ? extends V> zzdvuVar) {
        super(zzdzcVar, cls, zzdvuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxm
    final void setResult(V v) {
        set(v);
    }

    @Override // com.google.android.gms.internal.ads.zzdxm
    final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        return ((zzdvu) obj).apply(th);
    }
}
