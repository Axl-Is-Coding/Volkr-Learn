package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: renamed from: kotlin.collections.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractList.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2931b<E> extends AbstractC2930a<E> implements List<E>, kotlin.jvm.internal.a.a {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: kotlin.collections.b$a */
    /* JADX INFO: compiled from: AbstractList.kt */
    public static final class a {
        private a() {
        }

        public final void a(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void b(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
            if (i <= i2) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }

        public final int a(Collection<?> collection) {
            kotlin.jvm.internal.i.b(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public final boolean a(Collection<?> collection, Collection<?> collection2) {
            kotlin.jvm.internal.i.b(collection, "c");
            kotlin.jvm.internal.i.b(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.i.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractList.kt */
    private class C0245b implements Iterator<E>, kotlin.jvm.internal.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f22807a;

        public C0245b() {
        }

        protected final int a() {
            return this.f22807a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22807a < AbstractC2931b.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC2931b abstractC2931b = AbstractC2931b.this;
            int i = this.f22807a;
            this.f22807a = i + 1;
            return (E) abstractC2931b.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        protected final void a(int i) {
            this.f22807a = i;
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.b$c */
    /* JADX INFO: compiled from: AbstractList.kt */
    private class c extends AbstractC2931b<E>.C0245b implements ListIterator<E>, kotlin.jvm.internal.a.a {
        public c(int i) {
            super();
            AbstractC2931b.Companion.b(i, AbstractC2931b.this.size());
            a(i);
        }

        @Override // java.util.ListIterator
        public void add(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC2931b abstractC2931b = AbstractC2931b.this;
            a(a() - 1);
            return (E) abstractC2931b.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e2) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.b$d */
    /* JADX INFO: compiled from: AbstractList.kt */
    private static final class d<E> extends AbstractC2931b<E> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f22810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AbstractC2931b<E> f22811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f22812c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(AbstractC2931b<? extends E> abstractC2931b, int i, int i2) {
            kotlin.jvm.internal.i.b(abstractC2931b, "list");
            this.f22811b = abstractC2931b;
            this.f22812c = i;
            AbstractC2931b.Companion.a(this.f22812c, i2, this.f22811b.size());
            this.f22810a = i2 - this.f22812c;
        }

        @Override // kotlin.collections.AbstractC2931b, java.util.List
        public E get(int i) {
            AbstractC2931b.Companion.a(i, this.f22810a);
            return this.f22811b.get(this.f22812c + i);
        }

        @Override // kotlin.collections.AbstractC2931b, kotlin.collections.AbstractC2930a
        public int getSize() {
            return this.f22810a;
        }
    }

    protected AbstractC2931b() {
    }

    @Override // java.util.List
    public void add(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.a(this, (Collection<?>) obj);
        }
        return false;
    }

    @Override // java.util.List
    public abstract E get(int i);

    @Override // kotlin.collections.AbstractC2930a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.a(this);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        Iterator<E> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (kotlin.jvm.internal.i.a(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractC2930a, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new C0245b();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.i.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i, E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new d(this, i, i2);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new c(i);
    }
}
