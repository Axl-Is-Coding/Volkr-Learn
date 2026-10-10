package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.subscriptions.Subscriptions;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleFromFuture<T> implements Single.OnSubscribe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public SingleFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    @Override // rx.functions.Action1
    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Future<? extends T> future = this.future;
        singleSubscriber.add(Subscriptions.from(future));
        try {
            singleSubscriber.onSuccess(this.timeout == 0 ? future.get() : future.get(this.timeout, this.unit));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            singleSubscriber.onError(th);
        }
    }
}
