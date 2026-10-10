package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;

/* JADX INFO: compiled from: SortedIterables.java */
/* JADX INFO: loaded from: classes2.dex */
final class Ca {
    public static boolean a(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        com.google.common.base.m.a(comparator);
        com.google.common.base.m.a(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else {
            if (!(iterable instanceof Ba)) {
                return false;
            }
            comparator2 = ((Ba) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }

    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? Ordering.natural() : comparator;
    }
}
