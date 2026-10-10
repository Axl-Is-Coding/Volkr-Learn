package com.google.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes2.dex */
class Z extends AbstractQueue<Object> {
    Z() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return V.a();
    }

    @Override // java.util.Queue
    public boolean offer(Object obj) {
        return true;
    }

    @Override // java.util.Queue
    public Object peek() {
        return null;
    }

    @Override // java.util.Queue
    public Object poll() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return 0;
    }
}
