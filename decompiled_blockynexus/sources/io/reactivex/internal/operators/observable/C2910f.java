package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableAllSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2910f<T> extends io.reactivex.y<Boolean> implements io.reactivex.c.a.b<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22398b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.f$a */
    /* JADX INFO: compiled from: ObservableAllSingle.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super Boolean> f22399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22402d;

        a(io.reactivex.z<? super Boolean> zVar, io.reactivex.b.q<? super T> qVar) {
            this.f22399a = zVar;
            this.f22400b = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22401c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22401c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22402d) {
                return;
            }
            this.f22402d = true;
            this.f22399a.onSuccess(true);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22402d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22402d = true;
                this.f22399a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22402d) {
                return;
            }
            try {
                if (this.f22400b.test(t)) {
                    return;
                }
                this.f22402d = true;
                this.f22401c.dispose();
                this.f22399a.onSuccess(false);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22401c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22401c, bVar)) {
                this.f22401c = bVar;
                this.f22399a.onSubscribe(this);
            }
        }
    }

    public C2910f(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        this.f22397a = uVar;
        this.f22398b = qVar;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<Boolean> a() {
        return io.reactivex.e.a.a(new C2909e(this.f22397a, this.f22398b));
    }

    @Override // io.reactivex.y
    protected void b(io.reactivex.z<? super Boolean> zVar) {
        this.f22397a.subscribe(new a(zVar, this.f22398b));
    }
}
