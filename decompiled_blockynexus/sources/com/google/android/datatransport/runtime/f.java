package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.q;
import java.util.Arrays;

/* JADX INFO: compiled from: AutoValue_TransportContext.java */
/* JADX INFO: loaded from: classes.dex */
final class f extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f12939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Priority f12940c;

    @Override // com.google.android.datatransport.runtime.q
    public String b() {
        return this.f12938a;
    }

    @Override // com.google.android.datatransport.runtime.q
    public byte[] c() {
        return this.f12939b;
    }

    @Override // com.google.android.datatransport.runtime.q
    public Priority d() {
        return this.f12940c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (this.f12938a.equals(qVar.b())) {
            if (Arrays.equals(this.f12939b, qVar instanceof f ? ((f) qVar).f12939b : qVar.c()) && this.f12940c.equals(qVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f12938a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12939b)) * 1000003) ^ this.f12940c.hashCode();
    }

    /* JADX INFO: compiled from: AutoValue_TransportContext.java */
    static final class a extends q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f12941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f12942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Priority f12943c;

        a() {
        }

        @Override // com.google.android.datatransport.runtime.q.a
        public q.a a(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f12941a = str;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.q.a
        public q.a a(byte[] bArr) {
            this.f12942b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.q.a
        public q.a a(Priority priority) {
            if (priority != null) {
                this.f12943c = priority;
                return this;
            }
            throw new NullPointerException("Null priority");
        }

        @Override // com.google.android.datatransport.runtime.q.a
        public q a() {
            String str = "";
            if (this.f12941a == null) {
                str = " backendName";
            }
            if (this.f12943c == null) {
                str = str + " priority";
            }
            if (str.isEmpty()) {
                return new f(this.f12941a, this.f12942b, this.f12943c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private f(String str, byte[] bArr, Priority priority) {
        this.f12938a = str;
        this.f12939b = bArr;
        this.f12940c = priority;
    }
}
