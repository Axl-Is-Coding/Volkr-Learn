package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDoOnEach.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2929z<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.g<? super T> f22612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.g<? super Throwable> f22613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.b.a f22614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.b.a f22615e;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.z$a */
    /* JADX INFO: compiled from: ObservableDoOnEach.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.g<? super T> f22617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final io.reactivex.b.g<? super Throwable> f22618c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final io.reactivex.b.a f22619d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final io.reactivex.b.a f22620e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        io.reactivex.disposables.b f22621f;
        boolean g;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.a aVar2) {
            this.f22616a = wVar;
            this.f22617b = gVar;
            this.f22618c = gVar2;
            this.f22619d = aVar;
            this.f22620e = aVar2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22621f.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22621f.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.g) {
                return;
            }
            try {
                this.f22619d.run();
                this.g = true;
                this.f22616a.onComplete();
                try {
                    this.f22620e.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                onError(th2);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.g) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.g = true;
            try {
                this.f22618c.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f22616a.onError(th);
            try {
                this.f22620e.run();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.e.a.b(th3);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            try {
                this.f22617b.accept(t);
                this.f22616a.onNext(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22621f.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22621f, bVar)) {
                this.f22621f = bVar;
                this.f22616a.onSubscribe(this);
            }
        }
    }

    public C2929z(io.reactivex.u<T> uVar, io.reactivex.b.g<? super T> gVar, io.reactivex.b.g<? super Throwable> gVar2, io.reactivex.b.a aVar, io.reactivex.b.a aVar2) {
        super(uVar);
        this.f22612b = gVar;
        this.f22613c = gVar2;
        this.f22614d = aVar;
        this.f22615e = aVar2;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f22612b, this.f22613c, this.f22614d, this.f22615e));
    }
}
