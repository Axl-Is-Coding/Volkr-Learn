package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableError.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g<T> extends io.reactivex.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends Throwable> f21920b;

    public g(Callable<? extends Throwable> callable) {
        this.f21920b = callable;
    }

    @Override // io.reactivex.e
    public void b(f.b.c<? super T> cVar) {
        try {
            Throwable thCall = this.f21920b.call();
            io.reactivex.internal.functions.a.a(thCall, "Callable returned null throwable. Null values are generally not allowed in 2.x operators and sources.");
            th = thCall;
        } catch (Throwable th) {
            th = th;
            io.reactivex.exceptions.a.b(th);
        }
        EmptySubscription.error(th, cVar);
    }
}
