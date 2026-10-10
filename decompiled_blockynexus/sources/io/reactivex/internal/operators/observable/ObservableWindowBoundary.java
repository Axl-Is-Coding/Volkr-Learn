package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.subjects.UnicastSubject;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindowBoundary<T, B> extends AbstractC2904a<T, io.reactivex.p<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<B> f22277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f22278c;

    static final class WindowBoundaryMainObserver<T, B> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final int capacityHint;
        volatile boolean done;
        final io.reactivex.w<? super io.reactivex.p<T>> downstream;
        UnicastSubject<T> window;
        final a<T, B> boundaryObserver = new a<>(this);
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        final AtomicInteger windows = new AtomicInteger(1);
        final MpscLinkedQueue<Object> queue = new MpscLinkedQueue<>();
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicBoolean stopWindows = new AtomicBoolean();

        WindowBoundaryMainObserver(io.reactivex.w<? super io.reactivex.p<T>> wVar, int i) {
            this.downstream = wVar;
            this.capacityHint = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    DisposableHelper.dispose(this.upstream);
                }
            }
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
                        wVar.onNext(unicastSubjectA);
                    }
                }
            }
            mpscLinkedQueue.clear();
            this.window = null;
        }

        void innerComplete() {
            DisposableHelper.dispose(this.upstream);
            this.done = true;
            drain();
        }

        void innerError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            if (!this.errors.addThrowable(th)) {
                io.reactivex.e.a.b(th);
            } else {
                this.done = true;
                drain();
            }
        }

        void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.stopWindows.get();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.boundaryObserver.dispose();
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
            if (DisposableHelper.setOnce(this.upstream, bVar)) {
                innerNext();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.windows.decrementAndGet() == 0) {
                DisposableHelper.dispose(this.upstream);
            }
        }
    }

    static final class a<T, B> extends io.reactivex.observers.c<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowBoundaryMainObserver<T, B> f22279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22280c;

        a(WindowBoundaryMainObserver<T, B> windowBoundaryMainObserver) {
            this.f22279b = windowBoundaryMainObserver;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22280c) {
                return;
            }
            this.f22280c = true;
            this.f22279b.innerComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22280c) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22280c = true;
                this.f22279b.innerError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(B b2) {
            if (this.f22280c) {
                return;
            }
            this.f22279b.innerNext();
        }
    }

    public ObservableWindowBoundary(io.reactivex.u<T> uVar, io.reactivex.u<B> uVar2, int i) {
        super(uVar);
        this.f22277b = uVar2;
        this.f22278c = i;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.p<T>> wVar) {
        WindowBoundaryMainObserver windowBoundaryMainObserver = new WindowBoundaryMainObserver(wVar, this.f22278c);
        wVar.onSubscribe(windowBoundaryMainObserver);
        this.f22277b.subscribe(windowBoundaryMainObserver.boundaryObserver);
        this.f22358a.subscribe(windowBoundaryMainObserver);
    }
}
