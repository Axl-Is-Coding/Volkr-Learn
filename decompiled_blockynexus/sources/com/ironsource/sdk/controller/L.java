package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.b f15170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f15171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15172c;

    L(W w, b.f.d.g.a.b bVar, JSONObject jSONObject) {
        this.f15172c = w;
        this.f15170a = bVar;
        this.f15171b = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15170a.c(this.f15171b.optString("demandSourceName"), this.f15172c.f15235b);
    }
}
