package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDelay.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2922s<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.x f22539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f22540e;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s$a */
    /* JADX INFO: compiled from: ObservableDelay.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22541a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f22542b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f22543c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final x.c f22544d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final boolean f22545e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        io.reactivex.disposables.b f22546f;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableDelay.java */
        final class RunnableC0202a implements Runnable {
            RunnableC0202a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f22541a.onComplete();
                } finally {
                    a.this.f22544d.dispose();
                }
            }
        }

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s$a$b */
        /* JADX INFO: compiled from: ObservableDelay.java */
        final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Throwable f22548a;

            b(Throwable th) {
                this.f22548a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f22541a.onError(this.f22548a);
                } finally {
                    a.this.f22544d.dispose();
                }
            }
        }

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.s$a$c */
        /* JADX INFO: compiled from: ObservableDelay.java */
        final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final T f22550a;

            c(T t) {
                this.f22550a = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f22541a.onNext(this.f22550a);
            }
        }

        a(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar, boolean z) {
            this.f22541a = wVar;
            this.f22542b = j;
            this.f22543c = timeUnit;
            this.f22544d = cVar;
            this.f22545e = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22546f.dispose();
            this.f22544d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22544d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22544d.a(new RunnableC0202a(), this.f22542b, this.f22543c);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22544d.a(new b(th), this.f22545e ? this.f22542b : 0L, this.f22543c);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22544d.a(new c(t), this.f22542b, this.f22543c);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22546f, bVar)) {
                this.f22546f = bVar;
                this.f22541a.onSubscribe(this);
            }
        }
    }

    public C2922s(io.reactivex.u<T> uVar, long j, TimeUnit timeUnit, io.reactivex.x xVar, boolean z) {
        super(uVar);
        this.f22537b = j;
        this.f22538c = timeUnit;
        this.f22539d = xVar;
        this.f22540e = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(this.f22540e ? wVar : new io.reactivex.observers.f(wVar), this.f22537b, this.f22538c, this.f22539d.a(), this.f22540e));
    }
}
