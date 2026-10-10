package com.ironsource.sdk.controller;

import org.json.JSONObject;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class S implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.d f15212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ JSONObject f15213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15214c;

    S(W w, b.f.d.g.a.d dVar, JSONObject jSONObject) {
        this.f15214c = w;
        this.f15212a = dVar;
        this.f15213b = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15212a.d(this.f15213b.optString("demandSourceName"), this.f15214c.f15235b);
    }
}
