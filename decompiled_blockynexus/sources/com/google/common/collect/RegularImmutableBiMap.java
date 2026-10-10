package com.google.common.collect;

import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    static final double MAX_LOAD_FACTOR = 1.2d;
    private final transient Map.Entry<K, V>[] entries;
    private final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;
    private final transient ImmutableMapEntry<K, V>[] keyTable;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] valueTable;

    private final class Inverse extends ImmutableBiMap<V, K> {

        final class InverseEntrySet extends ImmutableMapEntrySet<V, K> {
            InverseEntrySet() {
            }

            @Override // com.google.common.collect.ImmutableCollection
            ImmutableList<Map.Entry<V, K>> createAsList() {
                return new ImmutableAsList<Map.Entry<V, K>>() { // from class: com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.1
                    @Override // com.google.common.collect.ImmutableAsList
                    ImmutableCollection<Map.Entry<V, K>> delegateCollection() {
                        return InverseEntrySet.this;
                    }

                    @Override // java.util.List
                    public Map.Entry<V, K> get(int i) {
                        Map.Entry entry = RegularImmutableBiMap.this.entries[i];
                        return Maps.a(entry.getValue(), entry.getKey());
                    }
                };
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return RegularImmutableBiMap.this.hashCode;
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet
            boolean isHashCodeFast() {
                return true;
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet
            ImmutableMap<V, K> map() {
                return Inverse.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            public Fa<Map.Entry<V, K>> iterator() {
                return asList().iterator();
            }
        }

        private Inverse() {
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<V, K>> createEntrySet() {
            return new InverseEntrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object obj) {
            if (obj != null && RegularImmutableBiMap.this.valueTable != null) {
                for (ImmutableMapEntry nextInValueBucket = RegularImmutableBiMap.this.valueTable[C2268x.a(obj.hashCode()) & RegularImmutableBiMap.this.mask]; nextInValueBucket != null; nextInValueBucket = nextInValueBucket.getNextInValueBucket()) {
                    if (obj.equals(nextInValueBucket.getValue())) {
                        return nextInValueBucket.getKey();
                    }
                }
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.Map
        public int size() {
            return mo60inverse().size();
        }

        @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return new InverseSerializedForm(RegularImmutableBiMap.this);
        }

        @Override // com.google.common.collect.ImmutableBiMap
        /* JADX INFO: renamed from: inverse */
        public ImmutableBiMap<K, V> mo60inverse() {
            return RegularImmutableBiMap.this;
        }
    }

    private static class InverseSerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        private final ImmutableBiMap<K, V> forward;

        InverseSerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            this.forward = immutableBiMap;
        }

        Object readResolve() {
            return this.forward.mo60inverse();
        }
    }

    private RegularImmutableBiMap(ImmutableMapEntry<K, V>[] immutableMapEntryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr2, Map.Entry<K, V>[] entryArr, int i, int i2) {
        this.keyTable = immutableMapEntryArr;
        this.valueTable = immutableMapEntryArr2;
        this.entries = entryArr;
        this.mask = i;
        this.hashCode = i2;
    }

    private static void checkNoConflictInValueBucket(Object obj, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> immutableMapEntry) {
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getValue()), "value", entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.getNextInValueBucket();
        }
    }

    static <K, V> RegularImmutableBiMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntryArray(entryArr.length, entryArr);
    }

    static <K, V> RegularImmutableBiMap<K, V> fromEntryArray(int i, Map.Entry<K, V>[] entryArr) {
        ImmutableMapEntry nonTerminalImmutableBiMapEntry;
        int i2 = i;
        com.google.common.base.m.b(i2, entryArr.length);
        int iA = C2268x.a(i2, MAX_LOAD_FACTOR);
        int i3 = iA - 1;
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray = ImmutableMapEntry.createEntryArray(iA);
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray2 = ImmutableMapEntry.createEntryArray(iA);
        Map.Entry<K, V>[] entryArrCreateEntryArray = i2 == entryArr.length ? entryArr : ImmutableMapEntry.createEntryArray(i);
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Map.Entry<K, V> entry = entryArr[i4];
            K key = entry.getKey();
            V value = entry.getValue();
            C2259n.a(key, value);
            int iHashCode = key.hashCode();
            int iHashCode2 = value.hashCode();
            int iA2 = C2268x.a(iHashCode) & i3;
            int iA3 = C2268x.a(iHashCode2) & i3;
            ImmutableMapEntry immutableMapEntry = immutableMapEntryArrCreateEntryArray[iA2];
            RegularImmutableMap.checkNoConflictInKeyBucket(key, entry, immutableMapEntry);
            ImmutableMapEntry immutableMapEntry2 = immutableMapEntryArrCreateEntryArray2[iA3];
            checkNoConflictInValueBucket(value, entry, immutableMapEntry2);
            if (immutableMapEntry2 == null && immutableMapEntry == null) {
                nonTerminalImmutableBiMapEntry = (entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).isReusable() ? (ImmutableMapEntry) entry : new ImmutableMapEntry(key, value);
            } else {
                nonTerminalImmutableBiMapEntry = new ImmutableMapEntry.NonTerminalImmutableBiMapEntry(key, value, immutableMapEntry, immutableMapEntry2);
            }
            immutableMapEntryArrCreateEntryArray[iA2] = nonTerminalImmutableBiMapEntry;
            immutableMapEntryArrCreateEntryArray2[iA3] = nonTerminalImmutableBiMapEntry;
            entryArrCreateEntryArray[i4] = nonTerminalImmutableBiMapEntry;
            i5 += iHashCode ^ iHashCode2;
            i4++;
            i2 = i;
        }
        return new RegularImmutableBiMap<>(immutableMapEntryArrCreateEntryArray, immutableMapEntryArrCreateEntryArray2, entryArrCreateEntryArray, i3, i5);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.keyTable;
        if (immutableMapEntryArr == null) {
            return null;
        }
        return (V) RegularImmutableMap.get(obj, immutableMapEntryArr, this.mask);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    @Override // com.google.common.collect.ImmutableBiMap
    /* JADX INFO: renamed from: inverse */
    public ImmutableBiMap<V, K> mo60inverse() {
        if (isEmpty()) {
            return ImmutableBiMap.of();
        }
        ImmutableBiMap<V, K> immutableBiMap = this.inverse;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        Inverse inverse = new Inverse();
        this.inverse = inverse;
        return inverse;
    }
}
