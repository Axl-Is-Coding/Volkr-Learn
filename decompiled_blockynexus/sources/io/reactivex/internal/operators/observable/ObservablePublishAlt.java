package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublishAlt<T> extends io.reactivex.d.a<T> implements io.reactivex.c.a.d<T>, io.reactivex.internal.disposables.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<PublishConnection<T>> f22163b = new AtomicReference<>();

    static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 7463222674719692880L;
        final io.reactivex.w<? super T> downstream;

        public InnerDisposable(io.reactivex.w<? super T> wVar, PublishConnection<T> publishConnection) {
            this.downstream = wVar;
            lazySet(publishConnection);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            PublishConnection<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.remove(this);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == null;
        }
    }

    static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements io.reactivex.w<T>, io.reactivex.disposables.b {
        static final InnerDisposable[] EMPTY = new InnerDisposable[0];
        static final InnerDisposable[] TERMINATED = new InnerDisposable[0];
        private static final long serialVersionUID = -3251430252873581268L;
        final AtomicReference<PublishConnection<T>> current;
        Throwable error;
        final AtomicBoolean connect = new AtomicBoolean();
        final AtomicReference<io.reactivex.disposables.b> upstream = new AtomicReference<>();

        public PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.current = atomicReference;
            lazySet(EMPTY);
        }

        public boolean add(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                if (innerDisposableArr == TERMINATED) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            getAndSet(TERMINATED);
            this.current.compareAndSet(this, null);
            DisposableHelper.dispose(this.upstream);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == TERMINATED;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(TERMINATED)) {
                innerDisposable.downstream.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.error = th;
            this.upstream.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable<T> innerDisposable : getAndSet(TERMINATED)) {
                innerDisposable.downstream.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : get()) {
                innerDisposable.downstream.onNext(t);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }

        public void remove(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = get();
                int length = innerDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (innerDisposableArr[i2] == innerDisposable) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                innerDisposableArr2 = EMPTY;
                if (length != 1) {
                    innerDisposableArr2 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr2, i, (length - i) - 1);
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }
    }

    public ObservablePublishAlt(io.reactivex.u<T> uVar) {
        this.f22162a = uVar;
    }

    @Override // io.reactivex.d.a
    public void a(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f22163b.get();
            if (publishConnection != null && !publishConnection.isDisposed()) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f22163b);
            if (this.f22163b.compareAndSet(publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        boolean z = !publishConnection.connect.get() && publishConnection.connect.compareAndSet(false, true);
        try {
            gVar.accept(publishConnection);
            if (z) {
                this.f22162a.subscribe(publishConnection);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw ExceptionHelper.b(th);
        }
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        PublishConnection<T> publishConnection;
        while (true) {
            publishConnection = this.f22163b.get();
            if (publishConnection != null) {
                break;
            }
            PublishConnection<T> publishConnection2 = new PublishConnection<>(this.f22163b);
            if (this.f22163b.compareAndSet(publishConnection, publishConnection2)) {
                publishConnection = publishConnection2;
                break;
            }
        }
        InnerDisposable<T> innerDisposable = new InnerDisposable<>(wVar, publishConnection);
        wVar.onSubscribe(innerDisposable);
        if (publishConnection.add(innerDisposable)) {
            if (innerDisposable.isDisposed()) {
                publishConnection.remove(innerDisposable);
            }
        } else {
            Throwable th = publishConnection.error;
            if (th != null) {
                wVar.onError(th);
            } else {
                wVar.onComplete();
            }
        }
    }

    @Override // io.reactivex.internal.disposables.c
    public void a(io.reactivex.disposables.b bVar) {
        this.f22163b.compareAndSet((PublishConnection) bVar, null);
    }
}
