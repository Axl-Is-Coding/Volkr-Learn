package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.controller.WebController.c.a;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Na implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebController.c f15185b;

    Na(WebController.c cVar, String str) {
        this.f15185b = cVar;
        this.f15184a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "omidAPI(" + this.f15184a + ")");
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(this.f15184a);
            Y y = WebController.this.mOmidJsAdapter;
            String string = fVar.toString();
            WebController.c.a aVar = this.f15185b.new a();
            WebController webController = WebController.this;
            WebController.access$5200(webController);
            y.a(string, aVar, webController);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.ironsource.sdk.utils.f.c(WebController.this.TAG, "omidAPI failed with exception " + e2.getMessage());
        }
    }
}
