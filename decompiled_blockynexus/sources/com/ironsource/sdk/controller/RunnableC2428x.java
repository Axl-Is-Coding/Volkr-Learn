package com.ironsource.sdk.controller;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2428x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.d f15361d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f15362e;

    RunnableC2428x(A a2, String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.d dVar2) {
        this.f15362e = a2;
        this.f15358a = str;
        this.f15359b = str2;
        this.f15360c = dVar;
        this.f15361d = dVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15362e.f15110c.initRewardedVideo(this.f15358a, this.f15359b, this.f15360c, this.f15361d);
    }
}
