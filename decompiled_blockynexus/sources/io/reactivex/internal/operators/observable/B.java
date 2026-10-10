package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ObservableElementAt.java */
/* JADX INFO: loaded from: classes5.dex */
public final class B<T> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f21995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final T f21996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f21997d;

    /* JADX INFO: compiled from: ObservableElementAt.java */
    static final class a<T> implements io.reactivex.w<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f21998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f21999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final T f22000c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final boolean f22001d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        io.reactivex.disposables.b f22002e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f22003f;
        boolean g;

        a(io.reactivex.w<? super T> wVar, long j, T t, boolean z) {
            this.f21998a = wVar;
            this.f21999b = j;
            this.f22000c = t;
            this.f22001d = z;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22002e.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22002e.isDisposed();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            if (this.g) {
                return;
            }
            this.g = true;
            T t = this.f22000c;
            if (t == null && this.f22001d) {
                this.f21998a.onError(new NoSuchElementException());
                return;
            }
            if (t != null) {
                this.f21998a.onNext(t);
            }
            this.f21998a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            if (this.g) {
                io.reactivex.e.a.b(th);
            } else {
                this.g = true;
                this.f21998a.onError(th);
            }
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.g) {
                return;
            }
            long j = this.f22003f;
            if (j != this.f21999b) {
                this.f22003f = j + 1;
                return;
            }
            this.g = true;
            this.f22002e.dispose();
            this.f21998a.onNext(t);
            this.f21998a.onComplete();
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.f22002e, bVar)) {
                this.f22002e = bVar;
                this.f21998a.onSubscribe(this);
            }
        }
    }

    public B(io.reactivex.u<T> uVar, long j, T t, boolean z) {
        super(uVar);
        this.f21995b = j;
        this.f21996c = t;
        this.f21997d = z;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        this.f22358a.subscribe(new a(wVar, this.f21995b, this.f21996c, this.f21997d));
    }
}
