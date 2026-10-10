package io.reactivex.internal.observers;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.w;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: BlockingBaseObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c<T> extends CountDownLatch implements w<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    T f21841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f21842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    io.reactivex.disposables.b f21843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f21844d;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                io.reactivex.internal.util.c.a();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw ExceptionHelper.b(e2);
            }
        }
        Throwable th = this.f21842b;
        if (th == null) {
            return this.f21841a;
        }
        throw ExceptionHelper.b(th);
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        this.f21844d = true;
        io.reactivex.disposables.b bVar = this.f21843c;
        if (bVar != null) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f21844d;
    }

    @Override // io.reactivex.w
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.w
    public final void onSubscribe(io.reactivex.disposables.b bVar) {
        this.f21843c = bVar;
        if (this.f21844d) {
            bVar.dispose();
        }
    }
}
