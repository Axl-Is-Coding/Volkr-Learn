package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import com.sandboxol.adsoversea.config.AdsEventConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.manager.AdsManager;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.view.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: RechargeModel.java */
/* JADX INFO: loaded from: classes3.dex */
class r extends OnResponseListener<RechargeEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f18384b;

    r(t tVar, Context context) {
        this.f18384b = tVar;
        this.f18383a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 7) {
            LoginManager.forceReLogin(this.f18383a);
            return;
        }
        if (i == 6002) {
            AppToastUtils.showLongNegativeTipToast(this.f18383a, R.string.googleplay_diamond_ads_over_times);
        } else if (i == 6003) {
            AppToastUtils.showLongNegativeTipToast(this.f18383a, R.string.sign_in_no_power);
        } else {
            AppToastUtils.showLongNegativeTipToast(this.f18383a, R.string.googleplay_email_attachment_received_failed);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ReportDataAdapter.onEvent(this.f18383a, EventConstant.MAIN_ADS_REWARD_FAIL);
        AppToastUtils.showLongNegativeTipToast(this.f18383a, R.string.googleplay_email_attachment_received_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(RechargeEntity rechargeEntity) {
        new CampaignGetIntegralRewardDialog(this.f18383a).setIntData(rechargeEntity.getCurrency() == 1 ? R.mipmap.ic_diamond : R.mipmap.ic_gold, String.valueOf(rechargeEntity.getRewardQuantity())).show();
        AccountCenter.newInstance().diamonds.set(Long.valueOf(rechargeEntity.getDiamonds()));
        AccountCenter.newInstance().golds.set(Long.valueOf(rechargeEntity.getGolds()));
        AccountCenter.putAccountInfo();
        ReportDataAdapter.onEvent(this.f18383a, AdsEventConstant.REWARD_AD_GIVE, String.valueOf(AdsManager.getAdsInfo().getGameIntType()));
    }
}
