package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableUnsubscribeOn<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.x f22268b;

    static final class UnsubscribeObserver<T> extends AtomicBoolean implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1015244841293359600L;
        final io.reactivex.w<? super T> downstream;
        final io.reactivex.x scheduler;
        io.reactivex.disposables.b upstream;

        final class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                UnsubscribeObserver.this.upstream.dispose();
            }
        }

        UnsubscribeObserver(io.reactivex.w<? super T> wVar, io.reactivex.x xVar) {
            this.downstream = wVar;
            this.scheduler = xVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.scheduler.a(new a());
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (get()) {
                io.reactivex.e.a.b(th);
            } else {
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUnsubscribeOn(io.reactivex.u<T> uVar, io.reactivex.x xVar) {
        super(uVar);
        this.f22268b = xVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new UnsubscribeObserver(wVar, this.f22268b));
    }
}
