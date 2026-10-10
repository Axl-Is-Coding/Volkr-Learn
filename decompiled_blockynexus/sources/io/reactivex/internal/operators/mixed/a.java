package io.reactivex.internal.operators.mixed;

import a.a.h;
import io.reactivex.A;
import io.reactivex.b;
import io.reactivex.b.o;
import io.reactivex.c;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.m;
import io.reactivex.w;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: ScalarXMapZHelper.java */
/* JADX INFO: loaded from: classes5.dex */
final class a {
    static <T> boolean a(Object obj, o<? super T, ? extends c> oVar, b bVar) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        c cVar = null;
        try {
            h.a aVar = (Object) ((Callable) obj).call();
            if (aVar != null) {
                c cVarApply = oVar.apply(aVar);
                io.reactivex.internal.functions.a.a(cVarApply, "The mapper returned a null CompletableSource");
                cVar = cVarApply;
            }
            if (cVar == null) {
                EmptyDisposable.complete(bVar);
            } else {
                cVar.a(bVar);
            }
            return true;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, bVar);
            return true;
        }
    }

    static <T, R> boolean b(Object obj, o<? super T, ? extends A<? extends R>> oVar, w<? super R> wVar) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        A<? extends R> a2 = null;
        try {
            h.a aVar = (Object) ((Callable) obj).call();
            if (aVar != null) {
                A<? extends R> aApply = oVar.apply(aVar);
                io.reactivex.internal.functions.a.a(aApply, "The mapper returned a null SingleSource");
                a2 = aApply;
            }
            if (a2 == null) {
                EmptyDisposable.complete(wVar);
            } else {
                a2.a(SingleToObservable.a(wVar));
            }
            return true;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
            return true;
        }
    }

    static <T, R> boolean a(Object obj, o<? super T, ? extends m<? extends R>> oVar, w<? super R> wVar) {
        if (!(obj instanceof Callable)) {
            return false;
        }
        m<? extends R> mVar = null;
        try {
            h.a aVar = (Object) ((Callable) obj).call();
            if (aVar != null) {
                m<? extends R> mVarApply = oVar.apply(aVar);
                io.reactivex.internal.functions.a.a(mVarApply, "The mapper returned a null MaybeSource");
                mVar = mVarApply;
            }
            if (mVar == null) {
                EmptyDisposable.complete(wVar);
            } else {
                mVar.a(MaybeToObservable.a(wVar));
            }
            return true;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.b(th);
            EmptyDisposable.error(th, wVar);
            return true;
        }
    }
}
