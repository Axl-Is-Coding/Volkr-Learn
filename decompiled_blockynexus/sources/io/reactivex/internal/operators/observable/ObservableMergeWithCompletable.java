package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableMergeWithCompletable<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.c f22146b;

    static final class MergeWithObserver<T> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = -4592979584110982903L;
        final io.reactivex.w<? super T> downstream;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final AtomicReference<io.reactivex.disposables.b> mainDisposable = new AtomicReference<>();
        final OtherObserver otherObserver = new OtherObserver(this);
        final AtomicThrowable error = new AtomicThrowable();

        static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.b {
            private static final long serialVersionUID = -2935427570954647017L;
            final MergeWithObserver<?> parent;

            OtherObserver(MergeWithObserver<?> mergeWithObserver) {
                this.parent = mergeWithObserver;
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onComplete() {
                this.parent.otherComplete();
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onError(Throwable th) {
                this.parent.otherError(th);
            }

            @Override // io.reactivex.b, io.reactivex.k
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        MergeWithObserver(io.reactivex.w<? super T> wVar) {
            this.downstream = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                io.reactivex.internal.util.g.a(this.downstream, this, this.error);
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.util.g.a((io.reactivex.w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            io.reactivex.internal.util.g.a(this.downstream, t, this, this.error);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }

        void otherComplete() {
            this.otherDone = true;
            if (this.mainDone) {
                io.reactivex.internal.util.g.a(this.downstream, this, this.error);
            }
        }

        void otherError(Throwable th) {
            DisposableHelper.dispose(this.mainDisposable);
            io.reactivex.internal.util.g.a((io.reactivex.w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }
    }

    public ObservableMergeWithCompletable(io.reactivex.p<T> pVar, io.reactivex.c cVar) {
        super(pVar);
        this.f22146b = cVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        MergeWithObserver mergeWithObserver = new MergeWithObserver(wVar);
        wVar.onSubscribe(mergeWithObserver);
        this.f22358a.subscribe(mergeWithObserver);
        this.f22146b.a(mergeWithObserver.otherObserver);
    }
}
