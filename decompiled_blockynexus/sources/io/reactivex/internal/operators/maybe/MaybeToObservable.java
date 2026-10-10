package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.w;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeToObservable<T> extends p<T> implements io.reactivex.c.a.c<T> {

    static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements k<T> {
        private static final long serialVersionUID = 7603343402964826922L;
        io.reactivex.disposables.b upstream;

        MaybeToObservableObserver(w<? super T> wVar) {
            super(wVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.k
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.k
        public void onError(Throwable th) {
            error(th);
        }

        @Override // io.reactivex.k
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.k
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public static <T> k<T> a(w<? super T> wVar) {
        return new MaybeToObservableObserver(wVar);
    }
}
