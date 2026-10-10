package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractC2904a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f22065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f22066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<U> f22067d;

    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -8223395059921494546L;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        final io.reactivex.w<? super U> downstream;
        long index;
        final int skip;
        io.reactivex.disposables.b upstream;

        BufferSkipObserver(io.reactivex.w<? super U> wVar, int i, int i2, Callable<U> callable) {
            this.downstream = wVar;
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.downstream.onNext(this.buffers.poll());
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.buffers.clear();
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            long j = this.index;
            this.index = 1 + j;
            if (j % ((long) this.skip) == 0) {
                try {
                    U uCall = this.bufferSupplier.call();
                    io.reactivex.internal.functions.a.a(uCall, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                    this.buffers.offer(uCall);
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.upstream.dispose();
                    this.downstream.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.downstream.onNext(next);
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    static final class a<T, U extends Collection<? super T>> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super U> f22068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f22069b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Callable<U> f22070c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        U f22071d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f22072e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        io.reactivex.disposables.b f22073f;

        a(io.reactivex.w<? super U> wVar, int i, Callable<U> callable) {
            this.f22068a = wVar;
            this.f22069b = i;
            this.f22070c = callable;
        }

        boolean a() {
            try {
                U uCall = this.f22070c.call();
                io.reactivex.internal.functions.a.a(uCall, "Empty buffer supplied");
                this.f22071d = uCall;
                return true;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                this.f22071d = null;
                io.reactivex.disposables.b bVar = this.f22073f;
                if (bVar == null) {
                    EmptyDisposable.error(th, this.f22068a);
                    return false;
                }
                bVar.dispose();
                this.f22068a.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22073f.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22073f.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            U u = this.f22071d;
            if (u != null) {
                this.f22071d = null;
                if (!u.isEmpty()) {
                    this.f22068a.onNext(u);
                }
                this.f22068a.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22071d = null;
            this.f22068a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            U u = this.f22071d;
            if (u != null) {
                u.add(t);
                int i = this.f22072e + 1;
                this.f22072e = i;
                if (i >= this.f22069b) {
                    this.f22068a.onNext(u);
                    this.f22072e = 0;
                    a();
                }
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22073f, bVar)) {
                this.f22073f = bVar;
                this.f22068a.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(io.reactivex.u<T> uVar, int i, int i2, Callable<U> callable) {
        super(uVar);
        this.f22065b = i;
        this.f22066c = i2;
        this.f22067d = callable;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super U> wVar) {
        int i = this.f22066c;
        int i2 = this.f22065b;
        if (i != i2) {
            this.f22358a.subscribe(new BufferSkipObserver(wVar, i2, i, this.f22067d));
            return;
        }
        a aVar = new a(wVar, i2, this.f22067d);
        if (aVar.a()) {
            this.f22358a.subscribe(aVar);
        }
    }
}
