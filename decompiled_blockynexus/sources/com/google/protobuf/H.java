package com.google.protobuf;

import com.google.protobuf.C2308n;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes2.dex */
class H<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f14298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<H<K, V>.b> f14299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<K, V> f14300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile H<K, V>.d f14302e;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f14303a = new F();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f14304b = new G();

        static <T> Iterable<T> b() {
            return (Iterable<T>) f14304b;
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class b implements Map.Entry<K, V>, Comparable<H<K, V>.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final K f14305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private V f14306b;

        b(H h, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(H<K, V>.b bVar) {
            return getKey().compareTo(bVar.getKey());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a(this.f14305a, entry.getKey()) && a(this.f14306b, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f14306b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f14305a;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.f14306b;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            H.this.f();
            V v2 = this.f14306b;
            this.f14306b = v;
            return v2;
        }

        public String toString() {
            return this.f14305a + "=" + this.f14306b;
        }

        b(K k, V v) {
            this.f14305a = k;
            this.f14306b = v;
        }

        private boolean a(Object obj, Object obj2) {
            return obj == null ? obj2 == null : obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f14305a;
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class c implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f14309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f14310c;

        private c() {
            this.f14308a = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f14310c == null) {
                this.f14310c = H.this.f14300c.entrySet().iterator();
            }
            return this.f14310c;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14308a + 1 < H.this.f14299b.size() || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f14309b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f14309b = false;
            H.this.f();
            if (this.f14308a >= H.this.f14299b.size()) {
                a().remove();
                return;
            }
            H h = H.this;
            int i = this.f14308a;
            this.f14308a = i - 1;
            h.c(i);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            this.f14309b = true;
            int i = this.f14308a + 1;
            this.f14308a = i;
            return i < H.this.f14299b.size() ? (Map.Entry) H.this.f14299b.get(this.f14308a) : a().next();
        }

        /* synthetic */ c(H h, E e2) {
            this();
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class d extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            H.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            H.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = H.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c(H.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            H.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return H.this.size();
        }

        /* synthetic */ d(H h, E e2) {
            this();
        }
    }

    /* synthetic */ H(int i, E e2) {
        this(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.f14301d) {
            throw new UnsupportedOperationException();
        }
    }

    private void g() {
        f();
        if (!this.f14299b.isEmpty() || (this.f14299b instanceof ArrayList)) {
            return;
        }
        this.f14299b = new ArrayList(this.f14298a);
    }

    private SortedMap<K, V> h() {
        f();
        if (this.f14300c.isEmpty() && !(this.f14300c instanceof TreeMap)) {
            this.f14300c = new TreeMap();
        }
        return (SortedMap) this.f14300c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        f();
        if (!this.f14299b.isEmpty()) {
            this.f14299b.clear();
        }
        if (this.f14300c.isEmpty()) {
            return;
        }
        this.f14300c.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f14300c.containsKey(comparable);
    }

    public boolean d() {
        return this.f14301d;
    }

    public void e() {
        if (this.f14301d) {
            return;
        }
        this.f14300c = this.f14300c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f14300c);
        this.f14301d = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f14302e == null) {
            this.f14302e = new d(this, null);
        }
        return this.f14302e;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return super.equals(obj);
        }
        H h = (H) obj;
        int size = size();
        if (size != h.size()) {
            return false;
        }
        int iA = a();
        if (iA != h.a()) {
            return entrySet().equals(h.entrySet());
        }
        for (int i = 0; i < iA; i++) {
            if (!a(i).equals(h.a(i))) {
                return false;
            }
        }
        if (iA != size) {
            return this.f14300c.equals(h.f14300c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? this.f14299b.get(iA).getValue() : this.f14300c.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iA = a();
        int iHashCode = 0;
        for (int i = 0; i < iA; i++) {
            iHashCode += this.f14299b.get(i).hashCode();
        }
        return b() > 0 ? iHashCode + this.f14300c.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return c(iA);
        }
        if (this.f14300c.isEmpty()) {
            return null;
        }
        return this.f14300c.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f14299b.size() + this.f14300c.size();
    }

    private H(int i) {
        this.f14298a = i;
        this.f14299b = Collections.emptyList();
        this.f14300c = Collections.emptyMap();
    }

    static <FieldDescriptorType extends C2308n.a<FieldDescriptorType>> H<FieldDescriptorType, Object> b(int i) {
        return new E(i);
    }

    public Iterable<Map.Entry<K, V>> c() {
        return this.f14300c.isEmpty() ? a.b() : this.f14300c.entrySet();
    }

    public int a() {
        return this.f14299b.size();
    }

    public int b() {
        return this.f14300c.size();
    }

    public Map.Entry<K, V> a(int i) {
        return this.f14299b.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V c(int i) {
        f();
        V value = this.f14299b.remove(i).getValue();
        if (!this.f14300c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = h().entrySet().iterator();
            this.f14299b.add(new b(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public V put(K k, V v) {
        f();
        int iA = a(k);
        if (iA >= 0) {
            return this.f14299b.get(iA).setValue(v);
        }
        g();
        int i = -(iA + 1);
        if (i >= this.f14298a) {
            return h().put(k, v);
        }
        int size = this.f14299b.size();
        int i2 = this.f14298a;
        if (size == i2) {
            H<K, V>.b bVarRemove = this.f14299b.remove(i2 - 1);
            h().put(bVarRemove.getKey(), bVarRemove.getValue());
        }
        this.f14299b.add(i, new b(k, v));
        return null;
    }

    private int a(K k) {
        int size = this.f14299b.size() - 1;
        if (size >= 0) {
            int iCompareTo = k.compareTo(this.f14299b.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int iCompareTo2 = k.compareTo(this.f14299b.get(i2).getKey());
            if (iCompareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }
}
