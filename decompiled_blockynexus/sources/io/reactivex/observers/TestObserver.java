package io.reactivex.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.w;
import io.reactivex.z;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class TestObserver<T> extends a<T, TestObserver<T>> implements w<T>, io.reactivex.disposables.b, k<T>, z<T>, io.reactivex.b {
    private final w<? super T> i;
    private final AtomicReference<io.reactivex.disposables.b> j;
    private io.reactivex.c.a.f<T> k;

    enum EmptyObserver implements w<Object> {
        INSTANCE;

        @Override // io.reactivex.w
        public void onComplete() {
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.w
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.j);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.j.get());
    }

    @Override // io.reactivex.w
    public void onComplete() {
        if (!this.f22743f) {
            this.f22743f = true;
            if (this.j.get() == null) {
                this.f22740c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f22742e = Thread.currentThread();
            this.f22741d++;
            this.i.onComplete();
        } finally {
            this.f22738a.countDown();
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        if (!this.f22743f) {
            this.f22743f = true;
            if (this.j.get() == null) {
                this.f22740c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f22742e = Thread.currentThread();
            if (th == null) {
                this.f22740c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f22740c.add(th);
            }
            this.i.onError(th);
        } finally {
            this.f22738a.countDown();
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        if (!this.f22743f) {
            this.f22743f = true;
            if (this.j.get() == null) {
                this.f22740c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f22742e = Thread.currentThread();
        if (this.h != 2) {
            this.f22739b.add(t);
            if (t == null) {
                this.f22740c.add(new NullPointerException("onNext received a null value"));
            }
            this.i.onNext(t);
            return;
        }
        while (true) {
            try {
                T tPoll = this.k.poll();
                if (tPoll == null) {
                    return;
                } else {
                    this.f22739b.add(tPoll);
                }
            } catch (Throwable th) {
                this.f22740c.add(th);
                this.k.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        this.f22742e = Thread.currentThread();
        if (bVar == null) {
            this.f22740c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.j.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (this.j.get() != DisposableHelper.DISPOSED) {
                this.f22740c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
                return;
            }
            return;
        }
        int i = this.g;
        if (i != 0 && (bVar instanceof io.reactivex.c.a.f)) {
            this.k = (io.reactivex.c.a.f) bVar;
            int iRequestFusion = this.k.requestFusion(i);
            this.h = iRequestFusion;
            if (iRequestFusion == 1) {
                this.f22743f = true;
                this.f22742e = Thread.currentThread();
                while (true) {
                    try {
                        T tPoll = this.k.poll();
                        if (tPoll == null) {
                            this.f22741d++;
                            this.j.lazySet(DisposableHelper.DISPOSED);
                            return;
                        }
                        this.f22739b.add(tPoll);
                    } catch (Throwable th) {
                        this.f22740c.add(th);
                        return;
                    }
                }
            }
        }
        this.i.onSubscribe(bVar);
    }

    @Override // io.reactivex.k
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    public TestObserver(w<? super T> wVar) {
        this.j = new AtomicReference<>();
        this.i = wVar;
    }
}
