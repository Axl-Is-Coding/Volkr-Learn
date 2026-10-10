package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.wa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2427wa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.f.d.g.a.a f15354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SSAEnums$ProductType f15355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f15356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ WebController.c f15357d;

    RunnableC2427wa(WebController.c cVar, b.f.d.g.a.a aVar, SSAEnums$ProductType sSAEnums$ProductType, String str) {
        this.f15357d = cVar;
        this.f15354a = aVar;
        this.f15355b = sSAEnums$ProductType;
        this.f15356c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15354a.c(this.f15355b, this.f15356c);
    }
}
