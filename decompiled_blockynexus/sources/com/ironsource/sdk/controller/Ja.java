package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15164b;

    Ja(WebController.c cVar, String str) {
        this.f15164b = cVar;
        this.f15163a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebController.this.mOnGenericFunctionListener.a(this.f15163a);
    }
}
