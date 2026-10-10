package io.reactivex.internal.disposables;

import io.reactivex.c.a.f;
import io.reactivex.k;
import io.reactivex.w;
import io.reactivex.z;

/* JADX INFO: loaded from: classes5.dex */
public enum EmptyDisposable implements f<Object> {
    INSTANCE,
    NEVER;

    public static void complete(w<?> wVar) {
        wVar.onSubscribe(INSTANCE);
        wVar.onComplete();
    }

    public static void error(Throwable th, w<?> wVar) {
        wVar.onSubscribe(INSTANCE);
        wVar.onError(th);
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this == INSTANCE;
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
    public Object poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.c.a.g
    public int requestFusion(int i) {
        return i & 2;
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(k<?> kVar) {
        kVar.onSubscribe(INSTANCE);
        kVar.onComplete();
    }

    public static void error(Throwable th, io.reactivex.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th);
    }

    public static void complete(io.reactivex.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void error(Throwable th, z<?> zVar) {
        zVar.onSubscribe(INSTANCE);
        zVar.onError(th);
    }

    public static void error(Throwable th, k<?> kVar) {
        kVar.onSubscribe(INSTANCE);
        kVar.onError(th);
    }
}
