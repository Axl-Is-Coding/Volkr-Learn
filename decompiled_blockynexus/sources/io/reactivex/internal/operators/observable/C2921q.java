package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDebounce.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2921q<T, U> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, ? extends io.reactivex.u<U>> f22514b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q$a */
    /* JADX INFO: compiled from: ObservableDebounce.java */
    static final class a<T, U> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.o<? super T, ? extends io.reactivex.u<U>> f22516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f22517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f22518d = new AtomicReference<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile long f22519e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f22520f;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableDebounce.java */
        static final class C0201a<T, U> extends io.reactivex.observers.c<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final a<T, U> f22521b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final long f22522c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final T f22523d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            boolean f22524e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final AtomicBoolean f22525f = new AtomicBoolean();

            C0201a(a<T, U> aVar, long j, T t) {
                this.f22521b = aVar;
                this.f22522c = j;
                this.f22523d = t;
            }

            void b() {
                if (this.f22525f.compareAndSet(false, true)) {
                    this.f22521b.a(this.f22522c, this.f22523d);
                }
            }

            @Override // io.reactivex.w
            public void onComplete() {
                if (this.f22524e) {
                    return;
                }
                this.f22524e = true;
                b();
            }

            @Override // io.reactivex.w
            public void onError(Throwable th) {
                if (this.f22524e) {
                    io.reactivex.e.a.b(th);
                } else {
                    this.f22524e = true;
                    this.f22521b.onError(th);
                }
            }

            @Override // io.reactivex.w
            public void onNext(U u) {
                if (this.f22524e) {
                    return;
                }
                this.f22524e = true;
                dispose();
                b();
            }
        }

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<U>> oVar) {
            this.f22515a = wVar;
            this.f22516b = oVar;
        }

        void a(long j, T t) {
            if (j == this.f22519e) {
                this.f22515a.onNext(t);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22517c.dispose();
            DisposableHelper.dispose(this.f22518d);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22517c.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22520f) {
                return;
            }
            this.f22520f = true;
            io.reactivex.disposables.b bVar = this.f22518d.get();
            if (bVar != DisposableHelper.DISPOSED) {
                ((C0201a) bVar).b();
                DisposableHelper.dispose(this.f22518d);
                this.f22515a.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.f22518d);
            this.f22515a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22520f) {
                return;
            }
            long j = this.f22519e + 1;
            this.f22519e = j;
            io.reactivex.disposables.b bVar = this.f22518d.get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                io.reactivex.u<U> uVarApply = this.f22516b.apply(t);
                io.reactivex.internal.functions.a.a(uVarApply, "The ObservableSource supplied is null");
                io.reactivex.u<U> uVar = uVarApply;
                C0201a c0201a = new C0201a(this, j, t);
                if (this.f22518d.compareAndSet(bVar, c0201a)) {
                    uVar.subscribe(c0201a);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                this.f22515a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22517c, bVar)) {
                this.f22517c = bVar;
                this.f22515a.onSubscribe(this);
            }
        }
    }

    public C2921q(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, ? extends io.reactivex.u<U>> oVar) {
        super(uVar);
        this.f22514b = oVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(new io.reactivex.observers.f(wVar), this.f22514b));
    }
}
