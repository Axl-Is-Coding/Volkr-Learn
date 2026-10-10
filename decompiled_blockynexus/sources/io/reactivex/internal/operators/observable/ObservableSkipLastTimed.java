package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSkipLastTimed<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.x f22231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f22232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f22233f;

    static final class SkipLastTimedObserver<T> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final io.reactivex.w<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final io.reactivex.x scheduler;
        final long time;
        final TimeUnit unit;
        io.reactivex.disposables.b upstream;

        SkipLastTimedObserver(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, int i, boolean z) {
            this.downstream = wVar;
            this.time = j;
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
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.w<? super T> wVar = this.downstream;
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            boolean z = this.delayError;
            TimeUnit timeUnit = this.unit;
            io.reactivex.x xVar = this.scheduler;
            long j = this.time;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z2 = this.done;
                Long l = (Long) aVar.a();
                boolean z3 = l == null;
                long jA = xVar.a(timeUnit);
                if (!z3 && l.longValue() > jA - j) {
                    z3 = true;
                }
                if (z2) {
                    if (!z) {
                        Throwable th = this.error;
                        if (th != null) {
                            this.queue.clear();
                            wVar.onError(th);
                            return;
                        } else if (z3) {
                            wVar.onComplete();
                            return;
                        }
                    } else if (z3) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            wVar.onError(th2);
                            return;
                        } else {
                            wVar.onComplete();
                            return;
                        }
                    }
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    aVar.poll();
                    wVar.onNext(aVar.poll());
                }
            }
            this.queue.clear();
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
            this.queue.a(Long.valueOf(this.scheduler.a(this.unit)), t);
            drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkipLastTimed(io.reactivex.u<T> uVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, int i, boolean z) {
        super(uVar);
        this.f22229b = j;
        this.f22230c = timeUnit;
        this.f22231d = xVar;
        this.f22232e = i;
        this.f22233f = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new SkipLastTimedObserver(wVar, this.f22229b, this.f22230c, this.f22231d, this.f22232e, this.f22233f));
    }
}
