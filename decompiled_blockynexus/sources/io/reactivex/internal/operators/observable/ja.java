package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableScanSeed.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ja<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.c<R, ? super T, R> f22441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<R> f22442c;

    /* JADX INFO: compiled from: ObservableScanSeed.java */
    static final class a<T, R> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super R> f22443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.c<R, ? super T, R> f22444b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        R f22445c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f22446d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22447e;

        a(io.reactivex.w<? super R> wVar, io.reactivex.b.c<R, ? super T, R> cVar, R r) {
            this.f22443a = wVar;
            this.f22444b = cVar;
            this.f22445c = r;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22446d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22446d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22447e) {
                return;
            }
            this.f22447e = true;
            this.f22443a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22447e) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22447e = true;
                this.f22443a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22447e) {
                return;
            }
            try {
                R rApply = this.f22444b.apply(this.f22445c, t);
                io.reactivex.internal.functions.a.a(rApply, "The accumulator returned a null value");
                this.f22445c = rApply;
                this.f22443a.onNext(rApply);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22446d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22446d, bVar)) {
                this.f22446d = bVar;
                this.f22443a.onSubscribe(this);
                this.f22443a.onNext(this.f22445c);
            }
        }
    }

    public ja(io.reactivex.u<T> uVar, Callable<R> callable, io.reactivex.b.c<R, ? super T, R> cVar) {
        super(uVar);
        this.f22441b = cVar;
        this.f22442c = callable;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super R> wVar) {
        try {
            R rCall = this.f22442c.call();
            io.reactivex.internal.functions.a.a(rCall, "The seed supplied is null");
            this.f22358a.subscribe(new a(wVar, this.f22441b, rCall));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
        }
    }
}
