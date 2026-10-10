package com.ironsource.sdk.controller;

import com.ironsource.sdk.data.SSAEnums$ProductType;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2403k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f15296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ A f15298d;

    RunnableC2403k(A a2, com.ironsource.sdk.data.d dVar, Map map, b.f.d.g.a.c cVar) {
        this.f15298d = a2;
        this.f15295a = dVar;
        this.f15296b = map;
        this.f15297c = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.f.d.a.a aVar = new b.f.d.a.a();
        aVar.a("demandsourcename", this.f15295a.d());
        aVar.a("producttype", b.f.d.a.f.a(this.f15295a, SSAEnums$ProductType.Interstitial));
        aVar.a("isbiddinginstance", Boolean.valueOf(b.f.d.a.f.a(this.f15295a)));
        b.f.d.a.e.a(b.f.d.a.g.i, aVar.a());
        this.f15298d.f15110c.loadInterstitial(this.f15295a, this.f15296b, this.f15297c);
    }
}
