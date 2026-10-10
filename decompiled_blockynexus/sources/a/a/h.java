package a.a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: MapCollections.java */
/* JADX INFO: loaded from: classes.dex */
abstract class h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    h<K, V>.b f144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    h<K, V>.c f145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    h<K, V>.e f146c;

    /* JADX INFO: compiled from: MapCollections.java */
    final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f150d = false;

        a(int i) {
            this.f147a = i;
            this.f148b = h.this.c();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f149c < this.f148b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) h.this.a(this.f149c, this.f147a);
            this.f149c++;
            this.f150d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f150d) {
                throw new IllegalStateException();
            }
            this.f149c--;
            this.f148b--;
            this.f150d = false;
            h.this.a(this.f149c);
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        public boolean a(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            a((Map.Entry) obj);
            throw null;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iC = h.this.c();
            for (Map.Entry<K, V> entry : collection) {
                h.this.a(entry.getKey(), entry.getValue());
            }
            return iC != h.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iA = h.this.a(entry.getKey());
            if (iA < 0) {
                return false;
            }
            return a.a.e.a(h.this.a(iA, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iC = h.this.c() - 1; iC >= 0; iC--) {
                Object objA = h.this.a(iC, 0);
                Object objA2 = h.this.a(iC, 1);
                iHashCode += (objA == null ? 0 : objA.hashCode()) ^ (objA2 == null ? 0 : objA2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return h.this.a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return h.a((Map) h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return h.a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iC = h.this.c() - 1; iC >= 0; iC--) {
                Object objA = h.this.a(iC, 0);
                iHashCode += objA == null ? 0 : objA.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iA = h.this.a(obj);
            if (iA < 0) {
                return false;
            }
            h.this.a(iA);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return h.b(h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return h.c(h.this.b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return h.this.c();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return h.this.b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.a(tArr, 0);
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f154a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f156c = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f155b = -1;

        d() {
            this.f154a = h.this.c() - 1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f156c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a.a.e.a(entry.getKey(), h.this.a(this.f155b, 0)) && a.a.e.a(entry.getValue(), h.this.a(this.f155b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f156c) {
                return (K) h.this.a(this.f155b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f156c) {
                return (V) h.this.a(this.f155b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f155b < this.f154a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f156c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objA = h.this.a(this.f155b, 0);
            Object objA2 = h.this.a(this.f155b, 1);
            return (objA == null ? 0 : objA.hashCode()) ^ (objA2 != null ? objA2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            next();
            return this;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f156c) {
                throw new IllegalStateException();
            }
            h.this.a(this.f155b);
            this.f155b--;
            this.f154a--;
            this.f156c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f156c) {
                return (V) h.this.a(this.f155b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f155b++;
            this.f156c = true;
            return this;
        }
    }

    /* JADX INFO: compiled from: MapCollections.java */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            h.this.a();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return h.this.b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return h.this.c() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iB = h.this.b(obj);
            if (iB < 0) {
                return false;
            }
            h.this.a(iB);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iC = h.this.c();
            int i = 0;
            boolean z = false;
            while (i < iC) {
                if (collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    iC--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iC = h.this.c();
            int i = 0;
            boolean z = false;
            while (i < iC) {
                if (!collection.contains(h.this.a(i, 1))) {
                    h.this.a(i);
                    i--;
                    iC--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return h.this.c();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return h.this.b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) h.this.a(tArr, 1);
        }
    }

    h() {
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a();

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    protected abstract int c();

    public Set<Map.Entry<K, V>> d() {
        if (this.f144a == null) {
            this.f144a = new b();
        }
        return this.f144a;
    }

    public Set<K> e() {
        if (this.f145b == null) {
            this.f145b = new c();
        }
        return this.f145b;
    }

    public Collection<V> f() {
        if (this.f146c == null) {
            this.f146c = new e();
        }
        return this.f146c;
    }

    public <T> T[] a(T[] tArr, int i) {
        int iC = c();
        if (tArr.length < iC) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iC));
        }
        for (int i2 = 0; i2 < iC; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > iC) {
            tArr[iC] = null;
        }
        return tArr;
    }

    public Object[] b(int i) {
        int iC = c();
        Object[] objArr = new Object[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }
}
