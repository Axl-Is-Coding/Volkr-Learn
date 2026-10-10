package com.google.android.datatransport.runtime.d;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;

/* JADX INFO: compiled from: SchedulingConfigModule_ConfigFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class g implements com.google.android.datatransport.runtime.a.a.b<SchedulerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a.a<com.google.android.datatransport.runtime.e.a> f12931a;

    public g(e.a.a<com.google.android.datatransport.runtime.e.a> aVar) {
        this.f12931a = aVar;
    }

    public static g a(e.a.a<com.google.android.datatransport.runtime.e.a> aVar) {
        return new g(aVar);
    }

    public static SchedulerConfig a(com.google.android.datatransport.runtime.e.a aVar) {
        SchedulerConfig schedulerConfigA = f.a(aVar);
        com.google.android.datatransport.runtime.a.a.d.a(schedulerConfigA, "Cannot return null from a non-@Nullable @Provides method");
        return schedulerConfigA;
    }

    @Override // e.a.a
    public SchedulerConfig get() {
        return a(this.f12931a.get());
    }
}
