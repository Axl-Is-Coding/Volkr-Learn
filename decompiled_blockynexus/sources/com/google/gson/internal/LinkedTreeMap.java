package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new t();
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.a entrySet;
    final d<K, V> header;
    private LinkedTreeMap<K, V>.b keySet;
    int modCount;
    d<K, V> root;
    int size;

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new u(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            d<K, V> dVarFindByEntry;
            if (!(obj instanceof Map.Entry) || (dVarFindByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(dVarFindByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new v(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    abstract class c<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d<K, V> f14110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d<K, V> f14111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f14112c;

        c() {
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            this.f14110a = linkedTreeMap.header.f14117d;
            this.f14111b = null;
            this.f14112c = linkedTreeMap.modCount;
        }

        final d<K, V> a() {
            d<K, V> dVar = this.f14110a;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (dVar == linkedTreeMap.header) {
                throw new NoSuchElementException();
            }
            if (linkedTreeMap.modCount != this.f14112c) {
                throw new ConcurrentModificationException();
            }
            this.f14110a = dVar.f14117d;
            this.f14111b = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f14110a != LinkedTreeMap.this.header;
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.f14111b;
            if (dVar == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(dVar, true);
            this.f14111b = null;
            this.f14112c = LinkedTreeMap.this.modCount;
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void rebalance(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.f14115b;
            d<K, V> dVar3 = dVar.f14116c;
            int i = dVar2 != null ? dVar2.h : 0;
            int i2 = dVar3 != null ? dVar3.h : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar4 = dVar3.f14115b;
                d<K, V> dVar5 = dVar3.f14116c;
                int i4 = (dVar4 != null ? dVar4.h : 0) - (dVar5 != null ? dVar5.h : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    rotateLeft(dVar);
                } else {
                    rotateRight(dVar3);
                    rotateLeft(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                d<K, V> dVar6 = dVar2.f14115b;
                d<K, V> dVar7 = dVar2.f14116c;
                int i5 = (dVar6 != null ? dVar6.h : 0) - (dVar7 != null ? dVar7.h : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    rotateRight(dVar);
                } else {
                    rotateLeft(dVar2);
                    rotateRight(dVar);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                dVar.h = i + 1;
                if (z) {
                    return;
                }
            } else {
                dVar.h = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar = dVar.f14114a;
        }
    }

    private void replaceInParent(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f14114a;
        dVar.f14114a = null;
        if (dVar2 != null) {
            dVar2.f14114a = dVar3;
        }
        if (dVar3 == null) {
            this.root = dVar2;
        } else if (dVar3.f14115b == dVar) {
            dVar3.f14115b = dVar2;
        } else {
            dVar3.f14116c = dVar2;
        }
    }

    private void rotateLeft(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f14115b;
        d<K, V> dVar3 = dVar.f14116c;
        d<K, V> dVar4 = dVar3.f14115b;
        d<K, V> dVar5 = dVar3.f14116c;
        dVar.f14116c = dVar4;
        if (dVar4 != null) {
            dVar4.f14114a = dVar;
        }
        replaceInParent(dVar, dVar3);
        dVar3.f14115b = dVar;
        dVar.f14114a = dVar3;
        dVar.h = Math.max(dVar2 != null ? dVar2.h : 0, dVar4 != null ? dVar4.h : 0) + 1;
        dVar3.h = Math.max(dVar.h, dVar5 != null ? dVar5.h : 0) + 1;
    }

    private void rotateRight(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.f14115b;
        d<K, V> dVar3 = dVar.f14116c;
        d<K, V> dVar4 = dVar2.f14115b;
        d<K, V> dVar5 = dVar2.f14116c;
        dVar.f14115b = dVar5;
        if (dVar5 != null) {
            dVar5.f14114a = dVar;
        }
        replaceInParent(dVar, dVar2);
        dVar2.f14116c = dVar;
        dVar.f14114a = dVar2;
        dVar.h = Math.max(dVar3 != null ? dVar3.h : 0, dVar5 != null ? dVar5.h : 0) + 1;
        dVar2.h = Math.max(dVar.h, dVar4 != null ? dVar4.h : 0) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        d<K, V> dVar = this.header;
        dVar.f14118e = dVar;
        dVar.f14117d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return findByObject(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.a aVar = this.entrySet;
        if (aVar != null) {
            return aVar;
        }
        LinkedTreeMap<K, V>.a aVar2 = new a();
        this.entrySet = aVar2;
        return aVar2;
    }

    d<K, V> find(K k, boolean z) {
        int iCompareTo;
        d<K, V> dVar;
        Comparator<? super K> comparator = this.comparator;
        d<K, V> dVar2 = this.root;
        if (dVar2 != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(dVar2.f14119f) : comparator.compare(k, dVar2.f14119f);
                if (iCompareTo == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = iCompareTo < 0 ? dVar2.f14115b : dVar2.f14116c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.header;
        if (dVar2 != null) {
            dVar = new d<>(dVar2, k, dVar4, dVar4.f14118e);
            if (iCompareTo < 0) {
                dVar2.f14115b = dVar;
            } else {
                dVar2.f14116c = dVar;
            }
            rebalance(dVar2, true);
        } else {
            if (comparator == NATURAL_ORDER && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            dVar = new d<>(dVar2, k, dVar4, dVar4.f14118e);
            this.root = dVar;
        }
        this.size++;
        this.modCount++;
        return dVar;
    }

    d<K, V> findByEntry(Map.Entry<?, ?> entry) {
        d<K, V> dVarFindByObject = findByObject(entry.getKey());
        if (dVarFindByObject != null && equal(dVarFindByObject.g, entry.getValue())) {
            return dVarFindByObject;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    d<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> dVarFindByObject = findByObject(obj);
        if (dVarFindByObject != null) {
            return dVarFindByObject.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.b bVar = this.keySet;
        if (bVar != null) {
            return bVar;
        }
        LinkedTreeMap<K, V>.b bVar2 = new b();
        this.keySet = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> dVarFind = find(k, true);
        V v2 = dVarFind.g;
        dVarFind.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> dVarRemoveInternalByKey = removeInternalByKey(obj);
        if (dVarRemoveInternalByKey != null) {
            return dVarRemoveInternalByKey.g;
        }
        return null;
    }

    void removeInternal(d<K, V> dVar, boolean z) {
        int i;
        if (z) {
            d<K, V> dVar2 = dVar.f14118e;
            dVar2.f14117d = dVar.f14117d;
            dVar.f14117d.f14118e = dVar2;
        }
        d<K, V> dVar3 = dVar.f14115b;
        d<K, V> dVar4 = dVar.f14116c;
        d<K, V> dVar5 = dVar.f14114a;
        int i2 = 0;
        if (dVar3 == null || dVar4 == null) {
            if (dVar3 != null) {
                replaceInParent(dVar, dVar3);
                dVar.f14115b = null;
            } else if (dVar4 != null) {
                replaceInParent(dVar, dVar4);
                dVar.f14116c = null;
            } else {
                replaceInParent(dVar, null);
            }
            rebalance(dVar5, false);
            this.size--;
            this.modCount++;
            return;
        }
        d<K, V> dVarB = dVar3.h > dVar4.h ? dVar3.b() : dVar4.a();
        removeInternal(dVarB, false);
        d<K, V> dVar6 = dVar.f14115b;
        if (dVar6 != null) {
            i = dVar6.h;
            dVarB.f14115b = dVar6;
            dVar6.f14114a = dVarB;
            dVar.f14115b = null;
        } else {
            i = 0;
        }
        d<K, V> dVar7 = dVar.f14116c;
        if (dVar7 != null) {
            i2 = dVar7.h;
            dVarB.f14116c = dVar7;
            dVar7.f14114a = dVarB;
            dVar.f14116c = null;
        }
        dVarB.h = Math.max(i, i2) + 1;
        replaceInParent(dVar, dVarB);
    }

    d<K, V> removeInternalByKey(Object obj) {
        d<K, V> dVarFindByObject = findByObject(obj);
        if (dVarFindByObject != null) {
            removeInternal(dVarFindByObject, true);
        }
        return dVarFindByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new d<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    static final class d<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d<K, V> f14114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        d<K, V> f14115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        d<K, V> f14116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        d<K, V> f14117d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        d<K, V> f14118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f14119f;
        V g;
        int h;

        d() {
            this.f14119f = null;
            this.f14118e = this;
            this.f14117d = this;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f14115b; dVar2 != null; dVar2 = dVar2.f14115b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.f14116c; dVar2 != null; dVar2 = dVar2.f14116c) {
                dVar = dVar2;
            }
            return dVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f14119f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.g;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f14119f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f14119f;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        public String toString() {
            return this.f14119f + "=" + this.g;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f14114a = dVar;
            this.f14119f = k;
            this.h = 1;
            this.f14117d = dVar2;
            this.f14118e = dVar3;
            dVar3.f14117d = this;
            dVar2.f14118e = this;
        }
    }
}
