package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ObservableGenerate.java */
/* JADX INFO: loaded from: classes5.dex */
public final class O<T, S> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Callable<S> f22051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.c<S, io.reactivex.d<T>, S> f22052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.g<? super S> f22053c;

    public O(Callable<S> callable, io.reactivex.b.c<S, io.reactivex.d<T>, S> cVar, io.reactivex.b.g<? super S> gVar) {
        this.f22051a = callable;
        this.f22052b = cVar;
        this.f22053c = gVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        try {
            a aVar = new a(wVar, this.f22052b, this.f22053c, this.f22051a.call());
            wVar.onSubscribe(aVar);
            aVar.a();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
        }
    }

    /* JADX INFO: compiled from: ObservableGenerate.java */
    static final class a<T, S> implements io.reactivex.d<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.c<S, ? super io.reactivex.d<T>, S> f22055b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final io.reactivex.b.g<? super S> f22056c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        S f22057d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f22058e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f22059f;
        boolean g;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.c<S, ? super io.reactivex.d<T>, S> cVar, io.reactivex.b.g<? super S> gVar, S s) {
            this.f22054a = wVar;
            this.f22055b = cVar;
            this.f22056c = gVar;
            this.f22057d = s;
        }

        public void a() {
            S sApply = this.f22057d;
            if (this.f22058e) {
                this.f22057d = null;
                a(sApply);
                return;
            }
            io.reactivex.b.c<S, ? super io.reactivex.d<T>, S> cVar = this.f22055b;
            while (!this.f22058e) {
                this.g = false;
                try {
                    sApply = cVar.apply(sApply, this);
                    if (this.f22059f) {
                        this.f22058e = true;
                        this.f22057d = null;
                        a(sApply);
                        return;
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f22057d = null;
                    this.f22058e = true;
                    onError(th);
                    a(sApply);
                    return;
                }
            }
            this.f22057d = null;
            a(sApply);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22058e = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22058e;
        }

        @Override // io.reactivex.d
        public void onComplete() {
            if (this.f22059f) {
                return;
            }
            this.f22059f = true;
            this.f22054a.onComplete();
        }

        @Override // io.reactivex.d
        public void onError(Throwable th) {
            if (this.f22059f) {
                io.reactivex.e.a.b(th);
                return;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f22059f = true;
            this.f22054a.onError(th);
        }

        @Override // io.reactivex.d
        public void onNext(T t) {
            if (this.f22059f) {
                return;
            }
            if (this.g) {
                onError(new IllegalStateException("onNext already called in this generate turn"));
            } else if (t == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.g = true;
                this.f22054a.onNext(t);
            }
        }

        private void a(S s) {
            try {
                this.f22056c.accept(s);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(th);
            }
        }
    }
}
