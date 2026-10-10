package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.d.a.C2223g;
import com.google.android.datatransport.runtime.d.a.C2224h;
import com.google.android.datatransport.runtime.d.a.C2225i;
import com.google.android.datatransport.runtime.d.a.D;
import com.google.android.datatransport.runtime.d.a.E;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import com.google.android.datatransport.runtime.d.a.J;
import com.google.android.datatransport.runtime.d.a.K;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.v;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DaggerTransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes.dex */
final class h extends v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e.a.a<Executor> f12946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e.a.a<Context> f12947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private e.a.a f12948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e.a.a f12949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e.a.a f12950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e.a.a<D> f12951f;
    private e.a.a<SchedulerConfig> g;
    private e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.s> h;
    private e.a.a<com.google.android.datatransport.runtime.d.c> i;
    private e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> j;
    private e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> k;
    private e.a.a<u> l;

    /* JADX INFO: compiled from: DaggerTransportRuntimeComponent.java */
    private static final class a implements v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f12952a;

        private a() {
        }

        @Override // com.google.android.datatransport.runtime.v.a
        public /* bridge */ /* synthetic */ v.a a(Context context) {
            a(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.v.a
        public v build() {
            com.google.android.datatransport.runtime.a.a.d.a(this.f12952a, (Class<Context>) Context.class);
            return new h(this.f12952a);
        }

        @Override // com.google.android.datatransport.runtime.v.a
        public a a(Context context) {
            com.google.android.datatransport.runtime.a.a.d.a(context);
            this.f12952a = context;
            return this;
        }
    }

    private void a(Context context) {
        this.f12946a = com.google.android.datatransport.runtime.a.a.a.a(n.a());
        this.f12947b = com.google.android.datatransport.runtime.a.a.c.a(context);
        this.f12948c = com.google.android.datatransport.runtime.backends.j.a(this.f12947b, com.google.android.datatransport.runtime.e.c.a(), com.google.android.datatransport.runtime.e.d.a());
        this.f12949d = com.google.android.datatransport.runtime.a.a.a.a(com.google.android.datatransport.runtime.backends.l.a(this.f12947b, (e.a.a<com.google.android.datatransport.runtime.backends.i>) this.f12948c));
        this.f12950e = K.a(this.f12947b, C2223g.a(), C2224h.a());
        this.f12951f = com.google.android.datatransport.runtime.a.a.a.a(E.a(com.google.android.datatransport.runtime.e.c.a(), com.google.android.datatransport.runtime.e.d.a(), C2225i.a(), (e.a.a<J>) this.f12950e));
        this.g = com.google.android.datatransport.runtime.d.g.a(com.google.android.datatransport.runtime.e.c.a());
        this.h = com.google.android.datatransport.runtime.d.i.a(this.f12947b, this.f12951f, this.g, com.google.android.datatransport.runtime.e.d.a());
        e.a.a<Executor> aVar = this.f12946a;
        e.a.a aVar2 = this.f12949d;
        e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.s> aVar3 = this.h;
        e.a.a<D> aVar4 = this.f12951f;
        this.i = com.google.android.datatransport.runtime.d.d.a(aVar, (e.a.a<com.google.android.datatransport.runtime.backends.f>) aVar2, aVar3, aVar4, aVar4);
        e.a.a<Context> aVar5 = this.f12947b;
        e.a.a aVar6 = this.f12949d;
        e.a.a<D> aVar7 = this.f12951f;
        this.j = com.google.android.datatransport.runtime.scheduling.jobscheduling.n.a(aVar5, (e.a.a<com.google.android.datatransport.runtime.backends.f>) aVar6, aVar7, this.h, this.f12946a, aVar7, com.google.android.datatransport.runtime.e.c.a());
        e.a.a<Executor> aVar8 = this.f12946a;
        e.a.a<D> aVar9 = this.f12951f;
        this.k = com.google.android.datatransport.runtime.scheduling.jobscheduling.r.a(aVar8, aVar9, this.h, aVar9);
        this.l = com.google.android.datatransport.runtime.a.a.a.a(w.a(com.google.android.datatransport.runtime.e.c.a(), com.google.android.datatransport.runtime.e.d.a(), this.i, this.j, this.k));
    }

    public static v.a g() {
        return new a();
    }

    @Override // com.google.android.datatransport.runtime.v
    InterfaceC2220d b() {
        return this.f12951f.get();
    }

    @Override // com.google.android.datatransport.runtime.v
    u d() {
        return this.l.get();
    }

    private h(Context context) {
        a(context);
    }
}
