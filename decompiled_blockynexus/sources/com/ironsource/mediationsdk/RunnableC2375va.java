package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.va, reason: case insensitive filesystem */
/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2375va implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ca f15062b;

    RunnableC2375va(Ca ca, String str) {
        this.f15062b = ca;
        this.f15061a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15062b.f14634b.d(this.f15061a);
        this.f15062b.f("onRewardedVideoAdLoadSuccess() instanceId=" + this.f15061a);
    }
}
