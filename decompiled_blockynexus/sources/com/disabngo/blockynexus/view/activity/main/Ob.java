package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.entity.FriendRequests;
import com.disabngo.blockynexus.web.error.FriendOnError;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Ob extends OnResponseListener<PageData<FriendRequests>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10816b;

    Ob(bc bcVar, Context context) {
        this.f10816b = bcVar;
        this.f10815a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        FriendOnError.showErrorTip(this.f10815a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10815a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<FriendRequests> pageData) {
        if (pageData.getData().size() > 0) {
            MessagerClient.getIns().sendMsg0(GameBroadcastType.GAME_SHOW_FRIEND_RED_POINT);
        }
    }
}
