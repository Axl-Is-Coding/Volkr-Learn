package com.ironsource.sdk.controller;

import android.widget.Toast;
import com.ironsource.sdk.data.SSAEnums$DebugMode;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ja, reason: case insensitive filesystem */
/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2402ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebController f15294c;

    RunnableC2402ja(WebController webController, String str, String str2) {
        this.f15294c = webController;
        this.f15292a = str;
        this.f15293b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f15294c.getDebugMode() == SSAEnums$DebugMode.MODE_3.getValue()) {
            Toast.makeText(this.f15294c.getCurrentActivityContext(), this.f15292a + " : " + this.f15293b, 1).show();
        }
    }
}
