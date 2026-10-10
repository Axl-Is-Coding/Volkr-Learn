package io.reactivex.android.a;

import io.reactivex.b.o;
import io.reactivex.x;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: RxAndroidPlugins.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile o<Callable<x>, x> f21758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile o<x, x> f21759b;

    public static x a(x xVar) {
        if (xVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        o<x, x> oVar = f21759b;
        return oVar == null ? xVar : (x) a((o<x, R>) oVar, xVar);
    }

    public static x b(Callable<x> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        o<Callable<x>, x> oVar = f21758a;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    static x a(Callable<x> callable) {
        try {
            x xVarCall = callable.call();
            if (xVarCall != null) {
                return xVarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            throw null;
        }
    }

    static x a(o<Callable<x>, x> oVar, Callable<x> callable) {
        x xVar = (x) a((o<Callable<x>, R>) oVar, callable);
        if (xVar != null) {
            return xVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static <T, R> R a(o<T, R> oVar, T t) {
        try {
            return oVar.apply(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            throw null;
        }
    }
}
