package io.reactivex.internal.operators.observable;

import a.a.h;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableScalarXMap {

    public static final class ScalarDisposable<T> extends AtomicInteger implements io.reactivex.c.a.f<T>, Runnable {
        static final int FUSED = 1;
        static final int ON_COMPLETE = 3;
        static final int ON_NEXT = 2;
        static final int START = 0;
        private static final long serialVersionUID = 3880992722410194083L;
        final io.reactivex.w<? super T> observer;
        final T value;

        public ScalarDisposable(io.reactivex.w<? super T> wVar, T t) {
            this.observer = wVar;
            this.value = t;
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            lazySet(3);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            set(3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == 3;
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return get() != 1;
        }

        @Override // io.reactivex.c.a.k
        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            if (get() != 1) {
                return null;
            }
            lazySet(3);
            return this.value;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            lazySet(1);
            return 1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (get() == 0 && compareAndSet(0, 2)) {
                this.observer.onNext(this.value);
                if (get() == 2) {
                    lazySet(3);
                    this.observer.onComplete();
                }
            }
        }

        public boolean offer(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }
    }

    static final class a<T, R> extends io.reactivex.p<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T f22208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> f22209b;

        a(T t, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar) {
            this.f22208a = t;
            this.f22209b = oVar;
        }

        @Override // io.reactivex.p
        public void subscribeActual(io.reactivex.w<? super R> wVar) {
            try {
                io.reactivex.u<? extends R> uVarApply = this.f22209b.apply(this.f22208a);
                io.reactivex.internal.functions.a.a(uVarApply, "The mapper returned a null ObservableSource");
                io.reactivex.u<? extends R> uVar = uVarApply;
                if (!(uVar instanceof Callable)) {
                    uVar.subscribe(wVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) uVar).call();
                    if (objCall == null) {
                        EmptyDisposable.complete(wVar);
                        return;
                    }
                    ScalarDisposable scalarDisposable = new ScalarDisposable(wVar, objCall);
                    wVar.onSubscribe(scalarDisposable);
                    scalarDisposable.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    EmptyDisposable.error(th, wVar);
                }
            } catch (Throwable th2) {
                EmptyDisposable.error(th2, wVar);
            }
        }
    }

    public static <T, R> boolean a(io.reactivex.u<T> uVar, io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends R>> oVar) {
        if (!(uVar instanceof Callable)) {
            return false;
        }
        try {
            h.a aVar = (Object) ((Callable) uVar).call();
            if (aVar == null) {
                EmptyDisposable.complete(wVar);
                return true;
            }
            try {
                io.reactivex.u<? extends R> uVarApply = oVar.apply(aVar);
                io.reactivex.internal.functions.a.a(uVarApply, "The mapper returned a null ObservableSource");
                io.reactivex.u<? extends R> uVar2 = uVarApply;
                if (uVar2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) uVar2).call();
                        if (objCall == null) {
                            EmptyDisposable.complete(wVar);
                            return true;
                        }
                        ScalarDisposable scalarDisposable = new ScalarDisposable(wVar, objCall);
                        wVar.onSubscribe(scalarDisposable);
                        scalarDisposable.run();
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptyDisposable.error(th, wVar);
                        return true;
                    }
                } else {
                    uVar2.subscribe(wVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, wVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptyDisposable.error(th3, wVar);
            return true;
        }
    }

    public static <T, U> io.reactivex.p<U> a(T t, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> oVar) {
        return io.reactivex.e.a.a(new a(t, oVar));
    }
}
