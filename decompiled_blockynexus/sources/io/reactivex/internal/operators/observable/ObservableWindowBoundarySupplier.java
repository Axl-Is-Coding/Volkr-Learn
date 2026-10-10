package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindowBoundarySupplier<T, B> extends AbstractC2904a<T, io.reactivex.p<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends io.reactivex.u<B>> f22281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f22282c;

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        static final a<Object, Object> BOUNDARY_DISPOSED = new a<>(null);
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final io.reactivex.w<? super io.reactivex.p<T>> downstream;
        final Callable<? extends io.reactivex.u<B>> other;
        io.reactivex.disposables.b upstream;
        UnicastSubject<T> window;
        final AtomicReference<a<T, B>> boundaryObserver = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();

        WindowBoundaryMainObserver(io.reactivex.w<? super io.reactivex.p<T>> wVar, int i, Callable<? extends io.reactivex.u<B>> callable) {
            this.downstream = wVar;
            this.capacityHint = i;
            this.other = callable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                disposeBoundary();
                if (this.windows.decrementAndGet() == 0) {
                    this.upstream.dispose();
                }
            }
        }

        void disposeBoundary() {
            a<T, B> andSet = this.boundaryObserver.getAndSet((a<T, B>) BOUNDARY_DISPOSED);
            if (andSet == null || andSet == BOUNDARY_DISPOSED) {
                return;
            }
            andSet.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.w<? super io.reactivex.p<T>> wVar = this.downstream;
            MpscLinkedQueue<Object> mpscLinkedQueue = this.queue;
            AtomicThrowable atomicThrowable = this.errors;
            int iAddAndGet = 1;
            while (this.windows.get() != 0) {
                UnicastSubject<T> unicastSubject = this.window;
                boolean z = this.done;
                if (z && atomicThrowable.get() != null) {
                    mpscLinkedQueue.clear();
                    Throwable thTerminate = atomicThrowable.terminate();
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onError(thTerminate);
                    }
                    wVar.onError(thTerminate);
                    return;
                }
                Object objPoll = mpscLinkedQueue.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    Throwable thTerminate2 = atomicThrowable.terminate();
                    if (thTerminate2 == null) {
                        if (unicastSubject != null) {
                            this.window = null;
                            unicastSubject.onComplete();
                        }
                        wVar.onComplete();
                        return;
                    }
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onError(thTerminate2);
                    }
                    wVar.onError(thTerminate2);
                    return;
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else if (objPoll != NEXT_WINDOW) {
                    unicastSubject.onNext((T) objPoll);
                } else {
                    if (unicastSubject != null) {
                        this.window = null;
                        unicastSubject.onComplete();
                    }
                    if (!this.stopWindows.get()) {
                        UnicastSubject<T> unicastSubjectA = UnicastSubject.a(this.capacityHint, this);
                        this.window = unicastSubjectA;
                        this.windows.getAndIncrement();
                        try {
                            io.reactivex.u<B> uVarCall = this.other.call();
                            io.reactivex.internal.functions.a.a(uVarCall, "The other Callable returned a null ObservableSource");
                            io.reactivex.u<B> uVar = uVarCall;
                            a<T, B> aVar = new a<>(this);
                            if (this.boundaryObserver.compareAndSet(null, aVar)) {
                                uVar.subscribe(aVar);
                                wVar.onNext(unicastSubjectA);
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.b(th);
                            atomicThrowable.addThrowable(th);
                            this.done = true;
                        }
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        void innerComplete() {
            this.upstream.dispose();
            this.done = true;
            drain();
        }

        void innerError(Throwable th) {
            this.upstream.dispose();
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        void innerNext(a<T, B> aVar) {
            this.boundaryObserver.compareAndSet(aVar, null);
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            disposeBoundary();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            disposeBoundary();
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
                this.queue.offer(NEXT_WINDOW);
                drain();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                this.upstream.dispose();
            }
        }
    }

    static final class a<T, B> extends io.reactivex.observers.c<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f22283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22284c;

        a(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f22283b = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22284c) {
                return;
            }
            this.f22284c = true;
            this.f22283b.innerComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22284c) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22284c = true;
                this.f22283b.innerError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(B b2) {
            if (this.f22284c) {
                return;
            }
            this.f22284c = true;
            dispose();
            this.f22283b.innerNext(this);
        }
    }

    public ObservableWindowBoundarySupplier(io.reactivex.u<T> uVar, Callable<? extends io.reactivex.u<B>> callable, int i) {
        super(uVar);
        this.f22281b = callable;
        this.f22282c = i;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.p<T>> wVar) {
        this.f22358a.subscribe(new WindowBoundaryMainObserver(wVar, this.f22282c, this.f22281b));
    }
}
