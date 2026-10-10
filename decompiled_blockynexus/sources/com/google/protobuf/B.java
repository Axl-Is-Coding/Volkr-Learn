package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ProtobufArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
final class B<E> extends AbstractC2297c<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final B<Object> f14264b = new B<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<E> f14265c;

    static {
        f14264b.b();
    }

    B() {
        this(new ArrayList(10));
    }

    public static <E> B<E> c() {
        return (B<E>) f14264b;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e2) {
        a();
        this.f14265c.add(i, e2);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return this.f14265c.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        a();
        E eRemove = this.f14265c.remove(i);
        ((AbstractList) this).modCount++;
        return eRemove;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e2) {
        a();
        E e3 = this.f14265c.set(i, e2);
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14265c.size();
    }

    private B(List<E> list) {
        this.f14265c = list;
    }

    @Override // com.google.protobuf.r.h
    public B<E> a(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.f14265c);
        return new B<>(arrayList);
    }
}
