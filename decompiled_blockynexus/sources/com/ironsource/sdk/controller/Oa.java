package com.ironsource.sdk.controller;

import android.os.Build;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Oa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebController.c f15187a;

    Oa(WebController.c cVar) {
        this.f15187a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (Build.VERSION.SDK_INT >= 21) {
            WebController.this.getSettings().setMixedContentMode(0);
        }
    }
}
