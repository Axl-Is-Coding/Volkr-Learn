package kotlin.e;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i<R> implements Iterator<R>, kotlin.jvm.internal.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterator<T> f22841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f22842b;

    i(j jVar) {
        this.f22842b = jVar;
        this.f22841a = jVar.f22843a.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22841a.hasNext();
    }

    @Override // java.util.Iterator
    public R next() {
        return (R) this.f22842b.f22844b.invoke(this.f22841a.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
