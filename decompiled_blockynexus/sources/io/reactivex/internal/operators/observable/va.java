package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ObservableTimeInterval.java */
/* JADX INFO: loaded from: classes5.dex */
public final class va<T> extends AbstractC2904a<T, io.reactivex.f.c<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.x f22579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22580c;

    /* JADX INFO: compiled from: ObservableTimeInterval.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super io.reactivex.f.c<T>> f22581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final TimeUnit f22582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final io.reactivex.x f22583c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f22584d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        io.reactivex.disposables.b f22585e;

        a(io.reactivex.w<? super io.reactivex.f.c<T>> wVar, TimeUnit timeUnit, io.reactivex.x xVar) {
            this.f22581a = wVar;
            this.f22583c = xVar;
            this.f22582b = timeUnit;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22585e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22585e.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22581a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22581a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            long jA = this.f22583c.a(this.f22582b);
            long j = this.f22584d;
            this.f22584d = jA;
            this.f22581a.onNext(new io.reactivex.f.c(t, jA - j, this.f22582b));
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22585e, bVar)) {
                this.f22585e = bVar;
                this.f22584d = this.f22583c.a(this.f22582b);
                this.f22581a.onSubscribe(this);
            }
        }
    }

    public va(io.reactivex.u<T> uVar, TimeUnit timeUnit, io.reactivex.x xVar) {
        super(uVar);
        this.f22579b = xVar;
        this.f22580c = timeUnit;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.f.c<T>> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22580c, this.f22579b));
    }
}
