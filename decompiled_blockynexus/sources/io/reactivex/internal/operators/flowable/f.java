package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;

/* JADX INFO: compiled from: FlowableEmpty.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f extends io.reactivex.e<Object> implements io.reactivex.c.a.i<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final io.reactivex.e<Object> f21919b = new f();

    private f() {
    }

    @Override // io.reactivex.e
    public void b(f.b.c<? super Object> cVar) {
        EmptySubscription.complete(cVar);
    }

    @Override // io.reactivex.c.a.i, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
