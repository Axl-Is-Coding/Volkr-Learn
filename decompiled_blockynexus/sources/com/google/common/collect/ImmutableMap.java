package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> createEntrySet() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                ImmutableMap<K, V> map() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                public Fa<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.entryIterator();
                }
            };
        }

        abstract Fa<Map.Entry<K, V>> entryIterator();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        private MapViewOfValuesAsSingletonSets() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        Fa<Map.Entry<K, ImmutableSet<V>>> entryIterator() {
            return new D(this, ImmutableMap.this.entrySet().iterator());
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isHashCodeFast() {
            return ImmutableMap.this.isHashCodeFast();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean isPartialView() {
            return ImmutableMap.this.isPartialView();
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        /* synthetic */ MapViewOfValuesAsSingletonSets(ImmutableMap immutableMap, B b2) {
            this();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<V> get(Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap, java.util.Map
        public ImmutableSet<K> keySet() {
            return ImmutableMap.this.keySet();
        }
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object[] keys;
        private final Object[] values;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            Iterator it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                this.keys[i] = entry.getKey();
                this.values[i] = entry.getValue();
                i++;
            }
        }

        Object createMap(a<Object, Object> aVar) {
            int i = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i >= objArr.length) {
                    return aVar.a();
                }
                aVar.a(objArr[i], this.values[i]);
                i++;
            }
        }

        Object readResolve() {
            return createMap(new a<>(this.keys.length));
        }
    }

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator<? super V> f13832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ImmutableMapEntry<K, V>[] f13833b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13834c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f13835d;

        public a() {
            this(4);
        }

        private void a(int i) {
            ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.f13833b;
            if (i > immutableMapEntryArr.length) {
                this.f13833b = (ImmutableMapEntry[]) ra.a((Object[]) immutableMapEntryArr, ImmutableCollection.b.a(immutableMapEntryArr.length, i));
                this.f13835d = false;
            }
        }

        a(int i) {
            this.f13833b = new ImmutableMapEntry[i];
            this.f13834c = 0;
            this.f13835d = false;
        }

        public a<K, V> a(K k, V v) {
            a(this.f13834c + 1);
            ImmutableMapEntry<K, V> immutableMapEntryEntryOf = ImmutableMap.entryOf(k, v);
            ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.f13833b;
            int i = this.f13834c;
            this.f13834c = i + 1;
            immutableMapEntryArr[i] = immutableMapEntryEntryOf;
            return this;
        }

        public a<K, V> a(Map.Entry<? extends K, ? extends V> entry) {
            return a(entry.getKey(), entry.getValue());
        }

        public a<K, V> a(Map<? extends K, ? extends V> map) {
            return a(map.entrySet());
        }

        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                a(this.f13834c + ((Collection) iterable).size());
            }
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableMap<K, V> a() {
            int i = this.f13834c;
            if (i == 0) {
                return ImmutableMap.of();
            }
            if (i != 1) {
                if (this.f13832a != null) {
                    if (this.f13835d) {
                        this.f13833b = (ImmutableMapEntry[]) ra.a((Object[]) this.f13833b, i);
                    }
                    Arrays.sort(this.f13833b, 0, this.f13834c, Ordering.from(this.f13832a).onResultOf(Maps.d()));
                }
                this.f13835d = this.f13834c == this.f13833b.length;
                return RegularImmutableMap.fromEntryArray(this.f13834c, this.f13833b);
            }
            return ImmutableMap.of((Object) this.f13833b[0].getKey(), (Object) this.f13833b[0].getValue());
        }
    }

    ImmutableMap() {
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    static void checkNoConflict(boolean z, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Multiple entries with same " + str + ": " + entry + " and " + entry2);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof ImmutableSortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.isPartialView()) {
                return immutableMap;
            }
        } else if (map instanceof EnumMap) {
            return copyOfEnumMap((EnumMap) map);
        }
        return copyOf(map.entrySet());
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> copyOfEnumMap(EnumMap<K, ? extends V> enumMap) {
        EnumMap enumMap2 = new EnumMap((EnumMap) enumMap);
        for (Map.Entry<K, V> entry : enumMap2.entrySet()) {
            C2259n.a(entry.getKey(), entry.getValue());
        }
        return ImmutableEnumMap.asImmutable(enumMap2);
    }

    static <K, V> ImmutableMapEntry<K, V> entryOf(K k, V v) {
        return new ImmutableMapEntry<>(k, v);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return ImmutableBiMap.of();
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    abstract ImmutableSet<Map.Entry<K, V>> createEntrySet();

    ImmutableSet<K> createKeySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapKeySet(this);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.c(this, obj);
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public int hashCode() {
        return Aa.a(entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    boolean isHashCodeFast() {
        return false;
    }

    abstract boolean isPartialView();

    Fa<K> keyIterator() {
        return new B(this, entrySet().iterator());
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.a(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v) {
        return ImmutableBiMap.of((Object) k, (Object) v);
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> immutableSetCreateEntrySet = createEntrySet();
        this.entrySet = immutableSetCreateEntrySet;
        return immutableSetCreateEntrySet;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> immutableSetCreateKeySet = createKeySet();
        this.keySet = immutableSetCreateKeySet;
        return immutableSetCreateKeySet;
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableMapValues immutableMapValues = new ImmutableMapValues(this);
        this.values = immutableMapValues;
        return immutableMapValues;
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2) {
        return RegularImmutableMap.fromEntries(entryOf(k, v), entryOf(k2, v2));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return RegularImmutableMap.fromEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return RegularImmutableMap.fromEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4));
    }

    public static <K, V> ImmutableMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return RegularImmutableMap.fromEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5));
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) L.a((Iterable) iterable, (Object[]) EMPTY_ENTRY_ARRAY);
        int length = entryArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return RegularImmutableMap.fromEntries(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return of(entry.getKey(), entry.getValue());
    }
}
