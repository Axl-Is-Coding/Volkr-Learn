package com.sandboxol.oversea.a;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.IntentUtils;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.oversea.R;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class d extends OnResponseListener<BuyVipEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Purchase f18823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18824b;

    d(Purchase purchase, Context context) {
        this.f18823a = purchase;
        this.f18824b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyVipEntity buyVipEntity) {
        BillingManager.getInstance().consumeAsync(this.f18823a, true);
        if (buyVipEntity != null) {
            AccountCenter.newInstance().vip.set(Integer.valueOf(buyVipEntity.getVip()));
            AccountCenter.newInstance().expireDate.set(buyVipEntity.getExpireDate());
            AccountCenter.putAccountInfo();
            IntentUtils.startVipGcubeGiftOneButtonDialog(this.f18824b, buyVipEntity.getgDiamonds());
        }
        BillingManager.getInstance().updateUserMoney(this.f18824b);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_BUY_VIP_SUCCESS);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5001) {
            AppToastUtils.showShortNegativeTipToast(this.f18824b, R.string.recharge_invalid_order);
        } else if (i == 5002) {
            AppToastUtils.showShortNegativeTipToast(this.f18824b, R.string.good_invalid_good_id);
        } else if (i == 5003) {
            BillingManager.getInstance().consumeAsync(this.f18823a, true);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
