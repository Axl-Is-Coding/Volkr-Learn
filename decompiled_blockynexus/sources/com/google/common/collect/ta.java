package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: PeekingIterator.java */
/* JADX INFO: loaded from: classes2.dex */
public interface ta<E> extends Iterator<E> {
    @Override // java.util.Iterator
    E next();

    E peek();
}
