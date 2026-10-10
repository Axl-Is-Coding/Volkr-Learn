package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.ScalarSubscription;

/* JADX INFO: compiled from: FlowableJust.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i<T> extends io.reactivex.e<T> implements io.reactivex.c.a.i<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f21924b;

    public i(T t) {
        this.f21924b = t;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        cVar.onSubscribe(new ScalarSubscription(cVar, this.f21924b));
    }

    @Override // io.reactivex.c.a.i, java.util.concurrent.Callable
    public T call() {
        return this.f21924b;
    }
}
