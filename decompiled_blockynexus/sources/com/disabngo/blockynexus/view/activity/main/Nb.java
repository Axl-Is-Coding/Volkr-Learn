package com.disabngo.blockynexus.view.activity.main;

import android.content.Intent;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Nb extends OnResponseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc f10812a;

    Nb(bc bcVar) {
        this.f10812a = bcVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (bool.booleanValue()) {
            MessagerClient.getIns().sendMsg0(GameBroadcastType.GAME_SHOW_EMAIL_RED_POINT);
            new Intent(GameBroadcastType.GAME_SHOW_EMAIL_RED_POINT);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
