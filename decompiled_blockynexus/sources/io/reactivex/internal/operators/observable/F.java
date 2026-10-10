package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableError.java */
/* JADX INFO: loaded from: classes5.dex */
public final class F<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<? extends Throwable> f22023a;

    public F(Callable<? extends Throwable> callable) {
        this.f22023a = callable;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        try {
            Throwable thCall = this.f22023a.call();
            io.reactivex.internal.functions.a.a(thCall, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = thCall;
        } catch (Throwable th) {
            th = th;
            io.reactivex.exceptions.a.b(th);
        }
        EmptyDisposable.error(th, wVar);
    }
}
