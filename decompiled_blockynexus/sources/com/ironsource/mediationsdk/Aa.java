package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class Aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ca f14595b;

    Aa(Ca ca, String str) {
        this.f14595b = ca;
        this.f14594a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14595b.f14634b.e(this.f14594a);
        this.f14595b.f("onRewardedVideoAdClicked() instanceId=" + this.f14594a);
    }
}
