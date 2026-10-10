package io.reactivex.internal.operators.flowable;

import a.a.h;
import io.reactivex.b.o;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.ScalarSubscription;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: FlowableScalarXMap.java */
/* JADX INFO: loaded from: classes5.dex */
public final class m {

    /* JADX INFO: compiled from: FlowableScalarXMap.java */
    static final class a<T, R> extends io.reactivex.e<R> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T f21932b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o<? super T, ? extends f.b.b<? extends R>> f21933c;

        a(T t, o<? super T, ? extends f.b.b<? extends R>> oVar) {
            this.f21932b = t;
            this.f21933c = oVar;
        }

        @Override // io.reactivex.e
        public void b(f.b.c<? super R> cVar) {
            try {
                f.b.b<? extends R> bVarApply = this.f21933c.apply(this.f21932b);
                io.reactivex.internal.functions.a.a(bVarApply, "The mapper returned a null Publisher");
                f.b.b<? extends R> bVar = bVarApply;
                if (!(bVar instanceof Callable)) {
                    bVar.a(cVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) bVar).call();
                    if (objCall == null) {
                        EmptySubscription.complete(cVar);
                    } else {
                        cVar.onSubscribe(new ScalarSubscription(cVar, objCall));
                    }
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    EmptySubscription.error(th, cVar);
                }
            } catch (Throwable th2) {
                EmptySubscription.error(th2, cVar);
            }
        }
    }

    public static <T, R> boolean a(f.b.b<T> bVar, f.b.c<? super R> cVar, o<? super T, ? extends f.b.b<? extends R>> oVar) {
        if (!(bVar instanceof Callable)) {
            return false;
        }
        try {
            h.a aVar = (Object) ((Callable) bVar).call();
            if (aVar == null) {
                EmptySubscription.complete(cVar);
                return true;
            }
            try {
                f.b.b<? extends R> bVarApply = oVar.apply(aVar);
                io.reactivex.internal.functions.a.a(bVarApply, "The mapper returned a null Publisher");
                f.b.b<? extends R> bVar2 = bVarApply;
                if (bVar2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) bVar2).call();
                        if (objCall == null) {
                            EmptySubscription.complete(cVar);
                            return true;
                        }
                        cVar.onSubscribe(new ScalarSubscription(cVar, objCall));
                    } catch (Throwable th) {
                        io.reactivex.exceptions.a.b(th);
                        EmptySubscription.error(th, cVar);
                        return true;
                    }
                } else {
                    bVar2.a(cVar);
                }
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptySubscription.error(th2, cVar);
                return true;
            }
        } catch (Throwable th3) {
            io.reactivex.exceptions.a.b(th3);
            EmptySubscription.error(th3, cVar);
            return true;
        }
    }

    public static <T, U> io.reactivex.e<U> a(T t, o<? super T, ? extends f.b.b<? extends U>> oVar) {
        return io.reactivex.e.a.a(new a(t, oVar));
    }
}
