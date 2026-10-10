package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.observable.ga;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableReduceWithSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ha<T, R> extends io.reactivex.y<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<R> f22429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.c<R, ? super T, R> f22430c;

    public ha(io.reactivex.u<T> uVar, Callable<R> callable, io.reactivex.b.c<R, ? super T, R> cVar) {
        this.f22428a = uVar;
        this.f22429b = callable;
        this.f22430c = cVar;
    }

    @Override // io.reactivex.y
    protected void b(io.reactivex.z<? super R> zVar) {
        try {
            R rCall = this.f22429b.call();
            io.reactivex.internal.functions.a.a(rCall, "The seedSupplier returned a null value");
            this.f22428a.subscribe(new ga.a(zVar, this.f22430c, rCall));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, zVar);
        }
    }
}
