package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.p;
import java.util.Arrays;

/* JADX INFO: compiled from: AutoValue_LogEvent.java */
/* JADX INFO: loaded from: classes.dex */
final class i extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f12769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f12771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f12772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f12773f;
    private final NetworkConnectionInfo g;

    /* JADX INFO: compiled from: AutoValue_LogEvent.java */
    static final class a extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f12774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f12775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Long f12776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f12777d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f12778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Long f12779f;
        private NetworkConnectionInfo g;

        a() {
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p.a a(long j) {
            this.f12774a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p.a b(long j) {
            this.f12776c = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p.a c(long j) {
            this.f12779f = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p.a a(Integer num) {
            this.f12775b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        p.a a(byte[] bArr) {
            this.f12777d = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        p.a a(String str) {
            this.f12778e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p.a a(NetworkConnectionInfo networkConnectionInfo) {
            this.g = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.p.a
        public p a() {
            String str = "";
            if (this.f12774a == null) {
                str = " eventTimeMs";
            }
            if (this.f12776c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f12779f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new i(this.f12774a.longValue(), this.f12775b, this.f12776c.longValue(), this.f12777d, this.f12778e, this.f12779f.longValue(), this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public Integer a() {
        return this.f12769b;
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public long b() {
        return this.f12768a;
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public long c() {
        return this.f12770c;
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public NetworkConnectionInfo d() {
        return this.g;
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public byte[] e() {
        return this.f12771d;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f12768a == pVar.b() && ((num = this.f12769b) != null ? num.equals(pVar.a()) : pVar.a() == null) && this.f12770c == pVar.c()) {
            if (Arrays.equals(this.f12771d, pVar instanceof i ? ((i) pVar).f12771d : pVar.e()) && ((str = this.f12772e) != null ? str.equals(pVar.f()) : pVar.f() == null) && this.f12773f == pVar.g()) {
                NetworkConnectionInfo networkConnectionInfo = this.g;
                if (networkConnectionInfo == null) {
                    if (pVar.d() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(pVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public String f() {
        return this.f12772e;
    }

    @Override // com.google.android.datatransport.cct.internal.p
    public long g() {
        return this.f12773f;
    }

    public int hashCode() {
        long j = this.f12768a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f12769b;
        int iHashCode = num == null ? 0 : num.hashCode();
        long j2 = this.f12770c;
        int iHashCode2 = (((((i ^ iHashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f12771d)) * 1000003;
        String str = this.f12772e;
        int iHashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f12773f;
        int i2 = (((iHashCode2 ^ iHashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.g;
        return i2 ^ (networkConnectionInfo != null ? networkConnectionInfo.hashCode() : 0);
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f12768a + ", eventCode=" + this.f12769b + ", eventUptimeMs=" + this.f12770c + ", sourceExtension=" + Arrays.toString(this.f12771d) + ", sourceExtensionJsonProto3=" + this.f12772e + ", timezoneOffsetSeconds=" + this.f12773f + ", networkConnectionInfo=" + this.g + "}";
    }

    private i(long j, Integer num, long j2, byte[] bArr, String str, long j3, NetworkConnectionInfo networkConnectionInfo) {
        this.f12768a = j;
        this.f12769b = num;
        this.f12770c = j2;
        this.f12771d = bArr;
        this.f12772e = str;
        this.f12773f = j3;
        this.g = networkConnectionInfo;
    }
}
