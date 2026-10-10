package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements za<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public abstract Set<V> createCollection();

    @Override // com.google.common.collect.AbstractC2255j
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createUnmodifiableEmptyCollection() {
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.ha
    public Set<V> get(K k) {
        return (Set) super.get((Object) k);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC2255j
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((Object) k, (Iterable) iterable);
    }
}
