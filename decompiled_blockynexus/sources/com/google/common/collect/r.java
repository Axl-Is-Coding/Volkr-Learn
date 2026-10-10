package com.google.common.collect;

/* JADX INFO: compiled from: FluentIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class r<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterable<E> f13963a;

    protected r() {
        this.f13963a = this;
    }

    public static <E> r<E> a(Iterable<E> iterable) {
        return iterable instanceof r ? (r) iterable : new C2262q(iterable, iterable);
    }

    public String toString() {
        return L.c(this.f13963a);
    }

    public final r<E> a(com.google.common.base.n<? super E> nVar) {
        return a(L.b(this.f13963a, nVar));
    }

    r(Iterable<E> iterable) {
        com.google.common.base.m.a(iterable);
        this.f13963a = iterable;
    }

    public final ImmutableSet<E> a() {
        return ImmutableSet.copyOf(this.f13963a);
    }
}
