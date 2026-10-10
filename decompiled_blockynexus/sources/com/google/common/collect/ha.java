package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Multimap.java */
/* JADX INFO: loaded from: classes2.dex */
public interface ha<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(Object obj, Object obj2);

    boolean containsKey(Object obj);

    Collection<Map.Entry<K, V>> entries();

    Collection<V> get(K k);

    boolean isEmpty();

    Set<K> keySet();

    boolean put(K k, V v);

    boolean putAll(K k, Iterable<? extends V> iterable);

    boolean remove(Object obj, Object obj2);

    int size();
}
