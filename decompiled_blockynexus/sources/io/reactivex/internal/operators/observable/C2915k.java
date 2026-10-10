package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableBufferExactBoundary.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2915k<T, U extends Collection<? super T>, B> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<B> f22448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<U> f22449c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k$a */
    /* JADX INFO: compiled from: ObservableBufferExactBoundary.java */
    static final class a<T, U extends Collection<? super T>, B> extends io.reactivex.observers.c<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, U, B> f22450b;

        a(b<T, U, B> bVar) {
            this.f22450b = bVar;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22450b.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22450b.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(B b2) {
            this.f22450b.d();
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.k$b */
    /* JADX INFO: compiled from: ObservableBufferExactBoundary.java */
    static final class b<T, U extends Collection<? super T>, B> extends io.reactivex.internal.observers.j<T, U, U> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        final Callable<U> g;
        final io.reactivex.u<B> h;
        io.reactivex.disposables.b i;
        io.reactivex.disposables.b j;
        U k;

        b(io.reactivex.w<? super U> wVar, Callable<U> callable, io.reactivex.u<B> uVar) {
            super(wVar, new MpscLinkedQueue());
            this.g = callable;
            this.h = uVar;
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public /* bridge */ /* synthetic */ void a(io.reactivex.w wVar, Object obj) {
            a((io.reactivex.w<? super Collection>) wVar, (Collection) obj);
        }

        void d() {
            try {
                U uCall = this.g.call();
                io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                U u = uCall;
                synchronized (this) {
                    U u2 = this.k;
                    if (u2 == null) {
                        return;
                    }
                    this.k = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                this.f21856b.onError(th);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f21858d) {
                return;
            }
            this.f21858d = true;
            this.j.dispose();
            this.i.dispose();
            if (b()) {
                this.f21857c.clear();
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
                try {
                    U uCall = this.g.call();
                    io.reactivex.internal.functions.a.a(uCall, "The buffer supplied is null");
                    this.k = uCall;
                    a aVar = new a(this);
                    this.j = aVar;
                    this.f21856b.onSubscribe(this);
                    if (this.f21858d) {
                        return;
                    }
                    this.h.subscribe(aVar);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f21858d = true;
                    bVar.dispose();
                    EmptyDisposable.error(th, this.f21856b);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public void a(io.reactivex.w<? super U> wVar, U u) {
            this.f21856b.onNext((Object) u);
        }
    }

    public C2915k(io.reactivex.u<T> uVar, io.reactivex.u<B> uVar2, Callable<U> callable) {
        super(uVar);
        this.f22448b = uVar2;
        this.f22449c = callable;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super U> wVar) {
        this.f22358a.subscribe(new b(new io.reactivex.observers.f(wVar), this.f22449c, this.f22448b));
    }
}
