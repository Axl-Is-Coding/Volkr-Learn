package io.reactivex.internal.queue;

import io.reactivex.c.a.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements j<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public SpscArrayQueue(int i) {
        super(io.reactivex.internal.util.j.a(i));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    E lvElement(int i) {
        return get(i);
    }

    @Override // io.reactivex.c.a.k
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.mask;
        long j = this.producerIndex.get();
        int iCalcElementOffset = calcElementOffset(j, i);
        if (j >= this.producerLookAhead) {
            long j2 = ((long) this.lookAheadStep) + j;
            if (lvElement(calcElementOffset(j2, i)) == null) {
                this.producerLookAhead = j2;
            } else if (lvElement(iCalcElementOffset) != null) {
                return false;
            }
        }
        soElement(iCalcElementOffset, e2);
        soProducerIndex(j + 1);
        return true;
    }

    @Override // io.reactivex.c.a.j, io.reactivex.c.a.k
    public E poll() {
        long j = this.consumerIndex.get();
        int iCalcElementOffset = calcElementOffset(j);
        E eLvElement = lvElement(iCalcElementOffset);
        if (eLvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(iCalcElementOffset, null);
        return eLvElement;
    }

    void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    void soElement(int i, E e2) {
        lazySet(i, e2);
    }

    void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    public boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
