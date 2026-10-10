package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
class Q<T> extends Fa<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f13911a;

    Q(Iterator it) {
        this.f13911a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13911a.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        return (T) this.f13911a.next();
    }
}
