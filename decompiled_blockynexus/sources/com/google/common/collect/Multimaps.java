package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.oa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class Multimaps {

    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.u<? extends List<V>> factory;

        CustomListMultimap(Map<K, Collection<V>> map, com.google.common.base.u<? extends List<V>> uVar) {
            super(map);
            com.google.common.base.m.a(uVar);
            this.factory = uVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.u) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public List<V> createCollection() {
            return this.factory.get();
        }
    }

    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient com.google.common.base.u<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> map, com.google.common.base.u<? extends Set<V>> uVar) {
            super(map);
            com.google.common.base.m.a(uVar);
            this.factory = uVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.u) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public Set<V> createCollection() {
            return this.factory.get();
        }
    }

    static abstract class a<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        a() {
        }

        abstract ha<K, V> a();

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return a().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return a().size();
        }
    }

    static class b<K, V> extends AbstractC2256k<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ha<K, V> f13904a;

        class a extends Multisets.c<K> {
            a() {
            }

            @Override // com.google.common.collect.Multisets.c
            oa<K> a() {
                return b.this;
            }

            @Override // com.google.common.collect.Multisets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof oa.a)) {
                    return false;
                }
                oa.a aVar = (oa.a) obj;
                Collection<V> collection = b.this.f13904a.asMap().get(aVar.getElement());
                return collection != null && collection.size() == aVar.getCount();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return b.this.f13904a.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<oa.a<K>> iterator() {
                return b.this.entryIterator();
            }

            @Override // com.google.common.collect.Multisets.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof oa.a)) {
                    return false;
                }
                oa.a aVar = (oa.a) obj;
                Collection<V> collection = b.this.f13904a.asMap().get(aVar.getElement());
                if (collection == null || collection.size() != aVar.getCount()) {
                    return false;
                }
                collection.clear();
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return b.this.distinctElements();
            }
        }

        b(ha<K, V> haVar) {
            this.f13904a = haVar;
        }

        @Override // com.google.common.collect.AbstractC2256k, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f13904a.clear();
        }

        @Override // com.google.common.collect.AbstractC2256k, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.oa
        public boolean contains(Object obj) {
            return this.f13904a.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
        public int count(Object obj) {
            Collection collection = (Collection) Maps.e(this.f13904a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.AbstractC2256k
        Set<oa.a<K>> createEntrySet() {
            return new a();
        }

        @Override // com.google.common.collect.AbstractC2256k
        int distinctElements() {
            return this.f13904a.asMap().size();
        }

        @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
        public Set<K> elementSet() {
            return this.f13904a.keySet();
        }

        @Override // com.google.common.collect.AbstractC2256k
        Iterator<oa.a<K>> entryIterator() {
            return new na(this, this.f13904a.asMap().entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractC2256k, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.a(this.f13904a.entries().iterator());
        }

        @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
        public int remove(Object obj, int i) {
            C2259n.a(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.e(this.f13904a.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }
    }

    public static <K, V> W<K, V> a(Map<K, Collection<V>> map, com.google.common.base.u<? extends List<V>> uVar) {
        return new CustomListMultimap(map, uVar);
    }

    public static <K, V> za<K, V> b(Map<K, Collection<V>> map, com.google.common.base.u<? extends Set<V>> uVar) {
        return new CustomSetMultimap(map, uVar);
    }

    static boolean a(ha<?, ?> haVar, Object obj) {
        if (obj == haVar) {
            return true;
        }
        if (obj instanceof ha) {
            return haVar.asMap().equals(((ha) obj).asMap());
        }
        return false;
    }
}
