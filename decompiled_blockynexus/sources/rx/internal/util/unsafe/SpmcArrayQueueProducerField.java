package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressAnimalSniffer
abstract class SpmcArrayQueueProducerField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueProducerField.class, "producerIndex");
    private volatile long producerIndex;

    public SpmcArrayQueueProducerField(int i) {
        super(i);
    }

    protected final long lvProducerIndex() {
        return this.producerIndex;
    }

    protected final void soTail(long j) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j);
    }
}
