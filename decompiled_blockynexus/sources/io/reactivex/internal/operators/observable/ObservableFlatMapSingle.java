package io.reactivex.internal.operators.observable;

import a.a.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableFlatMapSingle<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.A<? extends R>> f22121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f22122c;

    static final class FlatMapSingleObserver<T, R> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8600231336733376951L;
        volatile boolean cancelled;
        final boolean delayErrors;
        final io.reactivex.w<? super R> downstream;
        final io.reactivex.b.o<? super T, ? extends io.reactivex.A<? extends R>> mapper;
        io.reactivex.disposables.b upstream;
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicInteger active = new AtomicInteger(1);
        final AtomicReference<io.reactivex.internal.queue.a<R>> queue = new AtomicReference<>();

        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.z<R>, io.reactivex.disposables.b {
            private static final long serialVersionUID = -502562646270949838L;

            InnerObserver() {
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
            public void onError(Throwable th) {
                FlatMapSingleObserver.this.innerError(this, th);
            }

            @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.z, io.reactivex.k
            public void onSuccess(R r) {
                FlatMapSingleObserver.this.innerSuccess(this, r);
            }
        }

        FlatMapSingleObserver(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.A<? extends R>> oVar, boolean z) {
            this.downstream = wVar;
            this.mapper = oVar;
            this.delayErrors = z;
        }

        void clear() {
            io.reactivex.internal.queue.a<R> aVar = this.queue.get();
            if (aVar != null) {
                aVar.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            io.reactivex.w<? super R> wVar = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<io.reactivex.internal.queue.a<R>> atomicReference = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (!this.delayErrors && this.errors.get() != null) {
                    Throwable thTerminate = this.errors.terminate();
                    clear();
                    wVar.onError(thTerminate);
                    return;
                }
                boolean z = atomicInteger.get() == 0;
                io.reactivex.internal.queue.a<R> aVar = atomicReference.get();
                h.b bVarPoll = aVar != null ? aVar.poll() : null;
                boolean z2 = bVarPoll == null;
                if (z && z2) {
                    Throwable thTerminate2 = this.errors.terminate();
                    if (thTerminate2 != null) {
                        wVar.onError(thTerminate2);
                        return;
                    } else {
                        wVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    wVar.onNext(bVarPoll);
                }
            }
            clear();
        }

        io.reactivex.internal.queue.a<R> getOrCreateQueue() {
            io.reactivex.internal.queue.a<R> aVar;
            do {
                io.reactivex.internal.queue.a<R> aVar2 = this.queue.get();
                if (aVar2 != null) {
                    return aVar2;
                }
                aVar = new io.reactivex.internal.queue.a<>(io.reactivex.p.bufferSize());
            } while (!this.queue.compareAndSet(null, aVar));
            return aVar;
        }

        void innerError(FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void innerSuccess(io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver<T, R>.InnerObserver r3, R r4) {
            /*
                r2 = this;
                io.reactivex.disposables.a r0 = r2.set
                r0.c(r3)
                int r3 = r2.get()
                if (r3 != 0) goto L4f
                r3 = 1
                r0 = 0
                boolean r1 = r2.compareAndSet(r0, r3)
                if (r1 == 0) goto L4f
                io.reactivex.w<? super R> r1 = r2.downstream
                r1.onNext(r4)
                java.util.concurrent.atomic.AtomicInteger r4 = r2.active
                int r4 = r4.decrementAndGet()
                if (r4 != 0) goto L21
                goto L22
            L21:
                r3 = 0
            L22:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.queue.a<R>> r4 = r2.queue
                java.lang.Object r4 = r4.get()
                io.reactivex.internal.queue.a r4 = (io.reactivex.internal.queue.a) r4
                if (r3 == 0) goto L48
                if (r4 == 0) goto L34
                boolean r3 = r4.isEmpty()
                if (r3 == 0) goto L48
            L34:
                io.reactivex.internal.util.AtomicThrowable r3 = r2.errors
                java.lang.Throwable r3 = r3.terminate()
                if (r3 == 0) goto L42
                io.reactivex.w<? super R> r4 = r2.downstream
                r4.onError(r3)
                goto L47
            L42:
                io.reactivex.w<? super R> r3 = r2.downstream
                r3.onComplete()
            L47:
                return
            L48:
                int r3 = r2.decrementAndGet()
                if (r3 != 0) goto L64
                return
            L4f:
                io.reactivex.internal.queue.a r3 = r2.getOrCreateQueue()
                monitor-enter(r3)
                r3.offer(r4)     // Catch: java.lang.Throwable -> L68
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
                java.util.concurrent.atomic.AtomicInteger r3 = r2.active
                r3.decrementAndGet()
                int r3 = r2.getAndIncrement()
                if (r3 == 0) goto L64
                return
            L64:
                r2.drainLoop()
                return
            L68:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L68
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver.innerSuccess(io.reactivex.internal.operators.observable.ObservableFlatMapSingle$FlatMapSingleObserver$InnerObserver, java.lang.Object):void");
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.active.decrementAndGet();
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            try {
                io.reactivex.A<? extends R> aApply = this.mapper.apply(t);
                io.reactivex.internal.functions.a.a(aApply, "The mapper returned a null SingleSource");
                io.reactivex.A<? extends R> a2 = aApply;
                this.active.getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (this.cancelled || !this.set.b(innerObserver)) {
                    return;
                }
                a2.a(innerObserver);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableFlatMapSingle(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.A<? extends R>> oVar, boolean z) {
        super(uVar);
        this.f22121b = oVar;
        this.f22122c = z;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super R> wVar) {
        this.f22358a.subscribe(new FlatMapSingleObserver(wVar, this.f22121b, this.f22122c));
    }
}
