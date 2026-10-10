package com.google.android.datatransport.runtime.d;

import android.content.Context;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.s;

/* JADX INFO: compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class i implements com.google.android.datatransport.runtime.a.a.b<s> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<Context> f12932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.a.a<InterfaceC2220d> f12933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e.a.a<SchedulerConfig> f12934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f12935d;

    public i(e.a.a<Context> aVar, e.a.a<InterfaceC2220d> aVar2, e.a.a<SchedulerConfig> aVar3, e.a.a<com.google.android.datatransport.runtime.e.a> aVar4) {
        this.f12932a = aVar;
        this.f12933b = aVar2;
        this.f12934c = aVar3;
        this.f12935d = aVar4;
    }

    public static i a(e.a.a<Context> aVar, e.a.a<InterfaceC2220d> aVar2, e.a.a<SchedulerConfig> aVar3, e.a.a<com.google.android.datatransport.runtime.e.a> aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static s a(Context context, InterfaceC2220d interfaceC2220d, SchedulerConfig schedulerConfig, com.google.android.datatransport.runtime.e.a aVar) {
        s sVarA = h.a(context, interfaceC2220d, schedulerConfig, aVar);
        com.google.android.datatransport.runtime.a.a.d.a(sVarA, "Cannot return null from a non-@Nullable @Provides method");
        return sVarA;
    }

    @Override // e.a.a
    public s get() {
        return a(this.f12932a.get(), this.f12933b.get(), this.f12934c.get(), this.f12935d.get());
    }
}
