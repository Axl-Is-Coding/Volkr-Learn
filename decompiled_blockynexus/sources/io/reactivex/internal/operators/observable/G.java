package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableFilter.java */
/* JADX INFO: loaded from: classes5.dex */
public final class G<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22024b;

    /* JADX INFO: compiled from: ObservableFilter.java */
    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22025f;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.q<? super T> qVar) {
            super(wVar);
            this.f22025f = qVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f21840e != 0) {
                this.f21836a.onNext(null);
                return;
            }
            try {
                if (this.f22025f.test(t)) {
                    this.f21836a.onNext((Object) t);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll;
            do {
                tPoll = this.f21838c.poll();
                if (tPoll == null) {
                    break;
                }
            } while (!this.f22025f.test(tPoll));
            return tPoll;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public G(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        super(uVar);
        this.f22024b = qVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22024b));
    }
}
