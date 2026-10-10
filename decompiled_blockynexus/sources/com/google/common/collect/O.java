package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
class O extends Ga<Object> {
    O() {
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public Object next() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return -1;
    }
}
