package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements io.reactivex.c.a.f<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // io.reactivex.c.a.k
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
