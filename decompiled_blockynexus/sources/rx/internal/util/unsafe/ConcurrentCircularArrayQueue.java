package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: loaded from: classes5.dex */
@SuppressAnimalSniffer
public abstract class ConcurrentCircularArrayQueue<E> extends ConcurrentCircularArrayQueueL0Pad<E> {
    protected static final int BUFFER_PAD = 32;
    private static final long REF_ARRAY_BASE;
    private static final int REF_ELEMENT_SHIFT;
    protected static final int SPARSE_SHIFT = Integer.getInteger("sparse.shift", 0).intValue();
    protected final E[] buffer;
    protected final long mask;

    static {
        int iArrayIndexScale = UnsafeAccess.UNSAFE.arrayIndexScale(Object[].class);
        if (4 == iArrayIndexScale) {
            REF_ELEMENT_SHIFT = SPARSE_SHIFT + 2;
        } else {
            if (8 != iArrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            REF_ELEMENT_SHIFT = SPARSE_SHIFT + 3;
        }
        REF_ARRAY_BASE = UnsafeAccess.UNSAFE.arrayBaseOffset(Object[].class) + (32 << (REF_ELEMENT_SHIFT - SPARSE_SHIFT));
    }

    public ConcurrentCircularArrayQueue(int i) {
        int iRoundToPowerOfTwo = Pow2.roundToPowerOfTwo(i);
        this.mask = iRoundToPowerOfTwo - 1;
        this.buffer = (E[]) new Object[(iRoundToPowerOfTwo << SPARSE_SHIFT) + 64];
    }

    protected final long calcElementOffset(long j) {
        return calcElementOffset(j, this.mask);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final E lpElement(long j) {
        return lpElement(this.buffer, j);
    }

    protected final E lvElement(long j) {
        return lvElement(this.buffer, j);
    }

    protected final void soElement(long j, E e2) {
        soElement(this.buffer, j, e2);
    }

    protected final void spElement(long j, E e2) {
        spElement(this.buffer, j, e2);
    }

    protected final long calcElementOffset(long j, long j2) {
        return REF_ARRAY_BASE + ((j & j2) << REF_ELEMENT_SHIFT);
    }

    protected final E lpElement(E[] eArr, long j) {
        return (E) UnsafeAccess.UNSAFE.getObject(eArr, j);
    }

    protected final E lvElement(E[] eArr, long j) {
        return (E) UnsafeAccess.UNSAFE.getObjectVolatile(eArr, j);
    }

    protected final void soElement(E[] eArr, long j, E e2) {
        UnsafeAccess.UNSAFE.putOrderedObject(eArr, j, e2);
    }

    protected final void spElement(E[] eArr, long j, E e2) {
        UnsafeAccess.UNSAFE.putObject(eArr, j, e2);
    }
}
