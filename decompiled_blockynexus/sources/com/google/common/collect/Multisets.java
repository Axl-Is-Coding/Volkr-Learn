package com.google.common.collect;

import com.google.common.collect.Aa;
import com.google.common.collect.oa;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class Multisets {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Ordering<oa.a<?>> f13906a = new pa();

    static class ImmutableEntry<E> extends a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        ImmutableEntry(E e2, int i) {
            this.element = e2;
            this.count = i;
            C2259n.a(i, "count");
        }

        @Override // com.google.common.collect.oa.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.oa.a
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    static abstract class a<E> implements oa.a<E> {
        a() {
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof oa.a)) {
                return false;
            }
            oa.a aVar = (oa.a) obj;
            return getCount() == aVar.getCount() && com.google.common.base.k.a(getElement(), aVar.getElement());
        }

        public int hashCode() {
            E element = getElement();
            return (element == null ? 0 : element.hashCode()) ^ getCount();
        }

        public String toString() {
            String strValueOf = String.valueOf(getElement());
            int count = getCount();
            if (count == 1) {
                return strValueOf;
            }
            return strValueOf + " x " + count;
        }
    }

    static abstract class b<E> extends Aa.a<E> {
        b() {
        }

        abstract oa<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return a().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return a().containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return a().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new qa(this, a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return a().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a().entrySet().size();
        }
    }

    static abstract class c<E> extends Aa.a<oa.a<E>> {
        c() {
        }

        abstract oa<E> a();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            a().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof oa.a)) {
                return false;
            }
            oa.a aVar = (oa.a) obj;
            return aVar.getCount() > 0 && a().count(aVar.getElement()) == aVar.getCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof oa.a) {
                oa.a aVar = (oa.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return a().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    public static <E> oa.a<E> a(E e2, int i) {
        return new ImmutableEntry(e2, i);
    }

    static int b(Iterable<?> iterable) {
        if (iterable instanceof oa) {
            return ((oa) iterable).elementSet().size();
        }
        return 11;
    }

    static boolean c(oa<?> oaVar, Collection<?> collection) {
        com.google.common.base.m.a(collection);
        if (collection instanceof oa) {
            collection = ((oa) collection).elementSet();
        }
        return oaVar.elementSet().retainAll(collection);
    }

    static boolean a(oa<?> oaVar, Object obj) {
        if (obj == oaVar) {
            return true;
        }
        if (obj instanceof oa) {
            oa oaVar2 = (oa) obj;
            if (oaVar.size() == oaVar2.size() && oaVar.entrySet().size() == oaVar2.entrySet().size()) {
                for (oa.a aVar : oaVar2.entrySet()) {
                    if (oaVar.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    static boolean b(oa<?> oaVar, Collection<?> collection) {
        if (collection instanceof oa) {
            collection = ((oa) collection).elementSet();
        }
        return oaVar.elementSet().removeAll(collection);
    }

    static <E> boolean a(oa<E> oaVar, Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        if (collection instanceof oa) {
            for (oa.a<E> aVar : a(collection).entrySet()) {
                oaVar.add(aVar.getElement(), aVar.getCount());
            }
            return true;
        }
        V.a(oaVar, collection.iterator());
        return true;
    }

    static <E> int a(oa<E> oaVar, E e2, int i) {
        C2259n.a(i, "count");
        int iCount = oaVar.count(e2);
        int i2 = i - iCount;
        if (i2 > 0) {
            oaVar.add(e2, i2);
        } else if (i2 < 0) {
            oaVar.remove(e2, -i2);
        }
        return iCount;
    }

    static <E> boolean a(oa<E> oaVar, E e2, int i, int i2) {
        C2259n.a(i, "oldCount");
        C2259n.a(i2, "newCount");
        if (oaVar.count(e2) != i) {
            return false;
        }
        oaVar.setCount(e2, i2);
        return true;
    }

    static int a(oa<?> oaVar) {
        Iterator<oa.a<?>> it = oaVar.entrySet().iterator();
        long count = 0;
        while (it.hasNext()) {
            count += (long) it.next().getCount();
        }
        return b.c.b.b.a.a(count);
    }

    static <T> oa<T> a(Iterable<T> iterable) {
        return (oa) iterable;
    }
}
