package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableThrottleLatest<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.x f22252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f22253e;

    static final class ThrottleLatestObserver<T> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final io.reactivex.w<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;
        final x.c worker;

        ThrottleLatestObserver(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar, boolean z) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.emitLast = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet(null);
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.latest;
            io.reactivex.w<? super T> wVar = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                if (z && this.error != null) {
                    atomicReference.lazySet(null);
                    wVar.onError(this.error);
                    this.worker.dispose();
                    return;
                }
                boolean z2 = atomicReference.get() == null;
                if (z) {
                    T andSet = atomicReference.getAndSet(null);
                    if (!z2 && this.emitLast) {
                        wVar.onNext(andSet);
                    }
                    wVar.onComplete();
                    this.worker.dispose();
                    return;
                }
                if (z2) {
                    if (this.timerFired) {
                        this.timerRunning = false;
                        this.timerFired = false;
                    }
                } else if (!this.timerRunning || this.timerFired) {
                    wVar.onNext(atomicReference.getAndSet(null));
                    this.timerFired = false;
                    this.timerRunning = true;
                    this.worker.a(this, this.timeout, this.unit);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.latest.set(t);
            drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.timerFired = true;
            drain();
        }
    }

    public ObservableThrottleLatest(io.reactivex.p<T> pVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, boolean z) {
        super(pVar);
        this.f22250b = j;
        this.f22251c = timeUnit;
        this.f22252d = xVar;
        this.f22253e = z;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new ThrottleLatestObserver(wVar, this.f22250b, this.f22251c, this.f22252d.a(), this.f22253e));
    }
}
