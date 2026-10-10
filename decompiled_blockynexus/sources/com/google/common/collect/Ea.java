package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: TransformedIterator.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class Ea<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Iterator<? extends F> f13822a;

    Ea(Iterator<? extends F> it) {
        com.google.common.base.m.a(it);
        this.f13822a = it;
    }

    abstract T a(F f2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13822a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f13822a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f13822a.remove();
    }
}
