package com.ironsource.sdk.controller;

import android.os.CountDownTimer;
import com.ironsource.sdk.controller.WebController;

/* JADX INFO: compiled from: WebController.java */
/* JADX INFO: loaded from: classes2.dex */
class Wa extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebController.f f15237a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Wa(WebController.f fVar, long j, long j2) {
        super(j, j2);
        this.f15237a = fVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        com.ironsource.sdk.utils.f.c(WebController.this.TAG, "Close Event Timer Finish");
        if (WebController.this.isRemoveCloseEventHandler) {
            WebController.this.isRemoveCloseEventHandler = false;
        } else {
            WebController.this.engageEnd("forceClose");
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        com.ironsource.sdk.utils.f.c(WebController.this.TAG, "Close Event Timer Tick " + j);
    }
}
