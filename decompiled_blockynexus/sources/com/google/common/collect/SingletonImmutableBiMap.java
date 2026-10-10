package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    transient ImmutableBiMap<V, K> inverse;
    final transient K singleKey;
    final transient V singleValue;

    SingletonImmutableBiMap(K k, V v) {
        C2259n.a(k, v);
        this.singleKey = k;
        this.singleValue = v;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.singleKey.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this.singleValue.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.of(Maps.a(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.of(this.singleKey);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        if (this.singleKey.equals(obj)) {
            return this.singleValue;
        }
        return null;
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableBiMap
    /* JADX INFO: renamed from: inverse */
    public ImmutableBiMap<V, K> mo60inverse() {
        ImmutableBiMap<V, K> immutableBiMap = this.inverse;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        SingletonImmutableBiMap singletonImmutableBiMap = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
        this.inverse = singletonImmutableBiMap;
        return singletonImmutableBiMap;
    }

    private SingletonImmutableBiMap(K k, V v, ImmutableBiMap<V, K> immutableBiMap) {
        this.singleKey = k;
        this.singleValue = v;
        this.inverse = immutableBiMap;
    }
}
