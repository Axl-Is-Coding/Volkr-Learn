package com.google.android.datatransport.runtime;

/* JADX INFO: compiled from: TransportRuntime_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class w implements com.google.android.datatransport.runtime.a.a.b<u> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f13029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f13030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.d.e> f13031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> f13032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> f13033e;

    public w(e.a.a<com.google.android.datatransport.runtime.e.a> aVar, e.a.a<com.google.android.datatransport.runtime.e.a> aVar2, e.a.a<com.google.android.datatransport.runtime.d.e> aVar3, e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> aVar4, e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> aVar5) {
        this.f13029a = aVar;
        this.f13030b = aVar2;
        this.f13031c = aVar3;
        this.f13032d = aVar4;
        this.f13033e = aVar5;
    }

    public static w a(e.a.a<com.google.android.datatransport.runtime.e.a> aVar, e.a.a<com.google.android.datatransport.runtime.e.a> aVar2, e.a.a<com.google.android.datatransport.runtime.d.e> aVar3, e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.m> aVar4, e.a.a<com.google.android.datatransport.runtime.scheduling.jobscheduling.q> aVar5) {
        return new w(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static u a(com.google.android.datatransport.runtime.e.a aVar, com.google.android.datatransport.runtime.e.a aVar2, com.google.android.datatransport.runtime.d.e eVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.m mVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.q qVar) {
        return new u(aVar, aVar2, eVar, mVar, qVar);
    }

    @Override // e.a.a
    public u get() {
        return a(this.f13029a.get(), this.f13030b.get(), this.f13031c.get(), this.f13032d.get(), this.f13033e.get());
    }
}
