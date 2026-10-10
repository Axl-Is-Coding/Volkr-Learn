package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multimaps;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements za<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    private transient ImmutableSetMultimap<V, K> inverse;

    private static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> multimap;

        EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.multimap = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Fa<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    public static final class a<K, V> extends ImmutableMultimap.a<K, V> {
        public a() {
            super(MultimapBuilder.a().c().b());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* bridge */ /* synthetic */ ImmutableMultimap.a a(Object obj, Object obj2) {
            a(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* bridge */ /* synthetic */ ImmutableMultimap.a a(Map.Entry entry) {
            a(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public a<K, V> a(K k, V v) {
            ha<K, V> haVar = this.f13836a;
            com.google.common.base.m.a(k);
            com.google.common.base.m.a(v);
            haVar.put(k, v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public a<K, V> a(Map.Entry<? extends K, ? extends V> entry) {
            ha<K, V> haVar = this.f13836a;
            K key = entry.getKey();
            com.google.common.base.m.a(key);
            V value = entry.getValue();
            com.google.common.base.m.a(value);
            haVar.put(key, value);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.a((Iterable) iterable);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.a
        public ImmutableSetMultimap<K, V> a() {
            if (this.f13837b != null) {
                Multimaps.CustomListMultimap customListMultimapB = MultimapBuilder.a().c().b();
                for (Map.Entry entry : Ordering.from(this.f13837b).onKeys().immutableSortedCopy(this.f13836a.asMap().entrySet())) {
                    customListMultimapB.putAll(entry.getKey(), (Iterable) entry.getValue());
                }
                this.f13836a = customListMultimapB;
            }
            return ImmutableSetMultimap.copyOf(this.f13836a, this.f13838c);
        }
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(ha<? extends K, ? extends V> haVar) {
        return copyOf(haVar, null);
    }

    private static <V> ImmutableSet<V> emptySet(Comparator<? super V> comparator) {
        return comparator == null ? ImmutableSet.of() : ImmutableSortedSet.emptySet(comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        a aVarBuilder = builder();
        for (Map.Entry entry : entries()) {
            aVarBuilder.a(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> immutableSetMultimapA = aVarBuilder.a();
        immutableSetMultimapA.inverse = this;
        return immutableSetMultimapA;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException("Invalid key count " + i);
        }
        ImmutableMap.a aVarBuilder = ImmutableMap.builder();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object object = objectInputStream.readObject();
            int i4 = objectInputStream.readInt();
            if (i4 <= 0) {
                throw new InvalidObjectException("Invalid value count " + i4);
            }
            ImmutableSet.a aVarValuesBuilder = valuesBuilder(comparator);
            for (int i5 = 0; i5 < i4; i5++) {
                aVarValuesBuilder.a(objectInputStream.readObject());
            }
            ImmutableSet immutableSetA = aVarValuesBuilder.a();
            if (immutableSetA.size() != i4) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + object);
            }
            aVarBuilder.a(object, immutableSetA);
            i2 += i4;
        }
        try {
            ImmutableMultimap.b.f13839a.a(this, aVarBuilder.a());
            ImmutableMultimap.b.f13840b.a(this, i2);
            ImmutableMultimap.b.f13841c.a(this, emptySet(comparator));
        } catch (IllegalArgumentException e2) {
            throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
        }
    }

    private static <V> ImmutableSet<V> valueSet(Comparator<? super V> comparator, Collection<? extends V> collection) {
        return comparator == null ? ImmutableSet.copyOf((Collection) collection) : ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    private static <V> ImmutableSet.a<V> valuesBuilder(Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.a<>() : new ImmutableSortedSet.a(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        ya.a(this, objectOutputStream);
    }

    Comparator<? super V> valueComparator() {
        ImmutableSet<V> immutableSet = this.emptySet;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(ha<? extends K, ? extends V> haVar, Comparator<? super V> comparator) {
        com.google.common.base.m.a(haVar);
        if (haVar.isEmpty() && comparator == null) {
            return of();
        }
        if (haVar instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) haVar;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        ImmutableMap.a aVar = new ImmutableMap.a(haVar.asMap().size());
        int size = 0;
        for (Map.Entry<? extends K, Collection<? extends V>> entry : haVar.asMap().entrySet()) {
            K key = entry.getKey();
            ImmutableSet immutableSetValueSet = valueSet(comparator, entry.getValue());
            if (!immutableSetValueSet.isEmpty()) {
                aVar.a(key, immutableSetValueSet);
                size += immutableSetValueSet.size();
            }
        }
        return new ImmutableSetMultimap<>(aVar.a(), size, comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        return aVarBuilder.a();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> immutableSetMultimapInvert = invert();
        this.inverse = immutableSetMultimapInvert;
        return immutableSetMultimapInvert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entries = entrySet;
        return entrySet;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.ha
    public ImmutableSet<V> get(K k) {
        return (ImmutableSet) com.google.common.base.j.a((ImmutableSet) this.map.get(k), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @Deprecated
    /* JADX INFO: renamed from: removeAll */
    public ImmutableSet<V> mo61removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractC2255j
    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        aVarBuilder.a((Object) k3, (Object) v3);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        aVarBuilder.a((Object) k3, (Object) v3);
        aVarBuilder.a((Object) k4, (Object) v4);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a();
        aVar.a((Iterable) iterable);
        return aVar.a();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        aVarBuilder.a((Object) k3, (Object) v3);
        aVarBuilder.a((Object) k4, (Object) v4);
        aVarBuilder.a((Object) k5, (Object) v5);
        return aVarBuilder.a();
    }
}
