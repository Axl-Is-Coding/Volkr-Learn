package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.collect.Aa;
import com.google.common.collect.ImmutableMap;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class Maps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final h.a f13899a = C2261p.f13960a.c("=");

    private enum EntryFunction implements com.google.common.base.f<Map.Entry<?, ?>, Object> {
        KEY { // from class: com.google.common.collect.Maps.EntryFunction.1
            @Override // com.google.common.base.f
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE { // from class: com.google.common.collect.Maps.EntryFunction.2
            @Override // com.google.common.base.f
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        /* synthetic */ EntryFunction(C2248ea c2248ea) {
            this();
        }
    }

    static abstract class a<K, V> extends Aa.a<Map.Entry<K, V>> {
        a() {
        }

        abstract Map<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public abstract boolean contains(Object obj);

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // com.google.common.collect.Aa.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                com.google.common.base.m.a(collection);
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                return Aa.a((Set<?>) this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Aa.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                com.google.common.base.m.a(collection);
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = Aa.a(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        hashSetA.add(((Map.Entry) obj).getKey());
                    }
                }
                return a().keySet().retainAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    static class b<K, V> extends Aa.a<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, V> f13900a;

        b(Map<K, V> map) {
            com.google.common.base.m.a(map);
            this.f13900a = map;
        }

        Map<K, V> a() {
            return this.f13900a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return Maps.a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            a().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().size();
        }
    }

    static class c<K, V> extends AbstractCollection<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<K, V> f13901a;

        c(Map<K, V> map) {
            com.google.common.base.m.a(map);
            this.f13901a = map;
        }

        final Map<K, V> a() {
            return this.f13901a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return a().containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.c(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (com.google.common.base.k.a(obj, entry.getValue())) {
                        a().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                com.google.common.base.m.a(collection);
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = Aa.a();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetA.add(entry.getKey());
                    }
                }
                return a().keySet().removeAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                com.google.common.base.m.a(collection);
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSetA = Aa.a();
                for (Map.Entry<K, V> entry : a().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSetA.add(entry.getKey());
                    }
                }
                return a().keySet().retainAll(hashSetA);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    static abstract class d<K, V> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f13902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private transient Collection<V> f13903b;

        d() {
        }

        abstract Set<Map.Entry<K, V>> a();

        Collection<V> b() {
            return new c(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f13902a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> setA = a();
            this.f13902a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f13903b;
            if (collection != null) {
                return collection;
            }
            Collection<V> collectionB = b();
            this.f13903b = collectionB;
            return collectionB;
        }
    }

    static <K> com.google.common.base.f<Map.Entry<K, ?>, K> a() {
        return EntryFunction.KEY;
    }

    public static <K, V> HashMap<K, V> b() {
        return new HashMap<>();
    }

    static <K, V> Iterator<V> c(Iterator<Map.Entry<K, V>> it) {
        return V.a((Iterator) it, d());
    }

    static <V> com.google.common.base.f<Map.Entry<?, V>, V> d() {
        return EntryFunction.VALUE;
    }

    static <V> V e(Map<?, V> map, Object obj) {
        com.google.common.base.m.a(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static <V> V f(Map<?, V> map, Object obj) {
        com.google.common.base.m.a(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static <K, V> Iterator<K> a(Iterator<Map.Entry<K, V>> it) {
        return V.a((Iterator) it, a());
    }

    public static <K, V> LinkedHashMap<K, V> b(int i) {
        return new LinkedHashMap<>(a(i));
    }

    public static <K, V> LinkedHashMap<K, V> c() {
        return new LinkedHashMap<>();
    }

    static boolean d(Map<?, ?> map, Object obj) {
        com.google.common.base.m.a(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static int a(int i) {
        if (i < 3) {
            C2259n.a(i, "expectedSize");
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    static <K, V> Map.Entry<K, V> b(Map.Entry<? extends K, ? extends V> entry) {
        com.google.common.base.m.a(entry);
        return new C2250fa(entry);
    }

    static boolean c(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> a(K k, V v) {
        return new ImmutableEntry(k, v);
    }

    static boolean a(Map<?, ?> map, Object obj) {
        return V.a((Iterator<?>) a(map.entrySet().iterator()), obj);
    }

    static <K, V> Fa<Map.Entry<K, V>> b(Iterator<Map.Entry<K, V>> it) {
        return new C2252ga(it);
    }

    static String a(Map<?, ?> map) {
        StringBuilder sbA = C2261p.a(map.size());
        sbA.append('{');
        f13899a.a(sbA, map);
        sbA.append('}');
        return sbA.toString();
    }

    static boolean b(Map<?, ?> map, Object obj) {
        return V.a((Iterator<?>) c(map.entrySet().iterator()), obj);
    }

    static <K, V> void a(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry<? extends K, ? extends V> entry : map2.entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }
    }

    static <K> K a(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    static <E> ImmutableMap<E, Integer> a(Collection<E> collection) {
        ImmutableMap.a aVar = new ImmutableMap.a(collection.size());
        Iterator<E> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            aVar.a(it.next(), Integer.valueOf(i));
            i++;
        }
        return aVar.a();
    }
}
