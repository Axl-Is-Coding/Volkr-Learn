package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: com.google.common.collect.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMultimap.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC2255j<K, V> implements ha<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Map.Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient oa<K> keys;
    private transient Collection<V> values;

    /* JADX INFO: renamed from: com.google.common.collect.j$a */
    /* JADX INFO: compiled from: AbstractMultimap.java */
    private class a extends Multimaps.a<K, V> {
        private a() {
        }

        @Override // com.google.common.collect.Multimaps.a
        ha<K, V> a() {
            return AbstractC2255j.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractC2255j.this.entryIterator();
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.j$b */
    /* JADX INFO: compiled from: AbstractMultimap.java */
    private class b extends AbstractC2255j<K, V>.a implements Set<Map.Entry<K, V>> {
        private b() {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Aa.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Aa.a(this);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.j$c */
    /* JADX INFO: compiled from: AbstractMultimap.java */
    class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractC2255j.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC2255j.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return AbstractC2255j.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractC2255j.this.size();
        }
    }

    AbstractC2255j() {
    }

    @Override // com.google.common.collect.ha
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapCreateAsMap = createAsMap();
        this.asMap = mapCreateAsMap;
        return mapCreateAsMap;
    }

    @Override // com.google.common.collect.ha
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map<K, Collection<V>> createAsMap();

    Collection<Map.Entry<K, V>> createEntries() {
        return this instanceof za ? new b() : new a();
    }

    Set<K> createKeySet() {
        return new Maps.b(asMap());
    }

    oa<K> createKeys() {
        return new Multimaps.b(this);
    }

    Collection<V> createValues() {
        return new c();
    }

    @Override // com.google.common.collect.ha
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> collectionCreateEntries = createEntries();
        this.entries = collectionCreateEntries;
        return collectionCreateEntries;
    }

    abstract Iterator<Map.Entry<K, V>> entryIterator();

    public boolean equals(Object obj) {
        return Multimaps.a(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.ha
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.ha
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.keySet = setCreateKeySet;
        return setCreateKeySet;
    }

    public oa<K> keys() {
        oa<K> oaVar = this.keys;
        if (oaVar != null) {
            return oaVar;
        }
        oa<K> oaVarCreateKeys = createKeys();
        this.keys = oaVarCreateKeys;
        return oaVarCreateKeys;
    }

    @Override // com.google.common.collect.ha
    public abstract boolean put(K k, V v);

    @Override // com.google.common.collect.ha
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        com.google.common.base.m.a(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && V.a(get(k), it);
    }

    @Override // com.google.common.collect.ha
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public abstract Collection<V> replaceValues(K k, Iterable<? extends V> iterable);

    public String toString() {
        return asMap().toString();
    }

    abstract Iterator<V> valueIterator();

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.values = collectionCreateValues;
        return collectionCreateValues;
    }

    public boolean putAll(ha<? extends K, ? extends V> haVar) {
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : haVar.entries()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }
}
