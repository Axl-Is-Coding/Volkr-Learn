package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.adsoversea.config.AdsEventConstant;
import com.sandboxol.center.entity.AdsSignReward;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Gb extends OnResponseListener<AdsSignReward> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10778b;

    Gb(bc bcVar, Context context) {
        this.f10778b = bcVar;
        this.f10777a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(AdsSignReward adsSignReward) {
        if (adsSignReward != null) {
            new CampaignGetIntegralRewardDialog(this.f10777a).setStringData(adsSignReward.getPicUrl(), String.valueOf(((long) adsSignReward.getQuantity()) + AdsManager.getAdsInfo().getSignAdsQty())).show();
            BillingManager.getInstance().updateUserMoney(this.f10777a);
            ReportDataAdapter.onEvent(BaseApplication.getContext(), AdsEventConstant.REWARD_AD_GIVE);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f10777a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10777a, i);
    }
}
