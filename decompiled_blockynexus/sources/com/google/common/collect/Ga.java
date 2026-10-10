package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: compiled from: UnmodifiableListIterator.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Ga<E> extends Fa<E> implements ListIterator<E> {
    protected Ga() {
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @Deprecated
    public final void set(E e2) {
        throw new UnsupportedOperationException();
    }
}
