package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableThrottleFirstTimed<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.x f22249d;

    static final class DebounceTimedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final io.reactivex.w<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;
        final x.c worker;

        DebounceTimedObserver(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
            this.worker.dispose();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.gate || this.done) {
                return;
            }
            this.gate = true;
            this.downstream.onNext(t);
            io.reactivex.disposables.b bVar = get();
            if (bVar != null) {
                bVar.dispose();
            }
            DisposableHelper.replace(this, this.worker.a(this, this.timeout, this.unit));
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
            this.gate = false;
        }
    }

    public ObservableThrottleFirstTimed(io.reactivex.u<T> uVar, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
        super(uVar);
        this.f22247b = j;
        this.f22248c = timeUnit;
        this.f22249d = xVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new DebounceTimedObserver(new io.reactivex.observers.f(wVar), this.f22247b, this.f22248c, this.f22249d.a()));
    }
}
