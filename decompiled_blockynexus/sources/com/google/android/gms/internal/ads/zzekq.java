package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzekq<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzeko> zziks;

    private zzekq(Map.Entry<K, zzeko> entry) {
        this.zziks = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zziks.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zziks.getValue() == null) {
            return null;
        }
        zzeko.zzbhh();
        throw null;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzelj) {
            return this.zziks.getValue().zzn((zzelj) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzeko zzbhi() {
        return this.zziks.getValue();
    }
}
