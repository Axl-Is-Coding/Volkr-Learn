package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableMap.java */
/* JADX INFO: loaded from: classes5.dex */
public final class Y<T, U> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends U> f22348b;

    /* JADX INFO: compiled from: ObservableMap.java */
    static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final io.reactivex.b.o<? super T, ? extends U> f22349f;

        a(io.reactivex.w<? super U> wVar, io.reactivex.b.o<? super T, ? extends U> oVar) {
            super(wVar);
            this.f22349f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f21839d) {
                return;
            }
            if (this.f21840e != 0) {
                this.f21836a.onNext(null);
                return;
            }
            try {
                U uApply = this.f22349f.apply(t);
                io.reactivex.internal.functions.a.a(uApply, "The mapper function returned a null value.");
                this.f21836a.onNext((Object) uApply);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public U poll() throws Exception {
            T tPoll = this.f21838c.poll();
            if (tPoll == null) {
                return null;
            }
            U uApply = this.f22349f.apply(tPoll);
            io.reactivex.internal.functions.a.a(uApply, "The mapper function returned a null value.");
            return uApply;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public Y(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends U> oVar) {
        super(uVar);
        this.f22348b = oVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super U> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22348b));
    }
}
