package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableLastSingle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class W<T> extends io.reactivex.y<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final T f22342b;

    /* JADX INFO: compiled from: ObservableLastSingle.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.z<? super T> f22343a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f22344b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22345c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        T f22346d;

        a(io.reactivex.z<? super T> zVar, T t) {
            this.f22343a = zVar;
            this.f22344b = t;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22345c.dispose();
            this.f22345c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22345c == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22345c = DisposableHelper.DISPOSED;
            T t = this.f22346d;
            if (t != null) {
                this.f22346d = null;
                this.f22343a.onSuccess(t);
                return;
            }
            T t2 = this.f22344b;
            if (t2 != null) {
                this.f22343a.onSuccess(t2);
            } else {
                this.f22343a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22345c = DisposableHelper.DISPOSED;
            this.f22346d = null;
            this.f22343a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22346d = t;
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22345c, bVar)) {
                this.f22345c = bVar;
                this.f22343a.onSubscribe(this);
            }
        }
    }

    public W(io.reactivex.u<T> uVar, T t) {
        this.f22341a = uVar;
        this.f22342b = t;
    }

    @Override // io.reactivex.y
    protected void b(io.reactivex.z<? super T> zVar) {
        this.f22341a.subscribe(new a(zVar, this.f22342b));
    }
}
