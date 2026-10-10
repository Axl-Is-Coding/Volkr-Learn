package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet<>(ra.f13964a, 0, null, 0);
    private final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    final transient Object[] table;

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i2;
        this.hashCode = i;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int iA = C2268x.a(obj);
        while (true) {
            int i = iA & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iA = i + 1;
        }
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i) {
        Object[] objArr2 = this.elements;
        System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
        return i + this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableCollection
    ImmutableList<E> createAsList() {
        return this.table == null ? ImmutableList.of() : new RegularImmutableAsList(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.length;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public Fa<E> iterator() {
        return V.a(this.elements);
    }
}
