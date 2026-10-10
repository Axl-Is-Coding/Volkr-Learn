package com.ironsource.sdk.controller;

import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.c f15218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15220c;

    T(W w, b.f.d.g.a.c cVar, com.ironsource.sdk.data.d dVar) {
        this.f15220c = w;
        this.f15218a = cVar;
        this.f15219b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15218a.a(SSAEnums$ProductType.Interstitial, this.f15219b.d(), this.f15220c.f15235b);
    }
}
