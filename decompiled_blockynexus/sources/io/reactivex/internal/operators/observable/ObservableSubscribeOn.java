package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSubscribeOn<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.x f22234b;

    static final class SubscribeOnObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final io.reactivex.w<? super T> downstream;
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        SubscribeOnObserver(io.reactivex.w<? super T> wVar) {
            this.downstream = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.downstream.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        void setDisposable(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SubscribeOnObserver<T> f22235a;

        a(SubscribeOnObserver<T> subscribeOnObserver) {
            this.f22235a = subscribeOnObserver;
        }

        @Override // java.lang.Runnable
        public void run() {
            ObservableSubscribeOn.this.f22358a.subscribe(this.f22235a);
        }
    }

    public ObservableSubscribeOn(io.reactivex.u<T> uVar, io.reactivex.x xVar) {
        super(uVar);
        this.f22234b = xVar;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        SubscribeOnObserver subscribeOnObserver = new SubscribeOnObserver(wVar);
        wVar.onSubscribe(subscribeOnObserver);
        subscribeOnObserver.setDisposable(this.f22234b.a(new a(subscribeOnObserver)));
    }
}
