package com.ironsource.sdk.controller;

import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.v, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2424v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f15345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ A f15346b;

    RunnableC2424v(A a2, Map map) {
        this.f15346b = a2;
        this.f15345a = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15346b.f15110c.showOfferWall(this.f15345a);
    }
}
