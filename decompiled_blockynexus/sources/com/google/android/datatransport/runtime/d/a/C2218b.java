package com.google.android.datatransport.runtime.d.a;

import com.google.android.datatransport.runtime.d.a.AbstractC2221e;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
/* JADX INFO: loaded from: classes.dex */
final class C2218b extends AbstractC2221e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f12882f;

    /* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.b$a */
    /* JADX INFO: compiled from: AutoValue_EventStoreConfig.java */
    static final class a extends AbstractC2221e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f12883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f12884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f12885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f12886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f12887e;

        a() {
        }

        @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e.a
        AbstractC2221e.a a(int i) {
            this.f12885c = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e.a
        AbstractC2221e.a b(long j) {
            this.f12883a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e.a
        AbstractC2221e.a c(int i) {
            this.f12887e = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e.a
        AbstractC2221e.a a(long j) {
            this.f12886d = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e.a
        AbstractC2221e.a b(int i) {
            this.f12884b = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e.a
        AbstractC2221e a() {
            String str = "";
            if (this.f12883a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f12884b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f12885c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f12886d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f12887e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new C2218b(this.f12883a.longValue(), this.f12884b.intValue(), this.f12885c.intValue(), this.f12886d.longValue(), this.f12887e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e
    int b() {
        return this.f12880d;
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e
    long c() {
        return this.f12881e;
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e
    int d() {
        return this.f12879c;
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e
    int e() {
        return this.f12882f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2221e)) {
            return false;
        }
        AbstractC2221e abstractC2221e = (AbstractC2221e) obj;
        return this.f12878b == abstractC2221e.f() && this.f12879c == abstractC2221e.d() && this.f12880d == abstractC2221e.b() && this.f12881e == abstractC2221e.c() && this.f12882f == abstractC2221e.e();
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2221e
    long f() {
        return this.f12878b;
    }

    public int hashCode() {
        long j = this.f12878b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f12879c) * 1000003) ^ this.f12880d) * 1000003;
        long j2 = this.f12881e;
        return this.f12882f ^ ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f12878b + ", loadBatchSize=" + this.f12879c + ", criticalSectionEnterTimeoutMs=" + this.f12880d + ", eventCleanUpAge=" + this.f12881e + ", maxBlobByteSizePerRow=" + this.f12882f + "}";
    }

    private C2218b(long j, int i, int i2, long j2, int i3) {
        this.f12878b = j;
        this.f12879c = i;
        this.f12880d = i2;
        this.f12881e = j2;
        this.f12882f = i3;
    }
}
