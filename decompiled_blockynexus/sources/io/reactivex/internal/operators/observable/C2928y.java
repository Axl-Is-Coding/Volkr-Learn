package io.reactivex.internal.operators.observable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDoAfterNext.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2928y<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.g<? super T> f22601b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.y$a */
    /* JADX INFO: compiled from: ObservableDoAfterNext.java */
    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final io.reactivex.b.g<? super T> f22602f;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.g<? super T> gVar) {
            super(wVar);
            this.f22602f = gVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f21836a.onNext((Object) t);
            if (this.f21840e == 0) {
                try {
                    this.f22602f.accept(t);
                } catch (Throwable th) {
                    a(th);
                }
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll = this.f21838c.poll();
            if (tPoll != null) {
                this.f22602f.accept(tPoll);
            }
            return tPoll;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public C2928y(io.reactivex.u<T> uVar, io.reactivex.b.g<? super T> gVar) {
        super(uVar);
        this.f22601b = gVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22601b));
    }
}
