package com.google.common.collect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            this.value = obj;
        }
    }

    static class a extends Ordering<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<Object, Integer> f13909a;

        a() {
            MapMaker mapMaker = new MapMaker();
            ua.a(mapMaker);
            this.f13909a = mapMaker.a(new sa(this));
        }

        int a(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int iA = a(obj);
            int iA2 = a(obj2);
            if (iA != iA2) {
                return iA < iA2 ? -1 : 1;
            }
            int iCompareTo = this.f13909a.get(obj).compareTo(this.f13909a.get(obj2));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Ordering<Object> f13910a = new a();
    }

    protected Ordering() {
    }

    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f13910a;
    }

    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    private <E extends T> int partition(E[] eArr, int i, int i2, int i3) {
        E e2 = eArr[i3];
        eArr[i3] = eArr[i2];
        eArr[i2] = e2;
        int i4 = i;
        while (i < i2) {
            if (compare(eArr[i], e2) < 0) {
                ra.a(eArr, i4, i);
                i4++;
            }
            i++;
        }
        ra.a(eArr, i2, i4);
        return i4;
    }

    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(T t, T t2);

    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        com.google.common.base.m.a(comparator);
        return new CompoundOrdering(this, comparator);
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i) {
        return reverse().leastOf(iterable, i);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        Object[] objArrB = L.b(iterable);
        for (Object obj : objArrB) {
            com.google.common.base.m.a(obj);
        }
        Arrays.sort(objArrB, this);
        return ImmutableList.asImmutableList(objArrB);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= ((long) i) * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i) {
                    array = ra.a(array, i);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i);
    }

    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.a());
    }

    public <F> Ordering<F> onResultOf(com.google.common.base.f<F, ? extends T> fVar) {
        return new ByFunctionOrdering(fVar, this);
    }

    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] objArrB = L.b(iterable);
        Arrays.sort(objArrB, this);
        return Lists.a(Arrays.asList(objArrB));
    }

    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(Lists.a(t, tArr));
    }

    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        com.google.common.base.m.a(ordering);
        return ordering;
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i) {
        return reverse().leastOf(it, i);
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(E e2, E e3) {
        return compare(e2, e3) >= 0 ? e2 : e3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(E e2, E e3) {
        return compare(e2, e3) <= 0 ? e2 : e3;
    }

    public <E extends T> E max(E e2, E e3, E e4, E... eArr) {
        E e5 = (E) max(max(e2, e3), e4);
        for (E e6 : eArr) {
            e5 = (E) max(e5, e6);
        }
        return e5;
    }

    public <E extends T> E min(E e2, E e3, E e4, E... eArr) {
        E e5 = (E) min(min(e2, e3), e4);
        for (E e6 : eArr) {
            e5 = (E) min(e5, e6);
        }
        return e5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> List<E> leastOf(Iterator<E> it, int i) {
        com.google.common.base.m.a(it);
        C2259n.a(i, "k");
        if (i == 0 || !it.hasNext()) {
            return ImmutableList.of();
        }
        if (i >= 1073741823) {
            ArrayList arrayListA = Lists.a(it);
            Collections.sort(arrayListA, this);
            if (arrayListA.size() > i) {
                arrayListA.subList(i, arrayListA.size()).clear();
            }
            arrayListA.trimToSize();
            return Collections.unmodifiableList(arrayListA);
        }
        int i2 = i * 2;
        Object[] objArr = new Object[i2];
        E next = it.next();
        objArr[0] = next;
        Object objMax = next;
        int i3 = 1;
        while (i3 < i && it.hasNext()) {
            E next2 = it.next();
            objArr[i3] = next2;
            objMax = max(objMax, next2);
            i3++;
        }
        while (it.hasNext()) {
            E next3 = it.next();
            if (compare(next3, objMax) < 0) {
                int i4 = i3 + 1;
                objArr[i3] = next3;
                if (i4 == i2) {
                    int i5 = i2 - 1;
                    int iMax = 0;
                    int i6 = 0;
                    while (iMax < i5) {
                        int iPartition = partition(objArr, iMax, i5, ((iMax + i5) + 1) >>> 1);
                        if (iPartition <= i) {
                            if (iPartition >= i) {
                                break;
                            }
                            iMax = Math.max(iPartition, iMax + 1);
                            i6 = iPartition;
                        } else {
                            i5 = iPartition - 1;
                        }
                    }
                    Object objMax2 = objArr[i6];
                    while (true) {
                        i6++;
                        if (i6 >= i) {
                            break;
                        }
                        objMax2 = max(objMax2, objArr[i6]);
                    }
                    objMax = objMax2;
                    i3 = i;
                } else {
                    i3 = i4;
                }
            }
        }
        Arrays.sort(objArr, 0, i3, this);
        return Collections.unmodifiableList(Arrays.asList(ra.a(objArr, Math.min(i3, i))));
    }
}
