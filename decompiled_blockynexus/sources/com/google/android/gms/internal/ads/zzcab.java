package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcab<T> {
    public Executor executor;
    public T zzfwk;

    public zzcab(T t, Executor executor) {
        this.zzfwk = t;
        this.executor = executor;
    }

    public static <T> zzcab<T> zzb(T t, Executor executor) {
        return new zzcab<>(t, executor);
    }
}
