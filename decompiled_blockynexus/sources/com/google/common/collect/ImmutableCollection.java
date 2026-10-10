package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private transient ImmutableList<E> asList;

    ImmutableCollection() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListCreateAsList = createAsList();
        this.asList = immutableListCreateAsList;
        return immutableListCreateAsList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    int copyIntoArray(Object[] objArr, int i) {
        Iterator it = iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return i;
    }

    ImmutableList<E> createAsList() {
        int size = size();
        return size != 0 ? size != 1 ? new RegularImmutableAsList(this, toArray()) : ImmutableList.of((Object) iterator().next()) : ImmutableList.of();
    }

    abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract Fa<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return ra.f13964a;
        }
        Object[] objArr = new Object[size];
        copyIntoArray(objArr, 0);
        return objArr;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object[] f13830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13831b;

        a(int i) {
            C2259n.a(i, "initialCapacity");
            this.f13830a = new Object[i];
            this.f13831b = 0;
        }

        private void a(int i) {
            Object[] objArr = this.f13830a;
            if (objArr.length < i) {
                this.f13830a = ra.a(objArr, b.a(objArr.length, i));
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public a<E> a(E e2) {
            com.google.common.base.m.a(e2);
            a(this.f13831b + 1);
            Object[] objArr = this.f13830a;
            int i = this.f13831b;
            this.f13831b = i + 1;
            objArr[i] = e2;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public b<E> a(E... eArr) {
            ra.a(eArr);
            a(this.f13831b + eArr.length);
            System.arraycopy(eArr, 0, this.f13830a, this.f13831b, eArr.length);
            this.f13831b += eArr.length;
            return this;
        }
    }

    public static abstract class b<E> {
        b() {
        }

        static int a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i + (i >> 1) + 1;
            if (iHighestOneBit < i2) {
                iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        public abstract b<E> a(E e2);

        public b<E> a(E... eArr) {
            for (E e2 : eArr) {
                a(e2);
            }
            return this;
        }

        public b<E> a(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.m.a(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ra.c(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
