package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableDefer.java */
/* JADX INFO: loaded from: classes5.dex */
public final class r<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<? extends io.reactivex.u<? extends T>> f22531a;

    public r(Callable<? extends io.reactivex.u<? extends T>> callable) {
        this.f22531a = callable;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        try {
            io.reactivex.u<? extends T> uVarCall = this.f22531a.call();
            io.reactivex.internal.functions.a.a(uVarCall, "null ObservableSource supplied");
            uVarCall.subscribe(wVar);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
        }
    }
}
