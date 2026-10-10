package androidx.arch.core.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c<K, V> f735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<K, V> f736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f737c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f738d = 0;

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.arch.core.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f742d;
        }

        @Override // androidx.arch.core.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f741c;
        }
    }

    /* JADX INFO: renamed from: androidx.arch.core.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static class C0006b<K, V> extends e<K, V> {
        C0006b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.arch.core.b.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f741c;
        }

        @Override // androidx.arch.core.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f742d;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final V f740b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c<K, V> f741c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c<K, V> f742d;

        c(K k, V v) {
            this.f739a = k;
            this.f740b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f739a.equals(cVar.f739a) && this.f740b.equals(cVar.f740b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f739a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f740b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f739a.hashCode() ^ this.f740b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f739a + "=" + this.f740b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c<K, V> f743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f744b = true;

        d() {
        }

        @Override // androidx.arch.core.b.b.f
        public void a(c<K, V> cVar) {
            c<K, V> cVar2 = this.f743a;
            if (cVar == cVar2) {
                this.f743a = cVar2.f742d;
                this.f744b = this.f743a == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f744b) {
                return b.this.f735a != null;
            }
            c<K, V> cVar = this.f743a;
            return (cVar == null || cVar.f741c == null) ? false : true;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            if (this.f744b) {
                this.f744b = false;
                this.f743a = b.this.f735a;
            } else {
                c<K, V> cVar = this.f743a;
                this.f743a = cVar != null ? cVar.f741c : null;
            }
            return this.f743a;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c<K, V> f746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c<K, V> f747b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f746a = cVar2;
            this.f747b = cVar;
        }

        @Override // androidx.arch.core.b.b.f
        public void a(c<K, V> cVar) {
            if (this.f746a == cVar && cVar == this.f747b) {
                this.f747b = null;
                this.f746a = null;
            }
            c<K, V> cVar2 = this.f746a;
            if (cVar2 == cVar) {
                this.f746a = b(cVar2);
            }
            if (this.f747b == cVar) {
                this.f747b = a();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f747b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f747b;
            this.f747b = a();
            return cVar;
        }

        private c<K, V> a() {
            c<K, V> cVar = this.f747b;
            c<K, V> cVar2 = this.f746a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    interface f<K, V> {
        void a(c<K, V> cVar);
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.f735a;
        while (cVar != null && !cVar.f739a.equals(k)) {
            cVar = cVar.f741c;
        }
        return cVar;
    }

    public V b(K k, V v) {
        c<K, V> cVarA = a(k);
        if (cVarA != null) {
            return cVarA.f740b;
        }
        a(k, v);
        return null;
    }

    public b<K, V>.d c() {
        b<K, V>.d dVar = new d();
        this.f737c.put(dVar, false);
        return dVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0006b c0006b = new C0006b(this.f736b, this.f735a);
        this.f737c.put(c0006b, false);
        return c0006b;
    }

    public Map.Entry<K, V> e() {
        return this.f736b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f735a, this.f736b);
        this.f737c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        c<K, V> cVarA = a(k);
        if (cVarA == null) {
            return null;
        }
        this.f738d--;
        if (!this.f737c.isEmpty()) {
            Iterator<f<K, V>> it = this.f737c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarA);
            }
        }
        c<K, V> cVar = cVarA.f742d;
        if (cVar != null) {
            cVar.f741c = cVarA.f741c;
        } else {
            this.f735a = cVarA.f741c;
        }
        c<K, V> cVar2 = cVarA.f741c;
        if (cVar2 != null) {
            cVar2.f742d = cVarA.f742d;
        } else {
            this.f736b = cVarA.f742d;
        }
        cVarA.f741c = null;
        cVarA.f742d = null;
        return cVarA.f740b;
    }

    public int size() {
        return this.f738d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f738d++;
        c<K, V> cVar2 = this.f736b;
        if (cVar2 == null) {
            this.f735a = cVar;
            this.f736b = this.f735a;
            return cVar;
        }
        cVar2.f741c = cVar;
        cVar.f742d = cVar2;
        this.f736b = cVar;
        return cVar;
    }

    public Map.Entry<K, V> a() {
        return this.f735a;
    }
}
