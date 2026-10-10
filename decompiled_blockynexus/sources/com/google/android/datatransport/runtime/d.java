package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.p;

/* JADX INFO: compiled from: AutoValue_SendRequest.java */
/* JADX INFO: loaded from: classes.dex */
final class d extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f12837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.c<?> f12839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.d<?, byte[]> f12840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.android.datatransport.b f12841e;

    @Override // com.google.android.datatransport.runtime.p
    public com.google.android.datatransport.b b() {
        return this.f12841e;
    }

    @Override // com.google.android.datatransport.runtime.p
    com.google.android.datatransport.c<?> c() {
        return this.f12839c;
    }

    @Override // com.google.android.datatransport.runtime.p
    com.google.android.datatransport.d<?, byte[]> e() {
        return this.f12840d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f12837a.equals(pVar.f()) && this.f12838b.equals(pVar.g()) && this.f12839c.equals(pVar.c()) && this.f12840d.equals(pVar.e()) && this.f12841e.equals(pVar.b());
    }

    @Override // com.google.android.datatransport.runtime.p
    public q f() {
        return this.f12837a;
    }

    @Override // com.google.android.datatransport.runtime.p
    public String g() {
        return this.f12838b;
    }

    public int hashCode() {
        return ((((((((this.f12837a.hashCode() ^ 1000003) * 1000003) ^ this.f12838b.hashCode()) * 1000003) ^ this.f12839c.hashCode()) * 1000003) ^ this.f12840d.hashCode()) * 1000003) ^ this.f12841e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f12837a + ", transportName=" + this.f12838b + ", event=" + this.f12839c + ", transformer=" + this.f12840d + ", encoding=" + this.f12841e + "}";
    }

    /* JADX INFO: compiled from: AutoValue_SendRequest.java */
    static final class a extends p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q f12842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f12843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.google.android.datatransport.c<?> f12844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.google.android.datatransport.d<?, byte[]> f12845d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.google.android.datatransport.b f12846e;

        a() {
        }

        @Override // com.google.android.datatransport.runtime.p.a
        public p.a a(q qVar) {
            if (qVar == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f12842a = qVar;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.p.a
        public p.a a(String str) {
            if (str != null) {
                this.f12843b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        @Override // com.google.android.datatransport.runtime.p.a
        p.a a(com.google.android.datatransport.c<?> cVar) {
            if (cVar != null) {
                this.f12844c = cVar;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        @Override // com.google.android.datatransport.runtime.p.a
        p.a a(com.google.android.datatransport.d<?, byte[]> dVar) {
            if (dVar != null) {
                this.f12845d = dVar;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        @Override // com.google.android.datatransport.runtime.p.a
        p.a a(com.google.android.datatransport.b bVar) {
            if (bVar != null) {
                this.f12846e = bVar;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        @Override // com.google.android.datatransport.runtime.p.a
        public p a() {
            String str = "";
            if (this.f12842a == null) {
                str = " transportContext";
            }
            if (this.f12843b == null) {
                str = str + " transportName";
            }
            if (this.f12844c == null) {
                str = str + " event";
            }
            if (this.f12845d == null) {
                str = str + " transformer";
            }
            if (this.f12846e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new d(this.f12842a, this.f12843b, this.f12844c, this.f12845d, this.f12846e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private d(q qVar, String str, com.google.android.datatransport.c<?> cVar, com.google.android.datatransport.d<?, byte[]> dVar, com.google.android.datatransport.b bVar) {
        this.f12837a = qVar;
        this.f12838b = str;
        this.f12839c = cVar;
        this.f12840d = dVar;
        this.f12841e = bVar;
    }
}
