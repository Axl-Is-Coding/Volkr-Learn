package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: Multiset.java */
/* JADX INFO: loaded from: classes2.dex */
public interface oa<E> extends Collection<E> {

    /* JADX INFO: compiled from: Multiset.java */
    public interface a<E> {
        int getCount();

        E getElement();
    }

    int add(E e2, int i);

    boolean add(E e2);

    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    int remove(Object obj, int i);

    int setCount(E e2, int i);

    boolean setCount(E e2, int i, int i2);
}
