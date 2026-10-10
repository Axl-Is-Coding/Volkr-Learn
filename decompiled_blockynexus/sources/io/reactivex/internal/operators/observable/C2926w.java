package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: io.reactivex.internal.operators.observable.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ObservableDistinct.java */
/* JADX INFO: loaded from: classes5.dex */
public final class C2926w<T, K> extends AbstractC2904a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final io.reactivex.b.o<? super T, K> f22586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f22587c;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.w$a */
    /* JADX INFO: compiled from: ObservableDistinct.java */
    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Collection<? super K> f22588f;
        final io.reactivex.b.o<? super T, K> g;

        a(io.reactivex.w<? super T> wVar, io.reactivex.b.o<? super T, K> oVar, Collection<? super K> collection) {
            super(wVar);
            this.g = oVar;
            this.f22588f = collection;
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.c.a.k
        public void clear() {
            this.f22588f.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.w
        public void onComplete() {
            if (this.f21839d) {
                return;
            }
            this.f21839d = true;
            this.f22588f.clear();
            this.f21836a.onComplete();
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.w
        public void onError(Throwable th) {
            if (this.f21839d) {
                io.reactivex.e.a.b(th);
                return;
            }
            this.f21839d = true;
            this.f22588f.clear();
            this.f21836a.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.w
        public void onNext(T t) {
            if (this.f21839d) {
                return;
            }
            if (this.f21840e != 0) {
                this.f21836a.onNext(null);
                return;
            }
            try {
                K kApply = this.g.apply(t);
                io.reactivex.internal.functions.a.a(kApply, "The keySelector returned a null key");
                if (this.f22588f.add(kApply)) {
                    this.f21836a.onNext((Object) t);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // io.reactivex.c.a.k
        public T poll() throws Exception {
            T tPoll;
            Collection<? super K> collection;
            K kApply;
            do {
                tPoll = this.f21838c.poll();
                if (tPoll == null) {
                    break;
                }
                collection = this.f22588f;
                kApply = this.g.apply(tPoll);
                io.reactivex.internal.functions.a.a(kApply, "The keySelector returned a null key");
            } while (!collection.add(kApply));
            return tPoll;
        }

        @Override // io.reactivex.c.a.g
        public int requestFusion(int i) {
            return a(i);
        }
    }

    public C2926w(io.reactivex.u<T> uVar, io.reactivex.b.o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(uVar);
        this.f22586b = oVar;
        this.f22587c = callable;
    }

    @Override // io.reactivex.p
    protected void subscribeActual(io.reactivex.w<? super T> wVar) {
        try {
            Collection<? super K> collectionCall = this.f22587c.call();
            io.reactivex.internal.functions.a.a(collectionCall, "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
            this.f22358a.subscribe(new a(wVar, this.f22586b, collectionCall));
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
        }
    }
}
