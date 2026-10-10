package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* JADX INFO: compiled from: AutoValue_BackendResponse.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends BackendResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BackendResponse.Status f12818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12819b;

    c(BackendResponse.Status status, long j) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.f12818a = status;
        this.f12819b = j;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f12819b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f12818a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f12818a.equals(backendResponse.c()) && this.f12819b == backendResponse.b();
    }

    public int hashCode() {
        int iHashCode = (this.f12818a.hashCode() ^ 1000003) * 1000003;
        long j = this.f12819b;
        return iHashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f12818a + ", nextRequestWaitMillis=" + this.f12819b + "}";
    }
}
