package io.reactivex;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.mixed.MaybeFlatMapPublisher;

/* JADX INFO: compiled from: Maybe.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class i<T> implements m<T> {
    public static <T> i<T> a(l<T> lVar) {
        io.reactivex.internal.functions.a.a(lVar, "onSubscribe is null");
        return io.reactivex.e.a.a(new MaybeCreate(lVar));
    }

    public final T b() {
        io.reactivex.internal.observers.f fVar = new io.reactivex.internal.observers.f();
        a((k) fVar);
        return (T) fVar.a();
    }

    protected abstract void b(k<? super T> kVar);

    public final <R> i<R> c(io.reactivex.b.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.maybe.d(this, oVar));
    }

    public static <T> i<T> a(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "exception is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.maybe.b(th));
    }

    public final io.reactivex.disposables.b c() {
        return a(Functions.d(), Functions.f21807f, Functions.f21804c);
    }

    public final i<T> b(io.reactivex.b.g<? super T> gVar) {
        io.reactivex.b.g gVarD = Functions.d();
        io.reactivex.internal.functions.a.a(gVar, "onSuccess is null");
        io.reactivex.b.g gVarD2 = Functions.d();
        io.reactivex.b.a aVar = Functions.f21804c;
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.maybe.e(this, gVarD, gVar, gVarD2, aVar, aVar, aVar));
    }

    public final io.reactivex.disposables.b c(io.reactivex.b.g<? super T> gVar) {
        return a(gVar, Functions.f21807f, Functions.f21804c);
    }

    public static <T> i<T> a(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "item is null");
        return io.reactivex.e.a.a((i) new io.reactivex.internal.operators.maybe.c(t));
    }

    public final <E extends k<? super T>> E c(E e2) {
        a((k) e2);
        return e2;
    }

    public final i<T> a(io.reactivex.b.g<? super Throwable> gVar) {
        io.reactivex.b.g gVarD = Functions.d();
        io.reactivex.b.g gVarD2 = Functions.d();
        io.reactivex.internal.functions.a.a(gVar, "onError is null");
        io.reactivex.b.a aVar = Functions.f21804c;
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.maybe.e(this, gVarD, gVarD2, gVar, aVar, aVar, aVar));
    }

    public final <R> e<R> b(io.reactivex.b.o<? super T, ? extends f.b.b<? extends R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new MaybeFlatMapPublisher(this, oVar));
    }

    public final <R> i<R> a(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new MaybeFlatten(this, oVar));
    }

    public final io.reactivex.disposables.b a(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2) {
        return a(gVar, gVar2, Functions.f21804c);
    }

    public final io.reactivex.disposables.b a(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(gVar, "onSuccess is null");
        io.reactivex.internal.functions.a.a(gVar2, "onError is null");
        io.reactivex.internal.functions.a.a(aVar, "onComplete is null");
        MaybeCallbackObserver maybeCallbackObserver = new MaybeCallbackObserver(gVar, gVar2, aVar);
        c(maybeCallbackObserver);
        return maybeCallbackObserver;
    }

    @Override // io.reactivex.m
    public final void a(k<? super T> kVar) {
        io.reactivex.internal.functions.a.a(kVar, "observer is null");
        k<? super T> kVarA = io.reactivex.e.a.a(this, kVar);
        io.reactivex.internal.functions.a.a(kVarA, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(kVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final i<T> a(x xVar) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new MaybeSubscribeOn(this, xVar));
    }
}
