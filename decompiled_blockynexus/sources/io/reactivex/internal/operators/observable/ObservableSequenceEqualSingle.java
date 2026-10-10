package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableSequenceEqualSingle<T> extends io.reactivex.y<Boolean> implements io.reactivex.c.a.b<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.u<? extends T> f22220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.b.d<? super T, ? super T> f22221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22222d;

    static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final io.reactivex.b.d<? super T, ? super T> comparer;
        final io.reactivex.z<? super Boolean> downstream;
        final io.reactivex.u<? extends T> first;
        final a<T>[] observers;
        final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        final io.reactivex.u<? extends T> second;
        T v1;
        T v2;

        EqualCoordinator(io.reactivex.z<? super Boolean> zVar, int i, io.reactivex.u<? extends T> uVar, io.reactivex.u<? extends T> uVar2, io.reactivex.b.d<? super T, ? super T> dVar) {
            this.downstream = zVar;
            this.first = uVar;
            this.second = uVar2;
            this.comparer = dVar;
            this.observers = new a[]{new a<>(this, 0, i), new a<>(this, 1, i)};
        }

        void cancel(io.reactivex.internal.queue.a<T> aVar, io.reactivex.internal.queue.a<T> aVar2) {
            this.cancelled = true;
            aVar.clear();
            aVar2.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.resources.dispose();
            if (getAndIncrement() == 0) {
                a<T>[] aVarArr = this.observers;
                aVarArr[0].f22224b.clear();
                aVarArr[1].f22224b.clear();
            }
        }

        void drain() {
            Throwable th;
            Throwable th2;
            if (getAndIncrement() != 0) {
                return;
            }
            a<T>[] aVarArr = this.observers;
            a<T> aVar = aVarArr[0];
            io.reactivex.internal.queue.a<T> aVar2 = aVar.f22224b;
            a<T> aVar3 = aVarArr[1];
            io.reactivex.internal.queue.a<T> aVar4 = aVar3.f22224b;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                boolean z = aVar.f22226d;
                if (z && (th2 = aVar.f22227e) != null) {
                    cancel(aVar2, aVar4);
                    this.downstream.onError(th2);
                    return;
                }
                boolean z2 = aVar3.f22226d;
                if (z2 && (th = aVar3.f22227e) != null) {
                    cancel(aVar2, aVar4);
                    this.downstream.onError(th);
                    return;
                }
                if (this.v1 == null) {
                    this.v1 = aVar2.poll();
                }
                boolean z3 = this.v1 == null;
                if (this.v2 == null) {
                    this.v2 = aVar4.poll();
                }
                boolean z4 = this.v2 == null;
                if (z && z2 && z3 && z4) {
                    this.downstream.onSuccess(true);
                    return;
                }
                if (z && z2 && z3 != z4) {
                    cancel(aVar2, aVar4);
                    this.downstream.onSuccess(false);
                    return;
                }
                if (!z3 && !z4) {
                    try {
                        if (!this.comparer.test(this.v1, this.v2)) {
                            cancel(aVar2, aVar4);
                            this.downstream.onSuccess(false);
                            return;
                        } else {
                            this.v1 = null;
                            this.v2 = null;
                        }
                    } catch (Throwable th3) {
                        io.reactivex.exceptions.a.b(th3);
                        cancel(aVar2, aVar4);
                        this.downstream.onError(th3);
                        return;
                    }
                }
                if (z3 || z4) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            aVar2.clear();
            aVar4.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        boolean setDisposable(io.reactivex.disposables.b bVar, int i) {
            return this.resources.setResource(i, bVar);
        }

        void subscribe() {
            a<T>[] aVarArr = this.observers;
            this.first.subscribe(aVarArr[0]);
            this.second.subscribe(aVarArr[1]);
        }
    }

    static final class a<T> implements io.reactivex.w<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EqualCoordinator<T> f22223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.internal.queue.a<T> f22224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f22225c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile boolean f22226d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Throwable f22227e;

        a(EqualCoordinator<T> equalCoordinator, int i, int i2) {
            this.f22223a = equalCoordinator;
            this.f22225c = i;
            this.f22224b = new io.reactivex.internal.queue.a<>(i2);
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22226d = true;
            this.f22223a.drain();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22227e = th;
            this.f22226d = true;
            this.f22223a.drain();
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f22224b.offer(t);
            this.f22223a.drain();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f22223a.setDisposable(bVar, this.f22225c);
        }
    }

    public ObservableSequenceEqualSingle(io.reactivex.u<? extends T> uVar, io.reactivex.u<? extends T> uVar2, io.reactivex.b.d<? super T, ? super T> dVar, int i) {
        this.f22219a = uVar;
        this.f22220b = uVar2;
        this.f22221c = dVar;
        this.f22222d = i;
    }

    @Override // io.reactivex.c.a.b
    public io.reactivex.p<Boolean> a() {
        return io.reactivex.e.a.a(new ObservableSequenceEqual(this.f22219a, this.f22220b, this.f22221c, this.f22222d));
    }

    @Override // io.reactivex.y
    public void b(io.reactivex.z<? super Boolean> zVar) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(zVar, this.f22222d, this.f22219a, this.f22220b, this.f22221c);
        zVar.onSubscribe(equalCoordinator);
        equalCoordinator.subscribe();
    }
}
