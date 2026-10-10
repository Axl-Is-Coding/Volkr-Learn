package io.reactivex.internal.subscriptions;

import f.b.c;
import io.reactivex.c.a.h;

/* JADX INFO: loaded from: classes5.dex */
public enum EmptySubscription implements h<Object> {
    INSTANCE;

    public static void complete(c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th, c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th);
    }

    @Override // f.b.d
    public void cancel() {
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.c.a.k
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.c.a.k
    public Object poll() {
        return null;
    }

    @Override // f.b.d
    public void request(long j) {
        SubscriptionHelper.validate(j);
    }

    @Override // io.reactivex.c.a.g
    public int requestFusion(int i) {
        return i & 2;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
