package com.google.common.collect;

import com.google.common.collect.Multisets;
import com.google.common.collect.oa;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: com.google.common.collect.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMultiset.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC2256k<E> extends AbstractCollection<E> implements oa<E> {
    private transient Set<E> elementSet;
    private transient Set<oa.a<E>> entrySet;

    /* JADX INFO: renamed from: com.google.common.collect.k$a */
    /* JADX INFO: compiled from: AbstractMultiset.java */
    class a extends Multisets.b<E> {
        a() {
        }

        @Override // com.google.common.collect.Multisets.b
        oa<E> a() {
            return AbstractC2256k.this;
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.k$b */
    /* JADX INFO: compiled from: AbstractMultiset.java */
    class b extends Multisets.c<E> {
        b() {
        }

        @Override // com.google.common.collect.Multisets.c
        oa<E> a() {
            return AbstractC2256k.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<oa.a<E>> iterator() {
            return AbstractC2256k.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return AbstractC2256k.this.distinctElements();
        }
    }

    AbstractC2256k() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.oa
    public boolean add(E e2) {
        add(e2, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return Multisets.a((oa) this, (Collection) collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.oa
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public abstract int count(Object obj);

    Set<E> createElementSet() {
        return new a();
    }

    Set<oa.a<E>> createEntrySet() {
        return new b();
    }

    abstract int distinctElements();

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> setCreateElementSet = createElementSet();
        this.elementSet = setCreateElementSet;
        return setCreateElementSet;
    }

    abstract Iterator<oa.a<E>> entryIterator();

    public Set<oa.a<E>> entrySet() {
        Set<oa.a<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<oa.a<E>> setCreateEntrySet = createEntrySet();
        this.entrySet = setCreateEntrySet;
        return setCreateEntrySet;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return Multisets.a(this, obj);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract Iterator<E> iterator();

    public abstract int remove(Object obj, int i);

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return Multisets.b(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return Multisets.c(this, collection);
    }

    public int setCount(E e2, int i) {
        return Multisets.a(this, e2, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Multisets.a((oa<?>) this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    public int add(E e2, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean setCount(E e2, int i, int i2) {
        return Multisets.a(this, e2, i, i2);
    }
}
