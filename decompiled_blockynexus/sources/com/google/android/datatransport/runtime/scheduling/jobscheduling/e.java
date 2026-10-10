package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* JADX INFO: loaded from: classes.dex */
final class e extends SchedulerConfig.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<SchedulerConfig.Flag> f12978c;

    /* JADX INFO: compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    static final class a extends SchedulerConfig.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f12979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f12980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Set<SchedulerConfig.Flag> f12981c;

        a() {
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a a(long j) {
            this.f12979a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j) {
            this.f12980b = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a a(Set<SchedulerConfig.Flag> set) {
            if (set == null) {
                throw new NullPointerException("Null flags");
            }
            this.f12981c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.f12979a == null) {
                str = " delta";
            }
            if (this.f12980b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f12981c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new e(this.f12979a.longValue(), this.f12980b.longValue(), this.f12981c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long b() {
        return this.f12976a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    Set<SchedulerConfig.Flag> c() {
        return this.f12978c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long d() {
        return this.f12977b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.b)) {
            return false;
        }
        SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
        return this.f12976a == bVar.b() && this.f12977b == bVar.d() && this.f12978c.equals(bVar.c());
    }

    public int hashCode() {
        long j = this.f12976a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j2 = this.f12977b;
        return this.f12978c.hashCode() ^ ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f12976a + ", maxAllowedDelay=" + this.f12977b + ", flags=" + this.f12978c + "}";
    }

    private e(long j, long j2, Set<SchedulerConfig.Flag> set) {
        this.f12976a = j;
        this.f12977b = j2;
        this.f12978c = set;
    }
}
