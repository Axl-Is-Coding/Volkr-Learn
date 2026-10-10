package io.reactivex.internal.operators.flowable;

import io.reactivex.b.p;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: compiled from: FlowableDoOnLifecycle.java */
/* JADX INFO: loaded from: classes5.dex */
public final class e<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final io.reactivex.b.g<? super f.b.d> f21911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final p f21912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final io.reactivex.b.a f21913e;

    /* JADX INFO: compiled from: FlowableDoOnLifecycle.java */
    static final class a<T> implements io.reactivex.h<T>, f.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f.b.c<? super T> f21914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.b.g<? super f.b.d> f21915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final p f21916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final io.reactivex.b.a f21917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        f.b.d f21918e;

        a(f.b.c<? super T> cVar, io.reactivex.b.g<? super f.b.d> gVar, p pVar, io.reactivex.b.a aVar) {
            this.f21914a = cVar;
            this.f21915b = gVar;
            this.f21917d = aVar;
            this.f21916c = pVar;
        }

        @Override // f.b.d
        public void cancel() {
            f.b.d dVar = this.f21918e;
            SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
            if (dVar != subscriptionHelper) {
                this.f21918e = subscriptionHelper;
                try {
                    this.f21917d.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    io.reactivex.e.a.b(th);
                }
                dVar.cancel();
            }
        }

        @Override // f.b.c
        public void onComplete() {
            if (this.f21918e != SubscriptionHelper.CANCELLED) {
                this.f21914a.onComplete();
            }
        }

        @Override // f.b.c
        public void onError(Throwable th) {
            if (this.f21918e != SubscriptionHelper.CANCELLED) {
                this.f21914a.onError(th);
            } else {
                io.reactivex.e.a.b(th);
            }
        }

        @Override // f.b.c
        public void onNext(T t) {
            this.f21914a.onNext(t);
        }

        @Override // io.reactivex.h, f.b.c
        public void onSubscribe(f.b.d dVar) {
            try {
                this.f21915b.accept(dVar);
                if (SubscriptionHelper.validate(this.f21918e, dVar)) {
                    this.f21918e = dVar;
                    this.f21914a.onSubscribe(this);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                dVar.cancel();
                this.f21918e = SubscriptionHelper.CANCELLED;
                EmptySubscription.error(th, this.f21914a);
            }
        }

        @Override // f.b.d
        public void request(long j) {
            try {
                this.f21916c.accept(j);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                io.reactivex.e.a.b(th);
            }
            this.f21918e.request(j);
        }
    }

    public e(io.reactivex.e<T> eVar, io.reactivex.b.g<? super f.b.d> gVar, p pVar, io.reactivex.b.a aVar) {
        super(eVar);
        this.f21911c = gVar;
        this.f21912d = pVar;
        this.f21913e = aVar;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super T> cVar) {
        this.f21902b.a((io.reactivex.h) new a(cVar, this.f21911c, this.f21912d, this.f21913e));
    }
}
