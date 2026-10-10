package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableScalarXMap;

/* JADX INFO: compiled from: ObservableJust.java */
/* JADX INFO: loaded from: classes5.dex */
public final class U<T> extends io.reactivex.p<T> implements io.reactivex.c.a.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f22336a;

    public U(T t) {
        this.f22336a = t;
    }

    @Override // io.reactivex.c.a.i, java.util.concurrent.Callable
    public T call() {
        return this.f22336a;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        ObservableScalarXMap.ScalarDisposable scalarDisposable = new ObservableScalarXMap.ScalarDisposable(wVar, this.f22336a);
        wVar.onSubscribe(scalarDisposable);
        scalarDisposable.run();
    }
}
