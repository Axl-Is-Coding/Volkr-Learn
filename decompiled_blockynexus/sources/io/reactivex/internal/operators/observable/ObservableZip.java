package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableZip<T, R> extends io.reactivex.p<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<? extends T>[] f22293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Iterable<? extends io.reactivex.u<? extends T>> f22294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.o<? super Object[], ? extends R> f22295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f22297e;

    static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final io.reactivex.w<? super R> downstream;
        final a<T, R>[] observers;
        final T[] row;
        final io.reactivex.b.o<? super Object[], ? extends R> zipper;

        ZipCoordinator(io.reactivex.w<? super R> wVar, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i, boolean z) {
            this.downstream = wVar;
            this.zipper = oVar;
            this.observers = new a[i];
            this.row = (T[]) new Object[i];
            this.delayError = z;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            for (a<T, R> aVar : this.observers) {
                aVar.a();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, io.reactivex.w<? super R> wVar, boolean z3, a<?, ?> aVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = aVar.f22301d;
                this.cancelled = true;
                cancel();
                if (th != null) {
                    wVar.onError(th);
                } else {
                    wVar.onComplete();
                }
                return true;
            }
            Throwable th2 = aVar.f22301d;
            if (th2 != null) {
                this.cancelled = true;
                cancel();
                wVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.cancelled = true;
            cancel();
            wVar.onComplete();
            return true;
        }

        void clear() {
            for (a<T, R> aVar : this.observers) {
                aVar.f22299b.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelSources();
            if (getAndIncrement() == 0) {
                clear();
            }
        }

        public void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            a<T, R>[] aVarArr = this.observers;
            io.reactivex.w<? super R> wVar = this.downstream;
            T[] tArr = this.row;
            boolean z = this.delayError;
            int iAddAndGet = 1;
            while (true) {
                int i = 0;
                int i2 = 0;
                for (a<T, R> aVar : aVarArr) {
                    if (tArr[i2] == null) {
                        boolean z2 = aVar.f22300c;
                        T tPoll = aVar.f22299b.poll();
                        boolean z3 = tPoll == null;
                        if (checkTerminated(z2, z3, wVar, z, aVar)) {
                            return;
                        }
                        if (z3) {
                            i++;
                        } else {
                            tArr[i2] = tPoll;
                        }
                    } else if (aVar.f22300c && !z && (th = aVar.f22301d) != null) {
                        this.cancelled = true;
                        cancel();
                        wVar.onError(th);
                        return;
                    }
                    i2++;
                }
                if (i != 0) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    try {
                        R rApply = this.zipper.apply(tArr.clone());
                        io.reactivex.internal.functions.a.a(rApply, "The zipper returned a null value");
                        wVar.onNext(rApply);
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        cancel();
                        wVar.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void subscribe(io.reactivex.u<? extends T>[] uVarArr, int i) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                aVarArr[i2] = new a<>(this, i);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
                uVarArr[i3].subscribe(aVarArr[i3]);
            }
        }
    }

    static final class a<T, R> implements io.reactivex.w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ZipCoordinator<T, R> f22298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.internal.queue.a<T> f22299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f22300c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Throwable f22301d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f22302e = new AtomicReference<>();

        a(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.f22298a = zipCoordinator;
            this.f22299b = new io.reactivex.internal.queue.a<>(i);
        }

        public void a() {
            DisposableHelper.dispose(this.f22302e);
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22300c = true;
            this.f22298a.drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22301d = th;
            this.f22300c = true;
            this.f22298a.drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22299b.offer(t);
            this.f22298a.drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.f22302e, bVar);
        }
    }

    public ObservableZip(io.reactivex.u<? extends T>[] uVarArr, Iterable<? extends io.reactivex.u<? extends T>> iterable, io.reactivex.b.o<? super Object[], ? extends R> oVar, int i, boolean z) {
        this.f22293a = uVarArr;
        this.f22294b = iterable;
        this.f22295c = oVar;
        this.f22296d = i;
        this.f22297e = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super R> wVar) {
        int length;
        io.reactivex.u<? extends T>[] uVarArr = this.f22293a;
        if (uVarArr == null) {
            uVarArr = new io.reactivex.p[8];
            length = 0;
            for (io.reactivex.u<? extends T> uVar : this.f22294b) {
                if (length == uVarArr.length) {
                    io.reactivex.u<? extends T>[] uVarArr2 = new io.reactivex.u[(length >> 2) + length];
                    System.arraycopy(uVarArr, 0, uVarArr2, 0, length);
                    uVarArr = uVarArr2;
                }
                uVarArr[length] = uVar;
                length++;
            }
        } else {
            length = uVarArr.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(wVar);
        } else {
            new ZipCoordinator(wVar, this.f22295c, length, this.f22297e).subscribe(uVarArr, this.f22296d);
        }
    }
}
