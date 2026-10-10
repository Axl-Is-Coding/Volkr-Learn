package com.facebook.ads.redexgen.X;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S6<K, V> extends C2R<K, V> implements Map<K, V> {
    public C2O<K, V> A00;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S6 != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    private C2O<K, V> A00() {
        if (this.A00 == null) {
            this.A00 = new S5(this);
        }
        return this.A00;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S6 != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return A00().A0C();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S6 != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    public final Set<K> keySet() {
        return A00().A0D();
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S6 != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        A0E(super.A00 + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.S6 != com.facebook.ads.internal.androidx.support.v4.util.ArrayMap<K, V> */
    @Override // java.util.Map
    public final Collection<V> values() {
        return A00().A0A();
    }
}
