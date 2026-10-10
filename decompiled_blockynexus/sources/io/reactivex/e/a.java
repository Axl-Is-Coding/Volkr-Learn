package io.reactivex.e;

import io.reactivex.AbstractC2894a;
import io.reactivex.b;
import io.reactivex.b.c;
import io.reactivex.b.g;
import io.reactivex.b.o;
import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.i;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.y;
import io.reactivex.z;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: RxJavaPlugins.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile g<? super Throwable> f21774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile o<? super Runnable, ? extends Runnable> f21775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile o<? super Callable<x>, ? extends x> f21776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile o<? super Callable<x>, ? extends x> f21777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile o<? super Callable<x>, ? extends x> f21778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static volatile o<? super Callable<x>, ? extends x> f21779f;
    static volatile o<? super x, ? extends x> g;
    static volatile o<? super x, ? extends x> h;
    static volatile o<? super x, ? extends x> i;
    static volatile o<? super e, ? extends e> j;
    static volatile o<? super io.reactivex.a.a, ? extends io.reactivex.a.a> k;
    static volatile o<? super p, ? extends p> l;
    static volatile o<? super io.reactivex.d.a, ? extends io.reactivex.d.a> m;
    static volatile o<? super i, ? extends i> n;
    static volatile o<? super y, ? extends y> o;
    static volatile o<? super AbstractC2894a, ? extends AbstractC2894a> p;
    static volatile c<? super e, ? super f.b.c, ? extends f.b.c> q;
    static volatile c<? super i, ? super k, ? extends k> r;
    static volatile c<? super p, ? super w, ? extends w> s;
    static volatile c<? super y, ? super z, ? extends z> t;
    static volatile c<? super AbstractC2894a, ? super b, ? extends b> u;
    static volatile io.reactivex.b.e v;
    static volatile boolean w;
    static volatile boolean x;

    public static boolean a() {
        return x;
    }

    public static x b(Callable<x> callable) {
        io.reactivex.internal.functions.a.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<x>, ? extends x> oVar = f21776c;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    public static x c(Callable<x> callable) {
        io.reactivex.internal.functions.a.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<x>, ? extends x> oVar = f21778e;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    public static x d(Callable<x> callable) {
        io.reactivex.internal.functions.a.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<x>, ? extends x> oVar = f21779f;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    public static x e(Callable<x> callable) {
        io.reactivex.internal.functions.a.a(callable, "Scheduler Callable can't be null");
        o<? super Callable<x>, ? extends x> oVar = f21777d;
        return oVar == null ? a(callable) : a(oVar, callable);
    }

    public static x a(x xVar) {
        o<? super x, ? extends x> oVar = g;
        return oVar == null ? xVar : (x) a((o<x, R>) oVar, xVar);
    }

    static boolean a(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static void b(Throwable th) {
        g<? super Throwable> gVar = f21774a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new UndeliverableException(th);
        }
        if (gVar != null) {
            try {
                gVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static void c(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static x c(x xVar) {
        o<? super x, ? extends x> oVar = i;
        return oVar == null ? xVar : (x) a((o<x, R>) oVar, xVar);
    }

    public static Runnable a(Runnable runnable) {
        io.reactivex.internal.functions.a.a(runnable, "run is null");
        o<? super Runnable, ? extends Runnable> oVar = f21775b;
        return oVar == null ? runnable : (Runnable) a((o<Runnable, R>) oVar, runnable);
    }

    public static void a(g<? super Throwable> gVar) {
        if (!w) {
            f21774a = gVar;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static x b(x xVar) {
        o<? super x, ? extends x> oVar = h;
        return oVar == null ? xVar : (x) a((o<x, R>) oVar, xVar);
    }

    public static <T> f.b.c<? super T> a(e<T> eVar, f.b.c<? super T> cVar) {
        c<? super e, ? super f.b.c, ? extends f.b.c> cVar2 = q;
        return cVar2 != null ? (f.b.c) a(cVar2, eVar, cVar) : cVar;
    }

    public static boolean b() {
        io.reactivex.b.e eVar = v;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th) {
            throw ExceptionHelper.b(th);
        }
    }

    public static <T> w<? super T> a(p<T> pVar, w<? super T> wVar) {
        c<? super p, ? super w, ? extends w> cVar = s;
        return cVar != null ? (w) a(cVar, pVar, wVar) : wVar;
    }

    public static <T> z<? super T> a(y<T> yVar, z<? super T> zVar) {
        c<? super y, ? super z, ? extends z> cVar = t;
        return cVar != null ? (z) a(cVar, yVar, zVar) : zVar;
    }

    public static b a(AbstractC2894a abstractC2894a, b bVar) {
        c<? super AbstractC2894a, ? super b, ? extends b> cVar = u;
        return cVar != null ? (b) a(cVar, abstractC2894a, bVar) : bVar;
    }

    public static <T> k<? super T> a(i<T> iVar, k<? super T> kVar) {
        c<? super i, ? super k, ? extends k> cVar = r;
        return cVar != null ? (k) a(cVar, iVar, kVar) : kVar;
    }

    public static <T> i<T> a(i<T> iVar) {
        o<? super i, ? extends i> oVar = n;
        return oVar != null ? (i) a((o<i<T>, R>) oVar, iVar) : iVar;
    }

    public static <T> e<T> a(e<T> eVar) {
        o<? super e, ? extends e> oVar = j;
        return oVar != null ? (e) a((o<e<T>, R>) oVar, eVar) : eVar;
    }

    public static <T> io.reactivex.a.a<T> a(io.reactivex.a.a<T> aVar) {
        o<? super io.reactivex.a.a, ? extends io.reactivex.a.a> oVar = k;
        return oVar != null ? (io.reactivex.a.a) a((o<io.reactivex.a.a<T>, R>) oVar, aVar) : aVar;
    }

    public static <T> p<T> a(p<T> pVar) {
        o<? super p, ? extends p> oVar = l;
        return oVar != null ? (p) a((o<p<T>, R>) oVar, pVar) : pVar;
    }

    public static <T> io.reactivex.d.a<T> a(io.reactivex.d.a<T> aVar) {
        o<? super io.reactivex.d.a, ? extends io.reactivex.d.a> oVar = m;
        return oVar != null ? (io.reactivex.d.a) a((o<io.reactivex.d.a<T>, R>) oVar, aVar) : aVar;
    }

    public static <T> y<T> a(y<T> yVar) {
        o<? super y, ? extends y> oVar = o;
        return oVar != null ? (y) a((o<y<T>, R>) oVar, yVar) : yVar;
    }

    public static AbstractC2894a a(AbstractC2894a abstractC2894a) {
        o<? super AbstractC2894a, ? extends AbstractC2894a> oVar = p;
        return oVar != null ? (AbstractC2894a) a((o<AbstractC2894a, R>) oVar, abstractC2894a) : abstractC2894a;
    }

    static <T, R> R a(o<T, R> oVar, T t2) {
        try {
            return oVar.apply(t2);
        } catch (Throwable th) {
            throw ExceptionHelper.b(th);
        }
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t2, U u2) {
        try {
            return cVar.apply(t2, u2);
        } catch (Throwable th) {
            throw ExceptionHelper.b(th);
        }
    }

    static x a(Callable<x> callable) {
        try {
            x xVarCall = callable.call();
            io.reactivex.internal.functions.a.a(xVarCall, "Scheduler Callable result can't be null");
            return xVarCall;
        } catch (Throwable th) {
            throw ExceptionHelper.b(th);
        }
    }

    static x a(o<? super Callable<x>, ? extends x> oVar, Callable<x> callable) {
        Object objA = a((o<Callable<x>, Object>) oVar, callable);
        io.reactivex.internal.functions.a.a(objA, "Scheduler Callable result can't be null");
        return (x) objA;
    }
}
