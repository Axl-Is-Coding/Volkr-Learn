package com.disabngo.blockynexus.view.activity.friends;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendActivityModel.java */
/* JADX INFO: loaded from: classes2.dex */
class D extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Activity f10634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ F f10635c;

    D(F f2, long j, Activity activity) {
        this.f10635c = f2;
        this.f10633a = j;
        this.f10634b = activity;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showLongNegativeTipToast(this.f10634b, R.string.delete_friend_failed);
        FriendOnError.showErrorTip(this.f10634b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showLongNegativeTipToast(this.f10634b, R.string.delete_friend_failed);
        ServerOnError.showOnServerError(this.f10634b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("friend.type", 3);
        fVar.b("friend.id", this.f10633a);
        fVar.b("friend.alias", "");
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_FOLLOW_FRIENDS_LIST);
        MessagerClient.getIns().sendMsg1(BroadcastType.BROADCAST_REFRESH_FRIEND_LIST, fVar);
        if (!this.f10634b.isFinishing()) {
            this.f10634b.finish();
        }
        ReportDataAdapter.onEvent(this.f10634b, EventConstant.CHAT_DELETE_FRIEND);
    }
}
