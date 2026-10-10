package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Ba implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ca f14614b;

    Ba(Ca ca, String str) {
        this.f14614b = ca;
        this.f14613a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14614b.f14634b.c(this.f14613a);
        this.f14614b.f("onRewardedVideoAdRewarded() instanceId=" + this.f14613a);
    }
}
