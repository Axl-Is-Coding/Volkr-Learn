package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableCreate<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.s<T> f22099a;

    static final class CreateEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.r<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -3434801548987643227L;
        final io.reactivex.w<? super T> observer;

        CreateEmitter(io.reactivex.w<? super T> wVar) {
            this.observer = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.r, io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (isDisposed()) {
                return;
            }
            try {
                this.observer.onComplete();
            } finally {
                dispose();
            }
        }

        @Override // io.reactivex.d
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.e.a.b(th);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                if (isDisposed()) {
                    return;
                }
                this.observer.onNext(t);
            }
        }

        public io.reactivex.r<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.r
        public void setCancellable(io.reactivex.b.f fVar) {
            setDisposable(new CancellableDisposable(fVar));
        }

        @Override // io.reactivex.r
        public void setDisposable(io.reactivex.disposables.b bVar) {
            DisposableHelper.set(this, bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", CreateEmitter.class.getSimpleName(), super.toString());
        }

        public boolean tryOnError(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements io.reactivex.r<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final io.reactivex.r<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final io.reactivex.internal.queue.a<T> queue = new io.reactivex.internal.queue.a<>(16);

        SerializedEmitter(io.reactivex.r<T> rVar) {
            this.emitter = rVar;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            io.reactivex.r<T> rVar = this.emitter;
            io.reactivex.internal.queue.a<T> aVar = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int iAddAndGet = 1;
            while (!rVar.isDisposed()) {
                if (atomicThrowable.get() != null) {
                    aVar.clear();
                    rVar.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z = this.done;
                T tPoll = aVar.poll();
                boolean z2 = tPoll == null;
                if (z && z2) {
                    rVar.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    rVar.onNext(tPoll);
                }
            }
            aVar.clear();
        }

        @Override // io.reactivex.r, io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.d
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            io.reactivex.e.a.b(th);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.emitter.isDisposed() || this.done) {
                return;
            }
            if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                io.reactivex.internal.queue.a<T> aVar = this.queue;
                synchronized (aVar) {
                    aVar.offer(t);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public io.reactivex.r<T> serialize() {
            return this;
        }

        @Override // io.reactivex.r
        public void setCancellable(io.reactivex.b.f fVar) {
            this.emitter.setCancellable(fVar);
        }

        @Override // io.reactivex.r
        public void setDisposable(io.reactivex.disposables.b bVar) {
            this.emitter.setDisposable(bVar);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isDisposed() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public ObservableCreate(io.reactivex.s<T> sVar) {
        this.f22099a = sVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        CreateEmitter createEmitter = new CreateEmitter(wVar);
        wVar.onSubscribe(createEmitter);
        try {
            this.f22099a.a(createEmitter);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            createEmitter.onError(th);
        }
    }
}
