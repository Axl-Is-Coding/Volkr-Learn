package io.reactivex;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Flowable.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e<T> implements f.b.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f21773a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static int a() {
        return f21773a;
    }

    public static <T> e<T> b() {
        return io.reactivex.e.a.a(io.reactivex.internal.operators.flowable.f.f21919b);
    }

    public static <T> e<T> c(Iterable<? extends f.b.b<? extends T>> iterable) {
        return b(iterable).a(Functions.e(), true);
    }

    protected abstract void b(f.b.c<? super T> cVar);

    public final e<T> d() {
        return a(a(), false, true);
    }

    public final e<T> e() {
        return io.reactivex.e.a.a((e) new FlowableOnBackpressureDrop(this));
    }

    public final e<T> f() {
        return io.reactivex.e.a.a(new FlowableOnBackpressureLatest(this));
    }

    public final io.reactivex.a.a<T> g() {
        return a(a());
    }

    public static <T> e<T> a(Iterable<? extends f.b.b<? extends T>> iterable) {
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        return b(iterable).a(Functions.e());
    }

    public static <T> e<T> b(Iterable<? extends T> iterable) {
        io.reactivex.internal.functions.a.a(iterable, "source is null");
        return io.reactivex.e.a.a(new FlowableFromIterable(iterable));
    }

    public final e<T> c(io.reactivex.b.a aVar) {
        return a(Functions.d(), Functions.d(), aVar, Functions.f21804c);
    }

    public final io.reactivex.disposables.b d(io.reactivex.b.g<? super T> gVar) {
        return a(gVar, Functions.f21807f, Functions.f21804c, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final e<T> c(io.reactivex.b.g<? super f.b.d> gVar) {
        return a(gVar, Functions.g, Functions.f21804c);
    }

    public static <T> e<T> a(g<T> gVar, BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.functions.a.a(gVar, "source is null");
        io.reactivex.internal.functions.a.a(backpressureStrategy, "mode is null");
        return io.reactivex.e.a.a(new FlowableCreate(gVar, backpressureStrategy));
    }

    public final e<T> b(io.reactivex.b.a aVar) {
        return a(Functions.d(), Functions.g, aVar);
    }

    public final i<T> c() {
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.j(this));
    }

    public final e<T> b(io.reactivex.b.g<? super T> gVar) {
        io.reactivex.b.g<? super Throwable> gVarD = Functions.d();
        io.reactivex.b.a aVar = Functions.f21804c;
        return a(gVar, gVarD, aVar, aVar);
    }

    public final <R> e<R> c(io.reactivex.b.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.k(this, oVar));
    }

    public final <R> e<R> b(io.reactivex.b.o<? super T, ? extends f.b.b<? extends R>> oVar) {
        return a((io.reactivex.b.o) oVar, false, a(), a());
    }

    public static <T> e<T> a(Callable<? extends Throwable> callable) {
        io.reactivex.internal.functions.a.a(callable, "supplier is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.g(callable));
    }

    public final e<T> b(x xVar) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return a(xVar, !(this instanceof FlowableCreate));
    }

    public static <T> e<T> a(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "throwable is null");
        return a((Callable<? extends Throwable>) Functions.b(th));
    }

    public static <T, S> e<T> a(Callable<S> callable, io.reactivex.b.b<S, d<T>> bVar, io.reactivex.b.g<? super S> gVar) {
        io.reactivex.internal.functions.a.a(bVar, "generator is null");
        return a(callable, FlowableInternalHelper.a(bVar), gVar);
    }

    public static <T, S> e<T> a(Callable<S> callable, io.reactivex.b.c<S, d<T>, S> cVar, io.reactivex.b.g<? super S> gVar) {
        io.reactivex.internal.functions.a.a(callable, "initialState is null");
        io.reactivex.internal.functions.a.a(cVar, "generator is null");
        io.reactivex.internal.functions.a.a(gVar, "disposeState is null");
        return io.reactivex.e.a.a(new FlowableGenerate(callable, cVar, gVar));
    }

    public static <T> e<T> a(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "item is null");
        return io.reactivex.e.a.a((e) new io.reactivex.internal.operators.flowable.i(t));
    }

    public static <T> e<T> a(Iterable<? extends f.b.b<? extends T>> iterable, int i) {
        return b(iterable).a(Functions.e(), true, i);
    }

    public final <R> e<R> a(io.reactivex.b.o<? super T, ? extends f.b.b<? extends R>> oVar) {
        return a((io.reactivex.b.o) oVar, 2, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> a(io.reactivex.b.o<? super T, ? extends f.b.b<? extends R>> oVar, int i, boolean z) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        if (this instanceof io.reactivex.c.a.i) {
            Object objCall = ((io.reactivex.c.a.i) this).call();
            if (objCall == null) {
                return b();
            }
            return io.reactivex.internal.operators.flowable.m.a(objCall, oVar);
        }
        return io.reactivex.e.a.a(new FlowableConcatMap(this, oVar, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final e<T> a(io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(aVar, "onFinally is null");
        return io.reactivex.e.a.a(new FlowableDoFinally(this, aVar));
    }

    private e<T> a(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.a aVar2) {
        io.reactivex.internal.functions.a.a(gVar, "onNext is null");
        io.reactivex.internal.functions.a.a(gVar2, "onError is null");
        io.reactivex.internal.functions.a.a(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.a(aVar2, "onAfterTerminate is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.d(this, gVar, gVar2, aVar, aVar2));
    }

    public final e<T> a(io.reactivex.b.g<? super Throwable> gVar) {
        io.reactivex.b.g<? super T> gVarD = Functions.d();
        io.reactivex.b.a aVar = Functions.f21804c;
        return a(gVarD, gVar, aVar, aVar);
    }

    public final e<T> a(io.reactivex.b.g<? super f.b.d> gVar, io.reactivex.b.p pVar, io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(gVar, "onSubscribe is null");
        io.reactivex.internal.functions.a.a(pVar, "onRequest is null");
        io.reactivex.internal.functions.a.a(aVar, "onCancel is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.flowable.e(this, gVar, pVar, aVar));
    }

    public final <R> e<R> a(io.reactivex.b.o<? super T, ? extends f.b.b<? extends R>> oVar, boolean z) {
        return a(oVar, z, a(), a());
    }

    public final <R> e<R> a(io.reactivex.b.o<? super T, ? extends f.b.b<? extends R>> oVar, boolean z, int i) {
        return a(oVar, z, i, a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> e<R> a(io.reactivex.b.o<? super T, ? extends f.b.b<? extends R>> oVar, boolean z, int i, int i2) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "maxConcurrency");
        io.reactivex.internal.functions.a.a(i2, "bufferSize");
        if (this instanceof io.reactivex.c.a.i) {
            Object objCall = ((io.reactivex.c.a.i) this).call();
            if (objCall == null) {
                return b();
            }
            return io.reactivex.internal.operators.flowable.m.a(objCall, oVar);
        }
        return io.reactivex.e.a.a(new FlowableFlatMap(this, oVar, z, i, i2));
    }

    public final e<T> a(x xVar) {
        return a(xVar, false, a());
    }

    public final e<T> a(x xVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new FlowableObserveOn(this, xVar, z, i));
    }

    public final e<T> a(int i, boolean z, boolean z2) {
        io.reactivex.internal.functions.a.a(i, "capacity");
        return io.reactivex.e.a.a(new FlowableOnBackpressureBuffer(this, i, z2, z, Functions.f21804c));
    }

    public final io.reactivex.a.a<T> a(int i) {
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return FlowablePublish.a(this, i);
    }

    public final e<T> a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, io.reactivex.f.b.a());
    }

    public final e<T> a(long j, TimeUnit timeUnit, boolean z) {
        return a(j, timeUnit, io.reactivex.f.b.a(), z);
    }

    public final e<T> a(long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new FlowableSampleTimed(this, j, timeUnit, xVar, false));
    }

    public final e<T> a(long j, TimeUnit timeUnit, x xVar, boolean z) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new FlowableSampleTimed(this, j, timeUnit, xVar, z));
    }

    public final io.reactivex.disposables.b a(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar) {
        return a(gVar, gVar2, aVar, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final io.reactivex.disposables.b a(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.g<? super f.b.d> gVar3) {
        io.reactivex.internal.functions.a.a(gVar, "onNext is null");
        io.reactivex.internal.functions.a.a(gVar2, "onError is null");
        io.reactivex.internal.functions.a.a(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.a(gVar3, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(gVar, gVar2, aVar, gVar3);
        a((h) lambdaSubscriber);
        return lambdaSubscriber;
    }

    @Override // f.b.b
    public final void a(f.b.c<? super T> cVar) {
        if (cVar instanceof h) {
            a((h) cVar);
        } else {
            io.reactivex.internal.functions.a.a(cVar, "s is null");
            a((h) new StrictSubscriber(cVar));
        }
    }

    public final void a(h<? super T> hVar) {
        io.reactivex.internal.functions.a.a(hVar, "s is null");
        try {
            f.b.c<? super T> cVarA = io.reactivex.e.a.a(this, hVar);
            io.reactivex.internal.functions.a.a(cVarA, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(cVarA);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final e<T> a(x xVar, boolean z) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new FlowableSubscribeOn(this, xVar, z));
    }
}
