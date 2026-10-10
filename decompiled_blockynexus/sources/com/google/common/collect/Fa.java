package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: UnmodifiableIterator.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Fa<E> implements Iterator<E> {
    protected Fa() {
    }

    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
