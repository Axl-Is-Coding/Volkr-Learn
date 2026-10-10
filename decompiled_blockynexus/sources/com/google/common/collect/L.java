package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: Iterables.java */
/* JADX INFO: loaded from: classes2.dex */
public final class L {

    /* JADX INFO: compiled from: Iterables.java */
    private static final class a<T> extends r<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Iterable<T> f13853b;

        /* synthetic */ a(Iterable iterable, I i) {
            this(iterable);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return V.e(this.f13853b.iterator());
        }

        @Override // com.google.common.collect.r
        public String toString() {
            return this.f13853b.toString();
        }

        private a(Iterable<T> iterable) {
            this.f13853b = iterable;
        }
    }

    public static <T> T a(Iterable<T> iterable) {
        return (T) V.b(iterable.iterator());
    }

    static Object[] b(Iterable<?> iterable) {
        return e(iterable).toArray();
    }

    public static String c(Iterable<?> iterable) {
        return V.d(iterable.iterator());
    }

    public static <T> Iterable<T> d(Iterable<T> iterable) {
        com.google.common.base.m.a(iterable);
        return ((iterable instanceof a) || (iterable instanceof ImmutableCollection)) ? iterable : new a(iterable, null);
    }

    private static <E> Collection<E> e(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.a(iterable.iterator());
    }

    static <T> T[] a(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) e(iterable).toArray(tArr);
    }

    public static <T> Iterable<T> b(Iterable<T> iterable, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.a(iterable);
        com.google.common.base.m.a(nVar);
        return new J(iterable, nVar);
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(C2261p.a(iterable));
        }
        com.google.common.base.m.a(iterable);
        return V.a(collection, iterable.iterator());
    }

    public static <T> boolean a(Iterable<T> iterable, com.google.common.base.n<? super T> nVar) {
        return V.a(iterable.iterator(), nVar);
    }

    public static <F, T> Iterable<T> a(Iterable<F> iterable, com.google.common.base.f<? super F, ? extends T> fVar) {
        com.google.common.base.m.a(iterable);
        com.google.common.base.m.a(fVar);
        return new K(iterable, fVar);
    }

    public static <T> T a(Iterable<? extends T> iterable, T t) {
        return (T) V.b(iterable.iterator(), t);
    }
}
