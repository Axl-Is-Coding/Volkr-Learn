package com.google.common.collect;

import a.a.h;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, Ba<E> {
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.of(), NATURAL_ORDER);

    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            a aVar = new a(this.comparator);
            aVar.a(this.elements);
            return aVar.a();
        }
    }

    public static final class a<E> extends ImmutableSet.a<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Comparator<? super E> f13848c;

        public a(Comparator<? super E> comparator) {
            com.google.common.base.m.a(comparator);
            this.f13848c = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableCollection.b a(Object obj) {
            a(obj);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableSet.a a(Object obj) {
            a(obj);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableSet.a a(Iterator it) {
            a(it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.b
        public a<E> a(E e2) {
            super.a((Object) e2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.b
        public a<E> a(E... eArr) {
            super.a((Object[]) eArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a, com.google.common.collect.ImmutableCollection.b
        public a<E> a(Iterator<? extends E> it) {
            super.a((Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a
        public ImmutableSortedSet<E> a() {
            ImmutableSortedSet<E> immutableSortedSetConstruct = ImmutableSortedSet.construct(this.f13848c, this.f13831b, this.f13830a);
            this.f13831b = immutableSortedSetConstruct.size();
            return immutableSortedSetConstruct;
        }
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return emptySet(comparator);
        }
        ra.b(eArr, i);
        Arrays.sort(eArr, 0, i, comparator);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            h.b bVar = (Object) eArr[i3];
            if (comparator.compare(bVar, (Object) eArr[i2 - 1]) != 0) {
                eArr[i2] = bVar;
                i2++;
            }
        }
        Arrays.fill(eArr, i2, i, (Object) null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i2), comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return construct(Ordering.natural(), comparableArr.length, (Object[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator comparatorA = Ca.a(sortedSet);
        ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) sortedSet);
        return immutableListCopyOf.isEmpty() ? emptySet(comparatorA) : new RegularImmutableSortedSet(immutableListCopyOf, comparatorA);
    }

    static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        return NATURAL_ORDER.equals(comparator) ? (RegularImmutableSortedSet<E>) NATURAL_EMPTY_SET : new RegularImmutableSortedSet<>(ImmutableList.of(), comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return NATURAL_EMPTY_SET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    public E ceiling(E e2) {
        return (E) L.a(tailSet((Object) e2, true), (Object) null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.Ba
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    ImmutableSortedSet<E> createDescendingSet() {
        return new DescendingImmutableSortedSet(this);
    }

    @Override // java.util.NavigableSet
    public abstract Fa<E> descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    public E floor(E e2) {
        return (E) V.b(headSet((Object) e2, true).descendingIterator(), (Object) null);
    }

    abstract ImmutableSortedSet<E> headSetImpl(E e2, boolean z);

    public E higher(E e2) {
        return (E) L.a(tailSet((Object) e2, false), (Object) null);
    }

    abstract int indexOf(Object obj);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract Fa<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    public E lower(E e2) {
        return (E) V.b(headSet((Object) e2, false).descendingIterator(), (Object) null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    abstract ImmutableSortedSet<E> subSetImpl(E e2, boolean z, E e3, boolean z2);

    abstract ImmutableSortedSet<E> tailSetImpl(E e2, boolean z);

    int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.of(comparable), Ordering.natural());
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> immutableSortedSetCreateDescendingSet = createDescendingSet();
        this.descendingSet = immutableSortedSetCreateDescendingSet;
        immutableSortedSetCreateDescendingSet.descendingSet = this;
        return immutableSortedSetCreateDescendingSet;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        return construct(Ordering.natural(), 2, comparable, comparable2);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e2) {
        return headSet((Object) e2, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e2, E e3) {
        return subSet((Object) e2, true, (Object) e3, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E e2) {
        return tailSet((Object) e2, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return construct(Ordering.natural(), 3, comparable, comparable2, comparable3);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> headSet(E e2, boolean z) {
        com.google.common.base.m.a(e2);
        return headSetImpl(e2, z);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
        com.google.common.base.m.a(e2);
        com.google.common.base.m.a(e3);
        com.google.common.base.m.a(this.comparator.compare(e2, e3) <= 0);
        return subSetImpl(e2, z, e3, z2);
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> tailSet(E e2, boolean z) {
        com.google.common.base.m.a(e2);
        return tailSetImpl(e2, z);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return construct(Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return construct(Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        Comparable[] comparableArr2 = new Comparable[comparableArr.length + 6];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return construct(Ordering.natural(), comparableArr2.length, comparableArr2);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        a aVar = new a(comparator);
        aVar.a((Iterator) it);
        return aVar.a();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.m.a(comparator);
        if (Ca.a(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] objArrB = L.b(iterable);
        return construct(comparator, objArrB.length, objArrB);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }
}
