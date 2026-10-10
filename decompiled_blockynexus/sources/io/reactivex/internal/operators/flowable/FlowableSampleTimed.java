package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSampleTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f21894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f21895d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final x f21896e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f21897f;

    static final class SampleTimedEmitLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        SampleTimedEmitLast(f.b.c<? super T> cVar, long j, TimeUnit timeUnit, x xVar) {
            super(cVar, j, timeUnit, xVar);
            this.wip = new AtomicInteger(1);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }

    static final class SampleTimedNoLast<T> extends SampleTimedSubscriber<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        SampleTimedNoLast(f.b.c<? super T> cVar, long j, TimeUnit timeUnit, x xVar) {
            super(cVar, j, timeUnit, xVar);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSampleTimed.SampleTimedSubscriber
        void complete() {
            this.downstream.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            emit();
        }
    }

    static abstract class SampleTimedSubscriber<T> extends AtomicReference<T> implements io.reactivex.h<T>, f.b.d, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final f.b.c<? super T> downstream;
        final long period;
        final x scheduler;
        final TimeUnit unit;
        f.b.d upstream;
        final AtomicLong requested = new AtomicLong();
        final SequentialDisposable timer = new SequentialDisposable();

        SampleTimedSubscriber(f.b.c<? super T> cVar, long j, TimeUnit timeUnit, x xVar) {
            this.downstream = cVar;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = xVar;
        }

        @Override // f.b.d
        public void cancel() {
            cancelTimer();
            this.upstream.cancel();
        }

        void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        abstract void complete();

        void emit() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                if (this.requested.get() != 0) {
                    this.downstream.onNext(andSet);
                    io.reactivex.internal.util.b.c(this.requested, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Couldn't emit value due to lack of requests!"));
                }
            }
        }

        @Override // f.b.c
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            cancelTimer();
            this.downstream.onError(th);
        }

        @Override // f.b.c
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            if (SubscriptionHelper.validate(this.upstream, dVar)) {
                this.upstream = dVar;
                this.downstream.onSubscribe(this);
                SequentialDisposable sequentialDisposable = this.timer;
                x xVar = this.scheduler;
                long j = this.period;
                sequentialDisposable.replace(xVar.a(this, j, j, this.unit));
                dVar.request(Long.MAX_VALUE);
            }
        }

        @Override // f.b.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
            }
        }
    }

    public FlowableSampleTimed(io.reactivex.e<T> eVar, long j, TimeUnit timeUnit, x xVar, boolean z) {
        super(eVar);
        this.f21894c = j;
        this.f21895d = timeUnit;
        this.f21896e = xVar;
        this.f21897f = z;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        io.reactivex.g.a aVar = new io.reactivex.g.a(cVar);
        if (this.f21897f) {
            this.f21902b.a((io.reactivex.h) new SampleTimedEmitLast(aVar, this.f21894c, this.f21895d, this.f21896e));
        } else {
            this.f21902b.a((io.reactivex.h) new SampleTimedNoLast(aVar, this.f21894c, this.f21895d, this.f21896e));
        }
    }
}
