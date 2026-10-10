package io.reactivex.internal.operators.observable;

import a.a.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableMergeWithMaybe<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.m<? extends T> f22147b;

    static final class MergeWithObserver<T> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final io.reactivex.w<? super T> downstream;
        volatile boolean mainDone;
        volatile int otherState;
        volatile io.reactivex.c.a.j<T> queue;
        T singleItem;
        final AtomicReference<io.reactivex.disposables.b> mainDisposable = new AtomicReference<>();
        final OtherObserver<T> otherObserver = new OtherObserver<>(this);
        final AtomicThrowable error = new AtomicThrowable();

        static final class OtherObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.k<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<T> parent;

            OtherObserver(MergeWithObserver<T> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.k
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.k
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.k
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.k
            public void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }
        }

        MergeWithObserver(io.reactivex.w<? super T> wVar) {
            this.downstream = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            io.reactivex.w<? super T> wVar = this.downstream;
            int iAddAndGet = 1;
            while (!this.disposed) {
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    wVar.onError(this.error.terminate());
                    return;
                }
                int i = this.otherState;
                if (i == 1) {
                    T t = this.singleItem;
                    this.singleItem = null;
                    this.otherState = 2;
                    wVar.onNext(t);
                    i = 2;
                }
                boolean z = this.mainDone;
                io.reactivex.c.a.j<T> jVar = this.queue;
                h.b bVarPoll = jVar != null ? jVar.poll() : null;
                boolean z2 = bVarPoll == null;
                if (z && z2 && i == 2) {
                    this.queue = null;
                    wVar.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    wVar.onNext(bVarPoll);
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        io.reactivex.c.a.j<T> getOrCreateQueue() {
            io.reactivex.c.a.j<T> jVar = this.queue;
            if (jVar != null) {
                return jVar;
            }
            io.reactivex.internal.queue.a aVar = new io.reactivex.internal.queue.a(io.reactivex.p.bufferSize());
            this.queue = aVar;
            return aVar;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.mainDone = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }

        void otherComplete() {
            this.otherState = 2;
            drain();
        }

        void otherError(Throwable th) {
            if (!this.error.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                DisposableHelper.dispose(this.mainDisposable);
                drain();
            }
        }

        void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }
    }

    public ObservableMergeWithMaybe(io.reactivex.p<T> pVar, io.reactivex.m<? extends T> mVar) {
        super(pVar);
        this.f22147b = mVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(wVar);
        wVar.onSubscribe(mergeWithObserver);
        this.f22358a.subscribe(mergeWithObserver);
        this.f22147b.a(mergeWithObserver.otherObserver);
    }
}
