package com.ironsource.mediationsdk;

/* JADX INFO: compiled from: ISDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
class B implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C f14612b;

    B(C c2, String str) {
        this.f14612b = c2;
        this.f14611a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14612b.f14632b.d(this.f14611a);
        this.f14612b.e("onInterstitialAdClicked() instanceId=" + this.f14611a);
    }
}
