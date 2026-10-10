package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: kotlin.collections.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Collections.kt */
/* JADX INFO: loaded from: classes5.dex */
final class C2932c<T> implements Collection<T>, kotlin.jvm.internal.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T[] f22813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f22814b;

    public C2932c(T[] tArr, boolean z) {
        kotlin.jvm.internal.i.b(tArr, "values");
        this.f22813a = tArr;
        this.f22814b = z;
    }

    public int a() {
        return this.f22813a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return i.a(this.f22813a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        kotlin.jvm.internal.i.b(collection, MessengerShareContentUtility.ELEMENTS);
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f22813a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.b.a(this.f22813a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return l.a(this.f22813a, this.f22814b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) kotlin.jvm.internal.e.a(this, tArr);
    }
}
