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
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;
import com.sandboxol.oversea.R;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class e extends OnResponseListener<BuyVipEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Purchase f18825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f18826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f18827c;

    e(Purchase purchase, boolean z, Context context) {
        this.f18825a = purchase;
        this.f18826b = z;
        this.f18827c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyVipEntity buyVipEntity) {
        BillingManager.getInstance().acknowledgePurchase(this.f18825a, this.f18826b);
        if (buyVipEntity != null) {
            AccountCenter.newInstance().vip.set(Integer.valueOf(buyVipEntity.getVip()));
            AccountCenter.newInstance().expireDate.set(buyVipEntity.getExpireDate());
            AccountCenter.putAccountInfo();
            if (this.f18826b) {
                IntentUtils.startVipGcubeGiftOneButtonDialog(this.f18827c, buyVipEntity.getgDiamonds());
            }
        }
        BillingManager.getInstance().updateUserMoney(this.f18827c);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_BUY_VIP_SUBS_SUCCESS);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
        Messenger.getDefault().send(RefreshMsg.create(), MessageToken.TOKEN_REFRESH_PRODUCT_LIST);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5001) {
            if (this.f18826b) {
                AppToastUtils.showShortNegativeTipToast(this.f18827c, R.string.recharge_invalid_order);
            }
        } else if (i == 5002) {
            if (this.f18826b) {
                AppToastUtils.showShortNegativeTipToast(this.f18827c, R.string.good_invalid_good_id);
            }
        } else if (i == 5003) {
            BillingManager.getInstance().acknowledgePurchase(this.f18825a, this.f18826b);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18827c, i);
    }
}
