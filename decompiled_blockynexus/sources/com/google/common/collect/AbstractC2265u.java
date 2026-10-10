package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.common.collect.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ForwardingMap.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2265u<K, V> extends AbstractC2266v implements Map<K, V> {
    protected AbstractC2265u() {
    }

    @Override // java.util.Map
    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractC2266v
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.AbstractC2266v
    protected abstract Map<K, V> delegate();

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return delegate().put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    protected void standardClear() {
        V.a((Iterator<?>) entrySet().iterator());
    }

    protected boolean standardContainsKey(Object obj) {
        return Maps.a((Map<?, ?>) this, obj);
    }

    protected boolean standardContainsValue(Object obj) {
        return Maps.b(this, obj);
    }

    protected boolean standardEquals(Object obj) {
        return Maps.c(this, obj);
    }

    protected int standardHashCode() {
        return Aa.a(entrySet());
    }

    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    protected void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.a((Map) this, (Map) map);
    }

    protected V standardRemove(Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (com.google.common.base.k.a(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    protected String standardToString() {
        return Maps.a(this);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return delegate().values();
    }
}
