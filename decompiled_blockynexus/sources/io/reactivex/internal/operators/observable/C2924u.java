package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDematerialize.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2924u<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.n<R>> f22567b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.u$a */
    /* JADX INFO: compiled from: ObservableDematerialize.java */
    static final class a<T, R> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super R> f22568a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.o<? super T, ? extends io.reactivex.n<R>> f22569b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22570c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        io.reactivex.disposables.b f22571d;

        a(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.n<R>> oVar) {
            this.f22568a = wVar;
            this.f22569b = oVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22571d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22571d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22570c) {
                return;
            }
            this.f22570c = true;
            this.f22568a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22570c) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22570c = true;
                this.f22568a.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22570c) {
                if (t instanceof io.reactivex.n) {
                    io.reactivex.n nVar = (io.reactivex.n) t;
                    if (nVar.e()) {
                        io.reactivex.e.a.b(nVar.b());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                io.reactivex.n<R> nVarApply = this.f22569b.apply(t);
                io.reactivex.internal.functions.a.a(nVarApply, "The selector returned a null Notification");
                io.reactivex.n<R> nVar2 = nVarApply;
                if (nVar2.e()) {
                    this.f22571d.dispose();
                    onError(nVar2.b());
                } else if (!nVar2.d()) {
                    this.f22568a.onNext(nVar2.c());
                } else {
                    this.f22571d.dispose();
                    onComplete();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22571d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22571d, bVar)) {
                this.f22571d = bVar;
                this.f22568a.onSubscribe(this);
            }
        }
    }

    public C2924u(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.n<R>> oVar) {
        super(uVar);
        this.f22567b = oVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super R> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22567b));
    }
}
