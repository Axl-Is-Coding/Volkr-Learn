package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDebounceTimed<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f22101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.x f22102d;

    static final class DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements Runnable, io.reactivex.disposables.b {
        private static final long serialVersionUID = 6812032969491025141L;
        final long idx;
        final AtomicBoolean once = new AtomicBoolean();
        final a<T> parent;
        final T value;

        DebounceEmitter(T t, long j, a<T> aVar) {
            this.value = t;
            this.idx = j;
            this.parent = aVar;
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
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }
    }

    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f22104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f22105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final x.c f22106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        io.reactivex.disposables.b f22107e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        io.reactivex.disposables.b f22108f;
        volatile long g;
        boolean h;

        a(io.reactivex.w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar) {
            this.f22103a = wVar;
            this.f22104b = j;
            this.f22105c = timeUnit;
            this.f22106d = cVar;
        }

        void a(long j, T t, DebounceEmitter<T> debounceEmitter) {
            if (j == this.g) {
                this.f22103a.onNext(t);
                debounceEmitter.dispose();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22107e.dispose();
            this.f22106d.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22106d.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.h) {
                return;
            }
            this.h = true;
            io.reactivex.disposables.b bVar = this.f22108f;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
            if (debounceEmitter != null) {
                debounceEmitter.run();
            }
            this.f22103a.onComplete();
            this.f22106d.dispose();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.h) {
                io.reactivex.e.a.b(th);
                return;
            }
            io.reactivex.disposables.b bVar = this.f22108f;
            if (bVar != null) {
                bVar.dispose();
            }
            this.h = true;
            this.f22103a.onError(th);
            this.f22106d.dispose();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.h) {
                return;
            }
            long j = this.g + 1;
            this.g = j;
            io.reactivex.disposables.b bVar = this.f22108f;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t, j, this);
            this.f22108f = debounceEmitter;
            debounceEmitter.setResource(this.f22106d.a(debounceEmitter, this.f22104b, this.f22105c));
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22107e, bVar)) {
                this.f22107e = bVar;
                this.f22103a.onSubscribe(this);
            }
        }
    }

    public ObservableDebounceTimed(io.reactivex.u<T> uVar, long j, TimeUnit timeUnit, io.reactivex.x xVar) {
        super(uVar);
        this.f22100b = j;
        this.f22101c = timeUnit;
        this.f22102d = xVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(new io.reactivex.observers.f(wVar), this.f22100b, this.f22101c, this.f22102d.a()));
    }
}
