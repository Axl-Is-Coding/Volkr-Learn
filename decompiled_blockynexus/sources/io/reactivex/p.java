package io.reactivex;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.Aa;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.C;
import io.reactivex.internal.operators.observable.C2905aa;
import io.reactivex.internal.operators.observable.C2906b;
import io.reactivex.internal.operators.observable.C2907c;
import io.reactivex.internal.operators.observable.C2908d;
import io.reactivex.internal.operators.observable.C2910f;
import io.reactivex.internal.operators.observable.C2912h;
import io.reactivex.internal.operators.observable.C2913i;
import io.reactivex.internal.operators.observable.C2914j;
import io.reactivex.internal.operators.observable.C2915k;
import io.reactivex.internal.operators.observable.C2916l;
import io.reactivex.internal.operators.observable.C2918n;
import io.reactivex.internal.operators.observable.C2920p;
import io.reactivex.internal.operators.observable.C2921q;
import io.reactivex.internal.operators.observable.C2922s;
import io.reactivex.internal.operators.observable.C2923t;
import io.reactivex.internal.operators.observable.C2924u;
import io.reactivex.internal.operators.observable.C2925v;
import io.reactivex.internal.operators.observable.C2926w;
import io.reactivex.internal.operators.observable.C2927x;
import io.reactivex.internal.operators.observable.C2928y;
import io.reactivex.internal.operators.observable.C2929z;
import io.reactivex.internal.operators.observable.D;
import io.reactivex.internal.operators.observable.E;
import io.reactivex.internal.operators.observable.F;
import io.reactivex.internal.operators.observable.G;
import io.reactivex.internal.operators.observable.H;
import io.reactivex.internal.operators.observable.I;
import io.reactivex.internal.operators.observable.J;
import io.reactivex.internal.operators.observable.K;
import io.reactivex.internal.operators.observable.L;
import io.reactivex.internal.operators.observable.M;
import io.reactivex.internal.operators.observable.N;
import io.reactivex.internal.operators.observable.O;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.P;
import io.reactivex.internal.operators.observable.Q;
import io.reactivex.internal.operators.observable.S;
import io.reactivex.internal.operators.observable.T;
import io.reactivex.internal.operators.observable.U;
import io.reactivex.internal.operators.observable.V;
import io.reactivex.internal.operators.observable.W;
import io.reactivex.internal.operators.observable.X;
import io.reactivex.internal.operators.observable.Y;
import io.reactivex.internal.operators.observable.Z;
import io.reactivex.internal.operators.observable.ba;
import io.reactivex.internal.operators.observable.ca;
import io.reactivex.internal.operators.observable.da;
import io.reactivex.internal.operators.observable.fa;
import io.reactivex.internal.operators.observable.ga;
import io.reactivex.internal.operators.observable.ha;
import io.reactivex.internal.operators.observable.ia;
import io.reactivex.internal.operators.observable.ja;
import io.reactivex.internal.operators.observable.ka;
import io.reactivex.internal.operators.observable.la;
import io.reactivex.internal.operators.observable.ma;
import io.reactivex.internal.operators.observable.na;
import io.reactivex.internal.operators.observable.oa;
import io.reactivex.internal.operators.observable.pa;
import io.reactivex.internal.operators.observable.qa;
import io.reactivex.internal.operators.observable.ra;
import io.reactivex.internal.operators.observable.sa;
import io.reactivex.internal.operators.observable.ta;
import io.reactivex.internal.operators.observable.ua;
import io.reactivex.internal.operators.observable.va;
import io.reactivex.internal.operators.observable.wa;
import io.reactivex.internal.operators.observable.xa;
import io.reactivex.internal.operators.observable.ya;
import io.reactivex.internal.operators.observable.za;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Observable.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class p<T> implements u<T> {
    public static <T> p<T> amb(Iterable<? extends u<? extends T>> iterable) {
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        return io.reactivex.e.a.a(new ObservableAmb(null, iterable));
    }

    public static <T> p<T> ambArray(u<? extends T>... uVarArr) {
        io.reactivex.internal.functions.a.a(uVarArr, "sources is null");
        int length = uVarArr.length;
        return length == 0 ? empty() : length == 1 ? wrap(uVarArr[0]) : io.reactivex.e.a.a(new ObservableAmb(uVarArr, null));
    }

    public static int bufferSize() {
        return e.a();
    }

    public static <T, R> p<R> combineLatest(io.reactivex.b.o<? super Object[], ? extends R> oVar, int i, u<? extends T>... uVarArr) {
        return combineLatest(uVarArr, oVar, i);
    }

    public static <T, R> p<R> combineLatestDelayError(u<? extends T>[] uVarArr, io.reactivex.b.o<? super Object[], ? extends R> oVar) {
        return combineLatestDelayError(uVarArr, oVar, bufferSize());
    }

    public static <T> p<T> concat(Iterable<? extends u<? extends T>> iterable) {
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.e(), bufferSize(), false);
    }

    public static <T> p<T> concatArray(u<? extends T>... uVarArr) {
        return uVarArr.length == 0 ? empty() : uVarArr.length == 1 ? wrap(uVarArr[0]) : io.reactivex.e.a.a(new ObservableConcatMap(fromArray(uVarArr), Functions.e(), bufferSize(), ErrorMode.BOUNDARY));
    }

    public static <T> p<T> concatArrayDelayError(u<? extends T>... uVarArr) {
        return uVarArr.length == 0 ? empty() : uVarArr.length == 1 ? wrap(uVarArr[0]) : concatDelayError(fromArray(uVarArr));
    }

    public static <T> p<T> concatArrayEager(u<? extends T>... uVarArr) {
        return concatArrayEager(bufferSize(), bufferSize(), uVarArr);
    }

    public static <T> p<T> concatArrayEagerDelayError(u<? extends T>... uVarArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), uVarArr);
    }

    public static <T> p<T> concatDelayError(Iterable<? extends u<? extends T>> iterable) {
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> p<T> concatEager(u<? extends u<? extends T>> uVar) {
        return concatEager(uVar, bufferSize(), bufferSize());
    }

    public static <T> p<T> create(s<T> sVar) {
        io.reactivex.internal.functions.a.a(sVar, "source is null");
        return io.reactivex.e.a.a(new ObservableCreate(sVar));
    }

    public static <T> p<T> defer(Callable<? extends u<? extends T>> callable) {
        io.reactivex.internal.functions.a.a(callable, "supplier is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.observable.r(callable));
    }

    private p<T> doOnEach(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.a aVar2) {
        io.reactivex.internal.functions.a.a(gVar, "onNext is null");
        io.reactivex.internal.functions.a.a(gVar2, "onError is null");
        io.reactivex.internal.functions.a.a(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.a(aVar2, "onAfterTerminate is null");
        return io.reactivex.e.a.a(new C2929z(this, gVar, gVar2, aVar, aVar2));
    }

    public static <T> p<T> empty() {
        return io.reactivex.e.a.a(E.f22022a);
    }

    public static <T> p<T> error(Callable<? extends Throwable> callable) {
        io.reactivex.internal.functions.a.a(callable, "errorSupplier is null");
        return io.reactivex.e.a.a(new F(callable));
    }

    public static <T> p<T> fromArray(T... tArr) {
        io.reactivex.internal.functions.a.a(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : io.reactivex.e.a.a(new I(tArr));
    }

    public static <T> p<T> fromCallable(Callable<? extends T> callable) {
        io.reactivex.internal.functions.a.a(callable, "supplier is null");
        return io.reactivex.e.a.a((p) new J(callable));
    }

    public static <T> p<T> fromFuture(Future<? extends T> future) {
        io.reactivex.internal.functions.a.a(future, "future is null");
        return io.reactivex.e.a.a(new K(future, 0L, null));
    }

    public static <T> p<T> fromIterable(Iterable<? extends T> iterable) {
        io.reactivex.internal.functions.a.a(iterable, "source is null");
        return io.reactivex.e.a.a(new L(iterable));
    }

    public static <T> p<T> fromPublisher(f.b.b<? extends T> bVar) {
        io.reactivex.internal.functions.a.a(bVar, "publisher is null");
        return io.reactivex.e.a.a(new M(bVar));
    }

    public static <T> p<T> generate(io.reactivex.b.g<d<T>> gVar) {
        io.reactivex.internal.functions.a.a(gVar, "generator is null");
        return generate(Functions.h(), T.a(gVar), Functions.d());
    }

    public static p<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, io.reactivex.f.b.a());
    }

    public static p<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, io.reactivex.f.b.a());
    }

    public static <T> p<T> just(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "item is null");
        return io.reactivex.e.a.a((p) new U(t));
    }

    public static <T> p<T> merge(Iterable<? extends u<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.e(), false, i, i2);
    }

    public static <T> p<T> mergeArray(int i, int i2, u<? extends T>... uVarArr) {
        return fromArray(uVarArr).flatMap(Functions.e(), false, i, i2);
    }

    public static <T> p<T> mergeArrayDelayError(int i, int i2, u<? extends T>... uVarArr) {
        return fromArray(uVarArr).flatMap(Functions.e(), true, i, i2);
    }

    public static <T> p<T> mergeDelayError(Iterable<? extends u<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.e(), true);
    }

    public static <T> p<T> never() {
        return io.reactivex.e.a.a(ba.f22365a);
    }

    public static p<Integer> range(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return empty();
        }
        if (i2 == 1) {
            return just(Integer.valueOf(i));
        }
        if (((long) i) + ((long) (i2 - 1)) <= 2147483647L) {
            return io.reactivex.e.a.a(new ObservableRange(i, i2));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    public static p<Long> rangeLong(long j, long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        if (j2 == 0) {
            return empty();
        }
        if (j2 == 1) {
            return just(Long.valueOf(j));
        }
        long j3 = (j2 - 1) + j;
        if (j <= 0 || j3 >= 0) {
            return io.reactivex.e.a.a(new ObservableRangeLong(j, j2));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    public static <T> y<Boolean> sequenceEqual(u<? extends T> uVar, u<? extends T> uVar2) {
        return sequenceEqual(uVar, uVar2, io.reactivex.internal.functions.a.a(), bufferSize());
    }

    public static <T> p<T> switchOnNext(u<? extends u<? extends T>> uVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableSwitchMap(uVar, Functions.e(), i, false));
    }

    public static <T> p<T> switchOnNextDelayError(u<? extends u<? extends T>> uVar) {
        return switchOnNextDelayError(uVar, bufferSize());
    }

    private p<T> timeout0(long j, TimeUnit timeUnit, u<? extends T> uVar, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "timeUnit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableTimeoutTimed(this, j, timeUnit, xVar, uVar));
    }

    public static p<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, io.reactivex.f.b.a());
    }

    public static <T> p<T> unsafeCreate(u<T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "onSubscribe is null");
        if (uVar instanceof p) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return io.reactivex.e.a.a(new N(uVar));
    }

    public static <T, D> p<T> using(Callable<? extends D> callable, io.reactivex.b.o<? super D, ? extends u<? extends T>> oVar, io.reactivex.b.g<? super D> gVar) {
        return using(callable, oVar, gVar, true);
    }

    public static <T> p<T> wrap(u<T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "source is null");
        return uVar instanceof p ? io.reactivex.e.a.a((p) uVar) : io.reactivex.e.a.a(new N(uVar));
    }

    public static <T, R> p<R> zip(Iterable<? extends u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "zipper is null");
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        return io.reactivex.e.a.a(new ObservableZip(null, iterable, oVar, bufferSize(), false));
    }

    public static <T, R> p<R> zipArray(io.reactivex.b.o<? super Object[], ? extends R> oVar, boolean z, int i, u<? extends T>... uVarArr) {
        if (uVarArr.length == 0) {
            return empty();
        }
        io.reactivex.internal.functions.a.a(oVar, "zipper is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableZip(uVarArr, null, oVar, i, z));
    }

    public static <T, R> p<R> zipIterable(Iterable<? extends u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(oVar, "zipper is null");
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableZip(null, iterable, oVar, i, z));
    }

    public final y<Boolean> all(io.reactivex.b.q<? super T> qVar) {
        io.reactivex.internal.functions.a.a(qVar, "predicate is null");
        return io.reactivex.e.a.a(new C2910f(this, qVar));
    }

    public final p<T> ambWith(u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return ambArray(this, uVar);
    }

    public final y<Boolean> any(io.reactivex.b.q<? super T> qVar) {
        io.reactivex.internal.functions.a.a(qVar, "predicate is null");
        return io.reactivex.e.a.a(new C2912h(this, qVar));
    }

    public final <R> R as(q<T, ? extends R> qVar) {
        io.reactivex.internal.functions.a.a(qVar, "converter is null");
        return qVar.apply(this);
    }

    public final T blockingFirst() {
        io.reactivex.internal.observers.d dVar = new io.reactivex.internal.observers.d();
        subscribe(dVar);
        T tA = dVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(io.reactivex.b.g<? super T> gVar) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                gVar.accept(it.next());
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                ((io.reactivex.disposables.b) it).dispose();
                throw ExceptionHelper.b(th);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() {
        io.reactivex.internal.observers.e eVar = new io.reactivex.internal.observers.e();
        subscribe(eVar);
        T tA = eVar.a();
        if (tA != null) {
            return tA;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new C2906b(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new C2907c(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new C2908d(this);
    }

    public final T blockingSingle() {
        T tB = singleElement().b();
        if (tB != null) {
            return tB;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        C2913i.a(this);
    }

    public final p<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final p<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final p<T> cacheWithInitialCapacity(int i) {
        io.reactivex.internal.functions.a.a(i, "initialCapacity");
        return io.reactivex.e.a.a(new ObservableCache(this, i));
    }

    public final <U> p<U> cast(Class<U> cls) {
        io.reactivex.internal.functions.a.a(cls, "clazz is null");
        return (p<U>) map(Functions.a((Class) cls));
    }

    public final <U> y<U> collect(Callable<? extends U> callable, io.reactivex.b.b<? super U, ? super T> bVar) {
        io.reactivex.internal.functions.a.a(callable, "initialValueSupplier is null");
        io.reactivex.internal.functions.a.a(bVar, "collector is null");
        return io.reactivex.e.a.a(new C2918n(this, callable, bVar));
    }

    public final <U> y<U> collectInto(U u, io.reactivex.b.b<? super U, ? super T> bVar) {
        io.reactivex.internal.functions.a.a(u, "initialValue is null");
        return collect(Functions.b(u), bVar);
    }

    public final <R> p<R> compose(v<? super T, ? extends R> vVar) {
        io.reactivex.internal.functions.a.a(vVar, "composer is null");
        return wrap(vVar.apply(this));
    }

    public final <R> p<R> concatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar) {
        return concatMap(oVar, 2);
    }

    public final AbstractC2894a concatMapCompletable(io.reactivex.b.o<? super T, ? extends c> oVar) {
        return concatMapCompletable(oVar, 2);
    }

    public final AbstractC2894a concatMapCompletableDelayError(io.reactivex.b.o<? super T, ? extends c> oVar) {
        return concatMapCompletableDelayError(oVar, true, 2);
    }

    public final <R> p<R> concatMapDelayError(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar) {
        return concatMapDelayError(oVar, bufferSize(), true);
    }

    public final <R> p<R> concatMapEager(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar) {
        return concatMapEager(oVar, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> p<R> concatMapEagerDelayError(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, boolean z) {
        return concatMapEagerDelayError(oVar, Integer.MAX_VALUE, bufferSize(), z);
    }

    public final <U> p<U> concatMapIterable(io.reactivex.b.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new H(this, oVar));
    }

    public final <R> p<R> concatMapMaybe(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar) {
        return concatMapMaybe(oVar, 2);
    }

    public final <R> p<R> concatMapMaybeDelayError(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar) {
        return concatMapMaybeDelayError(oVar, true, 2);
    }

    public final <R> p<R> concatMapSingle(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar) {
        return concatMapSingle(oVar, 2);
    }

    public final <R> p<R> concatMapSingleDelayError(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar) {
        return concatMapSingleDelayError(oVar, true, 2);
    }

    public final p<T> concatWith(u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return concat(this, uVar);
    }

    public final y<Boolean> contains(Object obj) {
        io.reactivex.internal.functions.a.a(obj, "element is null");
        return any(Functions.a(obj));
    }

    public final y<Long> count() {
        return io.reactivex.e.a.a(new C2920p(this));
    }

    public final <U> p<T> debounce(io.reactivex.b.o<? super T, ? extends u<U>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "debounceSelector is null");
        return io.reactivex.e.a.a(new C2921q(this, oVar));
    }

    public final p<T> defaultIfEmpty(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final <U> p<T> delay(io.reactivex.b.o<? super T, ? extends u<U>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "itemDelay is null");
        return (p<T>) flatMap(T.b(oVar));
    }

    public final <U> p<T> delaySubscription(u<U> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return io.reactivex.e.a.a(new C2923t(this, uVar));
    }

    @Deprecated
    public final <T2> p<T2> dematerialize() {
        return io.reactivex.e.a.a(new C2924u(this, Functions.e()));
    }

    public final p<T> distinct() {
        return distinct(Functions.e(), Functions.c());
    }

    public final p<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.e());
    }

    public final p<T> doAfterNext(io.reactivex.b.g<? super T> gVar) {
        io.reactivex.internal.functions.a.a(gVar, "onAfterNext is null");
        return io.reactivex.e.a.a(new C2928y(this, gVar));
    }

    public final p<T> doAfterTerminate(io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(aVar, "onFinally is null");
        return doOnEach(Functions.d(), Functions.d(), Functions.f21804c, aVar);
    }

    public final p<T> doFinally(io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(aVar, "onFinally is null");
        return io.reactivex.e.a.a(new ObservableDoFinally(this, aVar));
    }

    public final p<T> doOnComplete(io.reactivex.b.a aVar) {
        return doOnEach(Functions.d(), Functions.d(), aVar, Functions.f21804c);
    }

    public final p<T> doOnDispose(io.reactivex.b.a aVar) {
        return doOnLifecycle(Functions.d(), aVar);
    }

    public final p<T> doOnError(io.reactivex.b.g<? super Throwable> gVar) {
        io.reactivex.b.g<? super T> gVarD = Functions.d();
        io.reactivex.b.a aVar = Functions.f21804c;
        return doOnEach(gVarD, gVar, aVar, aVar);
    }

    public final p<T> doOnLifecycle(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar, io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(gVar, "onSubscribe is null");
        io.reactivex.internal.functions.a.a(aVar, "onDispose is null");
        return io.reactivex.e.a.a(new io.reactivex.internal.operators.observable.A(this, gVar, aVar));
    }

    public final p<T> doOnNext(io.reactivex.b.g<? super T> gVar) {
        io.reactivex.b.g<? super Throwable> gVarD = Functions.d();
        io.reactivex.b.a aVar = Functions.f21804c;
        return doOnEach(gVar, gVarD, aVar, aVar);
    }

    public final p<T> doOnSubscribe(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar) {
        return doOnLifecycle(gVar, Functions.f21804c);
    }

    public final p<T> doOnTerminate(io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(aVar, "onTerminate is null");
        return doOnEach(Functions.d(), Functions.a(aVar), aVar, Functions.f21804c);
    }

    public final i<T> elementAt(long j) {
        if (j >= 0) {
            return io.reactivex.e.a.a(new C(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final y<T> elementAtOrError(long j) {
        if (j >= 0) {
            return io.reactivex.e.a.a(new D(this, j, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final p<T> filter(io.reactivex.b.q<? super T> qVar) {
        io.reactivex.internal.functions.a.a(qVar, "predicate is null");
        return io.reactivex.e.a.a(new G(this, qVar));
    }

    public final y<T> first(T t) {
        return elementAt(0L, t);
    }

    public final i<T> firstElement() {
        return elementAt(0L);
    }

    public final y<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar) {
        return flatMap((io.reactivex.b.o) oVar, false);
    }

    public final AbstractC2894a flatMapCompletable(io.reactivex.b.o<? super T, ? extends c> oVar) {
        return flatMapCompletable(oVar, false);
    }

    public final <U> p<U> flatMapIterable(io.reactivex.b.o<? super T, ? extends Iterable<? extends U>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new H(this, oVar));
    }

    public final <R> p<R> flatMapMaybe(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar) {
        return flatMapMaybe(oVar, false);
    }

    public final <R> p<R> flatMapSingle(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar) {
        return flatMapSingle(oVar, false);
    }

    public final io.reactivex.disposables.b forEach(io.reactivex.b.g<? super T> gVar) {
        return subscribe(gVar);
    }

    public final io.reactivex.disposables.b forEachWhile(io.reactivex.b.q<? super T> qVar) {
        return forEachWhile(qVar, Functions.f21807f, Functions.f21804c);
    }

    public final <K> p<io.reactivex.d.b<K, T>> groupBy(io.reactivex.b.o<? super T, ? extends K> oVar) {
        return (p<io.reactivex.d.b<K, T>>) groupBy(oVar, Functions.e(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> p<R> groupJoin(u<? extends TRight> uVar, io.reactivex.b.o<? super T, ? extends u<TLeftEnd>> oVar, io.reactivex.b.o<? super TRight, ? extends u<TRightEnd>> oVar2, io.reactivex.b.c<? super T, ? super p<TRight>, ? extends R> cVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        io.reactivex.internal.functions.a.a(oVar, "leftEnd is null");
        io.reactivex.internal.functions.a.a(oVar2, "rightEnd is null");
        io.reactivex.internal.functions.a.a(cVar, "resultSelector is null");
        return io.reactivex.e.a.a(new ObservableGroupJoin(this, uVar, oVar, oVar2, cVar));
    }

    public final p<T> hide() {
        return io.reactivex.e.a.a(new P(this));
    }

    public final AbstractC2894a ignoreElements() {
        return io.reactivex.e.a.a(new S(this));
    }

    public final y<Boolean> isEmpty() {
        return all(Functions.a());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> p<R> join(u<? extends TRight> uVar, io.reactivex.b.o<? super T, ? extends u<TLeftEnd>> oVar, io.reactivex.b.o<? super TRight, ? extends u<TRightEnd>> oVar2, io.reactivex.b.c<? super T, ? super TRight, ? extends R> cVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        io.reactivex.internal.functions.a.a(oVar, "leftEnd is null");
        io.reactivex.internal.functions.a.a(oVar2, "rightEnd is null");
        io.reactivex.internal.functions.a.a(cVar, "resultSelector is null");
        return io.reactivex.e.a.a(new ObservableJoin(this, uVar, oVar, oVar2, cVar));
    }

    public final y<T> last(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "defaultItem is null");
        return io.reactivex.e.a.a(new W(this, t));
    }

    public final i<T> lastElement() {
        return io.reactivex.e.a.a(new V(this));
    }

    public final y<T> lastOrError() {
        return io.reactivex.e.a.a(new W(this, null));
    }

    public final <R> p<R> lift(t<? extends R, ? super T> tVar) {
        io.reactivex.internal.functions.a.a(tVar, "lifter is null");
        return io.reactivex.e.a.a(new X(this, tVar));
    }

    public final <R> p<R> map(io.reactivex.b.o<? super T, ? extends R> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new Y(this, oVar));
    }

    public final p<n<T>> materialize() {
        return io.reactivex.e.a.a(new C2905aa(this));
    }

    public final p<T> mergeWith(u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return merge(this, uVar);
    }

    public final p<T> observeOn(x xVar) {
        return observeOn(xVar, false, bufferSize());
    }

    public final <U> p<U> ofType(Class<U> cls) {
        io.reactivex.internal.functions.a.a(cls, "clazz is null");
        return filter(Functions.b((Class) cls)).cast(cls);
    }

    public final p<T> onErrorResumeNext(io.reactivex.b.o<? super Throwable, ? extends u<? extends T>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "resumeFunction is null");
        return io.reactivex.e.a.a(new ca(this, oVar, false));
    }

    public final p<T> onErrorReturn(io.reactivex.b.o<? super Throwable, ? extends T> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "valueSupplier is null");
        return io.reactivex.e.a.a(new da(this, oVar));
    }

    public final p<T> onErrorReturnItem(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "item is null");
        return onErrorReturn(Functions.c(t));
    }

    public final p<T> onExceptionResumeNext(u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "next is null");
        return io.reactivex.e.a.a(new ca(this, Functions.c(uVar), true));
    }

    public final p<T> onTerminateDetach() {
        return io.reactivex.e.a.a(new C2925v(this));
    }

    public final io.reactivex.d.a<T> publish() {
        return ObservablePublish.a(this);
    }

    public final i<T> reduce(io.reactivex.b.c<T, T, T> cVar) {
        io.reactivex.internal.functions.a.a(cVar, "reducer is null");
        return io.reactivex.e.a.a(new fa(this, cVar));
    }

    public final <R> y<R> reduceWith(Callable<R> callable, io.reactivex.b.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.a(callable, "seedSupplier is null");
        io.reactivex.internal.functions.a.a(cVar, "reducer is null");
        return io.reactivex.e.a.a(new ha(this, callable, cVar));
    }

    public final p<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final p<T> repeatUntil(io.reactivex.b.e eVar) {
        io.reactivex.internal.functions.a.a(eVar, "stop is null");
        return io.reactivex.e.a.a(new ObservableRepeatUntil(this, eVar));
    }

    public final p<T> repeatWhen(io.reactivex.b.o<? super p<Object>, ? extends u<?>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "handler is null");
        return io.reactivex.e.a.a(new ObservableRepeatWhen(this, oVar));
    }

    public final io.reactivex.d.a<T> replay() {
        return ObservableReplay.a(this);
    }

    public final p<T> retry() {
        return retry(Long.MAX_VALUE, Functions.b());
    }

    public final p<T> retryUntil(io.reactivex.b.e eVar) {
        io.reactivex.internal.functions.a.a(eVar, "stop is null");
        return retry(Long.MAX_VALUE, Functions.a(eVar));
    }

    public final p<T> retryWhen(io.reactivex.b.o<? super p<Throwable>, ? extends u<?>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "handler is null");
        return io.reactivex.e.a.a(new ObservableRetryWhen(this, oVar));
    }

    public final void safeSubscribe(w<? super T> wVar) {
        io.reactivex.internal.functions.a.a(wVar, "observer is null");
        if (wVar instanceof io.reactivex.observers.e) {
            subscribe(wVar);
        } else {
            subscribe(new io.reactivex.observers.e(wVar));
        }
    }

    public final p<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, io.reactivex.f.b.a());
    }

    public final p<T> scan(io.reactivex.b.c<T, T, T> cVar) {
        io.reactivex.internal.functions.a.a(cVar, "accumulator is null");
        return io.reactivex.e.a.a(new ia(this, cVar));
    }

    public final <R> p<R> scanWith(Callable<R> callable, io.reactivex.b.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.a(callable, "seedSupplier is null");
        io.reactivex.internal.functions.a.a(cVar, "accumulator is null");
        return io.reactivex.e.a.a(new ja(this, callable, cVar));
    }

    public final p<T> serialize() {
        return io.reactivex.e.a.a(new ka(this));
    }

    public final p<T> share() {
        return publish().b();
    }

    public final y<T> single(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "defaultItem is null");
        return io.reactivex.e.a.a(new ma(this, t));
    }

    public final i<T> singleElement() {
        return io.reactivex.e.a.a(new la(this));
    }

    public final y<T> singleOrError() {
        return io.reactivex.e.a.a(new ma(this, null));
    }

    public final p<T> skip(long j) {
        return j <= 0 ? io.reactivex.e.a.a(this) : io.reactivex.e.a.a(new na(this, j));
    }

    public final p<T> skipLast(int i) {
        if (i >= 0) {
            return i == 0 ? io.reactivex.e.a.a(this) : io.reactivex.e.a.a(new ObservableSkipLast(this, i));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    public final <U> p<T> skipUntil(u<U> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return io.reactivex.e.a.a(new oa(this, uVar));
    }

    public final p<T> skipWhile(io.reactivex.b.q<? super T> qVar) {
        io.reactivex.internal.functions.a.a(qVar, "predicate is null");
        return io.reactivex.e.a.a(new pa(this, qVar));
    }

    public final p<T> sorted() {
        return toList().c().map(Functions.a(Functions.f())).flatMapIterable(Functions.e());
    }

    public final p<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final p<T> startWithArray(T... tArr) {
        p pVarFromArray = fromArray(tArr);
        return pVarFromArray == empty() ? io.reactivex.e.a.a(this) : concatArray(pVarFromArray, this);
    }

    public final io.reactivex.disposables.b subscribe() {
        return subscribe(Functions.d(), Functions.f21807f, Functions.f21804c, Functions.d());
    }

    protected abstract void subscribeActual(w<? super T> wVar);

    public final p<T> subscribeOn(x xVar) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableSubscribeOn(this, xVar));
    }

    public final <E extends w<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final p<T> switchIfEmpty(u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return io.reactivex.e.a.a(new qa(this, uVar));
    }

    public final <R> p<R> switchMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar) {
        return switchMap(oVar, bufferSize());
    }

    public final AbstractC2894a switchMapCompletable(io.reactivex.b.o<? super T, ? extends c> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableSwitchMapCompletable(this, oVar, false));
    }

    public final AbstractC2894a switchMapCompletableDelayError(io.reactivex.b.o<? super T, ? extends c> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableSwitchMapCompletable(this, oVar, true));
    }

    public final <R> p<R> switchMapDelayError(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar) {
        return switchMapDelayError(oVar, bufferSize());
    }

    public final <R> p<R> switchMapMaybe(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableSwitchMapMaybe(this, oVar, false));
    }

    public final <R> p<R> switchMapMaybeDelayError(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableSwitchMapMaybe(this, oVar, true));
    }

    public final <R> p<R> switchMapSingle(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableSwitchMapSingle(this, oVar, false));
    }

    public final <R> p<R> switchMapSingleDelayError(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableSwitchMapSingle(this, oVar, true));
    }

    public final p<T> take(long j) {
        if (j >= 0) {
            return io.reactivex.e.a.a(new ra(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final p<T> takeLast(int i) {
        if (i >= 0) {
            return i == 0 ? io.reactivex.e.a.a(new Q(this)) : i == 1 ? io.reactivex.e.a.a(new sa(this)) : io.reactivex.e.a.a(new ObservableTakeLast(this, i));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    public final <U> p<T> takeUntil(u<U> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return io.reactivex.e.a.a(new ObservableTakeUntil(this, uVar));
    }

    public final p<T> takeWhile(io.reactivex.b.q<? super T> qVar) {
        io.reactivex.internal.functions.a.a(qVar, "predicate is null");
        return io.reactivex.e.a.a(new ua(this, qVar));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final p<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, io.reactivex.f.b.a());
    }

    public final p<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final p<T> throttleLatest(long j, TimeUnit timeUnit) {
        return throttleLatest(j, timeUnit, io.reactivex.f.b.a(), false);
    }

    public final p<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final p<io.reactivex.f.c<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, io.reactivex.f.b.a());
    }

    public final <V> p<T> timeout(io.reactivex.b.o<? super T, ? extends u<V>> oVar) {
        return timeout0(null, oVar, null);
    }

    public final p<io.reactivex.f.c<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, io.reactivex.f.b.a());
    }

    public final <R> R to(io.reactivex.b.o<? super p<T>, R> oVar) {
        try {
            io.reactivex.internal.functions.a.a(oVar, "converter is null");
            return oVar.apply(this);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw ExceptionHelper.b(th);
        }
    }

    public final e<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        io.reactivex.internal.operators.flowable.h hVar = new io.reactivex.internal.operators.flowable.h(this);
        int i = o.f22737a[backpressureStrategy.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? hVar.d() : io.reactivex.e.a.a(new FlowableOnBackpressureError(hVar)) : hVar : hVar.f() : hVar.e();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new io.reactivex.internal.observers.h());
    }

    public final y<List<T>> toList() {
        return toList(16);
    }

    public final <K> y<Map<K, T>> toMap(io.reactivex.b.o<? super T, ? extends K> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "keySelector is null");
        return (y<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.a((io.reactivex.b.o) oVar));
    }

    public final <K> y<Map<K, Collection<T>>> toMultimap(io.reactivex.b.o<? super T, ? extends K> oVar) {
        return (y<Map<K, Collection<T>>>) toMultimap(oVar, Functions.e(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final y<List<T>> toSortedList() {
        return toSortedList(Functions.g());
    }

    public final p<T> unsubscribeOn(x xVar) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableUnsubscribeOn(this, xVar));
    }

    public final p<p<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    public final <U, R> p<R> withLatestFrom(u<? extends U> uVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        io.reactivex.internal.functions.a.a(cVar, "combiner is null");
        return io.reactivex.e.a.a(new ObservableWithLatestFrom(this, cVar, uVar));
    }

    public final <U, R> p<R> zipWith(Iterable<U> iterable, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.a(iterable, "other is null");
        io.reactivex.internal.functions.a.a(cVar, "zipper is null");
        return io.reactivex.e.a.a(new Aa(this, iterable, cVar));
    }

    public static <T, R> p<R> combineLatest(Iterable<? extends u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar) {
        return combineLatest(iterable, oVar, bufferSize());
    }

    public static <T, R> p<R> combineLatestDelayError(io.reactivex.b.o<? super Object[], ? extends R> oVar, int i, u<? extends T>... uVarArr) {
        return combineLatestDelayError(uVarArr, oVar, i);
    }

    public static <T> p<T> concatArrayEager(int i, int i2, u<? extends T>... uVarArr) {
        return fromArray(uVarArr).concatMapEagerDelayError(Functions.e(), i, i2, false);
    }

    public static <T> p<T> concatArrayEagerDelayError(int i, int i2, u<? extends T>... uVarArr) {
        return fromArray(uVarArr).concatMapEagerDelayError(Functions.e(), i, i2, true);
    }

    public static <T> p<T> concatEager(u<? extends u<? extends T>> uVar, int i, int i2) {
        return wrap(uVar).concatMapEager(Functions.e(), i, i2);
    }

    public static p<Long> interval(long j, long j2, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, xVar));
    }

    public static p<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, x xVar) {
        if (j2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        if (j2 == 0) {
            return empty().delay(j3, timeUnit, xVar);
        }
        long j5 = j + (j2 - 1);
        if (j > 0 && j5 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, xVar));
    }

    public static <T> p<T> merge(Iterable<? extends u<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.e());
    }

    public static <T> p<T> mergeArray(u<? extends T>... uVarArr) {
        return fromArray(uVarArr).flatMap(Functions.e(), uVarArr.length);
    }

    public static <T> p<T> mergeArrayDelayError(u<? extends T>... uVarArr) {
        return fromArray(uVarArr).flatMap(Functions.e(), true, uVarArr.length);
    }

    public static <T> p<T> mergeDelayError(Iterable<? extends u<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.e(), true, i, i2);
    }

    public static <T> y<Boolean> sequenceEqual(u<? extends T> uVar, u<? extends T> uVar2, io.reactivex.b.d<? super T, ? super T> dVar) {
        return sequenceEqual(uVar, uVar2, dVar, bufferSize());
    }

    public static <T> p<T> switchOnNextDelayError(u<? extends u<? extends T>> uVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return io.reactivex.e.a.a(new ObservableSwitchMap(uVar, Functions.e(), i, true));
    }

    public static p<Long> timer(long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableTimer(Math.max(j, 0L), timeUnit, xVar));
    }

    public static <T, D> p<T> using(Callable<? extends D> callable, io.reactivex.b.o<? super D, ? extends u<? extends T>> oVar, io.reactivex.b.g<? super D> gVar, boolean z) {
        io.reactivex.internal.functions.a.a(callable, "resourceSupplier is null");
        io.reactivex.internal.functions.a.a(oVar, "sourceSupplier is null");
        io.reactivex.internal.functions.a.a(gVar, "disposer is null");
        return io.reactivex.e.a.a(new ObservableUsing(callable, oVar, gVar, z));
    }

    public final Iterable<T> blockingIterable(int i) {
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return new BlockingObservableIterable(this, i);
    }

    public final void blockingSubscribe(io.reactivex.b.g<? super T> gVar) {
        C2913i.a(this, gVar, Functions.f21807f, Functions.f21804c);
    }

    public final p<List<T>> buffer(int i, int i2) {
        return (p<List<T>>) buffer(i, i2, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> p<R> concatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        if (!(this instanceof io.reactivex.c.a.i)) {
            return io.reactivex.e.a.a(new ObservableConcatMap(this, oVar, i, ErrorMode.IMMEDIATE));
        }
        Object objCall = ((io.reactivex.c.a.i) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.a(objCall, oVar);
    }

    public final AbstractC2894a concatMapCompletable(io.reactivex.b.o<? super T, ? extends c> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "capacityHint");
        return io.reactivex.e.a.a(new ObservableConcatMapCompletable(this, oVar, ErrorMode.IMMEDIATE, i));
    }

    public final AbstractC2894a concatMapCompletableDelayError(io.reactivex.b.o<? super T, ? extends c> oVar, boolean z) {
        return concatMapCompletableDelayError(oVar, z, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> p<R> concatMapDelayError(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, int i, boolean z) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        if (!(this instanceof io.reactivex.c.a.i)) {
            return io.reactivex.e.a.a(new ObservableConcatMap(this, oVar, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object objCall = ((io.reactivex.c.a.i) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.a(objCall, oVar);
    }

    public final <R> p<R> concatMapEager(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, int i, int i2) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "maxConcurrency");
        io.reactivex.internal.functions.a.a(i2, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMapEager(this, oVar, ErrorMode.IMMEDIATE, i, i2));
    }

    public final <R> p<R> concatMapEagerDelayError(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, int i, int i2, boolean z) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "maxConcurrency");
        io.reactivex.internal.functions.a.a(i2, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMapEager(this, oVar, z ? ErrorMode.END : ErrorMode.BOUNDARY, i, i2));
    }

    public final <R> p<R> concatMapMaybe(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMapMaybe(this, oVar, ErrorMode.IMMEDIATE, i));
    }

    public final <R> p<R> concatMapMaybeDelayError(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar, boolean z) {
        return concatMapMaybeDelayError(oVar, z, 2);
    }

    public final <R> p<R> concatMapSingle(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMapSingle(this, oVar, ErrorMode.IMMEDIATE, i));
    }

    public final <R> p<R> concatMapSingleDelayError(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar, boolean z) {
        return concatMapSingleDelayError(oVar, z, 2);
    }

    public final <R> p<R> dematerialize(io.reactivex.b.o<? super T, n<R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        return io.reactivex.e.a.a(new C2924u(this, oVar));
    }

    public final <K> p<T> distinct(io.reactivex.b.o<? super T, K> oVar) {
        return distinct(oVar, Functions.c());
    }

    public final <K> p<T> distinctUntilChanged(io.reactivex.b.o<? super T, K> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "keySelector is null");
        return io.reactivex.e.a.a(new C2927x(this, oVar, io.reactivex.internal.functions.a.a()));
    }

    public final <R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, boolean z) {
        return flatMap(oVar, z, Integer.MAX_VALUE);
    }

    public final AbstractC2894a flatMapCompletable(io.reactivex.b.o<? super T, ? extends c> oVar, boolean z) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableFlatMapCompletableCompletable(this, oVar, z));
    }

    public final <R> p<R> flatMapMaybe(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar, boolean z) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableFlatMapMaybe(this, oVar, z));
    }

    public final <R> p<R> flatMapSingle(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar, boolean z) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        return io.reactivex.e.a.a(new ObservableFlatMapSingle(this, oVar, z));
    }

    public final io.reactivex.disposables.b forEachWhile(io.reactivex.b.q<? super T> qVar, io.reactivex.b.g<? super Throwable> gVar) {
        return forEachWhile(qVar, gVar, Functions.f21804c);
    }

    public final <K> p<io.reactivex.d.b<K, T>> groupBy(io.reactivex.b.o<? super T, ? extends K> oVar, boolean z) {
        return (p<io.reactivex.d.b<K, T>>) groupBy(oVar, Functions.e(), z, bufferSize());
    }

    public final p<T> observeOn(x xVar, boolean z) {
        return observeOn(xVar, z, bufferSize());
    }

    public final <R> p<R> publish(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        return io.reactivex.e.a.a(new ObservablePublishSelector(this, oVar));
    }

    public final p<T> repeat(long j) {
        if (j >= 0) {
            return j == 0 ? empty() : io.reactivex.e.a.a(new ObservableRepeat(this, j));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        return ObservableReplay.a(T.a(this), oVar);
    }

    public final p<T> retry(io.reactivex.b.d<? super Integer, ? super Throwable> dVar) {
        io.reactivex.internal.functions.a.a(dVar, "predicate is null");
        return io.reactivex.e.a.a(new ObservableRetryBiPredicate(this, dVar));
    }

    public final p<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, io.reactivex.f.b.a(), z);
    }

    public final p<T> sorted(Comparator<? super T> comparator) {
        io.reactivex.internal.functions.a.a(comparator, "sortFunction is null");
        return toList().c().map(Functions.a((Comparator) comparator)).flatMapIterable(Functions.e());
    }

    public final p<T> startWith(u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return concatArray(uVar, this);
    }

    public final io.reactivex.disposables.b subscribe(io.reactivex.b.g<? super T> gVar) {
        return subscribe(gVar, Functions.f21807f, Functions.f21804c, Functions.d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> p<R> switchMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        if (!(this instanceof io.reactivex.c.a.i)) {
            return io.reactivex.e.a.a(new ObservableSwitchMap(this, oVar, i, false));
        }
        Object objCall = ((io.reactivex.c.a.i) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.a(objCall, oVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> p<R> switchMapDelayError(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        if (!(this instanceof io.reactivex.c.a.i)) {
            return io.reactivex.e.a.a(new ObservableSwitchMap(this, oVar, i, true));
        }
        Object objCall = ((io.reactivex.c.a.i) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.a(objCall, oVar);
    }

    public final p<T> throttleFirst(long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableThrottleFirstTimed(this, j, timeUnit, xVar));
    }

    public final p<T> throttleLast(long j, TimeUnit timeUnit, x xVar) {
        return sample(j, timeUnit, xVar);
    }

    public final p<T> throttleLatest(long j, TimeUnit timeUnit, boolean z) {
        return throttleLatest(j, timeUnit, io.reactivex.f.b.a(), z);
    }

    public final p<T> throttleWithTimeout(long j, TimeUnit timeUnit, x xVar) {
        return debounce(j, timeUnit, xVar);
    }

    public final p<io.reactivex.f.c<T>> timeInterval(x xVar) {
        return timeInterval(TimeUnit.MILLISECONDS, xVar);
    }

    public final <V> p<T> timeout(io.reactivex.b.o<? super T, ? extends u<V>> oVar, u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return timeout0(null, oVar, uVar);
    }

    public final p<io.reactivex.f.c<T>> timestamp(x xVar) {
        return timestamp(TimeUnit.MILLISECONDS, xVar);
    }

    public final y<List<T>> toList(int i) {
        io.reactivex.internal.functions.a.a(i, "capacityHint");
        return io.reactivex.e.a.a(new xa(this, i));
    }

    public final y<List<T>> toSortedList(Comparator<? super T> comparator) {
        io.reactivex.internal.functions.a.a(comparator, "comparator is null");
        return (y<List<T>>) toList().a(Functions.a((Comparator) comparator));
    }

    public final p<p<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    public static <T, R> p<R> combineLatest(Iterable<? extends u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i) {
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        io.reactivex.internal.functions.a.a(oVar, "combiner is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableCombineLatest(null, iterable, oVar, i << 1, false));
    }

    public static <T, R> p<R> combineLatestDelayError(u<? extends T>[] uVarArr, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i) {
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        io.reactivex.internal.functions.a.a(oVar, "combiner is null");
        if (uVarArr.length == 0) {
            return empty();
        }
        return io.reactivex.e.a.a(new ObservableCombineLatest(uVarArr, null, oVar, i << 1, true));
    }

    public static <T> p<T> concat(u<? extends u<? extends T>> uVar) {
        return concat(uVar, bufferSize());
    }

    public static <T> p<T> concatDelayError(u<? extends u<? extends T>> uVar) {
        return concatDelayError(uVar, bufferSize(), true);
    }

    public static <T> p<T> concatEager(Iterable<? extends u<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> p<T> error(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "exception is null");
        return error((Callable<? extends Throwable>) Functions.b(th));
    }

    public static <T> p<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        io.reactivex.internal.functions.a.a(future, "future is null");
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        return io.reactivex.e.a.a(new K(future, j, timeUnit));
    }

    public static <T> p<T> just(T t, T t2) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        return fromArray(t, t2);
    }

    public static <T> p<T> merge(Iterable<? extends u<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.e(), i);
    }

    public static <T> p<T> mergeDelayError(Iterable<? extends u<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.e(), true, i);
    }

    public static <T> y<Boolean> sequenceEqual(u<? extends T> uVar, u<? extends T> uVar2, io.reactivex.b.d<? super T, ? super T> dVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(dVar, "isEqual is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableSequenceEqualSingle(uVar, uVar2, dVar, i));
    }

    public final T blockingSingle(T t) {
        return single(t).b();
    }

    public final void blockingSubscribe(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2) {
        C2913i.a(this, gVar, gVar2, Functions.f21804c);
    }

    public final <U extends Collection<? super T>> p<U> buffer(int i, int i2, Callable<U> callable) {
        io.reactivex.internal.functions.a.a(i, "count");
        io.reactivex.internal.functions.a.a(i2, "skip");
        io.reactivex.internal.functions.a.a(callable, "bufferSupplier is null");
        return io.reactivex.e.a.a(new ObservableBuffer(this, i, i2, callable));
    }

    public final AbstractC2894a concatMapCompletableDelayError(io.reactivex.b.o<? super T, ? extends c> oVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMapCompletable(this, oVar, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final <U> p<U> concatMapIterable(io.reactivex.b.o<? super T, ? extends Iterable<? extends U>> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return (p<U>) concatMap(T.a(oVar), i);
    }

    public final <R> p<R> concatMapMaybeDelayError(io.reactivex.b.o<? super T, ? extends m<? extends R>> oVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMapMaybe(this, oVar, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final <R> p<R> concatMapSingleDelayError(io.reactivex.b.o<? super T, ? extends A<? extends R>> oVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMapSingle(this, oVar, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final p<T> concatWith(A<? extends T> a2) {
        io.reactivex.internal.functions.a.a(a2, "other is null");
        return io.reactivex.e.a.a(new ObservableConcatWithSingle(this, a2));
    }

    public final p<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, io.reactivex.f.b.a());
    }

    public final p<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, io.reactivex.f.b.a(), false);
    }

    public final p<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, io.reactivex.f.b.a());
    }

    public final <K> p<T> distinct(io.reactivex.b.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        io.reactivex.internal.functions.a.a(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.a(callable, "collectionSupplier is null");
        return io.reactivex.e.a.a(new C2926w(this, oVar, callable));
    }

    public final y<T> elementAt(long j, T t) {
        if (j >= 0) {
            io.reactivex.internal.functions.a.a((Object) t, "defaultItem is null");
            return io.reactivex.e.a.a(new D(this, j, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final <R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, boolean z, int i) {
        return flatMap(oVar, z, i, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> p<V> flatMapIterable(io.reactivex.b.o<? super T, ? extends Iterable<? extends U>> oVar, io.reactivex.b.c<? super T, ? super U, ? extends V> cVar) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(cVar, "resultSelector is null");
        return (p<V>) flatMap(T.a(oVar), cVar, false, bufferSize(), bufferSize());
    }

    public final io.reactivex.disposables.b forEachWhile(io.reactivex.b.q<? super T> qVar, io.reactivex.b.g<? super Throwable> gVar, io.reactivex.b.a aVar) {
        io.reactivex.internal.functions.a.a(qVar, "onNext is null");
        io.reactivex.internal.functions.a.a(gVar, "onError is null");
        io.reactivex.internal.functions.a.a(aVar, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(qVar, gVar, aVar);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K, V> p<io.reactivex.d.b<K, V>> groupBy(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2) {
        return groupBy(oVar, oVar2, false, bufferSize());
    }

    public final p<T> mergeWith(A<? extends T> a2) {
        io.reactivex.internal.functions.a.a(a2, "other is null");
        return io.reactivex.e.a.a(new ObservableMergeWithSingle(this, a2));
    }

    public final p<T> observeOn(x xVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableObserveOn(this, xVar, z, i));
    }

    public final p<T> onErrorResumeNext(u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "next is null");
        return onErrorResumeNext(Functions.c(uVar));
    }

    public final <R> y<R> reduce(R r, io.reactivex.b.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.a(r, "seed is null");
        io.reactivex.internal.functions.a.a(cVar, "reducer is null");
        return io.reactivex.e.a.a(new ga(this, r, cVar));
    }

    public final p<T> sample(long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableSampleTimed(this, j, timeUnit, xVar, false));
    }

    public final <R> p<R> scan(R r, io.reactivex.b.c<R, ? super T, R> cVar) {
        io.reactivex.internal.functions.a.a(r, "initialValue is null");
        return scanWith(Functions.b(r), cVar);
    }

    public final p<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    public final io.reactivex.disposables.b subscribe(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2) {
        return subscribe(gVar, gVar2, Functions.f21804c, Functions.d());
    }

    public final p<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    public final p<T> takeUntil(io.reactivex.b.q<? super T> qVar) {
        io.reactivex.internal.functions.a.a(qVar, "stopPredicate is null");
        return io.reactivex.e.a.a(new ta(this, qVar));
    }

    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final p<T> throttleLatest(long j, TimeUnit timeUnit, x xVar) {
        return throttleLatest(j, timeUnit, xVar, false);
    }

    public final p<io.reactivex.f.c<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, io.reactivex.f.b.a());
    }

    public final p<io.reactivex.f.c<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, io.reactivex.f.b.a());
    }

    public final <K, V> y<Map<K, V>> toMap(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2) {
        io.reactivex.internal.functions.a.a(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.a(oVar2, "valueSelector is null");
        return (y<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.a(oVar, oVar2));
    }

    public final p<p<T>> window(long j, long j2, int i) {
        io.reactivex.internal.functions.a.a(j, "count");
        io.reactivex.internal.functions.a.a(j2, "skip");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableWindow(this, j, j2, i));
    }

    public static <T> p<T> concat(u<? extends u<? extends T>> uVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        io.reactivex.internal.functions.a.a(i, "prefetch");
        return io.reactivex.e.a.a(new ObservableConcatMap(uVar, Functions.e(), i, ErrorMode.IMMEDIATE));
    }

    public static <T> p<T> concatDelayError(u<? extends u<? extends T>> uVar, int i, boolean z) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        io.reactivex.internal.functions.a.a(i, "prefetch is null");
        return io.reactivex.e.a.a(new ObservableConcatMap(uVar, Functions.e(), i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public static <T> p<T> concatEager(Iterable<? extends u<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.e(), i, i2, false);
    }

    public static <T> p<T> merge(u<? extends u<? extends T>> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        return io.reactivex.e.a.a(new ObservableFlatMap(uVar, Functions.e(), false, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> p<T> mergeDelayError(u<? extends u<? extends T>> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        return io.reactivex.e.a.a(new ObservableFlatMap(uVar, Functions.e(), true, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> p<T> switchOnNext(u<? extends u<? extends T>> uVar) {
        return switchOnNext(uVar, bufferSize());
    }

    private <U, V> p<T> timeout0(u<U> uVar, io.reactivex.b.o<? super T, ? extends u<V>> oVar, u<? extends T> uVar2) {
        io.reactivex.internal.functions.a.a(oVar, "itemTimeoutIndicator is null");
        return io.reactivex.e.a.a(new ObservableTimeout(this, uVar, oVar, uVar2));
    }

    public static <T, R> p<R> zip(u<? extends u<? extends T>> uVar, io.reactivex.b.o<? super Object[], ? extends R> oVar) {
        io.reactivex.internal.functions.a.a(oVar, "zipper is null");
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        return io.reactivex.e.a.a(new wa(uVar, 16).flatMap(T.c(oVar)));
    }

    public final void blockingSubscribe(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar) {
        C2913i.a(this, gVar, gVar2, aVar);
    }

    public final p<T> debounce(long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableDebounceTimed(this, j, timeUnit, xVar));
    }

    public final p<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, io.reactivex.f.b.a(), z);
    }

    public final p<T> delaySubscription(long j, TimeUnit timeUnit, x xVar) {
        return delaySubscription(timer(j, timeUnit, xVar));
    }

    public final p<T> distinctUntilChanged(io.reactivex.b.d<? super T, ? super T> dVar) {
        io.reactivex.internal.functions.a.a(dVar, "comparer is null");
        return io.reactivex.e.a.a(new C2927x(this, Functions.e(), dVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, boolean z, int i, int i2) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(i, "maxConcurrency");
        io.reactivex.internal.functions.a.a(i2, "bufferSize");
        if (this instanceof io.reactivex.c.a.i) {
            Object objCall = ((io.reactivex.c.a.i) this).call();
            if (objCall == null) {
                return empty();
            }
            return ObservableScalarXMap.a(objCall, oVar);
        }
        return io.reactivex.e.a.a(new ObservableFlatMap(this, oVar, z, i, i2));
    }

    public final <K, V> p<io.reactivex.d.b<K, V>> groupBy(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, boolean z) {
        return groupBy(oVar, oVar2, z, bufferSize());
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar, int i) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return ObservableReplay.a(T.a(this, i), oVar);
    }

    public final p<T> retry(long j) {
        return retry(j, Functions.b());
    }

    public final p<T> skip(long j, TimeUnit timeUnit, x xVar) {
        return skipUntil(timer(j, timeUnit, xVar));
    }

    public final p<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, io.reactivex.f.b.d(), false, bufferSize());
    }

    public final p<T> startWith(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "item is null");
        return concatArray(just(t), this);
    }

    public final io.reactivex.disposables.b subscribe(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar) {
        return subscribe(gVar, gVar2, aVar, Functions.d());
    }

    public final p<T> take(long j, TimeUnit timeUnit, x xVar) {
        return takeUntil(timer(j, timeUnit, xVar));
    }

    public final p<T> throttleLatest(long j, TimeUnit timeUnit, x xVar, boolean z) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableThrottleLatest(this, j, timeUnit, xVar, z));
    }

    public final p<io.reactivex.f.c<T>> timeInterval(TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new va(this, timeUnit, xVar));
    }

    public final p<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, null, io.reactivex.f.b.a());
    }

    public final p<io.reactivex.f.c<T>> timestamp(TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return (p<io.reactivex.f.c<T>>) map(Functions.a(timeUnit, xVar));
    }

    public final <U extends Collection<? super T>> y<U> toList(Callable<U> callable) {
        io.reactivex.internal.functions.a.a(callable, "collectionSupplier is null");
        return io.reactivex.e.a.a(new xa(this, callable));
    }

    public final y<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        io.reactivex.internal.functions.a.a(comparator, "comparator is null");
        return (y<List<T>>) toList(i).a(Functions.a((Comparator) comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> p<R> withLatestFrom(u<T1> uVar, u<T2> uVar2, io.reactivex.b.h<? super T, ? super T1, ? super T2, R> hVar) {
        io.reactivex.internal.functions.a.a(uVar, "o1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "o2 is null");
        io.reactivex.internal.functions.a.a(hVar, "combiner is null");
        return withLatestFrom((u<?>[]) new u[]{uVar, uVar2}, Functions.a((io.reactivex.b.h) hVar));
    }

    public final <U, R> p<R> zipWith(u<? extends U> uVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return zip(this, uVar, cVar);
    }

    public static <T, S> p<T> generate(Callable<S> callable, io.reactivex.b.b<S, d<T>> bVar) {
        io.reactivex.internal.functions.a.a(bVar, "generator is null");
        return generate(callable, T.a(bVar), Functions.d());
    }

    public static p<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, io.reactivex.f.b.a());
    }

    public final T blockingFirst(T t) {
        io.reactivex.internal.observers.d dVar = new io.reactivex.internal.observers.d();
        subscribe(dVar);
        T tA = dVar.a();
        return tA != null ? tA : t;
    }

    public final T blockingLast(T t) {
        io.reactivex.internal.observers.e eVar = new io.reactivex.internal.observers.e();
        subscribe(eVar);
        T tA = eVar.a();
        return tA != null ? tA : t;
    }

    public final void blockingSubscribe(w<? super T> wVar) {
        C2913i.a(this, wVar);
    }

    public final p<T> concatWith(m<? extends T> mVar) {
        io.reactivex.internal.functions.a.a(mVar, "other is null");
        return io.reactivex.e.a.a(new ObservableConcatWithMaybe(this, mVar));
    }

    public final p<T> delay(long j, TimeUnit timeUnit, x xVar) {
        return delay(j, timeUnit, xVar, false);
    }

    public final <K, V> p<io.reactivex.d.b<K, V>> groupBy(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, boolean z, int i) {
        io.reactivex.internal.functions.a.a(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.a(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableGroupBy(this, oVar, oVar2, i, z));
    }

    public final p<T> mergeWith(m<? extends T> mVar) {
        io.reactivex.internal.functions.a.a(mVar, "other is null");
        return io.reactivex.e.a.a(new ObservableMergeWithMaybe(this, mVar));
    }

    public final p<T> retry(long j, io.reactivex.b.q<? super Throwable> qVar) {
        if (j >= 0) {
            io.reactivex.internal.functions.a.a(qVar, "predicate is null");
            return io.reactivex.e.a.a(new ObservableRetryPredicate(this, j, qVar));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final p<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, io.reactivex.f.b.d(), z, bufferSize());
    }

    public final io.reactivex.disposables.b subscribe(io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.g<? super io.reactivex.disposables.b> gVar3) {
        io.reactivex.internal.functions.a.a(gVar, "onNext is null");
        io.reactivex.internal.functions.a.a(gVar2, "onError is null");
        io.reactivex.internal.functions.a.a(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.a(gVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(gVar, gVar2, aVar, gVar3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final p<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, io.reactivex.f.b.d(), false, bufferSize());
    }

    public final p<T> timeout(long j, TimeUnit timeUnit, u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return timeout0(j, timeUnit, uVar, io.reactivex.f.b.a());
    }

    public final <K, V> y<Map<K, Collection<V>>> toMultimap(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2) {
        return toMultimap(oVar, oVar2, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public static <T> p<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(xVar);
    }

    public static p<Long> interval(long j, TimeUnit timeUnit, x xVar) {
        return interval(j, j, timeUnit, xVar);
    }

    public static <T> p<T> just(T t, T t2, T t3) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    public static <T> p<T> merge(u<? extends u<? extends T>> uVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        io.reactivex.internal.functions.a.a(i, "maxConcurrency");
        return io.reactivex.e.a.a(new ObservableFlatMap(uVar, Functions.e(), false, i, bufferSize()));
    }

    public static <T> p<T> mergeDelayError(u<? extends u<? extends T>> uVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "sources is null");
        io.reactivex.internal.functions.a.a(i, "maxConcurrency");
        return io.reactivex.e.a.a(new ObservableFlatMap(uVar, Functions.e(), true, i, bufferSize()));
    }

    public final p<T> delay(long j, TimeUnit timeUnit, x xVar, boolean z) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new C2922s(this, j, timeUnit, xVar, z));
    }

    public final p<T> doOnEach(io.reactivex.b.g<? super n<T>> gVar) {
        io.reactivex.internal.functions.a.a(gVar, "onNotification is null");
        return doOnEach(Functions.c((io.reactivex.b.g) gVar), Functions.b((io.reactivex.b.g) gVar), Functions.a((io.reactivex.b.g) gVar), Functions.f21804c);
    }

    public final p<T> sample(long j, TimeUnit timeUnit, x xVar, boolean z) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return io.reactivex.e.a.a(new ObservableSampleTimed(this, j, timeUnit, xVar, z));
    }

    public final p<T> skipLast(long j, TimeUnit timeUnit, x xVar) {
        return skipLast(j, timeUnit, xVar, false, bufferSize());
    }

    public final p<T> takeLast(long j, long j2, TimeUnit timeUnit, x xVar) {
        return takeLast(j, j2, timeUnit, xVar, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> y<Map<K, V>> toMap(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, V>> callable) {
        io.reactivex.internal.functions.a.a(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.a(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.a(callable, "mapSupplier is null");
        return (y<Map<K, V>>) collect(callable, Functions.a(oVar, oVar2));
    }

    public final y<List<T>> toSortedList(int i) {
        return toSortedList(Functions.g(), i);
    }

    public final <U, R> p<R> zipWith(u<? extends U> uVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return zip(this, uVar, cVar, z);
    }

    public static <T, R> p<R> combineLatest(u<? extends T>[] uVarArr, io.reactivex.b.o<? super Object[], ? extends R> oVar) {
        return combineLatest(uVarArr, oVar, bufferSize());
    }

    public static <T> p<T> concat(u<? extends T> uVar, u<? extends T> uVar2) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        return concatArray(uVar, uVar2);
    }

    public static <T, S> p<T> generate(Callable<S> callable, io.reactivex.b.b<S, d<T>> bVar, io.reactivex.b.g<? super S> gVar) {
        io.reactivex.internal.functions.a.a(bVar, "generator is null");
        return generate(callable, T.a(bVar), gVar);
    }

    public final <U extends Collection<? super T>> p<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, callable);
    }

    public final p<T> concatWith(c cVar) {
        io.reactivex.internal.functions.a.a(cVar, "other is null");
        return io.reactivex.e.a.a(new ObservableConcatWithCompletable(this, cVar));
    }

    public final p<T> mergeWith(c cVar) {
        io.reactivex.internal.functions.a.a(cVar, "other is null");
        return io.reactivex.e.a.a(new ObservableMergeWithCompletable(this, cVar));
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar, int i, long j, TimeUnit timeUnit) {
        return replay(oVar, i, j, timeUnit, io.reactivex.f.b.a());
    }

    public final p<T> skipLast(long j, TimeUnit timeUnit, x xVar, boolean z) {
        return skipLast(j, timeUnit, xVar, z, bufferSize());
    }

    public final p<T> takeLast(long j, long j2, TimeUnit timeUnit, x xVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        if (j >= 0) {
            return io.reactivex.e.a.a(new ObservableTakeLastTimed(this, j, j2, timeUnit, xVar, i, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j);
    }

    public final p<T> timeout(long j, TimeUnit timeUnit, x xVar, u<? extends T> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "other is null");
        return timeout0(j, timeUnit, uVar, xVar);
    }

    public final p<p<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, io.reactivex.f.b.a(), bufferSize());
    }

    public final <U, R> p<R> zipWith(u<? extends U> uVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, boolean z, int i) {
        return zip(this, uVar, cVar, z, i);
    }

    public static <T, R> p<R> combineLatest(u<? extends T>[] uVarArr, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i) {
        io.reactivex.internal.functions.a.a(uVarArr, "sources is null");
        if (uVarArr.length == 0) {
            return empty();
        }
        io.reactivex.internal.functions.a.a(oVar, "combiner is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableCombineLatest(uVarArr, null, oVar, i << 1, false));
    }

    public static <T, R> p<R> combineLatestDelayError(Iterable<? extends u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar) {
        return combineLatestDelayError(iterable, oVar, bufferSize());
    }

    public static <T> y<Boolean> sequenceEqual(u<? extends T> uVar, u<? extends T> uVar2, int i) {
        return sequenceEqual(uVar, uVar2, io.reactivex.internal.functions.a.a(), i);
    }

    public final p<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return (p<List<T>>) buffer(j, j2, timeUnit, io.reactivex.f.b.a(), ArrayListSupplier.asCallable());
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar, int i, long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return ObservableReplay.a(T.a(this, i, j, timeUnit, xVar), oVar);
    }

    public final p<T> retry(io.reactivex.b.q<? super Throwable> qVar) {
        return retry(Long.MAX_VALUE, qVar);
    }

    public final p<T> skipLast(long j, TimeUnit timeUnit, x xVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableSkipLastTimed(this, j, timeUnit, xVar, i << 1, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> y<Map<K, Collection<V>>> toMultimap(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, Callable<? extends Map<K, Collection<V>>> callable, io.reactivex.b.o<? super K, ? extends Collection<? super V>> oVar3) {
        io.reactivex.internal.functions.a.a(oVar, "keySelector is null");
        io.reactivex.internal.functions.a.a(oVar2, "valueSelector is null");
        io.reactivex.internal.functions.a.a(callable, "mapSupplier is null");
        io.reactivex.internal.functions.a.a(oVar3, "collectionFactory is null");
        return (y<Map<K, Collection<V>>>) collect(callable, Functions.a(oVar, oVar2, oVar3));
    }

    public final p<p<T>> window(long j, long j2, TimeUnit timeUnit, x xVar) {
        return window(j, j2, timeUnit, xVar, bufferSize());
    }

    public static <T, R> p<R> combineLatestDelayError(Iterable<? extends u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i) {
        io.reactivex.internal.functions.a.a(iterable, "sources is null");
        io.reactivex.internal.functions.a.a(oVar, "combiner is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableCombineLatest(null, iterable, oVar, i << 1, true));
    }

    public static <T> p<T> fromFuture(Future<? extends T> future, x xVar) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return fromFuture(future).subscribeOn(xVar);
    }

    public static <T, S> p<T> generate(Callable<S> callable, io.reactivex.b.c<S, d<T>, S> cVar) {
        return generate(callable, cVar, Functions.d());
    }

    public static <T> p<T> merge(u<? extends T> uVar, u<? extends T> uVar2) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        return fromArray(uVar, uVar2).flatMap(Functions.e(), false, 2);
    }

    public static <T> p<T> mergeDelayError(u<? extends T> uVar, u<? extends T> uVar2) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        return fromArray(uVar, uVar2).flatMap(Functions.e(), true, 2);
    }

    public static <T1, T2, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, io.reactivex.b.c<? super T1, ? super T2, ? extends R> cVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        return zipArray(Functions.a((io.reactivex.b.c) cVar), false, bufferSize(), uVar, uVar2);
    }

    public final p<List<T>> buffer(long j, long j2, TimeUnit timeUnit, x xVar) {
        return (p<List<T>>) buffer(j, j2, timeUnit, xVar, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> p<T> delay(u<U> uVar, io.reactivex.b.o<? super T, ? extends u<V>> oVar) {
        return delaySubscription(uVar).delay(oVar);
    }

    public final <U> p<T> sample(u<U> uVar) {
        io.reactivex.internal.functions.a.a(uVar, "sampler is null");
        return io.reactivex.e.a.a(new ObservableSampleWithObservable(this, uVar, false));
    }

    public final p<T> timeout(long j, TimeUnit timeUnit, x xVar) {
        return timeout0(j, timeUnit, null, xVar);
    }

    public final p<p<T>> window(long j, long j2, TimeUnit timeUnit, x xVar, int i) {
        io.reactivex.internal.functions.a.a(j, "timespan");
        io.reactivex.internal.functions.a.a(j2, "timeskip");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        return io.reactivex.e.a.a(new za(this, j, j2, timeUnit, xVar, Long.MAX_VALUE, i, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> p<R> withLatestFrom(u<T1> uVar, u<T2> uVar2, u<T3> uVar3, io.reactivex.b.i<? super T, ? super T1, ? super T2, ? super T3, R> iVar) {
        io.reactivex.internal.functions.a.a(uVar, "o1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "o2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "o3 is null");
        io.reactivex.internal.functions.a.a(iVar, "combiner is null");
        return withLatestFrom((u<?>[]) new u[]{uVar, uVar2, uVar3}, Functions.a((io.reactivex.b.i) iVar));
    }

    public static <T> p<T> concat(u<? extends T> uVar, u<? extends T> uVar2, u<? extends T> uVar3) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        return concatArray(uVar, uVar2, uVar3);
    }

    public static <T, S> p<T> generate(Callable<S> callable, io.reactivex.b.c<S, d<T>, S> cVar, io.reactivex.b.g<? super S> gVar) {
        io.reactivex.internal.functions.a.a(callable, "initialState is null");
        io.reactivex.internal.functions.a.a(cVar, "generator is null");
        io.reactivex.internal.functions.a.a(gVar, "disposeState is null");
        return io.reactivex.e.a.a(new O(callable, cVar, gVar));
    }

    public static <T> p<T> just(T t, T t2, T t3, T t4) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        io.reactivex.internal.functions.a.a((Object) t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    public final <U extends Collection<? super T>> p<U> buffer(long j, long j2, TimeUnit timeUnit, x xVar, Callable<U> callable) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(callable, "bufferSupplier is null");
        return io.reactivex.e.a.a(new C2916l(this, j, j2, timeUnit, xVar, callable, Integer.MAX_VALUE, false));
    }

    public final <U, V> p<T> timeout(u<U> uVar, io.reactivex.b.o<? super T, ? extends u<V>> oVar) {
        io.reactivex.internal.functions.a.a(uVar, "firstTimeoutIndicator is null");
        return timeout0(uVar, oVar, null);
    }

    public final p<T> doOnEach(w<? super T> wVar) {
        io.reactivex.internal.functions.a.a(wVar, "observer is null");
        return doOnEach(T.c(wVar), T.b(wVar), T.a(wVar), Functions.f21804c);
    }

    public final <U> p<T> sample(u<U> uVar, boolean z) {
        io.reactivex.internal.functions.a.a(uVar, "sampler is null");
        return io.reactivex.e.a.a(new ObservableSampleWithObservable(this, uVar, z));
    }

    @Override // io.reactivex.u
    public final void subscribe(w<? super T> wVar) {
        io.reactivex.internal.functions.a.a(wVar, "observer is null");
        try {
            w<? super T> wVarA = io.reactivex.e.a.a(this, wVar);
            io.reactivex.internal.functions.a.a(wVarA, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(wVarA);
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

    public static <T> p<T> merge(u<? extends T> uVar, u<? extends T> uVar2, u<? extends T> uVar3) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        return fromArray(uVar, uVar2, uVar3).flatMap(Functions.e(), false, 3);
    }

    public static <T> p<T> mergeDelayError(u<? extends T> uVar, u<? extends T> uVar2, u<? extends T> uVar3) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        return fromArray(uVar, uVar2, uVar3).flatMap(Functions.e(), true, 3);
    }

    public static <T1, T2, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, io.reactivex.b.c<? super T1, ? super T2, ? extends R> cVar, boolean z) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        return zipArray(Functions.a((io.reactivex.b.c) cVar), z, bufferSize(), uVar, uVar2);
    }

    public final <R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, io.reactivex.b.o<? super Throwable, ? extends u<? extends R>> oVar2, Callable<? extends u<? extends R>> callable) {
        io.reactivex.internal.functions.a.a(oVar, "onNextMapper is null");
        io.reactivex.internal.functions.a.a(oVar2, "onErrorMapper is null");
        io.reactivex.internal.functions.a.a(callable, "onCompleteSupplier is null");
        return merge(new Z(this, oVar, oVar2, callable));
    }

    public final p<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, io.reactivex.f.b.d(), false, bufferSize());
    }

    public final <U, V> p<T> timeout(u<U> uVar, io.reactivex.b.o<? super T, ? extends u<V>> oVar, u<? extends T> uVar2) {
        io.reactivex.internal.functions.a.a(uVar, "firstTimeoutIndicator is null");
        io.reactivex.internal.functions.a.a(uVar2, "other is null");
        return timeout0(uVar, oVar, uVar2);
    }

    public final p<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, io.reactivex.f.b.d(), z, bufferSize());
    }

    public final <K, V> y<Map<K, Collection<V>>> toMultimap(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(oVar, oVar2, callable, ArrayListSupplier.asFunction());
    }

    public static <T1, T2, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, io.reactivex.b.c<? super T1, ? super T2, ? extends R> cVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        return combineLatest(Functions.a((io.reactivex.b.c) cVar), bufferSize(), uVar, uVar2);
    }

    public static <T> p<T> concat(u<? extends T> uVar, u<? extends T> uVar2, u<? extends T> uVar3, u<? extends T> uVar4) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        return concatArray(uVar, uVar2, uVar3, uVar4);
    }

    public final p<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, io.reactivex.f.b.a(), Integer.MAX_VALUE);
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar, int i, x xVar) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return ObservableReplay.a(T.a(this, i), T.a(oVar, xVar));
    }

    public final p<T> takeLast(long j, TimeUnit timeUnit, x xVar) {
        return takeLast(j, timeUnit, xVar, false, bufferSize());
    }

    public static <T> p<T> just(T t, T t2, T t3, T t4, T t5) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        io.reactivex.internal.functions.a.a((Object) t4, "item4 is null");
        io.reactivex.internal.functions.a.a((Object) t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T1, T2, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, io.reactivex.b.c<? super T1, ? super T2, ? extends R> cVar, boolean z, int i) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        return zipArray(Functions.a((io.reactivex.b.c) cVar), z, i, uVar, uVar2);
    }

    public final p<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, io.reactivex.f.b.a(), i);
    }

    public final p<T> takeLast(long j, TimeUnit timeUnit, x xVar, boolean z) {
        return takeLast(j, timeUnit, xVar, z, bufferSize());
    }

    public final p<p<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, io.reactivex.f.b.a(), Long.MAX_VALUE, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> p<R> withLatestFrom(u<T1> uVar, u<T2> uVar2, u<T3> uVar3, u<T4> uVar4, io.reactivex.b.j<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> jVar) {
        io.reactivex.internal.functions.a.a(uVar, "o1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "o2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "o3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "o4 is null");
        io.reactivex.internal.functions.a.a(jVar, "combiner is null");
        return withLatestFrom((u<?>[]) new u[]{uVar, uVar2, uVar3, uVar4}, Functions.a((io.reactivex.b.j) jVar));
    }

    public static <T> p<T> merge(u<? extends T> uVar, u<? extends T> uVar2, u<? extends T> uVar3, u<? extends T> uVar4) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        return fromArray(uVar, uVar2, uVar3, uVar4).flatMap(Functions.e(), false, 4);
    }

    public static <T> p<T> mergeDelayError(u<? extends T> uVar, u<? extends T> uVar2, u<? extends T> uVar3, u<? extends T> uVar4) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        return fromArray(uVar, uVar2, uVar3, uVar4).flatMap(Functions.e(), true, 4);
    }

    public final p<List<T>> buffer(long j, TimeUnit timeUnit, x xVar, int i) {
        return (p<List<T>>) buffer(j, timeUnit, xVar, i, ArrayListSupplier.asCallable(), false);
    }

    public final <R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, io.reactivex.b.o<Throwable, ? extends u<? extends R>> oVar2, Callable<? extends u<? extends R>> callable, int i) {
        io.reactivex.internal.functions.a.a(oVar, "onNextMapper is null");
        io.reactivex.internal.functions.a.a(oVar2, "onErrorMapper is null");
        io.reactivex.internal.functions.a.a(callable, "onCompleteSupplier is null");
        return merge(new Z(this, oVar, oVar2, callable), i);
    }

    public final p<T> takeLast(long j, TimeUnit timeUnit, x xVar, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, xVar, z, i);
    }

    public final p<p<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, io.reactivex.f.b.a(), j2, false);
    }

    public static <T1, T2, T3, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, io.reactivex.b.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        return combineLatest(Functions.a((io.reactivex.b.h) hVar), bufferSize(), uVar, uVar2, uVar3);
    }

    public final <U extends Collection<? super T>> p<U> buffer(long j, TimeUnit timeUnit, x xVar, int i, Callable<U> callable, boolean z) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(callable, "bufferSupplier is null");
        io.reactivex.internal.functions.a.a(i, "count");
        return io.reactivex.e.a.a(new C2916l(this, j, j, timeUnit, xVar, callable, i, z));
    }

    public final p<p<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, io.reactivex.f.b.a(), j2, z);
    }

    public static <T1, T2, T3, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, io.reactivex.b.h<? super T1, ? super T2, ? super T3, ? extends R> hVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        return zipArray(Functions.a((io.reactivex.b.h) hVar), false, bufferSize(), uVar, uVar2, uVar3);
    }

    public final p<p<T>> window(long j, TimeUnit timeUnit, x xVar) {
        return window(j, timeUnit, xVar, Long.MAX_VALUE, false);
    }

    public final p<p<T>> window(long j, TimeUnit timeUnit, x xVar, long j2) {
        return window(j, timeUnit, xVar, j2, false);
    }

    public final <R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends R>> oVar, int i) {
        return flatMap((io.reactivex.b.o) oVar, false, i, bufferSize());
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar, long j, TimeUnit timeUnit) {
        return replay(oVar, j, timeUnit, io.reactivex.f.b.a());
    }

    public final p<p<T>> window(long j, TimeUnit timeUnit, x xVar, long j2, boolean z) {
        return window(j, timeUnit, xVar, j2, z, bufferSize());
    }

    public static <T1, T2, T3, T4, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, io.reactivex.b.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        return combineLatest(Functions.a((io.reactivex.b.i) iVar), bufferSize(), uVar, uVar2, uVar3, uVar4);
    }

    public static <T> p<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        io.reactivex.internal.functions.a.a((Object) t4, "item4 is null");
        io.reactivex.internal.functions.a.a((Object) t5, "item5 is null");
        io.reactivex.internal.functions.a.a((Object) t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public final <U, R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends U>> oVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar) {
        return flatMap(oVar, cVar, false, bufferSize(), bufferSize());
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar, long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return ObservableReplay.a(T.a(this, j, timeUnit, xVar), oVar);
    }

    public final p<p<T>> window(long j, TimeUnit timeUnit, x xVar, long j2, boolean z, int i) {
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(j2, "count");
        return io.reactivex.e.a.a(new za(this, j, j, timeUnit, xVar, j2, i, z));
    }

    public static <T1, T2, T3, T4, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, io.reactivex.b.i<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> iVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        return zipArray(Functions.a((io.reactivex.b.i) iVar), false, bufferSize(), uVar, uVar2, uVar3, uVar4);
    }

    public final p<List<T>> buffer(long j, TimeUnit timeUnit, x xVar) {
        return (p<List<T>>) buffer(j, timeUnit, xVar, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final <U, R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends U>> oVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, boolean z) {
        return flatMap(oVar, cVar, z, bufferSize(), bufferSize());
    }

    public final <R> p<R> withLatestFrom(u<?>[] uVarArr, io.reactivex.b.o<? super Object[], R> oVar) {
        io.reactivex.internal.functions.a.a(uVarArr, "others is null");
        io.reactivex.internal.functions.a.a(oVar, "combiner is null");
        return io.reactivex.e.a.a(new ObservableWithLatestFromMany(this, uVarArr, oVar));
    }

    public final <TOpening, TClosing> p<List<T>> buffer(u<? extends TOpening> uVar, io.reactivex.b.o<? super TOpening, ? extends u<? extends TClosing>> oVar) {
        return (p<List<T>>) buffer(uVar, oVar, ArrayListSupplier.asCallable());
    }

    public final <U, R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends U>> oVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, boolean z, int i) {
        return flatMap(oVar, cVar, z, i, bufferSize());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> p<U> buffer(u<? extends TOpening> uVar, io.reactivex.b.o<? super TOpening, ? extends u<? extends TClosing>> oVar, Callable<U> callable) {
        io.reactivex.internal.functions.a.a(uVar, "openingIndicator is null");
        io.reactivex.internal.functions.a.a(oVar, "closingIndicator is null");
        io.reactivex.internal.functions.a.a(callable, "bufferSupplier is null");
        return io.reactivex.e.a.a(new ObservableBufferBoundary(this, uVar, oVar, callable));
    }

    public final <U, R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends U>> oVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, boolean z, int i, int i2) {
        io.reactivex.internal.functions.a.a(oVar, "mapper is null");
        io.reactivex.internal.functions.a.a(cVar, "combiner is null");
        return flatMap(T.a(oVar, cVar), z, i, i2);
    }

    public final <R> p<R> replay(io.reactivex.b.o<? super p<T>, ? extends u<R>> oVar, x xVar) {
        io.reactivex.internal.functions.a.a(oVar, "selector is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return ObservableReplay.a(T.a(this), T.a(oVar, xVar));
    }

    public final <R> p<R> withLatestFrom(Iterable<? extends u<?>> iterable, io.reactivex.b.o<? super Object[], R> oVar) {
        io.reactivex.internal.functions.a.a(iterable, "others is null");
        io.reactivex.internal.functions.a.a(oVar, "combiner is null");
        return io.reactivex.e.a.a(new ObservableWithLatestFromMany(this, iterable, oVar));
    }

    public static <T1, T2, T3, T4, T5, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, io.reactivex.b.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        return combineLatest(Functions.a((io.reactivex.b.j) jVar), bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5);
    }

    public final <B> p<p<T>> window(u<B> uVar) {
        return window(uVar, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, io.reactivex.b.j<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> jVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        return zipArray(Functions.a((io.reactivex.b.j) jVar), false, bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5);
    }

    public final <U, R> p<R> flatMap(io.reactivex.b.o<? super T, ? extends u<? extends U>> oVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, int i) {
        return flatMap(oVar, cVar, false, i, bufferSize());
    }

    public final <B> p<p<T>> window(u<B> uVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "boundary is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableWindowBoundary(this, uVar, i));
    }

    public static <T> p<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        io.reactivex.internal.functions.a.a((Object) t4, "item4 is null");
        io.reactivex.internal.functions.a.a((Object) t5, "item5 is null");
        io.reactivex.internal.functions.a.a((Object) t6, "item6 is null");
        io.reactivex.internal.functions.a.a((Object) t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public final <B> p<List<T>> buffer(u<B> uVar) {
        return (p<List<T>>) buffer(uVar, ArrayListSupplier.asCallable());
    }

    public final <B> p<List<T>> buffer(u<B> uVar, int i) {
        io.reactivex.internal.functions.a.a(i, "initialCapacity");
        return (p<List<T>>) buffer(uVar, Functions.a(i));
    }

    public final io.reactivex.d.a<T> replay(int i) {
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return ObservableReplay.a(this, i);
    }

    public final <U, V> p<p<T>> window(u<U> uVar, io.reactivex.b.o<? super U, ? extends u<V>> oVar) {
        return window(uVar, oVar, bufferSize());
    }

    public final <B, U extends Collection<? super T>> p<U> buffer(u<B> uVar, Callable<U> callable) {
        io.reactivex.internal.functions.a.a(uVar, "boundary is null");
        io.reactivex.internal.functions.a.a(callable, "bufferSupplier is null");
        return io.reactivex.e.a.a(new C2915k(this, uVar, callable));
    }

    public final <U, V> p<p<T>> window(u<U> uVar, io.reactivex.b.o<? super U, ? extends u<V>> oVar, int i) {
        io.reactivex.internal.functions.a.a(uVar, "openingIndicator is null");
        io.reactivex.internal.functions.a.a(oVar, "closingIndicator is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ya(this, uVar, oVar, i));
    }

    public static <T1, T2, T3, T4, T5, T6, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, io.reactivex.b.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        return combineLatest(Functions.a((io.reactivex.b.k) kVar), bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6);
    }

    public final io.reactivex.d.a<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, io.reactivex.f.b.a());
    }

    public static <T1, T2, T3, T4, T5, T6, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, io.reactivex.b.k<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> kVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        return zipArray(Functions.a((io.reactivex.b.k) kVar), false, bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6);
    }

    public final io.reactivex.d.a<T> replay(int i, long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return ObservableReplay.a(this, j, timeUnit, xVar, i);
    }

    public final <B> p<List<T>> buffer(Callable<? extends u<B>> callable) {
        return (p<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    public final <B, U extends Collection<? super T>> p<U> buffer(Callable<? extends u<B>> callable, Callable<U> callable2) {
        io.reactivex.internal.functions.a.a(callable, "boundarySupplier is null");
        io.reactivex.internal.functions.a.a(callable2, "bufferSupplier is null");
        return io.reactivex.e.a.a(new C2914j(this, callable, callable2));
    }

    public final <B> p<p<T>> window(Callable<? extends u<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> p<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        io.reactivex.internal.functions.a.a((Object) t4, "item4 is null");
        io.reactivex.internal.functions.a.a((Object) t5, "item5 is null");
        io.reactivex.internal.functions.a.a((Object) t6, "item6 is null");
        io.reactivex.internal.functions.a.a((Object) t7, "item7 is null");
        io.reactivex.internal.functions.a.a((Object) t8, "item8 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    public final <B> p<p<T>> window(Callable<? extends u<B>> callable, int i) {
        io.reactivex.internal.functions.a.a(callable, "boundary is null");
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableWindowBoundarySupplier(this, callable, i));
    }

    public final io.reactivex.d.a<T> replay(int i, x xVar) {
        io.reactivex.internal.functions.a.a(i, "bufferSize");
        return ObservableReplay.a(replay(i), xVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, u<? extends T7> uVar7, io.reactivex.b.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        io.reactivex.internal.functions.a.a(uVar7, "source7 is null");
        return combineLatest(Functions.a((io.reactivex.b.l) lVar), bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7);
    }

    public final io.reactivex.d.a<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, io.reactivex.f.b.a());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, u<? extends T7> uVar7, io.reactivex.b.l<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> lVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        io.reactivex.internal.functions.a.a(uVar7, "source7 is null");
        return zipArray(Functions.a((io.reactivex.b.l) lVar), false, bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7);
    }

    public final io.reactivex.d.a<T> replay(long j, TimeUnit timeUnit, x xVar) {
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return ObservableReplay.a(this, j, timeUnit, xVar);
    }

    public final io.reactivex.d.a<T> replay(x xVar) {
        io.reactivex.internal.functions.a.a(xVar, "scheduler is null");
        return ObservableReplay.a(replay(), xVar);
    }

    public static <T> p<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        io.reactivex.internal.functions.a.a((Object) t4, "item4 is null");
        io.reactivex.internal.functions.a.a((Object) t5, "item5 is null");
        io.reactivex.internal.functions.a.a((Object) t6, "item6 is null");
        io.reactivex.internal.functions.a.a((Object) t7, "item7 is null");
        io.reactivex.internal.functions.a.a((Object) t8, "item8 is null");
        io.reactivex.internal.functions.a.a((Object) t9, "item9 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, u<? extends T7> uVar7, u<? extends T8> uVar8, io.reactivex.b.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        io.reactivex.internal.functions.a.a(uVar7, "source7 is null");
        io.reactivex.internal.functions.a.a(uVar8, "source8 is null");
        return combineLatest(Functions.a((io.reactivex.b.m) mVar), bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, u<? extends T7> uVar7, u<? extends T8> uVar8, io.reactivex.b.m<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> mVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        io.reactivex.internal.functions.a.a(uVar7, "source7 is null");
        io.reactivex.internal.functions.a.a(uVar8, "source8 is null");
        return zipArray(Functions.a((io.reactivex.b.m) mVar), false, bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8);
    }

    public static <T> p<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        io.reactivex.internal.functions.a.a((Object) t, "item1 is null");
        io.reactivex.internal.functions.a.a((Object) t2, "item2 is null");
        io.reactivex.internal.functions.a.a((Object) t3, "item3 is null");
        io.reactivex.internal.functions.a.a((Object) t4, "item4 is null");
        io.reactivex.internal.functions.a.a((Object) t5, "item5 is null");
        io.reactivex.internal.functions.a.a((Object) t6, "item6 is null");
        io.reactivex.internal.functions.a.a((Object) t7, "item7 is null");
        io.reactivex.internal.functions.a.a((Object) t8, "item8 is null");
        io.reactivex.internal.functions.a.a((Object) t9, "item9 is null");
        io.reactivex.internal.functions.a.a((Object) t10, "item10 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> p<R> combineLatest(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, u<? extends T7> uVar7, u<? extends T8> uVar8, u<? extends T9> uVar9, io.reactivex.b.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        io.reactivex.internal.functions.a.a(uVar7, "source7 is null");
        io.reactivex.internal.functions.a.a(uVar8, "source8 is null");
        io.reactivex.internal.functions.a.a(uVar9, "source9 is null");
        return combineLatest(Functions.a((io.reactivex.b.n) nVar), bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8, uVar9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> p<R> zip(u<? extends T1> uVar, u<? extends T2> uVar2, u<? extends T3> uVar3, u<? extends T4> uVar4, u<? extends T5> uVar5, u<? extends T6> uVar6, u<? extends T7> uVar7, u<? extends T8> uVar8, u<? extends T9> uVar9, io.reactivex.b.n<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> nVar) {
        io.reactivex.internal.functions.a.a(uVar, "source1 is null");
        io.reactivex.internal.functions.a.a(uVar2, "source2 is null");
        io.reactivex.internal.functions.a.a(uVar3, "source3 is null");
        io.reactivex.internal.functions.a.a(uVar4, "source4 is null");
        io.reactivex.internal.functions.a.a(uVar5, "source5 is null");
        io.reactivex.internal.functions.a.a(uVar6, "source6 is null");
        io.reactivex.internal.functions.a.a(uVar7, "source7 is null");
        io.reactivex.internal.functions.a.a(uVar8, "source8 is null");
        io.reactivex.internal.functions.a.a(uVar9, "source9 is null");
        return zipArray(Functions.a((io.reactivex.b.n) nVar), false, bufferSize(), uVar, uVar2, uVar3, uVar4, uVar5, uVar6, uVar7, uVar8, uVar9);
    }
}
