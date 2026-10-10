package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkInitializer_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class r implements com.google.android.datatransport.runtime.a.a.b<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<Executor> f13020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<InterfaceC2220d> f13021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<s> f13022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.synchronization.a> f13023d;

    public r(e.a.a<Executor> aVar, e.a.a<InterfaceC2220d> aVar2, e.a.a<s> aVar3, e.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar4) {
        this.f13020a = aVar;
        this.f13021b = aVar2;
        this.f13022c = aVar3;
        this.f13023d = aVar4;
    }

    public static r a(e.a.a<Executor> aVar, e.a.a<InterfaceC2220d> aVar2, e.a.a<s> aVar3, e.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar4) {
        return new r(aVar, aVar2, aVar3, aVar4);
    }

    public static q a(Executor executor, InterfaceC2220d interfaceC2220d, s sVar, com.google.android.datatransport.runtime.synchronization.a aVar) {
        return new q(executor, interfaceC2220d, sVar, aVar);
    }

    @Override // e.a.a
    public q get() {
        return a(this.f13020a.get(), this.f13021b.get(), this.f13022c.get(), this.f13023d.get());
    }
}
