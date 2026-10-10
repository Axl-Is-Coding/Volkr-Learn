package com.google.common.collect;

import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final double MAX_LOAD_FACTOR = 1.2d;
    private static final long serialVersionUID = 0;
    private final transient Map.Entry<K, V>[] entries;
    private final transient int mask;
    private final transient ImmutableMapEntry<K, V>[] table;

    private RegularImmutableMap(Map.Entry<K, V>[] entryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr, int i) {
        this.entries = entryArr;
        this.table = immutableMapEntryArr;
        this.mask = i;
    }

    static void checkNoConflictInKeyBucket(Object obj, Map.Entry<?, ?> entry, ImmutableMapEntry<?, ?> immutableMapEntry) {
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getKey()), "key", entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.getNextInKeyBucket();
        }
    }

    static <K, V> RegularImmutableMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntryArray(entryArr.length, entryArr);
    }

    static <K, V> RegularImmutableMap<K, V> fromEntryArray(int i, Map.Entry<K, V>[] entryArr) {
        com.google.common.base.m.b(i, entryArr.length);
        Map.Entry<K, V>[] entryArrCreateEntryArray = i == entryArr.length ? entryArr : ImmutableMapEntry.createEntryArray(i);
        int iA = C2268x.a(i, MAX_LOAD_FACTOR);
        ImmutableMapEntry[] immutableMapEntryArrCreateEntryArray = ImmutableMapEntry.createEntryArray(iA);
        int i2 = iA - 1;
        for (int i3 = 0; i3 < i; i3++) {
            Map.Entry<K, V> entry = entryArr[i3];
            K key = entry.getKey();
            V value = entry.getValue();
            C2259n.a(key, value);
            int iA2 = C2268x.a(key.hashCode()) & i2;
            ImmutableMapEntry immutableMapEntry = immutableMapEntryArrCreateEntryArray[iA2];
            ImmutableMapEntry immutableMapEntry2 = immutableMapEntry == null ? (entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).isReusable() ? (ImmutableMapEntry) entry : new ImmutableMapEntry(key, value) : new ImmutableMapEntry.NonTerminalImmutableMapEntry(key, value, immutableMapEntry);
            immutableMapEntryArrCreateEntryArray[iA2] = immutableMapEntry2;
            entryArrCreateEntryArray[i3] = immutableMapEntry2;
            checkNoConflictInKeyBucket(key, immutableMapEntry2, immutableMapEntry);
        }
        return new RegularImmutableMap<>(entryArrCreateEntryArray, immutableMapEntryArrCreateEntryArray, i2);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) get(obj, this.table, this.mask);
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }

    static <V> V get(Object obj, ImmutableMapEntry<?, V>[] immutableMapEntryArr, int i) {
        if (obj == null) {
            return null;
        }
        for (ImmutableMapEntry<?, V> nextInKeyBucket = immutableMapEntryArr[i & C2268x.a(obj.hashCode())]; nextInKeyBucket != null; nextInKeyBucket = nextInKeyBucket.getNextInKeyBucket()) {
            if (obj.equals(nextInKeyBucket.getKey())) {
                return nextInKeyBucket.getValue();
            }
        }
        return null;
    }
}
