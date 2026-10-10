package com.sandboxol.oversea.a;

import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: ShareUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class i implements FacebookCallback<Sharer.Result> {
    i() {
    }

    @Override // com.facebook.FacebookCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Sharer.Result result) {
        Log.e("facebookCallback", "success");
        ReportDataAdapter.onEvent(BaseApplication.getContext(), EventConstant.SHARE_SUC);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        Messenger.getDefault().sendNoMsg(MessageToken.WEB_SHARE_SUCCESS);
    }

    @Override // com.facebook.FacebookCallback
    public void onCancel() {
        Log.e("facebookCallback", "onCancel");
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.facebook.FacebookCallback
    public void onError(FacebookException facebookException) {
        Log.e("facebookCallback", "error");
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }
}
