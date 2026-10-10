package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDistinctUntilChanged.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2927x<T, K> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, K> f22593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.d<? super K, ? super K> f22594c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.x$a */
    /* JADX INFO: compiled from: ObservableDistinctUntilChanged.java */
    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final io.reactivex.b.o<? super T, K> f22595f;
        final io.reactivex.b.d<? super K, ? super K> g;
        K h;
        boolean i;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super T, K> oVar, io.reactivex.b.d<? super K, ? super K> dVar) {
            super(wVar);
            this.f22595f = oVar;
            this.g = dVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f21839d) {
                return;
            }
            if (this.f21840e != 0) {
                this.f21836a.onNext((Object) t);
                return;
            }
            try {
                K kApply = this.f22595f.apply(t);
                if (this.i) {
                    boolean zTest = this.g.test(this.h, kApply);
                    this.h = kApply;
                    if (zTest) {
                        return;
                    }
                } else {
                    this.i = true;
                    this.h = kApply;
                }
                this.f21836a.onNext((Object) t);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            while (true) {
                T tPoll = this.f21838c.poll();
                if (tPoll == null) {
                    return null;
                }
                K kApply = this.f22595f.apply(tPoll);
                if (!this.i) {
                    this.i = true;
                    this.h = kApply;
                    return tPoll;
                }
                if (!this.g.test(this.h, kApply)) {
                    this.h = kApply;
                    return tPoll;
                }
                this.h = kApply;
            }
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public C2927x(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, K> oVar, io.reactivex.b.d<? super K, ? super K> dVar) {
        super(uVar);
        this.f22593b = oVar;
        this.f22594c = dVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22593b, this.f22594c));
    }
}
