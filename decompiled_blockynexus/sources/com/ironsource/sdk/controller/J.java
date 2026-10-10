package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class J implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f15161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15162c;

    J(W w, b.f.d.g.a.c cVar, JSONObject jSONObject) {
        this.f15162c = w;
        this.f15160a = cVar;
        this.f15161b = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15160a.a(this.f15161b.optString("demandSourceName"), this.f15162c.f15235b);
    }
}
