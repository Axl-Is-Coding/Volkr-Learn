package kotlin.collections;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class w implements Iterator<Integer>, kotlin.jvm.internal.a.a {
    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
