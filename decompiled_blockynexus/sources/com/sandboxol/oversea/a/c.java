package com.sandboxol.oversea.a;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.router.moduleInfo.pay.RechargeBroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.messager.MessagerClient;
import com.sandboxol.oversea.R;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class c extends OnResponseListener<RechargeEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Purchase f18821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18822b;

    c(Purchase purchase, Context context) {
        this.f18821a = purchase;
        this.f18822b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5001) {
            AppToastUtils.showShortNegativeTipToast(this.f18822b, R.string.recharge_invalid_order);
        } else if (i == 5002) {
            AppToastUtils.showShortNegativeTipToast(this.f18822b, R.string.good_invalid_good_id);
        } else if (i == 5003) {
            BillingManager.getInstance().consumeAsync(this.f18821a, true);
        }
        if (this.f18821a.getSku().contains("game")) {
            MessagerClient.getIns().sendMsg0(RechargeBroadcastType.BROADCAST_GAME_BED_WAR_RECHARGE_FAILED);
        } else if (this.f18821a.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) || this.f18821a.getSku().contains("cube")) {
            MessagerClient.getIns().sendMsg0(RechargeBroadcastType.BROADCAST_GAME_RECHARGE_FAILED);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (this.f18821a.getSku().contains("game")) {
            MessagerClient.getIns().sendMsg0(RechargeBroadcastType.BROADCAST_GAME_BED_WAR_RECHARGE_FAILED);
        } else if (this.f18821a.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) || this.f18821a.getSku().contains("cube")) {
            MessagerClient.getIns().sendMsg0(RechargeBroadcastType.BROADCAST_GAME_RECHARGE_FAILED);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(RechargeEntity rechargeEntity) {
        BillingManager.getInstance().consumeAsync(this.f18821a, true);
        if (rechargeEntity != null) {
            AccountCenter.newInstance().golds.set(Long.valueOf(rechargeEntity.getGolds()));
            AccountCenter.newInstance().diamonds.set(Long.valueOf(rechargeEntity.getDiamonds()));
            AccountCenter.newInstance().gDiamonds.set(Long.valueOf(rechargeEntity.getgDiamonds()));
            AccountCenter.putAccountInfo();
        }
        if (this.f18821a.getSku().contains("game")) {
            MessagerClient.getIns().sendMsg0(RechargeBroadcastType.BROADCAST_GAME_BED_WAR_RECHARGE_SUCCESS);
        } else if (this.f18821a.getSku().contains(StringConstant.MONEY_TYPE_DIAMOND) || this.f18821a.getSku().contains("cube")) {
            MessagerClient.getIns().sendMsg0(RechargeBroadcastType.BROADCAST_GAME_RECHARGE_SUCCESS);
            MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_RRESH_MONEY);
            FirebaseUtils.onEvent(this.f18822b, EventConstant.PURCHASE_APP);
        }
        AppToastUtils.showLongPositiveTipToast(this.f18822b, R.string.base_recharge_success);
    }
}
