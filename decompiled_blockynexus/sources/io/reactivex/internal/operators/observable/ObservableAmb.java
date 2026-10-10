package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableAmb<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<? extends T>[] f22060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends io.reactivex.u<? extends T>> f22061b;

    static final class AmbInnerObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.w<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final io.reactivex.w<? super T> downstream;
        final int index;
        final a<T> parent;
        boolean won;

        AmbInnerObserver(a<T> aVar, int i, io.reactivex.w<? super T> wVar) {
            this.parent = aVar;
            this.index = i;
            this.downstream = wVar;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.a(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.won) {
                this.downstream.onError(th);
            } else if (!this.parent.a(this.index)) {
                io.reactivex.e.a.b(th);
            } else {
                this.won = true;
                this.downstream.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.won) {
                this.downstream.onNext(t);
            } else if (!this.parent.a(this.index)) {
                get().dispose();
            } else {
                this.won = true;
                this.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableAmb(io.reactivex.u<? extends T>[] uVarArr, Iterable<? extends io.reactivex.u<? extends T>> iterable) {
        this.f22060a = uVarArr;
        this.f22061b = iterable;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        int length;
        io.reactivex.u<? extends T>[] uVarArr = this.f22060a;
        if (uVarArr == null) {
            uVarArr = new io.reactivex.p[8];
            try {
                length = 0;
                for (io.reactivex.u<? extends T> uVar : this.f22061b) {
                    if (uVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), wVar);
                        return;
                    }
                    if (length == uVarArr.length) {
                        io.reactivex.u<? extends T>[] uVarArr2 = new io.reactivex.u[(length >> 2) + length];
                        System.arraycopy(uVarArr, 0, uVarArr2, 0, length);
                        uVarArr = uVarArr2;
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
            EmptyDisposable.complete(wVar);
        } else if (length == 1) {
            uVarArr[0].subscribe(wVar);
        } else {
            new a(wVar, length).a(uVarArr);
        }
    }

    static final class a<T> implements io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AmbInnerObserver<T>[] f22063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicInteger f22064c = new AtomicInteger();

        a(io.reactivex.w<? super T> wVar, int i) {
            this.f22062a = wVar;
            this.f22063b = new AmbInnerObserver[i];
        }

        public void a(io.reactivex.u<? extends T>[] uVarArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f22063b;
            int length = ambInnerObserverArr.length;
            int i = 0;
            while (i < length) {
                int i2 = i + 1;
                ambInnerObserverArr[i] = new AmbInnerObserver<>(this, i2, this.f22062a);
                i = i2;
            }
            this.f22064c.lazySet(0);
            this.f22062a.onSubscribe(this);
            for (int i3 = 0; i3 < length && this.f22064c.get() == 0; i3++) {
                uVarArr[i3].subscribe(ambInnerObserverArr[i3]);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f22064c.get() != -1) {
                this.f22064c.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.f22063b) {
                    ambInnerObserver.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22064c.get() == -1;
        }

        public boolean a(int i) {
            int i2 = this.f22064c.get();
            int i3 = 0;
            if (i2 != 0) {
                return i2 == i;
            }
            if (!this.f22064c.compareAndSet(0, i)) {
                return false;
            }
            AmbInnerObserver<T>[] ambInnerObserverArr = this.f22063b;
            int length = ambInnerObserverArr.length;
            while (i3 < length) {
                int i4 = i3 + 1;
                if (i4 != i) {
                    ambInnerObserverArr[i3].dispose();
                }
                i3 = i4;
            }
            return true;
        }
    }
}
