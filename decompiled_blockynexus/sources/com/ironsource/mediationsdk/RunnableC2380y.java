package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ISDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2380y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C f15074b;

    RunnableC2380y(C c2, String str) {
        this.f15074b = c2;
        this.f15073a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15074b.f14632b.b(this.f15073a);
        this.f15074b.e("onInterstitialAdOpened() instanceId=" + this.f15073a);
    }
}
