package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWithLatestFromMany<T, R> extends AbstractC2904a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<?>[] f22289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Iterable<? extends io.reactivex.u<?>> f22290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final io.reactivex.b.o<? super Object[], R> f22291d;

    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1577321883966341961L;
        final io.reactivex.b.o<? super Object[], R> combiner;
        volatile boolean done;
        final io.reactivex.w<? super R> downstream;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReference<io.reactivex.disposables.b> upstream;
        final AtomicReferenceArray<Object> values;

        WithLatestFromObserver(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super Object[], R> oVar, int i) {
            this.downstream = wVar;
            this.combiner = oVar;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerObserverArr[i2] = new WithLatestInnerObserver(this, i2);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i);
            this.upstream = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        void cancelAllBut(int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerObserverArr[i2].dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.dispose();
            }
        }

        void innerComplete(int i, boolean z) {
            if (z) {
                return;
            }
            this.done = true;
            cancelAllBut(i);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        void innerError(int i, Throwable th) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            cancelAllBut(i);
            io.reactivex.internal.util.g.a((io.reactivex.w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        void innerNext(int i, Object obj) {
            this.values.set(i, obj);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.g.a(this.downstream, this, this.error);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            io.reactivex.internal.util.g.a((io.reactivex.w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            AtomicReferenceArray<Object> atomicReferenceArray = this.values;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i = 0;
            objArr[0] = t;
            while (i < length) {
                Object obj = atomicReferenceArray.get(i);
                if (obj == null) {
                    return;
                }
                i++;
                objArr[i] = obj;
            }
            try {
                R rApply = this.combiner.apply(objArr);
                io.reactivex.internal.functions.a.a(rApply, "combiner returned a null value");
                io.reactivex.internal.util.g.a(this.downstream, rApply, this, this.error);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        void subscribe(io.reactivex.u<?>[] uVarArr, int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<io.reactivex.disposables.b> atomicReference = this.upstream;
            for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i2++) {
                uVarArr[i2].subscribe(withLatestInnerObserverArr[i2]);
            }
        }
    }

    static final class WithLatestInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.parent = withLatestFromObserver;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    final class a implements io.reactivex.b.o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.lang.Object[]] */
        @Override // io.reactivex.b.o
        public R apply(T t) throws Exception {
            R rApply = ObservableWithLatestFromMany.this.f22291d.apply(new Object[]{t});
            io.reactivex.internal.functions.a.a(rApply, "The combiner returned a null value");
            return rApply;
        }
    }

    public ObservableWithLatestFromMany(io.reactivex.u<T> uVar, io.reactivex.u<?>[] uVarArr, io.reactivex.b.o<? super Object[], R> oVar) {
        super(uVar);
        this.f22289b = uVarArr;
        this.f22290c = null;
        this.f22291d = oVar;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super R> wVar) {
        int length;
        io.reactivex.u<?>[] uVarArr = this.f22289b;
        if (uVarArr == null) {
            uVarArr = new io.reactivex.u[8];
            try {
                length = 0;
                for (io.reactivex.u<?> uVar : this.f22290c) {
                    if (length == uVarArr.length) {
                        uVarArr = (io.reactivex.u[]) Arrays.copyOf(uVarArr, (length >> 1) + length);
                    }
                    int i = length + 1;
                    uVarArr[length] = uVar;
                    length = i;
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                EmptyDisposable.error(th, wVar);
                return;
            }
        } else {
            length = uVarArr.length;
        }
        if (length == 0) {
            new Y(this.f22358a, new a()).subscribeActual(wVar);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(wVar, this.f22291d, length);
        wVar.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.subscribe(uVarArr, length);
        this.f22358a.subscribe(withLatestFromObserver);
    }

    public ObservableWithLatestFromMany(io.reactivex.u<T> uVar, Iterable<? extends io.reactivex.u<?>> iterable, io.reactivex.b.o<? super Object[], R> oVar) {
        super(uVar);
        this.f22289b = null;
        this.f22290c = iterable;
        this.f22291d = oVar;
    }
}
