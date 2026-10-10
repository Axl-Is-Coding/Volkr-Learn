package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTakeUntil<T, U> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<? extends U> f22246b;

    static final class TakeUntilMainObserver<T, U> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1418547743690811973L;
        final io.reactivex.w<? super T> downstream;
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        final TakeUntilMainObserver<T, U>.OtherObserver otherObserver = new OtherObserver();
        final AtomicThrowable error = new AtomicThrowable();

        final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            OtherObserver() {
            }

            @Override // io.reactivex.w
            public void onComplete() {
                TakeUntilMainObserver.this.otherComplete();
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
                TakeUntilMainObserver.this.otherError(th);
            }

            @Override // io.reactivex.w
            public void onNext(U u) {
                DisposableHelper.dispose(this);
                TakeUntilMainObserver.this.otherComplete();
            }

            @Override // io.reactivex.w
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        TakeUntilMainObserver(io.reactivex.w<? super T> wVar) {
            this.downstream = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.a((io.reactivex.w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            io.reactivex.internal.util.g.a(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        void otherComplete() {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        void otherError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            io.reactivex.internal.util.g.a((io.reactivex.w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }
    }

    public ObservableTakeUntil(io.reactivex.u<T> uVar, io.reactivex.u<? extends U> uVar2) {
        super(uVar);
        this.f22246b = uVar2;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        TakeUntilMainObserver takeUntilMainObserver = new TakeUntilMainObserver(wVar);
        wVar.onSubscribe(takeUntilMainObserver);
        this.f22246b.subscribe(takeUntilMainObserver.otherObserver);
        this.f22358a.subscribe(takeUntilMainObserver);
    }
}
