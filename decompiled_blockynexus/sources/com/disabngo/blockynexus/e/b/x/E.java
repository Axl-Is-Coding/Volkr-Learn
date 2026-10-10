package com.disabngo.blockynexus.e.b.x;

import android.content.Context;
import android.util.Log;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: FriendModel.java */
/* JADX INFO: loaded from: classes2.dex */
class E extends OnResponseListener<Friend> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10279b;

    E(long j, Context context) {
        this.f10278a = j;
        this.f10279b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.e("EchoesGLSurfaceView", i + str);
        FriendOnError.showErrorTip(this.f10279b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("EchoesGLSurfaceView", String.valueOf(i));
        ServerOnError.showOnServerError(this.f10279b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Friend friend) {
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b(GameConstant.GAME_FRIEND_ID_BACK, this.f10278a);
        fVar.b(GameConstant.GAME_IS_FRIEND_BACK, friend.isFriend());
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_ENTER_GAME_CHECK_BACK, fVar);
    }
}
