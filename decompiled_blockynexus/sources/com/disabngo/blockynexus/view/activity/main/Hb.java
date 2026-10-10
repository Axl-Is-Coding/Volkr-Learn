package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.adsoversea.config.AdsEventConstant;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.web.error.GameOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Hb extends OnResponseListener<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10782b;

    Hb(bc bcVar, Context context) {
        this.f10782b = bcVar;
        this.f10781a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GameOnError.showErrorTip(this.f10781a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10781a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Long l) {
        DialogUtils.newsInstant().showAdsGameRewardDialog(this.f10781a, l.longValue());
        com.sandboxol.messager.a.f fVar = new com.sandboxol.messager.a.f();
        fVar.b("game.ads.type", AdsManager.getAdsInfo().getGameIntType());
        fVar.b("game.ads.params", AdsManager.getAdsInfo().getGameParams());
        fVar.b(GameConstant.GAME_ADS_IS_SUCCESS, true);
        fVar.b("game.ads.id", "ResultPanelWatchAd");
        MessagerClient.getIns().sendMsg1(GameBroadcastType.BROADCAST_SHOW_ENGINE1_ADS_RESULT, fVar);
        ReportDataAdapter.onEvent(this.f10781a, AdsEventConstant.REWARD_AD_GIVE, String.valueOf(AdsManager.getAdsInfo().getGameIntType()));
    }
}
