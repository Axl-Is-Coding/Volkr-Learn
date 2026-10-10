package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.w;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FutureObserver.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends CountDownLatch implements w<T>, Future<T>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    T f21853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Throwable f21854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<io.reactivex.disposables.b> f21855c;

    public h() {
        super(1);
        this.f21855c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        io.reactivex.disposables.b bVar;
        DisposableHelper disposableHelper;
        do {
            bVar = this.f21855c.get();
            if (bVar == this || bVar == (disposableHelper = DisposableHelper.DISPOSED)) {
                return false;
            }
        } while (!this.f21855c.compareAndSet(bVar, disposableHelper));
        if (bVar != null) {
            bVar.dispose();
        }
        countDown();
        return true;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        if (getCount() != 0) {
            io.reactivex.internal.util.c.a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f21854b;
        if (th == null) {
            return this.f21853a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return DisposableHelper.isDisposed(this.f21855c.get());
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // io.reactivex.w
    public void onComplete() {
        io.reactivex.disposables.b bVar;
        if (this.f21853a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            bVar = this.f21855c.get();
            if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                return;
            }
        } while (!this.f21855c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        io.reactivex.disposables.b bVar;
        if (this.f21854b != null) {
            io.reactivex.e.a.b(th);
            return;
        }
        this.f21854b = th;
        do {
            bVar = this.f21855c.get();
            if (bVar == this || bVar == DisposableHelper.DISPOSED) {
                io.reactivex.e.a.b(th);
                return;
            }
        } while (!this.f21855c.compareAndSet(bVar, this));
        countDown();
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (this.f21853a == null) {
            this.f21853a = t;
        } else {
            this.f21855c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this.f21855c, bVar);
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (getCount() != 0) {
            io.reactivex.internal.util.c.a();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(ExceptionHelper.a(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f21854b;
            if (th == null) {
                return this.f21853a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
