package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzepa<K, V> extends zzeor<K, V, V> {
    private static final zzeph<Map<Object, Object>> zzius = zzeox.zzba(Collections.emptyMap());

    private zzepa(Map<K, zzeph<V>> map) {
        super(map);
    }

    public static <K, V> zzepc<K, V> zzic(int i) {
        return new zzepc<>(i);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        LinkedHashMap linkedHashMapZzia = zzeot.zzia(zzbki().size());
        for (Map.Entry<K, zzeph<V>> entry : zzbki().entrySet()) {
            linkedHashMapZzia.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(linkedHashMapZzia);
    }
}
