package b.d.a.b;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: LazyList.java */
/* JADX INFO: loaded from: classes2.dex */
class e<E> implements Iterator<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2524a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f2525b;

    e(f fVar) {
        this.f2525b = fVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2524a < this.f2525b.f2527b.size() || this.f2525b.f2528c.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.f2524a >= this.f2525b.f2527b.size()) {
            f fVar = this.f2525b;
            fVar.f2527b.add(fVar.f2528c.next());
            return next();
        }
        List<E> list = this.f2525b.f2527b;
        int i = this.f2524a;
        this.f2524a = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
