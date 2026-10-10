package io.reactivex;

import io.reactivex.internal.operators.single.SingleToObservable;

/* JADX INFO: compiled from: Single.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class y<T> implements A<T> {
    public final <R> y<R> a(io.reactivex.b.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.single.a(this, oVar));
    }

    public final T b() {
        io.reactivex.internal.observers.f fVar = new io.reactivex.internal.observers.f();
        a(fVar);
        return (T) fVar.a();
    }

    protected abstract void b(z<? super T> zVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final p<T> c() {
        return this instanceof io.reactivex.c.a.b ? ((io.reactivex.c.a.b) this).a() : io.reactivex.e.a.a(new SingleToObservable(this));
    }

    @Override // io.reactivex.A
    public final void a(z<? super T> zVar) {
        io.reactivex.internal.functions.a.a(zVar, "observer is null");
        z<? super T> zVarA = io.reactivex.e.a.a(this, zVar);
        io.reactivex.internal.functions.a.a(zVarA, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(zVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
