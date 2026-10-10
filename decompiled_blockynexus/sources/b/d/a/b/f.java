package b.d.a.b;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: LazyList.java */
/* JADX INFO: loaded from: classes2.dex */
public class f<E> extends AbstractList<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f2526a = g.a(f.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    List<E> f2527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Iterator<E> f2528c;

    public f(List<E> list, Iterator<E> it) {
        this.f2527b = list;
        this.f2528c = it;
    }

    private void a() {
        f2526a.a("blowup running");
        while (this.f2528c.hasNext()) {
            this.f2527b.add(this.f2528c.next());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.f2527b.size() > i) {
            return this.f2527b.get(i);
        }
        if (!this.f2528c.hasNext()) {
            throw new NoSuchElementException();
        }
        this.f2527b.add(this.f2528c.next());
        return get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new e(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        f2526a.a("potentially expensive size() call");
        a();
        return this.f2527b.size();
    }
}
