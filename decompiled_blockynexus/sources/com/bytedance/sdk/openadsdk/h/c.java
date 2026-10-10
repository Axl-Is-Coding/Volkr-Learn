package com.bytedance.sdk.openadsdk.h;

/* JADX INFO: compiled from: IncrementalTimeout.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f6864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f6865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f6866c;

    public long a(int i) {
        return i <= 0 ? this.f6864a : Math.min(this.f6864a + (this.f6865b * ((long) i)), this.f6866c);
    }
}
