package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObserverResourceWrapper<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -8612022020200669122L;
    final io.reactivex.w<? super T> downstream;
    final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

    public ObserverResourceWrapper(io.reactivex.w<? super T> wVar) {
        this.downstream = wVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this.upstream);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.upstream.get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.w
    public void onComplete() {
        dispose();
        this.downstream.onComplete();
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        dispose();
        this.downstream.onError(th);
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        this.downstream.onNext(t);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.setOnce(this.upstream, bVar)) {
            this.downstream.onSubscribe(this);
        }
    }

    public void setResource(io.reactivex.disposables.b bVar) {
        DisposableHelper.set(this, bVar);
    }
}
