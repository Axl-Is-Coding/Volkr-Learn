package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableTimer extends io.reactivex.p<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.x f22265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22267c;

    static final class TimerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final io.reactivex.w<? super Long> downstream;

        TimerObserver(io.reactivex.w<? super Long> wVar) {
            this.downstream = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            this.downstream.onNext(0L);
            lazySet(EmptyDisposable.INSTANCE);
            this.downstream.onComplete();
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.trySet(this, bVar);
        }
    }

    public ObservableTimer(long j, TimeUnit timeUnit, io.reactivex.x xVar) {
        this.f22266b = j;
        this.f22267c = timeUnit;
        this.f22265a = xVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super Long> wVar) {
        TimerObserver timerObserver = new TimerObserver(wVar);
        wVar.onSubscribe(timerObserver);
        timerObserver.setResource(this.f22265a.a(timerObserver, this.f22266b, this.f22267c));
    }
}
