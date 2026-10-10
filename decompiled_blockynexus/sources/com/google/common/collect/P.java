package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
class P implements Iterator<Object> {
    P() {
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
        C2259n.a(false);
    }
}
