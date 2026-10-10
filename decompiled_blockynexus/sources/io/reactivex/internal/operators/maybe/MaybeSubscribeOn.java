package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.x;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeSubscribeOn<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final x f21937b;

    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements k<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 8571289934935992137L;
        final k<? super T> downstream;
        final SequentialDisposable task = new SequentialDisposable();

        SubscribeOnMaybeObserver(k<? super T> kVar) {
            this.downstream = kVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.k
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.k
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.k
        public void onSuccess(T t) {
            this.downstream.onSuccess(t);
        }
    }

    static final class a<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final k<? super T> f21938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final m<T> f21939b;

        a(k<? super T> kVar, m<T> mVar) {
            this.f21938a = kVar;
            this.f21939b = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21939b.a(this.f21938a);
        }
    }

    public MaybeSubscribeOn(m<T> mVar, x xVar) {
        super(mVar);
        this.f21937b = xVar;
    }

    @Override // io.reactivex.i
    protected void b(k<? super T> kVar) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(kVar);
        kVar.onSubscribe(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.task.replace(this.f21937b.a(new a(subscribeOnMaybeObserver, this.f21941a)));
    }
}
