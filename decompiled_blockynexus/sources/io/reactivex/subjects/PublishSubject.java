package io.reactivex.subjects;

import io.reactivex.w;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class PublishSubject<T> extends b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final PublishDisposable[] f22773a = new PublishDisposable[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final PublishDisposable[] f22774b = new PublishDisposable[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<PublishDisposable<T>[]> f22775c = new AtomicReference<>(f22774b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Throwable f22776d;

    static final class PublishDisposable<T> extends AtomicBoolean implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 3562861878281475070L;
        final w<? super T> downstream;
        final PublishSubject<T> parent;

        PublishDisposable(w<? super T> wVar, PublishSubject<T> publishSubject) {
            this.downstream = wVar;
            this.parent = publishSubject;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.parent.b(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get();
        }

        public void onComplete() {
            if (get()) {
                return;
            }
            this.downstream.onComplete();
        }

        public void onError(Throwable th) {
            if (get()) {
                io.reactivex.e.a.b(th);
            } else {
                this.downstream.onError(th);
            }
        }

        public void onNext(T t) {
            if (get()) {
                return;
            }
            this.downstream.onNext(t);
        }
    }

    PublishSubject() {
    }

    public static <T> PublishSubject<T> c() {
        return new PublishSubject<>();
    }

    boolean a(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f22775c.get();
            if (publishDisposableArr == f22773a) {
                return false;
            }
            int length = publishDisposableArr.length;
            publishDisposableArr2 = new PublishDisposable[length + 1];
            System.arraycopy(publishDisposableArr, 0, publishDisposableArr2, 0, length);
            publishDisposableArr2[length] = publishDisposable;
        } while (!this.f22775c.compareAndSet(publishDisposableArr, publishDisposableArr2));
        return true;
    }

    void b(PublishDisposable<T> publishDisposable) {
        PublishDisposable<T>[] publishDisposableArr;
        PublishDisposable<T>[] publishDisposableArr2;
        do {
            publishDisposableArr = this.f22775c.get();
            if (publishDisposableArr == f22773a || publishDisposableArr == f22774b) {
                return;
            }
            int length = publishDisposableArr.length;
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (publishDisposableArr[i2] == publishDisposable) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                publishDisposableArr2 = f22774b;
            } else {
                PublishDisposable<T>[] publishDisposableArr3 = new PublishDisposable[length - 1];
                System.arraycopy(publishDisposableArr, 0, publishDisposableArr3, 0, i);
                System.arraycopy(publishDisposableArr, i + 1, publishDisposableArr3, i, (length - i) - 1);
                publishDisposableArr2 = publishDisposableArr3;
            }
        } while (!this.f22775c.compareAndSet(publishDisposableArr, publishDisposableArr2));
    }

    @Override // io.reactivex.w
    public void onComplete() {
        PublishDisposable<T>[] publishDisposableArr = this.f22775c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f22773a;
        if (publishDisposableArr == publishDisposableArr2) {
            return;
        }
        for (PublishDisposable<T> publishDisposable : this.f22775c.getAndSet(publishDisposableArr2)) {
            publishDisposable.onComplete();
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        PublishDisposable<T>[] publishDisposableArr = this.f22775c.get();
        PublishDisposable<T>[] publishDisposableArr2 = f22773a;
        if (publishDisposableArr == publishDisposableArr2) {
            io.reactivex.e.a.b(th);
            return;
        }
        this.f22776d = th;
        for (PublishDisposable<T> publishDisposable : this.f22775c.getAndSet(publishDisposableArr2)) {
            publishDisposable.onError(th);
        }
    }

    @Override // io.reactivex.w
    public void onNext(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (PublishDisposable<T> publishDisposable : this.f22775c.get()) {
            publishDisposable.onNext(t);
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f22775c.get() == f22773a) {
            bVar.dispose();
        }
    }

    @Override // io.reactivex.p
    protected void subscribeActual(w<? super T> wVar) {
        PublishDisposable<T> publishDisposable = new PublishDisposable<>(wVar, this);
        wVar.onSubscribe(publishDisposable);
        if (a(publishDisposable)) {
            if (publishDisposable.isDisposed()) {
                b(publishDisposable);
            }
        } else {
            Throwable th = this.f22776d;
            if (th != null) {
                wVar.onError(th);
            } else {
                wVar.onComplete();
            }
        }
    }
}
