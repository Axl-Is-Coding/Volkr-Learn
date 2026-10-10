package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
class N<T> extends Fa<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f13907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f13908b;

    N(Object obj) {
        this.f13908b = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f13907a;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f13907a) {
            throw new NoSuchElementException();
        }
        this.f13907a = true;
        return (T) this.f13908b;
    }
}
