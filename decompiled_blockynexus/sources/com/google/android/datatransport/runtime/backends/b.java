package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.g;
import java.util.Arrays;

/* JADX INFO: compiled from: AutoValue_BackendRequest.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Iterable<com.google.android.datatransport.runtime.l> f12814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f12815b;

    @Override // com.google.android.datatransport.runtime.backends.g
    public Iterable<com.google.android.datatransport.runtime.l> b() {
        return this.f12814a;
    }

    @Override // com.google.android.datatransport.runtime.backends.g
    public byte[] c() {
        return this.f12815b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f12814a.equals(gVar.b())) {
            if (Arrays.equals(this.f12815b, gVar instanceof b ? ((b) gVar).f12815b : gVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f12814a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f12815b);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f12814a + ", extras=" + Arrays.toString(this.f12815b) + "}";
    }

    /* JADX INFO: compiled from: AutoValue_BackendRequest.java */
    static final class a extends g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterable<com.google.android.datatransport.runtime.l> f12816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f12817b;

        a() {
        }

        @Override // com.google.android.datatransport.runtime.backends.g.a
        public g.a a(Iterable<com.google.android.datatransport.runtime.l> iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f12816a = iterable;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.g.a
        public g.a a(byte[] bArr) {
            this.f12817b = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.backends.g.a
        public g a() {
            String str = "";
            if (this.f12816a == null) {
                str = " events";
            }
            if (str.isEmpty()) {
                return new b(this.f12816a, this.f12817b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }
    }

    private b(Iterable<com.google.android.datatransport.runtime.l> iterable, byte[] bArr) {
        this.f12814a = iterable;
        this.f12815b = bArr;
    }
}
