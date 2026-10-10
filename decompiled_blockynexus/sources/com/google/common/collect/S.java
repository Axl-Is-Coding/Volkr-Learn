package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
class S<T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Iterator<T> f13912a = V.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterable f13913b;

    S(Iterable iterable) {
        this.f13913b = iterable;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13912a.hasNext() || this.f13913b.iterator().hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        if (!this.f13912a.hasNext()) {
            this.f13912a = this.f13913b.iterator();
            if (!this.f13912a.hasNext()) {
                throw new NoSuchElementException();
            }
        }
        return this.f13912a.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f13912a.remove();
    }
}
