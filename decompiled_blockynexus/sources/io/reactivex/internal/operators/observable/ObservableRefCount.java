package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableRefCount<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.d.a<T> f22171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f22172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f22174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final io.reactivex.x f22175e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    RefConnection f22176f;

    static final class RefConnection extends AtomicReference<io.reactivex.disposables.b> implements Runnable, io.reactivex.b.g<io.reactivex.disposables.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        io.reactivex.disposables.b timer;

        RefConnection(ObservableRefCount<?> observableRefCount) {
            this.parent = observableRefCount;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.c(this);
        }

        @Override // io.reactivex.b.g
        public void accept(io.reactivex.disposables.b bVar) throws Exception {
            DisposableHelper.replace(this, bVar);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((io.reactivex.internal.disposables.c) this.parent.f22171a).a(bVar);
                }
            }
        }
    }

    static final class RefCountObserver<T> extends AtomicBoolean implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -7419642935409022375L;
        final RefConnection connection;
        final io.reactivex.w<? super T> downstream;
        final ObservableRefCount<T> parent;
        io.reactivex.disposables.b upstream;

        RefCountObserver(io.reactivex.w<? super T> wVar, ObservableRefCount<T> observableRefCount, RefConnection refConnection) {
            this.downstream = wVar;
            this.parent = observableRefCount;
            this.connection = refConnection;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.a(this.connection);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                io.reactivex.e.a.b(th);
            } else {
                this.parent.b(this.connection);
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableRefCount(io.reactivex.d.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void a(RefConnection refConnection) {
        synchronized (this) {
            if (this.f22176f != null && this.f22176f == refConnection) {
                long j = refConnection.subscriberCount - 1;
                refConnection.subscriberCount = j;
                if (j == 0 && refConnection.connected) {
                    if (this.f22173c == 0) {
                        c(refConnection);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    refConnection.timer = sequentialDisposable;
                    sequentialDisposable.replace(this.f22175e.a(refConnection, this.f22173c, this.f22174d));
                }
            }
        }
    }

    void b(RefConnection refConnection) {
        synchronized (this) {
            if (this.f22176f != null && this.f22176f == refConnection) {
                this.f22176f = null;
                if (refConnection.timer != null) {
                    refConnection.timer.dispose();
                }
            }
            long j = refConnection.subscriberCount - 1;
            refConnection.subscriberCount = j;
            if (j == 0) {
                if (this.f22171a instanceof io.reactivex.disposables.b) {
                    ((io.reactivex.disposables.b) this.f22171a).dispose();
                } else if (this.f22171a instanceof io.reactivex.internal.disposables.c) {
                    ((io.reactivex.internal.disposables.c) this.f22171a).a(refConnection.get());
                }
            }
        }
    }

    void c(RefConnection refConnection) {
        synchronized (this) {
            if (refConnection.subscriberCount == 0 && refConnection == this.f22176f) {
                this.f22176f = null;
                io.reactivex.disposables.b bVar = refConnection.get();
                DisposableHelper.dispose(refConnection);
                if (this.f22171a instanceof io.reactivex.disposables.b) {
                    ((io.reactivex.disposables.b) this.f22171a).dispose();
                } else if (this.f22171a instanceof io.reactivex.internal.disposables.c) {
                    if (bVar == null) {
                        refConnection.disconnectedEarly = true;
                    } else {
                        ((io.reactivex.internal.disposables.c) this.f22171a).a(bVar);
                    }
                }
            }
        }
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        RefConnection refConnection;
        boolean z;
        synchronized (this) {
            refConnection = this.f22176f;
            if (refConnection == null) {
                refConnection = new RefConnection(this);
                this.f22176f = refConnection;
            }
            long j = refConnection.subscriberCount;
            if (j == 0 && refConnection.timer != null) {
                refConnection.timer.dispose();
            }
            long j2 = j + 1;
            refConnection.subscriberCount = j2;
            z = true;
            if (refConnection.connected || j2 != this.f22172b) {
                z = false;
            } else {
                refConnection.connected = true;
            }
        }
        this.f22171a.subscribe(new RefCountObserver(wVar, this, refConnection));
        if (z) {
            this.f22171a.a(refConnection);
        }
    }

    public ObservableRefCount(io.reactivex.d.a<T> aVar, int i, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
        this.f22171a = aVar;
        this.f22172b = i;
        this.f22173c = j;
        this.f22174d = timeUnit;
        this.f22175e = xVar;
    }
}
