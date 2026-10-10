package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: Sets.java */
/* JADX INFO: loaded from: classes2.dex */
public final class Aa {

    /* JADX INFO: compiled from: Sets.java */
    static abstract class a<E> extends AbstractSet<E> {
        a() {
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Aa.a((Set<?>) this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            com.google.common.base.m.a(collection);
            return super.retainAll(collection);
        }
    }

    public static <E> HashSet<E> a() {
        return new HashSet<>();
    }

    public static <E> LinkedHashSet<E> b(int i) {
        return new LinkedHashSet<>(Maps.a(i));
    }

    public static <E> HashSet<E> a(int i) {
        return new HashSet<>(Maps.a(i));
    }

    static int a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = ((iHashCode + (next != null ? next.hashCode() : 0)) ^ (-1)) ^ (-1);
        }
        return iHashCode;
    }

    static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean a(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    static boolean a(Set<?> set, Collection<?> collection) {
        com.google.common.base.m.a(collection);
        if (collection instanceof oa) {
            collection = ((oa) collection).elementSet();
        }
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return V.a(set.iterator(), collection);
        }
        return a(set, collection.iterator());
    }
}
