package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.p;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractService implements Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final o<Object> f14019a = new com.google.common.util.concurrent.d("starting()");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o<Object> f14020b = new com.google.common.util.concurrent.e("running()");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final o<Object> f14021c = stoppingCallback(Service.State.STARTING);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final o<Object> f14022d = stoppingCallback(Service.State.RUNNING);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final o<Object> f14023e = terminatedCallback(Service.State.NEW);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final o<Object> f14024f = terminatedCallback(Service.State.RUNNING);
    private static final o<Object> g = terminatedCallback(Service.State.STOPPING);
    private final p h = new p();
    private final p.a i = new b();
    private final p.a j = new c();
    private final p.a k = new a();
    private final p.a l = new d();
    private final List<Object<Object>> m = Collections.synchronizedList(new ArrayList());
    private volatile e n = new e(Service.State.NEW);

    private final class a extends p.a {
        a() {
            super(AbstractService.this.h);
        }
    }

    private final class b extends p.a {
        b() {
            super(AbstractService.this.h);
        }
    }

    private final class c extends p.a {
        c() {
            super(AbstractService.this.h);
        }
    }

    private final class d extends p.a {
        d() {
            super(AbstractService.this.h);
        }
    }

    private static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Service.State f14029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f14030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Throwable f14031c;

        e(Service.State state) {
            this(state, false, null);
        }

        Service.State a() {
            return (this.f14030b && this.f14029a == Service.State.STARTING) ? Service.State.STOPPING : this.f14029a;
        }

        e(Service.State state, boolean z, Throwable th) {
            com.google.common.base.m.a(!z || state == Service.State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            com.google.common.base.m.a(!((th != null) ^ (state == Service.State.FAILED)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.f14029a = state;
            this.f14030b = z;
            this.f14031c = th;
        }
    }

    protected AbstractService() {
    }

    private static o<Object> stoppingCallback(Service.State state) {
        return new g("stopping({from = " + state + "})", state);
    }

    private static o<Object> terminatedCallback(Service.State state) {
        return new f("terminated({from = " + state + "})", state);
    }

    public String toString() {
        return AbstractService.class.getSimpleName() + " [" + a() + "]";
    }

    public final Service.State a() {
        return this.n.a();
    }
}
