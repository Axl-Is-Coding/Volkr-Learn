package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
abstract class BaseLinkedAtomicQueue<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> producerNode = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> consumerNode = new AtomicReference<>();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final LinkedQueueNode<E> lpConsumerNode() {
        return this.consumerNode.get();
    }

    protected final LinkedQueueNode<E> lpProducerNode() {
        return this.producerNode.get();
    }

    protected final LinkedQueueNode<E> lvConsumerNode() {
        return this.consumerNode.get();
    }

    protected final LinkedQueueNode<E> lvProducerNode() {
        return this.producerNode.get();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> linkedQueueNodeLvNext;
        LinkedQueueNode<E> linkedQueueNodeLvConsumerNode = lvConsumerNode();
        LinkedQueueNode<E> linkedQueueNodeLvProducerNode = lvProducerNode();
        int i = 0;
        while (linkedQueueNodeLvConsumerNode != linkedQueueNodeLvProducerNode && i < Integer.MAX_VALUE) {
            do {
                linkedQueueNodeLvNext = linkedQueueNodeLvConsumerNode.lvNext();
            } while (linkedQueueNodeLvNext == null);
            i++;
            linkedQueueNodeLvConsumerNode = linkedQueueNodeLvNext;
        }
        return i;
    }

    protected final void spConsumerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.consumerNode.lazySet(linkedQueueNode);
    }

    protected final void spProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        this.producerNode.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        return this.producerNode.getAndSet(linkedQueueNode);
    }
}
