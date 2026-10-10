package com.disabngo.blockynexus.utils.logic;

import io.rong.imkit.RongContext;
import io.rong.imkit.model.Event;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/* JADX INFO: compiled from: RongIMLogic.java */
/* JADX INFO: loaded from: classes2.dex */
class J extends RongIMClient.ResultCallback<Boolean> {
    J() {
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onError(RongIMClient.ErrorCode errorCode) {
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onSuccess(Boolean bool) {
        RongContext.getInstance().getEventBus().post(new Event.ConversationUnreadEvent(Conversation.ConversationType.PRIVATE, String.valueOf(32L)));
    }
}
