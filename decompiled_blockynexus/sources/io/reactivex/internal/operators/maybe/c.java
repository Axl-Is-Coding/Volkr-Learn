package io.reactivex.internal.operators.maybe;

import io.reactivex.i;
import io.reactivex.k;

/* JADX INFO: compiled from: MaybeJust.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c<T> extends i<T> implements io.reactivex.c.a.i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final T f21943a;

    public c(T t) {
        this.f21943a = t;
    }

    @Override // io.reactivex.i
    protected void b(k<? super T> kVar) {
        kVar.onSubscribe(io.reactivex.disposables.c.a());
        kVar.onSuccess(this.f21943a);
    }

    @Override // io.reactivex.c.a.i, java.util.concurrent.Callable
    public T call() {
        return this.f21943a;
    }
}
