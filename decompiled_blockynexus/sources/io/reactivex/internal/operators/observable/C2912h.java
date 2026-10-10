package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableAnySingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2912h<T> extends io.reactivex.y<Boolean> implements io.reactivex.c.a.b<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.q<? super T> f22423b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.h$a */
    /* JADX INFO: compiled from: ObservableAnySingle.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super Boolean> f22424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.q<? super T> f22425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22426c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22427d;

        a(io.reactivex.z<? super Boolean> zVar, io.reactivex.b.q<? super T> qVar) {
            this.f22424a = zVar;
            this.f22425b = qVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22426c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22426c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22427d) {
                return;
            }
            this.f22427d = true;
            this.f22424a.onSuccess(false);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22427d) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22427d = true;
                this.f22424a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22427d) {
                return;
            }
            try {
                if (this.f22425b.test(t)) {
                    this.f22427d = true;
                    this.f22426c.dispose();
                    this.f22424a.onSuccess(true);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22426c.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22426c, bVar)) {
                this.f22426c = bVar;
                this.f22424a.onSubscribe(this);
            }
        }
    }

    public C2912h(io.reactivex.u<T> uVar, io.reactivex.b.q<? super T> qVar) {
        this.f22422a = uVar;
        this.f22423b = qVar;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<Boolean> a() {
        return io.reactivex.e.a.a(new C2911g(this.f22422a, this.f22423b));
    }

    @Override // io.reactivex.y
    protected void b(io.reactivex.z<? super Boolean> zVar) {
        this.f22422a.subscribe(new a(zVar, this.f22423b));
    }
}
