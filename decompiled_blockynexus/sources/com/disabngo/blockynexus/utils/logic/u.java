package com.disabngo.blockynexus.utils.logic;

import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class u extends RongIMClient.OperationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.disabngo.blockynexus.interfaces.c f10557a;

    u(com.disabngo.blockynexus.interfaces.c cVar) {
        this.f10557a = cVar;
    }

    @Override // io.rong.imlib.RongIMClient.Callback
    public void onError(RongIMClient.ErrorCode errorCode) {
        this.f10557a.onError(errorCode);
    }

    @Override // io.rong.imlib.RongIMClient.Callback
    public void onSuccess() {
        this.f10557a.onSuccess();
    }
}
