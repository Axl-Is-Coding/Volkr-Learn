package io.reactivex.f;

import io.reactivex.internal.schedulers.i;
import io.reactivex.internal.schedulers.j;
import io.reactivex.x;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: Schedulers.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final x f21782a = io.reactivex.e.a.e(new h());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final x f21783b = io.reactivex.e.a.b(new CallableC0198b());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final x f21784c = io.reactivex.e.a.c(new c());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final x f21785d = j.b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final x f21786e = io.reactivex.e.a.d(new f());

    /* JADX INFO: compiled from: Schedulers.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x f21787a = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: renamed from: io.reactivex.f.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Schedulers.java */
    static final class CallableC0198b implements Callable<x> {
        CallableC0198b() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public x call() throws Exception {
            return a.f21787a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class c implements Callable<x> {
        c() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public x call() throws Exception {
            return d.f21788a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x f21788a = new io.reactivex.internal.schedulers.c();
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x f21789a = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class f implements Callable<x> {
        f() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public x call() throws Exception {
            return e.f21789a;
        }
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final x f21790a = new i();
    }

    /* JADX INFO: compiled from: Schedulers.java */
    static final class h implements Callable<x> {
        h() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public x call() throws Exception {
            return g.f21790a;
        }
    }

    public static x a() {
        return io.reactivex.e.a.a(f21783b);
    }

    public static x b() {
        return io.reactivex.e.a.b(f21784c);
    }

    public static x c() {
        return io.reactivex.e.a.c(f21786e);
    }

    public static x d() {
        return f21785d;
    }
}
