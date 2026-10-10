package io.reactivex.internal.subscriptions;

import f.b.c;
import io.reactivex.c.a.h;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements h<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final c<? super T> subscriber;
    final T value;

    public ScalarSubscription(c<? super T> cVar, T t) {
        this.subscriber = cVar;
        this.value = t;
    }

    @Override // f.b.d
    public void cancel() {
        lazySet(2);
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // io.reactivex.c.a.k
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.c.a.k
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // f.b.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            c<? super T> cVar = this.subscriber;
            cVar.onNext(this.value);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    @Override // io.reactivex.c.a.g
    public int requestFusion(int i) {
        return i & 1;
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
