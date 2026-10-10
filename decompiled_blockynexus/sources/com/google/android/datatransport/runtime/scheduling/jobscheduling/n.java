package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Uploader_Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class n implements com.google.android.datatransport.runtime.a.a.b<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<Context> f13008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.backends.f> f13009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<InterfaceC2220d> f13010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.a.a<s> f13011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e.a.a<Executor> f13012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.synchronization.a> f13013f;
    private final e.a.a<com.google.android.datatransport.runtime.e.a> g;

    public n(e.a.a<Context> aVar, e.a.a<com.google.android.datatransport.runtime.backends.f> aVar2, e.a.a<InterfaceC2220d> aVar3, e.a.a<s> aVar4, e.a.a<Executor> aVar5, e.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar6, e.a.a<com.google.android.datatransport.runtime.e.a> aVar7) {
        this.f13008a = aVar;
        this.f13009b = aVar2;
        this.f13010c = aVar3;
        this.f13011d = aVar4;
        this.f13012e = aVar5;
        this.f13013f = aVar6;
        this.g = aVar7;
    }

    public static n a(e.a.a<Context> aVar, e.a.a<com.google.android.datatransport.runtime.backends.f> aVar2, e.a.a<InterfaceC2220d> aVar3, e.a.a<s> aVar4, e.a.a<Executor> aVar5, e.a.a<com.google.android.datatransport.runtime.synchronization.a> aVar6, e.a.a<com.google.android.datatransport.runtime.e.a> aVar7) {
        return new n(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static m a(Context context, com.google.android.datatransport.runtime.backends.f fVar, InterfaceC2220d interfaceC2220d, s sVar, Executor executor, com.google.android.datatransport.runtime.synchronization.a aVar, com.google.android.datatransport.runtime.e.a aVar2) {
        return new m(context, fVar, interfaceC2220d, sVar, executor, aVar, aVar2);
    }

    @Override // e.a.a
    public m get() {
        return a(this.f13008a.get(), this.f13009b.get(), this.f13010c.get(), this.f13011d.get(), this.f13012e.get(), this.f13013f.get(), this.g.get());
    }
}
