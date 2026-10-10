package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.oa;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableMultiset<E> extends ImmutableCollection<E> implements oa<E> {
    private transient ImmutableSet<oa.a<E>> entrySet;

    private final class EntrySet extends ImmutableSet.Indexed<oa.a<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof oa.a)) {
                return false;
            }
            oa.a aVar = (oa.a) obj;
            return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, H h) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet.Indexed
        public oa.a<E> get(int i) {
            return ImmutableMultiset.this.getEntry(i);
        }
    }

    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(oa<?> oaVar) {
            int size = oaVar.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (oa.a<?> aVar : oaVar.entrySet()) {
                this.elements[i] = aVar.getElement();
                this.counts[i] = aVar.getCount();
                i++;
            }
        }

        Object readResolve() {
            LinkedHashMultiset linkedHashMultisetCreate = LinkedHashMultiset.create(this.elements.length);
            int i = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i >= objArr.length) {
                    return ImmutableMultiset.copyOf(linkedHashMultisetCreate);
                }
                linkedHashMultisetCreate.add(objArr[i], this.counts[i]);
                i++;
            }
        }
    }

    public static class a<E> extends ImmutableCollection.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final oa<E> f13846a;

        public a() {
            this(LinkedHashMultiset.create());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.b
        public /* bridge */ /* synthetic */ ImmutableCollection.b a(Object obj) {
            a(obj);
            return this;
        }

        a(oa<E> oaVar) {
            this.f13846a = oaVar;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public a<E> a(E e2) {
            oa<E> oaVar = this.f13846a;
            com.google.common.base.m.a(e2);
            oaVar.add(e2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        public a<E> a(E... eArr) {
            super.a((Object[]) eArr);
            return this;
        }

        public ImmutableMultiset<E> a() {
            return ImmutableMultiset.copyOf(this.f13846a);
        }
    }

    ImmutableMultiset() {
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        LinkedHashMultiset linkedHashMultisetCreate = LinkedHashMultiset.create();
        Collections.addAll(linkedHashMultisetCreate, eArr);
        return copyFromEntries(linkedHashMultisetCreate.entrySet());
    }

    static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends oa.a<? extends E>> collection) {
        return collection.isEmpty() ? of() : new RegularImmutableMultiset(collection);
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private final ImmutableSet<oa.a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // com.google.common.collect.oa
    @Deprecated
    public final int add(E e2, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i) {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            oa.a aVar = (oa.a) it.next();
            Arrays.fill(objArr, i, aVar.getCount() + i, aVar.getElement());
            i += aVar.getCount();
        }
        return i;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return Multisets.a(this, obj);
    }

    abstract oa.a<E> getEntry(int i);

    @Override // java.util.Collection
    public int hashCode() {
        return Aa.a(entrySet());
    }

    @Override // com.google.common.collect.oa
    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.oa
    @Deprecated
    public final int setCount(E e2, int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        return copyFromEntries((iterable instanceof oa ? Multisets.a(iterable) : LinkedHashMultiset.create(iterable)).entrySet());
    }

    public static <E> ImmutableMultiset<E> of(E e2) {
        return copyFromElements(e2);
    }

    @Override // com.google.common.collect.oa
    public ImmutableSet<oa.a<E>> entrySet() {
        ImmutableSet<oa.a<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<oa.a<E>> immutableSetCreateEntrySet = createEntrySet();
        this.entrySet = immutableSetCreateEntrySet;
        return immutableSetCreateEntrySet;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public Fa<E> iterator() {
        return new H(this, entrySet().iterator());
    }

    @Override // com.google.common.collect.oa
    @Deprecated
    public final boolean setCount(E e2, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3) {
        return copyFromElements(e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4) {
        return copyFromElements(e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5) {
        return copyFromElements(e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5, E e6) {
        return copyFromElements(e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        LinkedHashMultiset linkedHashMultisetCreate = LinkedHashMultiset.create();
        V.a(linkedHashMultisetCreate, it);
        return copyFromEntries(linkedHashMultisetCreate.entrySet());
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        a aVar = new a();
        aVar.a((Object) e2);
        aVar.a((Object) e3);
        aVar.a((Object) e4);
        aVar.a((Object) e5);
        aVar.a((Object) e6);
        aVar.a((Object) e7);
        aVar.a((Object[]) eArr);
        return aVar.a();
    }
}
