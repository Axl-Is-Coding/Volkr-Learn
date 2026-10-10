package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.da, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MediationInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2316da implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediationInitializer f14807a;

    RunnableC2316da(MediationInitializer mediationInitializer) {
        this.f14807a = mediationInitializer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14807a.p = new CountDownTimerC2314ca(this, 60000L, 15000L).start();
    }
}
