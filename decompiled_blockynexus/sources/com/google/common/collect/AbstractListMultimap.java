package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements W<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public abstract List<V> createCollection();

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
    public List<V> createUnmodifiableEmptyCollection() {
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.ha
    public List<V> get(K k) {
        return (List) super.get((Object) k);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractC2255j
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((Object) k, (Iterable) iterable);
    }
}
