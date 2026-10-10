package io.reactivex.internal.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.w;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class LambdaObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements w<T>, io.reactivex.disposables.b, io.reactivex.observers.d {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.b.a onComplete;
    final io.reactivex.b.g<? super Throwable> onError;
    final io.reactivex.b.g<? super T> onNext;
    final io.reactivex.b.g<? super io.reactivex.disposables.b> onSubscribe;

    public LambdaObserver(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.g<? super io.reactivex.disposables.b> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        if (isDisposed()) {
            io.reactivex.e.a.b(th);
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.e.a.b(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
