package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeow<T> implements zzeoy<T> {
    private zzeph<T> zziuq;

    public static <T> void zzbk(zzeph<T> zzephVar, zzeph<T> zzephVar2) {
        zzepe.checkNotNull(zzephVar2);
        zzeow zzeowVar = (zzeow) zzephVar;
        if (zzeowVar.zziuq != null) {
            throw new IllegalStateException();
        }
        zzeowVar.zziuq = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final T get() {
        zzeph<T> zzephVar = this.zziuq;
        if (zzephVar != null) {
            return zzephVar.get();
        }
        throw new IllegalStateException();
    }
}
