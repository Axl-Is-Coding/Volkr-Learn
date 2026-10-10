package io.reactivex.internal.subscriptions;

import io.reactivex.c.a.h;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements h<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // io.reactivex.c.a.k
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
