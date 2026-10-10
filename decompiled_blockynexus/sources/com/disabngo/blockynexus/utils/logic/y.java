package com.disabngo.blockynexus.utils.logic;

import android.util.Log;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.SharedUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class y extends RongIMClient.ResultCallback<Conversation.ConversationNotificationStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f10560a;

    y(String str) {
        this.f10560a = str;
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onError(RongIMClient.ErrorCode errorCode) {
        Log.e("TAG", "onError: " + errorCode);
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onSuccess(Conversation.ConversationNotificationStatus conversationNotificationStatus) {
        SharedUtils.putBoolean(BaseApplication.getContext(), this.f10560a, false);
    }
}
