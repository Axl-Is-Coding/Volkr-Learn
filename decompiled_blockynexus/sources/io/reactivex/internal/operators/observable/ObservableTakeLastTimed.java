package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeLastTimed<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f22243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.x f22244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f22245f;
    final boolean g;

    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final io.reactivex.w<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final io.reactivex.x scheduler;
        final long time;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;

        TakeLastTimedObserver(io.reactivex.w<? super T> wVar, long j, long j2, TimeUnit timeUnit, io.reactivex.x xVar, int i, boolean z) {
            this.downstream = wVar;
            this.count = j;
            this.time = j2;
            this.unit = timeUnit;
            this.scheduler = xVar;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.delayError = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                io.reactivex.w<? super T> wVar = this.downstream;
                io.reactivex.internal.queue.a<Object> aVar = this.queue;
                boolean z = this.delayError;
                while (!this.cancelled) {
                    if (!z && (th = this.error) != null) {
                        aVar.clear();
                        wVar.onError(th);
                        return;
                    }
                    Object objPoll = aVar.poll();
                    if (objPoll == null) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            wVar.onError(th2);
                            return;
                        } else {
                            wVar.onComplete();
                            return;
                        }
                    }
                    Object objPoll2 = aVar.poll();
                    if (((Long) objPoll).longValue() >= this.scheduler.a(this.unit) - this.time) {
                        wVar.onNext(objPoll2);
                    }
                }
                aVar.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.error = th;
            drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            long jA = this.scheduler.a(this.unit);
            long j = this.time;
            long j2 = this.count;
            boolean z = j2 == Long.MAX_VALUE;
            aVar.a(Long.valueOf(jA), t);
            while (!aVar.isEmpty()) {
                if (((Long) aVar.a()).longValue() > jA - j && (z || (aVar.b() >> 1) <= j2)) {
                    return;
                }
                aVar.poll();
                aVar.poll();
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

    public ObservableTakeLastTimed(io.reactivex.u<T> uVar, long j, long j2, TimeUnit timeUnit, io.reactivex.x xVar, int i, boolean z) {
        super(uVar);
        this.f22241b = j;
        this.f22242c = j2;
        this.f22243d = timeUnit;
        this.f22244e = xVar;
        this.f22245f = i;
        this.g = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new TakeLastTimedObserver(wVar, this.f22241b, this.f22242c, this.f22243d, this.f22244e, this.f22245f, this.g));
    }
}
