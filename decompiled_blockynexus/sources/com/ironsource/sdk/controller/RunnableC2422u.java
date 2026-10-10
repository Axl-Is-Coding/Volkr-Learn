package com.ironsource.sdk.controller;

import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2422u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Map f15340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.e f15341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ A f15342e;

    RunnableC2422u(A a2, String str, String str2, Map map, b.f.d.g.e eVar) {
        this.f15342e = a2;
        this.f15338a = str;
        this.f15339b = str2;
        this.f15340c = map;
        this.f15341d = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15342e.f15110c.initOfferWall(this.f15338a, this.f15339b, this.f15340c, this.f15341d);
    }
}
