package com.twitter.sdk.android.core;

/* JADX INFO: compiled from: AuthToken.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.a.c("created_at")
    protected final long f20118a;

    public b() {
        this(System.currentTimeMillis());
    }

    protected b(long j) {
        this.f20118a = j;
    }
}
