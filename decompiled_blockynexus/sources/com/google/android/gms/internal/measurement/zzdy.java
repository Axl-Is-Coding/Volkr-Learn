package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdy<T> implements Serializable {
    zzdy() {
    }

    public static <T> zzdy<T> zza(T t) {
        zzeb.zza(t);
        return new zzea(t);
    }

    public static <T> zzdy<T> zzc() {
        return zzdu.zza;
    }

    public abstract boolean zza();

    public abstract T zzb();
}
