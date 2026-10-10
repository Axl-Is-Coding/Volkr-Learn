package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.q;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* JADX INFO: compiled from: AutoValue_LogRequest.java */
/* JADX INFO: loaded from: classes.dex */
final class k extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClientInfo f12782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f12783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f12784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<p> f12785f;
    private final QosTier g;

    /* JADX INFO: compiled from: AutoValue_LogRequest.java */
    static final class a extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Long f12786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Long f12787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ClientInfo f12788c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f12789d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f12790e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<p> f12791f;
        private QosTier g;

        a() {
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a a(long j) {
            this.f12786a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a b(long j) {
            this.f12787b = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a a(ClientInfo clientInfo) {
            this.f12788c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        q.a a(Integer num) {
            this.f12789d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        q.a a(String str) {
            this.f12790e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a a(List<p> list) {
            this.f12791f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q.a a(QosTier qosTier) {
            this.g = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.q.a
        public q a() {
            String str = "";
            if (this.f12786a == null) {
                str = " requestTimeMs";
            }
            if (this.f12787b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new k(this.f12786a.longValue(), this.f12787b.longValue(), this.f12788c, this.f12789d, this.f12790e, this.f12791f, this.g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public ClientInfo b() {
        return this.f12782c;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    @Encodable.Field(name = "logEvent")
    public List<p> c() {
        return this.f12785f;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public Integer d() {
        return this.f12783d;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public String e() {
        return this.f12784e;
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<p> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f12780a == qVar.g() && this.f12781b == qVar.h() && ((clientInfo = this.f12782c) != null ? clientInfo.equals(qVar.b()) : qVar.b() == null) && ((num = this.f12783d) != null ? num.equals(qVar.d()) : qVar.d() == null) && ((str = this.f12784e) != null ? str.equals(qVar.e()) : qVar.e() == null) && ((list = this.f12785f) != null ? list.equals(qVar.c()) : qVar.c() == null)) {
            QosTier qosTier = this.g;
            if (qosTier == null) {
                if (qVar.f() == null) {
                    return true;
                }
            } else if (qosTier.equals(qVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public QosTier f() {
        return this.g;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public long g() {
        return this.f12780a;
    }

    @Override // com.google.android.datatransport.cct.internal.q
    public long h() {
        return this.f12781b;
    }

    public int hashCode() {
        long j = this.f12780a;
        long j2 = this.f12781b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        ClientInfo clientInfo = this.f12782c;
        int iHashCode = (i ^ (clientInfo == null ? 0 : clientInfo.hashCode())) * 1000003;
        Integer num = this.f12783d;
        int iHashCode2 = (iHashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f12784e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<p> list = this.f12785f;
        int iHashCode4 = (iHashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier = this.g;
        return iHashCode4 ^ (qosTier != null ? qosTier.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f12780a + ", requestUptimeMs=" + this.f12781b + ", clientInfo=" + this.f12782c + ", logSource=" + this.f12783d + ", logSourceName=" + this.f12784e + ", logEvents=" + this.f12785f + ", qosTier=" + this.g + "}";
    }

    private k(long j, long j2, ClientInfo clientInfo, Integer num, String str, List<p> list, QosTier qosTier) {
        this.f12780a = j;
        this.f12781b = j2;
        this.f12782c = clientInfo;
        this.f12783d = num;
        this.f12784e = str;
        this.f12785f = list;
        this.g = qosTier;
    }
}
