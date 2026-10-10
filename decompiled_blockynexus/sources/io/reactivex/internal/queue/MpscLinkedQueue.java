package io.reactivex.internal.queue;

import io.reactivex.c.a.j;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MpscLinkedQueue<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f22638a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicReference<LinkedQueueNode<T>> f22639b = new AtomicReference<>();

    static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        public E getAndNullValue() {
            E eLpValue = lpValue();
            spValue(null);
            return eLpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e2) {
            this.value = e2;
        }

        LinkedQueueNode(E e2) {
            spValue(e2);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        a(linkedQueueNode);
        b(linkedQueueNode);
    }

    LinkedQueueNode<T> a() {
        return this.f22639b.get();
    }

    LinkedQueueNode<T> b(LinkedQueueNode<T> linkedQueueNode) {
        return this.f22638a.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> c() {
        return this.f22638a.get();
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // io.reactivex.c.a.k
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
        b(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    @Override // io.reactivex.c.a.j, io.reactivex.c.a.k
    public T poll() {
        LinkedQueueNode<T> linkedQueueNodeLvNext;
        LinkedQueueNode<T> linkedQueueNodeA = a();
        LinkedQueueNode<T> linkedQueueNodeLvNext2 = linkedQueueNodeA.lvNext();
        if (linkedQueueNodeLvNext2 != null) {
            T andNullValue = linkedQueueNodeLvNext2.getAndNullValue();
            a(linkedQueueNodeLvNext2);
            return andNullValue;
        }
        if (linkedQueueNodeA == c()) {
            return null;
        }
        do {
            linkedQueueNodeLvNext = linkedQueueNodeA.lvNext();
        } while (linkedQueueNodeLvNext == null);
        T andNullValue2 = linkedQueueNodeLvNext.getAndNullValue();
        a(linkedQueueNodeLvNext);
        return andNullValue2;
    }

    void a(LinkedQueueNode<T> linkedQueueNode) {
        this.f22639b.lazySet(linkedQueueNode);
    }

    LinkedQueueNode<T> b() {
        return this.f22639b.get();
    }
}
