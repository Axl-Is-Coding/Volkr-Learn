package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: com.google.common.collect.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractIndexedListIterator.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractC2239a<E> extends Ga<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13923b;

    protected AbstractC2239a(int i, int i2) {
        com.google.common.base.m.b(i2, i);
        this.f13922a = i;
        this.f13923b = i2;
    }

    protected abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f13923b < this.f13922a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f13923b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f13923b;
        this.f13923b = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f13923b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f13923b - 1;
        this.f13923b = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f13923b - 1;
    }
}
