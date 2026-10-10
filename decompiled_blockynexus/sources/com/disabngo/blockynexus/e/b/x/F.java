package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.utils.logic.N;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class F extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10281b;

    F(long j, Context context) {
        this.f10280a = j;
        this.f10281b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_FRIEND_ID_BACK, this.f10280a);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_AGREE_ADD_FRIEND_ERROR_BACK, fVar);
        AppToastUtils.showShortPositiveTipToast(this.f10281b, R.string.agree_add_friend_failed);
        FriendOnError.showErrorTip(this.f10281b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_FRIEND_ID_BACK, this.f10280a);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_AGREE_ADD_FRIEND_ERROR_BACK, fVar);
        AppToastUtils.showShortPositiveTipToast(this.f10281b, R.string.agree_add_friend_failed);
        ServerOnError.showOnServerError(this.f10281b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_FRIEND_ID_BACK, this.f10280a);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_AGREE_ADD_FRIEND_BACK, fVar);
        N.a(this.f10281b, this.f10280a);
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.friend.list");
        ReportDataAdapter.onEvent(this.f10281b, EventConstant.CHAT_ACCEPT, "GAME");
    }
}
