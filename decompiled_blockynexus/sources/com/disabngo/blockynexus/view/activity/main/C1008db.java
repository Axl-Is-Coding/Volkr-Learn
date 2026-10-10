package com.disabngo.blockynexus.view.activity.main;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.db, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class C1008db implements com.sandboxol.messager.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MainActivity f10891a;

    C1008db(MainActivity mainActivity) {
        this.f10891a = mainActivity;
    }

    @Override // com.sandboxol.messager.a.b
    public void onCall(com.sandboxol.messager.a.f fVar) {
        fVar.c("game.id");
        int iA = fVar.a("game.ads.type", 0);
        String strC = fVar.c("game.ads.params");
        if (AdsManager.isVideoLoaded()) {
            AdsManager.showRewardVideoByPlacement(this.f10891a, iA, strC, "");
            return;
        }
        com.sandboxol.messager.a.f fVar2 = new com.sandboxol.messager.a.f();
        fVar2.b("game.ads.type", iA);
        fVar2.b("game.ads.result", 2);
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_ENGINE2_ADS_RESULT, fVar2);
        AppToastUtils.showShortPositiveTipToast(this.f10891a, R.string.no_ads);
    }
}
