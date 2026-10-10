package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzeor<K, V, V2> implements zzeoy<Map<K, V2>> {
    private final Map<K, zzeph<V>> zzium;

    zzeor(Map<K, zzeph<V>> map) {
        this.zzium = Collections.unmodifiableMap(map);
    }

    final Map<K, zzeph<V>> zzbki() {
        return this.zzium;
    }
}
