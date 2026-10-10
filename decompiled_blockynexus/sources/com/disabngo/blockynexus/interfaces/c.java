package com.disabngo.blockynexus.interfaces;

import io.rong.imlib.RongIMClient;

/* JADX INFO: compiled from: IMyRongCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {
    void onError(RongIMClient.ErrorCode errorCode);

    void onSuccess();
}
