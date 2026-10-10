package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeov<T> implements zzeos<T>, zzeph<T> {
    private static final Object zziuo = new Object();
    private volatile Object zzedi = zziuo;
    private volatile zzeph<T> zziup;

    private zzeov(zzeph<T> zzephVar) {
        this.zziup = zzephVar;
    }

    public static <P extends zzeph<T>, T> zzeph<T> zzas(P p) {
        zzepe.checkNotNull(p);
        return p instanceof zzeov ? p : new zzeov(p);
    }

    public static <P extends zzeph<T>, T> zzeos<T> zzat(P p) {
        if (p instanceof zzeos) {
            return (zzeos) p;
        }
        zzepe.checkNotNull(p);
        return new zzeov(p);
    }

    @Override // com.google.android.gms.internal.ads.zzeos, com.google.android.gms.internal.ads.zzeph
    public final T get() {
        T t = (T) this.zzedi;
        if (t == zziuo) {
            synchronized (this) {
                t = (T) this.zzedi;
                if (t == zziuo) {
                    t = this.zziup.get();
                    Object obj = this.zzedi;
                    if (((obj == zziuo || (obj instanceof zzepb)) ? false : true) && obj != t) {
                        String strValueOf = String.valueOf(obj);
                        String strValueOf2 = String.valueOf(t);
                        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 118 + String.valueOf(strValueOf2).length());
                        sb.append("Scoped provider was invoked recursively returning different results: ");
                        sb.append(strValueOf);
                        sb.append(" & ");
                        sb.append(strValueOf2);
                        sb.append(". This is likely due to a circular dependency.");
                        throw new IllegalStateException(sb.toString());
                    }
                    this.zzedi = t;
                    this.zziup = null;
                }
            }
        }
        return t;
    }
}
