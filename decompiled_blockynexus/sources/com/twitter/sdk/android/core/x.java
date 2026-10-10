package com.twitter.sdk.android.core;

/* JADX INFO: compiled from: TwitterRateLimit.java */
/* JADX INFO: loaded from: classes5.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f20287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f20289c;

    x(okhttp3.u uVar) {
        if (uVar == null) {
            throw new IllegalArgumentException("headers must not be null");
        }
        for (int i = 0; i < uVar.b(); i++) {
            if ("x-rate-limit-limit".equals(uVar.a(i))) {
                this.f20287a = Integer.valueOf(uVar.b(i)).intValue();
            } else if ("x-rate-limit-remaining".equals(uVar.a(i))) {
                this.f20288b = Integer.valueOf(uVar.b(i)).intValue();
            } else if ("x-rate-limit-reset".equals(uVar.a(i))) {
                this.f20289c = Long.valueOf(uVar.b(i)).longValue();
            }
        }
    }
}
