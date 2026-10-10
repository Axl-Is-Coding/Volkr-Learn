package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableWindow<T> extends AbstractC2904a<T, io.reactivex.p<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f22276d;

    static final class WindowExactObserver<T> extends AtomicInteger implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final io.reactivex.w<? super io.reactivex.p<T>> downstream;
        long size;
        io.reactivex.disposables.b upstream;
        UnicastSubject<T> window;

        WindowExactObserver(io.reactivex.w<? super io.reactivex.p<T>> wVar, long j, int i) {
            this.downstream = wVar;
            this.count = j;
            this.capacityHint = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            UnicastSubject<T> unicastSubject = this.window;
            if (unicastSubject != null) {
                this.window = null;
                unicastSubject.onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            UnicastSubject<T> unicastSubjectA = this.window;
            if (unicastSubjectA == null && !this.cancelled) {
                unicastSubjectA = UnicastSubject.a(this.capacityHint, this);
                this.window = unicastSubjectA;
                this.downstream.onNext(unicastSubjectA);
            }
            if (unicastSubjectA != null) {
                unicastSubjectA.onNext(t);
                long j = this.size + 1;
                this.size = j;
                if (j >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    unicastSubjectA.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
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

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    static final class WindowSkipObserver<T> extends AtomicBoolean implements io.reactivex.w<T>, io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final io.reactivex.w<? super io.reactivex.p<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        io.reactivex.disposables.b upstream;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<UnicastSubject<T>> windows = new ArrayDeque<>();

        WindowSkipObserver(io.reactivex.w<? super io.reactivex.p<T>> wVar, long j, long j2, int i) {
            this.downstream = wVar;
            this.count = j;
            this.skip = j2;
            this.capacityHint = i;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th);
            }
            this.downstream.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            ArrayDeque<UnicastSubject<T>> arrayDeque = this.windows;
            long j = this.index;
            long j2 = this.skip;
            if (j % j2 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                UnicastSubject<T> unicastSubjectA = UnicastSubject.a(this.capacityHint, this);
                arrayDeque.offer(unicastSubjectA);
                this.downstream.onNext(unicastSubjectA);
            }
            long j3 = this.firstEmission + 1;
            Iterator<UnicastSubject<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            if (j3 >= this.count) {
                arrayDeque.poll().onComplete();
                if (arrayDeque.isEmpty() && this.cancelled) {
                    this.upstream.dispose();
                    return;
                }
                this.firstEmission = j3 - j2;
            } else {
                this.firstEmission = j3;
            }
            this.index = j + 1;
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public ObservableWindow(io.reactivex.u<T> uVar, long j, long j2, int i) {
        super(uVar);
        this.f22274b = j;
        this.f22275c = j2;
        this.f22276d = i;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super io.reactivex.p<T>> wVar) {
        long j = this.f22274b;
        long j2 = this.f22275c;
        if (j == j2) {
            this.f22358a.subscribe(new WindowExactObserver(wVar, j, this.f22276d));
        } else {
            this.f22358a.subscribe(new WindowSkipObserver(wVar, j, j2, this.f22276d));
        }
    }
}
