package com.google.common.collect;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class Lists {

    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        OnePlusArrayList(E e2, E[] eArr) {
            this.first = e2;
            com.google.common.base.m.a(eArr);
            this.rest = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            com.google.common.base.m.a(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.rest.length + 1;
        }
    }

    public static <E> ArrayList<E> a() {
        return new ArrayList<>();
    }

    static int b(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return d(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.k.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    static int c(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.k.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int d(List<?> list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int e(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> a(Iterable<? extends E> iterable) {
        com.google.common.base.m.a(iterable);
        return iterable instanceof Collection ? new ArrayList<>(C2261p.a(iterable)) : a(iterable.iterator());
    }

    public static <E> ArrayList<E> a(Iterator<? extends E> it) {
        ArrayList<E> arrayListA = a();
        V.a(arrayListA, it);
        return arrayListA;
    }

    public static <E> ArrayList<E> a(int i) {
        C2259n.a(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    public static <E> List<E> a(E e2, E[] eArr) {
        return new OnePlusArrayList(e2, eArr);
    }

    static boolean a(List<?> list, Object obj) {
        com.google.common.base.m.a(list);
        if (obj == list) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return V.a(list.iterator(), (Iterator<?>) list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!com.google.common.base.k.a(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }
}
