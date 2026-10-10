package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublishSelector<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super io.reactivex.p<T>, ? extends io.reactivex.u<R>> f22164b;

    static final class TargetObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<R>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 854110278590336484L;
        final io.reactivex.w<? super R> downstream;
        io.reactivex.disposables.b upstream;

        TargetObserver(io.reactivex.w<? super R> wVar) {
            this.downstream = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    static final class a<T, R> implements io.reactivex.w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final PublishSubject<T> f22165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f22166b;

        a(PublishSubject<T> publishSubject, AtomicReference<io.reactivex.disposables.b> atomicReference) {
            this.f22165a = publishSubject;
            this.f22166b = atomicReference;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22165a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22165a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22165a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.f22166b, bVar);
        }
    }

    public ObservablePublishSelector(io.reactivex.u<T> uVar, io.reactivex.b.o<? super io.reactivex.p<T>, ? extends io.reactivex.u<R>> oVar) {
        super(uVar);
        this.f22164b = oVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super R> wVar) {
        PublishSubject publishSubjectC = PublishSubject.c();
        try {
            io.reactivex.u<R> uVarApply = this.f22164b.apply(publishSubjectC);
            io.reactivex.internal.functions.a.a(uVarApply, "The selector returned a null ObservableSource");
            io.reactivex.u<R> uVar = uVarApply;
            TargetObserver targetObserver = new TargetObserver(wVar);
            uVar.subscribe(targetObserver);
            this.f22358a.subscribe(new a(publishSubjectC, targetObserver));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
        }
    }
}
