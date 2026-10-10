package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    static abstract class Indexed<E> extends ImmutableSet<E> {
        Indexed() {
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<E> createAsList() {
            return new ImmutableAsList<E>() { // from class: com.google.common.collect.ImmutableSet.Indexed.1
                @Override // java.util.List
                public E get(int i) {
                    return (E) Indexed.this.get(i);
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.ImmutableAsList
                public Indexed<E> delegateCollection() {
                    return Indexed.this;
                }
            };
        }

        abstract E get(int i);

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public Fa<E> iterator() {
            return asList().iterator();
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        a(int i) {
            super(i);
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public a<E> a(E e2) {
            super.a((Object) e2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.a, com.google.common.collect.ImmutableCollection.b
        public a<E> a(E... eArr) {
            super.a((Object[]) eArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public a<E> a(Iterator<? extends E> it) {
            super.a((Iterator) it);
            return this;
        }

        public ImmutableSet<E> a() {
            ImmutableSet<E> immutableSetConstruct = ImmutableSet.construct(this.f13831b, this.f13830a);
            this.f13831b = immutableSetConstruct.size();
            return immutableSetConstruct;
        }
    }

    ImmutableSet() {
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    static int chooseTableSize(int i) {
        if (i >= CUTOFF) {
            com.google.common.base.m.a(i < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(i - 1) << 1;
        while (true) {
            double d2 = iHighestOneBit;
            Double.isNaN(d2);
            if (d2 * DESIRED_LOAD_FACTOR >= i) {
                return iHighestOneBit;
            }
            iHighestOneBit <<= 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        if (i == 0) {
            return of();
        }
        if (i == 1) {
            return of(objArr[0]);
        }
        int iChooseTableSize = chooseTableSize(i);
        Object[] objArr2 = new Object[iChooseTableSize];
        int i2 = iChooseTableSize - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            ra.a(obj, i5);
            int iHashCode = obj.hashCode();
            int iA = C2268x.a(iHashCode);
            while (true) {
                int i6 = iA & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i3] = obj;
                    objArr2[i6] = obj;
                    i4 += iHashCode;
                    i3++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iA++;
            }
        }
        Arrays.fill(objArr, i3, i, (Object) null);
        if (i3 == 1) {
            return new SingletonImmutableSet(objArr[0], i4);
        }
        if (iChooseTableSize != chooseTableSize(i3)) {
            return construct(i3, objArr);
        }
        if (i3 < objArr.length) {
            objArr = ra.a(objArr, i3);
        }
        return new RegularImmutableSet(objArr, i4, objArr2, i2);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return ImmutableEnumSet.asImmutable(EnumSet.copyOf(enumSet));
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Aa.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Aa.a(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract Fa<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e2) {
        return new SingletonImmutableSet(e2);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3) {
        return construct(2, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4) {
        return construct(3, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5) {
        return construct(4, e2, e3, e4, e5);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6) {
        return construct(5, e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableSet<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        Object[] objArr = new Object[eArr.length + 6];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(objArr.length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a((Object) next).a((Iterator) it).a();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
