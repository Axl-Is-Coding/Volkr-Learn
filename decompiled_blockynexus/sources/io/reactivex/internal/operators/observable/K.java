package io.reactivex.internal.operators.observable;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ObservableFromFuture.java */
/* JADX INFO: loaded from: classes5.dex */
public final class K<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Future<? extends T> f22037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22039c;

    public K(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f22037a = future;
        this.f22038b = j;
        this.f22039c = timeUnit;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(wVar);
        wVar.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            T t = this.f22039c != null ? this.f22037a.get(this.f22038b, this.f22039c) : this.f22037a.get();
            io.reactivex.internal.functions.a.a((Object) t, "Future returned null");
            deferredScalarDisposable.complete(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            wVar.onError(th);
        }
    }
}
