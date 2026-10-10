package com.sandboxol.oversea.a;

import android.content.Context;
import com.android.billingclient.api.Purchase;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: GoogleInventoryUtil.java */
/* JADX INFO: loaded from: classes4.dex */
class b extends OnResponseListener<BuyVipEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Purchase f18819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18820b;

    b(Purchase purchase, Context context) {
        this.f18819a = purchase;
        this.f18820b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(BuyVipEntity buyVipEntity) {
        BillingManager.getInstance().consumeAsync(this.f18819a, false);
        if (buyVipEntity != null) {
            AccountCenter.newInstance().vip.set(Integer.valueOf(buyVipEntity.getVip()));
            AccountCenter.newInstance().expireDate.set(buyVipEntity.getExpireDate());
            AccountCenter.putAccountInfo();
        }
        BillingManager.getInstance().updateUserMoney(this.f18820b);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_BUY_VIP_SUCCESS);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_DECORATION_TYPE);
        ReportDataAdapter.onEvent(this.f18820b, EventConstant.TOPUP_VIP_CONSUME_SUC, this.f18819a.getSku());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 5003) {
            BillingManager.getInstance().consumeAsync(this.f18819a, false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
