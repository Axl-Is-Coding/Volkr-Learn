package io.reactivex.internal.observers;

/* JADX INFO: compiled from: BlockingFirstObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class d<T> extends c<T> {
    @Override // io.reactivex.w
    public void onError(Throwable th) {
        if (this.f21841a == null) {
            this.f21842b = th;
        }
        countDown();
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (this.f21841a == null) {
            this.f21841a = t;
            this.f21843c.dispose();
            countDown();
        }
    }
}
