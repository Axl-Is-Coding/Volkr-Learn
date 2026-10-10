package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableDoFinally<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.a f22109b;

    static final class DoFinallyObserver<T> extends BasicIntQueueDisposable<T> implements io.reactivex.w<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final io.reactivex.w<? super T> downstream;
        final io.reactivex.b.a onFinally;
        io.reactivex.c.a.f<T> qd;
        boolean syncFused;
        io.reactivex.disposables.b upstream;

        DoFinallyObserver(io.reactivex.w<? super T> wVar, io.reactivex.b.a aVar) {
            this.downstream = wVar;
            this.onFinally = aVar;
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.qd.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            runFinally();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.qd.isEmpty();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.downstream.onComplete();
            runFinally();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.downstream.onError(th);
            runFinally();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof io.reactivex.c.a.f) {
                    this.qd = (io.reactivex.c.a.f) bVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll = this.qd.poll();
            if (tPoll == null && this.syncFused) {
                runFinally();
            }
            return tPoll;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            io.reactivex.c.a.f<T> fVar = this.qd;
            if (fVar == null || (i & 4) != 0) {
                return 0;
            }
            int iRequestFusion = fVar.requestFusion(i);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
            }
        }
    }

    public ObservableDoFinally(io.reactivex.u<T> uVar, io.reactivex.b.a aVar) {
        super(uVar);
        this.f22109b = aVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new DoFinallyObserver(wVar, this.f22109b));
    }
}
