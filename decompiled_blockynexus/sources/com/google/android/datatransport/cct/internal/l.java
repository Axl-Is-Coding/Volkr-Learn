package com.google.android.datatransport.cct.internal;

/* JADX INFO: compiled from: AutoValue_LogResponse.java */
/* JADX INFO: loaded from: classes.dex */
final class l extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12792a;

    l(long j) {
        this.f12792a = j;
    }

    @Override // com.google.android.datatransport.cct.internal.r
    public long a() {
        return this.f12792a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof r) && this.f12792a == ((r) obj).a();
    }

    public int hashCode() {
        long j = this.f12792a;
        return 1000003 ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f12792a + "}";
    }
}
