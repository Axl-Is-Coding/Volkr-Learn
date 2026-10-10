package io.rong.imageloader.core.assist.deque;

/* JADX INFO: loaded from: classes5.dex */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // io.rong.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, io.rong.imageloader.core.assist.deque.BlockingDeque, java.util.concurrent.BlockingQueue, io.rong.imageloader.core.assist.deque.Deque
    public boolean offer(T t) {
        return super.offerFirst(t);
    }

    @Override // io.rong.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, io.rong.imageloader.core.assist.deque.BlockingDeque, io.rong.imageloader.core.assist.deque.Deque
    public T remove() {
        return (T) super.removeFirst();
    }
}
