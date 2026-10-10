package com.google.android.datatransport.runtime.d;

import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DefaultScheduler_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class d implements com.google.android.datatransport.runtime.a.a.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<Executor> f12926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.backends.f> f12927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<s> f12928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.a.a<InterfaceC2220d> f12929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.synchronization.a> f12930e;

    public d(e.a.a<Executor> aVar, e.a.a<com.google.android.datatransport.runtime.backends.f> aVar2, e.a.a<s> aVar3, e.a.a<InterfaceC2220d> aVar4, e.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar5) {
        this.f12926a = aVar;
        this.f12927b = aVar2;
        this.f12928c = aVar3;
        this.f12929d = aVar4;
        this.f12930e = aVar5;
    }

    public static d a(e.a.a<Executor> aVar, e.a.a<com.google.android.datatransport.runtime.backends.f> aVar2, e.a.a<s> aVar3, e.a.a<InterfaceC2220d> aVar4, e.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c a(Executor executor, com.google.android.datatransport.runtime.backends.f fVar, s sVar, InterfaceC2220d interfaceC2220d, com.google.android.datatransport.runtime.synchronization.a aVar) {
        return new c(executor, fVar, sVar, interfaceC2220d, aVar);
    }

    @Override // e.a.a
    public c get() {
        return a(this.f12926a.get(), this.f12927b.get(), this.f12928c.get(), this.f12929d.get(), this.f12930e.get());
    }
}
