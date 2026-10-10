package com.bytedance.sdk.adnet.err;

import com.bytedance.sdk.adnet.core.i;

/* JADX INFO: loaded from: classes.dex */
public class VAdError extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5564a;
    public final i networkResponse;

    public VAdError() {
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.f5564a;
    }

    public void setNetworkTimeMs(long j) {
        this.f5564a = j;
    }

    public VAdError(i iVar) {
        this.networkResponse = iVar;
    }

    public VAdError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VAdError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VAdError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }
}
