package io.reactivex.internal.operators.observable;

import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ObservableInternalHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public final class T {

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class a<T> implements Callable<io.reactivex.d.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.p<T> f22310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22311b;

        a(io.reactivex.p<T> pVar, int i) {
            this.f22310a = pVar;
            this.f22311b = i;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.d.a<T> call() {
            return this.f22310a.replay(this.f22311b);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class b<T> implements Callable<io.reactivex.d.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.p<T> f22312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f22314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TimeUnit f22315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final io.reactivex.x f22316e;

        b(io.reactivex.p<T> pVar, int i, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            this.f22312a = pVar;
            this.f22313b = i;
            this.f22314c = j;
            this.f22315d = timeUnit;
            this.f22316e = xVar;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.d.a<T> call() {
            return this.f22312a.replay(this.f22313b, this.f22314c, this.f22315d, this.f22316e);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class c<T, U> implements io.reactivex.b.o<T, io.reactivex.u<U>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.o<? super T, ? extends Iterable<? extends U>> f22317a;

        c(io.reactivex.b.o<? super T, ? extends Iterable<? extends U>> oVar) {
            this.f22317a = oVar;
        }

        @Override // io.reactivex.b.o
        public io.reactivex.u<U> apply(T t) throws Exception {
            Iterable<? extends U> iterableApply = this.f22317a.apply(t);
            io.reactivex.internal.functions.a.a(iterableApply, "The mapper returned a null Iterable");
            return new L(iterableApply);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class d<U, R, T> implements io.reactivex.b.o<U, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.c<? super T, ? super U, ? extends R> f22318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final T f22319b;

        d(io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, T t) {
            this.f22318a = cVar;
            this.f22319b = t;
        }

        @Override // io.reactivex.b.o
        public R apply(U u) throws Exception {
            return this.f22318a.apply(this.f22319b, u);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class e<T, R, U> implements io.reactivex.b.o<T, io.reactivex.u<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.c<? super T, ? super U, ? extends R> f22320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> f22321b;

        e(io.reactivex.b.c<? super T, ? super U, ? extends R> cVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> oVar) {
            this.f22320a = cVar;
            this.f22321b = oVar;
        }

        @Override // io.reactivex.b.o
        public io.reactivex.u<R> apply(T t) throws Exception {
            io.reactivex.u<? extends U> uVarApply = this.f22321b.apply(t);
            io.reactivex.internal.functions.a.a(uVarApply, "The mapper returned a null ObservableSource");
            return new Y(uVarApply, new d(this.f22320a, t));
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class f<T, U> implements io.reactivex.b.o<T, io.reactivex.u<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<U>> f22322a;

        f(io.reactivex.b.o<? super T, ? extends io.reactivex.u<U>> oVar) {
            this.f22322a = oVar;
        }

        @Override // io.reactivex.b.o
        public io.reactivex.u<T> apply(T t) throws Exception {
            io.reactivex.u<U> uVarApply = this.f22322a.apply(t);
            io.reactivex.internal.functions.a.a(uVarApply, "The itemDelay returned a null ObservableSource");
            return new ra(uVarApply, 1L).map(Functions.c(t)).defaultIfEmpty(t);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class g<T> implements io.reactivex.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<T> f22323a;

        g(io.reactivex.w<T> wVar) {
            this.f22323a = wVar;
        }

        @Override // io.reactivex.b.a
        public void run() throws Exception {
            this.f22323a.onComplete();
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class h<T> implements io.reactivex.b.g<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<T> f22324a;

        h(io.reactivex.w<T> wVar) {
            this.f22324a = wVar;
        }

        @Override // io.reactivex.b.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f22324a.onError(th);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class i<T> implements io.reactivex.b.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<T> f22325a;

        i(io.reactivex.w<T> wVar) {
            this.f22325a = wVar;
        }

        @Override // io.reactivex.b.g
        public void accept(T t) throws Exception {
            this.f22325a.onNext(t);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class j<T> implements Callable<io.reactivex.d.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.p<T> f22326a;

        j(io.reactivex.p<T> pVar) {
            this.f22326a = pVar;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.d.a<T> call() {
            return this.f22326a.replay();
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class k<T, R> implements io.reactivex.b.o<io.reactivex.p<T>, io.reactivex.u<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.o<? super io.reactivex.p<T>, ? extends io.reactivex.u<R>> f22327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.x f22328b;

        k(io.reactivex.b.o<? super io.reactivex.p<T>, ? extends io.reactivex.u<R>> oVar, io.reactivex.x xVar) {
            this.f22327a = oVar;
            this.f22328b = xVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.u<R> apply(io.reactivex.p<T> pVar) throws Exception {
            io.reactivex.u<R> uVarApply = this.f22327a.apply(pVar);
            io.reactivex.internal.functions.a.a(uVarApply, "The selector returned a null ObservableSource");
            return io.reactivex.p.wrap(uVarApply).observeOn(this.f22328b);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class l<T, S> implements io.reactivex.b.c<S, io.reactivex.d<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.b<S, io.reactivex.d<T>> f22329a;

        l(io.reactivex.b.b<S, io.reactivex.d<T>> bVar) {
            this.f22329a = bVar;
        }

        public S a(S s, io.reactivex.d<T> dVar) throws Exception {
            this.f22329a.accept(s, dVar);
            return s;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.b.c
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            a(obj, (io.reactivex.d) obj2);
            return obj;
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class m<T, S> implements io.reactivex.b.c<S, io.reactivex.d<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.g<io.reactivex.d<T>> f22330a;

        m(io.reactivex.b.g<io.reactivex.d<T>> gVar) {
            this.f22330a = gVar;
        }

        public S a(S s, io.reactivex.d<T> dVar) throws Exception {
            this.f22330a.accept(dVar);
            return s;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.b.c
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            a(obj, (io.reactivex.d) obj2);
            return obj;
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class n<T> implements Callable<io.reactivex.d.a<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.p<T> f22331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f22332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final TimeUnit f22333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final io.reactivex.x f22334d;

        n(io.reactivex.p<T> pVar, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
            this.f22331a = pVar;
            this.f22332b = j;
            this.f22333c = timeUnit;
            this.f22334d = xVar;
        }

        @Override // java.util.concurrent.Callable
        public io.reactivex.d.a<T> call() {
            return this.f22331a.replay(this.f22332b, this.f22333c, this.f22334d);
        }
    }

    /* JADX INFO: compiled from: ObservableInternalHelper.java */
    static final class o<T, R> implements io.reactivex.b.o<List<io.reactivex.u<? extends T>>, io.reactivex.u<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.o<? super Object[], ? extends R> f22335a;

        o(io.reactivex.b.o<? super Object[], ? extends R> oVar) {
            this.f22335a = oVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.u<? extends R> apply(List<io.reactivex.u<? extends T>> list) {
            return io.reactivex.p.zipIterable(list, this.f22335a, false, io.reactivex.p.bufferSize());
        }
    }

    public static <T, S> io.reactivex.b.c<S, io.reactivex.d<T>, S> a(io.reactivex.b.g<io.reactivex.d<T>> gVar) {
        return new m(gVar);
    }

    public static <T, U> io.reactivex.b.o<T, io.reactivex.u<T>> b(io.reactivex.b.o<? super T, ? extends io.reactivex.u<U>> oVar) {
        return new f(oVar);
    }

    public static <T> io.reactivex.b.g<T> c(io.reactivex.w<T> wVar) {
        return new i(wVar);
    }

    public static <T, S> io.reactivex.b.c<S, io.reactivex.d<T>, S> a(io.reactivex.b.b<S, io.reactivex.d<T>> bVar) {
        return new l(bVar);
    }

    public static <T> io.reactivex.b.g<Throwable> b(io.reactivex.w<T> wVar) {
        return new h(wVar);
    }

    public static <T, R> io.reactivex.b.o<List<io.reactivex.u<? extends T>>, io.reactivex.u<? extends R>> c(io.reactivex.b.o<? super Object[], ? extends R> oVar) {
        return new o(oVar);
    }

    public static <T> io.reactivex.b.a a(io.reactivex.w<T> wVar) {
        return new g(wVar);
    }

    public static <T, U, R> io.reactivex.b.o<T, io.reactivex.u<R>> a(io.reactivex.b.o<? super T, ? extends io.reactivex.u<? extends U>> oVar, io.reactivex.b.c<? super T, ? super U, ? extends R> cVar) {
        return new e(cVar, oVar);
    }

    public static <T, U> io.reactivex.b.o<T, io.reactivex.u<U>> a(io.reactivex.b.o<? super T, ? extends Iterable<? extends U>> oVar) {
        return new c(oVar);
    }

    public static <T> Callable<io.reactivex.d.a<T>> a(io.reactivex.p<T> pVar) {
        return new j(pVar);
    }

    public static <T> Callable<io.reactivex.d.a<T>> a(io.reactivex.p<T> pVar, int i2) {
        return new a(pVar, i2);
    }

    public static <T> Callable<io.reactivex.d.a<T>> a(io.reactivex.p<T> pVar, int i2, long j2, TimeUnit timeUnit, io.reactivex.x xVar) {
        return new b(pVar, i2, j2, timeUnit, xVar);
    }

    public static <T> Callable<io.reactivex.d.a<T>> a(io.reactivex.p<T> pVar, long j2, TimeUnit timeUnit, io.reactivex.x xVar) {
        return new n(pVar, j2, timeUnit, xVar);
    }

    public static <T, R> io.reactivex.b.o<io.reactivex.p<T>, io.reactivex.u<R>> a(io.reactivex.b.o<? super io.reactivex.p<T>, ? extends io.reactivex.u<R>> oVar, io.reactivex.x xVar) {
        return new k(oVar, xVar);
    }
}
