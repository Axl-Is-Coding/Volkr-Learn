package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    SingletonImmutableList(E e2) {
        com.google.common.base.m.a(e2);
        this.element = e2;
    }

    @Override // java.util.List
    public E get(int i) {
        com.google.common.base.m.a(i, 1);
        return this.element;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        String string = this.element.toString();
        StringBuilder sb = new StringBuilder(string.length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public Fa<E> iterator() {
        return V.a(this.element);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int i, int i2) {
        com.google.common.base.m.a(i, i2, 1);
        return i == i2 ? ImmutableList.of() : this;
    }
}
