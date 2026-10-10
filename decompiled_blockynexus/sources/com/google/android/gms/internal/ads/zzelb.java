package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzelb<K, V> {
    static <K, V> void zza(zzejj zzejjVar, zzele<K, V> zzeleVar, K k, V v) throws IOException {
        zzejs.zza(zzejjVar, zzeleVar.zzili, 1, k);
        zzejs.zza(zzejjVar, zzeleVar.zzilk, 2, v);
    }

    static <K, V> int zza(zzele<K, V> zzeleVar, K k, V v) {
        return zzejs.zza(zzeleVar.zzili, 1, k) + zzejs.zza(zzeleVar.zzilk, 2, v);
    }
}
