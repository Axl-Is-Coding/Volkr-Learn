package io.reactivex.internal.observers;

import io.reactivex.b.q;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements w<T>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final io.reactivex.b.a onComplete;
    final io.reactivex.b.g<? super Throwable> onError;
    final q<? super T> onNext;

    public ForEachWhileObserver(q<? super T> qVar, io.reactivex.b.g<? super Throwable> gVar, io.reactivex.b.a aVar) {
        this.onNext = qVar;
        this.onError = gVar;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        if (this.done) {
            io.reactivex.e.a.b(th);
            return;
        }
        this.done = true;
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.e.a.b(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            if (this.onNext.test(t)) {
                return;
            }
            dispose();
            onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
