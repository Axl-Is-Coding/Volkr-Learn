package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
class ImmutableEntry<K, V> extends AbstractC2253h<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K key;
    final V value;

    ImmutableEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
