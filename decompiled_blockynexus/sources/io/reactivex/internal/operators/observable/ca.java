package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: compiled from: ObservableOnErrorNext.java */
/* JADX INFO: loaded from: classes5.dex */
public final class ca<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends T>> f22371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f22372c;

    /* JADX INFO: compiled from: ObservableOnErrorNext.java */
    static final class a<T> implements io.reactivex.w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends T>> f22374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f22375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final SequentialDisposable f22376d = new SequentialDisposable();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f22377e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f22378f;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends T>> oVar, boolean z) {
            this.f22373a = wVar;
            this.f22374b = oVar;
            this.f22375c = z;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.f22378f) {
                return;
            }
            this.f22378f = true;
            this.f22377e = true;
            this.f22373a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.f22377e) {
                if (this.f22378f) {
                    io.reactivex.e.a.b(th);
                    return;
                } else {
                    this.f22373a.onError(th);
                    return;
                }
            }
            this.f22377e = true;
            if (this.f22375c && !(th instanceof Exception)) {
                this.f22373a.onError(th);
                return;
            }
            try {
                io.reactivex.u<? extends T> uVarApply = this.f22374b.apply(th);
                if (uVarApply != null) {
                    uVarApply.subscribe(this);
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("Observable is null");
                nullPointerException.initCause(th);
                this.f22373a.onError(nullPointerException);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f22373a.onError(new CompositeException(th, th2));
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f22378f) {
                return;
            }
            this.f22373a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22376d.replace(bVar);
        }
    }

    public ca(io.reactivex.u<T> uVar, io.reactivex.b.o<? super Throwable, ? extends io.reactivex.u<? extends T>> oVar, boolean z) {
        super(uVar);
        this.f22371b = oVar;
        this.f22372c = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        a aVar = new a(wVar, this.f22371b, this.f22372c);
        wVar.onSubscribe(aVar.f22376d);
        this.f22358a.subscribe(aVar);
    }
}
