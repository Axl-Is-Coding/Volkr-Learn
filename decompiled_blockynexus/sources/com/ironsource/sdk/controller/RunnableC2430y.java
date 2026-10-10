package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.y, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2430y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f15365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.d f15366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ A f15367c;

    RunnableC2430y(A a2, JSONObject jSONObject, b.f.d.g.a.d dVar) {
        this.f15367c = a2;
        this.f15365a = jSONObject;
        this.f15366b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15367c.f15110c.showRewardedVideo(this.f15365a, this.f15366b);
    }
}
