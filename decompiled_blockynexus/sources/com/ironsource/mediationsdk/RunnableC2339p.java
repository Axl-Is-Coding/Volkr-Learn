package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CallbackThrottler.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2339p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.mediationsdk.logger.b f14959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CallbackThrottler f14960c;

    RunnableC2339p(CallbackThrottler callbackThrottler, String str, com.ironsource.mediationsdk.logger.b bVar) {
        this.f14960c = callbackThrottler;
        this.f14958a = str;
        this.f14959b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14960c.invokeCallback(this.f14958a, this.f14959b);
        this.f14960c.f14637c.put(this.f14958a, false);
    }
}
