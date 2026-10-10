package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableUsing<T, D> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<? extends D> f22270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super D, ? extends io.reactivex.u<? extends T>> f22271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.g<? super D> f22272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f22273d;

    static final class UsingObserver<T, D> extends AtomicBoolean implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 5904473792286235046L;
        final io.reactivex.b.g<? super D> disposer;
        final io.reactivex.w<? super T> downstream;
        final boolean eager;
        final D resource;
        io.reactivex.disposables.b upstream;

        UsingObserver(io.reactivex.w<? super T> wVar, D d2, io.reactivex.b.g<? super D> gVar, boolean z) {
            this.downstream = wVar;
            this.resource = d2;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            disposeAfter();
            this.upstream.dispose();
        }

        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (!this.eager) {
                this.downstream.onComplete();
                this.upstream.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.downstream.onError(th);
                    return;
                }
            }
            this.upstream.dispose();
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!this.eager) {
                this.downstream.onError(th);
                this.upstream.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    th = new CompositeException(th, th2);
                }
            }
            this.upstream.dispose();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableUsing(Callable<? extends D> callable, io.reactivex.b.o<? super D, ? extends io.reactivex.u<? extends T>> oVar, io.reactivex.b.g<? super D> gVar, boolean z) {
        this.f22270a = callable;
        this.f22271b = oVar;
        this.f22272c = gVar;
        this.f22273d = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        try {
            D dCall = this.f22270a.call();
            try {
                io.reactivex.u<? extends T> uVarApply = this.f22271b.apply(dCall);
                io.reactivex.internal.functions.a.a(uVarApply, "The sourceSupplier returned a null ObservableSource");
                uVarApply.subscribe(new UsingObserver(wVar, dCall, this.f22272c, this.f22273d));
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                try {
                    this.f22272c.accept(dCall);
                    EmptyDisposable.error(th, wVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    EmptyDisposable.error(new CompositeException(th, th2), wVar);
                }
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptyDisposable.error(th3, wVar);
        }
    }
}
