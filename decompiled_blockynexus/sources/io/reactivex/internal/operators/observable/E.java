package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: compiled from: ObservableEmpty.java */
/* JADX INFO: loaded from: classes5.dex */
public final class E extends io.reactivex.p<Object> implements io.reactivex.c.a.i<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final io.reactivex.p<Object> f22022a = new E();

    private E() {
    }

    @Override // io.reactivex.c.a.i, java.util.concurrent.Callable
    public Object call() {
        return null;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super Object> wVar) {
        EmptyDisposable.complete(wVar);
    }
}
