package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservablePublish<T> extends io.reactivex.d.a<T> implements io.reactivex.c.a.d<T>, ea<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.u<T> f22152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>> f22153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final io.reactivex.u<T> f22154c;

    static final class InnerDisposable<T> extends AtomicReference<Object> implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -1100270633763673112L;
        final io.reactivex.w<? super T> child;

        InnerDisposable(io.reactivex.w<? super T> wVar) {
            this.child = wVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((a) andSet).b(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == this;
        }

        void setParent(a<T> aVar) {
            if (compareAndSet(null, aVar)) {
                return;
            }
            aVar.b(this);
        }
    }

    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final InnerDisposable[] f22155a = new InnerDisposable[0];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final InnerDisposable[] f22156b = new InnerDisposable[0];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference<a<T>> f22157c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReference<io.reactivex.disposables.b> f22160f = new AtomicReference<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final AtomicReference<InnerDisposable<T>[]> f22158d = new AtomicReference<>(f22155a);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicBoolean f22159e = new AtomicBoolean();

        a(AtomicReference<a<T>> atomicReference) {
            this.f22157c = atomicReference;
        }

        boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f22158d.get();
                if (innerDisposableArr == f22156b) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[length + 1];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!this.f22158d.compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        void b(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable<T>[] innerDisposableArr2;
            do {
                innerDisposableArr = this.f22158d.get();
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
                    if (innerDisposableArr[i2].equals(innerDisposable)) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    innerDisposableArr2 = f22155a;
                } else {
                    InnerDisposable<T>[] innerDisposableArr3 = new InnerDisposable[length - 1];
                    System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i);
                    System.arraycopy(innerDisposableArr, i + 1, innerDisposableArr3, i, (length - i) - 1);
                    innerDisposableArr2 = innerDisposableArr3;
                }
            } while (!this.f22158d.compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f22158d.getAndSet(f22156b) != f22156b) {
                this.f22157c.compareAndSet(this, null);
                DisposableHelper.dispose(this.f22160f);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22158d.get() == f22156b;
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f22157c.compareAndSet(this, null);
            for (InnerDisposable<T> innerDisposable : this.f22158d.getAndSet(f22156b)) {
                innerDisposable.child.onComplete();
            }
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f22157c.compareAndSet(this, null);
            InnerDisposable<T>[] andSet = this.f22158d.getAndSet(f22156b);
            if (andSet.length == 0) {
                io.reactivex.e.a.b(th);
                return;
            }
            for (InnerDisposable<T> innerDisposable : andSet) {
                innerDisposable.child.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            for (InnerDisposable<T> innerDisposable : this.f22158d.get()) {
                innerDisposable.child.onNext(t);
            }
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.f22160f, bVar);
        }
    }

    static final class b<T> implements io.reactivex.u<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicReference<a<T>> f22161a;

        b(AtomicReference<a<T>> atomicReference) {
            this.f22161a = atomicReference;
        }

        @Override // io.reactivex.u
        public void subscribe(io.reactivex.w<? super T> wVar) {
            InnerDisposable innerDisposable = new InnerDisposable(wVar);
            wVar.onSubscribe(innerDisposable);
            while (true) {
                a<T> aVar = this.f22161a.get();
                if (aVar == null || aVar.isDisposed()) {
                    a<T> aVar2 = new a<>(this.f22161a);
                    if (this.f22161a.compareAndSet(aVar, aVar2)) {
                        aVar = aVar2;
                    } else {
                        continue;
                    }
                }
                if (aVar.a(innerDisposable)) {
                    innerDisposable.setParent(aVar);
                    return;
                }
            }
        }
    }

    private ObservablePublish(io.reactivex.u<T> uVar, io.reactivex.u<T> uVar2, AtomicReference<a<T>> atomicReference) {
        this.f22154c = uVar;
        this.f22152a = uVar2;
        this.f22153b = atomicReference;
    }

    public static <T> io.reactivex.d.a<T> a(io.reactivex.u<T> uVar) {
        AtomicReference atomicReference = new AtomicReference();
        return io.reactivex.e.a.a((io.reactivex.d.a) new ObservablePublish(new b(atomicReference), uVar, atomicReference));
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22154c.subscribe(wVar);
    }

    @Override // io.reactivex.internal.operators.observable.ea
    public io.reactivex.u<T> a() {
        return this.f22152a;
    }

    @Override // io.reactivex.d.a
    public void a(io.reactivex.b.g<? super io.reactivex.disposables.b> gVar) {
        a<T> aVar;
        while (true) {
            aVar = this.f22153b.get();
            if (aVar != null && !aVar.isDisposed()) {
                break;
            }
            a<T> aVar2 = new a<>(this.f22153b);
            if (this.f22153b.compareAndSet(aVar, aVar2)) {
                aVar = aVar2;
                break;
            }
        }
        boolean z = !aVar.f22159e.get() && aVar.f22159e.compareAndSet(false, true);
        try {
            gVar.accept(aVar);
            if (z) {
                this.f22152a.subscribe(aVar);
            }
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            throw ExceptionHelper.b(th);
        }
    }
}
