package com.google.common.collect;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: renamed from: com.google.common.collect.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ForwardingConcurrentMap.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractConcurrentMapC2264t<K, V> extends AbstractC2265u<K, V> implements ConcurrentMap<K, V> {
    protected AbstractConcurrentMapC2264t() {
    }

    @Override // com.google.common.collect.AbstractC2265u, com.google.common.collect.AbstractC2266v
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.AbstractC2265u, com.google.common.collect.AbstractC2266v
    protected abstract /* bridge */ /* synthetic */ Map delegate();

    @Override // com.google.common.collect.AbstractC2265u, com.google.common.collect.AbstractC2266v
    protected abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        return delegate().putIfAbsent(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        return delegate().replace(k, v);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v2) {
        return delegate().replace(k, v, v2);
    }
}
