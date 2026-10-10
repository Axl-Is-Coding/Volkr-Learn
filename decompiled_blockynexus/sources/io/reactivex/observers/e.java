package io.reactivex.observers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.w;

/* JADX INFO: compiled from: SafeObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e<T> implements w<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final w<? super T> f22746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    io.reactivex.disposables.b f22747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f22748c;

    public e(w<? super T> wVar) {
        this.f22746a = wVar;
    }

    void a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f22746a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f22746a.onError(nullPointerException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.e.a.b(new CompositeException(nullPointerException, th2));
        }
    }

    void b() {
        this.f22748c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f22746a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f22746a.onError(nullPointerException);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(new CompositeException(nullPointerException, th));
            }
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            io.reactivex.e.a.b(new CompositeException(nullPointerException, th2));
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        this.f22747b.dispose();
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return this.f22747b.isDisposed();
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (this.f22748c) {
            return;
        }
        this.f22748c = true;
        if (this.f22747b == null) {
            a();
            return;
        }
        try {
            this.f22746a.onComplete();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            io.reactivex.e.a.b(th);
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        if (this.f22748c) {
            io.reactivex.e.a.b(th);
            return;
        }
        this.f22748c = true;
        if (this.f22747b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f22746a.onError(th);
                return;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                io.reactivex.e.a.b(new CompositeException(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f22746a.onSubscribe(EmptyDisposable.INSTANCE);
            try {
                this.f22746a.onError(new CompositeException(th, nullPointerException));
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                io.reactivex.e.a.b(new CompositeException(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            io.reactivex.exceptions.a.b(th4);
            io.reactivex.e.a.b(new CompositeException(th, nullPointerException, th4));
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (this.f22748c) {
            return;
        }
        if (this.f22747b == null) {
            b();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f22747b.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                onError(new CompositeException(nullPointerException, th));
                return;
            }
        }
        try {
            this.f22746a.onNext(t);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            try {
                this.f22747b.dispose();
                onError(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                onError(new CompositeException(th2, th3));
            }
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.f22747b, bVar)) {
            this.f22747b = bVar;
            try {
                this.f22746a.onSubscribe(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22748c = true;
                try {
                    bVar.dispose();
                    io.reactivex.e.a.b(th);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    io.reactivex.e.a.b(new CompositeException(th, th2));
                }
            }
        }
    }
}
