package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterator.kt */
/* JADX INFO: loaded from: classes5.dex */
final class a<T> implements Iterator<T>, kotlin.jvm.internal.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f22845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T[] f22846b;

    public a(T[] tArr) {
        i.b(tArr, "array");
        this.f22846b = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22845a < this.f22846b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f22846b;
            int i = this.f22845a;
            this.f22845a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f22845a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
