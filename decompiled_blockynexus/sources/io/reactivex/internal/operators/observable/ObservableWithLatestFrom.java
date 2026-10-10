package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWithLatestFrom<T, U, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.c<? super T, ? super U, ? extends R> f22285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.u<? extends U> f22286c;

    static final class WithLatestFromObserver<T, U, R> extends AtomicReference<U> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -312246233408980075L;
        final io.reactivex.b.c<? super T, ? super U, ? extends R> combiner;
        final io.reactivex.w<? super R> downstream;
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();
        final AtomicReference<io.reactivex.disposables.b> other = new AtomicReference<>();

        WithLatestFromObserver(io.reactivex.w<? super R> wVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar) {
            this.downstream = wVar;
            this.combiner = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            U u = get();
            if (u != null) {
                try {
                    R rApply = this.combiner.apply(t, u);
                    io.reactivex.internal.functions.a.a(rApply, "The combiner returned a null value");
                    this.downstream.onNext(rApply);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    dispose();
                    this.downstream.onError(th);
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        public void otherError(Throwable th) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th);
        }

        public boolean setOther(io.reactivex.disposables.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }
    }

    final class a implements io.reactivex.w<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WithLatestFromObserver<T, U, R> f22287a;

        a(WithLatestFromObserver<T, U, R> withLatestFromObserver) {
            this.f22287a = withLatestFromObserver;
        }

        @Override // io.reactivex.w
        public void onComplete() {
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22287a.otherError(th);
        }

        @Override // io.reactivex.w
        public void onNext(U u) {
            this.f22287a.lazySet(u);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22287a.setOther(bVar);
        }
    }

    public ObservableWithLatestFrom(io.reactivex.u<T> uVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, io.reactivex.u<? extends U> uVar2) {
        super(uVar);
        this.f22285b = cVar;
        this.f22286c = uVar2;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super R> wVar) {
        io.reactivex.observers.f fVar = new io.reactivex.observers.f(wVar);
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(fVar, this.f22285b);
        fVar.onSubscribe(withLatestFromObserver);
        this.f22286c.subscribe(new a(withLatestFromObserver));
        this.f22358a.subscribe(withLatestFromObserver);
    }
}
