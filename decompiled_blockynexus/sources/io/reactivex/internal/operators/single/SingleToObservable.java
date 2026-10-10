package io.reactivex.internal.operators.single;

import io.reactivex.A;
import io.reactivex.disposables.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.p;
import io.reactivex.w;
import io.reactivex.z;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleToObservable<T> extends p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final A<? extends T> f22633a;

    static final class SingleToObservableObserver<T> extends DeferredScalarDisposable<T> implements z<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        b upstream;

        SingleToObservableObserver(w<? super T> wVar) {
            super(wVar);
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
        public void dispose() {
            super.dispose();
            this.upstream.dispose();
        }

        @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
        public void onError(Throwable th) {
            error(th);
        }

        @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.z, io.reactivex.k
        public void onSuccess(T t) {
            complete(t);
        }
    }

    public SingleToObservable(A<? extends T> a2) {
        this.f22633a = a2;
    }

    public static <T> z<T> a(w<? super T> wVar) {
        return new SingleToObservableObserver(wVar);
    }

    @Override // io.reactivex.p
    public void subscribeActual(w<? super T> wVar) {
        this.f22633a.a(a(wVar));
    }
}
