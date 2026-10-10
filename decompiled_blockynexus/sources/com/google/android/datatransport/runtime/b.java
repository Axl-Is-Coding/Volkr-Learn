package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.l;
import java.util.Map;

/* JADX INFO: compiled from: AutoValue_EventInternal.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f12803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f12804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12806e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, String> f12807f;

    /* JADX INFO: compiled from: AutoValue_EventInternal.java */
    static final class a extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f12809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private k f12810c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Long f12811d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Long f12812e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map<String, String> f12813f;

        a() {
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l.a a(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f12808a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l.a b(long j) {
            this.f12812e = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        protected Map<String, String> b() {
            Map<String, String> map = this.f12813f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l.a a(Integer num) {
            this.f12809b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l.a a(k kVar) {
            if (kVar != null) {
                this.f12810c = kVar;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l.a a(long j) {
            this.f12811d = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.l.a
        protected l.a a(Map<String, String> map) {
            if (map != null) {
                this.f12813f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        @Override // com.google.android.datatransport.runtime.l.a
        public l a() {
            String str = "";
            if (this.f12808a == null) {
                str = " transportName";
            }
            if (this.f12810c == null) {
                str = str + " encodedPayload";
            }
            if (this.f12811d == null) {
                str = str + " eventMillis";
            }
            if (this.f12812e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f12813f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new b(this.f12808a, this.f12809b, this.f12810c, this.f12811d.longValue(), this.f12812e.longValue(), this.f12813f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // com.google.android.datatransport.runtime.l
    protected Map<String, String> b() {
        return this.f12807f;
    }

    @Override // com.google.android.datatransport.runtime.l
    public Integer c() {
        return this.f12803b;
    }

    @Override // com.google.android.datatransport.runtime.l
    public k d() {
        return this.f12804c;
    }

    @Override // com.google.android.datatransport.runtime.l
    public long e() {
        return this.f12805d;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f12802a.equals(lVar.g()) && ((num = this.f12803b) != null ? num.equals(lVar.c()) : lVar.c() == null) && this.f12804c.equals(lVar.d()) && this.f12805d == lVar.e() && this.f12806e == lVar.h() && this.f12807f.equals(lVar.b());
    }

    @Override // com.google.android.datatransport.runtime.l
    public String g() {
        return this.f12802a;
    }

    @Override // com.google.android.datatransport.runtime.l
    public long h() {
        return this.f12806e;
    }

    public int hashCode() {
        int iHashCode = (this.f12802a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f12803b;
        int iHashCode2 = (((iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003) ^ this.f12804c.hashCode()) * 1000003;
        long j = this.f12805d;
        int i = (iHashCode2 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f12806e;
        return ((i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f12807f.hashCode();
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f12802a + ", code=" + this.f12803b + ", encodedPayload=" + this.f12804c + ", eventMillis=" + this.f12805d + ", uptimeMillis=" + this.f12806e + ", autoMetadata=" + this.f12807f + "}";
    }

    private b(String str, Integer num, k kVar, long j, long j2, Map<String, String> map) {
        this.f12802a = str;
        this.f12803b = num;
        this.f12804c = kVar;
        this.f12805d = j;
        this.f12806e = j2;
        this.f12807f = map;
    }
}
