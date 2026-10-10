package com.google.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes2.dex */
class F implements Iterator<Object> {
    F() {
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
