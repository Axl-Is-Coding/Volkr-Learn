package com.ironsource.mediationsdk;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ISDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2376w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C f15064b;

    RunnableC2376w(C c2, String str) {
        this.f15064b = c2;
        this.f15063a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15064b.f14632b.a(this.f15063a);
        this.f15064b.e("onInterstitialAdReady() instanceId=" + this.f15063a);
    }
}
