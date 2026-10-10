package io.reactivex.internal.operators.flowable;

import io.reactivex.b.o;

/* JADX INFO: compiled from: FlowableMap.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k<T, U> extends io.reactivex.internal.operators.flowable.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final o<? super T, ? extends U> f21929c;

    /* JADX INFO: compiled from: FlowableMap.java */
    static final class a<T, U> extends io.reactivex.internal.subscribers.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final o<? super T, ? extends U> f21930f;

        a(io.reactivex.c.a.a<? super U> aVar, o<? super T, ? extends U> oVar) {
            super(aVar);
            this.f21930f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // f.b.c
        public void onNext(T t) {
            if (this.f22715d) {
                return;
            }
            if (this.f22716e != 0) {
                this.f22712a.onNext(null);
                return;
            }
            try {
                U uApply = this.f21930f.apply(t);
                io.reactivex.internal.functions.a.a(uApply, "The mapper function returned a null value.");
                this.f22712a.onNext((Object) uApply);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public U poll() throws Exception {
            T tPoll = this.f22714c.poll();
            if (tPoll == null) {
                return null;
            }
            U uApply = this.f21930f.apply(tPoll);
            io.reactivex.internal.functions.a.a(uApply, "The mapper function returned a null value.");
            return uApply;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.c.a.a
        public boolean tryOnNext(T t) {
            if (this.f22715d) {
                return false;
            }
            try {
                U uApply = this.f21930f.apply(t);
                io.reactivex.internal.functions.a.a(uApply, "The mapper function returned a null value.");
                return this.f22712a.tryOnNext((Object) uApply);
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }
    }

    /* JADX INFO: compiled from: FlowableMap.java */
    static final class b<T, U> extends io.reactivex.internal.subscribers.b<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final o<? super T, ? extends U> f21931f;

        b(f.b.c<? super U> cVar, o<? super T, ? extends U> oVar) {
            super(cVar);
            this.f21931f = oVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // f.b.c
        public void onNext(T t) {
            if (this.f22720d) {
                return;
            }
            if (this.f22721e != 0) {
                this.f22717a.onNext(null);
                return;
            }
            try {
                U uApply = this.f21931f.apply(t);
                io.reactivex.internal.functions.a.a(uApply, "The mapper function returned a null value.");
                this.f22717a.onNext((Object) uApply);
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public U poll() throws Exception {
            T tPoll = this.f22719c.poll();
            if (tPoll == null) {
                return null;
            }
            U uApply = this.f21931f.apply(tPoll);
            io.reactivex.internal.functions.a.a(uApply, "The mapper function returned a null value.");
            return uApply;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public k(io.reactivex.e<T> eVar, o<? super T, ? extends U> oVar) {
        super(eVar);
        this.f21929c = oVar;
    }

    @Override // io.reactivex.e
    protected void b(f.b.c<? super U> cVar) {
        if (cVar instanceof io.reactivex.c.a.a) {
            this.f21902b.a((io.reactivex.h) new a((io.reactivex.c.a.a) cVar, this.f21929c));
        } else {
            this.f21902b.a((io.reactivex.h) new b(cVar, this.f21929c));
        }
    }
}
