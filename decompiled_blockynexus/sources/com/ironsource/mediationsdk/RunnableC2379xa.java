package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.xa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2379xa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ca f15072b;

    RunnableC2379xa(Ca ca, String str) {
        this.f15072b = ca;
        this.f15071a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15072b.f14634b.a(this.f15071a);
        this.f15072b.f("onRewardedVideoAdOpened() instanceId=" + this.f15071a);
    }
}
