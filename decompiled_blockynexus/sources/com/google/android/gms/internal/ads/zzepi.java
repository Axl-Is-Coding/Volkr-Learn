package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzepi<T> implements zzeph<T> {
    private static final Object zziuo = new Object();
    private volatile Object zzedi = zziuo;
    private volatile zzeph<T> zziup;

    private zzepi(zzeph<T> zzephVar) {
        this.zziup = zzephVar;
    }

    public static <P extends zzeph<T>, T> zzeph<T> zzas(P p) {
        if ((p instanceof zzepi) || (p instanceof zzeov)) {
            return p;
        }
        zzepe.checkNotNull(p);
        return new zzepi(p);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final T get() {
        T t = (T) this.zzedi;
        if (t != zziuo) {
            return t;
        }
        zzeph<T> zzephVar = this.zziup;
        if (zzephVar == null) {
            return (T) this.zzedi;
        }
        T t2 = zzephVar.get();
        this.zzedi = t2;
        this.zziup = null;
        return t2;
    }
}
