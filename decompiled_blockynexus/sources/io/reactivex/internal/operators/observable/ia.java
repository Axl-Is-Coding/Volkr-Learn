package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableScan.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ia<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.c<T, T, T> f22431b;

    /* JADX INFO: compiled from: ObservableScan.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.c<T, T, T> f22433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f22435d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22436e;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.c<T, T, T> cVar) {
            this.f22432a = wVar;
            this.f22433b = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22434c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22434c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22436e) {
                return;
            }
            this.f22436e = true;
            this.f22432a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22436e) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22436e = true;
                this.f22432a.onError(th);
            }
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.Object] */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22436e) {
                return;
            }
            io.reactivex.w<? super T> wVar = this.f22432a;
            T t2 = this.f22435d;
            if (t2 == null) {
                this.f22435d = t;
                wVar.onNext(t);
                return;
            }
            try {
                T tApply = this.f22433b.apply(t2, t);
                io.reactivex.internal.functions.a.a((Object) tApply, "The value returned by the accumulator is null");
                this.f22435d = tApply;
                wVar.onNext(tApply);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22434c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22434c, bVar)) {
                this.f22434c = bVar;
                this.f22432a.onSubscribe(this);
            }
        }
    }

    public ia(io.reactivex.u<T> uVar, io.reactivex.b.c<T, T, T> cVar) {
        super(uVar);
        this.f22431b = cVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22431b));
    }
}
