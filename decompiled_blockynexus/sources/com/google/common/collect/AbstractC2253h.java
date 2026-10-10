package com.google.common.collect;

import java.util.Map;

/* JADX INFO: renamed from: com.google.common.collect.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMapEntry.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC2253h<K, V> implements Map.Entry<K, V> {
    AbstractC2253h() {
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return com.google.common.base.k.a(getKey(), entry.getKey()) && com.google.common.base.k.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (key == null ? 0 : key.hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
