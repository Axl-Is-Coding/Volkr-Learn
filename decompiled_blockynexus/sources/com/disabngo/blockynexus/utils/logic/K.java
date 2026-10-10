package com.disabngo.blockynexus.utils.logic;

import android.app.Activity;
import android.content.Context;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class K implements IRongCallback.ISendMessageCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10530a;

    K(Context context) {
        this.f10530a = context;
    }

    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
    public void onAttached(Message message) {
    }

    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
    public void onError(Message message, RongIMClient.ErrorCode errorCode) {
        Context context = this.f10530a;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
    public void onSuccess(Message message) {
        Context context = this.f10530a;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
}
