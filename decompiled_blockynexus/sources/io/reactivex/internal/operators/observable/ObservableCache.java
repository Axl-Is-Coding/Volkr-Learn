package io.reactivex.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableCache<T> extends AbstractC2904a<T, T> implements io.reactivex.w<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final CacheDisposable[] f22077b = new CacheDisposable[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final CacheDisposable[] f22078c = new CacheDisposable[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicBoolean f22079d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f22080e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicReference<CacheDisposable<T>[]> f22081f;
    volatile long g;
    final a<T> h;
    a<T> i;
    int j;
    Throwable k;
    volatile boolean l;

    static final class CacheDisposable<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final io.reactivex.w<? super T> downstream;
        long index;
        a<T> node;
        int offset;
        final ObservableCache<T> parent;

        CacheDisposable(io.reactivex.w<? super T> wVar, ObservableCache<T> observableCache) {
            this.downstream = wVar;
            this.parent = observableCache;
            this.node = observableCache.h;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.disposed) {
                return;
            }
            this.disposed = true;
            this.parent.b(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T[] f22082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile a<T> f22083b;

        a(int i) {
            this.f22082a = (T[]) new Object[i];
        }
    }

    public ObservableCache(io.reactivex.p<T> pVar, int i) {
        super(pVar);
        this.f22080e = i;
        this.f22079d = new AtomicBoolean();
        a<T> aVar = new a<>(i);
        this.h = aVar;
        this.i = aVar;
        this.f22081f = new AtomicReference<>(f22077b);
    }

    void a(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f22081f.get();
            if (cacheDisposableArr == f22078c) {
                return;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[length + 1];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f22081f.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    void b(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        do {
            cacheDisposableArr = this.f22081f.get();
            int length = cacheDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (cacheDisposableArr[i2] == cacheDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                cacheDisposableArr2 = f22077b;
            } else {
                CacheDisposable<T>[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                cacheDisposableArr2 = cacheDisposableArr3;
            }
        } while (!this.f22081f.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    void c(CacheDisposable<T> cacheDisposable) {
        if (cacheDisposable.getAndIncrement() != 0) {
            return;
        }
        long j = cacheDisposable.index;
        int i = cacheDisposable.offset;
        a<T> aVar = cacheDisposable.node;
        io.reactivex.w<? super T> wVar = cacheDisposable.downstream;
        int i2 = this.f22080e;
        int iAddAndGet = 1;
        while (!cacheDisposable.disposed) {
            boolean z = this.l;
            boolean z2 = this.g == j;
            if (z && z2) {
                cacheDisposable.node = null;
                Throwable th = this.k;
                if (th != null) {
                    wVar.onError(th);
                    return;
                } else {
                    wVar.onComplete();
                    return;
                }
            }
            if (z2) {
                cacheDisposable.index = j;
                cacheDisposable.offset = i;
                cacheDisposable.node = aVar;
                iAddAndGet = cacheDisposable.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                if (i == i2) {
                    aVar = aVar.f22083b;
                    i = 0;
                }
                wVar.onNext(aVar.f22082a[i]);
                i++;
                j++;
            }
        }
        cacheDisposable.node = null;
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.l = true;
        for (CacheDisposable<T> cacheDisposable : this.f22081f.getAndSet(f22078c)) {
            c(cacheDisposable);
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        this.k = th;
        this.l = true;
        for (CacheDisposable<T> cacheDisposable : this.f22081f.getAndSet(f22078c)) {
            c(cacheDisposable);
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        int i = this.j;
        if (i == this.f22080e) {
            a<T> aVar = new a<>(i);
            aVar.f22082a[0] = t;
            this.j = 1;
            this.i.f22083b = aVar;
            this.i = aVar;
        } else {
            this.i.f22082a[i] = t;
            this.j = i + 1;
        }
        this.g++;
        for (CacheDisposable<T> cacheDisposable : this.f22081f.get()) {
            c(cacheDisposable);
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        CacheDisposable<T> cacheDisposable = new CacheDisposable<>(wVar, this);
        wVar.onSubscribe(cacheDisposable);
        a(cacheDisposable);
        if (this.f22079d.get() || !this.f22079d.compareAndSet(false, true)) {
            c(cacheDisposable);
        } else {
            this.f22358a.subscribe(this);
        }
    }
}
