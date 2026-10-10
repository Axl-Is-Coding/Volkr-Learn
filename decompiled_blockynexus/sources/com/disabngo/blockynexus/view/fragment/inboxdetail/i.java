package com.disabngo.blockynexus.view.fragment.inboxdetail;

import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: InboxDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f11746a;

    i(k kVar) {
        this.f11746a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        this.f11746a.f11752e = game;
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ServerOnError.showOnServerError(this.f11746a.f11748a, i);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11746a.f11748a, i);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }
}
