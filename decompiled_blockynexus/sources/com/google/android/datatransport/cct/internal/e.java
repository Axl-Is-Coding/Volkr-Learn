package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* JADX INFO: compiled from: AutoValue_BatchedLogRequest.java */
/* JADX INFO: loaded from: classes.dex */
final class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<q> f12763a;

    e(List<q> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f12763a = list;
    }

    @Override // com.google.android.datatransport.cct.internal.o
    @Encodable.Field(name = "logRequest")
    public List<q> b() {
        return this.f12763a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            return this.f12763a.equals(((o) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f12763a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f12763a + "}";
    }
}
