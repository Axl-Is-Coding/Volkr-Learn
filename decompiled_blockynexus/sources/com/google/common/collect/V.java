package com.google.common.collect;

import com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
public final class V {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Ga<Object> f13917a = new O();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Iterator<Object> f13918b = new P();

    /* JADX INFO: compiled from: Iterators.java */
    private static class a<E> implements ta<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator<? extends E> f13919a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f13920b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private E f13921c;

        public a(Iterator<? extends E> it) {
            com.google.common.base.m.a(it);
            this.f13919a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13920b || this.f13919a.hasNext();
        }

        @Override // com.google.common.collect.ta, java.util.Iterator
        public E next() {
            if (!this.f13920b) {
                return this.f13919a.next();
            }
            E e2 = this.f13921c;
            this.f13920b = false;
            this.f13921c = null;
            return e2;
        }

        @Override // com.google.common.collect.ta
        public E peek() {
            if (!this.f13920b) {
                this.f13921c = this.f13919a.next();
                this.f13920b = true;
            }
            return this.f13921c;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.base.m.b(!this.f13920b, "Can't remove after you've peeked at next");
            this.f13919a.remove();
        }
    }

    @Deprecated
    public static <T> Fa<T> a() {
        return b();
    }

    static <T> Ga<T> b() {
        return (Ga<T>) f13917a;
    }

    static <T> Iterator<T> c() {
        return (Iterator<T>) f13918b;
    }

    public static String d(Iterator<?> it) {
        com.google.common.base.h hVar = C2261p.f13960a;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        hVar.a(sb, it);
        sb.append(']');
        return sb.toString();
    }

    public static <T> Fa<T> e(Iterator<T> it) {
        com.google.common.base.m.a(it);
        return it instanceof Fa ? (Fa) it : new Q(it);
    }

    public static boolean a(Iterator<?> it, Object obj) {
        return b((Iterator) it, Predicates.a(obj));
    }

    public static boolean b(Iterator<?> it, Collection<?> collection) {
        return e(it, Predicates.a(Predicates.a((Collection) collection)));
    }

    public static <T> Fa<T> c(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.a(it);
        com.google.common.base.m.a(nVar);
        return new T(it, nVar);
    }

    public static <T> int d(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.a(nVar, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean a(Iterator<?> it, Collection<?> collection) {
        return e(it, Predicates.a((Collection) collection));
    }

    public static <T> T b(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <" + next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", " + it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static boolean a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.k.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> ta<T> c(Iterator<? extends T> it) {
        if (it instanceof a) {
            return (a) it;
        }
        return new a(it);
    }

    public static <T> boolean e(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.a(nVar);
        boolean z = false;
        while (it.hasNext()) {
            if (nVar.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.m.a(collection);
        com.google.common.base.m.a(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    public static <T> boolean b(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        return d(it, nVar) != -1;
    }

    public static <T> Iterator<T> a(Iterable<T> iterable) {
        com.google.common.base.m.a(iterable);
        return new S(iterable);
    }

    public static <T> T b(Iterator<? extends T> it, T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static <T> boolean a(Iterator<T> it, com.google.common.base.n<? super T> nVar) {
        com.google.common.base.m.a(nVar);
        while (it.hasNext()) {
            if (!nVar.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <F, T> Iterator<T> a(Iterator<F> it, com.google.common.base.f<? super F, ? extends T> fVar) {
        com.google.common.base.m.a(fVar);
        return new U(it, fVar);
    }

    static void a(Iterator<?> it) {
        com.google.common.base.m.a(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Fa<T> a(T... tArr) {
        return a(tArr, 0, tArr.length, 0);
    }

    static <T> Ga<T> a(T[] tArr, int i, int i2, int i3) {
        com.google.common.base.m.a(i2 >= 0);
        com.google.common.base.m.a(i, i + i2, tArr.length);
        com.google.common.base.m.b(i3, i2);
        if (i2 == 0) {
            return b();
        }
        return new M(i2, i3, tArr, i);
    }

    public static <T> Fa<T> a(T t) {
        return new N(t);
    }
}
