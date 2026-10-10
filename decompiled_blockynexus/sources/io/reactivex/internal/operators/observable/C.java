package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: compiled from: ObservableElementAtMaybe.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C<T> extends io.reactivex.i<T> implements io.reactivex.c.a.b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22007b;

    /* JADX INFO: compiled from: ObservableElementAtMaybe.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.k<? super T> f22008a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f22009b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22010c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f22011d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22012e;

        a(io.reactivex.k<? super T> kVar, long j) {
            this.f22008a = kVar;
            this.f22009b = j;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22010c.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22010c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22012e) {
                return;
            }
            this.f22012e = true;
            this.f22008a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22012e) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22012e = true;
                this.f22008a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22012e) {
                return;
            }
            long j = this.f22011d;
            if (j != this.f22009b) {
                this.f22011d = j + 1;
                return;
            }
            this.f22012e = true;
            this.f22010c.dispose();
            this.f22008a.onSuccess(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22010c, bVar)) {
                this.f22010c = bVar;
                this.f22008a.onSubscribe(this);
            }
        }
    }

    public C(io.reactivex.u<T> uVar, long j) {
        this.f22006a = uVar;
        this.f22007b = j;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<T> a() {
        return io.reactivex.e.a.a(new B(this.f22006a, this.f22007b, null, false));
    }

    @Override // io.reactivex.i
    public void b(io.reactivex.k<? super T> kVar) {
        this.f22006a.subscribe(new a(kVar, this.f22007b));
    }
}
