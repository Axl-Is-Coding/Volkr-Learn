package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: compiled from: MpmcArrayQueue.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressAnimalSniffer
abstract class MpmcArrayQueueProducerField<E> extends MpmcArrayQueueL1Pad<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueProducerField.class, "producerIndex");
    private volatile long producerIndex;

    public MpmcArrayQueueProducerField(int i) {
        super(i);
    }

    protected final boolean casProducerIndex(long j, long j2) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, j, j2);
    }

    protected final long lvProducerIndex() {
        return this.producerIndex;
    }
}
