package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbch<T> extends zzbcg<T> {
    private final T zzefa;

    private zzbch(T t) {
        this.zzefa = t;
    }

    public static <T> zzbch<T> zzl(T t) {
        return new zzbch<>(t);
    }

    public final void zzyw() {
        set(this.zzefa);
    }
}
