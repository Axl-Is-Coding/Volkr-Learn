package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ISDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2382z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C f15078b;

    RunnableC2382z(C c2, String str) {
        this.f15078b = c2;
        this.f15077a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15078b.f14632b.c(this.f15077a);
        this.f15078b.e("onInterstitialAdClosed() instanceId=" + this.f15077a);
    }
}
