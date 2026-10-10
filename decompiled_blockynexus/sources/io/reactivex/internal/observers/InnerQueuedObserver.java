package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements w<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final i<T> parent;
    final int prefetch;
    io.reactivex.c.a.k<T> queue;

    public InnerQueuedObserver(i<T> iVar, int i) {
        this.parent = iVar;
        this.prefetch = i;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public int fusionMode() {
        return this.fusionMode;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        this.parent.innerError(this, th);
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (this.fusionMode == 0) {
            this.parent.innerNext(this, t);
        } else {
            this.parent.drain();
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof io.reactivex.c.a.f) {
                io.reactivex.c.a.f fVar = (io.reactivex.c.a.f) bVar;
                int iRequestFusion = fVar.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = fVar;
                    this.done = true;
                    this.parent.innerComplete(this);
                    return;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = fVar;
                    return;
                }
            }
            this.queue = io.reactivex.internal.util.k.a(-this.prefetch);
        }
    }

    public io.reactivex.c.a.k<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}
