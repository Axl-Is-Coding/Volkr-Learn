package com.ironsource.sdk.ISNAdView;

/* JADX INFO: compiled from: ISNAdViewLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15095a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ h f15096b;

    g(h hVar, String str) {
        this.f15096b = hVar;
        this.f15095a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15096b.g(this.f15095a);
    }
}
