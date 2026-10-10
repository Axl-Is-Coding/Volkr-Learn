package com.ironsource.sdk.controller;

import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: NativeController.java */
/* JADX INFO: loaded from: classes2.dex */
class Q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.d f15200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.ironsource.sdk.data.d f15201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ W f15202c;

    Q(W w, b.f.d.g.a.d dVar, com.ironsource.sdk.data.d dVar2) {
        this.f15202c = w;
        this.f15200a = dVar;
        this.f15201b = dVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15200a.a(SSAEnums$ProductType.RewardedVideo, this.f15201b.d(), this.f15202c.f15235b);
    }
}
