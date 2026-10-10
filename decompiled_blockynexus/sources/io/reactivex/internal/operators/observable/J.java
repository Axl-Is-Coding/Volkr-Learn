package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableFromCallable.java */
/* JADX INFO: loaded from: classes5.dex */
public final class J<T> extends io.reactivex.p<T> implements Callable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<? extends T> f22036a;

    public J(Callable<? extends T> callable) {
        this.f22036a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        T tCall = this.f22036a.call();
        io.reactivex.internal.functions.a.a((Object) tCall, "The callable returned a null value");
        return tCall;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(wVar);
        wVar.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            T tCall = this.f22036a.call();
            io.reactivex.internal.functions.a.a((Object) tCall, "Callable returned null");
            deferredScalarDisposable.complete(tCall);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (deferredScalarDisposable.isDisposed()) {
                io.reactivex.e.a.b(th);
            } else {
                wVar.onError(th);
            }
        }
    }
}
