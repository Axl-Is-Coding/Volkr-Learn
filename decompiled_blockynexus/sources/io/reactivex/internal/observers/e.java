package io.reactivex.internal.observers;

/* JADX INFO: compiled from: BlockingLastObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends c<T> {
    @Override // io.reactivex.w
    public void onError(Throwable th) {
        this.f21841a = null;
        this.f21842b = th;
        countDown();
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        this.f21841a = t;
    }
}
