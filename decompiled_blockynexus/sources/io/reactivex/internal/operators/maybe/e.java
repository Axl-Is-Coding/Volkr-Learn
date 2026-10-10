package io.reactivex.internal.operators.maybe;

import io.reactivex.b.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.m;

/* JADX INFO: compiled from: MaybePeek.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g<? super io.reactivex.disposables.b> f21948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final g<? super T> f21949c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final g<? super Throwable> f21950d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.b.a f21951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final io.reactivex.b.a f21952f;
    final io.reactivex.b.a g;

    public e(m<T> mVar, g<? super io.reactivex.disposables.b> gVar, g<? super T> gVar2, g<? super Throwable> gVar3, io.reactivex.b.a aVar, io.reactivex.b.a aVar2, io.reactivex.b.a aVar3) {
        super(mVar);
        this.f21948b = gVar;
        this.f21949c = gVar2;
        this.f21950d = gVar3;
        this.f21951e = aVar;
        this.f21952f = aVar2;
        this.g = aVar3;
    }

    @Override // io.reactivex.i
    protected void b(k<? super T> kVar) {
        this.f21941a.a(new a(kVar, this));
    }

    /* JADX INFO: compiled from: MaybePeek.java */
    static final class a<T> implements k<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final k<? super T> f21953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final e<T> f21954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        io.reactivex.disposables.b f21955c;

        a(k<? super T> kVar, e<T> eVar) {
            this.f21953a = kVar;
            this.f21954b = eVar;
        }

        void a(Throwable th) {
            try {
                this.f21954b.f21950d.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                th = new CompositeException(th, th2);
            }
            this.f21955c = DisposableHelper.DISPOSED;
            this.f21953a.onError(th);
            a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            try {
                this.f21954b.g.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(th);
            }
            this.f21955c.dispose();
            this.f21955c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f21955c.isDisposed();
        }

        @Override // io.reactivex.k
        public void onComplete() {
            if (this.f21955c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.f21954b.f21951e.run();
                this.f21955c = DisposableHelper.DISPOSED;
                this.f21953a.onComplete();
                a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                a(th);
            }
        }

        @Override // io.reactivex.k
        public void onError(Throwable th) {
            if (this.f21955c == DisposableHelper.DISPOSED) {
                io.reactivex.e.a.b(th);
            } else {
                a(th);
            }
        }

        @Override // io.reactivex.k
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f21955c, bVar)) {
                try {
                    this.f21954b.f21948b.accept(bVar);
                    this.f21955c = bVar;
                    this.f21953a.onSubscribe(this);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    bVar.dispose();
                    this.f21955c = DisposableHelper.DISPOSED;
                    EmptyDisposable.error(th, this.f21953a);
                }
            }
        }

        @Override // io.reactivex.k
        public void onSuccess(T t) {
            if (this.f21955c == DisposableHelper.DISPOSED) {
                return;
            }
            try {
                this.f21954b.f21949c.accept(t);
                this.f21955c = DisposableHelper.DISPOSED;
                this.f21953a.onSuccess(t);
                a();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                a(th);
            }
        }

        void a() {
            try {
                this.f21954b.f21952f.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(th);
            }
        }
    }
}
