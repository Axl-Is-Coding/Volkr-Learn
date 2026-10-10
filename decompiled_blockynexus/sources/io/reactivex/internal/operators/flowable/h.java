package io.reactivex.internal.operators.flowable;

import io.reactivex.p;
import io.reactivex.w;

/* JADX INFO: compiled from: FlowableFromObservable.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends io.reactivex.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p<T> f21921b;

    /* JADX INFO: compiled from: FlowableFromObservable.java */
    static final class a<T> implements w<T>, f.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f.b.c<? super T> f21922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        io.reactivex.disposables.b f21923b;

        a(f.b.c<? super T> cVar) {
            this.f21922a = cVar;
        }

        @Override // f.b.d
        public void cancel() {
            this.f21923b.dispose();
        }

        @Override // io.reactivex.w
        public void onComplete() {
            this.f21922a.onComplete();
        }

        @Override // io.reactivex.w
        public void onError(Throwable th) {
            this.f21922a.onError(th);
        }

        @Override // io.reactivex.w
        public void onNext(T t) {
            this.f21922a.onNext(t);
        }

        @Override // io.reactivex.w
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.f21923b = bVar;
            this.f21922a.onSubscribe(this);
        }

        @Override // f.b.d
        public void request(long j) {
        }
    }

    public h(p<T> pVar) {
        this.f21921b = pVar;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        this.f21921b.subscribe(new a(cVar));
    }
}
