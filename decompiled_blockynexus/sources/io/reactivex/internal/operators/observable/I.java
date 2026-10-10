package io.reactivex.internal.operators.observable;

/* JADX INFO: compiled from: ObservableFromArray.java */
/* JADX INFO: loaded from: classes5.dex */
public final class I<T> extends io.reactivex.p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final T[] f22030a;

    /* JADX INFO: compiled from: ObservableFromArray.java */
    static final class a<T> extends io.reactivex.internal.observers.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.w<? super T> f22031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T[] f22032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f22033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f22034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f22035e;

        a(io.reactivex.w<? super T> wVar, T[] tArr) {
            this.f22031a = wVar;
            this.f22032b = tArr;
        }

        void a() {
            T[] tArr = this.f22032b;
            int length = tArr.length;
            for (int i = 0; i < length && !isDisposed(); i++) {
                T t = tArr[i];
                if (t == null) {
                    this.f22031a.onError(new NullPointerException("The element at index " + i + " is null"));
                    return;
                }
                this.f22031a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.f22031a.onComplete();
        }

        @Override // io.reactivex.c.a.k
        public void clear() {
            this.f22033c = this.f22032b.length;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f22035e = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f22035e;
        }

        @Override // io.reactivex.c.a.k
        public boolean isEmpty() {
            return this.f22033c == this.f22032b.length;
        }

        @Override // io.reactivex.c.a.k
        public T poll() {
            int i = this.f22033c;
            T[] tArr = this.f22032b;
            if (i == tArr.length) {
                return null;
            }
            this.f22033c = i + 1;
            T t = tArr[i];
            io.reactivex.internal.functions.a.a((Object) t, "The array element is null");
            return t;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f22034d = true;
            return 1;
        }
    }

    public I(T[] tArr) {
        this.f22030a = tArr;
    }

    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super T> wVar) {
        a aVar = new a(wVar, this.f22030a);
        wVar.onSubscribe(aVar);
        if (aVar.f22034d) {
            return;
        }
        aVar.a();
    }
}
