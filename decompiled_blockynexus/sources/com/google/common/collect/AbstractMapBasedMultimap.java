package com.google.common.collect;

import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMapBasedMultimap<K, V> extends AbstractC2255j<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    private class a extends Maps.d<K, Collection<V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient Map<K, Collection<V>> f13778c;

        /* JADX INFO: renamed from: com.google.common.collect.AbstractMapBasedMultimap$a$a, reason: collision with other inner class name */
        class C0132a extends Maps.a<K, Collection<V>> {
            C0132a() {
            }

            @Override // com.google.common.collect.Maps.a
            Map<K, Collection<V>> a() {
                return a.this;
            }

            @Override // com.google.common.collect.Maps.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return C2261p.a(a.this.f13778c.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return a.this.new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMapBasedMultimap.this.removeValuesForKey(((Map.Entry) obj).getKey());
                return true;
            }
        }

        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f13781a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Collection<V> f13782b;

            b() {
                this.f13781a = a.this.f13778c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f13781a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f13781a.remove();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, this.f13782b.size());
                this.f13782b.clear();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f13781a.next();
                this.f13782b = next.getValue();
                return a.this.a(next);
            }
        }

        a(Map<K, Collection<V>> map) {
            this.f13778c = map;
        }

        @Override // com.google.common.collect.Maps.d
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new C0132a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f13778c == AbstractMapBasedMultimap.this.map) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                V.a((Iterator<?>) new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return Maps.d(this.f13778c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f13778c.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f13778c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f13778c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f13778c.toString();
        }

        Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.a(key, AbstractMapBasedMultimap.this.wrapCollection(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) Maps.e(this.f13778c, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.wrapCollection(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.f13778c.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionCreateCollection = AbstractMapBasedMultimap.this.createCollection();
            collectionCreateCollection.addAll(collectionRemove);
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collectionRemove.size());
            collectionRemove.clear();
            return collectionCreateCollection;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f13784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        K f13785b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection<V> f13786c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Iterator<V> f13787d = V.c();

        b() {
            this.f13784a = AbstractMapBasedMultimap.this.map.entrySet().iterator();
        }

        abstract T a(K k, V v);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13784a.hasNext() || this.f13787d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f13787d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f13784a.next();
                this.f13785b = next.getKey();
                this.f13786c = next.getValue();
                this.f13787d = this.f13786c.iterator();
            }
            return a(this.f13785b, this.f13787d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f13787d.remove();
            if (this.f13786c.isEmpty()) {
                this.f13784a.remove();
            }
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c extends Maps.b<K, Collection<V>> {
        c(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            V.a((Iterator<?>) iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return a().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new C2247e(this, a().entrySet().iterator());
        }

        @Override // com.google.common.collect.Maps.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int size;
            Collection<V> collectionRemove = a().remove(obj);
            if (collectionRemove != null) {
                size = collectionRemove.size();
                collectionRemove.clear();
                AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    private class d extends AbstractMapBasedMultimap<K, V>.h implements RandomAccess {
        d(K k, List<V> list, AbstractMapBasedMultimap<K, V>.g gVar) {
            super(k, list, gVar);
        }
    }

    private class e extends AbstractMapBasedMultimap<K, V>.a implements SortedMap<K, Collection<V>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        SortedSet<K> f13790e;

        e(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedSet<K> c() {
            return new f(d());
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        SortedMap<K, Collection<V>> d() {
            return (SortedMap) this.f13778c;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return d().firstKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> headMap(K k) {
            return new e(d().headMap(k));
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return d().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new e(d().subMap(k, k2));
        }

        @Override // java.util.SortedMap
        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new e(d().tailMap(k));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.a, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f13790e;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> sortedSetC = c();
            this.f13790e = sortedSetC;
            return sortedSetC;
        }
    }

    private class f extends AbstractMapBasedMultimap<K, V>.c implements SortedSet<K> {
        f(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        SortedMap<K, Collection<V>> c() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return c().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return c().firstKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> headSet(K k) {
            return new f(c().headMap(k));
        }

        @Override // java.util.SortedSet
        public K last() {
            return c().lastKey();
        }

        @Override // java.util.SortedSet
        public SortedSet<K> subSet(K k, K k2) {
            return new f(c().subMap(k, k2));
        }

        @Override // java.util.SortedSet
        public SortedSet<K> tailSet(K k) {
            return new f(c().tailMap(k));
        }
    }

    private class i extends AbstractMapBasedMultimap<K, V>.g implements Set<V> {
        i(K k, Set<V> set) {
            super(k, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.g, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zA = Aa.a((Set<?>) this.f13794b, collection);
            if (zA) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f13794b.size() - size);
                i();
            }
            return zA;
        }
    }

    private class j extends AbstractMapBasedMultimap<K, V>.g implements SortedSet<V> {
        j(K k, SortedSet<V> sortedSet, AbstractMapBasedMultimap<K, V>.g gVar) {
            super(k, sortedSet, gVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            h();
            return j().first();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v) {
            h();
            return new j(f(), j().headSet(v), c() == null ? this : c());
        }

        SortedSet<V> j() {
            return (SortedSet) e();
        }

        @Override // java.util.SortedSet
        public V last() {
            h();
            return j().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v, V v2) {
            h();
            return new j(f(), j().subSet(v, v2), c() == null ? this : c());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v) {
            h();
            return new j(f(), j().tailSet(v), c() == null ? this : c());
        }
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        com.google.common.base.m.a(map.isEmpty());
        this.map = map;
    }

    static /* synthetic */ int access$208(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 + 1;
        return i2;
    }

    static /* synthetic */ int access$210(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.totalSize;
        abstractMapBasedMultimap.totalSize = i2 - 1;
        return i2;
    }

    static /* synthetic */ int access$212(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.totalSize + i2;
        abstractMapBasedMultimap.totalSize = i3;
        return i3;
    }

    static /* synthetic */ int access$220(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.totalSize - i2;
        abstractMapBasedMultimap.totalSize = i3;
        return i3;
    }

    private Collection<V> getOrCreateCollection(K k) {
        Collection<V> collection = this.map.get(k);
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateCollection = createCollection(k);
        this.map.put(k, collectionCreateCollection);
        return collectionCreateCollection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator<V> iteratorOrListIterator(Collection<V> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int removeValuesForKey(Object obj) {
        Collection collection = (Collection) Maps.f(this.map, obj);
        if (collection == null) {
            return 0;
        }
        int size = collection.size();
        collection.clear();
        this.totalSize -= size;
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<V> wrapList(K k, List<V> list, AbstractMapBasedMultimap<K, V>.g gVar) {
        return list instanceof RandomAccess ? new d(k, list, gVar) : new h(k, list, gVar);
    }

    Map<K, Collection<V>> backingMap() {
        return this.map;
    }

    @Override // com.google.common.collect.ha
    public void clear() {
        Iterator<Collection<V>> it = this.map.values().iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.ha
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractC2255j
    Map<K, Collection<V>> createAsMap() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof SortedMap ? new e((SortedMap) map) : new a(map);
    }

    abstract Collection<V> createCollection();

    Collection<V> createCollection(K k) {
        return createCollection();
    }

    @Override // com.google.common.collect.AbstractC2255j
    Set<K> createKeySet() {
        Map<K, Collection<V>> map = this.map;
        return map instanceof SortedMap ? new f((SortedMap) map) : new c(map);
    }

    Collection<V> createUnmodifiableEmptyCollection() {
        return unmodifiableCollectionSubclass(createCollection());
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractC2255j
    Iterator<Map.Entry<K, V>> entryIterator() {
        return new C2245d(this);
    }

    @Override // com.google.common.collect.ha
    public Collection<V> get(K k) {
        Collection<V> collectionCreateCollection = this.map.get(k);
        if (collectionCreateCollection == null) {
            collectionCreateCollection = createCollection(k);
        }
        return wrapCollection(k, collectionCreateCollection);
    }

    @Override // com.google.common.collect.AbstractC2255j, com.google.common.collect.ha
    public boolean put(K k, V v) {
        Collection<V> collection = this.map.get(k);
        if (collection != null) {
            if (!collection.add(v)) {
                return false;
            }
            this.totalSize++;
            return true;
        }
        Collection<V> collectionCreateCollection = createCollection(k);
        if (!collectionCreateCollection.add(v)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.totalSize++;
        this.map.put(k, collectionCreateCollection);
        return true;
    }

    public Collection<V> removeAll(Object obj) {
        Collection<V> collectionRemove = this.map.remove(obj);
        if (collectionRemove == null) {
            return createUnmodifiableEmptyCollection();
        }
        Collection<V> collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(collectionRemove);
        this.totalSize -= collectionRemove.size();
        collectionRemove.clear();
        return unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    @Override // com.google.common.collect.AbstractC2255j
    public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k);
        }
        Collection<V> orCreateCollection = getOrCreateCollection(k);
        Collection<V> collectionCreateCollection = createCollection();
        collectionCreateCollection.addAll(orCreateCollection);
        this.totalSize -= orCreateCollection.size();
        orCreateCollection.clear();
        while (it.hasNext()) {
            if (orCreateCollection.add(it.next())) {
                this.totalSize++;
            }
        }
        return unmodifiableCollectionSubclass(collectionCreateCollection);
    }

    final void setMap(Map<K, Collection<V>> map) {
        this.map = map;
        this.totalSize = 0;
        for (Collection<V> collection : map.values()) {
            com.google.common.base.m.a(!collection.isEmpty());
            this.totalSize += collection.size();
        }
    }

    @Override // com.google.common.collect.ha
    public int size() {
        return this.totalSize;
    }

    Collection<V> unmodifiableCollectionSubclass(Collection<V> collection) {
        return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    @Override // com.google.common.collect.AbstractC2255j
    Iterator<V> valueIterator() {
        return new C2243c(this);
    }

    @Override // com.google.common.collect.AbstractC2255j
    public Collection<V> values() {
        return super.values();
    }

    Collection<V> wrapCollection(K k, Collection<V> collection) {
        return collection instanceof SortedSet ? new j(k, (SortedSet) collection, null) : collection instanceof Set ? new i(k, (Set) collection) : collection instanceof List ? wrapList(k, (List) collection, null) : new g(k, collection, null);
    }

    private class g extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f13793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection<V> f13794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AbstractMapBasedMultimap<K, V>.g f13795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection<V> f13796d;

        g(K k, Collection<V> collection, AbstractMapBasedMultimap<K, V>.g gVar) {
            this.f13793a = k;
            this.f13794b = collection;
            this.f13795c = gVar;
            this.f13796d = gVar == null ? null : gVar.e();
        }

        void a() {
            AbstractMapBasedMultimap<K, V>.g gVar = this.f13795c;
            if (gVar != null) {
                gVar.a();
            } else {
                AbstractMapBasedMultimap.this.map.put(this.f13793a, this.f13794b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            h();
            boolean zIsEmpty = this.f13794b.isEmpty();
            boolean zAdd = this.f13794b.add(v);
            if (zAdd) {
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f13794b.addAll(collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f13794b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        AbstractMapBasedMultimap<K, V>.g c() {
            return this.f13795c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f13794b.clear();
            AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, size);
            i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            h();
            return this.f13794b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            h();
            return this.f13794b.containsAll(collection);
        }

        Collection<V> e() {
            return this.f13794b;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            h();
            return this.f13794b.equals(obj);
        }

        K f() {
            return this.f13793a;
        }

        void h() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.g gVar = this.f13795c;
            if (gVar != null) {
                gVar.h();
                if (this.f13795c.e() != this.f13796d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f13794b.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.map.get(this.f13793a)) == null) {
                    return;
                }
                this.f13794b = collection;
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            h();
            return this.f13794b.hashCode();
        }

        void i() {
            AbstractMapBasedMultimap<K, V>.g gVar = this.f13795c;
            if (gVar != null) {
                gVar.i();
            } else if (this.f13794b.isEmpty()) {
                AbstractMapBasedMultimap.this.map.remove(this.f13793a);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            h();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            h();
            boolean zRemove = this.f13794b.remove(obj);
            if (zRemove) {
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                i();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f13794b.removeAll(collection);
            if (zRemoveAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f13794b.size() - size);
                i();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.m.a(collection);
            int size = size();
            boolean zRetainAll = this.f13794b.retainAll(collection);
            if (zRetainAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, this.f13794b.size() - size);
                i();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            h();
            return this.f13794b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            h();
            return this.f13794b.toString();
        }

        class a implements Iterator<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<V> f13798a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Collection<V> f13799b;

            a() {
                this.f13799b = g.this.f13794b;
                this.f13798a = AbstractMapBasedMultimap.this.iteratorOrListIterator(g.this.f13794b);
            }

            Iterator<V> a() {
                b();
                return this.f13798a;
            }

            void b() {
                g.this.h();
                if (g.this.f13794b != this.f13799b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f13798a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f13798a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f13798a.remove();
                AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
                g.this.i();
            }

            a(Iterator<V> it) {
                this.f13799b = g.this.f13794b;
                this.f13798a = it;
            }
        }
    }

    private class h extends AbstractMapBasedMultimap<K, V>.g implements List<V> {

        private class a extends AbstractMapBasedMultimap<K, V>.g.a implements ListIterator<V> {
            a() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v) {
                boolean zIsEmpty = h.this.isEmpty();
                c().add(v);
                AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
                if (zIsEmpty) {
                    h.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v) {
                c().set(v);
            }

            public a(int i) {
                super(h.this.j().listIterator(i));
            }
        }

        h(K k, List<V> list, AbstractMapBasedMultimap<K, V>.g gVar) {
            super(k, list, gVar);
        }

        @Override // java.util.List
        public void add(int i, V v) {
            h();
            boolean zIsEmpty = e().isEmpty();
            j().add(i, v);
            AbstractMapBasedMultimap.access$208(AbstractMapBasedMultimap.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = j().addAll(i, collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.access$212(AbstractMapBasedMultimap.this, e().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public V get(int i) {
            h();
            return j().get(i);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            h();
            return j().indexOf(obj);
        }

        List<V> j() {
            return (List) e();
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            h();
            return j().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            h();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i) {
            h();
            V vRemove = j().remove(i);
            AbstractMapBasedMultimap.access$210(AbstractMapBasedMultimap.this);
            i();
            return vRemove;
        }

        @Override // java.util.List
        public V set(int i, V v) {
            h();
            return j().set(i, v);
        }

        @Override // java.util.List
        public List<V> subList(int i, int i2) {
            h();
            return AbstractMapBasedMultimap.this.wrapList(f(), j().subList(i, i2), c() == null ? this : c());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i) {
            h();
            return new a(i);
        }
    }
}
