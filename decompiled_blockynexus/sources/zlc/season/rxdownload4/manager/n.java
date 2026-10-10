package zlc.season.rxdownload4.manager;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes5.dex */
public class n<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b<K, V> f23962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b<K, V> f23963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakHashMap<d<K, V>, Boolean> f23964c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23965d = 0;

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class a<K, V> extends c<K, V> {
        a(b<K, V> bVar, b<K, V> bVar2) {
            super(bVar, bVar2);
        }

        @Override // zlc.season.rxdownload4.manager.n.c
        b<K, V> b(b<K, V> bVar) {
            return bVar.f23969d;
        }

        @Override // zlc.season.rxdownload4.manager.n.c
        b<K, V> c(b<K, V> bVar) {
            return bVar.f23968c;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class b<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f23966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final V f23967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        b<K, V> f23968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        b<K, V> f23969d;

        b(K k, V v) {
            this.f23966a = k;
            this.f23967b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f23966a.equals(bVar.f23966a) && this.f23967b.equals(bVar.f23967b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f23966a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f23967b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f23966a + "=" + this.f23967b;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static abstract class c<K, V> implements Iterator<Map.Entry<K, V>>, d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b<K, V> f23970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        b<K, V> f23971b;

        c(b<K, V> bVar, b<K, V> bVar2) {
            this.f23970a = bVar2;
            this.f23971b = bVar;
        }

        @Override // zlc.season.rxdownload4.manager.n.d
        public void a(b<K, V> bVar) {
            if (this.f23970a == bVar && bVar == this.f23971b) {
                this.f23971b = null;
                this.f23970a = null;
            }
            b<K, V> bVar2 = this.f23970a;
            if (bVar2 == bVar) {
                this.f23970a = b(bVar2);
            }
            if (this.f23971b == bVar) {
                this.f23971b = a();
            }
        }

        abstract b<K, V> b(b<K, V> bVar);

        abstract b<K, V> c(b<K, V> bVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23971b != null;
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            b<K, V> bVar = this.f23971b;
            this.f23971b = a();
            return bVar;
        }

        private b<K, V> a() {
            b<K, V> bVar = this.f23971b;
            b<K, V> bVar2 = this.f23970a;
            if (bVar == bVar2 || bVar2 == null) {
                return null;
            }
            return c(bVar);
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    interface d<K, V> {
        void a(b<K, V> bVar);
    }

    protected b<K, V> a(K k) {
        b<K, V> bVar = this.f23962a;
        while (bVar != null && !bVar.f23966a.equals(k)) {
            bVar = bVar.f23968c;
        }
        return bVar;
    }

    public V b(K k, V v) {
        b<K, V> bVarA = a(k);
        if (bVarA != null) {
            return bVarA.f23967b;
        }
        a(k, v);
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (size() != nVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = nVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f23962a, this.f23963b);
        this.f23964c.put(aVar, false);
        return aVar;
    }

    public V remove(K k) {
        b<K, V> bVarA = a(k);
        if (bVarA == null) {
            return null;
        }
        this.f23965d--;
        if (!this.f23964c.isEmpty()) {
            Iterator<d<K, V>> it = this.f23964c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(bVarA);
            }
        }
        b<K, V> bVar = bVarA.f23969d;
        if (bVar != null) {
            bVar.f23968c = bVarA.f23968c;
        } else {
            this.f23962a = bVarA.f23968c;
        }
        b<K, V> bVar2 = bVarA.f23968c;
        if (bVar2 != null) {
            bVar2.f23969d = bVarA.f23969d;
        } else {
            this.f23963b = bVarA.f23969d;
        }
        bVarA.f23968c = null;
        bVarA.f23969d = null;
        return bVarA.f23967b;
    }

    public int size() {
        return this.f23965d;
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

    protected b<K, V> a(K k, V v) {
        b<K, V> bVar = new b<>(k, v);
        this.f23965d++;
        b<K, V> bVar2 = this.f23963b;
        if (bVar2 == null) {
            this.f23962a = bVar;
            this.f23963b = this.f23962a;
            return bVar;
        }
        bVar2.f23968c = bVar;
        bVar.f23969d = bVar2;
        this.f23963b = bVar;
        return bVar;
    }
}
