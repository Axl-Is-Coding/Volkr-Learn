package com.disabngo.blockynexus.view.activity.main;

import com.disabngo.blockynexus.R;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.eb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1011eb implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10895a;

    C1011eb(MainActivity mainActivity) {
        this.f10895a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        fVar.c("game.id");
        int iA = fVar.a("game.ads.type", 0);
        String strC = fVar.c("game.ads.params");
        String strC2 = fVar.c("game.ads.id");
        if (AdsManager.isVideoLoaded()) {
            AdsManager.showRewardVideoByPlacement(this.f10895a, iA, strC, strC2);
            return;
        }
        com.sandboxol.messager.a.f fVar2 = new com.sandboxol.messager.a.f();
        fVar2.b("game.ads.type", iA);
        fVar2.b("game.ads.params", strC);
        fVar2.b(GameConstant.GAME_ADS_IS_SUCCESS, false);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_ENGINE1_ADS_RESULT, fVar2);
        AppToastUtils.showShortPositiveTipToast(this.f10895a, R.string.no_ads);
    }
}
