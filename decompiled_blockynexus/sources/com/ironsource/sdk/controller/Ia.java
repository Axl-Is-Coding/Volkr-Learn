package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Ia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebController.c f15159a;

    Ia(WebController.c cVar) {
        this.f15159a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        WebController.this.mOnGenericFunctionListener.a();
    }
}
