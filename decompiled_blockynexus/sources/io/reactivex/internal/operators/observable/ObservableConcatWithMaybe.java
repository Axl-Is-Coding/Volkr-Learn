package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatWithMaybe<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.m<? extends T> f22097b;

    static final class ConcatWithObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.k<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -1953724749712440952L;
        final io.reactivex.w<? super T> downstream;
        boolean inMaybe;
        io.reactivex.m<? extends T> other;

        ConcatWithObserver(io.reactivex.w<? super T> wVar, io.reactivex.m<? extends T> mVar) {
            this.downstream = wVar;
            this.other = mVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            io.reactivex.m<? extends T> mVar = this.other;
            this.other = null;
            mVar.a(this);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (!DisposableHelper.setOnce(this, bVar) || this.inMaybe) {
                return;
            }
            this.downstream.onSubscribe(this);
        }

        @Override // io.reactivex.k
        public void onSuccess(T t) {
            this.downstream.onNext(t);
            this.downstream.onComplete();
        }
    }

    public ObservableConcatWithMaybe(io.reactivex.p<T> pVar, io.reactivex.m<? extends T> mVar) {
        super(pVar);
        this.f22097b = mVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new ConcatWithObserver(wVar, this.f22097b));
    }
}
