package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

/* JADX INFO: compiled from: MpmcArrayQueue.java */
/* JADX INFO: loaded from: classes5.dex */
@SuppressAnimalSniffer
abstract class MpmcArrayQueueConsumerField<E> extends MpmcArrayQueueL2Pad<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueConsumerField.class, "consumerIndex");
    private volatile long consumerIndex;

    public MpmcArrayQueueConsumerField(int i) {
        super(i);
    }

    protected final boolean casConsumerIndex(long j, long j2) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, j, j2);
    }

    protected final long lvConsumerIndex() {
        return this.consumerIndex;
    }
}
