package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f22005b;

    static final class BlockingObservableIterator<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, Iterator<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 6695226475494099826L;
        volatile boolean done;
        Throwable error;
        final io.reactivex.internal.queue.a<T> queue;
        final Lock lock = new ReentrantLock();
        final Condition condition = this.lock.newCondition();

        BlockingObservableIterator(int i) {
            this.queue = new io.reactivex.internal.queue.a<>(i);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                boolean z = this.done;
                boolean zIsEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw ExceptionHelper.b(th);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                try {
                    io.reactivex.internal.util.c.a();
                    this.lock.lock();
                    while (!this.done && this.queue.isEmpty()) {
                        try {
                            this.condition.await();
                        } finally {
                        }
                    }
                    this.lock.unlock();
                } catch (InterruptedException e2) {
                    DisposableHelper.dispose(this);
                    signalConsumer();
                    throw ExceptionHelper.b(e2);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public BlockingObservableIterable(io.reactivex.u<? extends T> uVar, int i) {
        this.f22004a = uVar;
        this.f22005b = i;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f22005b);
        this.f22004a.subscribe(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
