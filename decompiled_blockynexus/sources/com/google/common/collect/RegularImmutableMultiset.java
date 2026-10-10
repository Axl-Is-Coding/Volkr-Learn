package com.google.common.collect;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multisets;
import com.google.common.collect.oa;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
class RegularImmutableMultiset<E> extends ImmutableMultiset<E> {
    static final RegularImmutableMultiset<Object> EMPTY = new RegularImmutableMultiset<>(ImmutableList.of());
    private transient ImmutableSet<E> elementSet;
    private final transient Multisets.ImmutableEntry<E>[] entries;
    private final transient int hashCode;
    private final transient Multisets.ImmutableEntry<E>[] hashTable;
    private final transient int size;

    private final class ElementSet extends ImmutableSet.Indexed<E> {
        private ElementSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return RegularImmutableMultiset.this.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableSet.Indexed
        E get(int i) {
            return (E) RegularImmutableMultiset.this.entries[i].getElement();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return RegularImmutableMultiset.this.entries.length;
        }
    }

    private static final class NonTerminalEntry<E> extends Multisets.ImmutableEntry<E> {
        private final Multisets.ImmutableEntry<E> nextInBucket;

        NonTerminalEntry(E e2, int i, Multisets.ImmutableEntry<E> immutableEntry) {
            super(e2, i);
            this.nextInBucket = immutableEntry;
        }

        @Override // com.google.common.collect.Multisets.ImmutableEntry
        public Multisets.ImmutableEntry<E> nextInBucket() {
            return this.nextInBucket;
        }
    }

    RegularImmutableMultiset(Collection<? extends oa.a<? extends E>> collection) {
        int size = collection.size();
        Multisets.ImmutableEntry<E>[] immutableEntryArr = new Multisets.ImmutableEntry[size];
        if (size == 0) {
            this.entries = immutableEntryArr;
            this.hashTable = null;
            this.size = 0;
            this.hashCode = 0;
            this.elementSet = ImmutableSet.of();
            return;
        }
        int iA = C2268x.a(size, 1.0d);
        int i = iA - 1;
        Multisets.ImmutableEntry<E>[] immutableEntryArr2 = new Multisets.ImmutableEntry[iA];
        long j = 0;
        int i2 = 0;
        int i3 = 0;
        for (oa.a<? extends E> aVar : collection) {
            E element = aVar.getElement();
            com.google.common.base.m.a(element);
            int count = aVar.getCount();
            int iHashCode = element.hashCode();
            int iA2 = C2268x.a(iHashCode) & i;
            Multisets.ImmutableEntry<E> immutableEntry = immutableEntryArr2[iA2];
            Multisets.ImmutableEntry<E> immutableEntry2 = immutableEntry == null ? (aVar instanceof Multisets.ImmutableEntry) && !(aVar instanceof NonTerminalEntry) ? (Multisets.ImmutableEntry) aVar : new Multisets.ImmutableEntry<>(element, count) : new NonTerminalEntry<>(element, count, immutableEntry);
            i2 += iHashCode ^ count;
            immutableEntryArr[i3] = immutableEntry2;
            immutableEntryArr2[iA2] = immutableEntry2;
            j += (long) count;
            i3++;
        }
        this.entries = immutableEntryArr;
        this.hashTable = immutableEntryArr2;
        this.size = b.c.b.b.a.a(j);
        this.hashCode = i2;
    }

    @Override // com.google.common.collect.oa
    public int count(Object obj) {
        Multisets.ImmutableEntry<E>[] immutableEntryArr = this.hashTable;
        if (obj != null && immutableEntryArr != null) {
            for (Multisets.ImmutableEntry<E> immutableEntryNextInBucket = immutableEntryArr[C2268x.a(obj) & (immutableEntryArr.length - 1)]; immutableEntryNextInBucket != null; immutableEntryNextInBucket = immutableEntryNextInBucket.nextInBucket()) {
                if (com.google.common.base.k.a(obj, immutableEntryNextInBucket.getElement())) {
                    return immutableEntryNextInBucket.getCount();
                }
            }
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    oa.a<E> getEntry(int i) {
        return this.entries[i];
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableCollection
    boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.oa
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ElementSet elementSet = new ElementSet();
        this.elementSet = elementSet;
        return elementSet;
    }
}
