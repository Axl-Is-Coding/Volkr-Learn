package com.google.android.datatransport.runtime.backends;

/* JADX INFO: loaded from: classes.dex */
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse a() {
        return new c(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse d() {
        return new c(Status.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract Status c();

    public static BackendResponse a(long j) {
        return new c(Status.OK, j);
    }
}
