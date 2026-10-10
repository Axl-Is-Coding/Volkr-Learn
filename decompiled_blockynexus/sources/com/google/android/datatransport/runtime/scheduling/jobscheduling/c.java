package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Map;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends SchedulerConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.e.a f12974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Priority, SchedulerConfig.b> f12975b;

    c(com.google.android.datatransport.runtime.e.a aVar, Map<Priority, SchedulerConfig.b> map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f12974a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f12975b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    com.google.android.datatransport.runtime.e.a b() {
        return this.f12974a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Map<Priority, SchedulerConfig.b> c() {
        return this.f12975b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.f12974a.equals(schedulerConfig.b()) && this.f12975b.equals(schedulerConfig.c());
    }

    public int hashCode() {
        return ((this.f12974a.hashCode() ^ 1000003) * 1000003) ^ this.f12975b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f12974a + ", values=" + this.f12975b + "}";
    }
}
