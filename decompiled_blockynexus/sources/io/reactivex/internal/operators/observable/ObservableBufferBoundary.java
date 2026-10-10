package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBufferBoundary<T, U extends Collection<? super T>, Open, Close> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<U> f22074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.u<? extends Open> f22075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.b.o<? super Open, ? extends io.reactivex.u<? extends Close>> f22076d;

    static final class BufferBoundaryObserver<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8466418554264089604L;
        final io.reactivex.b.o<? super Open, ? extends io.reactivex.u<? extends Close>> bufferClose;
        final io.reactivex.u<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        final io.reactivex.w<? super C> downstream;
        long index;
        final io.reactivex.internal.queue.a<C> queue = new io.reactivex.internal.queue.a<>(io.reactivex.p.bufferSize());
        final io.reactivex.disposables.a observers = new io.reactivex.disposables.a();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        Map<Long, C> buffers = new LinkedHashMap();
        final AtomicThrowable errors = new AtomicThrowable();

        static final class BufferOpenObserver<Open> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<Open>, io.reactivex.disposables.b {
            private static final long serialVersionUID = -8498650778633225126L;
            final BufferBoundaryObserver<?, ?, Open, ?> parent;

            BufferOpenObserver(BufferBoundaryObserver<?, ?, Open, ?> bufferBoundaryObserver) {
                this.parent = bufferBoundaryObserver;
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.w
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.openComplete(this);
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.boundaryError(this, th);
            }

            @Override // io.reactivex.w
            public void onNext(Open open) {
                this.parent.open(open);
            }

            @Override // io.reactivex.w
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        BufferBoundaryObserver(io.reactivex.w<? super C> wVar, io.reactivex.u<? extends Open> uVar, io.reactivex.b.o<? super Open, ? extends io.reactivex.u<? extends Close>> oVar, Callable<C> callable) {
            this.downstream = wVar;
            this.bufferSupplier = callable;
            this.bufferOpen = uVar;
            this.bufferClose = oVar;
        }

        void boundaryError(io.reactivex.disposables.b bVar, Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.observers.c(bVar);
            onError(th);
        }

        void close(BufferCloseObserver<T, C> bufferCloseObserver, long j) {
            boolean z;
            this.observers.c(bufferCloseObserver);
            if (this.observers.a() == 0) {
                DisposableHelper.dispose(this.upstream);
                z = true;
            } else {
                z = false;
            }
            synchronized (this) {
                if (this.buffers == null) {
                    return;
                }
                this.queue.offer(this.buffers.remove(Long.valueOf(j)));
                if (z) {
                    this.done = true;
                }
                drain();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.w<? super C> wVar = this.downstream;
            io.reactivex.internal.queue.a<C> aVar = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && this.errors.get() != null) {
                    aVar.clear();
                    wVar.onError(this.errors.terminate());
                    return;
                }
                C cPoll = aVar.poll();
                boolean z2 = cPoll == null;
                if (z && z2) {
                    wVar.onComplete();
                    return;
                } else if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    wVar.onNext(cPoll);
                }
            }
            aVar.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    this.queue.offer(it.next());
                }
                this.buffers = null;
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.observers.dispose();
            synchronized (this) {
                this.buffers = null;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map == null) {
                    return;
                }
                Iterator<C> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this.upstream, bVar)) {
                BufferOpenObserver bufferOpenObserver = new BufferOpenObserver(this);
                this.observers.b(bufferOpenObserver);
                this.bufferOpen.subscribe(bufferOpenObserver);
            }
        }

        void open(Open open) {
            try {
                C cCall = this.bufferSupplier.call();
                io.reactivex.internal.functions.a.a(cCall, "The bufferSupplier returned a null Collection");
                C c2 = cCall;
                io.reactivex.u<? extends Close> uVarApply = this.bufferClose.apply(open);
                io.reactivex.internal.functions.a.a(uVarApply, "The bufferClose returned a null ObservableSource");
                io.reactivex.u<? extends Close> uVar = uVarApply;
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map == null) {
                        return;
                    }
                    map.put(Long.valueOf(j), c2);
                    BufferCloseObserver bufferCloseObserver = new BufferCloseObserver(this, j);
                    this.observers.b(bufferCloseObserver);
                    uVar.subscribe(bufferCloseObserver);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                DisposableHelper.dispose(this.upstream);
                onError(th);
            }
        }

        void openComplete(BufferOpenObserver<Open> bufferOpenObserver) {
            this.observers.c(bufferOpenObserver);
            if (this.observers.a() == 0) {
                DisposableHelper.dispose(this.upstream);
                this.done = true;
                drain();
            }
        }
    }

    static final class BufferCloseObserver<T, C extends Collection<? super T>> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final BufferBoundaryObserver<T, C, ?, ?> parent;

        BufferCloseObserver(BufferBoundaryObserver<T, C, ?, ?> bufferBoundaryObserver, long j) {
            this.parent = bufferBoundaryObserver;
            this.index = j;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                io.reactivex.e.a.b(th);
            } else {
                lazySet(disposableHelper);
                this.parent.boundaryError(this, th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            io.reactivex.disposables.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                bVar.dispose();
                this.parent.close(this, this.index);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableBufferBoundary(io.reactivex.u<T> uVar, io.reactivex.u<? extends Open> uVar2, io.reactivex.b.o<? super Open, ? extends io.reactivex.u<? extends Close>> oVar, Callable<U> callable) {
        super(uVar);
        this.f22075c = uVar2;
        this.f22076d = oVar;
        this.f22074b = callable;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super U> wVar) {
        BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(wVar, this.f22075c, this.f22076d, this.f22074b);
        wVar.onSubscribe(bufferBoundaryObserver);
        this.f22358a.subscribe(bufferBoundaryObserver);
    }
}
