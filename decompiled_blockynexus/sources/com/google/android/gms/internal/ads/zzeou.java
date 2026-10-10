package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.b;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeou<K, V, V2> {
    final LinkedHashMap<K, zzeph<V>> zziun;

    zzeou(int i) {
        this.zziun = zzeot.zzia(i);
    }

    zzeou<K, V, V2> zza(K k, zzeph<V> zzephVar) {
        LinkedHashMap<K, zzeph<V>> linkedHashMap = this.zziun;
        zzepe.zza(k, "key");
        zzepe.zza(zzephVar, b.L);
        linkedHashMap.put(k, zzephVar);
        return this;
    }
}
