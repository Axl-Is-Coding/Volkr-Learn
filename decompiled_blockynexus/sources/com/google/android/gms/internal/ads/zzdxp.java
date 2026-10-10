package com.google.android.gms.internal.ads;

import java.lang.Throwable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxp<V, X extends Throwable> extends zzdxm<V, X, zzdya<? super X, ? extends V>, zzdzc<? extends V>> {
    zzdxp(zzdzc<? extends V> zzdzcVar, Class<X> cls, zzdya<? super X, ? extends V> zzdyaVar) {
        super(zzdzcVar, cls, zzdyaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxm
    final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdzc) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdxm
    final /* synthetic */ Object zza(Object obj, Throwable th) throws Exception {
        zzdya zzdyaVar = (zzdya) obj;
        zzdzc zzdzcVarZzf = zzdyaVar.zzf(th);
        zzdwd.zza(zzdzcVarZzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyaVar);
        return zzdzcVarZzf;
    }
}
