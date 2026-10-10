package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxv<I, O> extends zzdxt<I, O, zzdvu<? super I, ? extends O>, O> {
    zzdxv(zzdzc<? extends I> zzdzcVar, zzdvu<? super I, ? extends O> zzdvuVar) {
        super(zzdzcVar, zzdvuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxt
    final void setResult(O o) {
        set(o);
    }

    @Override // com.google.android.gms.internal.ads.zzdxt
    final /* synthetic */ Object zzd(Object obj, Object obj2) throws Exception {
        return ((zzdvu) obj).apply(obj2);
    }
}
