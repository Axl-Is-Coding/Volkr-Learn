package io.reactivex.internal.operators.maybe;

import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.k;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements k<T>, io.reactivex.disposables.b, io.reactivex.observers.d {
    private static final long serialVersionUID = -6076952298809384986L;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public MaybeCallbackObserver(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.b.a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f21807f;
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.k
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
        }
    }

    @Override // io.reactivex.k
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.e.a.b(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.k
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.k
    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
        }
    }
}
