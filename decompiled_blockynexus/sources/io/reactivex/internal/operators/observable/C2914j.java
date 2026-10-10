package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableBufferBoundarySupplier.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2914j<T, U extends Collection<? super T>, B> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends io.reactivex.u<B>> f22437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<U> f22438c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j$a */
    /* JADX INFO: compiled from: ObservableBufferBoundarySupplier.java */
    static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.c<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, U, B> f22439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f22440c;

        a(b<T, U, B> bVar) {
            this.f22439b = bVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22440c) {
                return;
            }
            this.f22440c = true;
            this.f22439b.e();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22440c) {
                io.reactivex.e.a.b(th);
            } else {
                this.f22440c = true;
                this.f22439b.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(B b2) {
            if (this.f22440c) {
                return;
            }
            this.f22440c = true;
            dispose();
            this.f22439b.e();
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.j$b */
    /* JADX INFO: compiled from: ObservableBufferBoundarySupplier.java */
    static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.observers.j<T, U, U> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        final Callable<U> g;
        final Callable<? extends io.reactivex.u<B>> h;
        io.reactivex.disposables.b i;
        final AtomicReference<io.reactivex.disposables.b> j;
        U k;

        b(io.reactivex.w<? super U> wVar, Callable<U> callable, Callable<? extends io.reactivex.u<B>> callable2) {
            super(wVar, new MpscLinkedQueue());
            this.j = new AtomicReference<>();
            this.g = callable;
            this.h = callable2;
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public /* bridge */ /* synthetic */ void a(io.reactivex.w wVar, Object obj) {
            a((io.reactivex.w<? super Collection>) wVar, (Collection) obj);
        }

        void d() {
            DisposableHelper.dispose(this.j);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f21858d) {
                return;
            }
            this.f21858d = true;
            this.i.dispose();
            d();
            if (b()) {
                this.f21857c.clear();
            }
        }

        void e() {
            try {
                U uCall = this.g.call();
                io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                U u = uCall;
                try {
                    io.reactivex.u<B> uVarCall = this.h.call();
                    io.reactivex.internal.functions.a.a(uVarCall, "The boundary ObservableSource supplied is null");
                    io.reactivex.u<B> uVar = uVarCall;
                    a aVar = new a(this);
                    if (DisposableHelper.replace(this.j, aVar)) {
                        synchronized (this) {
                            U u2 = this.k;
                            if (u2 == null) {
                                return;
                            }
                            this.k = u;
                            uVar.subscribe(aVar);
                            a(u2, false, this);
                        }
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f21858d = true;
                    this.i.dispose();
                    this.f21856b.onError(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                this.f21856b.onError(th2);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21858d;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            synchronized (this) {
                U u = this.k;
                if (u == null) {
                    return;
                }
                this.k = null;
                this.f21857c.offer(u);
                this.f21859e = true;
                if (b()) {
                    io.reactivex.internal.util.k.a(this.f21857c, this.f21856b, false, this, this);
                }
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            dispose();
            this.f21856b.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            synchronized (this) {
                U u = this.k;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.i, bVar)) {
                this.i = bVar;
                io.reactivex.w<? super V> wVar = this.f21856b;
                try {
                    U uCall = this.g.call();
                    io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                    this.k = uCall;
                    try {
                        io.reactivex.u<B> uVarCall = this.h.call();
                        io.reactivex.internal.functions.a.a(uVarCall, "The boundary ObservableSource supplied is null");
                        io.reactivex.u<B> uVar = uVarCall;
                        a aVar = new a(this);
                        this.j.set(aVar);
                        wVar.onSubscribe(this);
                        if (this.f21858d) {
                            return;
                        }
                        uVar.subscribe(aVar);
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        this.f21858d = true;
                        bVar.dispose();
                        EmptyDisposable.error(th, wVar);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f21858d = true;
                    bVar.dispose();
                    EmptyDisposable.error(th2, wVar);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void a(io.reactivex.w<? super U> wVar, U u) {
            this.f21856b.onNext((Object) u);
        }
    }

    public C2914j(io.reactivex.u<T> uVar, Callable<? extends io.reactivex.u<B>> callable, Callable<U> callable2) {
        super(uVar);
        this.f22437b = callable;
        this.f22438c = callable2;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super U> wVar) {
        this.f22358a.subscribe(new b(new io.reactivex.observers.f(wVar), this.f22438c, this.f22437b));
    }
}
