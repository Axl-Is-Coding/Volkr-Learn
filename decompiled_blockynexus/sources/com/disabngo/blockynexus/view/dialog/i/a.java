package com.disabngo.blockynexus.view.dialog.i;

import android.content.Context;
import com.disabngo.blockynexus.R;
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

/* JADX INFO: compiled from: SignInModel.java */
/* JADX INFO: loaded from: classes2.dex */
class a extends OnResponseListener<RechargeEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f11598b;

    a(b bVar, Context context) {
        this.f11598b = bVar;
        this.f11597a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 7) {
            LoginManager.switchAccount(this.f11597a);
            return;
        }
        if (i == 6002) {
            AppToastUtils.showLongNegativeTipToast(this.f11597a, R.string.diamond_ads_over_times);
        } else if (i == 6003) {
            AppToastUtils.showLongNegativeTipToast(this.f11597a, R.string.sign_in_no_power);
        } else {
            AppToastUtils.showLongNegativeTipToast(this.f11597a, R.string.email_attachment_received_failed);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ReportDataAdapter.onEvent(this.f11597a, EventConstant.MAIN_ADS_REWARD_FAIL);
        AppToastUtils.showLongNegativeTipToast(this.f11597a, R.string.email_attachment_received_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(RechargeEntity rechargeEntity) {
        new CampaignGetIntegralRewardDialog(this.f11597a).setIntData(rechargeEntity.getCurrency() == 1 ? R.mipmap.ic_diamond : R.mipmap.ic_gold, String.valueOf(rechargeEntity.getRewardQuantity())).show();
        AccountCenter.newInstance().diamonds.set(Long.valueOf(rechargeEntity.getDiamonds()));
        AccountCenter.newInstance().golds.set(Long.valueOf(rechargeEntity.getGolds()));
        AccountCenter.putAccountInfo();
        ReportDataAdapter.onEvent(this.f11597a, AdsEventConstant.REWARD_AD_GIVE, String.valueOf(AdsManager.getAdsInfo().getGameIntType()));
    }
}
