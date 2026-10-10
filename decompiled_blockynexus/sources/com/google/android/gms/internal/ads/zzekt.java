package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzekt {
    private static final zzekt zzikz;
    private static final zzekt zzila;

    static {
        zzekw zzekwVar = null;
        zzikz = new zzekv();
        zzila = new zzeky();
    }

    private zzekt() {
    }

    static zzekt zzbhl() {
        return zzikz;
    }

    static zzekt zzbhm() {
        return zzila;
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);
}
