package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(ra.f13964a);
    private final transient Object[] array;
    private final transient int offset;
    private final transient int size;

    RegularImmutableList(Object[] objArr, int i, int i2) {
        this.offset = i;
        this.size = i2;
        this.array = objArr;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i) {
        System.arraycopy(this.array, this.offset, objArr, i, this.size);
        return i + this.size;
    }

    @Override // java.util.List
    public E get(int i) {
        com.google.common.base.m.a(i, this.size);
        return (E) this.array[i + this.offset];
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return this.size != this.array.length;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableList
    ImmutableList<E> subListUnchecked(int i, int i2) {
        return new RegularImmutableList(this.array, this.offset + i, i2 - i);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public Ga<E> listIterator(int i) {
        return V.a(this.array, this.offset, this.size, i);
    }

    RegularImmutableList(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }
}
