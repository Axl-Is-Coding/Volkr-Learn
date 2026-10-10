package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class G extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10283b;

    G(long j, Context context) {
        this.f10282a = j;
        this.f10283b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_FRIEND_ID_BACK, this.f10282a);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_REQUEST_ADD_FRIEND_ERROR_BACK, fVar);
        FriendOnError.showErrorTip(this.f10283b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10283b, i);
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_FRIEND_ID_BACK, this.f10282a);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_REQUEST_ADD_FRIEND_ERROR_BACK, fVar);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_FRIEND_ID_BACK, this.f10282a);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_REQUEST_ADD_FRIEND_BACK, fVar);
        ReportDataAdapter.onEvent(this.f10283b, EventConstant.CHAT_ADD_FRIEND, "GAME");
    }
}
