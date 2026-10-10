package io.reactivex.internal.observers;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.z;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingMultiObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class f<T> extends CountDownLatch implements z<T>, io.reactivex.b, io.reactivex.k<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    T f21845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f21846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    io.reactivex.disposables.b f21847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f21848d;

    public f() {
        super(1);
    }

    public T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.a();
                await();
            } catch (InterruptedException e2) {
                b();
                throw ExceptionHelper.b(e2);
            }
        }
        Throwable th = this.f21846b;
        if (th == null) {
            return this.f21845a;
        }
        throw ExceptionHelper.b(th);
    }

    void b() {
        this.f21848d = true;
        io.reactivex.disposables.b bVar = this.f21847c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.b, io.reactivex.k
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
    public void onError(Throwable th) {
        this.f21846b = th;
        countDown();
    }

    @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        this.f21847c = bVar;
        if (this.f21848d) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.z, io.reactivex.k
    public void onSuccess(T t) {
        this.f21845a = t;
        countDown();
    }
}
