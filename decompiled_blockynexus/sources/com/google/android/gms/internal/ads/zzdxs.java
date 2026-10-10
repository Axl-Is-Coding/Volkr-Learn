package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxs<I, O> extends zzdxt<I, O, zzdya<? super I, ? extends O>, zzdzc<? extends O>> {
    zzdxs(zzdzc<? extends I> zzdzcVar, zzdya<? super I, ? extends O> zzdyaVar) {
        super(zzdzcVar, zzdyaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxt
    final /* synthetic */ void setResult(Object obj) {
        setFuture((zzdzc) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdxt
    final /* synthetic */ Object zzd(Object obj, Object obj2) throws Exception {
        zzdya zzdyaVar = (zzdya) obj;
        zzdzc<O> zzdzcVarZzf = zzdyaVar.zzf(obj2);
        zzdwd.zza(zzdzcVarZzf, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzdyaVar);
        return zzdzcVarZzf;
    }
}
