package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;

/* JADX INFO: compiled from: DisposableLambdaObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g<T> implements w<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w<? super T> f21849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.g<? super io.reactivex.disposables.b> f21850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.a f21851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    io.reactivex.disposables.b f21852d;

    public g(w<? super T> wVar, io.reactivex.b.g<? super io.reactivex.disposables.b> gVar, io.reactivex.b.a aVar) {
        this.f21849a = wVar;
        this.f21850b = gVar;
        this.f21851c = aVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        io.reactivex.disposables.b bVar = this.f21852d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.f21852d = disposableHelper;
            try {
                this.f21851c.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(th);
            }
            bVar.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f21852d.isDisposed();
    }

    @Override // io.reactivex.w
    public void onComplete() {
        io.reactivex.disposables.b bVar = this.f21852d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper) {
            this.f21852d = disposableHelper;
            this.f21849a.onComplete();
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        io.reactivex.disposables.b bVar = this.f21852d;
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper) {
            io.reactivex.e.a.b(th);
        } else {
            this.f21852d = disposableHelper;
            this.f21849a.onError(th);
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        this.f21849a.onNext(t);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        try {
            this.f21850b.accept(bVar);
            if (DisposableHelper.validate(this.f21852d, bVar)) {
                this.f21852d = bVar;
                this.f21849a.onSubscribe(this);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            bVar.dispose();
            this.f21852d = DisposableHelper.DISPOSED;
            EmptyDisposable.error(th, this.f21849a);
        }
    }
}
