package com.disabngo.blockynexus.e.b.D;

import com.sandboxol.common.utils.AppToastUtils;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/* JADX INFO: compiled from: GroupInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class F extends RongIMClient.ResultCallback<Conversation> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ I f9165a;

    F(I i) {
        this.f9165a = i;
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onError(RongIMClient.ErrorCode errorCode) {
        AppToastUtils.showShortNegativeTipToast(this.f9165a.f9168a, errorCode.getMessage());
    }

    @Override // io.rong.imlib.RongIMClient.ResultCallback
    public void onSuccess(Conversation conversation) {
        if (conversation != null) {
            this.f9165a.v.set(Boolean.valueOf(conversation.isTop()));
        }
    }
}
