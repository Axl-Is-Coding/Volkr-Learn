package io.reactivex.internal.operators.single;

import io.reactivex.A;
import io.reactivex.b.o;
import io.reactivex.disposables.b;
import io.reactivex.y;
import io.reactivex.z;

/* JADX INFO: compiled from: SingleMap.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a<T, R> extends y<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final A<? extends T> f22634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final o<? super T, ? extends R> f22635b;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.single.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SingleMap.java */
    static final class C0205a<T, R> implements z<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final z<? super R> f22636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final o<? super T, ? extends R> f22637b;

        C0205a(z<? super R> zVar, o<? super T, ? extends R> oVar) {
            this.f22636a = zVar;
            this.f22637b = oVar;
        }

        @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
        public void onError(Throwable th) {
            this.f22636a.onError(th);
        }

        @Override // io.reactivex.z, io.reactivex.b, io.reactivex.k
        public void onSubscribe(b bVar) {
            this.f22636a.onSubscribe(bVar);
        }

        @Override // io.reactivex.z, io.reactivex.k
        public void onSuccess(T t) {
            try {
                R rApply = this.f22637b.apply(t);
                io.reactivex.internal.functions.a.a(rApply, "The mapper function returned a null value.");
                this.f22636a.onSuccess(rApply);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.b(th);
                onError(th);
            }
        }
    }

    public a(A<? extends T> a2, o<? super T, ? extends R> oVar) {
        this.f22634a = a2;
        this.f22635b = oVar;
    }

    @Override // io.reactivex.y
    protected void b(z<? super R> zVar) {
        this.f22634a.a(new C0205a(zVar, this.f22635b));
    }
}
