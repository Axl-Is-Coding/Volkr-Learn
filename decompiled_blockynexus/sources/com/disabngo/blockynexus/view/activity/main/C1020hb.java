package com.disabngo.blockynexus.view.activity.main;

import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.utils.MultiProcessSharedUtils;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.hb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1020hb implements com.sandboxol.messager.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10907a;

    C1020hb(MainActivity mainActivity) {
        this.f10907a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.a
    public void onCall() {
        if (AdsManager.isVideoLoaded()) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
            MultiProcessSharedUtils.putBoolean(this.f10907a, "is.show.ads", true);
            MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_SHOW_ADS);
        }
    }
}
