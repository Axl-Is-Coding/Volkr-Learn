package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
interface zzemf<T> {
    boolean equals(T t, T t2);

    int hashCode(T t);

    T newInstance();

    void zza(T t, zzelz zzelzVar, zzejm zzejmVar) throws IOException;

    void zza(T t, zzenu zzenuVar) throws IOException;

    void zza(T t, byte[] bArr, int i, int i2, zzeik zzeikVar) throws IOException;

    void zzaj(T t);

    int zzat(T t);

    boolean zzav(T t);

    void zzg(T t, T t2);
}
