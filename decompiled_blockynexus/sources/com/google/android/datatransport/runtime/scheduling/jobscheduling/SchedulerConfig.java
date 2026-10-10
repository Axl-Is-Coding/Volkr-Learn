package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.e;
import com.tendcloud.tenddata.ab;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class SchedulerConfig {

    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.google.android.datatransport.runtime.e.a f12966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Priority, b> f12967b = new HashMap();

        public a a(com.google.android.datatransport.runtime.e.a aVar) {
            this.f12966a = aVar;
            return this;
        }

        public a a(Priority priority, b bVar) {
            this.f12967b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig a() {
            if (this.f12966a != null) {
                if (this.f12967b.keySet().size() >= Priority.values().length) {
                    Map<Priority, b> map = this.f12967b;
                    this.f12967b = new HashMap();
                    return SchedulerConfig.a(this.f12966a, map);
                }
                throw new IllegalStateException("Not all priorities have been configured");
            }
            throw new NullPointerException("missing required property: clock");
        }
    }

    public static abstract class b {

        public static abstract class a {
            public abstract a a(long j);

            public abstract a a(Set<Flag> set);

            public abstract b a();

            public abstract a b(long j);
        }

        public static a a() {
            e.a aVar = new e.a();
            aVar.a(Collections.emptySet());
            return aVar;
        }

        abstract long b();

        abstract Set<Flag> c();

        abstract long d();
    }

    public static SchedulerConfig a(com.google.android.datatransport.runtime.e.a aVar) {
        a aVarA = a();
        Priority priority = Priority.DEFAULT;
        b.a aVarA2 = b.a();
        aVarA2.a(ab.R);
        aVarA2.b(86400000L);
        aVarA.a(priority, aVarA2.a());
        Priority priority2 = Priority.HIGHEST;
        b.a aVarA3 = b.a();
        aVarA3.a(1000L);
        aVarA3.b(86400000L);
        aVarA.a(priority2, aVarA3.a());
        Priority priority3 = Priority.VERY_LOW;
        b.a aVarA4 = b.a();
        aVarA4.a(86400000L);
        aVarA4.b(86400000L);
        aVarA4.a(a(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE));
        aVarA.a(priority3, aVarA4.a());
        aVarA.a(aVar);
        return aVarA.a();
    }

    abstract com.google.android.datatransport.runtime.e.a b();

    abstract Map<Priority, b> c();

    public static a a() {
        return new a();
    }

    static SchedulerConfig a(com.google.android.datatransport.runtime.e.a aVar, Map<Priority, b> map) {
        return new c(aVar, map);
    }

    public long a(Priority priority, long j, int i) {
        long time = j - b().getTime();
        b bVar = c().get(priority);
        return Math.min(Math.max(a(i, bVar.b()), time), bVar.d());
    }

    private long a(int i, long j) {
        int i2 = i - 1;
        double dMax = Math.max(1.0d, Math.log(10000.0d) / Math.log((j > 1 ? j : 2L) * ((long) i2)));
        double dPow = Math.pow(3.0d, i2);
        double d2 = j;
        Double.isNaN(d2);
        return (long) (dPow * d2 * dMax);
    }

    public JobInfo.Builder a(JobInfo.Builder builder, Priority priority, long j, int i) {
        builder.setMinimumLatency(a(priority, j, i));
        a(builder, c().get(priority).c());
        return builder;
    }

    private void a(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    private static <T> Set<T> a(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }
}
