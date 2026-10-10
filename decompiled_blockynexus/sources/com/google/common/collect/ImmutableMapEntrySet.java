package com.google.common.collect;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImmutableMapEntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

    private static class EntrySetSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, V> map;

        EntrySetSerializedForm(ImmutableMap<K, V> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.entrySet();
        }
    }

    static final class RegularEntrySet<K, V> extends ImmutableMapEntrySet<K, V> {
        private final transient Map.Entry<K, V>[] entries;
        private final transient ImmutableMap<K, V> map;

        RegularEntrySet(ImmutableMap<K, V> immutableMap, Map.Entry<K, V>[] entryArr) {
            this.map = immutableMap;
            this.entries = entryArr;
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new RegularImmutableAsList(this, this.entries);
        }

        @Override // com.google.common.collect.ImmutableMapEntrySet
        ImmutableMap<K, V> map() {
            return this.map;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Fa<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    ImmutableMapEntrySet() {
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        V v = map().get(entry.getKey());
        return v != null && v.equals(entry.getValue());
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return map().hashCode();
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return map().isHashCodeFast();
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return map().isPartialView();
    }

    abstract ImmutableMap<K, V> map();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return map().size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new EntrySetSerializedForm(map());
    }
}
