package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.oa;
import com.google.common.collect.ya;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultimap<K, V> extends AbstractC2255j<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
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
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Fa<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    class Keys extends ImmutableMultiset<K> {
        Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.oa
        public int count(Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        @Override // com.google.common.collect.oa
        public Set<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        oa.a<K> getEntry(int i) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i);
            return Multisets.a(entry.getKey(), entry.getValue().size());
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ImmutableMultimap.this.size();
        }
    }

    private static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        private final transient ImmutableMultimap<K, V> multimap;

        Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.multimap.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        int copyIntoArray(Object[] objArr, int i) {
            Iterator it = this.multimap.map.values().iterator();
            while (it.hasNext()) {
                i = ((ImmutableCollection) it.next()).copyIntoArray(objArr, i);
            }
            return i;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Fa<V> iterator() {
            return this.multimap.valueIterator();
        }
    }

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ha<K, V> f13836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator<? super K> f13837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Comparator<? super V> f13838c;

        public a() {
            this(MultimapBuilder.a().a().b());
        }

        public a<K, V> a(K k, V v) {
            C2259n.a(k, v);
            this.f13836a.put(k, v);
            return this;
        }

        a(ha<K, V> haVar) {
            this.f13836a = haVar;
        }

        public a<K, V> a(Map.Entry<? extends K, ? extends V> entry) {
            return a(entry.getKey(), entry.getValue());
        }

        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            Iterator<? extends Map.Entry<? extends K, ? extends V>> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ImmutableMultimap<K, V> a() {
            if (this.f13838c != null) {
                Iterator<Collection<V>> it = this.f13836a.asMap().values().iterator();
                while (it.hasNext()) {
                    Collections.sort((List) it.next(), this.f13838c);
                }
            }
            if (this.f13837b != null) {
                Multimaps.CustomListMultimap customListMultimapB = MultimapBuilder.a().a().b();
                for (Map.Entry entry : Ordering.from(this.f13837b).onKeys().immutableSortedCopy(this.f13836a.asMap().entrySet())) {
                    customListMultimapB.putAll(entry.getKey(), (Iterable) entry.getValue());
                }
                this.f13836a = customListMultimapB;
            }
            return ImmutableMultimap.copyOf(this.f13836a);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ya.a<ImmutableMultimap> f13839a = ya.a(ImmutableMultimap.class, "map");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final ya.a<ImmutableMultimap> f13840b = ya.a(ImmutableMultimap.class, "size");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final ya.a<ImmutableSetMultimap> f13841c = ya.a(ImmutableSetMultimap.class, "emptySet");
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(ha<? extends K, ? extends V> haVar) {
        if (haVar instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) haVar;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((ha) haVar);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    @Override // com.google.common.collect.ha
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.ha
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC2255j
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractC2255j
    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractC2255j
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.ha
    public abstract ImmutableCollection<V> get(K k);

    @Override // com.google.common.collect.AbstractC2255j
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    @Deprecated
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    @Deprecated
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ha
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractC2255j
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of((Object) k, (Object) v);
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC2255j
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC2255j
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC2255j
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC2255j
    public Fa<Map.Entry<K, V>> entryIterator() {
        return new F(this);
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.AbstractC2255j
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.AbstractC2255j
    @Deprecated
    public boolean putAll(ha<? extends K, ? extends V> haVar) {
        throw new UnsupportedOperationException();
    }

    @Override // 
    @Deprecated
    /* JADX INFO: renamed from: removeAll, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection<V> mo61removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractC2255j
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractC2255j
    public Fa<V> valueIterator() {
        return new G(this);
    }

    @Override // com.google.common.collect.AbstractC2255j
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class c<T> extends Fa<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f13842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        K f13843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Iterator<V> f13844c;

        private c() {
            this.f13842a = ImmutableMultimap.this.asMap().entrySet().iterator();
            this.f13843b = null;
            this.f13844c = V.a();
        }

        abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13842a.hasNext() || this.f13844c.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f13844c.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f13842a.next();
                this.f13843b = next.getKey();
                this.f13844c = next.getValue().iterator();
            }
            return a(this.f13843b, this.f13844c.next());
        }

        /* synthetic */ c(ImmutableMultimap immutableMultimap, F f2) {
            this();
        }
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }
}
