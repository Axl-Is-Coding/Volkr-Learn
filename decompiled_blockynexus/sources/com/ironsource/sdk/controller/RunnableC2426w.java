package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2426w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.e f15352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ A f15353d;

    RunnableC2426w(A a2, String str, String str2, b.f.d.g.e eVar) {
        this.f15353d = a2;
        this.f15350a = str;
        this.f15351b = str2;
        this.f15352c = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15353d.f15110c.getOfferWallCredits(this.f15350a, this.f15351b, this.f15352c);
    }
}
