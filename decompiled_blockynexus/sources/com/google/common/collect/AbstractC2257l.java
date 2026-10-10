package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.common.collect.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractSequentialIterator.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2257l<T> extends Fa<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f13953a;

    protected AbstractC2257l(T t) {
        this.f13953a = t;
    }

    protected abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13953a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return this.f13953a;
        } finally {
            this.f13953a = a(this.f13953a);
        }
    }
}
